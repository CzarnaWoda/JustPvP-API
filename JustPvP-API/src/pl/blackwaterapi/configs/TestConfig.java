package pl.blackwaterapi.configs;

import org.bukkit.configuration.file.FileConfiguration;

import pl.blackwaterapi.API;

public class TestConfig extends ConfigCreator{
	public static String xDmessage;
	public TestConfig() {
		super("test.yml", "opis", API.getPlugin());
		// TODO Auto-generated constructor stub
		FileConfiguration config = getConfig();
		xDmessage = config.getString("config.message");
	}

}
