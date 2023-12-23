package com.github.luriel0228.spawnpreciousticket.commands;

import com.github.luriel0228.spawnpreciousticket.SpawnPreciousTicket;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SpawnPreciousCommand implements CommandExecutor {

    private final String allowedWorlds;

    public static final java.util.Map<Player, Location> playerLocations = new java.util.HashMap<>();

    public SpawnPreciousCommand(String allowedWorlds) {
        this.allowedWorlds = allowedWorlds;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (!(sender instanceof Player player)) {
            sender.sendMessage("플레이어만 사용할 수 있는 명령어입니다.");
            return true;
        }

        playerLocations.put(player, player.getLocation());

        player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&e스폰으로 이동중입니다.."));
        Bukkit.getScheduler().runTaskLater(SpawnPreciousTicket.getInstance(), () -> teleport(player), 60L);
        return true;
    }

    private void teleport(Player player) {
        World world = Bukkit.getWorld(allowedWorlds);
        if (world != null) {
            player.teleport(world.getSpawnLocation());
            player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&e스폰으로 이동하였습니다."));
        }
        playerLocations.remove(player);

    }
}
