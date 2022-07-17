package me.nelson131.msg.gui;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import static me.nelson131.msg.gui.Gui.inv;

public class SoundChooseCommand implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if(!(sender instanceof Player)){
            sender.sendMessage("You are not a player");
            return false;
        }
        Player player = (Player) sender;
        player.openInventory(inv);
        return true;
    }
}
