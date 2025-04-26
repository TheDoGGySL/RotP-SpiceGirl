package com.thedoggy.spice_girl_addon.action;

import com.github.standobyte.jojo.action.ActionTarget;
import com.github.standobyte.jojo.action.stand.StandEntityAction;
import com.github.standobyte.jojo.action.stand.StandEntityLightAttack;
import com.github.standobyte.jojo.entity.stand.StandEntity;
import com.github.standobyte.jojo.entity.stand.StandEntityTask;
import com.github.standobyte.jojo.entity.stand.StandPose;
import com.github.standobyte.jojo.power.impl.stand.IStandPower;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.potion.EffectInstance;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

import static com.thedoggy.spice_girl_addon.init.InitEffects.BOUNCE_EFFECT;

public class SpiceGirlBounce extends StandEntityLightAttack {
    boolean manifest = true;

    public static final StandPose BOUNCE = new StandPose("mobPunch");


    public SpiceGirlBounce(StandEntityLightAttack.Builder builder) {
        super(builder);
    }


    @Override
    public void standPerform(World world, StandEntity standEntity, IStandPower userPower, StandEntityTask task) {
        if (!world.isClientSide) {

            LivingEntity user = userPower.getUser();

            if (task.getTarget().getType() == ActionTarget.TargetType.ENTITY) {
                Entity target = task.getTarget().getEntity();
                if (!standEntity.isArmsOnlyMode()) {
                    standEntity.moveTo(target.position());
                }
                if (target instanceof LivingEntity) {
                    standEntity.punch(task, this, task.getTarget());

                    if (EntityRange(userPower, 16) != null) {
                        if (standEntity.isArmsOnlyMode() && target.distanceTo(standEntity) <= 3) {
                            if (target instanceof LivingEntity) {
                                LivingEntity livingTarget = (LivingEntity) target;
                                livingTarget.addEffect(new EffectInstance(BOUNCE_EFFECT.get(), 750, 0, false, false));
                            }
                        } else if (!standEntity.isArmsOnlyMode()) {
                            if (target instanceof LivingEntity) {
                            LivingEntity livingTarget = (LivingEntity) target;
                            livingTarget.addEffect(new EffectInstance(BOUNCE_EFFECT.get(), 750, 0, false, false));
                        }
                            }

                    }
                }
            }
        }

    }


    public void onTaskSet(World world, StandEntity standEntity, IStandPower standPower, StandEntityAction.Phase phase, StandEntityTask task, int ticks) {
        if (standEntity.isArmsOnlyMode() && standEntity.swingingArm == Hand.OFF_HAND) {
            standEntity.setArmsOnlyMode(true, false);
        }
        if (standEntity.isArmsOnlyMode()) {
            manifest = false;
        }

    }


    public static LivingEntity EntityRange(IStandPower userPower, double range) {
        LivingEntity user = userPower.getUser();
        World world = user.level;
        LivingEntity entidad = world.getEntitiesOfClass(LivingEntity.class, user.getBoundingBox().inflate(range)).stream().filter(entity -> !entity.getActiveEffects().contains(new EffectInstance(BOUNCE_EFFECT.get()))).findFirst().orElse(null);
        return entidad;
    }

    @Override
    protected boolean standKeepsTarget(ActionTarget target) {
        return target.getType() == ActionTarget.TargetType.ENTITY && target.getEntity() instanceof LivingEntity;
    }

    @Override
    public TargetRequirement getTargetRequirement() {
        return TargetRequirement.ENTITY;
    }

    @Override
    public boolean noAdheringToUserOffset(IStandPower standPower, StandEntity standEntity) {
        return !standEntity.isArmsOnlyMode();
    }

}





