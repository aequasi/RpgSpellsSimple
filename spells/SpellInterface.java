package com.unrulymyth.spells;

import org.bukkit.entity.Player;
import com.unrulymyth.RpgSpells;

public interface SpellInterface {
    private RpgSpells function getPlugin();

    public String function getName();

    public boolean function cast(Player player);
}