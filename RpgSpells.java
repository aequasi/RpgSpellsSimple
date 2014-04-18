package com.unrulymyth;

import org.bukkit.plugin.java.JavaPlugin;

import com.unrulymyth.commands.SpellsCommands;
import com.unrulymyth.listeners.PlayerLevelUpListener;
import com.unrulymyth.spells.SpellTeleport;


public class RpgSpells extends JavaPlugin {
	
	SpellTeleport st = new SpellTeleport(this);
	
	public void onEnable() {
		super.onEnable();
		
		getConfig().options().copyDefaults(true);
		saveConfig();
		
		getServer().getPluginManager().registerEvents(new PlayerLevelUpListener(), this);
		
		SpellsCommands cmd = new SpellsCommands(this);
		getCommand("rpg").setExecutor(cmd);
	}
	
	public void onDisable() {
		super.onDisable();
	}
}
