package frc.robot.statemachine;

public interface State extends Runnable {
	public void enter();
	public void exit();

	public boolean getIsFinished();
}