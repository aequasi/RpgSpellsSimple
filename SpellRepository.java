package com.unrulymyth;

import org.bukkit.plugin.java.JavaPlugin;

import com.unrulymyth.RpgSpells;
import com.unrulymyth.commands.SpellsCommands;
import com.unrulymyth.listeners.PlayerLevelUpListener;
import com.unrulymyth.spells.SpellInterface;
import com.unrulymyth.spells.SpellTeleport;
import com.unrulymyth.spells.SpellTaunt;


public class SpellRepository {

    private RpgSpells plugin;

    private SpellInterface[] spellClasses;

    public SpellRepository(RpgSpells plugin) {
        this.plugin = plugin;

        this.spellClasses = {
            new SpellTeleport(plugin),
            new SpellTaunt(plugin)
        };
    }

    public SpellInterface function getSpell(String name) {
        for (SpellInterface spell : this.spellClasses) {
            if (spell.getName().toLowerCase() == name.toLowerCase()) {
                return spell;
            }
        }

        throw new Exception("Couldn't find a spell with that name.")
    }
}