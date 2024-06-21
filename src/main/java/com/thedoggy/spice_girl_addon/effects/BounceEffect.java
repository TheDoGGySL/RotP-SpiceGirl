package com.thedoggy.spice_girl_addon.effects;

import com.github.standobyte.jojo.potion.IApplicableEffect;
import com.thedoggy.spice_girl_addon.SpiceGirl;
import com.thedoggy.spice_girl_addon.event.BounceTimedEvent;
import com.thedoggy.spice_girl_addon.event.EventQueue;
import com.thedoggy.spice_girl_addon.init.InitEffects;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectType;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraftforge.event.entity.living.*;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = SpiceGirl.MOD_ID)
public class BounceEffect extends Effect implements IApplicableEffect {
    public BounceEffect(int color) {
        super(EffectType.BENEFICIAL, color);
    }

    @Override
    public boolean isApplicable(LivingEntity entity) {
        return !(entity instanceof PlayerEntity && ((PlayerEntity) entity).abilities.instabuild);
    }

    @SubscribeEvent
    public static void onFall(LivingFallEvent event) {
        LivingEntity entity = event.getEntityLiving();
        if (entity == null || !entity.hasEffect(InitEffects.BOUNCE_EFFECT.get())) {
            return;
        }
        boolean isPlayer = entity instanceof PlayerEntity;
        boolean isClient = entity.level.isClientSide;
        if (isClient && !isPlayer) {
            return;
        }
        if (event.getDistance() > 2) {
            if (entity.isCrouching()) {
                event.setDamageMultiplier(0.0f);
            } else {
                event.setDamageMultiplier(0);
                entity.fallDistance = 0.0F;
                if (!isPlayer || isClient) {
                    double f = 0.95d - .1 * entity.getEffect(InitEffects.BOUNCE_EFFECT.get()).getAmplifier();
                    // only slow down half as much when bouncing
                    entity.setDeltaMovement(entity.getDeltaMovement().x / f, entity.getDeltaMovement().y * (-0.9), entity.getDeltaMovement().z / f);
                    entity.setOnGround(false);
                }
                if (isClient) {
                    EventQueue.getClientQueue().addEvent(new BounceTimedEvent(entity, entity.getDeltaMovement().y));
                } else {
                    EventQueue.getServerInstance().addEvent(new BounceTimedEvent(entity, entity.getDeltaMovement().y));
                }
                event.setCanceled(true);
            }
        }
    }

    @SubscribeEvent
    public static void onFlyWallDamage(LivingHurtEvent event) {
        LivingEntity entity = event.getEntityLiving();
        if (entity == null || !entity.hasEffect(InitEffects.BOUNCE_EFFECT.get())) {
            return;
        }
        boolean isPlayer = entity instanceof PlayerEntity;
        if (isPlayer) {
            if (event.getSource() == DamageSource.FLY_INTO_WALL) {
                event.setAmount(0);
            }
            if (entity.isFallFlying()) {
                Vector3d lookAngle = entity.getLookAngle();
                entity.setDeltaMovement(lookAngle.scale(-2));
            }
        }
    }
    @SubscribeEvent
    public static void whenInWater(LivingEvent.LivingUpdateEvent event) {
        LivingEntity entity = event.getEntityLiving();
        if ((entity instanceof PlayerEntity && entity.level.isClientSide()) || !entity.level.isClientSide()){
            if (entity.isInWater() && entity.hasEffect(InitEffects.BOUNCE_EFFECT.get())){
                entity.setDeltaMovement(entity.getDeltaMovement().x(), 0.1, entity.getDeltaMovement().z());
            }
        }
    }
    // 3 часа мучений от мистера биста part 2
    @SubscribeEvent
    public static void onKnockback(LivingKnockBackEvent event) {
        LivingEntity entity = event.getEntityLiving();
        if (entity.hasEffect(InitEffects.BOUNCE_EFFECT.get())) {
            event.setStrength(1.5F*(entity.getEffect(InitEffects.BOUNCE_EFFECT.get()).getAmplifier()+1));
        }
    }
}




