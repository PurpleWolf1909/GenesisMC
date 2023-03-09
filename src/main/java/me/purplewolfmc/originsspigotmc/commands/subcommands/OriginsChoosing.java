package me.purplewolfmc.originsspigotmc.commands.subcommands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class OriginsChoosing extends SubCommand {
    @Override
    public String getName() {
        return "choose";
    }

    @Override
    public String getDescription() {
        return "choose your origin";
    }

    @Override
    public String getSyntax() {
        return "/origins choose";
    }

    @Override
    public void perform(Player p, String[] args) {

            if (!p.getScoreboardTags().contains("chosen")) {


                Inventory humangui = Bukkit.createInventory(p, 54, ChatColor.BLACK + "Human");

                ItemStack close = new ItemStack(Material.BARRIER);
                ItemStack next = new ItemStack(Material.ARROW);
                ItemStack human = new ItemStack(Material.PLAYER_HEAD);
                ItemStack air = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);
                ItemStack human_origin_info = new ItemStack(Material.FILLED_MAP);
                ItemStack blank = new ItemStack(Material.PAPER);
                ItemStack eye_origin = new ItemStack(Material.ENDER_EYE);

                ItemMeta eye_origin_meta = eye_origin.getItemMeta();
                eye_origin_meta.setDisplayName(ChatColor.GOLD + "Orb of Origin");
                eye_origin.setItemMeta(eye_origin_meta);

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


                ItemStack[] humangui_items = {close, air, air, air, eye_origin, air, air, air, close, air, air, air, air, human, air, air, air, air, air, air, blank, blank, human_origin_info, blank, blank, air, air, air, air, blank, blank, blank, blank, blank, air, air, air, air, air, air, air, air, air, air, air, air, air, air, air, next, air, air, air, air};
                humangui.setContents(humangui_items);
                p.openInventory(humangui);
            } else {
                p.sendMessage(ChatColor.RED + "You have already chosen an origin. Ask server operator for origin change, or craft the Orb of Origin to change your origin.");
            }
        }

    }
