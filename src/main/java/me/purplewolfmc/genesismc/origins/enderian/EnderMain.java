package me.purplewolfmc.genesismc.origins.enderian;

import org.bukkit.*;
import org.bukkit.block.Biome;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffectType;

import java.util.Random;

public class EnderMain implements Listener {
    @EventHandler
    public void onEvent(PlayerMoveEvent e) {
        Player p = (Player) e.getPlayer();
        if (p.getScoreboardTags().contains("enderian")) {
            if (p.getActivePotionEffects().equals(PotionEffectType.INVISIBILITY)) {
                //do nothing
            } else {
                p.spawnParticle(Particle.PORTAL, p.getLocation(), 2);
            }
            p.setMaximumAir(2);
            p.setHealthScale(24);
        }
    }

    @EventHandler
    public void onEvent1(PlayerJoinEvent e) {
        Player p = (Player) e.getPlayer();
        if (p.getScoreboardTags().contains("enderian")) {
            if (!p.getActivePotionEffects().equals(PotionEffectType.INVISIBILITY)) {
                p.spawnParticle(Particle.PORTAL, p.getLocation(), 1);
            } else {
                //do nothing
            }
            p.setMaximumAir(2);
            p.playSound(p.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, 10, 9);
            p.setHealthScale(24);
        }
    }
    @EventHandler
    public void randomNoise(PlayerMoveEvent e) {
        Player p = (Player) e.getPlayer();
        if (p.getScoreboardTags().contains("enderian")) {

            Random random = new Random();

            int r = random.nextInt(3000);
            if (r == (int) 3 || r == (int) 9 || r == (int) 11 || r == (int) 998 || r == (int) 2279 || r == (int) 989) {
                p.playSound(p.getLocation(), Sound.ENTITY_ENDERMAN_AMBIENT, 10, 9);
            }
        }
    }

    @EventHandler
    public void onDeathWater(PlayerDeathEvent e){
        Player p = (Player) e.getEntity();
        if (p.getScoreboardTags().contains("enderian")) {
            Block b = p.getWorld().getHighestBlockAt(p.getLocation());
            if (p.getLocation().getBlockY() + 1 > p.getWorld().getHighestBlockYAt(p.getLocation())) {
                if (p.getLocation().getBlock().getBiome() == Biome.SAVANNA || p.getLocation().getBlock().getBiome() == Biome.BADLANDS || p.getLocation().getBlock().getBiome() == Biome.WOODED_BADLANDS || p.getLocation().getBlock().getBiome() == Biome.SAVANNA_PLATEAU || p.getLocation().getBlock().getBiome() == Biome.WINDSWEPT_SAVANNA || p.getLocation().getBlock().getBiome() == Biome.DESERT) {
                    //do nothing
                } else {
                    if (!p.getWorld().isClearWeather()) {
                        e.setDeathMessage(p.getName() + " melted to death");
                    }
                }
            }
        }
        if (p.getScoreboardTags().contains("enderian")) {
            if (p.getLocation().getBlock().getType() == Material.WATER || p.getLocation().getBlock().getType() == Material.WATER_BUCKET || p.getLocation().getBlock().getType() == Material.WATER_CAULDRON) {
                p.getLocation().getWorld().dropItem(p.getLocation(), new ItemStack(Material.ENDER_PEARL));
                p.playSound(p.getLocation(), Sound.ENTITY_ENDERMAN_DEATH, 10, 5);
                e.setDeathMessage(p.getName() + " melted to death");
            }
        }


        if (p.getScoreboardTags().contains("enderian")) {
            p.playSound(p.getLocation(), Sound.ENTITY_ENDERMAN_DEATH, 10, 5);
        }
    }

}

