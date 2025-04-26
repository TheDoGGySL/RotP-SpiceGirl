package com.thedoggy.spice_girl_addon.event;

import com.thedoggy.spice_girl_addon.SpiceGirl;
import net.minecraft.world.World;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = SpiceGirl.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class WorldEventHandler {

    @SubscribeEvent
    public static void onWorldTick(TickEvent.WorldTickEvent event) {
        if (event.phase == TickEvent.Phase.END) {
            SoftBlockManager.tick(event.world);
        }
    }
    @SubscribeEvent
    public static void onBlockBreak(BlockEvent.BreakEvent event) {
        if (!event.getWorld().isClientSide()) {
            SoftBlockManager.removeSoftBlock((World) event.getWorld(), event.getPos());
        }
    }
}

