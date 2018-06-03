package pl.blackwaterapi.configs;

import java.util.HashMap;

import pl.blackwaterapi.utils.Logger;

public class ConfigManager {
	public static HashMap<String, ConfigCreator> configs;
	static{
		configs = new HashMap<>();
	}
	public static void register(ConfigCreator c){
		ConfigCreator cfg = configs.get(c.getConfigName());
		if(cfg == null){
			configs.put(c.getConfigName(), c);
			c.saveDefaultConfig();
			Logger.info("Config " + c.getConfigName() + " was registered");
		}
	}
	public static ConfigCreator getConfig(String cfgname){
		return configs.get(cfgname);
	}
}
