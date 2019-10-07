package frc.robot;

import java.util.HashMap;
import java.util.Map;

public class ComponentInfo {
	private Map<String, String> values = new HashMap<String, String>();

	public ComponentInfo() {}

	public <T> void add(String valueName, T value) {
		values.put(valueName, value.toString());
	}

	public void remove(String valueName) {
		values.remove(valueName);
	}

	public void clear() {
		values.clear();
	}

	public String print() {
		String printString = "";

		String[] valuesKeys = values.keySet().toArray(new String[0]);
		for(int i = valuesKeys.length-1; i >= 0; i--) {
			printString += valuesKeys[i] + " : \t" + values.get(valuesKeys[i]);
		}
		return printString;
	}
}