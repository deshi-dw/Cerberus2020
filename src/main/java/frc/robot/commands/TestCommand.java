package frc.robot.commands;

public class TestCommand implements Command {
	private int count = 0;
	private boolean isFinished = false;

	public TestCommand(int initialCount) {
		count = initialCount;
	}

	@Override
	public void run() {
		count += 100;
		isFinished = true;
	}

	@Override
	public int getId() {
		return 314159265;
	}

	@Override
	public int getLength() {
		return 4;
	}

	@Override
	public boolean getIsFinished() {
		return isFinished;
	}

	@Override
	public void deserialize(byte[] data) {
		// FIXME: Replace with BitReader when that is made.
		for (int i = 0; i < 4; i++) {
			count <<= 8;
			count |= (data[i] & 0xFF);
		}
	}

	@Override
	public byte[] serialize() {
		// FIXME: Replace with BitReader when that is made.
		int c = count;
		byte[] result = new byte[8];
		
		for (int i = 3; i >= 0; i--) {
			result[i] = (byte) (c & 0xFF);
			c >>= 8;
		}

		return result;
	}
}