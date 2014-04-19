package com.unrulymyth.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.unrulymyth.RpgSpells;
import com.unrulymyth.SpellRepository;
import com.unrulymyth.mana.Mana;
import com.unrulymyth.spells.SpellInterface;

public class SpellsCommands implements CommandExecutor {

    private SpellRepository spellRepository;

    Mana mana = new Mana();
    
    public SpellsCommands(RpgSpells plugin, SpellRepository spellRepository) {
        this.spellRepository = spellRepository;
    }
    
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        try {
            Player player = (Player) sender;
            
            if (args.length == 0) {
                player.sendMessage(ChatColor.RED + "Incorrect syntax: /rpg <Spell>");
            }

            if (args[0].equalsIgnoreCase("mana")) {
            	player.sendMessage("Your current mana is: " + mana.getMana(player));
            }
            
            SpellInterface spell = this.spellRepository.getSpell(args[0]);
            
            if (spell.cast(player)) {
            	// Spell Succeeded
            } else {
            	// Spell Failed
            }

        } catch (Exception e) {
        	e.printStackTrace();
            System.out.println("Exception in SpellsCommands");
        }

        return true;
    }
}
