package frc.robot.util;

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

	public void WriteByte(byte value) {
		buffer.add(value);
	}

	public void WriteChar(short value) {
	}

	public void WriteInt16(short value) {
		byte[] bytes = new byte[4];
		ByteBuffer.wrap(bytes).putShort(value);
		for (int i = 0; i < bytes.length; i++) {
			buffer.add(bytes[i]);
		}
	}

	public void WriteInt32(int value) {
		byte[] bytes = new byte[4];
		ByteBuffer.wrap(bytes).putInt(value);
		for (int i = 0; i < bytes.length; i++) {
			buffer.add(bytes[i]);
		}
	}

	public void WriteInt64(long value) {
		byte[] bytes = new byte[4];
		ByteBuffer.wrap(bytes).putLong(value);
		for (int i = 0; i < bytes.length; i++) {
			buffer.add(bytes[i]);
		}
	}

	public void WriteSingle(float value) {
		byte[] bytes = new byte[4];
		ByteBuffer.wrap(bytes).putFloat(value);
		for (int i = 0; i < bytes.length; i++) {
			buffer.add(bytes[i]);
		}
	}

	public void WriteDouble(double value) {
		byte[] bytes = new byte[4];
		ByteBuffer.wrap(bytes).putDouble(value);
		for (int i = 0; i < bytes.length; i++) {
			buffer.add(bytes[i]);
		}
	}

	public void WriteString(String value) {
		WriteInt32(value.length());
		try {
			byte[] bytes = value.getBytes("US-ASCII");
			for (int i = 0; i < bytes.length; i++) {
				buffer.add(bytes[i]);
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}

	public void WriteByteArray(byte[] value) {
		WriteInt32(value.length);
		for (int i = 0; i < value.length; i++) {
			buffer.add(value[i]);
		}
	}
}