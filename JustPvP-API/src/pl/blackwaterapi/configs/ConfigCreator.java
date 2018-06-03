package pl.blackwaterapi.configs;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;

import org.bukkit.Bukkit;
import org.bukkit.configuration.Configuration;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public abstract class ConfigCreator {
	private String configName;
	private File configFile = null;
	private String configDescription;
	private Plugin plugin;
	private FileConfiguration config = null;
	
	public ConfigCreator(String configName,String configDescription,Plugin plugin){
		this.configName = configName;
		this.configDescription = configDescription;
		this.plugin = plugin;
	}
	public Plugin getPlugin(){
		return plugin;
	}
	@SuppressWarnings("deprecation")
	public void reloadConfig() {
        if (configFile == null) {
            configFile = new File(plugin.getDataFolder(), configName);
        }
        config = (FileConfiguration)YamlConfiguration.loadConfiguration(configFile);
        final InputStream defConfigStream = plugin.getResource(configName);
        if (defConfigStream != null) {
            final YamlConfiguration defConfig = YamlConfiguration.loadConfiguration(defConfigStream);
            config.setDefaults((Configuration)defConfig);
        }
    }
    public FileConfiguration getConfig() {
        if (config == null) {
            reloadConfig();
        }
        return config;
    }
    public void saveConfig() {
        if (config == null || configFile == null) {
            return;
        }
        try {
            getConfig().save(configFile);
        }
        catch (IOException ex) {
            Bukkit.getLogger().log(Level.SEVERE, "Could not save config to " + configFile, ex);
        }
    }
    public void saveDefaultConfig() {
        if (configFile == null) {
            configFile = new File(plugin.getDataFolder(), configName);
        }
        if (!configFile.exists()) {
            plugin.saveResource(configName, false);
        }
    }
}
