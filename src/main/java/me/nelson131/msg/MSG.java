package me.nelson131.msg;

import me.nelson131.msg.gui.ClickEvent;
import me.nelson131.msg.gui.Gui;
import me.nelson131.msg.gui.SoundChooseCommand;
import me.nelson131.msg.util.Team;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

public class MSG extends JavaPlugin {
    Logger log = getLogger();

    @Override
    public void onEnable() {
        log.info("Enabled MSG");
        getCommand("msg").setExecutor(new MsgCommand());
        getCommand("soundmsg").setExecutor(new SoundChooseCommand());
        getServer().getPluginManager().registerEvents(new ClickEvent(), this);
        Gui.init();
        Team.ifnull();
    }

    @Override
    public void onDisable() {

    }
}
