package frc.robot.util;

public class Pair<KT, VT> {
	private KT key;
	private VT value;

	public Pair(KT key, VT value) {
		this.value = value;
		this.key = key;
	}

	public KT getKey() {
		return key;
	}
	public KT setKey() {
		return key;
	}

	public VT getValue() {
		return value;
	}
	public VT setValue() {
		return value;
	}
}