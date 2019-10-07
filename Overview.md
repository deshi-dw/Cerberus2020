# FRC 2020 Programming Document

This document has been made to help organize the programming team on goals and tasks that need to be completed.

[TOC]

## Robot Code Architecture

The underlying code design principals and rules that need to be followed when adding code to the robot.

### Components

Components are the main parts of the code architecture. They represents important parts of the robot like a drive train or arm.

**Components should be designed with methods only.** The use of a component should come from [Controllers](#Controller).
Components can (for the most part) contain any number of moving parts. That said, they should stick to a specific function like moving the robot or picking up game pieces. A component should never exceed what it is designed to do.

#### Component Structure

A component is comprised from a few methods. 

```java
IComponent
|- boolean Enabled;
|- ComponentInfo GetInfo();
```

`Enabled` - This can be toggled to turn this component on or off. All components should be design to include enabling and disabling functionality.

`GetInfo` - Gets any useful values from the component. This can then be used to be printed out or logged.

#### Defining a Component

Defining a new Component is done like any other interface: the `implements` keyword.

```java
public class DriveTrain implements IComponent {
    public boolean Enabled { get; set; }
    
    ComponentInfo GetInfo() {
        return null;
    }
}
```

Note that when implementing an interface, all methods from that interface **must be implemented** even if a method isn't actually used.

#### Using a Component

The only way a component should be used is through a [Controller](#Controllers). To accomplish this, components use methods.

```java
public class Arm implements IComponent {
    // Component implementation Code
    ...
    
    public void SetAngle(double angle) {
        // Set Angle Code
        ...
    }
    
    public boolean IsArmMovementFixed {
        get { ... };
        set { ... };
    }
    
    // etc.
}
```

The arm implements basic methods like `SetAngle` but also checks that can be used by the [Controller](#Controllers) like `IsArmMovementFixed`. The more information the component can give to controllers, the smarter the controllers can be.

### Controllers

Controllers are used to control one or more [Components](#Components).

#### Controller Structure

```java
IController
| void Activate(SettingsManager settings);
| void Deactivate();
| void Update();
```

`Update` - Called once each periodic update and should be used for updating each component the controller uses.

`Activate` - Called when the robot is first active. A `SettingsManager` is used to supplied the controller with external settings. This method should be used to initialize all values in the controller.

`Deactivate` - Called when the robot deactivates. This method should be used to stop any tasks that are running and run any deactivation procedures for that controller.

#### Defining a Controller

```java
public class ArmController extends IController {
    public ArmController() { ... }
    
    public void Activate(SettingsManager settings) { ... }
    public void Deactivate() { ... }
    public void Update() { ... }
}
```

The controllers constructor method can be used to add components from the arguments. This is demonstrated in the "Using a Controller" section.

#### Using a Controller

```java
public class ArmController extends IController {
    private Arm arm;
    private Xbox xbox;
    
    private double rotateSpeed = 1.0;
    
    public ArmController(Arm arm, Xbox xbox) {
        this.arm = arm;
        this.controller = controller;
    }
    
    public void Activate(SettingsManager settings) {
        rotateSpeed = SettingsManager.GetDouble("ArmRotSpd");
    }
    public void Deactivate() {
        arm.Stop();
    }
    
    public void Update() {
        arm.Rotate(xbox.Get(Xbox.Axis.RightX) * rotateSpeed);
    }
}
```

The `ArmController` doesn't need to have any extra methods besides the ones implemented by `IController`. **If a method needs to be implemented, it should always be done through components and not controllers.**

### Managers

Managers are used to store and manipulate a group of data. Managers are more arbitrary than [Components](#Components) or [Controllers](#Controllers). As such, they don't have any interface to implement.
