package me.unkor.wo_a.events;

import me.unkor.wo_a.Wo_a;
import me.unkor.wo_a.items.WoaStick;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

public class WoaStickEvents implements Listener {
    @EventHandler()
    public static void acceptPlayerStick(PlayerInteractEvent event) {
        if (!(event.getAction().isLeftClick()) && WoaStick.getStickFrom(event.getPlayer().getInventory().getItemInMainHand())
                == false)
            return;
        if (!(event.getClickedBlock() instanceof Player)) return;

        Player player = (Player) event.getClickedBlock();
        if (player.getScoreboard().getPlayerTeam(player) != null) return;

        player.getScoreboard().getTeam(Wo_a.getInstance().getConfig().getString("everyone_team"));
        event.setCancelled(true);
    }
}