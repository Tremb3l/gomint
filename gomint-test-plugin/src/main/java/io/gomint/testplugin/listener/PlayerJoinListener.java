package io.gomint.testplugin.listener;

import io.gomint.event.EventHandler;
import io.gomint.event.EventListener;
import io.gomint.event.EventPriority;
import io.gomint.event.player.PlayerJoinEvent;
import io.gomint.inventory.item.ItemCake;
import io.gomint.inventory.item.ItemChest;
import io.gomint.inventory.item.ItemPlank;
import io.gomint.inventory.item.ItemShovel;
import io.gomint.inventory.item.ItemWoodenShovel;
import io.gomint.testplugin.TestPlugin;
import io.gomint.testplugin.scoreboard.DebugScoreboard;
import io.gomint.world.Gamemode;
import lombok.RequiredArgsConstructor;

/**
 * @author geNAZt
 * @version 1.0
 */
@RequiredArgsConstructor
public class PlayerJoinListener implements EventListener {

    private final TestPlugin plugin;

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onPlayerJoin(PlayerJoinEvent event) {
        // Set to allow all permissions
        event.getPlayer().getPermissionManager().setPermission("*", true);

        // event.getPlayer().setGamemode( Gamemode.CREATIVE );

        // Give this player the debug scoreboard
        new DebugScoreboard(this.plugin, event.getPlayer());

        event.getPlayer().getInventory().setItem(6, ItemChest.create(1));
    }

}
