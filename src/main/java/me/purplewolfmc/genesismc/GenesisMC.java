package me.purplewolfmc.genesismc;

import me.purplewolfmc.genesismc.commands.BetaCommands;
import me.purplewolfmc.genesismc.commands.GenesisCommandManager;
import me.purplewolfmc.genesismc.commands.GenesisOP;
import me.purplewolfmc.genesismc.commands.subcommands.GenesisChooseListener;
import me.purplewolfmc.genesismc.commands.subcommands.Purge;
import me.purplewolfmc.genesismc.items.OrbOfOrigins;
import me.purplewolfmc.genesismc.items.OrbofOriginsListener;
import me.purplewolfmc.genesismc.origins.enderian.EnderMain;
import me.purplewolfmc.genesismc.origins.enderian.EnderReach;
import me.purplewolfmc.genesismc.origins.enderian.EnderTeleport;
import me.purplewolfmc.genesismc.origins.enderian.EnderWater;
import me.purplewolfmc.genesismc.origins.human.HumanMain;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.event.EventHandler;

public final class GenesisMC extends JavaPlugin implements Listener {

    public GenesisMC() {
    }

    @Override
    public void onEnable() {
// Plugin startup logic

        getServer().getConsoleSender().sendMessage(ChatColor.DARK_RED + "[GenesisMC]              ____");
        getServer().getConsoleSender().sendMessage(ChatColor.RED + "[GenesisMC]  ___        |    |   ___  [*]");
        getServer().getConsoleSender().sendMessage(ChatColor.YELLOW + "[GenesisMC] |   | | | | |    |  |   |");
        getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "[GenesisMC] |___| | | | |____|  |___|  |");
        getServer().getConsoleSender().sendMessage(ChatColor.AQUA + "[GenesisMC] |     | | | |    |  |      |");
        getServer().getConsoleSender().sendMessage(ChatColor.BLUE + "[GenesisMC] |     |_|_| |    |  |      |");
        getServer().getConsoleSender().sendMessage(ChatColor.LIGHT_PURPLE + "[GenesisMC] |           |    |  |      |");
        getServer().getConsoleSender().sendMessage(ChatColor.DARK_PURPLE + "[GenesisMC] |                   |");
        getServer().getConsoleSender().sendMessage(ChatColor.GRAY + "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        if(!this.getConfig().getString("config-version").equalsIgnoreCase(String.valueOf(0133))){
            getServer().getConsoleSender().sendMessage(ChatColor.RED + "[GenesisMC] WARNING. THIS IS THE WRONG CONFIG VERSION. PLEASE RELOAD THE CONFIG OR DELETE THE CONFIG AND RESTART");
            getServer().getConsoleSender().sendMessage(ChatColor.RED + "[GenesisMC] RELOADING CONFIG");
            this.reloadConfig();
            this.getServer().getScheduler().scheduleSyncRepeatingTask(this, new Runnable() {
                public void run() {
                    if(getConfig().getString("config-version").equalsIgnoreCase(String.valueOf(0133))){
                        getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "[GenesisMC] RELOADING CONFIG SUCCESSFUL");
                    } else if (getConfig().getString("config-version") == null || !getConfig().getString("config-version").equalsIgnoreCase(String.valueOf(0133))) {
                        getServer().getConsoleSender().sendMessage(ChatColor.RED + "[GenesisMC] ERROR RELOADING CONFIG. PLEASE DELETE CONFIG FILE AND RESTART");
                    }
                }
            }, 40, 20);
        }
        this.getServer().getScheduler().scheduleSyncRepeatingTask(this, new Runnable() {
            public void run() {
                for(Player p : Bukkit.getOnlinePlayers()) {
                    if (p.getScoreboardTags().contains("enderian")) {
                        Block b = p.getWorld().getHighestBlockAt(p.getLocation());
                        if (p.getScoreboardTags().contains("enderian")) {
                            if (!this.getTemperature(p.getLocation()).equalsIgnoreCase("Hot") && p.getLocation().getBlockY() + 1 > p.getWorld().getHighestBlockYAt(p.getLocation()) && !p.getWorld().isClearWeather()){
                                p.damage(2.0 * Bukkit.getPluginManager().getPlugin("GenesisMC").getConfig().getDouble("enderian-water-damage-multiplier"));
                            }
                        }
                        if (p.getScoreboardTags().contains("enderian") && (p.getLocation().getBlock().getType() == Material.WATER || p.getLocation().getBlock().getType() == Material.WATER_BUCKET || p.getLocation().getBlock().getType() == Material.WATER_CAULDRON)) {
                            p.damage(2.0 * Bukkit.getPluginManager().getPlugin("GenesisMC").getConfig().getDouble("enderian-water-damage-multiplier"));
                        }
                    }
                }
                Bukkit.getOnlinePlayers().stream().forEach(p -> {

                });
                }

            public String getTemperature(Location target) {
                String temperatureReading = "";
                double temperature = target.getBlock().getTemperature();
                if ((double) EnderWater.baseTemperature + temperature < 0.2) {
                    temperatureReading = "Freezing";
                } else if ((double)EnderWater.baseTemperature + temperature > 0.9) {
                    temperatureReading = "Hot";
                }

                return temperatureReading;
            }
        }, 0, 5);
        if(this.getConfig().getString("config-version") == null){
            getServer().getConsoleSender().sendMessage(ChatColor.RED + "[GenesisMC] ERROR LOADING CONFIG");
        }
        if(this.getConfig().getString("console-dump-onstartup").equalsIgnoreCase("true")){
            getServer().getConsoleSender().sendMessage(ChatColor.GRAY + "[GenesisMC] Loading API version 0.1.1");
            getServer().getConsoleSender().sendMessage(ChatColor.GRAY + "[GenesisMC] Loading Subcommands");
            getServer().getConsoleSender().sendMessage(ChatColor.GRAY + "[GenesisMC] Loading HumanMain.class");
            getServer().getConsoleSender().sendMessage(ChatColor.GRAY + "[GenesisMC] Loading EnderMain.class");
            getServer().getConsoleSender().sendMessage(ChatColor.GRAY + "[GenesisMC] Loading OriginsChoosingCommands");
            getServer().getConsoleSender().sendMessage(ChatColor.LIGHT_PURPLE + "[GenesisMC] DUMPING PLUGIN-API FILES:");
            getServer().getConsoleSender().sendMessage(ChatColor.GRAY + "Loading config file:" +
                    this.getConfig().getValues(Boolean.parseBoolean("all")));
            getServer().getConsoleSender().sendMessage(ChatColor.LIGHT_PURPLE + "[GenesisMC] Loading API");
            getServer().getConsoleSender().sendMessage(ChatColor.GRAY + "[GenesisMC] DUMPING SERVER FILES:" +
                    getServer().getVersion() +
                    getServer().getAllowEnd() +
                    getServer().getAllowNether() +
                    getServer().getPluginManager() +
                    getServer().getMaxPlayers() +
                    getServer().getConnectionThrottle() +
                    getServer().getLogger() +
                    getServer().getName() +
                    getServer().getBukkitVersion() +
                    getServer().getDefaultGameMode() +
                    getServer().getWorldType() +
                    getServer().getResourcePack() +
                    getServer().getHelpMap() +
                    getServer().getPluginManager().getPlugins()
            );
            getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "[GenesisMC] Successfully loaded version 0.1.3-SNAPSHOT (1.19.3)");
            getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "[GenesisMC] Successfully loaded API version 0.1.1-BETA (1.19.3)");
            getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "[GenesisMC] Successfully loaded CONFIG version 0133 (1.19.3)");
            if(!this.getConfig().getString("use-purplewolfapi").equalsIgnoreCase(String.valueOf(true))){
                getServer().getConsoleSender().sendMessage(ChatColor.RED + "[GenesisMC] WARNGING. PURPLEWOLFAPI IS DISABLED. THINGS WILL BREAK. PLEASE TURN BACK TO TRUE");
                getServer().getPluginManager().getPlugin("origins-spigotmc").reloadConfig();
            }
        }else{
            getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "[GenesisMC] Successfully loaded version 0.1.3-SNAPSHOT (1.19.3)");
        }
        if(getServer().getPluginManager().getPlugins().toString().contains("PurpleWolfAPI") || getServer().getPluginManager().isPluginEnabled("PurpleWolfAPI") || getServer().getPluginManager().getPlugin("PurpleWolfAPI") != null){
            getServer().getConsoleSender().sendMessage(ChatColor.LIGHT_PURPLE + "[GenesisMC - PurpleWolfAPI] Successfully injected PurpleWolfAPI into plugin");
        }else{
            //PurpleWolfAPI not avalible, inject built-in
            getServer().getConsoleSender().sendMessage(ChatColor.LIGHT_PURPLE + "[GenesisMC] PurpleWolfAPI not detected. Injecting built-in API");
        }
        getServer().getConsoleSender().sendMessage(ChatColor.GRAY + "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        getServer().getPluginManager().registerEvents(this, this);
//Commands
        getCommand("origins").setExecutor(new GenesisCommandManager());
        getCommand("origins-op").setExecutor(new GenesisOP());
//Event Handler Register
        getServer().getPluginManager().registerEvents(new GenesisChooseListener(),this);
        getServer().getPluginManager().registerEvents(new EnderReach(),this);
        getServer().getPluginManager().registerEvents(new EnderTeleport(),this);
        getServer().getPluginManager().registerEvents(new EnderWater(), this);
        getServer().getPluginManager().registerEvents(new HumanMain(), this);
        getServer().getPluginManager().registerEvents(new EnderMain(), this);
        getServer().getPluginManager().registerEvents(new Purge(), this);
        getServer().getPluginManager().registerEvents(new OrbofOriginsListener(), this);
        if(this.getConfig().getString("update-beta").equalsIgnoreCase("true")){
            getCommand("beta").setExecutor(new BetaCommands());
        }
        OrbOfOrigins.init();

        this.saveDefaultConfig();

        Bukkit.getServer().getPluginManager().registerEvents(this, this);
        this.getConfig().options().copyDefaults(true);
        this.saveDefaultConfig();

    }

    //RunOnPlayerJoinIfNotChoose

    @EventHandler
    public void onBeforeChoose(PlayerJoinEvent e){
        Player p = e.getPlayer();
        if(!p.getScoreboardTags().contains("chosen")){
            p.sendMessage(ChatColor.WHITE + "Run " + ChatColor.GREEN + "/origins" + ChatColor.WHITE + " to choose your origin!!");
        }else{
            return;
        }
    }




    @Override
    public void onDisable() {
        // Plugin shutdown logic
        System.out.println("[PWSMP-Origins] Disabling PWSMP Origins Mod");


    }
}
