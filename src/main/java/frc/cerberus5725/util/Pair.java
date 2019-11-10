package frc.cerberus5725.util;

public class Pair<KT, VT> {
	private KT key;
	private VT value;

	public Pair(KT key, VT value) {
		this.key = key;
		this.value = value;
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