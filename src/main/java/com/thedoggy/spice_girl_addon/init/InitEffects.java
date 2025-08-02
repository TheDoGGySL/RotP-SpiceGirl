package com.thedoggy.spice_girl_addon.init;


import com.thedoggy.spice_girl_addon.SpiceGirl;
import com.thedoggy.spice_girl_addon.effect.BounceEffect;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.potion.Effect;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;


public class InitEffects {

    public static final DeferredRegister<Effect> EFFECTS = DeferredRegister.create(
            ForgeRegistries.POTIONS, SpiceGirl.MOD_ID);

    public static final RegistryObject<Effect> BOUNCE_EFFECT = EFFECTS.register("bounce",
            () -> new BounceEffect(0xB1F971).addAttributeModifier(Attributes.KNOCKBACK_RESISTANCE, "03e48a50-091f-44f2-8576-354e25d423e8", -3, AttributeModifier.Operation.ADDITION)
    );
}

