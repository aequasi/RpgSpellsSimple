package com.unrulymyth;

import org.bukkit.plugin.java.JavaPlugin;

import com.unrulymyth.commands.SpellsCommands;
import com.unrulymyth.listeners.PlayerLevelUpListener;
import com.unrulymyth.spells.SpellTeleport;
import com.unrulymyth.SpellRepository;


public class RpgSpells extends JavaPlugin {
	
	private SpellRepository spellRepository;
	
	public void onEnable() {
		super.onEnable();
		
		getConfig().options().copyDefaults(true);
		saveConfig();
		
		getServer().getPluginManager().registerEvents(new PlayerLevelUpListener(), this);

        this.spellRepository = new SpellRepository(this);
		
		SpellsCommands cmd = new SpellsCommands(this, this.spellRepository);

		getCommand("rpg").setExecutor(cmd);
	}
	
	public void onDisable() {
		super.onDisable();
	}
}
