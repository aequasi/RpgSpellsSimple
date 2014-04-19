package com.unrulymyth.spells;

import org.bukkit.entity.Player;
import com.unrulymyth.RpgSpells;

public interface SpellInterface {
    public RpgSpells getPlugin();

    public String getName();

    public boolean cast(Player player);
}
