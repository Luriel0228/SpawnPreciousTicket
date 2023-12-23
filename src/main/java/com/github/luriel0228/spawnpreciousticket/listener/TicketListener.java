package com.github.luriel0228.spawnpreciousticket.listener;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import static com.github.luriel0228.spawnpreciousticket.commands.SpawnPreciousCommand.playerLocations;

public class TicketListener implements Listener {

    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event) {
        Player player = event.getPlayer();

        if (playerLocations.containsKey(player)) {
            Location originalLocation = playerLocations.get(player);
            Location currentLocation = event.getTo();

            if (originalLocation != null && currentLocation != null && !originalLocation.equals(currentLocation)) {
                event.setTo(originalLocation);
            }
        }
    }


}
