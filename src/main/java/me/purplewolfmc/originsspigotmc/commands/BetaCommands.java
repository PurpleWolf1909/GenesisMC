package me.purplewolfmc.originsspigotmc.commands;

import me.purplewolfmc.originsspigotmc.commands.subcommands.BetaOrbOrigins;
import me.purplewolfmc.originsspigotmc.commands.subcommands.SubCommand;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;

public class BetaCommands implements CommandExecutor {

    //key = uuid of player
    //long = epoch time of when ran command
    private ArrayList<SubCommand> subCommands = new ArrayList<>();
    public BetaCommands(){
        subCommands.add(new BetaOrbOrigins());
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player){
            Player p = (Player) sender;
            if (args.length > 0){
                for (int i = 0; i < getSubCommands().size(); i++){
                    if (args[0].equalsIgnoreCase(getSubCommands().get(i).getName())){
                        getSubCommands().get(i).perform(p,args);
                    }

                }
            }
        }
        return true;
    }
    public ArrayList<SubCommand> getSubCommands(){
        return subCommands;
    }
}