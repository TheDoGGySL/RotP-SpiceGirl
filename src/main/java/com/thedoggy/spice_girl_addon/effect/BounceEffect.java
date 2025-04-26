package com.thedoggy.spice_girl_addon.effect;

import com.github.standobyte.jojo.potion.IApplicableEffect;
import com.thedoggy.spice_girl_addon.SpiceGirl;
import com.thedoggy.spice_girl_addon.init.InitEffects;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.AbstractArrowEntity;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectType;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.EntityRayTraceResult;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.ProjectileImpactEvent;
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
        if ((entity instanceof PlayerEntity && entity.level.isClientSide()) || !entity.level.isClientSide()) {
            if (entity.isInWater() && entity.hasEffect(InitEffects.BOUNCE_EFFECT.get())) {
                entity.setDeltaMovement(entity.getDeltaMovement().x(), 0.1, entity.getDeltaMovement().z());
            }
        }
    }

    // 3 часа мучений от мистера биста part 2
    @SubscribeEvent
    public static void onKnockback(LivingKnockBackEvent event) {
        LivingEntity entity = event.getEntityLiving();
        if (entity.hasEffect(InitEffects.BOUNCE_EFFECT.get())) {
            event.setStrength(1.5F * (entity.getEffect(InitEffects.BOUNCE_EFFECT.get()).getAmplifier() + 1));
        }
    }
    @SubscribeEvent
    public static void onProjectileImpact(ProjectileImpactEvent event) {
        RayTraceResult result = event.getRayTraceResult();
        if (result.getType() == RayTraceResult.Type.ENTITY) {
            EntityRayTraceResult entityResult = (EntityRayTraceResult) result;
            Entity target = entityResult.getEntity();

            if (target instanceof PlayerEntity) {
                PlayerEntity player = (PlayerEntity) target;

                if (player.hasEffect(InitEffects.BOUNCE_EFFECT.get())) {
                    event.setCanceled(true);

                    Entity projectile = event.getEntity();

                    Vector3d motion = projectile.getDeltaMovement();
                    Vector3d newMotion = motion.reverse().scale(0.5);
                    projectile.setDeltaMovement(newMotion);

                    projectile.yRot += 180.0F;
                    projectile.yRot %= 360.0F;

                    if (projectile instanceof AbstractArrowEntity) {
                        AbstractArrowEntity arrow = (AbstractArrowEntity) projectile;
                        arrow.setNoGravity(false);
                    }

                    World world = player.level;
                    if (!world.isClientSide) {
                        world.addParticle(ParticleTypes.CRIT,
                                projectile.getX(),
                                projectile.getY(),
                                projectile.getZ(),
                                0, 0, 0);
                    }
                }
            }
        }
    }

    @SubscribeEvent
    public static void onLivingHurt(LivingHurtEvent event) {
        if (event.getEntityLiving() instanceof PlayerEntity) {
            PlayerEntity player = (PlayerEntity) event.getEntityLiving();

            if (player.hasEffect(InitEffects.BOUNCE_EFFECT.get())) {
                DamageSource source = event.getSource();
                if (source.getDirectEntity() instanceof ProjectileEntity) {
                    event.setCanceled(true);
                }
            }
        }
    }
}






