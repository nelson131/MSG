package me.nelson131.msg.gui;

import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;
import org.w3c.dom.Text;

import java.awt.*;

import static me.nelson131.msg.gui.Gui.inv;

public class ClickEvent implements Listener {


    @EventHandler
    public void onClick(InventoryClickEvent event){
        if(!event.getInventory().equals(inv))
            return;
        if(event.getCurrentItem() == null) return;
        if(event.getCurrentItem().getItemMeta() == null) return;
        if(event.getCurrentItem().getItemMeta().getDisplayName() == null) return;

        event.setCancelled(true);

        Player player = (Player) event.getWhoClicked();
        Scoreboard scoreboard = Bukkit.getScoreboardManager().getMainScoreboard();
        Team am = scoreboard.getTeam("am");
        Team mud = scoreboard.getTeam("mud");
        Team note = scoreboard.getTeam("note");

        if(am == null){
            am = scoreboard.registerNewTeam("am");
        }
        if(mud == null){
            mud = scoreboard.registerNewTeam("mud");
        }
        if(note == null){
            note = scoreboard.registerNewTeam("note");
        }

        if(event.getSlot() == 0){
            am.addEntry(player.getName());
            note.removeEntry(player.getName());
            mud.removeEntry(player.getName());
            player.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(ChatColor.LIGHT_PURPLE + "You choose pack of Amethyst Sounds"));
        }

        if(event.getSlot() == 1){
            mud.addEntry(player.getName());
            note.removeEntry(player.getName());
            am.removeEntry(player.getName());

            player.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(ChatColor.GRAY + "You choose pack of Mud Block Sounds"));
        }

        if(event.getSlot() == 2){
            mud.removeEntry(player.getName());
            am.removeEntry(player.getName());
            note.addEntry(player.getName());
            player.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(ChatColor.BLUE + "You choose pack of Node Block Sounds"));
        }

        if(event.getSlot() == 3){
            player.closeInventory();
        }
    }
}
