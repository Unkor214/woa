package me.unkor.wo_a.events;

import com.destroystokyo.paper.Title;
import me.unkor.wo_a.Wo_a;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.*;

public class PlayerEvents implements Listener {
    @EventHandler(priority = EventPriority.HIGH)
    public static final void giveTagForFp (PlayerJoinEvent event) {
        OfflinePlayer player = event.getPlayer();

        if (event.getPlayer().getScoreboard().getPlayerTeam(player) != null) return;
    }

    @EventHandler(priority = EventPriority.LOW)
    public static final void stopWoaPlayer(PlayerMoveEvent event) {
        OfflinePlayer player = event.getPlayer();

        if (event.getPlayer().getScoreboard().getPlayerTeam(player) != null) return;

        event.getPlayer().sendTitle(new Title(Wo_a.getInstance().getConfig().getString("title")));
        event.setCancelled(true);
    }

    @EventHandler(priority = EventPriority.HIGH)
    public static final void deInteractiveWoaPlayer(PlayerInteractEvent event) {
        if (event.getPlayer().getScoreboard().getPlayerTeam(event.getPlayer()) != null) return;

        event.getPlayer().sendTitle(new Title(Wo_a.getInstance().getConfig().getString("title")));
        event.setCancelled(true);
    }

    @EventHandler(priority = EventPriority.HIGH)
    public static final void dontGetDamageWoaPlayer(EntityDamageEvent event) {
        if (!(event.getEntity() instanceof Player)) return;

        OfflinePlayer player = (OfflinePlayer) event.getEntity();
        if (((Player) event.getEntity()).getPlayer().getScoreboard().getPlayerTeam(
                ((Player) event.getEntity()).getPlayer()) != null) return;

        event.setCancelled(true);
    }

}
