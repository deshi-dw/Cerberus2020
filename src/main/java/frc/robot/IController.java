package frc.robot;

import frc.robot.settings.Settings;

public interface IController {

	public void activate(Settings settings);
	public void deactivate();

	public void update();
}