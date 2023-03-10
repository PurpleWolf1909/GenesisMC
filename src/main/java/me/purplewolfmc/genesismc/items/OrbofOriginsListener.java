package me.purplewolfmc.genesismc.items;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

import static me.purplewolfmc.genesismc.items.OrbOfOrigins.orb;
import static org.bukkit.ChatColor.LIGHT_PURPLE;
import static org.bukkit.Material.ENDER_PEARL;

public class OrbofOriginsListener implements Listener {

    @EventHandler
    public void onOrbClick(PlayerInteractEvent e) {
        Player p = e.getPlayer();
        if (e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.LEFT_CLICK_AIR || e.getAction() == Action.LEFT_CLICK_BLOCK || e.getAction() == Action.RIGHT_CLICK_BLOCK) {
            if (e.getItem() != null) {
                if (e.getItem().equals(orb)) {
                    if (e.getItem().getType().equals(Material.MAGMA_CREAM)) {
                        if (e.getItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.LIGHT_PURPLE + "Orb of Origins")) {
                            if (e.getItem().getItemMeta().getItemFlags().contains(ItemFlag.HIDE_UNBREAKABLE)) {

                                e.setCancelled(true);
                                Inventory humangui = Bukkit.createInventory(p, 54, ChatColor.BLACK + "Origins Rechoosing");

                                ItemStack close = new ItemStack(Material.BARRIER);
                                ItemStack next = new ItemStack(Material.ARROW);
                                ItemStack human = new ItemStack(Material.PLAYER_HEAD);
                                ItemStack GRAY_STAINED_GLASS_PANE = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);
                                ItemStack human_origin_info = new ItemStack(Material.FILLED_MAP);
                                ItemStack blank = new ItemStack(Material.PAPER);

                                ItemStack item = new ItemStack(Material.MAGMA_CREAM, 1);
                                ItemMeta meta = item.getItemMeta();
                                meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
                                meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
                                meta.addItemFlags(ItemFlag.HIDE_DESTROYS);
                                meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                                meta.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
                                meta.addItemFlags(ItemFlag.HIDE_PLACED_ON);
                                meta.setDisplayName(ChatColor.LIGHT_PURPLE + "Orb of Origins");
                                meta.setUnbreakable(true);
                                meta.addEnchant(Enchantment.ARROW_INFINITE, 1, true);
                                List<String> lore = new ArrayList<>();
                                item.setItemMeta(meta);
                                orb = item;

                                ItemMeta human_origin_info_meta = human_origin_info.getItemMeta();
                                human_origin_info_meta.setDisplayName("NOTHING");
                                ArrayList<String> human_origin_info_lore = new ArrayList<>();
                                human_origin_info_lore.add(ChatColor.WHITE + "You have no powers");
                                human_origin_info_meta.setLore(human_origin_info_lore);
                                human_origin_info.setItemMeta(human_origin_info_meta);

                                ItemMeta close_meta = close.getItemMeta();
                                close_meta.setDisplayName(ChatColor.RED + "Close");
                                ArrayList<String> close_lore = new ArrayList<>();
                                close_lore.add(ChatColor.RED + "Cancel Choosing");
                                close_meta.setLore(close_lore);
                                close.setItemMeta(close_meta);

                                ItemMeta next_meta = next.getItemMeta();
                                next_meta.setDisplayName(ChatColor.BLUE + "MENU");
                                ArrayList<String> next_lore = new ArrayList<>();
                                next_lore.add(ChatColor.WHITE + "All Origins");
                                next_meta.setLore(next_lore);
                                next.setItemMeta(next_meta);

                                ItemMeta human_meta = human.getItemMeta();
                                human_meta.setDisplayName("Human");
                                ArrayList<String> human_lore = new ArrayList<>();
                                human_lore.add(ChatColor.WHITE + "Human Origin");
                                human_meta.setLore(human_lore);
                                human.setItemMeta(human_meta);


                                ItemStack[] humangui_items = {close, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, orb, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, close, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, human, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, blank, blank, human_origin_info, blank, blank, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, blank, blank, blank, blank, blank, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, next, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE};
                                humangui.setContents(humangui_items);
                                p.openInventory(humangui);
                            }
                        }
                    }
                }
            }
        }

    }


    @EventHandler
    public void onMenuClick(InventoryClickEvent e) {
        Player p = (Player) e.getWhoClicked();
//Origins Human Menu
        if (e.getView().getTitle().equalsIgnoreCase(ChatColor.BLACK + "Origins Rechoosing")) {
//All-Menu-Button-Open
            if (e.getCurrentItem() != null) {
                if (e.getCurrentItem().getType() == Material.ARROW) {
                    p.playSound(p.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 10, 9);
                    Inventory allmenu = Bukkit.createInventory(p, 18, ChatColor.BLACK + "Origins Rechoosing Menu");

                    ItemStack human = new ItemStack(Material.PLAYER_HEAD);
                    ItemStack enderian = new ItemStack(Material.ENDER_PEARL);
                    ItemStack shulker = new ItemStack(Material.SHULKER_SHELL);
                    ItemStack arachnid = new ItemStack(Material.COBWEB);
                    ItemStack creep = new ItemStack(Material.GUNPOWDER);
                    ItemStack phantom = new ItemStack(Material.PHANTOM_MEMBRANE);
                    ItemStack slimeling = new ItemStack(Material.SLIME_BALL);
                    ItemStack vexian = new ItemStack(Material.IRON_SWORD);
                    ItemStack blazeborn = new ItemStack(Material.BLAZE_POWDER);
                    ItemStack starborne = new ItemStack(Material.NETHER_STAR);
                    ItemStack mermaid = new ItemStack(Material.COD);
                    ItemStack witch = new ItemStack(Material.NETHER_WART);
                    ItemStack rabbit = new ItemStack(Material.CARROT);
                    ItemStack bumblebee = new ItemStack(Material.HONEYCOMB);
                    ItemStack elytrian = new ItemStack(Material.ELYTRA);
                    ItemStack avian = new ItemStack(Material.FEATHER);
                    ItemStack piglin = new ItemStack(Material.GOLD_INGOT);
                    ItemStack dragonborne = new ItemStack(Material.DRAGON_BREATH);

                    ItemMeta human_meta = human.getItemMeta();
                    human_meta.setDisplayName(ChatColor.WHITE + "Human");
                    ArrayList<String> human_lore = new ArrayList<>();
                    human_lore.add(ChatColor.WHITE + "Human Origin");
                    human_meta.setLore(human_lore);
                    human.setItemMeta(human_meta);

                    ItemMeta ender_meta = enderian.getItemMeta();
                    ender_meta.setDisplayName(LIGHT_PURPLE + "Enderian");
                    ArrayList<String> ender_lore = new ArrayList<>();
                    ender_lore.add(ChatColor.WHITE + "Enderman Origin");
                    ender_meta.setLore(ender_lore);
                    enderian.setItemMeta(ender_meta);

                    ItemMeta shulker_meta = shulker.getItemMeta();
                    shulker_meta.setDisplayName(ChatColor.DARK_PURPLE + "Shulker");
                    ArrayList<String> shulker_lore = new ArrayList<>();
                    shulker_lore.add(ChatColor.WHITE + "Shulker Origin");
                    shulker_meta.setLore(shulker_lore);
                    shulker.setItemMeta(shulker_meta);

                    ItemMeta spider_meta = arachnid.getItemMeta();
                    spider_meta.setDisplayName(ChatColor.RED + "Arachnid");
                    ArrayList<String> spider_lore = new ArrayList<>();
                    spider_lore.add(ChatColor.WHITE + "Spider Origin");
                    spider_meta.setLore(spider_lore);
                    arachnid.setItemMeta(spider_meta);

                    ItemMeta creep_meta = creep.getItemMeta();
                    creep_meta.setDisplayName(ChatColor.GREEN + "Creep");
                    ArrayList<String> creep_lore = new ArrayList<>();
                    creep_lore.add(ChatColor.WHITE + "Creeper Origin");
                    creep_meta.setLore(creep_lore);
                    creep.setItemMeta(creep_meta);

                    ItemMeta phantom_meta = phantom.getItemMeta();
                    phantom_meta.setDisplayName(ChatColor.BLUE + "Phantom");
                    ArrayList<String> phantom_lore = new ArrayList<>();
                    phantom_lore.add(ChatColor.WHITE + "Phantom Origin");
                    phantom_meta.setLore(phantom_lore);
                    phantom.setItemMeta(phantom_meta);

                    ItemMeta slime_meta = slimeling.getItemMeta();
                    slime_meta.setDisplayName(ChatColor.GREEN + "Slimeling");
                    ArrayList<String> slime_lore = new ArrayList<>();
                    slime_lore.add(ChatColor.WHITE + "Slime Origin");
                    slime_meta.setLore(slime_lore);
                    slimeling.setItemMeta(slime_meta);

                    ItemMeta vex_meta = vexian.getItemMeta();
                    vex_meta.setDisplayName(ChatColor.AQUA + "Vexian");
                    ArrayList<String> vex_lore = new ArrayList<>();
                    vex_lore.add(ChatColor.WHITE + "Vex Origin");
                    vex_meta.setLore(vex_lore);
                    vexian.setItemMeta(vex_meta);

                    ItemMeta blaze_meta = blazeborn.getItemMeta();
                    blaze_meta.setDisplayName(ChatColor.GOLD + "Blazeborn");
                    ArrayList<String> blaze_lore = new ArrayList<>();
                    blaze_lore.add(ChatColor.WHITE + "Blaze Origin");
                    blaze_meta.setLore(blaze_lore);
                    blazeborn.setItemMeta(blaze_meta);

                    ItemMeta star_meta = starborne.getItemMeta();
                    star_meta.setDisplayName(LIGHT_PURPLE + "Starborne");
                    ArrayList<String> star_lore = new ArrayList<>();
                    star_lore.add(ChatColor.WHITE + "Starborne Origin");
                    star_meta.setLore(star_lore);
                    starborne.setItemMeta(star_meta);

                    ItemMeta mer_meta = mermaid.getItemMeta();
                    mer_meta.setDisplayName(ChatColor.BLUE + "Mermaid");
                    ArrayList<String> mer_lore = new ArrayList<>();
                    mer_lore.add(ChatColor.WHITE + "Mermaid Origin");
                    mer_meta.setLore(mer_lore);
                    mermaid.setItemMeta(mer_meta);

                    ItemMeta witch_meta = witch.getItemMeta();
                    witch_meta.setDisplayName(ChatColor.RED + "Witch");
                    ArrayList<String> witch_lore = new ArrayList<>();
                    witch_lore.add(ChatColor.WHITE + "Witch Origin");
                    witch_meta.setLore(witch_lore);
                    witch.setItemMeta(witch_meta);

                    ItemMeta rabbit_meta = rabbit.getItemMeta();
                    rabbit_meta.setDisplayName(ChatColor.GOLD + "Rabbit");
                    ArrayList<String> rabbit_lore = new ArrayList<>();
                    rabbit_lore.add(ChatColor.WHITE + "Rabbit Origin");
                    rabbit_meta.setLore(rabbit_lore);
                    rabbit.setItemMeta(rabbit_meta);

                    ItemMeta bee_meta = bumblebee.getItemMeta();
                    bee_meta.setDisplayName(ChatColor.YELLOW + "Bumblebee");
                    ArrayList<String> bee_lore = new ArrayList<>();
                    bee_lore.add(ChatColor.WHITE + "Bee Origin");
                    bee_meta.setLore(bee_lore);
                    bumblebee.setItemMeta(bee_meta);

                    ItemMeta elytra_meta = elytrian.getItemMeta();
                    elytra_meta.setDisplayName(ChatColor.GRAY + "Elytrian");
                    ArrayList<String> elytra_lore = new ArrayList<>();
                    elytra_lore.add(ChatColor.WHITE + "Elytra Origin");
                    elytra_meta.setLore(elytra_lore);
                    elytrian.setItemMeta(elytra_meta);

                    ItemMeta avian_meta = avian.getItemMeta();
                    avian_meta.setDisplayName(ChatColor.DARK_AQUA + "Avian");
                    ArrayList<String> avian_lore = new ArrayList<>();
                    avian_lore.add(ChatColor.WHITE + "Avian Origin");
                    avian_meta.setLore(avian_lore);
                    avian.setItemMeta(avian_meta);

                    ItemMeta pig_meta = piglin.getItemMeta();
                    pig_meta.setDisplayName(ChatColor.GOLD + "Piglin");
                    ArrayList<String> pig_lore = new ArrayList<>();
                    pig_lore.add(ChatColor.WHITE + "Piglin Origin");
                    pig_meta.setLore(pig_lore);
                    piglin.setItemMeta(pig_meta);

                    ItemMeta dragonborne_meta = dragonborne.getItemMeta();
                    dragonborne_meta.setDisplayName(ChatColor.DARK_PURPLE + "Dragonborne");
                    ArrayList<String> dragonborne_lore = new ArrayList<>();
                    dragonborne_lore.add(ChatColor.WHITE + "Dragon Origin");
                    dragonborne_meta.setLore(dragonborne_lore);
                    dragonborne.setItemMeta(dragonborne_meta);


                    ItemStack[] allmenu_items = {human, enderian, shulker, arachnid, creep, phantom, slimeling, vexian, blazeborn, starborne, mermaid, witch, rabbit, bumblebee, elytrian, avian, piglin, dragonborne};
                    allmenu.setContents(allmenu_items);

                    p.openInventory(allmenu);
                } else {
                    e.setCancelled(true);
                }

//Close Button
                if (e.getCurrentItem().getType() == Material.BARRIER) {
                    p.closeInventory();
                    p.playSound(p.getLocation(), Sound.BLOCK_NOTE_BLOCK_GUITAR, 10, 9);
                    p.sendMessage(ChatColor.RED + "Choosing canceled!");
                    e.setCancelled(true);
                }
                if (e.getCurrentItem().getType() == Material.GRAY_STAINED_GLASS_PANE) {
                    e.setCancelled(true);
                }
//Choose
                if (e.getCurrentItem().getType() == Material.PLAYER_HEAD || e.getCurrentItem().getType() == Material.ENDER_PEARL || e.getCurrentItem().getType() == Material.SHULKER_SHELL || e.getCurrentItem().getType() == Material.COBWEB || e.getCurrentItem().getType() == Material.GUNPOWDER || e.getCurrentItem().getType() == Material.PHANTOM_MEMBRANE || e.getCurrentItem().getType() == Material.SLIME_BALL || e.getCurrentItem().getType() == Material.IRON_SWORD || e.getCurrentItem().getType() == Material.BLAZE_POWDER || e.getCurrentItem().getType() == Material.NETHER_STAR || e.getCurrentItem().getType() == Material.COD || e.getCurrentItem().getType() == Material.NETHER_WART || e.getCurrentItem().getType() == Material.CARROT || e.getCurrentItem().getType() == Material.HONEYCOMB || e.getCurrentItem().getType() == Material.ELYTRA || e.getCurrentItem().getType() == Material.FEATHER || e.getCurrentItem().getType() == Material.GOLD_INGOT || e.getCurrentItem().getType() == Material.DRAGON_BREATH) {
                    p.closeInventory();
                    p.playSound(p.getLocation(), Sound.BLOCK_NOTE_BLOCK_CHIME, 10, 9);
                    p.sendMessage(ChatColor.AQUA + "You have chosen an origin!");
                    p.setCustomNameVisible(false);
                    p.getScoreboardTags().add("chosen");
                    p.getInventory().remove(orb);

                    if (e.getCurrentItem().getType() == Material.ENDER_PEARL) {
                        p.getScoreboardTags().add("enderian");
                        p.getScoreboardTags().remove("shulker");
                        p.getScoreboardTags().remove("human");
                        p.getScoreboardTags().remove("arachnid");
                        p.getScoreboardTags().remove("creep");
                        p.getScoreboardTags().remove("phantom");
                        p.getScoreboardTags().remove("slimeling");
                        p.getScoreboardTags().remove("vexian");
                        p.getScoreboardTags().remove("blazeborn");
                        p.getScoreboardTags().remove("starborne");
                        p.getScoreboardTags().remove("mermaid");
                        p.getScoreboardTags().remove("witch");
                        p.getScoreboardTags().remove("rabbit");
                        p.getScoreboardTags().remove("bee");
                        p.getScoreboardTags().remove("elytrian");
                        p.getScoreboardTags().remove("avian");
                        p.getScoreboardTags().remove("piglin");
                        p.getScoreboardTags().remove("dragonborne");
                        ItemStack infinpearl = new ItemStack(ENDER_PEARL);
                        ItemMeta pearl_meta = infinpearl.getItemMeta();
                        pearl_meta.setDisplayName(ChatColor.LIGHT_PURPLE + "Teleport");
                        ArrayList<String> pearl_lore = new ArrayList<>();
                        pearl_meta.setUnbreakable(true);
                        pearl_meta.addEnchant(Enchantment.ARROW_INFINITE, 1, true);
                        pearl_meta.setLore(pearl_lore);
                        infinpearl.setItemMeta(pearl_meta);
                        p.getInventory().addItem(infinpearl);
                    }
                    if (e.getCurrentItem().getType() == Material.SHULKER_SHELL) {
                        p.getScoreboardTags().add("shulker");
                        p.getScoreboardTags().remove("enderian");
                        p.getScoreboardTags().remove("human");
                        p.getScoreboardTags().remove("arachnid");
                        p.getScoreboardTags().remove("creep");
                        p.getScoreboardTags().remove("phantom");
                        p.getScoreboardTags().remove("slimeling");
                        p.getScoreboardTags().remove("vexian");
                        p.getScoreboardTags().remove("blazeborn");
                        p.getScoreboardTags().remove("starborne");
                        p.getScoreboardTags().remove("mermaid");
                        p.getScoreboardTags().remove("witch");
                        p.getScoreboardTags().remove("rabbit");
                        p.getScoreboardTags().remove("bee");
                        p.getScoreboardTags().remove("elytrian");
                        p.getScoreboardTags().remove("avian");
                        p.getScoreboardTags().remove("piglin");
                        p.getScoreboardTags().remove("dragonborne");
                    }
                    if (e.getCurrentItem().getType() == Material.PLAYER_HEAD) {
                        p.getScoreboardTags().add("human");
                        p.getScoreboardTags().remove("enderian");
                        p.getScoreboardTags().remove("shulker");
                        p.getScoreboardTags().remove("arachnid");
                        p.getScoreboardTags().remove("creep");
                        p.getScoreboardTags().remove("phantom");
                        p.getScoreboardTags().remove("slimeling");
                        p.getScoreboardTags().remove("vexian");
                        p.getScoreboardTags().remove("blazeborn");
                        p.getScoreboardTags().remove("starborne");
                        p.getScoreboardTags().remove("mermaid");
                        p.getScoreboardTags().remove("witch");
                        p.getScoreboardTags().remove("rabbit");
                        p.getScoreboardTags().remove("bee");
                        p.getScoreboardTags().remove("elytrian");
                        p.getScoreboardTags().remove("avian");
                        p.getScoreboardTags().remove("piglin");
                        p.getScoreboardTags().remove("dragonborne");
                    }
                    if (e.getCurrentItem().getType() == Material.COBWEB) {
                        p.getScoreboardTags().add("arachnid");
                        p.getScoreboardTags().remove("enderian");
                        p.getScoreboardTags().remove("shulker");
                        p.getScoreboardTags().remove("human");
                        p.getScoreboardTags().remove("creep");
                        p.getScoreboardTags().remove("phantom");
                        p.getScoreboardTags().remove("slimeling");
                        p.getScoreboardTags().remove("vexian");
                        p.getScoreboardTags().remove("blazeborn");
                        p.getScoreboardTags().remove("starborne");
                        p.getScoreboardTags().remove("mermaid");
                        p.getScoreboardTags().remove("witch");
                        p.getScoreboardTags().remove("rabbit");
                        p.getScoreboardTags().remove("bee");
                        p.getScoreboardTags().remove("elytrian");
                        p.getScoreboardTags().remove("avian");
                        p.getScoreboardTags().remove("piglin");
                        p.getScoreboardTags().remove("dragonborne");
                    }
                    if (e.getCurrentItem().getType() == Material.GUNPOWDER) {
                        p.getScoreboardTags().add("creep");
                        p.getScoreboardTags().remove("enderian");
                        p.getScoreboardTags().remove("shulker");
                        p.getScoreboardTags().remove("arachnid");
                        p.getScoreboardTags().remove("human");
                        p.getScoreboardTags().remove("phantom");
                        p.getScoreboardTags().remove("slimeling");
                        p.getScoreboardTags().remove("vexian");
                        p.getScoreboardTags().remove("blazeborn");
                        p.getScoreboardTags().remove("starborne");
                        p.getScoreboardTags().remove("mermaid");
                        p.getScoreboardTags().remove("witch");
                        p.getScoreboardTags().remove("rabbit");
                        p.getScoreboardTags().remove("bee");
                        p.getScoreboardTags().remove("elytrian");
                        p.getScoreboardTags().remove("avian");
                        p.getScoreboardTags().remove("piglin");
                        p.getScoreboardTags().remove("dragonborne");
                    }
                    if (e.getCurrentItem().getType() == Material.PHANTOM_MEMBRANE) {
                        p.getScoreboardTags().add("phantom");
                        p.getScoreboardTags().remove("enderian");
                        p.getScoreboardTags().remove("shulker");
                        p.getScoreboardTags().remove("arachnid");
                        p.getScoreboardTags().remove("creep");
                        p.getScoreboardTags().remove("human");
                        p.getScoreboardTags().remove("slimeling");
                        p.getScoreboardTags().remove("vexian");
                        p.getScoreboardTags().remove("blazeborn");
                        p.getScoreboardTags().remove("starborne");
                        p.getScoreboardTags().remove("mermaid");
                        p.getScoreboardTags().remove("witch");
                        p.getScoreboardTags().remove("rabbit");
                        p.getScoreboardTags().remove("bee");
                        p.getScoreboardTags().remove("elytrian");
                        p.getScoreboardTags().remove("avian");
                        p.getScoreboardTags().remove("piglin");
                        p.getScoreboardTags().remove("dragonborne");
                    }
                    if (e.getCurrentItem().getType() == Material.SLIME_BALL) {
                        p.getScoreboardTags().add("slimeling");
                        p.getScoreboardTags().remove("enderian");
                        p.getScoreboardTags().remove("shulker");
                        p.getScoreboardTags().remove("arachnid");
                        p.getScoreboardTags().remove("creep");
                        p.getScoreboardTags().remove("phantom");
                        p.getScoreboardTags().remove("human");
                        p.getScoreboardTags().remove("vexian");
                        p.getScoreboardTags().remove("blazeborn");
                        p.getScoreboardTags().remove("starborne");
                        p.getScoreboardTags().remove("mermaid");
                        p.getScoreboardTags().remove("witch");
                        p.getScoreboardTags().remove("rabbit");
                        p.getScoreboardTags().remove("bee");
                        p.getScoreboardTags().remove("elytrian");
                        p.getScoreboardTags().remove("avian");
                        p.getScoreboardTags().remove("piglin");
                        p.getScoreboardTags().remove("dragonborne");
                    }
                    if (e.getCurrentItem().getType() == Material.IRON_SWORD) {
                        p.getScoreboardTags().add("vexian");
                        p.getScoreboardTags().remove("enderian");
                        p.getScoreboardTags().remove("shulker");
                        p.getScoreboardTags().remove("arachnid");
                        p.getScoreboardTags().remove("creep");
                        p.getScoreboardTags().remove("phantom");
                        p.getScoreboardTags().remove("slimeling");
                        p.getScoreboardTags().remove("human");
                        p.getScoreboardTags().remove("blazeborn");
                        p.getScoreboardTags().remove("starborne");
                        p.getScoreboardTags().remove("mermaid");
                        p.getScoreboardTags().remove("witch");
                        p.getScoreboardTags().remove("rabbit");
                        p.getScoreboardTags().remove("bee");
                        p.getScoreboardTags().remove("elytrian");
                        p.getScoreboardTags().remove("avian");
                        p.getScoreboardTags().remove("piglin");
                        p.getScoreboardTags().remove("dragonborne");
                    }
                    if (e.getCurrentItem().getType() == Material.BLAZE_POWDER) {
                        p.getScoreboardTags().add("blazeborn");
                        p.getScoreboardTags().remove("enderian");
                        p.getScoreboardTags().remove("shulker");
                        p.getScoreboardTags().remove("arachnid");
                        p.getScoreboardTags().remove("creep");
                        p.getScoreboardTags().remove("phantom");
                        p.getScoreboardTags().remove("slimeling");
                        p.getScoreboardTags().remove("vexian");
                        p.getScoreboardTags().remove("human");
                        p.getScoreboardTags().remove("starborne");
                        p.getScoreboardTags().remove("mermaid");
                        p.getScoreboardTags().remove("witch");
                        p.getScoreboardTags().remove("rabbit");
                        p.getScoreboardTags().remove("bee");
                        p.getScoreboardTags().remove("elytrian");
                        p.getScoreboardTags().remove("avian");
                        p.getScoreboardTags().remove("piglin");
                        p.getScoreboardTags().remove("dragonborne");
                    }
                    if (e.getCurrentItem().getType() == Material.NETHER_STAR) {
                        p.getScoreboardTags().add("starborne");
                        p.getScoreboardTags().remove("enderian");
                        p.getScoreboardTags().remove("shulker");
                        p.getScoreboardTags().remove("arachnid");
                        p.getScoreboardTags().remove("creep");
                        p.getScoreboardTags().remove("phantom");
                        p.getScoreboardTags().remove("slimeling");
                        p.getScoreboardTags().remove("vexian");
                        p.getScoreboardTags().remove("blazeborn");
                        p.getScoreboardTags().remove("human");
                        p.getScoreboardTags().remove("mermaid");
                        p.getScoreboardTags().remove("witch");
                        p.getScoreboardTags().remove("rabbit");
                        p.getScoreboardTags().remove("bee");
                        p.getScoreboardTags().remove("elytrian");
                        p.getScoreboardTags().remove("avian");
                        p.getScoreboardTags().remove("piglin");
                        p.getScoreboardTags().remove("dragonborne");
                    }
                    if (e.getCurrentItem().getType() == Material.COD) {
                        p.getScoreboardTags().add("mermaid");
                        p.getScoreboardTags().remove("enderian");
                        p.getScoreboardTags().remove("shulker");
                        p.getScoreboardTags().remove("arachnid");
                        p.getScoreboardTags().remove("creep");
                        p.getScoreboardTags().remove("phantom");
                        p.getScoreboardTags().remove("slimeling");
                        p.getScoreboardTags().remove("vexian");
                        p.getScoreboardTags().remove("blazeborn");
                        p.getScoreboardTags().remove("starborne");
                        p.getScoreboardTags().remove("human");
                        p.getScoreboardTags().remove("witch");
                        p.getScoreboardTags().remove("rabbit");
                        p.getScoreboardTags().remove("bee");
                        p.getScoreboardTags().remove("elytrian");
                        p.getScoreboardTags().remove("avian");
                        p.getScoreboardTags().remove("piglin");
                        p.getScoreboardTags().remove("dragonborne");
                    }
                    if (e.getCurrentItem().getType() == Material.NETHER_WART) {
                        p.getScoreboardTags().add("witch");
                        p.getScoreboardTags().remove("enderian");
                        p.getScoreboardTags().remove("shulker");
                        p.getScoreboardTags().remove("arachnid");
                        p.getScoreboardTags().remove("creep");
                        p.getScoreboardTags().remove("phantom");
                        p.getScoreboardTags().remove("slimeling");
                        p.getScoreboardTags().remove("vexian");
                        p.getScoreboardTags().remove("blazeborn");
                        p.getScoreboardTags().remove("starborne");
                        p.getScoreboardTags().remove("mermaid");
                        p.getScoreboardTags().remove("human");
                        p.getScoreboardTags().remove("rabbit");
                        p.getScoreboardTags().remove("bee");
                        p.getScoreboardTags().remove("elytrian");
                        p.getScoreboardTags().remove("avian");
                        p.getScoreboardTags().remove("piglin");
                        p.getScoreboardTags().remove("dragonborne");

                    }
                    if (e.getCurrentItem().getType() == Material.CARROT) {
                        p.getScoreboardTags().add("rabbit");
                        p.getScoreboardTags().remove("enderian");
                        p.getScoreboardTags().remove("shulker");
                        p.getScoreboardTags().remove("arachnid");
                        p.getScoreboardTags().remove("creep");
                        p.getScoreboardTags().remove("phantom");
                        p.getScoreboardTags().remove("slimeling");
                        p.getScoreboardTags().remove("vexian");
                        p.getScoreboardTags().remove("blazeborn");
                        p.getScoreboardTags().remove("starborne");
                        p.getScoreboardTags().remove("mermaid");
                        p.getScoreboardTags().remove("witch");
                        p.getScoreboardTags().remove("human");
                        p.getScoreboardTags().remove("bee");
                        p.getScoreboardTags().remove("elytrian");
                        p.getScoreboardTags().remove("avian");
                        p.getScoreboardTags().remove("piglin");
                        p.getScoreboardTags().remove("dragonborne");
                    }
                    if (e.getCurrentItem().getType() == Material.HONEYCOMB) {
                        p.getScoreboardTags().add("bee");
                        p.getScoreboardTags().remove("enderian");
                        p.getScoreboardTags().remove("shulker");
                        p.getScoreboardTags().remove("arachnid");
                        p.getScoreboardTags().remove("creep");
                        p.getScoreboardTags().remove("phantom");
                        p.getScoreboardTags().remove("slimeling");
                        p.getScoreboardTags().remove("vexian");
                        p.getScoreboardTags().remove("blazeborn");
                        p.getScoreboardTags().remove("starborne");
                        p.getScoreboardTags().remove("mermaid");
                        p.getScoreboardTags().remove("witch");
                        p.getScoreboardTags().remove("rabbit");
                        p.getScoreboardTags().remove("human");
                        p.getScoreboardTags().remove("elytrian");
                        p.getScoreboardTags().remove("avian");
                        p.getScoreboardTags().remove("piglin");
                        p.getScoreboardTags().remove("dragonborne");
                    }
                    if (e.getCurrentItem().getType() == Material.ELYTRA) {
                        p.getScoreboardTags().add("elytrian");
                        p.getScoreboardTags().remove("enderian");
                        p.getScoreboardTags().remove("shulker");
                        p.getScoreboardTags().remove("arachnid");
                        p.getScoreboardTags().remove("creep");
                        p.getScoreboardTags().remove("phantom");
                        p.getScoreboardTags().remove("slimeling");
                        p.getScoreboardTags().remove("vexian");
                        p.getScoreboardTags().remove("blazeborn");
                        p.getScoreboardTags().remove("starborne");
                        p.getScoreboardTags().remove("mermaid");
                        p.getScoreboardTags().remove("witch");
                        p.getScoreboardTags().remove("rabbit");
                        p.getScoreboardTags().remove("bee");
                        p.getScoreboardTags().remove("human");
                        p.getScoreboardTags().remove("avian");
                        p.getScoreboardTags().remove("piglin");
                        p.getScoreboardTags().remove("dragonborne");
                    }
                    if (e.getCurrentItem().getType() == Material.FEATHER) {
                        p.getScoreboardTags().add("avian");
                        p.getScoreboardTags().remove("enderian");
                        p.getScoreboardTags().remove("shulker");
                        p.getScoreboardTags().remove("arachnid");
                        p.getScoreboardTags().remove("creep");
                        p.getScoreboardTags().remove("phantom");
                        p.getScoreboardTags().remove("slimeling");
                        p.getScoreboardTags().remove("vexian");
                        p.getScoreboardTags().remove("blazeborn");
                        p.getScoreboardTags().remove("starborne");
                        p.getScoreboardTags().remove("mermaid");
                        p.getScoreboardTags().remove("witch");
                        p.getScoreboardTags().remove("rabbit");
                        p.getScoreboardTags().remove("bee");
                        p.getScoreboardTags().remove("elytrian");
                        p.getScoreboardTags().remove("human");
                        p.getScoreboardTags().remove("piglin");
                        p.getScoreboardTags().remove("dragonborne");
                    }
                    if (e.getCurrentItem().getType() == Material.GOLD_INGOT) {
                        p.getScoreboardTags().add("piglin");
                        p.getScoreboardTags().remove("enderian");
                        p.getScoreboardTags().remove("shulker");
                        p.getScoreboardTags().remove("arachnid");
                        p.getScoreboardTags().remove("creep");
                        p.getScoreboardTags().remove("phantom");
                        p.getScoreboardTags().remove("slimeling");
                        p.getScoreboardTags().remove("vexian");
                        p.getScoreboardTags().remove("blazeborn");
                        p.getScoreboardTags().remove("starborne");
                        p.getScoreboardTags().remove("mermaid");
                        p.getScoreboardTags().remove("witch");
                        p.getScoreboardTags().remove("rabbit");
                        p.getScoreboardTags().remove("bee");
                        p.getScoreboardTags().remove("elytrian");
                        p.getScoreboardTags().remove("avian");
                        p.getScoreboardTags().remove("human");
                        p.getScoreboardTags().remove("dragonborne");
                    }
                    if (e.getCurrentItem().getType() == Material.DRAGON_BREATH) {
                        p.getScoreboardTags().add("dragonborne");
                        p.getScoreboardTags().remove("enderian");
                        p.getScoreboardTags().remove("shulker");
                        p.getScoreboardTags().remove("arachnid");
                        p.getScoreboardTags().remove("creep");
                        p.getScoreboardTags().remove("phantom");
                        p.getScoreboardTags().remove("slimeling");
                        p.getScoreboardTags().remove("vexian");
                        p.getScoreboardTags().remove("blazeborn");
                        p.getScoreboardTags().remove("starborne");
                        p.getScoreboardTags().remove("mermaid");
                        p.getScoreboardTags().remove("witch");
                        p.getScoreboardTags().remove("rabbit");
                        p.getScoreboardTags().remove("bee");
                        p.getScoreboardTags().remove("elytrian");
                        p.getScoreboardTags().remove("avian");
                        p.getScoreboardTags().remove("piglin");
                        p.getScoreboardTags().remove("human");
                    }
                }
            }
        }


//Check if on MENU-GUI

        if (e.getView().getTitle().equalsIgnoreCase(ChatColor.BLACK + "Origins Rechoosing Menu")) {
            //Human
            if (e.getCurrentItem() != null) {
                if (e.getCurrentItem().getType() == Material.PLAYER_HEAD) {
                    e.setCancelled(true);
                    p.playSound(p.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 10, 9);
                    Inventory humangui = Bukkit.createInventory(p, 54, ChatColor.BLACK + "Origins Rechoosing");

                    ItemStack close = new ItemStack(Material.BARRIER);
                    ItemStack next = new ItemStack(Material.ARROW);
                    ItemStack back = new ItemStack(Material.ARROW);
                    ItemStack human = new ItemStack(Material.PLAYER_HEAD);
                    ItemStack GRAY_STAINED_GLASS_PANE = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);
                    ItemStack human_origin_info = new ItemStack(Material.FILLED_MAP);
                    ItemStack blank = new ItemStack(Material.PAPER);
                    ItemStack orb = new ItemStack(Material.MAGMA_CREAM);

                    ItemStack item = new ItemStack(Material.MAGMA_CREAM, 1);
                    ItemMeta meta = item.getItemMeta();
                    meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
                    meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
                    meta.addItemFlags(ItemFlag.HIDE_DESTROYS);
                    meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                    meta.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
                    meta.addItemFlags(ItemFlag.HIDE_PLACED_ON);
                    meta.setDisplayName(ChatColor.LIGHT_PURPLE + "Orb of Origins");
                    meta.setUnbreakable(true);
                    meta.addEnchant(Enchantment.ARROW_INFINITE, 1, true);
                    List<String> lore = new ArrayList<>();
                    item.setItemMeta(meta);
                    orb = item;

                    ItemMeta human_origin_info_meta = human_origin_info.getItemMeta();
                    human_origin_info_meta.setDisplayName("NOTHING");
                    ArrayList<String> human_origin_info_lore = new ArrayList<>();
                    human_origin_info_lore.add(ChatColor.WHITE + "You have no powers");
                    human_origin_info_meta.setLore(human_origin_info_lore);
                    human_origin_info.setItemMeta(human_origin_info_meta);

                    ItemMeta close_meta = close.getItemMeta();
                    close_meta.setDisplayName(ChatColor.RED + "Close");
                    ArrayList<String> close_lore = new ArrayList<>();
                    close_lore.add(ChatColor.RED + "Cancel Choosing");
                    close_meta.setLore(close_lore);
                    close.setItemMeta(close_meta);

                    ItemMeta next_meta = next.getItemMeta();
                    next_meta.setDisplayName(ChatColor.BLUE + "MENU");
                    ArrayList<String> next_lore = new ArrayList<>();
                    next_lore.add(ChatColor.WHITE + "All Origins");
                    next_meta.setLore(next_lore);
                    next.setItemMeta(next_meta);

                    ItemMeta human_meta = human.getItemMeta();
                    human_meta.setDisplayName("Human");
                    ArrayList<String> human_lore = new ArrayList<>();
                    human_lore.add(ChatColor.WHITE + "Human Origin");
                    human_meta.setLore(human_lore);
                    human.setItemMeta(human_meta);


                    ItemStack[] humangui_items = {close, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, orb, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, close, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, human, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, blank, blank, human_origin_info, blank, blank, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, blank, blank, blank, blank, blank, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, next, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE};
                    humangui.setContents(humangui_items);
                    p.openInventory(humangui);
                }
                //Enderian
                if (e.getCurrentItem().getType() == Material.ENDER_PEARL) {
                    e.setCancelled(true);
                    p.playSound(p.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 10, 9);
                    Inventory endergui = Bukkit.createInventory(p, 54, ChatColor.BLACK + "Origins Rechoosing");

                    ItemStack close = new ItemStack(Material.BARRIER);
                    ItemStack next = new ItemStack(Material.ARROW);
                    ItemStack ender = new ItemStack(Material.ENDER_PEARL);
                    ItemStack GRAY_STAINED_GLASS_PANE = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);
                    ItemStack ender_origin_info1 = new ItemStack(Material.FILLED_MAP);
                    ItemStack blank = new ItemStack(Material.PAPER);
                    ItemStack orb = new ItemStack(Material.MAGMA_CREAM);
                    ItemStack ender_origin_info2 = new ItemStack(Material.FILLED_MAP);
                    ItemStack ender_origin_info3 = new ItemStack(Material.FILLED_MAP);
                    ItemStack ender_origin_info4 = new ItemStack(Material.FILLED_MAP);
                    ItemStack ender_origin_info5 = new ItemStack(Material.FILLED_MAP);

                    ItemStack item = new ItemStack(Material.MAGMA_CREAM, 1);
                    ItemMeta meta = item.getItemMeta();
                    meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
                    meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
                    meta.addItemFlags(ItemFlag.HIDE_DESTROYS);
                    meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                    meta.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
                    meta.addItemFlags(ItemFlag.HIDE_PLACED_ON);
                    meta.setDisplayName(ChatColor.LIGHT_PURPLE + "Orb of Origins");
                    meta.setUnbreakable(true);
                    meta.addEnchant(Enchantment.ARROW_INFINITE, 1, true);
                    List<String> lore = new ArrayList<>();
                    item.setItemMeta(meta);
                    orb = item;

                    ItemMeta ender_origin_info1_meta = ender_origin_info1.getItemMeta();
                    ender_origin_info1_meta.setDisplayName("Teleport");
                    ArrayList<String> ender_origin_info1_lore = new ArrayList<>();
                    ender_origin_info1_lore.add(ChatColor.WHITE + "You have an infinite ender pearl that alows you to teleport with no damage");
                    ender_origin_info1_meta.setLore(ender_origin_info1_lore);
                    ender_origin_info1.setItemMeta(ender_origin_info1_meta);

                    ItemMeta ender_origin_info2_meta = ender_origin_info2.getItemMeta();
                    ender_origin_info2_meta.setDisplayName("Hydrophobia");
                    ArrayList<String> ender_origin_info2_lore = new ArrayList<>();
                    ender_origin_info2_lore.add(ChatColor.WHITE + "You will take damage while in contact with water");
                    ender_origin_info2_meta.setLore(ender_origin_info2_lore);
                    ender_origin_info2.setItemMeta(ender_origin_info2_meta);

                    ItemMeta ender_origin_info3_meta = ender_origin_info3.getItemMeta();
                    ender_origin_info3_meta.setDisplayName("Slender Body");
                    ArrayList<String> ender_origin_info3_lore = new ArrayList<>();
                    ender_origin_info3_lore.add(ChatColor.WHITE + "You can reach blocks and entities further away");
                    ender_origin_info3_meta.setLore(ender_origin_info3_lore);
                    ender_origin_info3.setItemMeta(ender_origin_info3_meta);

                    ItemMeta ender_origin_info4_meta = ender_origin_info4.getItemMeta();
                    ender_origin_info4_meta.setDisplayName("Scared of Gourds");
                    ArrayList<String> ender_origin_info4_lore = new ArrayList<>();
                    ender_origin_info4_lore.add(ChatColor.WHITE + "You take damage from pumpkins");
                    ender_origin_info4_meta.setLore(ender_origin_info4_lore);
                    ender_origin_info4.setItemMeta(ender_origin_info4_meta);

                    ItemMeta ender_origin_info5_meta = ender_origin_info5.getItemMeta();
                    ender_origin_info5_meta.setDisplayName("Bearer of Pearls");
                    ArrayList<String> ender_origin_info5_lore = new ArrayList<>();
                    ender_origin_info5_lore.add(ChatColor.WHITE + "You always drop 0-2 ender pearls upon death");
                    ender_origin_info5_meta.setLore(ender_origin_info5_lore);
                    ender_origin_info5.setItemMeta(ender_origin_info5_meta);

                    ItemMeta close_meta = close.getItemMeta();
                    close_meta.setDisplayName(ChatColor.RED + "Close");
                    ArrayList<String> close_lore = new ArrayList<>();
                    close_lore.add(ChatColor.RED + "Cancel Choosing");
                    close_meta.setLore(close_lore);
                    close.setItemMeta(close_meta);

                    ItemMeta next_meta = next.getItemMeta();
                    next_meta.setDisplayName(ChatColor.BLUE + "MENU");
                    ArrayList<String> next_lore = new ArrayList<>();
                    next_lore.add(ChatColor.WHITE + "All Origins");
                    next_meta.setLore(next_lore);
                    next.setItemMeta(next_meta);

                    ItemMeta ender_meta = ender.getItemMeta();
                    ender_meta.setDisplayName("Enderian");
                    ArrayList<String> ender_lore = new ArrayList<>();
                    ender_lore.add(LIGHT_PURPLE + "Enderman Origin");
                    ender_meta.setLore(ender_lore);
                    ender.setItemMeta(ender_meta);


                    ItemStack[] endergui_items = {close, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, orb, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, close, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, ender, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, ender_origin_info1, ender_origin_info2, ender_origin_info3, ender_origin_info4, ender_origin_info5, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, blank, blank, blank, blank, blank, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, next, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE};
                    endergui.setContents(endergui_items);
                    p.openInventory(endergui);
                }
                //shulker
                if (e.getCurrentItem().getType() == Material.SHULKER_SHELL) {
                    e.setCancelled(true);
                    p.playSound(p.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 10, 9);
                    Inventory shulkgui = Bukkit.createInventory(p, 54, ChatColor.BLACK + "Origins Rechoosing");

                    ItemStack close = new ItemStack(Material.BARRIER);
                    ItemStack next = new ItemStack(Material.ARROW);
                    ItemStack shulk = new ItemStack(Material.SHULKER_SHELL);
                    ItemStack GRAY_STAINED_GLASS_PANE = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);
                    ItemStack blank = new ItemStack(Material.PAPER);
                    ItemStack orb = new ItemStack(Material.MAGMA_CREAM);
                    ItemStack shulk_origin_info1 = new ItemStack(Material.FILLED_MAP);
                    ItemStack shulk_origin_info2 = new ItemStack(Material.FILLED_MAP);
                    ItemStack shulk_origin_info3 = new ItemStack(Material.FILLED_MAP);
                    ItemStack shulk_origin_info4 = new ItemStack(Material.FILLED_MAP);
                    ItemStack shulk_origin_info5 = new ItemStack(Material.FILLED_MAP);

                    ItemStack item = new ItemStack(Material.MAGMA_CREAM, 1);
                    ItemMeta meta = item.getItemMeta();
                    meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
                    meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
                    meta.addItemFlags(ItemFlag.HIDE_DESTROYS);
                    meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                    meta.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
                    meta.addItemFlags(ItemFlag.HIDE_PLACED_ON);
                    meta.setDisplayName(ChatColor.LIGHT_PURPLE + "Orb of Origins");
                    meta.setUnbreakable(true);
                    meta.addEnchant(Enchantment.ARROW_INFINITE, 1, true);
                    List<String> lore = new ArrayList<>();
                    item.setItemMeta(meta);
                    orb = item;

                    ItemMeta shulk_origin_info1_meta = shulk_origin_info1.getItemMeta();
                    shulk_origin_info1_meta.setDisplayName("Hoarder");
                    ArrayList<String> shulk_origin_info1_lore = new ArrayList<>();
                    shulk_origin_info1_lore.add(ChatColor.WHITE + "You have 9 more inventory slots, which you keep upon death");
                    shulk_origin_info1_meta.setLore(shulk_origin_info1_lore);
                    shulk_origin_info1.setItemMeta(shulk_origin_info1_meta);

                    ItemMeta shulk_origin_info2_meta = shulk_origin_info2.getItemMeta();
                    shulk_origin_info2_meta.setDisplayName("Sturdy Skin");
                    ArrayList<String> shulk_origin_info2_lore = new ArrayList<>();
                    shulk_origin_info2_lore.add(ChatColor.WHITE + "Even without wearing armour, your skin provides natural protection");
                    shulk_origin_info2_meta.setLore(shulk_origin_info2_lore);
                    shulk_origin_info2.setItemMeta(shulk_origin_info2_meta);

                    ItemMeta shulk_origin_info3_meta = shulk_origin_info3.getItemMeta();
                    shulk_origin_info3_meta.setDisplayName("Strong Arms");
                    ArrayList<String> shulk_origin_info3_lore = new ArrayList<>();
                    shulk_origin_info3_lore.add(ChatColor.WHITE + "You are strong enough to break natural stones without using a pickaxe");
                    shulk_origin_info3_meta.setLore(shulk_origin_info3_lore);
                    shulk_origin_info3.setItemMeta(shulk_origin_info3_meta);

                    ItemMeta shulk_origin_info4_meta = shulk_origin_info4.getItemMeta();
                    shulk_origin_info4_meta.setDisplayName("Unwieldy");
                    ArrayList<String> shulk_origin_info4_lore = new ArrayList<>();
                    shulk_origin_info4_lore.add(ChatColor.WHITE + "You cannot hold a shield");
                    shulk_origin_info4_meta.setLore(shulk_origin_info4_lore);
                    shulk_origin_info4.setItemMeta(shulk_origin_info4_meta);

                    ItemMeta shulk_origin_info5_meta = shulk_origin_info5.getItemMeta();
                    shulk_origin_info5_meta.setDisplayName("Large Appetite");
                    ArrayList<String> shulk_origin_info5_lore = new ArrayList<>();
                    shulk_origin_info5_lore.add(ChatColor.WHITE + "You exhaust much quicker than others, meaning you have to eat more often");
                    shulk_origin_info5_meta.setLore(shulk_origin_info5_lore);
                    shulk_origin_info5.setItemMeta(shulk_origin_info5_meta);

                    ItemMeta close_meta = close.getItemMeta();
                    close_meta.setDisplayName(ChatColor.RED + "Close");
                    ArrayList<String> close_lore = new ArrayList<>();
                    close_lore.add(ChatColor.RED + "Cancel Choosing");
                    close_meta.setLore(close_lore);
                    close.setItemMeta(close_meta);

                    ItemMeta next_meta = next.getItemMeta();
                    next_meta.setDisplayName(ChatColor.BLUE + "MENU");
                    ArrayList<String> next_lore = new ArrayList<>();
                    next_lore.add(ChatColor.WHITE + "All Origins");
                    next_meta.setLore(next_lore);
                    next.setItemMeta(next_meta);

                    ItemMeta shulk_meta = shulk.getItemMeta();
                    shulk_meta.setDisplayName("Shulker");
                    ArrayList<String> shulk_lore = new ArrayList<>();
                    shulk_lore.add(LIGHT_PURPLE + "Shulker Origin");
                    shulk_meta.setLore(shulk_lore);
                    shulk.setItemMeta(shulk_meta);


                    ItemStack[] shulkgui_items = {close, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, orb, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, close, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, shulk, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, shulk_origin_info1, shulk_origin_info2, shulk_origin_info3, shulk_origin_info4, shulk_origin_info5, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, blank, blank, blank, blank, blank, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, next, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE};
                    shulkgui.setContents(shulkgui_items);
                    p.openInventory(shulkgui);
                }
                //spider
                if (e.getCurrentItem().getType() == Material.COBWEB) {
                    e.setCancelled(true);
                    p.playSound(p.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 10, 9);
                    Inventory spidergui = Bukkit.createInventory(p, 54, ChatColor.BLACK + "Origins Rechoosing");

                    ItemStack close = new ItemStack(Material.BARRIER);
                    ItemStack next = new ItemStack(Material.ARROW);
                    ItemStack spider = new ItemStack(Material.COBWEB);
                    ItemStack GRAY_STAINED_GLASS_PANE = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);
                    ItemStack blank = new ItemStack(Material.PAPER);
                    ItemStack orb = new ItemStack(Material.MAGMA_CREAM);
                    ItemStack spider_origin_info1 = new ItemStack(Material.FILLED_MAP);
                    ItemStack spider_origin_info2 = new ItemStack(Material.FILLED_MAP);
                    ItemStack spider_origin_info3 = new ItemStack(Material.FILLED_MAP);
                    ItemStack spider_origin_info4 = new ItemStack(Material.FILLED_MAP);
                    ItemStack spider_origin_info5 = new ItemStack(Material.FILLED_MAP);

                    ItemStack item = new ItemStack(Material.MAGMA_CREAM, 1);
                    ItemMeta meta = item.getItemMeta();
                    meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
                    meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
                    meta.addItemFlags(ItemFlag.HIDE_DESTROYS);
                    meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                    meta.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
                    meta.addItemFlags(ItemFlag.HIDE_PLACED_ON);
                    meta.setDisplayName(ChatColor.LIGHT_PURPLE + "Orb of Origins");
                    meta.setUnbreakable(true);
                    meta.addEnchant(Enchantment.ARROW_INFINITE, 1, true);
                    List<String> lore = new ArrayList<>();
                    item.setItemMeta(meta);
                    orb = item;

                    ItemMeta spider_origin_info1_meta = spider_origin_info1.getItemMeta();
                    spider_origin_info1_meta.setDisplayName("Ittsy Bittsy Spider");
                    ArrayList<String> spider_origin_info1_lore = new ArrayList<>();
                    spider_origin_info1_lore.add(ChatColor.WHITE + "You can climb up walls");
                    spider_origin_info1_meta.setLore(spider_origin_info1_lore);
                    spider_origin_info1.setItemMeta(spider_origin_info1_meta);

                    ItemMeta spider_origin_info2_meta = spider_origin_info2.getItemMeta();
                    spider_origin_info2_meta.setDisplayName("Weaver");
                    ArrayList<String> spider_origin_info2_lore = new ArrayList<>();
                    spider_origin_info2_lore.add(ChatColor.WHITE + "Hinders foes with cobweb on attack");
                    spider_origin_info2_meta.setLore(spider_origin_info2_lore);
                    spider_origin_info2.setItemMeta(spider_origin_info2_meta);

                    ItemMeta spider_origin_info3_meta = spider_origin_info3.getItemMeta();
                    spider_origin_info3_meta.setDisplayName("Squishable");
                    ArrayList<String> spider_origin_info3_lore = new ArrayList<>();
                    spider_origin_info3_lore.add(ChatColor.WHITE + "You have 3 less hearts");
                    spider_origin_info3_meta.setLore(spider_origin_info3_lore);
                    spider_origin_info3.setItemMeta(spider_origin_info3_meta);

                    ItemMeta spider_origin_info4_meta = spider_origin_info4.getItemMeta();
                    spider_origin_info4_meta.setDisplayName("Tiny Carnivore");
                    ArrayList<String> spider_origin_info4_lore = new ArrayList<>();
                    spider_origin_info4_lore.add(ChatColor.WHITE + "You can only eat meat");
                    spider_origin_info4_meta.setLore(spider_origin_info4_lore);
                    spider_origin_info4.setItemMeta(spider_origin_info4_meta);

                    ItemMeta close_meta = close.getItemMeta();
                    close_meta.setDisplayName(ChatColor.RED + "Close");
                    ArrayList<String> close_lore = new ArrayList<>();
                    close_lore.add(ChatColor.RED + "Cancel Choosing");
                    close_meta.setLore(close_lore);
                    close.setItemMeta(close_meta);

                    ItemMeta next_meta = next.getItemMeta();
                    next_meta.setDisplayName(ChatColor.BLUE + "MENU");
                    ArrayList<String> next_lore = new ArrayList<>();
                    next_lore.add(ChatColor.WHITE + "All Origins");
                    next_meta.setLore(next_lore);
                    next.setItemMeta(next_meta);

                    ItemMeta spider_meta = spider.getItemMeta();
                    spider_meta.setDisplayName("Arachnid");
                    ArrayList<String> spider_lore = new ArrayList<>();
                    spider_lore.add(ChatColor.RED + "Spider Origin");
                    spider_meta.setLore(spider_lore);
                    spider.setItemMeta(spider_meta);


                    ItemStack[] spidergui_items = {close, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, orb, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, close, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, spider, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, spider_origin_info1, spider_origin_info2, spider_origin_info3, spider_origin_info4, blank, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, blank, blank, blank, blank, blank, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, next, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE};
                    spidergui.setContents(spidergui_items);
                    p.openInventory(spidergui);
                }
                //creep
                if (e.getCurrentItem().getType() == Material.GUNPOWDER) {
                    e.setCancelled(true);
                    p.playSound(p.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 10, 9);
                    Inventory creepgui = Bukkit.createInventory(p, 54, ChatColor.BLACK + "Origins Rechoosing");

                    ItemStack close = new ItemStack(Material.BARRIER);
                    ItemStack next = new ItemStack(Material.ARROW);
                    ItemStack creep = new ItemStack(Material.GUNPOWDER);
                    ItemStack GRAY_STAINED_GLASS_PANE = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);
                    ItemStack blank = new ItemStack(Material.PAPER);
                    ItemStack orb = new ItemStack(Material.MAGMA_CREAM);
                    ItemStack creep_origin_info1 = new ItemStack(Material.FILLED_MAP);
                    ItemStack creep_origin_info2 = new ItemStack(Material.FILLED_MAP);
                    ItemStack creep_origin_info3 = new ItemStack(Material.FILLED_MAP);
                    ItemStack creep_origin_info4 = new ItemStack(Material.FILLED_MAP);

                    ItemStack item = new ItemStack(Material.MAGMA_CREAM, 1);
                    ItemMeta meta = item.getItemMeta();
                    meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
                    meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
                    meta.addItemFlags(ItemFlag.HIDE_DESTROYS);
                    meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                    meta.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
                    meta.addItemFlags(ItemFlag.HIDE_PLACED_ON);
                    meta.setDisplayName(ChatColor.LIGHT_PURPLE + "Orb of Origins");
                    meta.setUnbreakable(true);
                    meta.addEnchant(Enchantment.ARROW_INFINITE, 1, true);
                    List<String> lore = new ArrayList<>();
                    item.setItemMeta(meta);
                    orb = item;

                    ItemMeta creep_origin_info1_meta = creep_origin_info1.getItemMeta();
                    creep_origin_info1_meta.setDisplayName("BOOOOM");
                    ArrayList<String> creep_origin_info1_lore = new ArrayList<>();
                    creep_origin_info1_lore.add(ChatColor.WHITE + "You can explode at will");
                    creep_origin_info1_meta.setLore(creep_origin_info1_lore);
                    creep_origin_info1.setItemMeta(creep_origin_info1_meta);

                    ItemMeta creep_origin_info2_meta = creep_origin_info2.getItemMeta();
                    creep_origin_info2_meta.setDisplayName("You Got a Friend in Me");
                    ArrayList<String> creep_origin_info2_lore = new ArrayList<>();
                    creep_origin_info2_lore.add(ChatColor.WHITE + "Creepers will avoid you");
                    creep_origin_info2_meta.setLore(creep_origin_info2_lore);
                    creep_origin_info2.setItemMeta(creep_origin_info2_meta);

                    ItemMeta creep_origin_info3_meta = creep_origin_info3.getItemMeta();
                    creep_origin_info3_meta.setDisplayName("Camouflage");
                    ArrayList<String> creep_origin_info3_lore = new ArrayList<>();
                    creep_origin_info3_lore.add(ChatColor.WHITE + "Your skin is green");
                    creep_origin_info3_meta.setLore(creep_origin_info3_lore);
                    creep_origin_info3.setItemMeta(creep_origin_info3_meta);

                    ItemMeta creep_origin_info4_meta = creep_origin_info4.getItemMeta();
                    creep_origin_info4_meta.setDisplayName("Felinephobia");
                    ArrayList<String> creep_origin_info4_lore = new ArrayList<>();
                    creep_origin_info4_lore.add(ChatColor.WHITE + "If you are near cats, they damage you");
                    creep_origin_info4_meta.setLore(creep_origin_info4_lore);
                    creep_origin_info4.setItemMeta(creep_origin_info4_meta);

                    ItemMeta close_meta = close.getItemMeta();
                    close_meta.setDisplayName(ChatColor.RED + "Close");
                    ArrayList<String> close_lore = new ArrayList<>();
                    close_lore.add(ChatColor.RED + "Cancel Choosing");
                    close_meta.setLore(close_lore);
                    close.setItemMeta(close_meta);

                    ItemMeta next_meta = next.getItemMeta();
                    next_meta.setDisplayName(ChatColor.BLUE + "MENU");
                    ArrayList<String> next_lore = new ArrayList<>();
                    next_lore.add(ChatColor.WHITE + "All Origins");
                    next_meta.setLore(next_lore);
                    next.setItemMeta(next_meta);

                    ItemMeta creep_meta = creep.getItemMeta();
                    creep_meta.setDisplayName("Creep");
                    ArrayList<String> creep_lore = new ArrayList<>();
                    creep_lore.add(ChatColor.GREEN + "Creeper Origin");
                    creep_meta.setLore(creep_lore);
                    creep.setItemMeta(creep_meta);


                    ItemStack[] creepgui_items = {close, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, orb, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, close, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, creep, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, creep_origin_info1, creep_origin_info2, creep_origin_info3, creep_origin_info4, blank, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, blank, blank, blank, blank, blank, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, next, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE};
                    creepgui.setContents(creepgui_items);
                    p.openInventory(creepgui);
                }
                //phantom
                if (e.getCurrentItem().getType() == Material.PHANTOM_MEMBRANE) {
                    e.setCancelled(true);
                    p.playSound(p.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 10, 9);
                    Inventory phantomgui = Bukkit.createInventory(p, 54, ChatColor.BLACK + "Origins Rechoosing");

                    ItemStack close = new ItemStack(Material.BARRIER);
                    ItemStack next = new ItemStack(Material.ARROW);
                    ItemStack phantom = new ItemStack(Material.PHANTOM_MEMBRANE);
                    ItemStack GRAY_STAINED_GLASS_PANE = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);
                    ItemStack blank = new ItemStack(Material.PAPER);
                    ItemStack orb = new ItemStack(Material.MAGMA_CREAM);
                    ItemStack phantom_origin_info1 = new ItemStack(Material.FILLED_MAP);
                    ItemStack phantom_origin_info2 = new ItemStack(Material.FILLED_MAP);
                    ItemStack phantom_origin_info3 = new ItemStack(Material.FILLED_MAP);
                    ItemStack phantom_origin_info4 = new ItemStack(Material.FILLED_MAP);
                    ItemStack phantom_origin_info5 = new ItemStack(Material.FILLED_MAP);
                    ItemStack phantom_origin_info6 = new ItemStack(Material.FILLED_MAP);

                    ItemStack item = new ItemStack(Material.MAGMA_CREAM, 1);
                    ItemMeta meta = item.getItemMeta();
                    meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
                    meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
                    meta.addItemFlags(ItemFlag.HIDE_DESTROYS);
                    meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                    meta.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
                    meta.addItemFlags(ItemFlag.HIDE_PLACED_ON);
                    meta.setDisplayName(ChatColor.LIGHT_PURPLE + "Orb of Origins");
                    meta.setUnbreakable(true);
                    meta.addEnchant(Enchantment.ARROW_INFINITE, 1, true);
                    List<String> lore = new ArrayList<>();
                    item.setItemMeta(meta);
                    orb = item;

                    ItemMeta phantom_origin_info1_meta = phantom_origin_info1.getItemMeta();
                    phantom_origin_info1_meta.setDisplayName("Translucent");
                    ArrayList<String> phantom_origin_info1_lore = new ArrayList<>();
                    phantom_origin_info1_lore.add(ChatColor.WHITE + "Your skin is translucent");
                    phantom_origin_info1_meta.setLore(phantom_origin_info1_lore);
                    phantom_origin_info1.setItemMeta(phantom_origin_info1_meta);

                    ItemMeta phantom_origin_info2_meta = phantom_origin_info2.getItemMeta();
                    phantom_origin_info2_meta.setDisplayName("Phantom Form");
                    ArrayList<String> phantom_origin_info2_lore = new ArrayList<>();
                    phantom_origin_info2_lore.add(ChatColor.WHITE + "You can switch between human and phantom form at will");
                    phantom_origin_info2_meta.setLore(phantom_origin_info2_lore);
                    phantom_origin_info2.setItemMeta(phantom_origin_info2_meta);

                    ItemMeta phantom_origin_info3_meta = phantom_origin_info3.getItemMeta();
                    phantom_origin_info3_meta.setDisplayName("Phasing");
                    ArrayList<String> phantom_origin_info3_lore = new ArrayList<>();
                    phantom_origin_info3_lore.add(ChatColor.WHITE + "While phantomized, you can walk through solid material");
                    phantom_origin_info3_meta.setLore(phantom_origin_info3_lore);
                    phantom_origin_info3.setItemMeta(phantom_origin_info3_meta);

                    ItemMeta phantom_origin_info4_meta = phantom_origin_info4.getItemMeta();
                    phantom_origin_info4_meta.setDisplayName("Photoallergic");
                    ArrayList<String> phantom_origin_info4_lore = new ArrayList<>();
                    phantom_origin_info4_lore.add(ChatColor.WHITE + "You begin to burn in daylight if you are not invisible");
                    phantom_origin_info4_meta.setLore(phantom_origin_info4_lore);
                    phantom_origin_info4.setItemMeta(phantom_origin_info4_meta);

                    ItemMeta phantom_origin_info5_meta = phantom_origin_info5.getItemMeta();
                    phantom_origin_info5_meta.setDisplayName("Fast Metabolism");
                    ArrayList<String> phantom_origin_info5_lore = new ArrayList<>();
                    phantom_origin_info5_lore.add(ChatColor.WHITE + "Being phantomized causes you to become hungry");
                    phantom_origin_info5_meta.setLore(phantom_origin_info5_lore);
                    phantom_origin_info5.setItemMeta(phantom_origin_info5_meta);

                    ItemMeta phantom_origin_info6_meta = phantom_origin_info6.getItemMeta();
                    phantom_origin_info6_meta.setDisplayName("Fragile");
                    ArrayList<String> phantom_origin_info6_lore = new ArrayList<>();
                    phantom_origin_info6_lore.add(ChatColor.WHITE + "You have 3 less hearts of health");
                    phantom_origin_info6_meta.setLore(phantom_origin_info6_lore);
                    phantom_origin_info6.setItemMeta(phantom_origin_info6_meta);

                    ItemMeta close_meta = close.getItemMeta();
                    close_meta.setDisplayName(ChatColor.RED + "Close");
                    ArrayList<String> close_lore = new ArrayList<>();
                    close_lore.add(ChatColor.RED + "Cancel Choosing");
                    close_meta.setLore(close_lore);
                    close.setItemMeta(close_meta);

                    ItemMeta next_meta = next.getItemMeta();
                    next_meta.setDisplayName(ChatColor.BLUE + "MENU");
                    ArrayList<String> next_lore = new ArrayList<>();
                    next_lore.add(ChatColor.WHITE + "All Origins");
                    next_meta.setLore(next_lore);
                    next.setItemMeta(next_meta);

                    ItemMeta phantom_meta = phantom.getItemMeta();
                    phantom_meta.setDisplayName("Phantom");
                    ArrayList<String> phantom_lore = new ArrayList<>();
                    phantom_lore.add(ChatColor.BLUE + "Phantom Origin");
                    phantom_meta.setLore(phantom_lore);
                    phantom.setItemMeta(phantom_meta);


                    ItemStack[] phantomgui_items = {close, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, orb, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, close, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, phantom, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, phantom_origin_info1, phantom_origin_info2, phantom_origin_info3, phantom_origin_info4, phantom_origin_info5, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, phantom_origin_info6, blank, blank, blank, blank, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, next, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE};
                    phantomgui.setContents(phantomgui_items);
                    p.openInventory(phantomgui);
                }
                //slimeling
                if (e.getCurrentItem().getType() == Material.SLIME_BALL) {
                    e.setCancelled(true);
                    p.playSound(p.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 10, 9);
                    Inventory slimegui = Bukkit.createInventory(p, 54, ChatColor.BLACK + "Origins Rechoosing");

                    ItemStack close = new ItemStack(Material.BARRIER);
                    ItemStack next = new ItemStack(Material.ARROW);
                    ItemStack slime = new ItemStack(Material.SLIME_BALL);
                    ItemStack GRAY_STAINED_GLASS_PANE = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);
                    ItemStack blank = new ItemStack(Material.PAPER);
                    ItemStack orb = new ItemStack(Material.MAGMA_CREAM);
                    ItemStack slime_origin_info1 = new ItemStack(Material.FILLED_MAP);
                    ItemStack slime_origin_info2 = new ItemStack(Material.FILLED_MAP);
                    ItemStack slime_origin_info3 = new ItemStack(Material.FILLED_MAP);
                    ItemStack slime_origin_info4 = new ItemStack(Material.FILLED_MAP);
                    ItemStack slime_origin_info5 = new ItemStack(Material.FILLED_MAP);
                    ItemStack slime_origin_info6 = new ItemStack(Material.FILLED_MAP);
                    ItemStack slime_origin_info7 = new ItemStack(Material.FILLED_MAP);


                    ItemStack item = new ItemStack(Material.MAGMA_CREAM, 1);
                    ItemMeta meta = item.getItemMeta();
                    meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
                    meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
                    meta.addItemFlags(ItemFlag.HIDE_DESTROYS);
                    meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                    meta.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
                    meta.addItemFlags(ItemFlag.HIDE_PLACED_ON);
                    meta.setDisplayName(ChatColor.LIGHT_PURPLE + "Orb of Origins");
                    meta.setUnbreakable(true);
                    meta.addEnchant(Enchantment.ARROW_INFINITE, 1, true);
                    List<String> lore = new ArrayList<>();
                    item.setItemMeta(meta);
                    orb = item;

                    ItemMeta slime_origin_info1_meta = slime_origin_info1.getItemMeta();
                    slime_origin_info1_meta.setDisplayName("Bouncy");
                    ArrayList<String> slime_origin_info1_lore = new ArrayList<>();
                    slime_origin_info1_lore.add(ChatColor.WHITE + "You bounce on any block as if it was a slime block");
                    slime_origin_info1_meta.setLore(slime_origin_info1_lore);
                    slime_origin_info1.setItemMeta(slime_origin_info1_meta);

                    ItemMeta slime_origin_info2_meta = slime_origin_info2.getItemMeta();
                    slime_origin_info2_meta.setDisplayName("Break Apart");
                    ArrayList<String> slime_origin_info2_lore = new ArrayList<>();
                    slime_origin_info2_lore.add(ChatColor.WHITE + "When you hit you have a small chance to create small slimes");
                    slime_origin_info2_meta.setLore(slime_origin_info2_lore);
                    slime_origin_info2.setItemMeta(slime_origin_info2_meta);

                    ItemMeta slime_origin_info3_meta = slime_origin_info3.getItemMeta();
                    slime_origin_info3_meta.setDisplayName("Improved Jump");
                    ArrayList<String> slime_origin_info3_lore = new ArrayList<>();
                    slime_origin_info3_lore.add(ChatColor.WHITE + "You have an improved leap at the cost of movement speed");
                    slime_origin_info3_meta.setLore(slime_origin_info3_lore);
                    slime_origin_info3.setItemMeta(slime_origin_info3_meta);

                    ItemMeta slime_origin_info4_meta = slime_origin_info4.getItemMeta();
                    slime_origin_info4_meta.setDisplayName("Melting");
                    ArrayList<String> slime_origin_info4_lore = new ArrayList<>();
                    slime_origin_info4_lore.add(ChatColor.WHITE + "When hit, you will drop a slime ball on the ground");
                    slime_origin_info4_meta.setLore(slime_origin_info4_lore);
                    slime_origin_info4.setItemMeta(slime_origin_info4_meta);

                    ItemMeta slime_origin_info5_meta = slime_origin_info5.getItemMeta();
                    slime_origin_info5_meta.setDisplayName("Bounce[Primary]");
                    ArrayList<String> slime_origin_info5_lore = new ArrayList<>();
                    slime_origin_info5_lore.add(ChatColor.WHITE + "You perform a great leap towards the direction you're facing");
                    slime_origin_info5_meta.setLore(slime_origin_info5_lore);
                    slime_origin_info5.setItemMeta(slime_origin_info5_meta);

                    ItemMeta slime_origin_info6_meta = slime_origin_info6.getItemMeta();
                    slime_origin_info6_meta.setDisplayName("Slimy Skin");
                    ArrayList<String> slime_origin_info6_lore = new ArrayList<>();
                    slime_origin_info6_lore.add(ChatColor.WHITE + "You have the green trranslucent skin of a slime");
                    slime_origin_info6_meta.setLore(slime_origin_info6_lore);
                    slime_origin_info6.setItemMeta(slime_origin_info6_meta);

                    ItemMeta slime_origin_info7_meta = slime_origin_info7.getItemMeta();
                    slime_origin_info7_meta.setDisplayName("Slimy");
                    ArrayList<String> slime_origin_info7_lore = new ArrayList<>();
                    slime_origin_info7_lore.add(ChatColor.WHITE + "You burn when the weather is too hot");
                    slime_origin_info7_meta.setLore(slime_origin_info7_lore);
                    slime_origin_info7.setItemMeta(slime_origin_info7_meta);

                    ItemMeta close_meta = close.getItemMeta();
                    close_meta.setDisplayName(ChatColor.RED + "Close");
                    ArrayList<String> close_lore = new ArrayList<>();
                    close_lore.add(ChatColor.RED + "Cancel Choosing");
                    close_meta.setLore(close_lore);
                    close.setItemMeta(close_meta);

                    ItemMeta next_meta = next.getItemMeta();
                    next_meta.setDisplayName(ChatColor.BLUE + "MENU");
                    ArrayList<String> next_lore = new ArrayList<>();
                    next_lore.add(ChatColor.WHITE + "All Origins");
                    next_meta.setLore(next_lore);
                    next.setItemMeta(next_meta);

                    ItemMeta slime_meta = slime.getItemMeta();
                    slime_meta.setDisplayName("Slimeling");
                    ArrayList<String> slime_lore = new ArrayList<>();
                    slime_lore.add(ChatColor.GREEN + "Slime Origin");
                    slime_meta.setLore(slime_lore);
                    slime.setItemMeta(slime_meta);


                    ItemStack[] slimegui_items = {close, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, orb, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, close, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, slime, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, slime_origin_info1, slime_origin_info2, slime_origin_info3, slime_origin_info4, slime_origin_info5, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, blank, blank, blank, blank, blank, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, next, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE};
                    slimegui.setContents(slimegui_items);
                    p.openInventory(slimegui);
                }
                //vexian
                if (e.getCurrentItem().getType() == Material.IRON_SWORD) {
                    e.setCancelled(true);
                    p.playSound(p.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 10, 9);
                    Inventory vexgui = Bukkit.createInventory(p, 54, ChatColor.BLACK + "Origins Rechoosing");

                    ItemStack close = new ItemStack(Material.BARRIER);
                    ItemStack next = new ItemStack(Material.ARROW);
                    ItemStack vex = new ItemStack(Material.IRON_SWORD);
                    ItemStack GRAY_STAINED_GLASS_PANE = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);
                    ItemStack blank = new ItemStack(Material.PAPER);
                    ItemStack orb = new ItemStack(Material.MAGMA_CREAM);
                    ItemStack vex_origin_info1 = new ItemStack(Material.FILLED_MAP);
                    ItemStack vex_origin_info2 = new ItemStack(Material.FILLED_MAP);
                    ItemStack vex_origin_info3 = new ItemStack(Material.FILLED_MAP);
                    ItemStack vex_origin_info4 = new ItemStack(Material.FILLED_MAP);
                    ItemStack vex_origin_info5 = new ItemStack(Material.FILLED_MAP);
                    ItemStack vex_origin_info6 = new ItemStack(Material.FILLED_MAP);
                    ItemStack vex_origin_info7 = new ItemStack(Material.FILLED_MAP);

                    ItemStack item = new ItemStack(Material.MAGMA_CREAM, 1);
                    ItemMeta meta = item.getItemMeta();
                    meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
                    meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
                    meta.addItemFlags(ItemFlag.HIDE_DESTROYS);
                    meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                    meta.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
                    meta.addItemFlags(ItemFlag.HIDE_PLACED_ON);
                    meta.setDisplayName(ChatColor.LIGHT_PURPLE + "Orb of Origins");
                    meta.setUnbreakable(true);
                    meta.addEnchant(Enchantment.ARROW_INFINITE, 1, true);
                    List<String> lore = new ArrayList<>();
                    item.setItemMeta(meta);
                    orb = item;

                    ItemMeta vex_origin_info1_meta = vex_origin_info1.getItemMeta();
                    vex_origin_info1_meta.setDisplayName("Weightless Soul");
                    ArrayList<String> vex_origin_info1_lore = new ArrayList<>();
                    vex_origin_info1_lore.add(ChatColor.WHITE + "You can fly");
                    vex_origin_info1_meta.setLore(vex_origin_info1_lore);
                    vex_origin_info1.setItemMeta(vex_origin_info1_meta);

                    ItemMeta vex_origin_info2_meta = vex_origin_info2.getItemMeta();
                    vex_origin_info2_meta.setDisplayName("Raging Vex");
                    ArrayList<String> vex_origin_info2_lore = new ArrayList<>();
                    vex_origin_info2_lore.add(ChatColor.WHITE + "Gains strength 2 and speed 3 upon being hit");
                    vex_origin_info2_meta.setLore(vex_origin_info2_lore);
                    vex_origin_info2.setItemMeta(vex_origin_info2_meta);

                    ItemMeta vex_origin_info3_meta = vex_origin_info3.getItemMeta();
                    vex_origin_info3_meta.setDisplayName("Matterless");
                    ArrayList<String> vex_origin_info3_lore = new ArrayList<>();
                    vex_origin_info3_lore.add(ChatColor.WHITE + "You can fly through solid blocks");
                    vex_origin_info3_meta.setLore(vex_origin_info3_lore);
                    vex_origin_info3.setItemMeta(vex_origin_info3_meta);

                    ItemMeta vex_origin_info4_meta = vex_origin_info4.getItemMeta();
                    vex_origin_info4_meta.setDisplayName("Feared Spirit");
                    ArrayList<String> vex_origin_info4_lore = new ArrayList<>();
                    vex_origin_info4_lore.add(ChatColor.WHITE + "Villagers will not trade with you");
                    vex_origin_info4_meta.setLore(vex_origin_info4_lore);
                    vex_origin_info4.setItemMeta(vex_origin_info4_meta);

                    ItemMeta vex_origin_info5_meta = vex_origin_info5.getItemMeta();
                    vex_origin_info5_meta.setDisplayName("Unholy Creature");
                    ArrayList<String> vex_origin_info5_lore = new ArrayList<>();
                    vex_origin_info5_lore.add(ChatColor.WHITE + "You cannot wear any armour made of Iron, Gold, or Chainmail");
                    vex_origin_info5_meta.setLore(vex_origin_info5_lore);
                    vex_origin_info5.setItemMeta(vex_origin_info5_meta);

                    ItemMeta vex_origin_info6_meta = vex_origin_info6.getItemMeta();
                    vex_origin_info6_meta.setDisplayName("Bloodlust");
                    ArrayList<String> vex_origin_info6_lore = new ArrayList<>();
                    vex_origin_info6_lore.add(ChatColor.WHITE + "You can only eat meat");
                    vex_origin_info6_meta.setLore(vex_origin_info6_lore);
                    vex_origin_info6.setItemMeta(vex_origin_info6_meta);

                    ItemMeta vex_origin_info7_meta = vex_origin_info7.getItemMeta();
                    vex_origin_info7_meta.setDisplayName("Little Demon");
                    ArrayList<String> vex_origin_info7_lore = new ArrayList<>();
                    vex_origin_info7_lore.add(ChatColor.WHITE + "You are slower and weaker when in water");
                    vex_origin_info7_meta.setLore(vex_origin_info7_lore);
                    vex_origin_info7.setItemMeta(vex_origin_info7_meta);

                    ItemMeta close_meta = close.getItemMeta();
                    close_meta.setDisplayName(ChatColor.RED + "Close");
                    ArrayList<String> close_lore = new ArrayList<>();
                    close_lore.add(ChatColor.RED + "Cancel Choosing");
                    close_meta.setLore(close_lore);
                    close.setItemMeta(close_meta);

                    ItemMeta next_meta = next.getItemMeta();
                    next_meta.setDisplayName(ChatColor.BLUE + "MENU");
                    ArrayList<String> next_lore = new ArrayList<>();
                    next_lore.add(ChatColor.WHITE + "All Origins");
                    next_meta.setLore(next_lore);
                    next.setItemMeta(next_meta);

                    ItemMeta vex_meta = vex.getItemMeta();
                    vex_meta.setDisplayName("Vexian");
                    ArrayList<String> vex_lore = new ArrayList<>();
                    vex_lore.add(ChatColor.AQUA + "Vex Origin");
                    vex_meta.setLore(vex_lore);
                    vex.setItemMeta(vex_meta);


                    ItemStack[] vexgui_items = {close, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, orb, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, close, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, vex, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, vex_origin_info1, vex_origin_info2, vex_origin_info3, vex_origin_info4, vex_origin_info5, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, vex_origin_info6, vex_origin_info7, blank, blank, blank, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, next, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE};
                    vexgui.setContents(vexgui_items);
                    p.openInventory(vexgui);
                }
                if (e.getCurrentItem().getType() == Material.BLAZE_POWDER) {
                    e.setCancelled(true);
                    p.playSound(p.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 10, 9);
                    Inventory blazegui = Bukkit.createInventory(p, 54, ChatColor.BLACK + "Origins Rechoosing");

                    ItemStack close = new ItemStack(Material.BARRIER);
                    ItemStack next = new ItemStack(Material.ARROW);
                    ItemStack blaze = new ItemStack(Material.BLAZE_POWDER);
                    ItemStack GRAY_STAINED_GLASS_PANE = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);
                    ItemStack blank = new ItemStack(Material.PAPER);
                    ItemStack orb = new ItemStack(Material.MAGMA_CREAM);
                    ItemStack blaze_origin_info1 = new ItemStack(Material.FILLED_MAP);
                    ItemStack blaze_origin_info2 = new ItemStack(Material.FILLED_MAP);
                    ItemStack blaze_origin_info3 = new ItemStack(Material.FILLED_MAP);
                    ItemStack blaze_origin_info4 = new ItemStack(Material.FILLED_MAP);
                    ItemStack blaze_origin_info5 = new ItemStack(Material.FILLED_MAP);

                    ItemStack item = new ItemStack(Material.MAGMA_CREAM, 1);
                    ItemMeta meta = item.getItemMeta();
                    meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
                    meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
                    meta.addItemFlags(ItemFlag.HIDE_DESTROYS);
                    meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                    meta.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
                    meta.addItemFlags(ItemFlag.HIDE_PLACED_ON);
                    meta.setDisplayName(ChatColor.LIGHT_PURPLE + "Orb of Origins");
                    meta.setUnbreakable(true);
                    meta.addEnchant(Enchantment.ARROW_INFINITE, 1, true);
                    List<String> lore = new ArrayList<>();
                    item.setItemMeta(meta);
                    orb = item;

                    ItemMeta blaze_origin_info1_meta = blaze_origin_info1.getItemMeta();
                    blaze_origin_info1_meta.setDisplayName("Fire Immunity");
                    ArrayList<String> blaze_origin_info1_lore = new ArrayList<>();
                    blaze_origin_info1_lore.add(ChatColor.WHITE + "You are immune to all types of fire damage");
                    blaze_origin_info1_meta.setLore(blaze_origin_info1_lore);
                    blaze_origin_info1.setItemMeta(blaze_origin_info1_meta);

                    ItemMeta blaze_origin_info2_meta = blaze_origin_info2.getItemMeta();
                    blaze_origin_info2_meta.setDisplayName("Burning Wrath");
                    ArrayList<String> blaze_origin_info2_lore = new ArrayList<>();
                    blaze_origin_info2_lore.add(ChatColor.WHITE + "When on fire, you deal additional damage with your attacks");
                    blaze_origin_info2_meta.setLore(blaze_origin_info2_lore);
                    blaze_origin_info2.setItemMeta(blaze_origin_info2_meta);

                    ItemMeta blaze_origin_info3_meta = blaze_origin_info3.getItemMeta();
                    blaze_origin_info3_meta.setDisplayName("Hotblooded");
                    ArrayList<String> blaze_origin_info3_lore = new ArrayList<>();
                    blaze_origin_info3_lore.add(ChatColor.WHITE + "Due to your hot body, venom burns up, making you immune to poison");
                    blaze_origin_info3_meta.setLore(blaze_origin_info3_lore);
                    blaze_origin_info3.setItemMeta(blaze_origin_info3_meta);

                    ItemMeta blaze_origin_info4_meta = blaze_origin_info4.getItemMeta();
                    blaze_origin_info4_meta.setDisplayName("Nether Inhabitant");
                    ArrayList<String> blaze_origin_info4_lore = new ArrayList<>();
                    blaze_origin_info4_lore.add(ChatColor.WHITE + "Your natural spawn will be in the Nether");
                    blaze_origin_info4_meta.setLore(blaze_origin_info4_lore);
                    blaze_origin_info4.setItemMeta(blaze_origin_info4_meta);

                    ItemMeta blaze_origin_info5_meta = blaze_origin_info5.getItemMeta();
                    blaze_origin_info5_meta.setDisplayName("Hydrophobia");
                    ArrayList<String> blaze_origin_info5_lore = new ArrayList<>();
                    blaze_origin_info5_lore.add(ChatColor.WHITE + "You receive damage over time while in contact with water");
                    blaze_origin_info5_meta.setLore(blaze_origin_info5_lore);
                    blaze_origin_info5.setItemMeta(blaze_origin_info5_meta);

                    ItemMeta close_meta = close.getItemMeta();
                    close_meta.setDisplayName(ChatColor.RED + "Close");
                    ArrayList<String> close_lore = new ArrayList<>();
                    close_lore.add(ChatColor.RED + "Cancel Choosing");
                    close_meta.setLore(close_lore);
                    close.setItemMeta(close_meta);

                    ItemMeta next_meta = next.getItemMeta();
                    next_meta.setDisplayName(ChatColor.BLUE + "MENU");
                    ArrayList<String> next_lore = new ArrayList<>();
                    next_lore.add(ChatColor.WHITE + "All Origins");
                    next_meta.setLore(next_lore);
                    next.setItemMeta(next_meta);

                    ItemMeta blaze_meta = blaze.getItemMeta();
                    blaze_meta.setDisplayName("Blazeborn");
                    ArrayList<String> blaze_lore = new ArrayList<>();
                    blaze_lore.add(ChatColor.GOLD + "Blaze Origin");
                    blaze_meta.setLore(blaze_lore);
                    blaze.setItemMeta(blaze_meta);


                    ItemStack[] blazegui_items = {close, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, orb, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, close, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, blaze, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, blaze_origin_info1, blaze_origin_info2, blaze_origin_info3, blaze_origin_info4, blaze_origin_info5, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, blank, blank, blank, blank, blank, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, next, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE};
                    blazegui.setContents(blazegui_items);
                    p.openInventory(blazegui);
                }
                if (e.getCurrentItem().getType() == Material.NETHER_STAR) {
                    e.setCancelled(true);
                    p.playSound(p.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 10, 9);
                    Inventory stargui = Bukkit.createInventory(p, 54, ChatColor.BLACK + "Origins Rechoosing");

                    ItemStack close = new ItemStack(Material.BARRIER);
                    ItemStack next = new ItemStack(Material.ARROW);
                    ItemStack star = new ItemStack(Material.NETHER_STAR);
                    ItemStack GRAY_STAINED_GLASS_PANE = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);
                    ItemStack blank = new ItemStack(Material.PAPER);
                    ItemStack orb = new ItemStack(Material.MAGMA_CREAM);
                    ItemStack star_origin_info1 = new ItemStack(Material.FILLED_MAP);
                    ItemStack star_origin_info2 = new ItemStack(Material.FILLED_MAP);
                    ItemStack star_origin_info3 = new ItemStack(Material.FILLED_MAP);
                    ItemStack star_origin_info4 = new ItemStack(Material.FILLED_MAP);
                    ItemStack star_origin_info5 = new ItemStack(Material.FILLED_MAP);
                    ItemStack star_origin_info6 = new ItemStack(Material.FILLED_MAP);
                    ItemStack star_origin_info7 = new ItemStack(Material.FILLED_MAP);
                    ItemStack star_origin_info8 = new ItemStack(Material.FILLED_MAP);
                    ItemStack star_origin_info9 = new ItemStack(Material.FILLED_MAP);
                    ItemStack star_origin_info10 = new ItemStack(Material.FILLED_MAP);

                    ItemStack item = new ItemStack(Material.MAGMA_CREAM, 1);
                    ItemMeta meta = item.getItemMeta();
                    meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
                    meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
                    meta.addItemFlags(ItemFlag.HIDE_DESTROYS);
                    meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                    meta.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
                    meta.addItemFlags(ItemFlag.HIDE_PLACED_ON);
                    meta.setDisplayName(ChatColor.LIGHT_PURPLE + "Orb of Origins");
                    meta.setUnbreakable(true);
                    meta.addEnchant(Enchantment.ARROW_INFINITE, 1, true);
                    List<String> lore = new ArrayList<>();
                    item.setItemMeta(meta);
                    orb = item;

                    ItemMeta star_origin_info1_meta = star_origin_info1.getItemMeta();
                    star_origin_info1_meta.setDisplayName("Wanderer of the Stars");
                    ArrayList<String> star_origin_info1_lore = new ArrayList<>();
                    star_origin_info1_lore.add(ChatColor.WHITE + "You cannot sleep");
                    star_origin_info1_meta.setLore(star_origin_info1_lore);
                    star_origin_info1.setItemMeta(star_origin_info1_meta);

                    ItemMeta star_origin_info2_meta = star_origin_info2.getItemMeta();
                    star_origin_info2_meta.setDisplayName("Speedy Star");
                    ArrayList<String> star_origin_info2_lore = new ArrayList<>();
                    star_origin_info2_lore.add(ChatColor.WHITE + "You can fling youself into the GRAY_STAINED_GLASS_PANE after a 5 second cooldown");
                    star_origin_info2_meta.setLore(star_origin_info2_lore);
                    star_origin_info2.setItemMeta(star_origin_info2_meta);

                    ItemMeta star_origin_info3_meta = star_origin_info3.getItemMeta();
                    star_origin_info3_meta.setDisplayName("Falling Stars");
                    ArrayList<String> star_origin_info3_lore = new ArrayList<>();
                    star_origin_info3_lore.add(ChatColor.WHITE + "You can drop stars on your enemy every 30 seconds");
                    star_origin_info3_meta.setLore(star_origin_info3_lore);
                    star_origin_info3.setItemMeta(star_origin_info3_meta);

                    ItemMeta star_origin_info4_meta = star_origin_info4.getItemMeta();
                    star_origin_info4_meta.setDisplayName("Mysterious Power");
                    ArrayList<String> star_origin_info4_lore = new ArrayList<>();
                    star_origin_info4_lore.add(ChatColor.WHITE + "When night falls, you are granted a mysterious power");
                    star_origin_info4_meta.setLore(star_origin_info4_lore);
                    star_origin_info4.setItemMeta(star_origin_info4_meta);

                    ItemMeta star_origin_info5_meta = star_origin_info5.getItemMeta();
                    star_origin_info5_meta.setDisplayName("Supernova");
                    ArrayList<String> star_origin_info5_lore = new ArrayList<>();
                    star_origin_info5_lore.add(ChatColor.WHITE + "When you die, you explode into a supernova");
                    star_origin_info5_meta.setLore(star_origin_info5_lore);
                    star_origin_info5.setItemMeta(star_origin_info5_meta);

                    ItemMeta star_origin_info6_meta = star_origin_info6.getItemMeta();
                    star_origin_info6_meta.setDisplayName("Cold Vacuum");
                    ArrayList<String> star_origin_info6_lore = new ArrayList<>();
                    star_origin_info6_lore.add(ChatColor.WHITE + "You take double damage from fire");
                    star_origin_info6_meta.setLore(star_origin_info6_lore);
                    star_origin_info6.setItemMeta(star_origin_info6_meta);

                    ItemMeta star_origin_info7_meta = star_origin_info7.getItemMeta();
                    star_origin_info7_meta.setDisplayName("Stargazer");
                    ArrayList<String> star_origin_info7_lore = new ArrayList<>();
                    star_origin_info7_lore.add(ChatColor.WHITE + "When exposed to the stars, you gain speed and regeneration, as a gift from the stars");
                    star_origin_info7_meta.setLore(star_origin_info7_lore);
                    star_origin_info7.setItemMeta(star_origin_info7_meta);

                    ItemMeta star_origin_info8_meta = star_origin_info8.getItemMeta();
                    star_origin_info8_meta.setDisplayName("Unkown Realm of The Star");
                    ArrayList<String> star_origin_info8_lore = new ArrayList<>();
                    star_origin_info8_lore.add(ChatColor.WHITE + "Being in a realm with no stars will make you weaker");
                    star_origin_info8_meta.setLore(star_origin_info8_lore);
                    star_origin_info8.setItemMeta(star_origin_info8_meta);

                    ItemMeta star_origin_info9_meta = star_origin_info9.getItemMeta();
                    star_origin_info9_meta.setDisplayName("Nonviolent");
                    ArrayList<String> star_origin_info9_lore = new ArrayList<>();
                    star_origin_info9_lore.add(ChatColor.WHITE + "You have a chance to get immobilized upon taking damage");
                    star_origin_info9_meta.setLore(star_origin_info9_lore);
                    star_origin_info9.setItemMeta(star_origin_info9_meta);

                    ItemMeta close_meta = close.getItemMeta();
                    close_meta.setDisplayName(ChatColor.RED + "Close");
                    ArrayList<String> close_lore = new ArrayList<>();
                    close_lore.add(ChatColor.RED + "Cancel Choosing");
                    close_meta.setLore(close_lore);
                    close.setItemMeta(close_meta);

                    ItemMeta next_meta = next.getItemMeta();
                    next_meta.setDisplayName(ChatColor.BLUE + "MENU");
                    ArrayList<String> next_lore = new ArrayList<>();
                    next_lore.add(ChatColor.WHITE + "All Origins");
                    next_meta.setLore(next_lore);
                    next.setItemMeta(next_meta);

                    ItemMeta star_meta = star.getItemMeta();
                    star_meta.setDisplayName("Starborne");
                    ArrayList<String> star_lore = new ArrayList<>();
                    star_lore.add(LIGHT_PURPLE + "Starborne Origin");
                    star_meta.setLore(star_lore);
                    star.setItemMeta(star_meta);


                    ItemStack[] stargui_items = {close, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, orb, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, close, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, star, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, star_origin_info1, star_origin_info2, star_origin_info3, star_origin_info4, star_origin_info5, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, star_origin_info6, star_origin_info7, star_origin_info8, star_origin_info9, blank, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, next, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE};
                    stargui.setContents(stargui_items);
                    p.openInventory(stargui);
                }
                if (e.getCurrentItem().getType() == Material.COD) {
                    e.setCancelled(true);
                    p.playSound(p.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 10, 9);
                    Inventory mermaidgui = Bukkit.createInventory(p, 54, ChatColor.BLACK + "Origins Rechoosing");

                    ItemStack close = new ItemStack(Material.BARRIER);
                    ItemStack next = new ItemStack(Material.ARROW);
                    ItemStack mermaid = new ItemStack(Material.COD);
                    ItemStack GRAY_STAINED_GLASS_PANE = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);
                    ItemStack blank = new ItemStack(Material.PAPER);
                    ItemStack orb = new ItemStack(Material.MAGMA_CREAM);
                    ItemStack mermaid_origin_info1 = new ItemStack(Material.FILLED_MAP);
                    ItemStack mermaid_origin_info2 = new ItemStack(Material.FILLED_MAP);
                    ItemStack mermaid_origin_info3 = new ItemStack(Material.FILLED_MAP);
                    ItemStack mermaid_origin_info4 = new ItemStack(Material.FILLED_MAP);
                    ItemStack mermaid_origin_info5 = new ItemStack(Material.FILLED_MAP);

                    ItemStack item = new ItemStack(Material.MAGMA_CREAM, 1);
                    ItemMeta meta = item.getItemMeta();
                    meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
                    meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
                    meta.addItemFlags(ItemFlag.HIDE_DESTROYS);
                    meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                    meta.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
                    meta.addItemFlags(ItemFlag.HIDE_PLACED_ON);
                    meta.setDisplayName(ChatColor.LIGHT_PURPLE + "Orb of Origins");
                    meta.setUnbreakable(true);
                    meta.addEnchant(Enchantment.ARROW_INFINITE, 1, true);
                    List<String> lore = new ArrayList<>();
                    item.setItemMeta(meta);
                    orb = item;

                    ItemMeta mermaid_origin_info1_meta = mermaid_origin_info1.getItemMeta();
                    mermaid_origin_info1_meta.setDisplayName("Gills");
                    ArrayList<String> mermaid_origin_info1_lore = new ArrayList<>();
                    mermaid_origin_info1_lore.add(ChatColor.WHITE + "You can breathe underwater, but not on land");
                    mermaid_origin_info1_meta.setLore(mermaid_origin_info1_lore);
                    mermaid_origin_info1.setItemMeta(mermaid_origin_info1_meta);

                    ItemMeta mermaid_origin_info2_meta = mermaid_origin_info2.getItemMeta();
                    mermaid_origin_info2_meta.setDisplayName("Wet Eyes");
                    ArrayList<String> mermaid_origin_info2_lore = new ArrayList<>();
                    mermaid_origin_info2_lore.add(ChatColor.WHITE + "Your vision underwater is almost perfect");
                    mermaid_origin_info2_meta.setLore(mermaid_origin_info2_lore);
                    mermaid_origin_info2.setItemMeta(mermaid_origin_info2_meta);

                    ItemMeta mermaid_origin_info3_meta = mermaid_origin_info3.getItemMeta();
                    mermaid_origin_info3_meta.setDisplayName("Fins");
                    ArrayList<String> mermaid_origin_info3_lore = new ArrayList<>();
                    mermaid_origin_info3_lore.add(ChatColor.WHITE + "Your underwater speed is increased");
                    mermaid_origin_info3_meta.setLore(mermaid_origin_info3_lore);
                    mermaid_origin_info3.setItemMeta(mermaid_origin_info3_meta);

                    ItemMeta mermaid_origin_info4_meta = mermaid_origin_info4.getItemMeta();
                    mermaid_origin_info4_meta.setDisplayName("Like Water");
                    ArrayList<String> mermaid_origin_info4_lore = new ArrayList<>();
                    mermaid_origin_info4_lore.add(ChatColor.WHITE + "When underwater, you do not sink unless you want to");
                    mermaid_origin_info4_meta.setLore(mermaid_origin_info4_lore);
                    mermaid_origin_info4.setItemMeta(mermaid_origin_info4_meta);

                    ItemMeta mermaid_origin_info5_meta = mermaid_origin_info5.getItemMeta();
                    mermaid_origin_info5_meta.setDisplayName("Gills");
                    ArrayList<String> mermaid_origin_info5_lore = new ArrayList<>();
                    mermaid_origin_info5_lore.add(ChatColor.WHITE + "When raining, you can get out of the water for a short time");
                    mermaid_origin_info5_meta.setLore(mermaid_origin_info5_lore);
                    mermaid_origin_info5.setItemMeta(mermaid_origin_info5_meta);

                    ItemMeta close_meta = close.getItemMeta();
                    close_meta.setDisplayName(ChatColor.RED + "Close");
                    ArrayList<String> close_lore = new ArrayList<>();
                    close_lore.add(ChatColor.RED + "Cancel Choosing");
                    close_meta.setLore(close_lore);
                    close.setItemMeta(close_meta);

                    ItemMeta next_meta = next.getItemMeta();
                    next_meta.setDisplayName(ChatColor.BLUE + "MENU");
                    ArrayList<String> next_lore = new ArrayList<>();
                    next_lore.add(ChatColor.WHITE + "All Origins");
                    next_meta.setLore(next_lore);
                    next.setItemMeta(next_meta);

                    ItemMeta mermaid_meta = mermaid.getItemMeta();
                    mermaid_meta.setDisplayName("Mermaid");
                    ArrayList<String> mermaid_lore = new ArrayList<>();
                    mermaid_lore.add(ChatColor.BLUE + "Mermaid Origin");
                    mermaid_meta.setLore(mermaid_lore);
                    mermaid.setItemMeta(mermaid_meta);


                    ItemStack[] mermaidgui_items = {close, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, orb, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, close, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, mermaid, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, mermaid_origin_info1, mermaid_origin_info2, mermaid_origin_info3, mermaid_origin_info4, mermaid_origin_info5, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, blank, blank, blank, blank, blank, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, next, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE};
                    mermaidgui.setContents(mermaidgui_items);
                    p.openInventory(mermaidgui);
                }
                if (e.getCurrentItem().getType() == Material.NETHER_WART) {
                    e.setCancelled(true);
                    p.playSound(p.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 10, 9);
                    Inventory witchgui = Bukkit.createInventory(p, 54, ChatColor.BLACK + "Origins Rechoosing");

                    ItemStack close = new ItemStack(Material.BARRIER);
                    ItemStack next = new ItemStack(Material.ARROW);
                    ItemStack witch = new ItemStack(Material.NETHER_WART);
                    ItemStack GRAY_STAINED_GLASS_PANE = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);
                    ItemStack blank = new ItemStack(Material.PAPER);
                    ItemStack orb = new ItemStack(Material.MAGMA_CREAM);
                    ItemStack witch_origin_info1 = new ItemStack(Material.FILLED_MAP);
                    ItemStack witch_origin_info2 = new ItemStack(Material.FILLED_MAP);
                    ItemStack witch_origin_info3 = new ItemStack(Material.FILLED_MAP);
                    ItemStack witch_origin_info4 = new ItemStack(Material.FILLED_MAP);
                    ItemStack witch_origin_info5 = new ItemStack(Material.FILLED_MAP);
                    ItemStack witch_origin_info6 = new ItemStack(Material.FILLED_MAP);

                    ItemStack item = new ItemStack(Material.MAGMA_CREAM, 1);
                    ItemMeta meta = item.getItemMeta();
                    meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
                    meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
                    meta.addItemFlags(ItemFlag.HIDE_DESTROYS);
                    meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                    meta.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
                    meta.addItemFlags(ItemFlag.HIDE_PLACED_ON);
                    meta.setDisplayName(ChatColor.LIGHT_PURPLE + "Orb of Origins");
                    meta.setUnbreakable(true);
                    meta.addEnchant(Enchantment.ARROW_INFINITE, 1, true);
                    List<String> lore = new ArrayList<>();
                    item.setItemMeta(meta);
                    orb = item;

                    ItemMeta witch_origin_info1_meta = witch_origin_info1.getItemMeta();
                    witch_origin_info1_meta.setDisplayName("Healer");
                    ArrayList<String> witch_origin_info1_lore = new ArrayList<>();
                    witch_origin_info1_lore.add(ChatColor.WHITE + "Shift-Clicking heals you by 4 hearts with a 50 second cooldown");
                    witch_origin_info1_meta.setLore(witch_origin_info1_lore);
                    witch_origin_info1.setItemMeta(witch_origin_info1_meta);

                    ItemMeta witch_origin_info2_meta = witch_origin_info2.getItemMeta();
                    witch_origin_info2_meta.setDisplayName("Boost");
                    ArrayList<String> witch_origin_info2_lore = new ArrayList<>();
                    witch_origin_info2_lore.add(ChatColor.WHITE + "If you are near black cats, you get strength and speed");
                    witch_origin_info2_meta.setLore(witch_origin_info2_lore);
                    witch_origin_info2.setItemMeta(witch_origin_info2_meta);

                    ItemMeta witch_origin_info3_meta = witch_origin_info3.getItemMeta();
                    witch_origin_info3_meta.setDisplayName("Witches Power");
                    ArrayList<String> witch_origin_info3_lore = new ArrayList<>();
                    witch_origin_info3_lore.add(ChatColor.WHITE + "You spawn in a witches hut");
                    witch_origin_info3_meta.setLore(witch_origin_info3_lore);
                    witch_origin_info3.setItemMeta(witch_origin_info3_meta);

                    ItemMeta witch_origin_info4_meta = witch_origin_info4.getItemMeta();
                    witch_origin_info4_meta.setDisplayName("Effect");
                    ArrayList<String> witch_origin_info4_lore = new ArrayList<>();
                    witch_origin_info4_lore.add(ChatColor.WHITE + "You always have a potion in your 9th slot");
                    witch_origin_info4_meta.setLore(witch_origin_info4_lore);
                    witch_origin_info4.setItemMeta(witch_origin_info4_meta);

                    ItemMeta witch_origin_info5_meta = witch_origin_info5.getItemMeta();
                    witch_origin_info5_meta.setDisplayName("Burning at the Stake");
                    ArrayList<String> witch_origin_info5_lore = new ArrayList<>();
                    witch_origin_info5_lore.add(ChatColor.WHITE + "You take double damage from lava");
                    witch_origin_info5_meta.setLore(witch_origin_info5_lore);
                    witch_origin_info5.setItemMeta(witch_origin_info5_meta);

                    ItemMeta witch_origin_info6_meta = witch_origin_info6.getItemMeta();
                    witch_origin_info6_meta.setDisplayName("Outcast");
                    ArrayList<String> witch_origin_info6_lore = new ArrayList<>();
                    witch_origin_info6_lore.add(ChatColor.WHITE + "Villagers will not trade with you");
                    witch_origin_info6_meta.setLore(witch_origin_info6_lore);
                    witch_origin_info6.setItemMeta(witch_origin_info6_meta);

                    ItemMeta close_meta = close.getItemMeta();
                    close_meta.setDisplayName(ChatColor.RED + "Close");
                    ArrayList<String> close_lore = new ArrayList<>();
                    close_lore.add(ChatColor.RED + "Cancel Choosing");
                    close_meta.setLore(close_lore);
                    close.setItemMeta(close_meta);

                    ItemMeta next_meta = next.getItemMeta();
                    next_meta.setDisplayName(ChatColor.BLUE + "MENU");
                    ArrayList<String> next_lore = new ArrayList<>();
                    next_lore.add(ChatColor.WHITE + "All Origins");
                    next_meta.setLore(next_lore);
                    next.setItemMeta(next_meta);

                    ItemMeta witch_meta = witch.getItemMeta();
                    witch_meta.setDisplayName("Witch");
                    ArrayList<String> witch_lore = new ArrayList<>();
                    witch_lore.add(ChatColor.RED + "Witch Origin");
                    witch_meta.setLore(witch_lore);
                    witch.setItemMeta(witch_meta);


                    ItemStack[] witchgui_items = {close, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, orb, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, close, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, witch, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, witch_origin_info1, witch_origin_info2, witch_origin_info3, witch_origin_info4, witch_origin_info5, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, witch_origin_info6, blank, blank, blank, blank, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, next, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE};
                    witchgui.setContents(witchgui_items);
                    p.openInventory(witchgui);
                }
                if (e.getCurrentItem().getType() == Material.CARROT) {
                    e.setCancelled(true);
                    p.playSound(p.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 10, 9);
                    Inventory rabbitgui = Bukkit.createInventory(p, 54, ChatColor.BLACK + "Origins Rechoosing");

                    ItemStack close = new ItemStack(Material.BARRIER);
                    ItemStack next = new ItemStack(Material.ARROW);
                    ItemStack rabbit = new ItemStack(Material.CARROT);
                    ItemStack GRAY_STAINED_GLASS_PANE = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);
                    ItemStack blank = new ItemStack(Material.PAPER);
                    ItemStack orb = new ItemStack(Material.MAGMA_CREAM);
                    ItemStack rabbit_origin_info1 = new ItemStack(Material.FILLED_MAP);
                    ItemStack rabbit_origin_info2 = new ItemStack(Material.FILLED_MAP);
                    ItemStack rabbit_origin_info3 = new ItemStack(Material.FILLED_MAP);
                    ItemStack rabbit_origin_info4 = new ItemStack(Material.FILLED_MAP);
                    ItemStack rabbit_origin_info5 = new ItemStack(Material.FILLED_MAP);
                    ItemStack rabbit_origin_info6 = new ItemStack(Material.FILLED_MAP);

                    ItemStack item = new ItemStack(Material.MAGMA_CREAM, 1);
                    ItemMeta meta = item.getItemMeta();
                    meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
                    meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
                    meta.addItemFlags(ItemFlag.HIDE_DESTROYS);
                    meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                    meta.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
                    meta.addItemFlags(ItemFlag.HIDE_PLACED_ON);
                    meta.setDisplayName(ChatColor.LIGHT_PURPLE + "Orb of Origins");
                    meta.setUnbreakable(true);
                    meta.addEnchant(Enchantment.ARROW_INFINITE, 1, true);
                    List<String> lore = new ArrayList<>();
                    item.setItemMeta(meta);
                    orb = item;

                    ItemMeta rabbit_origin_info1_meta = rabbit_origin_info1.getItemMeta();
                    rabbit_origin_info1_meta.setDisplayName("Leap");
                    ArrayList<String> rabbit_origin_info1_lore = new ArrayList<>();
                    rabbit_origin_info1_lore.add(ChatColor.WHITE + "You leap in the direction you're looking to");
                    rabbit_origin_info1_meta.setLore(rabbit_origin_info1_lore);
                    rabbit_origin_info1.setItemMeta(rabbit_origin_info1_meta);

                    ItemMeta rabbit_origin_info2_meta = rabbit_origin_info2.getItemMeta();
                    rabbit_origin_info2_meta.setDisplayName("Strong Hopper");
                    ArrayList<String> rabbit_origin_info2_lore = new ArrayList<>();
                    rabbit_origin_info2_lore.add(ChatColor.WHITE + "You jump significantly higher");
                    rabbit_origin_info2_meta.setLore(rabbit_origin_info2_lore);
                    rabbit_origin_info2.setItemMeta(rabbit_origin_info2_meta);

                    ItemMeta rabbit_origin_info3_meta = rabbit_origin_info3.getItemMeta();
                    rabbit_origin_info3_meta.setDisplayName("Shock Absorption");
                    ArrayList<String> rabbit_origin_info3_lore = new ArrayList<>();
                    rabbit_origin_info3_lore.add(ChatColor.WHITE + "You take less fall damage");
                    rabbit_origin_info3_meta.setLore(rabbit_origin_info3_lore);
                    rabbit_origin_info3.setItemMeta(rabbit_origin_info3_meta);

                    ItemMeta rabbit_origin_info4_meta = rabbit_origin_info4.getItemMeta();
                    rabbit_origin_info4_meta.setDisplayName("Delicious");
                    ArrayList<String> rabbit_origin_info4_lore = new ArrayList<>();
                    rabbit_origin_info4_lore.add(ChatColor.WHITE + "You may drop a rabbit's foot when hit");
                    rabbit_origin_info4_meta.setLore(rabbit_origin_info4_lore);
                    rabbit_origin_info4.setItemMeta(rabbit_origin_info4_meta);

                    ItemMeta rabbit_origin_info5_meta = rabbit_origin_info5.getItemMeta();
                    rabbit_origin_info5_meta.setDisplayName("Picky Eater");
                    ArrayList<String> rabbit_origin_info5_lore = new ArrayList<>();
                    rabbit_origin_info5_lore.add(ChatColor.WHITE + "You can only eat carrots and golden carrots");
                    rabbit_origin_info5_meta.setLore(rabbit_origin_info5_lore);
                    rabbit_origin_info5.setItemMeta(rabbit_origin_info5_meta);

                    ItemMeta rabbit_origin_info6_meta = rabbit_origin_info6.getItemMeta();
                    rabbit_origin_info6_meta.setDisplayName("Fragile");
                    ArrayList<String> rabbit_origin_info6_lore = new ArrayList<>();
                    rabbit_origin_info6_lore.add(ChatColor.WHITE + "You have 3 less hearts");
                    rabbit_origin_info6_meta.setLore(rabbit_origin_info6_lore);
                    rabbit_origin_info6.setItemMeta(rabbit_origin_info6_meta);

                    ItemMeta close_meta = close.getItemMeta();
                    close_meta.setDisplayName(ChatColor.RED + "Close");
                    ArrayList<String> close_lore = new ArrayList<>();
                    close_lore.add(ChatColor.RED + "Cancel Choosing");
                    close_meta.setLore(close_lore);
                    close.setItemMeta(close_meta);

                    ItemMeta next_meta = next.getItemMeta();
                    next_meta.setDisplayName(ChatColor.BLUE + "MENU");
                    ArrayList<String> next_lore = new ArrayList<>();
                    next_lore.add(ChatColor.WHITE + "All Origins");
                    next_meta.setLore(next_lore);
                    next.setItemMeta(next_meta);

                    ItemMeta rabbit_meta = rabbit.getItemMeta();
                    rabbit_meta.setDisplayName("Rabbit");
                    ArrayList<String> rabbit_lore = new ArrayList<>();
                    rabbit_lore.add(ChatColor.GOLD + "Bunny Origin");
                    rabbit_meta.setLore(rabbit_lore);
                    rabbit.setItemMeta(rabbit_meta);


                    ItemStack[] rabbitgui_items = {close, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, orb, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, close, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, rabbit, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, rabbit_origin_info1, rabbit_origin_info2, rabbit_origin_info3, rabbit_origin_info4, rabbit_origin_info5, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, rabbit_origin_info6, blank, blank, blank, blank, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, next, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE};
                    rabbitgui.setContents(rabbitgui_items);
                    p.openInventory(rabbitgui);
                }
                if (e.getCurrentItem().getType() == Material.HONEYCOMB) {
                    e.setCancelled(true);
                    p.playSound(p.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 10, 9);
                    Inventory beegui = Bukkit.createInventory(p, 54, ChatColor.BLACK + "Origins Rechoosing");

                    ItemStack close = new ItemStack(Material.BARRIER);
                    ItemStack next = new ItemStack(Material.ARROW);
                    ItemStack bee = new ItemStack(Material.HONEYCOMB);
                    ItemStack GRAY_STAINED_GLASS_PANE = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);
                    ItemStack blank = new ItemStack(Material.PAPER);
                    ItemStack orb = new ItemStack(Material.MAGMA_CREAM);
                    ItemStack bee_origin_info1 = new ItemStack(Material.FILLED_MAP);
                    ItemStack bee_origin_info2 = new ItemStack(Material.FILLED_MAP);
                    ItemStack bee_origin_info3 = new ItemStack(Material.FILLED_MAP);
                    ItemStack bee_origin_info4 = new ItemStack(Material.FILLED_MAP);
                    ItemStack bee_origin_info5 = new ItemStack(Material.FILLED_MAP);
                    ItemStack bee_origin_info6 = new ItemStack(Material.FILLED_MAP);
                    ItemStack bee_origin_info7 = new ItemStack(Material.FILLED_MAP);

                    ItemStack item = new ItemStack(Material.MAGMA_CREAM, 1);
                    ItemMeta meta = item.getItemMeta();
                    meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
                    meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
                    meta.addItemFlags(ItemFlag.HIDE_DESTROYS);
                    meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                    meta.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
                    meta.addItemFlags(ItemFlag.HIDE_PLACED_ON);
                    meta.setDisplayName(ChatColor.LIGHT_PURPLE + "Orb of Origins");
                    meta.setUnbreakable(true);
                    meta.addEnchant(Enchantment.ARROW_INFINITE, 1, true);
                    List<String> lore = new ArrayList<>();
                    item.setItemMeta(meta);
                    orb = item;

                    ItemMeta bee_origin_info1_meta = bee_origin_info1.getItemMeta();
                    bee_origin_info1_meta.setDisplayName("Featherweight");
                    ArrayList<String> bee_origin_info1_lore = new ArrayList<>();
                    bee_origin_info1_lore.add(ChatColor.WHITE + "You fall as gently to the ground as a feather would unless you shift");
                    bee_origin_info1_meta.setLore(bee_origin_info1_lore);
                    bee_origin_info1.setItemMeta(bee_origin_info1_meta);

                    ItemMeta bee_origin_info2_meta = bee_origin_info2.getItemMeta();
                    bee_origin_info2_meta.setDisplayName("Poisonous");
                    ArrayList<String> bee_origin_info2_lore = new ArrayList<>();
                    bee_origin_info2_lore.add(ChatColor.WHITE + "Hitting someone gives them poison for 2 seconds");
                    bee_origin_info2_meta.setLore(bee_origin_info2_lore);
                    bee_origin_info2.setItemMeta(bee_origin_info2_meta);

                    ItemMeta bee_origin_info3_meta = bee_origin_info3.getItemMeta();
                    bee_origin_info3_meta.setDisplayName("Bloom");
                    ArrayList<String> bee_origin_info3_lore = new ArrayList<>();
                    bee_origin_info3_lore.add(ChatColor.WHITE + "You gain regeneration when near flowers");
                    bee_origin_info3_meta.setLore(bee_origin_info3_lore);
                    bee_origin_info3.setItemMeta(bee_origin_info3_meta);

                    ItemMeta bee_origin_info4_meta = bee_origin_info4.getItemMeta();
                    bee_origin_info4_meta.setDisplayName("Flight");
                    ArrayList<String> bee_origin_info4_lore = new ArrayList<>();
                    bee_origin_info4_lore.add(ChatColor.WHITE + "You can fly, just like a bee!(WHATT)");
                    bee_origin_info4_meta.setLore(bee_origin_info4_lore);
                    bee_origin_info4.setItemMeta(bee_origin_info4_meta);

                    ItemMeta bee_origin_info5_meta = bee_origin_info5.getItemMeta();
                    bee_origin_info5_meta.setDisplayName("Nighttime");
                    ArrayList<String> bee_origin_info5_lore = new ArrayList<>();
                    bee_origin_info5_lore.add(ChatColor.WHITE + "You are sleepy at night, so you walk and fly slower");
                    bee_origin_info5_meta.setLore(bee_origin_info5_lore);
                    bee_origin_info5.setItemMeta(bee_origin_info5_meta);

                    ItemMeta bee_origin_info6_meta = bee_origin_info6.getItemMeta();
                    bee_origin_info6_meta.setDisplayName("Lifespan");
                    ArrayList<String> bee_origin_info6_lore = new ArrayList<>();
                    bee_origin_info6_lore.add(ChatColor.WHITE + "You have 3 less hearts");
                    bee_origin_info6_meta.setLore(bee_origin_info6_lore);
                    bee_origin_info6.setItemMeta(bee_origin_info6_meta);

                    ItemMeta bee_origin_info7_meta = bee_origin_info7.getItemMeta();
                    bee_origin_info7_meta.setDisplayName("Rain");
                    ArrayList<String> bee_origin_info7_lore = new ArrayList<>();
                    bee_origin_info7_lore.add(ChatColor.WHITE + "You cannot fly when in the rain and are weaker while wet");
                    bee_origin_info7_meta.setLore(bee_origin_info7_lore);
                    bee_origin_info7.setItemMeta(bee_origin_info7_meta);

                    ItemMeta close_meta = close.getItemMeta();
                    close_meta.setDisplayName(ChatColor.RED + "Close");
                    ArrayList<String> close_lore = new ArrayList<>();
                    close_lore.add(ChatColor.RED + "Cancel Choosing");
                    close_meta.setLore(close_lore);
                    close.setItemMeta(close_meta);

                    ItemMeta next_meta = next.getItemMeta();
                    next_meta.setDisplayName(ChatColor.BLUE + "MENU");
                    ArrayList<String> next_lore = new ArrayList<>();
                    next_lore.add(ChatColor.WHITE + "All Origins");
                    next_meta.setLore(next_lore);
                    next.setItemMeta(next_meta);

                    ItemMeta bee_meta = bee.getItemMeta();
                    bee_meta.setDisplayName("Bumblebee");
                    ArrayList<String> bee_lore = new ArrayList<>();
                    bee_lore.add(ChatColor.YELLOW + "Bee Origin");
                    bee_meta.setLore(bee_lore);
                    bee.setItemMeta(bee_meta);


                    ItemStack[] beegui_items = {close, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, orb, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, close, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, bee, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, bee_origin_info1, bee_origin_info2, bee_origin_info3, bee_origin_info4, bee_origin_info5, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, bee_origin_info6, bee_origin_info7, blank, blank, blank, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, next, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE};
                    beegui.setContents(beegui_items);
                    p.openInventory(beegui);
                }
                if (e.getCurrentItem().getType() == Material.ELYTRA) {
                    e.setCancelled(true);
                    p.playSound(p.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 10, 9);
                    Inventory elyrtiangui = Bukkit.createInventory(p, 54, ChatColor.BLACK + "Origins Rechoosing");

                    ItemStack close = new ItemStack(Material.BARRIER);
                    ItemStack next = new ItemStack(Material.ARROW);
                    ItemStack elyrtian = new ItemStack(Material.ELYTRA);
                    ItemStack GRAY_STAINED_GLASS_PANE = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);
                    ItemStack blank = new ItemStack(Material.PAPER);
                    ItemStack orb = new ItemStack(Material.MAGMA_CREAM);
                    ItemStack elyrtian_origin_info1 = new ItemStack(Material.FILLED_MAP);
                    ItemStack elyrtian_origin_info2 = new ItemStack(Material.FILLED_MAP);
                    ItemStack elyrtian_origin_info3 = new ItemStack(Material.FILLED_MAP);
                    ItemStack elyrtian_origin_info4 = new ItemStack(Material.FILLED_MAP);
                    ItemStack elyrtian_origin_info5 = new ItemStack(Material.FILLED_MAP);

                    ItemStack item = new ItemStack(Material.MAGMA_CREAM, 1);
                    ItemMeta meta = item.getItemMeta();
                    meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
                    meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
                    meta.addItemFlags(ItemFlag.HIDE_DESTROYS);
                    meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                    meta.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
                    meta.addItemFlags(ItemFlag.HIDE_PLACED_ON);
                    meta.setDisplayName(ChatColor.LIGHT_PURPLE + "Orb of Origins");
                    meta.setUnbreakable(true);
                    meta.addEnchant(Enchantment.ARROW_INFINITE, 1, true);
                    List<String> lore = new ArrayList<>();
                    item.setItemMeta(meta);
                    orb = item;

                    ItemMeta elyrtian_origin_info1_meta = elyrtian_origin_info1.getItemMeta();
                    elyrtian_origin_info1_meta.setDisplayName("Winged");
                    ArrayList<String> elyrtian_origin_info1_lore = new ArrayList<>();
                    elyrtian_origin_info1_lore.add(ChatColor.WHITE + "You have Elytra wings without needing to equip any");
                    elyrtian_origin_info1_meta.setLore(elyrtian_origin_info1_lore);
                    elyrtian_origin_info1.setItemMeta(elyrtian_origin_info1_meta);

                    ItemMeta elyrtian_origin_info2_meta = elyrtian_origin_info2.getItemMeta();
                    elyrtian_origin_info2_meta.setDisplayName("Gift of the Winds");
                    ArrayList<String> elyrtian_origin_info2_lore = new ArrayList<>();
                    elyrtian_origin_info2_lore.add(ChatColor.WHITE + "Every 60 seconds, you can launch yourself 20 blocks in the GRAY_STAINED_GLASS_PANE");
                    elyrtian_origin_info2_meta.setLore(elyrtian_origin_info2_lore);
                    elyrtian_origin_info2.setItemMeta(elyrtian_origin_info2_meta);

                    ItemMeta elyrtian_origin_info3_meta = elyrtian_origin_info3.getItemMeta();
                    elyrtian_origin_info3_meta.setDisplayName("Claustrophobia");
                    ArrayList<String> elyrtian_origin_info3_lore = new ArrayList<>();
                    elyrtian_origin_info3_lore.add(ChatColor.WHITE + "Being somewhere with a low ceiling for too long will weaken you");
                    elyrtian_origin_info3_meta.setLore(elyrtian_origin_info3_lore);
                    elyrtian_origin_info3.setItemMeta(elyrtian_origin_info3_meta);

                    ItemMeta elyrtian_origin_info4_meta = elyrtian_origin_info4.getItemMeta();
                    elyrtian_origin_info4_meta.setDisplayName("Need for Mobility");
                    ArrayList<String> elyrtian_origin_info4_lore = new ArrayList<>();
                    elyrtian_origin_info4_lore.add(ChatColor.WHITE + "You cannot wear any heavy armour with prot values higher than chainmail");
                    elyrtian_origin_info4_meta.setLore(elyrtian_origin_info4_lore);
                    elyrtian_origin_info4.setItemMeta(elyrtian_origin_info4_meta);

                    ItemMeta elyrtian_origin_info5_meta = elyrtian_origin_info5.getItemMeta();
                    elyrtian_origin_info5_meta.setDisplayName("Brittle Bones");
                    ArrayList<String> elyrtian_origin_info5_lore = new ArrayList<>();
                    elyrtian_origin_info5_lore.add(ChatColor.WHITE + "You take more damage from falling and flying into blocks");
                    elyrtian_origin_info5_meta.setLore(elyrtian_origin_info5_lore);
                    elyrtian_origin_info5.setItemMeta(elyrtian_origin_info5_meta);

                    ItemMeta close_meta = close.getItemMeta();
                    close_meta.setDisplayName(ChatColor.RED + "Close");
                    ArrayList<String> close_lore = new ArrayList<>();
                    close_lore.add(ChatColor.RED + "Cancel Choosing");
                    close_meta.setLore(close_lore);
                    close.setItemMeta(close_meta);

                    ItemMeta next_meta = next.getItemMeta();
                    next_meta.setDisplayName(ChatColor.BLUE + "MENU");
                    ArrayList<String> next_lore = new ArrayList<>();
                    next_lore.add(ChatColor.WHITE + "All Origins");
                    next_meta.setLore(next_lore);
                    next.setItemMeta(next_meta);

                    ItemMeta elyrtian_meta = elyrtian.getItemMeta();
                    elyrtian_meta.setDisplayName("Elytrian");
                    ArrayList<String> elyrtian_lore = new ArrayList<>();
                    elyrtian_lore.add(ChatColor.GRAY + "Elytrian Origin");
                    elyrtian_meta.setLore(elyrtian_lore);
                    elyrtian.setItemMeta(elyrtian_meta);


                    ItemStack[] elyrtiangui_items = {close, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, orb, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, close, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, elyrtian, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, elyrtian_origin_info1, elyrtian_origin_info2, elyrtian_origin_info3, elyrtian_origin_info4, elyrtian_origin_info5, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, blank, blank, blank, blank, blank, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, next, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE};
                    elyrtiangui.setContents(elyrtiangui_items);
                    p.openInventory(elyrtiangui);
                }
                if (e.getCurrentItem().getType() == Material.FEATHER) {
                    e.setCancelled(true);
                    p.playSound(p.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 10, 9);
                    Inventory aviangui = Bukkit.createInventory(p, 54, ChatColor.BLACK + "Origins Rechoosing");

                    ItemStack close = new ItemStack(Material.BARRIER);
                    ItemStack next = new ItemStack(Material.ARROW);
                    ItemStack avian = new ItemStack(Material.FEATHER);
                    ItemStack GRAY_STAINED_GLASS_PANE = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);
                    ItemStack blank = new ItemStack(Material.PAPER);
                    ItemStack orb = new ItemStack(Material.MAGMA_CREAM);
                    ItemStack avian_origin_info1 = new ItemStack(Material.FILLED_MAP);
                    ItemStack avian_origin_info2 = new ItemStack(Material.FILLED_MAP);
                    ItemStack avian_origin_info3 = new ItemStack(Material.FILLED_MAP);
                    ItemStack avian_origin_info4 = new ItemStack(Material.FILLED_MAP);
                    ItemStack avian_origin_info5 = new ItemStack(Material.FILLED_MAP);

                    ItemStack item = new ItemStack(Material.MAGMA_CREAM, 1);
                    ItemMeta meta = item.getItemMeta();
                    meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
                    meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
                    meta.addItemFlags(ItemFlag.HIDE_DESTROYS);
                    meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                    meta.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
                    meta.addItemFlags(ItemFlag.HIDE_PLACED_ON);
                    meta.setDisplayName(ChatColor.LIGHT_PURPLE + "Orb of Origins");
                    meta.setUnbreakable(true);
                    meta.addEnchant(Enchantment.ARROW_INFINITE, 1, true);
                    List<String> lore = new ArrayList<>();
                    item.setItemMeta(meta);
                    orb = item;

                    ItemMeta avian_origin_info1_meta = avian_origin_info1.getItemMeta();
                    avian_origin_info1_meta.setDisplayName("Featherweight");
                    ArrayList<String> avian_origin_info1_lore = new ArrayList<>();
                    avian_origin_info1_lore.add(ChatColor.WHITE + "You fall as gently to the ground as a feather would, unless you shift");
                    avian_origin_info1_meta.setLore(avian_origin_info1_lore);
                    avian_origin_info1.setItemMeta(avian_origin_info1_meta);

                    ItemMeta avian_origin_info2_meta = avian_origin_info2.getItemMeta();
                    avian_origin_info2_meta.setDisplayName("Tailwind");
                    ArrayList<String> avian_origin_info2_lore = new ArrayList<>();
                    avian_origin_info2_lore.add(ChatColor.WHITE + "You are a little quicker on foot than others");
                    avian_origin_info2_meta.setLore(avian_origin_info2_lore);
                    avian_origin_info2.setItemMeta(avian_origin_info2_meta);

                    ItemMeta avian_origin_info3_meta = avian_origin_info3.getItemMeta();
                    avian_origin_info3_meta.setDisplayName("Oviparous");
                    ArrayList<String> avian_origin_info3_lore = new ArrayList<>();
                    avian_origin_info3_lore.add(ChatColor.WHITE + "Whenever you wake up in the morning, you lay an egg");
                    avian_origin_info3_meta.setLore(avian_origin_info3_lore);
                    avian_origin_info3.setItemMeta(avian_origin_info3_meta);

                    ItemMeta avian_origin_info4_meta = avian_origin_info4.getItemMeta();
                    avian_origin_info4_meta.setDisplayName("Vegetarian");
                    ArrayList<String> avian_origin_info4_lore = new ArrayList<>();
                    avian_origin_info4_lore.add(ChatColor.WHITE + "You can't digest any meat");
                    avian_origin_info4_meta.setLore(avian_origin_info4_lore);
                    avian_origin_info4.setItemMeta(avian_origin_info4_meta);

                    ItemMeta avian_origin_info5_meta = avian_origin_info5.getItemMeta();
                    avian_origin_info5_meta.setDisplayName("Fresh GRAY_STAINED_GLASS_PANE");
                    ArrayList<String> avian_origin_info5_lore = new ArrayList<>();
                    avian_origin_info5_lore.add(ChatColor.WHITE + "When sleeping, your bed needs to be at an altitude of at least 86 blocks");
                    avian_origin_info5_meta.setLore(avian_origin_info5_lore);
                    avian_origin_info5.setItemMeta(avian_origin_info5_meta);

                    ItemMeta close_meta = close.getItemMeta();
                    close_meta.setDisplayName(ChatColor.RED + "Close");
                    ArrayList<String> close_lore = new ArrayList<>();
                    close_lore.add(ChatColor.RED + "Cancel Choosing");
                    close_meta.setLore(close_lore);
                    close.setItemMeta(close_meta);

                    ItemMeta next_meta = next.getItemMeta();
                    next_meta.setDisplayName(ChatColor.BLUE + "MENU");
                    ArrayList<String> next_lore = new ArrayList<>();
                    next_lore.add(ChatColor.WHITE + "All Origins");
                    next_meta.setLore(next_lore);
                    next.setItemMeta(next_meta);

                    ItemMeta avian_meta = avian.getItemMeta();
                    avian_meta.setDisplayName("Avian");
                    ArrayList<String> avian_lore = new ArrayList<>();
                    avian_lore.add(ChatColor.DARK_AQUA + "Avian Origin");
                    avian_meta.setLore(avian_lore);
                    avian.setItemMeta(avian_meta);


                    ItemStack[] aviangui_items = {close, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, orb, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, close, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, avian, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, avian_origin_info1, avian_origin_info2, avian_origin_info3, avian_origin_info4, avian_origin_info5, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, blank, blank, blank, blank, blank, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, next, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE};
                    aviangui.setContents(aviangui_items);
                    p.openInventory(aviangui);
                }
                if (e.getCurrentItem().getType() == Material.GOLD_INGOT) {
                    e.setCancelled(true);
                    p.playSound(p.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 10, 9);
                    Inventory piglingui = Bukkit.createInventory(p, 54, ChatColor.BLACK + "Origins Rechoosing");

                    ItemStack close = new ItemStack(Material.BARRIER);
                    ItemStack next = new ItemStack(Material.ARROW);
                    ItemStack piglin = new ItemStack(Material.GOLD_INGOT);
                    ItemStack GRAY_STAINED_GLASS_PANE = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);
                    ItemStack blank = new ItemStack(Material.PAPER);
                    ItemStack orb = new ItemStack(Material.MAGMA_CREAM);
                    ItemStack piglin_origin_info1 = new ItemStack(Material.FILLED_MAP);
                    ItemStack piglin_origin_info2 = new ItemStack(Material.FILLED_MAP);
                    ItemStack piglin_origin_info3 = new ItemStack(Material.FILLED_MAP);
                    ItemStack piglin_origin_info4 = new ItemStack(Material.FILLED_MAP);
                    ItemStack piglin_origin_info5 = new ItemStack(Material.FILLED_MAP);

                    ItemStack item = new ItemStack(Material.MAGMA_CREAM, 1);
                    ItemMeta meta = item.getItemMeta();
                    meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
                    meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
                    meta.addItemFlags(ItemFlag.HIDE_DESTROYS);
                    meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                    meta.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
                    meta.addItemFlags(ItemFlag.HIDE_PLACED_ON);
                    meta.setDisplayName(ChatColor.LIGHT_PURPLE + "Orb of Origins");
                    meta.setUnbreakable(true);
                    meta.addEnchant(Enchantment.ARROW_INFINITE, 1, true);
                    List<String> lore = new ArrayList<>();
                    item.setItemMeta(meta);
                    orb = item;

                    ItemMeta piglin_origin_info1_meta = piglin_origin_info1.getItemMeta();
                    piglin_origin_info1_meta.setDisplayName("I like to be SHINY");
                    ArrayList<String> piglin_origin_info1_lore = new ArrayList<>();
                    piglin_origin_info1_lore.add(ChatColor.WHITE + "Golden tools deal extra damage and gold armour has more protection");
                    piglin_origin_info1_meta.setLore(piglin_origin_info1_lore);
                    piglin_origin_info1.setItemMeta(piglin_origin_info1_meta);

                    ItemMeta piglin_origin_info2_meta = piglin_origin_info2.getItemMeta();
                    piglin_origin_info2_meta.setDisplayName("Friendly Frenemies");
                    ArrayList<String> piglin_origin_info2_lore = new ArrayList<>();
                    piglin_origin_info2_lore.add(ChatColor.WHITE + "Piglins won't attack you unless provoked, Brutes will still attack on sight");
                    piglin_origin_info2_meta.setLore(piglin_origin_info2_lore);
                    piglin_origin_info2.setItemMeta(piglin_origin_info2_meta);

                    ItemMeta piglin_origin_info3_meta = piglin_origin_info3.getItemMeta();
                    piglin_origin_info3_meta.setDisplayName("Nether Dweller");
                    ArrayList<String> piglin_origin_info3_lore = new ArrayList<>();
                    piglin_origin_info3_lore.add(ChatColor.WHITE + "Your natural spawn is in the Nether and you can only eat meat");
                    piglin_origin_info3_meta.setLore(piglin_origin_info3_lore);
                    piglin_origin_info3.setItemMeta(piglin_origin_info3_meta);

                    ItemMeta piglin_origin_info4_meta = piglin_origin_info4.getItemMeta();
                    piglin_origin_info4_meta.setDisplayName("When outside of the Nether, you zombify and become immune to fire and are slower");
                    ArrayList<String> piglin_origin_info4_lore = new ArrayList<>();
                    piglin_origin_info4_lore.add(ChatColor.WHITE + "You cannot hold a shield");
                    piglin_origin_info4_meta.setLore(piglin_origin_info4_lore);
                    piglin_origin_info4.setItemMeta(piglin_origin_info4_meta);

                    ItemMeta piglin_origin_info5_meta = piglin_origin_info5.getItemMeta();
                    piglin_origin_info5_meta.setDisplayName("BLUE FIRE SPOOKY");
                    ArrayList<String> piglin_origin_info5_lore = new ArrayList<>();
                    piglin_origin_info5_lore.add(ChatColor.WHITE + "You are afraid of soul fire, becoming weak when near it");
                    piglin_origin_info5_meta.setLore(piglin_origin_info5_lore);
                    piglin_origin_info5.setItemMeta(piglin_origin_info5_meta);

                    ItemMeta close_meta = close.getItemMeta();
                    close_meta.setDisplayName(ChatColor.RED + "Close");
                    ArrayList<String> close_lore = new ArrayList<>();
                    close_lore.add(ChatColor.RED + "Cancel Choosing");
                    close_meta.setLore(close_lore);
                    close.setItemMeta(close_meta);

                    ItemMeta next_meta = next.getItemMeta();
                    next_meta.setDisplayName(ChatColor.BLUE + "MENU");
                    ArrayList<String> next_lore = new ArrayList<>();
                    next_lore.add(ChatColor.WHITE + "All Origins");
                    next_meta.setLore(next_lore);
                    next.setItemMeta(next_meta);

                    ItemMeta piglin_meta = piglin.getItemMeta();
                    piglin_meta.setDisplayName("Piglin");
                    ArrayList<String> piglin_lore = new ArrayList<>();
                    piglin_lore.add(ChatColor.GOLD + "Piglin Origin");
                    piglin_meta.setLore(piglin_lore);
                    piglin.setItemMeta(piglin_meta);


                    ItemStack[] piglingui_items = {close, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, orb, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, close, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, piglin, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, piglin_origin_info1, piglin_origin_info2, piglin_origin_info3, piglin_origin_info4, piglin_origin_info5, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, blank, blank, blank, blank, blank, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, next, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE};
                    piglingui.setContents(piglingui_items);
                    p.openInventory(piglingui);
                }
                if (e.getCurrentItem().getType() == Material.DRAGON_BREATH) {
                    e.setCancelled(true);
                    p.playSound(p.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 10, 9);
                    Inventory dragongui = Bukkit.createInventory(p, 54, ChatColor.BLACK + "Origins Rechoosing");

                    ItemStack close = new ItemStack(Material.BARRIER);
                    ItemStack next = new ItemStack(Material.ARROW);
                    ItemStack dragon = new ItemStack(Material.DRAGON_BREATH);
                    ItemStack GRAY_STAINED_GLASS_PANE = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);
                    ItemStack blank = new ItemStack(Material.PAPER);
                    ItemStack orb = new ItemStack(Material.MAGMA_CREAM);
                    ItemStack dragon_origin_info1 = new ItemStack(Material.FILLED_MAP);
                    ItemStack dragon_origin_info2 = new ItemStack(Material.FILLED_MAP);
                    ItemStack dragon_origin_info3 = new ItemStack(Material.FILLED_MAP);
                    ItemStack dragon_origin_info4 = new ItemStack(Material.FILLED_MAP);
                    ItemStack dragon_origin_info5 = new ItemStack(Material.FILLED_MAP);
                    ItemStack dragon_origin_info6 = new ItemStack(Material.FILLED_MAP);

                    ItemStack item = new ItemStack(Material.MAGMA_CREAM, 1);
                    ItemMeta meta = item.getItemMeta();
                    meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
                    meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
                    meta.addItemFlags(ItemFlag.HIDE_DESTROYS);
                    meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                    meta.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
                    meta.addItemFlags(ItemFlag.HIDE_PLACED_ON);
                    meta.setDisplayName(ChatColor.LIGHT_PURPLE + "Orb of Origins");
                    meta.setUnbreakable(true);
                    meta.addEnchant(Enchantment.ARROW_INFINITE, 1, true);
                    List<String> lore = new ArrayList<>();
                    item.setItemMeta(meta);
                    orb = item;

                    ItemMeta dragon_origin_info1_meta = dragon_origin_info1.getItemMeta();
                    dragon_origin_info1_meta.setDisplayName("Mighty Wings");
                    ArrayList<String> dragon_origin_info1_lore = new ArrayList<>();
                    dragon_origin_info1_lore.add(ChatColor.WHITE + "You spawn with a permanent Elytra");
                    dragon_origin_info1_meta.setLore(dragon_origin_info1_lore);
                    dragon_origin_info1.setItemMeta(dragon_origin_info1_meta);

                    ItemMeta dragon_origin_info2_meta = dragon_origin_info2.getItemMeta();
                    dragon_origin_info2_meta.setDisplayName("Heart of a Dragon");
                    ArrayList<String> dragon_origin_info2_lore = new ArrayList<>();
                    dragon_origin_info2_lore.add(ChatColor.WHITE + "You have 6 more hearts and can only eat meat");
                    dragon_origin_info2_meta.setLore(dragon_origin_info2_lore);
                    dragon_origin_info2.setItemMeta(dragon_origin_info2_meta);

                    ItemMeta dragon_origin_info3_meta = dragon_origin_info3.getItemMeta();
                    dragon_origin_info3_meta.setDisplayName("Breath of Fire");
                    ArrayList<String> dragon_origin_info3_lore = new ArrayList<>();
                    dragon_origin_info3_lore.add(ChatColor.WHITE + "You can shoot a dragon fireball upon shift-clicking with a 30 second cooldown");
                    dragon_origin_info3_meta.setLore(dragon_origin_info3_lore);
                    dragon_origin_info3.setItemMeta(dragon_origin_info3_meta);

                    ItemMeta dragon_origin_info4_meta = dragon_origin_info4.getItemMeta();
                    dragon_origin_info4_meta.setDisplayName("Unkown Healing");
                    ArrayList<String> dragon_origin_info4_lore = new ArrayList<>();
                    dragon_origin_info4_lore.add(ChatColor.WHITE + "If you hold an End Crystal in your hand, you heal, saturation heals a lot slower");
                    dragon_origin_info4_meta.setLore(dragon_origin_info4_lore);
                    dragon_origin_info4.setItemMeta(dragon_origin_info4_meta);

                    ItemMeta dragon_origin_info5_meta = dragon_origin_info5.getItemMeta();
                    dragon_origin_info5_meta.setDisplayName("Resistance");
                    ArrayList<String> dragon_origin_info5_lore = new ArrayList<>();
                    dragon_origin_info5_lore.add(ChatColor.WHITE + "You take no knockback and have extremely tough and protective skin");
                    dragon_origin_info5_meta.setLore(dragon_origin_info5_lore);
                    dragon_origin_info5.setItemMeta(dragon_origin_info5_meta);

                    ItemMeta dragon_origin_info6_meta = dragon_origin_info6.getItemMeta();
                    dragon_origin_info6_meta.setDisplayName("Creature of The Sky");
                    ArrayList<String> dragon_origin_info6_lore = new ArrayList<>();
                    dragon_origin_info6_lore.add(ChatColor.WHITE + "After being on land for more than 30 seconds, you get a bit weaker unless you are at a higher altitude");
                    dragon_origin_info6_meta.setLore(dragon_origin_info6_lore);
                    dragon_origin_info6.setItemMeta(dragon_origin_info6_meta);

                    ItemMeta close_meta = close.getItemMeta();
                    close_meta.setDisplayName(ChatColor.RED + "Close");
                    ArrayList<String> close_lore = new ArrayList<>();
                    close_lore.add(ChatColor.RED + "Cancel Choosing");
                    close_meta.setLore(close_lore);
                    close.setItemMeta(close_meta);

                    ItemMeta next_meta = next.getItemMeta();
                    next_meta.setDisplayName(ChatColor.BLUE + "MENU");
                    ArrayList<String> next_lore = new ArrayList<>();
                    next_lore.add(ChatColor.WHITE + "All Origins");
                    next_meta.setLore(next_lore);
                    next.setItemMeta(next_meta);

                    ItemMeta dragon_meta = dragon.getItemMeta();
                    dragon_meta.setDisplayName("Dragonborne");
                    ArrayList<String> dragon_lore = new ArrayList<>();
                    dragon_lore.add(ChatColor.DARK_PURPLE + "Dragon Origin");
                    dragon_meta.setLore(dragon_lore);
                    dragon.setItemMeta(dragon_meta);


                    ItemStack[] dragongui_items = {close, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, orb, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, close, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, dragon, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, dragon_origin_info1, dragon_origin_info2, dragon_origin_info3, dragon_origin_info4, dragon_origin_info5, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, dragon_origin_info6, blank, blank, blank, blank, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, next, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE};
                    dragongui.setContents(dragongui_items);
                    p.openInventory(dragongui);
                }
            } else {
            } //End of Origins Menu Open

            if (e.getView().getTitle().equalsIgnoreCase(ChatColor.BLACK + "Origins Rechoosing")) {
                e.setCancelled(true);
                if (e.getCurrentItem().getType() == Material.BARRIER) {
                    p.closeInventory();
                    p.playSound(p.getLocation(), Sound.BLOCK_NOTE_BLOCK_GUITAR, 10, 9);
                    p.sendMessage(ChatColor.RED + "Choosing canceled!");
                    e.setCancelled(true);
                }
            }
        }
    }
}
