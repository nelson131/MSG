package me.nelson131.msg.util;

import org.bukkit.Bukkit;
import org.bukkit.scoreboard.Scoreboard;

import static me.nelson131.msg.gui.ClickEvent.*;

public class Team {

    public static org.bukkit.scoreboard.Team am;
    public static org.bukkit.scoreboard.Team mud;
    public static org.bukkit.scoreboard.Team note;
    public static Scoreboard scoreboard;
    public static void ifnull(){

        Scoreboard scoreboard = Bukkit.getScoreboardManager().getMainScoreboard();

        if(am == null){
            am = scoreboard.registerNewTeam("am");
        }
        if(mud == null){
            mud = scoreboard.registerNewTeam("mud");
        }
        if(note == null){
            note = scoreboard.registerNewTeam("note");
        }
    }
}
