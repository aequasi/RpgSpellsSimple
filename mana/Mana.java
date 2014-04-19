package com.unrulymyth.mana;

import java.util.HashMap;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class Mana {
	public HashMap<Player, Integer> manaLevels = new HashMap<>();
	
	public void changeMana(Player player, int cost) {
		manaLevels.put(player, manaLevels.get(player) - cost);
	}
	
	public void showMana(Player player, int mana) {
		if (mana == 100) {
			player.sendMessage(ChatColor.BLUE + "Mana: |==========|");
		} else if (mana < 99 && mana > 90) {
			player.sendMessage(ChatColor.BLUE + "Mana: |=========" + ChatColor.RED + "=|");
		} else if (mana < 89 && mana > 80) {
			player.sendMessage(ChatColor.BLUE + "Mana: |========" + ChatColor.RED + "==|");
		} else if (mana < 79 && mana > 70) {
			player.sendMessage(ChatColor.BLUE + "Mana: |=======" + ChatColor.RED + "===|");
		} else if (mana < 69 && mana > 60) {
			player.sendMessage(ChatColor.BLUE + "Mana: |======" + ChatColor.RED + "====|");
		} else if (mana < 59 && mana > 50) {
			player.sendMessage(ChatColor.BLUE + "Mana: |=====" + ChatColor.RED + "=====|");
		} else if (mana < 49 && mana > 40) {
			player.sendMessage(ChatColor.BLUE + "Mana: |====" + ChatColor.RED + "======|");
		} else if (mana < 39 && mana > 30) {
			player.sendMessage(ChatColor.BLUE + "Mana: |===" + ChatColor.RED + "=======|");
		} else if (mana < 29 && mana > 20) {
			player.sendMessage(ChatColor.BLUE + "Mana: |==" + ChatColor.RED + "========|");
		} else if (mana < 19 && mana > 10) {
			player.sendMessage(ChatColor.BLUE + "Mana: |=" + ChatColor.RED + "=========|");
		} else if (mana < 9 && mana > 1) {
			player.sendMessage(ChatColor.BLUE + "Mana: |:" + ChatColor.RED + "=========|");
		} else if (mana == 0) {
			player.sendMessage(ChatColor.BLUE + "Mana: |" + ChatColor.RED + "==========|");
		}
	}
}