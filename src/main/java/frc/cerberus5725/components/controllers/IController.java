package frc.cerberus5725.components.controllers;

import frc.cerberus5725.settings.Settings;

public interface IController {

	public void activate(Settings settings);
	public void deactivate();

	public void update();
}