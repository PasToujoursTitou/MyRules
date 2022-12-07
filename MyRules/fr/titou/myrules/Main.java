package fr.titou.myrules;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
	
	
	@Override
	public void onEnable() {
		System.out.println("[MyRules] Enabling...");
		saveDefaultConfig();
		getCommand("rules").setExecutor(this);
	}
	
	@Override
	public void onDisable() {
		System.out.println("[MyRules] Disabling...");
	}
	
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if(cmd.getName().equalsIgnoreCase("rules")) {
			
			Player player = (Player)sender;
			
			if(player instanceof Player) {
				
				for(String string : getConfig().getStringList("message")) {
					player.sendMessage(string);
				}
			}
		}
		return super.onCommand(sender, cmd, label, args);
	}
}
