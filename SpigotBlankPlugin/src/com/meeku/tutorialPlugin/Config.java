package com.meeku.tutorialPlugin;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

public class Config {
private static final String Location = null;
// This stuff will be initialized in your constructor
private final Plugin PLUGIN;
private final String Config;
private final File FOLDER;
private FileConfiguration config;
private File configFile;
private String FILENAME;

// This first constructor is for putting the config file directly into the getDataFolder()
public Config(String Config, SpigotBlankPlugin instance) {
if(!Config.endsWith(".yml")) {
FILENAME += ".yml"; // Check whether the filename already has the extension, and if it doesn't, add it.
 }
this.FILENAME = Config;
this.PLUGIN = instance; // You can also remove the instance grom your constructor and use Bukkit.getPluginmanager().getPlugin("<pluginname>");
this.FOLDER = this.PLUGIN.getDataFolder();
this.config = null; // this.config and this.configfile are set to null here, but they will be properly initialized in the reload() method.
this.configFile = null;
reload(); // We will define this method in a minute, hold your horses.
 }

// The second constructor is for putting the config file into a specified folder.
public Config(File folder, String Config, SpigotBlankPlugin instance) {
if(!Config.endsWith("yml.")) {
FILENAME += ".yml"; // Check whether the filename already has the extension, and if it doesnt, add it.
 }
this.FILENAME =	Config;
this.PLUGIN = instance; // You can also remove the instance for your constructor and use Bukkit.getPluginManager().getPlugin("<pluginname>"};
this.FOLDER = folder;
this.config = null; // this.config and this.configfile are set to null here, but they will be properly initialized in the reload() method.
this.configFile = null;
reload(); // We will define it in a minute, hold your horses.
 } 
public FileConfiguration GetConfig() {
	if (config == null) {
		reload();
	    }
return config; // Return the config so that the player can save, set, and get from the console.
   }

public void reload() {
	if(!this.FOLDER.exists()) { // Checks if folder exists
		try {
			if(this.FOLDER.mkdir() ) { // Attempts to make a folder if the folder doesnt exist.
				this.PLUGIN.getLogger().log(Level.INFO, "Folder " + this.FOLDER.getName() + " created.");
			} else {
				this.PLUGIN.getLogger().log(Level.WARNING, "Unable to create folder " + this.FOLDER.getName() + ".");
			}
		} catch(Exception e) {
			
		}
	}
	configFile = new File(this.FOLDER, this.FILENAME); // Makes the file in the folder
	if(!configFile.exists()) { // Creates the file if it doesnt exists
		try {
			configFile.createNewFile();
		} catch(IOException e) {
			
		}
	}
config = YamlConfiguration.loadConfiguration(configFile); // Loads the file through YAML'S system.
}

public void saveDefaultConfig() {
	if (configFile == null) {
		configFile = new File(PLUGIN.getDataFolder(), this.FILENAME);	
	}
	
	if (!configFile.exists()) {
		PLUGIN.saveResource(this.FILENAME, false); // Gets resource from jar (from the same as plugin.yml)
	}
	}

public void save() { // This method makes it so that you dont have to do config.getConfig().save(configFile); everytime you want to save.
	if (config == null || configFile == null) {
		return;
	}
	try {
		GetConfig().save(configFile);
	} catch (IOException ex) {
		this.PLUGIN.getLogger().log(Level.WARNING, "Could not save config to " + configFile.getName(), ex);
	}
}

public void set(String path, Object o) { // Shortens the path to set something.
	GetConfig().set(path, o);
// You could also add a save() here, but I decided not to, just so it only had to save once per time I set things.
}

public int setLocation(String path) { // You can get locations that you set with the above mathod by using this one.
	Location 1 = new Location(Bukkit.getWorld(getConfig().getString(path + ".w")), getConfig().getDouble(path + ".y"), getConfig().getDouble(path + ".z"),Float.pareFloat("" + getConfig().getDouble(path + ".yaw")), Float.parseFloat("" + getConfig().getDouble(path + ".pitch")));
	return 1;
	}
}


	

 	

