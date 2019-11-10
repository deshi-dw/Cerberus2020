package frc.cerberus5725.statemachine;

public enum TestState2 implements State {
	DISABLED {
		@Override
		public void run() {}

		@Override
		public void enter() {}

		@Override
		public void exit() {}

		@Override
		public boolean getIsFinished() {
			return false;
		}
	},
	TESTING, AUTONOMOUS, TELEOP;

	@Override
	public void run() {}

	@Override
	public void enter() {}

	@Override
	public void exit() {}

	@Override
	public boolean getIsFinished() { return false; }

}