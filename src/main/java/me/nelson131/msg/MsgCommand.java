package me.nelson131.msg;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import static me.nelson131.msg.gui.ClickEvent.*;
import static me.nelson131.msg.util.Team.*;

public class MsgCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if(!(sender instanceof Player)){
            sender.sendMessage("You are not a player");
            return false;
        }

        Player getter = Bukkit.getPlayer(args[0]);
        String gettermsg = ChatColor.GRAY + "< " + ChatColor.WHITE + sender.getName() + " says: ";
        String sendermsg = ChatColor.GRAY + "< " + ChatColor.WHITE + "To " + getter.getName() + ": ";
        Location sloc = ((Player) sender).getLocation();
        Location gloc = getter.getLocation();

        if(getter == null){
            sender.sendMessage(ChatColor.GRAY + args[0] + ChatColor.RED + "  is offline");
            return false;
        }

        for (int i = 1; i < args.length; i++) {
            gettermsg += args[i] +" ";
            sendermsg += args[i] + " ";
        }

        if(am.hasEntry(((Player) sender).getDisplayName())){
            sender.sendMessage(sendermsg);
            ((Player) sender).playSound(sloc, Sound.BLOCK_AMETHYST_BLOCK_STEP, 2.0F, 1.0F);
            if(am.hasEntry(getter.getDisplayName())){
                getter.sendMessage(gettermsg);
                getter.playSound(gloc, Sound.BLOCK_AMETHYST_CLUSTER_BREAK, 2.0F, 1.0F);
                return true;
            }
            if(note.hasEntry(getter.getDisplayName())){
                getter.sendMessage(gettermsg);
                getter.playSound(gloc, Sound.BLOCK_NOTE_BLOCK_FLUTE, 2.0F, 1.0F);
                return true;
            }
            if(mud.hasEntry(getter.getDisplayName())){
                getter.sendMessage(gettermsg);
                getter.playSound(gloc, Sound.BLOCK_MUD_BREAK, 2.0F, 1.0F);
                return true;
            }
        }

        if(mud.hasEntry(((Player) sender).getDisplayName())){
            sender.sendMessage(sendermsg);
            ((Player) sender).playSound(sloc, Sound.BLOCK_MUD_STEP, 2.0F, 1.0F);
            if(am.hasEntry(getter.getDisplayName())){
                getter.sendMessage(gettermsg);
                getter.playSound(gloc, Sound.BLOCK_AMETHYST_CLUSTER_BREAK, 2.0F, 1.0F);
                return true;
            }
            if(note.hasEntry(getter.getDisplayName())){
                getter.sendMessage(gettermsg);
                getter.playSound(gloc, Sound.BLOCK_NOTE_BLOCK_FLUTE, 2.0F, 1.0F);
                return true;
            }
            if(mud.hasEntry(getter.getDisplayName())){
                getter.sendMessage(gettermsg);
                getter.playSound(gloc, Sound.BLOCK_MUD_BREAK, 2.0F, 1.0F);
                return true;
            }
        }

        if(note.hasEntry(((Player) sender).getDisplayName())){
            sender.sendMessage(sendermsg);
            ((Player) sender).playSound(sloc, Sound.BLOCK_NOTE_BLOCK_BASS, 2.0F, 1.0F);
            if(am.hasEntry(getter.getDisplayName())){
                getter.sendMessage(gettermsg);
                getter.playSound(gloc, Sound.BLOCK_AMETHYST_CLUSTER_BREAK, 2.0F, 1.0F);
                return true;
            }
            if(note.hasEntry(getter.getDisplayName())){
                getter.sendMessage(gettermsg);
                getter.playSound(gloc, Sound.BLOCK_NOTE_BLOCK_FLUTE, 2.0F, 1.0F);
                return true;
            }
            if(mud.hasEntry(getter.getDisplayName())){
                getter.sendMessage(gettermsg);
                getter.playSound(gloc, Sound.BLOCK_MUD_BREAK, 2.0F, 1.0F);
                return true;
            }
        }

        sender.sendMessage(sendermsg);
        ((Player) sender).playSound(sloc, Sound.BLOCK_AMETHYST_BLOCK_STEP, 2.0F, 1.0F);
        getter.sendMessage(gettermsg);
        getter.playSound(gloc, Sound.BLOCK_AMETHYST_CLUSTER_BREAK, 2.0F, 1.0F);

        return true;
    }
}
