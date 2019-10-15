/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import java.io.IOException;

import edu.wpi.first.wpilibj.TimedRobot;
import frc.robot.communication.RobotServer;
import frc.robot.statemachine.StateMachine;
import frc.robot.statemachine.TestState;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {

	private RobotServer server;

	/**
	 * This function is run when the robot is first started up and should be used
	 * for any initialization code.
	 */
	@Override
	public void robotInit() {
		System.out.println("Robot has been initialized.");

		// server = new RobotServer("127.0.0.1", 300);
		// server.connect();

		// System.out.println(server.read());
		// server.write("*Some random server data.");

		// StateMachine states = new StateMachine();
		
		// states.getStates().add(new TestState(10));
		// states.getStates().add(new TestState(10));
		// states.getStates().add(new TestState(10));
		// states.getStates().add(new TestState(10));

		// states.printStates();

	}

	@Override
	public void robotPeriodic() {
		System.out.println("Initialized periodic.");
	}

	@Override
	public void autonomousInit() {
		System.out.println("Autonomous code has been initialized.");
	}

	@Override
	public void autonomousPeriodic() {
	}

	@Override
	public void teleopInit() {
		System.out.println("Teleop code has been initialized.");
	}

	@Override
	public void teleopPeriodic() {
	}

	@Override
	public void testInit() {
		System.out.println("Test code has been initialized.");
	}

	@Override
	public void testPeriodic() {
	}

	@Override
	public void disabledInit() {
	}

	@Override
	public void disabledPeriodic() {
	}

}
