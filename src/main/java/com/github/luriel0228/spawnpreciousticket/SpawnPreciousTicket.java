package com.github.luriel0228.spawnpreciousticket;

import com.github.luriel0228.spawnpreciousticket.commands.SpawnPreciousCommand;
import com.github.luriel0228.spawnpreciousticket.listener.TicketListener;
import org.bukkit.plugin.java.JavaPlugin;

public final class SpawnPreciousTicket extends JavaPlugin {

    private static SpawnPreciousTicket instance;

    @Override
    public void onEnable() {
        instance = this;
        saveDefaultConfig();
        registerEvent();
    }

    public static SpawnPreciousTicket getInstance() {
        return instance;
    }

    private void setExecutor() {
        getCommand("스폰").setExecutor(new SpawnPreciousCommand(getConfig().getString("allowed-worlds")));
    }

    public void registerEvent() {
        getServer().getPluginManager().registerEvents(new TicketListener(), this);
    }
}
