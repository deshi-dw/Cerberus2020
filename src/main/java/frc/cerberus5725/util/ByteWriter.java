package frc.cerberus5725.util;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

public class ByteWriter {
	private List<Byte> buffer = new ArrayList<Byte>();

	public ByteWriter() {
	}

	public Byte[] getBuffer() {
		return buffer.toArray(new Byte[0]);
	}

	public void writeByte(byte value) {
		buffer.add(value);
	}

	public void writeChar(char value) {
		buffer.add((byte)value);
	}

	public void writeInt16(short value) {
		byte[] bytes = new byte[4];
		ByteBuffer.wrap(bytes).putShort(value);
		for (int i = 0; i < bytes.length; i++) {
			buffer.add(bytes[i]);
		}
	}

	public void writeInt32(int value) {
		byte[] bytes = new byte[4];
		ByteBuffer.wrap(bytes).putInt(value);
		for (int i = 0; i < bytes.length; i++) {
			buffer.add(bytes[i]);
		}
	}

	public void writeInt64(long value) {
		byte[] bytes = new byte[4];
		ByteBuffer.wrap(bytes).putLong(value);
		for (int i = 0; i < bytes.length; i++) {
			buffer.add(bytes[i]);
		}
	}

	public void writeSingle(float value) {
		byte[] bytes = new byte[4];
		ByteBuffer.wrap(bytes).putFloat(value);
		for (int i = 0; i < bytes.length; i++) {
			buffer.add(bytes[i]);
		}
	}

	public void writeDouble(double value) {
		byte[] bytes = new byte[4];
		ByteBuffer.wrap(bytes).putDouble(value);
		for (int i = 0; i < bytes.length; i++) {
			buffer.add(bytes[i]);
		}
	}

	public void writeString(String value) {
		writeInt32(value.length());
		try {
			byte[] bytes = value.getBytes("US-ASCII");
			for (int i = 0; i < bytes.length; i++) {
				buffer.add(bytes[i]);
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}

	public void writeByteArray(byte[] value) {
		writeInt32(value.length);
		for (int i = 0; i < value.length; i++) {
			buffer.add(value[i]);
		}
	}
}