package com.unrulymyth.listeners;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLevelChangeEvent;

public class PlayerLevelUpListener implements Listener {

	@EventHandler
	public void playerLevelUp(PlayerLevelChangeEvent event) {
		if (event.getPlayer().getLevel() == 2) {
			event.getPlayer().sendMessage(ChatColor.AQUA + "Congratulations. You can now use teleport!");
		}
		
	}
}
