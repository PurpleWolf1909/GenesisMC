package me.purplewolfmc.genesismc.origins.human;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class HumanMain implements Listener {
    @EventHandler
    public void onSpawn(PlayerMoveEvent e){
        Player p = (Player) e.getPlayer();
        if (p.getScoreboardTags().contains("human")){
                p.setHealthScale(20);
                p.setMaximumAir(20);
            }
        }
    }
