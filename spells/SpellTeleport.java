package com.unrulymyth.spells;

import java.util.HashMap;
import java.util.Map;

import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.craftbukkit.Main;
import org.bukkit.entity.Player;
import org.bukkit.util.BlockIterator;

import com.unrulymyth.RpgSpells;
import com.unrulymyth.commands.SpellsCommands;

public class SpellTeleport {
	
	private static RpgSpells plugin;
	   
    public SpellTeleport(RpgSpells instance){
        plugin = instance;
    }
    
	private static Map<String, Long> cooldownTeleport = new HashMap<String, Long>();
	
	public static boolean castTeleport(Player player) {
		int cooldownTime = plugin.getConfig().getInt("teleport.cooldown");
		
		if (player.getLevel() >= 2) {
			if (cooldownTeleport.containsKey(player.getName())) {
				long secondsLeft = ((cooldownTeleport.get(player.getName()) / 1000) + cooldownTime) - (System.currentTimeMillis() / 1000);
			
				if (secondsLeft > 0) {
					player.sendMessage("You can't use this for another " + secondsLeft + " seconds");
					
					return true;
				}
			}
			
			Block b = getTarget(player, 20);
			Block aboveB = b.getRelative(BlockFace.UP);
			Location bLoc = b.getLocation();
			Location pLoc = player.getLocation();
			bLoc.setPitch(pLoc.getPitch());
			bLoc.setYaw(pLoc.getYaw());
			if (b.getType().isSolid()) {
				bLoc.setY(b.getY() + 1);
			}
			
			if (!aboveB.isEmpty()) {
				player.sendMessage("You cannot teleport there");
				return false;
			}
			
			player.teleport(bLoc);
			player.playSound(player.getLocation(), Sound.ENDERMAN_TELEPORT, 1.0f, 0);
			World world = player.getWorld();
			world.playEffect(player.getLocation(), Effect.SMOKE, 100);
			
			cooldownTeleport.put(player.getName(), System.currentTimeMillis());
		} else {
			player.sendMessage("You must be level 2 or higher to use this!");
		}
		
		return true;
	}
	
	public final static Block getTarget(Player player, Integer range) {
        BlockIterator iter = new BlockIterator(player, range);
        Block lastBlock = iter.next();
        while (iter.hasNext()) {
            lastBlock = iter.next();
            if (lastBlock.getType() == Material.AIR)
                continue;
            break;
        }
        return lastBlock;
    }
}
