package com.thedoggy.spice_girl_addon.action;

import com.github.standobyte.jojo.action.ActionConditionResult;
import com.github.standobyte.jojo.action.ActionTarget;
import com.github.standobyte.jojo.action.stand.StandEntityAction;
import com.github.standobyte.jojo.entity.stand.StandEntity;
import com.github.standobyte.jojo.power.impl.stand.IStandPower;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.World;


public class SpiceGirlWallClimb extends StandEntityAction {
    private StandEntity standEntity;

    public SpiceGirlWallClimb(Builder builder) {
        super(builder.holdType());
    }
    @Override
    protected ActionConditionResult checkSpecificConditions(LivingEntity user, IStandPower power, ActionTarget target) {
        if (user.horizontalCollision){
            return ActionConditionResult.POSITIVE;
        }
        return ActionConditionResult.NEGATIVE;
    }

    @Override
    protected void holdTick(World world, LivingEntity user, IStandPower userPower, int ticksHeld, ActionTarget target, boolean requirementsFulfilled) {
        if (world.isClientSide() && user.horizontalCollision) {
            Vector3d movement = user.getLookAngle();
            user.setDeltaMovement(movement.x / 3, movement.y/3, movement.z / 3);

        }

        }
    }
