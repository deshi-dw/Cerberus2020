package frc.cerberus5725.commands;

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

	public void periodic() {
		if(getIsConditionMet()) {
			target.run();
		}
	}

	public abstract boolean getIsConditionMet();
}