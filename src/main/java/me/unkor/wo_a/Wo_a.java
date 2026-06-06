package me.unkor.wo_a;

import me.unkor.wo_a.CMD.TABCOM.WoaCommandTab;
import me.unkor.wo_a.CMD.WoaCommand;
import me.unkor.wo_a.events.PlayerEvents;
import me.unkor.wo_a.events.WoaStickEvents;
import org.bukkit.Bukkit;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.plugin.java.JavaPlugin;

public final class Wo_a extends JavaPlugin {

    private static Wo_a instance;

    @Override
    public void onEnable() {
        instance = this;
        ConsoleCommandSender ccs = Bukkit.getConsoleSender();

        saveDefaultConfig();

        ccs.sendMessage("---------------------------------------");

        ccs.sendMessage("wo_a - v1.0");
        ccs.sendMessage("everyone_team = " + getConfig().getString("everyone_team"));
        ccs.sendMessage("WithOut_Apply = " + getConfig().getString("WithOut_Apply"));

        ccs.sendMessage("set command executor for 'woa'");
        Bukkit.getPluginCommand("woa").setExecutor(new WoaCommand());
        ccs.sendMessage("set tab completer ");
        Bukkit.getPluginCommand("woa").setTabCompleter(new WoaCommandTab());

        ccs.sendMessage("set events class PlayerEvents");
        Bukkit.getPluginManager().registerEvents(new PlayerEvents(), this);

        ccs.sendMessage("set events class WoaStickEvents");
        Bukkit.getPluginManager().registerEvents(new WoaStickEvents(), this);

        ccs.sendMessage("---------------------------------------");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static Wo_a getInstance() {
        return instance;
    }
}