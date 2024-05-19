package com.thedoggy.spice_girl_addon.action;

import com.github.standobyte.jojo.action.stand.StandEntityAction;
import com.github.standobyte.jojo.entity.stand.StandEntity;
import com.github.standobyte.jojo.entity.stand.StandEntityTask;
import com.github.standobyte.jojo.entity.stand.StandPose;
import com.github.standobyte.jojo.power.impl.stand.IStandPower;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.World;

public class SpiceGirlBounce extends StandEntityAction {

    public static final StandPose BOUNCE = new StandPose("BOUNCE");

    public SpiceGirlBounce(Builder builder) {
        super(builder);
    }

    private static final double RANGE = 16;
    @Override
    public void standTickPerform(World world, StandEntity standEntity, IStandPower userPower, StandEntityTask task) {
        Vector3d wrLookVec = standEntity.getLookAngle();
        world.getEntities(standEntity, standEntity.getBoundingBox().inflate(RANGE, RANGE, RANGE),
                entity -> wrLookVec.dot(entity.position().subtract(standEntity.position()).normalize()) > 0.886 && entity.distanceToSqr(standEntity) > 0.5
                        && (/*standEntity.isManuallyControlled() || */!entity.is(standEntity.getUser()))).forEach(entity -> {
            if (entity.canUpdate()) {
                double distance = entity.distanceTo(standEntity);
                Vector3d pushVec = wrLookVec.normalize().scale(0.5 * standEntity.getStandEfficiency());
                entity.setDeltaMovement(distance > 2 ?
                        entity.getDeltaMovement().add(pushVec.scale(1/distance*2))
                        : pushVec.scale(Math.max(distance - 1, 0)));
                Entity effecttarget = entity;
                if (effecttarget instanceof LivingEntity){
                    LivingEntity effectTarget = (LivingEntity) effecttarget;
                    effectTarget.addEffect(new EffectInstance(Effects.SLOW_FALLING, 1200, 0));
                }
            };
        });

            }

        }


