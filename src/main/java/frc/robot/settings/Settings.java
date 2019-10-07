package frc.robot.settings;

import java.util.HashMap;
import java.util.Map;

public class Settings {
	private Map<String, Object> settings = new HashMap<String, Object>();

	public Settings() { }

	public <T> T get(String settingsName) {
		return (T)settings.get(settingsName);
	}
	
	public void set(String settingName, Object newValue) {
		settings.put(settingName, newValue);
	}

	public void add(String settingName, Object defaultValue) {
		settings.put(settingName, defaultValue);
	}

	public void remove(String settingsName) {
		settings.remove(settingsName);
	}

	public void clear() {
		settings.clear();
	}

	public String save() {
		// TODO: Implement settings saving to file.
		return "";
	}

	public void load(String data) {
		// TODO: Implement settings loading from file.
	}
}