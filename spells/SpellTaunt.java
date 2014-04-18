package com.unrulymyth.spells;

import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.entity.Creature;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Monster;
import org.bukkit.entity.Player;

public class SpellTaunt {

	public void castTaunt(Player player) {
		List<Entity> entities = player.getNearbyEntities(5.0, 5.0, 5.0);
		
		for (Entity n : entities) {
			if (n instanceof Monster) {
				((Creature)n).setTarget(player);
			}
		}
		
		player.sendMessage(ChatColor.RED + "You taunt nearby entities");
	}
}
