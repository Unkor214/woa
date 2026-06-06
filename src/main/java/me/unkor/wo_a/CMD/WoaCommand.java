package me.unkor.wo_a.CMD;

import me.unkor.wo_a.Wo_a;
import me.unkor.wo_a.items.WoaStick;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class WoaCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label,
                             @NotNull String @NotNull [] args) {
        if (args[0] == "apply") {
            if (args[1] == "player") {
                Player player = Bukkit.getPlayer(args[2]);

                player.getScoreboard().getTeam(Wo_a.getInstance().getConfig().getString("everyone_team")).addPlayer(player);
                player.sendMessage(Wo_a.getInstance().getConfig().getString("player_message"));

                return true;
            }
        } else if (args[0] == "give") {
            if (!(sender instanceof Player)) {
                sender.sendMessage("error - you do not have inventory");
                return true;
            }

            ((Player) sender).getPlayer().getInventory().addItem(WoaStick.createItemStack());
            return true;
        }
        return false;
    }
}
