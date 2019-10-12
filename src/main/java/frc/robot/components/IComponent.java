package frc.robot.components;

import frc.robot.components.ComponentInfo;

public interface IComponent {
	public boolean enabled = false;

	public ComponentInfo getInfo();
} 