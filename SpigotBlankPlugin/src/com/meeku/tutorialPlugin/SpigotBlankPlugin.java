package com.meeku.tutorialPlugin;
import org.bukkit.plugin.java.JavaPlugin;

public class SpigotBlankPlugin extends JavaPlugin {
	// Fired when plugin is first enabled
	@Override
	public void onEnable() {
		this.getCommand("kit").setExecutor(new Exectutor());
		getServer().getPluginManager().registerEvents(new EventAPI(), this);	
	}
	// Fired when plugin is disabled
	@Override
	public void onDisable( ) {
	// Register our command "kit" (set an instance of your command class as executor}
	}
    
}


