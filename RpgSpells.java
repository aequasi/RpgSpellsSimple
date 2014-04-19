package com.unrulymyth;

import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitScheduler;

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
		getServer().getPluginManager().registerEvents(new PlayerJoinListener(this), this);

		getCommand("rpg").setExecutor(new SpellsCommands(this, sp));
		
		BukkitScheduler scheduler = Bukkit.getServer().getScheduler();
        scheduler.scheduleSyncRepeatingTask(this, new Runnable() {
            @Override
            public void run() {
            	Player[] players = getServer().getOnlinePlayers();
            	
            	for (int i = 0; i < mana.manaLevels.size(); i++) {
            		if ((int) mana.manaLevels.get(players[i]) < 100) {
            			mana.manaLevels.put((Player) players[i], (int) mana.manaLevels.get(players[i]) + 5);
            			mana.showMana((Player)players[i], (int) mana.manaLevels.get(players[i])); 
            		}
            	}
            }
        }, 0L, 100L);
	}
	
	public void onDisable() {
		super.onDisable();
	}
	
	public Mana getMana() {
		return this.mana;
	}
}
