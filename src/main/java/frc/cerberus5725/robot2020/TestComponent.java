package frc.cerberus5725.robot2020;

import frc.cerberus5725.components.ComponentInfo;
import frc.cerberus5725.components.IComponent;
import frc.cerberus5725.util.Pair;

public class TestComponent implements IComponent {
	private int value;

	@Override
	public ComponentInfo getInfo() {
		return new ComponentInfo(new Pair[] { new Pair("Value", value) });
	}

	public void ChangeValue(int amount) {
		value += amount;
	}

}