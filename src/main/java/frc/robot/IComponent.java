package frc.robot;

import frc.robot.ComponentInfo;

public interface IComponent {
	public boolean enabled = false;

	public ComponentInfo getInfo();
} 