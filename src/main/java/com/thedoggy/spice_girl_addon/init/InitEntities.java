package com.thedoggy.spice_girl_addon.init;

import com.thedoggy.spice_girl_addon.SpiceGirl;
import net.minecraft.entity.EntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class InitEntities {
    public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(
            ForgeRegistries.ENTITIES, SpiceGirl.MOD_ID);
    

};
