package com.unrulymyth.spells;

import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.entity.Creature;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Monster;
import org.bukkit.entity.Player;
import com.unrulymyth.RpgSpells;
import com.unrulymyth.spells.SpellInterface;


public class SpellTaunt implements SpellInterface {


    private RpgSpells plugin;

    public SpellTaunt(RpgSpells plugin) {
        this.plugin = plugin;
    }

    private RpgSpells function getPlugin() {
        return this.plugin;
    }

    public String function getName() {
        return "taunt";
    }

	public boolean function cast(Player player) {
		List<Entity> entities = player.getNearbyEntities(5.0, 5.0, 5.0);

        boolean targetSet = false;
		for (Entity n : entities) {
			if (n instanceof Monster) {
				((Creature)n).setTarget(player);
                targetSet = true;
			}
		}
        if (!targetSet) {
            return false;
        }

		player.sendMessage(ChatColor.RED + "You taunt nearby entities");

        return true;
	}
}
