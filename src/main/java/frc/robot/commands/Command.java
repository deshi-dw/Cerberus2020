package frc.robot.commands;

public interface Command extends Runnable {
	public int getId();
	public int getLength();

	public void deserialize(byte[] data);
	public byte[] serialize();
}