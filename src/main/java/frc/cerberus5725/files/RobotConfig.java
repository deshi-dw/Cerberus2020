package frc.cerberus5725.files;

import frc.cerberus5725.util.ByteWriter;

public class RobotConfig {
	public String fileType;
	public byte fileVersion;

	public boolean driveTrain_isEnabled;
	public float driveTrain_driveSpeed;
	public float driveTrain_turnSpeed;

	public String getPath() {
		return "robotConfig.rcfg";
	}

	public void save() {
		ByteWriter writer = new ByteWriter();

		// Write header data
		writer.writeString(fileType);
		writer.writeByte(fileVersion);

		// Write drive train data
		writer.writeByte(driveTrain_isEnabled ? (byte)1 : (byte)0);
		writer.writeSingle(driveTrain_driveSpeed);
		writer.writeSingle(driveTrain_turnSpeed);
	}
	public void load() {
		// TODO: Implement...
	}
}