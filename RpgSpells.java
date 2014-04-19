package com.unrulymyth;

import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.java.JavaPlugin;

import com.unrulymyth.commands.SpellsCommands;
import com.unrulymyth.listeners.PlayerJoinListener;
import com.unrulymyth.listeners.PlayerLevelUpListener;
import com.unrulymyth.mana.Mana;


public class RpgSpells extends JavaPlugin {

	SpellRepository sp = new SpellRepository(this);
	Mana mana = new Mana();
	
	public void onEnable() {
		super.onEnable();

		getConfig().options().copyDefaults(true);
		saveConfig();

		
		getServer().getPluginManager().registerEvents(new PlayerLevelUpListener(), this);
		getServer().getPluginManager().registerEvents(new PlayerJoinListener(), this);

		getCommand("rpg").setExecutor(new SpellsCommands(this, sp));
	}
	
	public void onDisable() {
		super.onDisable();
	}
}
