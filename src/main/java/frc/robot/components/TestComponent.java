package frc.robot.components;

import frc.robot.ComponentInfo;
import frc.robot.IComponent;
import frc.robot.util.Pair;

public class TestComponent implements IComponent {
	private int value;

	@Override
	public ComponentInfo getInfo() {
		return new ComponentInfo(new Pair[] { new Pair<String, Integer>("Value", value) });
	}

	public void ChangeValue(int amount) {
		value += amount;
	}

}