package com.unrulymyth.mana;

import java.util.HashMap;

import org.bukkit.entity.Player;

public class Mana {
	public static HashMap<Player, Integer> manaLevels = new HashMap<>();
	
	public void takeMana(Player player, Integer currentMana) {
		manaLevels.put(player, manaLevels.get(currentMana));
	}
	
	public int getMana(Player player) {
		return manaLevels.get(player);
	}
}