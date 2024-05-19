package com.thedoggy.spice_girl_addon;

import com.thedoggy.spice_girl_addon.init.InitEntities;
import com.thedoggy.spice_girl_addon.init.InitSounds;
import com.thedoggy.spice_girl_addon.init.InitStands;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


@Mod(SpiceGirl.MOD_ID)
public class SpiceGirl {
    public static final String MOD_ID = "rotp_sg";
    public static final Logger LOGGER = LogManager.getLogger();

    public SpiceGirl() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        InitEntities.ENTITIES.register(modEventBus);
        InitSounds.SOUNDS.register(modEventBus);
        InitStands.ACTIONS.register(modEventBus);
        InitStands.STANDS.register(modEventBus);


        }
    }
