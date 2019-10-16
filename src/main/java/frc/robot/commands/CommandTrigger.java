package frc.robot.commands;

public abstract class CommandTrigger {
	private Runnable target;

	public CommandTrigger(Runnable target) {
		this.target = target;
	}

	public void setTarget(Runnable target) {
		this.target = target;
	}
	public Runnable getTarget() {
		return target;
	}

	public void Periodic() {
		if(getIsConditionMet()) {
			target.run();
		}
	}

	public abstract boolean getIsConditionMet();
}