package com.thedoggy.spice_girl_addon.event;

import com.github.standobyte.jojo.power.impl.stand.IStandPower;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class SoftBlockManager {
    private static final Map<RegistryKey<World>, Map<BlockPos, Long>> softBlocks = new ConcurrentHashMap<>();

    public static void addSoftBlock(World world, BlockPos pos) {
        RegistryKey<World> dimension = world.dimension();
        long expirationTime = world.getGameTime() + 450;
        softBlocks.computeIfAbsent(dimension, k -> new HashMap<>())
                .put(pos.immutable(), expirationTime);
    }
    public static void removeSoftBlock(World world, BlockPos pos) {
        RegistryKey<World> dimension = world.dimension();
        if (softBlocks.containsKey(dimension)) {
            softBlocks.get(dimension).remove(pos);
        }
    }

    public static boolean isInSoftArea(World world, BlockPos  pos) {
        RegistryKey<World> dimension = world.dimension();
        Map<BlockPos, Long> dimensionMap = softBlocks.get(dimension);
        if (dimensionMap == null) return false;

        Long expiration = dimensionMap.get(pos);
        return expiration != null && expiration > world.getGameTime();
    }

    public static void tick(World world) {
        RegistryKey<World> dimension = world.dimension();
        Map<BlockPos, Long> dimensionMap = softBlocks.get(dimension);
        if (dimensionMap == null) return;

        long currentTime = world.getGameTime();
        dimensionMap.entrySet().removeIf(entry -> entry.getValue() <= currentTime);
    }
}
