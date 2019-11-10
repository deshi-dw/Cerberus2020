package frc.cerberus5725.robot2020;

import frc.cerberus5725.statemachine.State;

public class TestState implements State {
	private int counterIndex;

	public TestState(int counterStart) {
		counterIndex = counterStart;
	}

	@Override
	public void run() {
		System.out.print(counterIndex);
		counterIndex--;
	}

	@Override
	public void enter() { }

	@Override
	public void exit() {
		System.out.println();
	}

	@Override
	public boolean getIsFinished() {
		return counterIndex < 0;
	}
}