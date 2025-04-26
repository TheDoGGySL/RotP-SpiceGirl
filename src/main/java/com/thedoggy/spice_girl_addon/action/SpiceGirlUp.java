package com.thedoggy.spice_girl_addon.action;

import com.github.standobyte.jojo.action.stand.StandEntityAction;
import com.github.standobyte.jojo.action.stand.StarPlatinumInhale;
import com.github.standobyte.jojo.entity.stand.StandEntity;
import com.github.standobyte.jojo.entity.stand.StandEntityTask;
import com.github.standobyte.jojo.entity.stand.StandPose;
import com.github.standobyte.jojo.power.impl.stand.IStandPower;
import com.thedoggy.spice_girl_addon.init.InitSounds;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.World;

public class SpiceGirlUp extends StandEntityAction {
    public SpiceGirlUp(Builder builder) {
        super(builder);
    }

    public static final StandPose BOUNCE_UP = new StandPose("groundPunch");
    private static final double RANGE = 5;

    @Override
    public void standPerform(World world, StandEntity standEntity, IStandPower userPower, StandEntityTask task) {
        Vector3d wrLookVec = standEntity.getLookAngle();

        world.getEntities(standEntity, standEntity.getBoundingBox().inflate(RANGE, RANGE, RANGE),
                entity -> wrLookVec.dot(entity.position().subtract(standEntity.position()).normalize()) > 0.886
                        && entity.distanceToSqr(standEntity) > 0.5
                        && !entity.is(standEntity.getUser())).forEach(entity -> {

            if (entity.canUpdate() && entity.isOnGround()) {
                entity.setDeltaMovement(entity.getDeltaMovement().add(0, 1.5, 0));

                if (entity instanceof LivingEntity && ((LivingEntity) entity).isOnGround()) {
                    for (int i = 0; i < 8; i++) {
                        world.addParticle(ParticleTypes.ITEM_SLIME,
                                entity.getX() + (world.random.nextDouble() - 0.5) * 0.5,
                                entity.getY() + 0.1,
                                entity.getZ() + (world.random.nextDouble() - 0.5) * 0.5,
                                0, 0, 0);
                    }
                }
                standEntity.playSound(InitSounds.SPICE_GIRL_ABILITY_FIRST.get(), 1.0f, 1.0f);
            }
        });

        if (standEntity.getUser() instanceof LivingEntity) {
            LivingEntity user = (LivingEntity) standEntity.getUser();
            if (user.isOnGround()) {
                world.addParticle(ParticleTypes.ITEM_SLIME,
                        user.getX(), user.getY() + 0.1, user.getZ(), 0, 0, 0);
            }
        }
    }
}

