package com.thedoggy.spice_girl_addon.init;

import com.github.standobyte.jojo.action.Action;
import com.github.standobyte.jojo.action.stand.*;
import com.github.standobyte.jojo.entity.stand.StandEntityType;
import com.github.standobyte.jojo.entity.stand.StandPose;
import com.github.standobyte.jojo.init.power.stand.EntityStandRegistryObject;
import com.github.standobyte.jojo.init.power.stand.ModStandsInit;
import com.github.standobyte.jojo.power.impl.stand.StandInstance.StandPart;
import com.github.standobyte.jojo.power.impl.stand.stats.StandStats;
import com.github.standobyte.jojo.power.impl.stand.type.EntityStandType;
import com.github.standobyte.jojo.power.impl.stand.type.StandType;
import com.github.standobyte.jojo.util.mod.StoryPart;
import com.thedoggy.spice_girl_addon.SpiceGirl;
import com.thedoggy.spice_girl_addon.action.*;
import com.thedoggy.spice_girl_addon.entity.SpiceGirlEntity;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;

public class InitStands {
    @SuppressWarnings("unchecked")
    public static final DeferredRegister<Action<?>> ACTIONS = DeferredRegister.create(
            (Class<Action<?>>) ((Class<?>) Action.class), SpiceGirl.MOD_ID);
    @SuppressWarnings("unchecked")
    public static final DeferredRegister<StandType<?>> STANDS = DeferredRegister.create(
            (Class<StandType<?>>) ((Class<?>) StandType.class), SpiceGirl.MOD_ID);
    
 // ======================================== Spice Girl ========================================


    public static final RegistryObject<StandEntityLightAttack> SPICE_GIRL_PUNCH = ACTIONS.register("spice_girl_punch",
            () -> new StandEntityLightAttack(new StandEntityLightAttack.Builder()
                    .punchSound(InitSounds.SPICE_GIRL_PUNCH_LIGHT)
                    .standSound(StandEntityAction.Phase.WINDUP, false, InitSounds.SPICE_GIRL_PUNCH_VOICE)
            ));

    public static final RegistryObject<StandEntityMeleeBarrage> SPICE_GIRL_BARRAGE = ACTIONS.register("spice_girl_barrage",
            () -> new StandEntityMeleeBarrage(new StandEntityMeleeBarrage.Builder()
                    .standPose(new StandPose("barrage"))
                    .barrageHitSound(InitSounds.SPICE_GIRL_PUNCH_BARRAGE)
                    .standSound(StandEntityAction.Phase.PERFORM, false, InitSounds.SPICE_GIRL_BARRAGE_VOICE)));


    public static final RegistryObject<SpiceGirlFinisher> SPICE_GIRL_FINISHER_PUNCH = ACTIONS.register("spice_girl_finisher_punch",
            () -> new SpiceGirlFinisher(new SpiceGirlFinisher.Builder() // TODO finisher ability
                    .shout(InitSounds.SPICE_GIRL_FINISHER_PUNCH_VOICE)
                    .standPose(SpiceGirlFinisher.FINISHER)
                    .punchSound(InitSounds.SPICE_GIRL_PUNCH_FINISHER)
                    .partsRequired(StandPart.ARMS)));


    public static final RegistryObject<SpiceGirlHeavy> SPICE_GIRL_HEAVY_PUNCH = ACTIONS.register("spice_girl_heavy_punch",
            () -> new SpiceGirlHeavy(new StandEntityHeavyAttack.Builder()
                    .shout(InitSounds.SPICE_GIRL_HEAVY_PUNCH_VOICE)
                    .shiftVariationOf(SPICE_GIRL_PUNCH).shiftVariationOf(SPICE_GIRL_BARRAGE)
                    .setFinisherVariation(SPICE_GIRL_FINISHER_PUNCH)
                    .punchSound(InitSounds.SPICE_GIRL_PUNCH_HEAVY)
                    .partsRequired(StandPart.ARMS)));

    public static final RegistryObject<StandEntityAction> SPICE_GIRL_BLOCK = ACTIONS.register("spice_girl_block",
            () -> new StandEntityBlock());

    public static final RegistryObject<SpiceGirlSoftBlock> SPICE_GIRL_SOFT_BLOCK = ACTIONS.register("spice_girl_soft_block",
            () -> new SpiceGirlSoftBlock(new StandEntityAction.Builder()
                    .standPose(SpiceGirlSoftBlock.SOFT_BLOCK)
                    .staminaCostTick(3F).cooldown(100)
                    .holdToFire(20, false)
                    .shout(InitSounds.SPICE_GIRL_ABILITY_FIRST_VOICE)
                    .standOffsetFront()
                    .resolveLevelToUnlock(1)
                    .partsRequired(StandPart.MAIN_BODY)));

    public static final RegistryObject<SpiceGirlWallClimb> SPICE_GIRL_WALL_CLIMB = ACTIONS.register("spice_girl_wall_climb",
            () -> new SpiceGirlWallClimb(new SpiceGirlWallClimb.Builder()
                    .shout(InitSounds.SPICE_GIRL_HEAVY_PUNCH_VOICE)
                    .partsRequired(StandPart.ARMS)));

    public static final RegistryObject<SpiceGirlBounce> SPICE_GIRL_BOUNCE = ACTIONS.register("spice_girl_bounce",
            () -> new SpiceGirlBounce(new StandEntityLightAttack.Builder()
                    .standPose(SpiceGirlBounce.BOUNCE)
                    .staminaCost(250)
                    .standOffsetFront()
                    .cooldown(160)
                    .standPose(SpiceGirlBounce.BOUNCE)
                    .shout(InitSounds.SPICE_GIRL_ABILITY_FIRST_VOICE)
                    .standSound(InitSounds.SPICE_GIRL_ABILITY_SECOND)
                    .partsRequired(StandPart.ARMS)));

    public static final RegistryObject<SpiceGirlBounceHer> SPICE_GIRL_BOUNCE_HER = ACTIONS.register("spice_girl_bounce_her",
            () -> new SpiceGirlBounceHer(new StandEntityAction.Builder().holdType(80).staminaCostTick(3F).cooldown(160)
                    .shout(InitSounds.SPICE_GIRL_ABILITY_FIRST_VOICE)
                    .standPose(SpiceGirlBounceHer.BOUNCE_HER)
                    .holdToFire(10, false)
                    .shiftVariationOf(SPICE_GIRL_BOUNCE)
                    .resolveLevelToUnlock(1)
                    .partsRequired(StandPart.MAIN_BODY)));


    public static final RegistryObject<SpiceGirlUp> SPICE_GIRL_BOUNCE_UP = ACTIONS.register("spice_girl_bounce_up",
            () -> new SpiceGirlUp(new SpiceGirlUp.Builder()
                    .shout(InitSounds.SPICE_GIRL_ABILITY_SECOND_VOICE)
                    .resolveLevelToUnlock(2)
                    .standOffsetFront()
                    .holdToFire(20, false)
                    .cooldown(200)
                    .standPose(SpiceGirlUp.BOUNCE_UP)
                    .standSound(InitSounds.SPICE_GIRL_ABILITY_FIRST)
                    .partsRequired(StandPart.MAIN_BODY)));

    public static final RegistryObject<SpiceGirlUpHer> SPICE_GIRL_BOUNCE_UP_HER = ACTIONS.register("spice_girl_bounce_up_her",
            () -> new SpiceGirlUpHer(new SpiceGirlUpHer.Builder()
                    .shiftVariationOf(SPICE_GIRL_BOUNCE_UP)
                    .standPose(SpiceGirlUpHer.BOUNCE_UP_HER)
                    .standOffsetFromUser(0, 2)
                    .resolveLevelToUnlock(3)
                    .holdToFire(20, false)
                    .shout(InitSounds.SPICE_GIRL_ABILITY_SECOND_VOICE)
                    .standSound(InitSounds.SPICE_GIRL_ABILITY_FIRST)
                    .cooldown(175)
                    .partsRequired(StandPart.MAIN_BODY)));


    public static final EntityStandRegistryObject<EntityStandType<StandStats>, StandEntityType<SpiceGirlEntity>> STAND_SPICE_GIRL =
            new EntityStandRegistryObject<>("spice_girl",
                    STANDS, 
                    () -> new EntityStandType.Builder<StandStats>()
                    .color(0xFFB4D5)
                    .storyPartName(StoryPart.GOLDEN_WIND.getName())
                    .leftClickHotbar(
                            SPICE_GIRL_PUNCH.get(),
                            SPICE_GIRL_BARRAGE.get(),
                            SPICE_GIRL_SOFT_BLOCK.get()
                            )
                    .rightClickHotbar(
                            SPICE_GIRL_BLOCK.get(),
                            SPICE_GIRL_WALL_CLIMB.get(),
                            SPICE_GIRL_BOUNCE.get(),
                            SPICE_GIRL_BOUNCE_UP.get()
                            )
                    .defaultStats(StandStats.class, new StandStats.Builder()
                            .power(14)
                            .speed(15)
                            .range(5, 10)
                            .durability(13)
                            .precision(7)
                            .randomWeight(0.3))
                            .addSummonShout(InitSounds.SPICE_GIRL_SUMMON_VOICE)
                    .addOst(InitSounds.SPICE_GIRL_OST)
                    .build(),
                    
                    InitEntities.ENTITIES,
                    () -> new StandEntityType<SpiceGirlEntity>(SpiceGirlEntity::new, 0.7F, 2.1F)
                    .summonSound(InitSounds.SPICE_GIRL_SUMMON_SOUND)
                    .unsummonSound(InitSounds.SPICE_GIRL_UNSUMMON_SOUND))
            .withDefaultStandAttributes();
    

    

    
    
    
}
