package com.meeku.tutorialPlugin;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class Exectutor implements CommandExecutor {

    // This  method is called, when someone uses our command
    @Override
    public boolean onCommand(CommandSender sender, Command kit, String label, String [] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            // Create a new ItemStack (type: diamond)
            ItemStack diamond = new ItemStack(Material.DIAMOND);

            // Create a new ItemStack (type: brick)
            ItemStack bricks = new ItemStack(Material.BRICK);

            // Set the amount of the ItemStack or already in the ItemStack: ItemStack bricks = new ItemStack(Material.BRICK, 20)
            bricks.setAmount(20);

            // Give the player our items (comma-separated list of all ItemStack)
            player.getInventory().addItem(bricks, diamond);
			// If the player (or console) uses our command correct, we can return true
      		  return true; 
        }
		else {
			return false;
		}
   }
}