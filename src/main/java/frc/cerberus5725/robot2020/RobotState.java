package frc.cerberus5725.robot2020;

import frc.cerberus5725.statemachine.State;

public enum RobotState implements State {
	DISABLED {
		@Override
		public void run() {
		}

		@Override
		public void enter() {
			System.out.println("---Entering Disabled State.");
		}

		@Override
		public void exit() {
			System.out.println("---Exiting Disabled State.");
		}
	},
	TESTING {
		@Override
		public void run() {
		}

		@Override
		public void enter() {
			System.out.println("---Entering Testing State.");
		}

		@Override
		public void exit() {
			System.out.println("---Exiting Testing State.");
		}
	},
	AUTONOMOUS {
		@Override
		public void run() {
		}

		@Override
		public void enter() {
			System.out.println("---Entering Autonomous State.");
		}

		@Override
		public void exit() {
			System.out.println("---Exiting Autonomous State.");
		}
	},
	TELEOP {
		@Override
		public void run() {
		}

		@Override
		public void enter() {
			System.out.println("---Entering Teleop State.");
		}

		@Override
		public void exit() {
			System.out.println("---Exiting Teleop State.");
		}
	};

	@Override
	public void run() {
	}

	@Override
	public void enter() {
	}

	@Override
	public void exit() {
	}

}