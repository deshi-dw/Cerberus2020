package frc.cerberus5725.robot2020.controllers;

import frc.cerberus5725.components.controllers.IController;
import frc.cerberus5725.robot2020.components.TestComponent;
import frc.cerberus5725.settings.Settings;

public class TestController implements IController {
	private int changeValueAmount = 1;

	private int totalChange = 0;

	private TestComponent testComponent;
	
	public TestController(TestComponent testComponent) {
		this.testComponent = testComponent;
	}

	@Override
	public void activate(Settings settings) {
		changeValueAmount = settings.get("TestController_changeValueAmount");
	}

	@Override
	public void deactivate() {
		testComponent.ChangeValue(-totalChange);
	}

	@Override
	public void update() {
		testComponent.ChangeValue(changeValueAmount);
		totalChange += changeValueAmount;
	}

}