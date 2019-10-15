package frc.robot.commands;

public interface Command extends Runnable {
	public int getId();
	public int getLength();

	public boolean getIsFinished();

	public void deserialize(byte[] data);
	public byte[] serialize();
}