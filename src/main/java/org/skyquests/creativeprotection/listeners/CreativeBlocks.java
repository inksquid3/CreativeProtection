package org.skyquests.creativeprotection.listeners;

import org.bukkit.GameMode;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;

import java.util.ArrayList;
import java.util.List;

public class CreativeBlocks implements Listener {

    private List<Block> blocks = new ArrayList<Block>();

    @EventHandler
    public void onBlockPlace(BlockPlaceEvent event) {
        Player player = event.getPlayer();
        Block block = event.getBlockPlaced();

        if(player.getGameMode() == GameMode.CREATIVE) {
            blocks.add(block);
        }
    }

    @EventHandler
    public void onBlockBreak(BlockBreakEvent event) {
        Player player = event.getPlayer();
        Block block = event.getBlock();

        if(player.getGameMode() == GameMode.SURVIVAL && blocks.contains(block)) {
            event.setCancelled(true);
        }
    }
}
