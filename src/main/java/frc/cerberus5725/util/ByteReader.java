package frc.cerberus5725.util;

import java.nio.ByteBuffer;

public class ByteReader {
	private byte[] buffer;
	private int position = 0;

	public ByteReader(byte[] buffer) {
		this.buffer = buffer;
	}

	public byte[] getBuffer() {
		return buffer;
	}

	public short readByte() {
		byte result = buffer[position];
		position++;
		return result;
	}

	public short readInt16() {
		short result = ByteBuffer.wrap(buffer, position, Short.BYTES).getShort();

		position += Short.BYTES;
		return result;
	}

	public int readInt32() {
		int result = ByteBuffer.wrap(buffer, position, Integer.BYTES).getInt();

		position += Integer.BYTES;
		return result;
	}

	public long readInt64() {
		long result = ByteBuffer.wrap(buffer, position, Long.BYTES).getLong();

		position += Long.BYTES;
		return result;
	}

	public float readSingle() {
		float result = ByteBuffer.wrap(buffer, position, Float.BYTES).getFloat();

		position += Float.BYTES;
		return result;
	}

	public double readDouble() {
		double result = ByteBuffer.wrap(buffer, position, Double.BYTES).getDouble();

		position += Double.BYTES;
		return result;
	}
	
}