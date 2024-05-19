package com.thedoggy.spice_girl_addon.init;

import java.util.function.Supplier;

import com.github.standobyte.jojo.util.mc.OstSoundList;

import com.thedoggy.spice_girl_addon.SpiceGirl;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class InitSounds {
    public static final DeferredRegister<SoundEvent> SOUNDS = DeferredRegister.create(
            ForgeRegistries.SOUND_EVENTS, SpiceGirl.MOD_ID); // TODO sounds.json


    public static final Supplier<SoundEvent> SPICE_GIRL_SUMMON_SOUND = SOUNDS.register("sg_summon",
            () -> new SoundEvent(new ResourceLocation(SpiceGirl.MOD_ID, "sg_summon")));

    public static final Supplier<SoundEvent> SPICE_GIRL_UNSUMMON_SOUND = SOUNDS.register("sg_unsummon",
            () -> new SoundEvent(new ResourceLocation(SpiceGirl.MOD_ID,"sg_unsummon")));
    
    public static final Supplier<SoundEvent> SPICE_GIRL_PUNCH_LIGHT = SOUNDS.register("sg_punch",
            () -> new SoundEvent(new ResourceLocation(SpiceGirl.MOD_ID,"sg_punch")));
    public static final Supplier<SoundEvent> SPICE_GIRL_PUNCH_HEAVY = SOUNDS.register("sg_punch_heavy",
            () -> new SoundEvent(new ResourceLocation(SpiceGirl.MOD_ID,"sg_punch_heavy")));

    public static final Supplier<SoundEvent> SPICE_GIRL_PUNCH_FINISHER = SOUNDS.register("sg_finisher",
            () -> new SoundEvent(new ResourceLocation(SpiceGirl.MOD_ID,"sg_finisher")));
    public static final Supplier<SoundEvent> SPICE_GIRL_ABILITY_FIRST = SOUNDS.register("sg_ability_1",
            () -> new SoundEvent(new ResourceLocation(SpiceGirl.MOD_ID,"sg_ability_1")));

    public static final Supplier<SoundEvent> SPICE_GIRL_ABILITY_SECOND = SOUNDS.register("sg_ability_2",
            () -> new SoundEvent(new ResourceLocation(SpiceGirl.MOD_ID,"sg_ability_2")));
    public static final Supplier<SoundEvent> SPICE_GIRL_PUNCH_VOICE = SOUNDS.register("sg_punch_voice",
            () -> new SoundEvent(new ResourceLocation(SpiceGirl.MOD_ID,"sg_punch_voice")));

    public static final Supplier<SoundEvent> SPICE_GIRL_BARRAGE_VOICE = SOUNDS.register("sg_barrage_voice",
            () -> new SoundEvent(new ResourceLocation(SpiceGirl.MOD_ID,"sg_barrage_voice")));

    public static final Supplier<SoundEvent> SPICE_GIRL_HEAVY_PUNCH_VOICE = SOUNDS.register("sg_punch_heavy_voice",
            () -> new SoundEvent(new ResourceLocation(SpiceGirl.MOD_ID,"sg_punch_heavy_voice")));

    public static final Supplier<SoundEvent> SPICE_GIRL_FINISHER_PUNCH_VOICE = SOUNDS.register("sg_punch_finisher_voice",
            () -> new SoundEvent(new ResourceLocation(SpiceGirl.MOD_ID,"sg_punch_finisher_voice")));

    public static final Supplier<SoundEvent> SPICE_GIRL_SUMMON_VOICE = SOUNDS.register("sg_summon_voice",
            () -> new SoundEvent(new ResourceLocation(SpiceGirl.MOD_ID,"sg_summon_voice")));

    public static final Supplier<SoundEvent> SPICE_GIRL_ABILITY_FIRST_VOICE = SOUNDS.register("sg_ability1_voice",
            () -> new SoundEvent(new ResourceLocation(SpiceGirl.MOD_ID,"sg_ability1_voice")));

    public static final Supplier<SoundEvent> SPICE_GIRL_ABILITY_SECOND_VOICE = SOUNDS.register("sg_ability2_voice",
            () -> new SoundEvent(new ResourceLocation(SpiceGirl.MOD_ID,"sg_ability2_voice")));


    public static final Supplier<SoundEvent> SPICE_GIRL_PUNCH_BARRAGE = InitSounds.SPICE_GIRL_PUNCH_LIGHT;

    public static final OstSoundList SPICE_GIRL_OST = new OstSoundList(
            new ResourceLocation(SpiceGirl.MOD_ID, "spice_girl_ost"), SOUNDS);


}
