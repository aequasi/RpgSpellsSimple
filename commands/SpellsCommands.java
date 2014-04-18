package com.unrulymyth.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.unrulymyth.RpgSpells;
import com.unrulymyth.spells.SpellTaunt;
import com.unrulymyth.spells.SpellTeleport;

public class SpellsCommands implements CommandExecutor {

	private RpgSpells plugin;
	   
    public SpellsCommands(RpgSpells instance){
        plugin = instance;
    }

	SpellTaunt sta = new SpellTaunt();
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		try {
			Player player = (Player) sender;
			
			if (args.length == 0) {
				player.sendMessage(ChatColor.RED + "Incorrect syntax: /rpg <Spell>");
			}
			
			if (args[0].equalsIgnoreCase("teleport")) {
				SpellTeleport.castTeleport(player);
			}
			
			if (args[0].equalsIgnoreCase("taunt")) {
				sta.castTaunt(player);
			}
		} catch (Exception e) {
			System.out.println("Exception in SpellsCommands");
		}
		
		return false;
	}
}
