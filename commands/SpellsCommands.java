package com.unrulymyth.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import com.unrulymyth.RpgSpells;
import com.unrulymyth.SpellRepository;
import com.unrulymyth.spells.SpellInterface;

public class SpellsCommands implements CommandExecutor {

    private RpgSpells plugin;

    private SpellRepository spellRepository;

    public SpellsCommands(RpgSpells plugin, SpellRepository spellRepository) {
        this.plugin = plugin;
        this.spellRepository = spellRepository;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        try {
            Player player = (Player) sender;

            if (args.length == 0) {
                player.sendMessage(ChatColor.RED + "Incorrect syntax: /rpg <Spell>");
            }

            SpellInterface spell = this.spellRepository.getSpell(args[0]);

            if (spell.cast()) {
                // Spell Succeeded
            } else {
                // Spell Failed
            }

        } catch (Exception e) {
            System.out.println("Exception in SpellsCommands");
        }

        return false;
    }
}
