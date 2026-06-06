package me.unkor.wo_a.CMD.TABCOM;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class WoaCommandTab implements TabCompleter {
    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command,
                                                @NotNull String label, @NotNull String @NotNull [] args) {

        if (args.length == 1) return List.of("apply", "give");
        else if (args.length == 2) {
            if (args[1].equals("apply")) {
                List<String> playerList = new ArrayList<>();

                for (Player players : Bukkit.getOnlinePlayers()) {
                    playerList.add(players.getName());
                }
                return playerList;
            }
        }
        return null;
    }
}
