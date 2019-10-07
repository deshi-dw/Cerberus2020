package frc.robot;

import ComponentInfo;

public interface IComponent {
	public boolean enabled = false;

	public ComponentInfo getInfo();
} 