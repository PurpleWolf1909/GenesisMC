package me.purplewolfmc.genesismc.commands.subcommands;

import me.purplewolfmc.genesismc.items.OrbOfOrigins;
import org.bukkit.entity.Player;

public class BetaOrbOrigins extends SubCommand{
    @Override
    public String getName() {
        return "orboforigin";
    }

    @Override
    public String getDescription() {
        return "spawns the orb of origin";
    }

    @Override
    public String getSyntax() {
        return "/beta orboforigin";
    }

    @Override
    public void perform(Player p, String[] args) {
        p.getInventory().addItem(OrbOfOrigins.orb);
        p.sendMessage("test");
    }
}
