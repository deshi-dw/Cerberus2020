package frc.robot.util;

import java.nio.ByteBuffer;

public class ByteReader {
	private byte[] buffer;
	private int position = 0;

	public ByteReader(byte[] buffer) {
		this.buffer = buffer;
	}

	public short ReadByte() {
		byte result = buffer[position];
		position++;
		return result;
	}

	public short ReadInt16() {
		short result = 0;
		for (int i = 0; i < Short.BYTES; i++) {
			result <<= 8;
			result |= (buffer[position + i] & 0xFF);
		}

		position += Short.BYTES;
		return result;
	}

	public int ReadInt32() {
		int result = 0;
		for (int i = 0; i < Integer.BYTES; i++) {
			result <<= 8;
			result |= (buffer[position + i] & 0xFF);
		}

		position += Integer.BYTES;
		return result;
	}

	public long ReadInt64() {
		long result = 0;
		for (int i = 0; i < Long.BYTES; i++) {
			result <<= 8;
			result |= (buffer[position + i] & 0xFF);
		}

		position += Long.BYTES;
		return result;
	}

	public float ReadSingle() {
		float result = ByteBuffer.wrap(buffer, position, Float.BYTES).getFloat();

		position += Float.BYTES;
		return result;
	}

	public double ReadDouble() {
		double result = ByteBuffer.wrap(buffer, position, Double.BYTES).getDouble();

		position += Double.BYTES;
		return result;
	}
	
}