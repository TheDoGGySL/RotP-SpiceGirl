package com.thedoggy.spice_girl_addon.client;

import com.thedoggy.spice_girl_addon.SpiceGirl;
import com.thedoggy.spice_girl_addon.client.render.entity.renderer.stand.SpiceGirlRenderer;
import com.thedoggy.spice_girl_addon.init.InitStands;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@EventBusSubscriber(modid = SpiceGirl.MOD_ID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientInit {

    @SubscribeEvent
    public static void onFMLClientSetup(FMLClientSetupEvent event) {
        RenderingRegistry.registerEntityRenderingHandler(InitStands.STAND_SPICE_GIRL.getEntityType(), SpiceGirlRenderer::new);
    }
}













