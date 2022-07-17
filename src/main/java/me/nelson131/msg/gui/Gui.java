package me.nelson131.msg.gui;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class Gui {
    public static Inventory inv;

    public static void init(){
        inv = Bukkit.createInventory(null, 9, "Choose sound for private messages");
        createAMsound();
        createMudsound();
        createNotesound();
        close();
    }

    public static void createAMsound(){
        ItemStack am = new ItemStack(Material.AMETHYST_BLOCK);
        ItemMeta metaAm = am.getItemMeta();
        metaAm.setDisplayName(ChatColor.LIGHT_PURPLE + "Amethyst Sounds");
        am.setItemMeta(metaAm);
        inv.setItem(0, am);
    }
    public static void createMudsound(){
        ItemStack mud = new ItemStack(Material.MUD);
        ItemMeta metamud = mud.getItemMeta();
        metamud.setDisplayName(ChatColor.GRAY + "Mud Block Sounds");
        mud.setItemMeta(metamud);
        inv.setItem(1, mud);
    }

    public static void createNotesound(){
        ItemStack am = new ItemStack(Material.NOTE_BLOCK);
        ItemMeta metaAm = am.getItemMeta();
        metaAm.setDisplayName(ChatColor.BLUE + "Note Sounds");
        am.setItemMeta(metaAm);
        inv.setItem(2, am);
    }

    public static void close(){
        ItemStack close = new ItemStack(Material.BARRIER);
        ItemMeta meta = close.getItemMeta();
        meta.setDisplayName(ChatColor.RED + "Close Menu");
        close.setItemMeta(meta);
        inv.setItem(3, close);
    }
}
