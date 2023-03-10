package me.purplewolfmc.genesismc.origins.enderian;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Biome;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.ItemStack;

public class EnderWater implements Listener {
    public EnderWater() {
    }
    public static int baseTemperature = 0;


    @EventHandler
    public void onDeathWeather(PlayerDeathEvent e) {
        Player p = e.getEntity();
        if (p.getScoreboardTags().contains("enderian")) {
            Block b = p.getWorld().getHighestBlockAt(p.getLocation());
            if (p.getLocation().getBlockY() + 1 > p.getWorld().getHighestBlockYAt(p.getLocation()) && p.getLocation().getBlock().getBiome() != Biome.SAVANNA && p.getLocation().getBlock().getBiome() != Biome.BADLANDS && p.getLocation().getBlock().getBiome() != Biome.WOODED_BADLANDS && p.getLocation().getBlock().getBiome() != Biome.SAVANNA_PLATEAU && p.getLocation().getBlock().getBiome() != Biome.WINDSWEPT_SAVANNA && p.getLocation().getBlock().getBiome() != Biome.DESERT && !p.getWorld().isClearWeather()) {
                e.setDeathMessage(e.getEntity().getName() + " melted to death");
            }
        }

    }

    @EventHandler
    public void onDeathEnder(PlayerDeathEvent e) {
        Player p = e.getEntity();
        if (e.getEntity().getScoreboardTags().contains("enderian") && (e.getEntity().getLocation().getBlock().getType() == Material.WATER || e.getEntity().getLocation().getBlock().getType() == Material.WATER_BUCKET || e.getEntity().getLocation().getBlock().getType() == Material.WATER_CAULDRON)) {
            p.getLocation().getWorld().dropItem(p.getLocation(), new ItemStack(Material.ENDER_PEARL));
            p.playSound(p.getLocation(), Sound.ENTITY_ENDERMAN_DEATH, 10.0F, 5.0F);
            e.setDeathMessage(e.getEntity().getName() + " melted to death");
        }

    }

    @EventHandler
    public void onDamage(EntityDamageEvent e) {
        if (e.getEntity().getScoreboardTags().contains("enderian")) {
            Player p = (Player)e.getEntity();
            p.playSound(p.getLocation(), Sound.ENTITY_ENDERMAN_DEATH, 10.0F, 5.0F);
        }

    }

}
