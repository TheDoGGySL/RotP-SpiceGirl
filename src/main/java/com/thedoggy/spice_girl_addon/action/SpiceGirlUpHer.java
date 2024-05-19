package com.thedoggy.spice_girl_addon.action;

import com.github.standobyte.jojo.action.ActionConditionResult;
import com.github.standobyte.jojo.action.ActionTarget;
import com.github.standobyte.jojo.action.stand.StandEntityAction;
import com.github.standobyte.jojo.entity.stand.StandEntity;
import com.github.standobyte.jojo.entity.stand.StandEntityTask;
import com.github.standobyte.jojo.power.impl.stand.IStandPower;
import com.thedoggy.spice_girl_addon.init.InitSounds;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.world.World;


public class SpiceGirlUpHer extends StandEntityAction {
    public SpiceGirlUpHer(Builder builder) {
        super(builder);
    }


    @Override
    protected ActionConditionResult checkStandConditions(StandEntity stand, IStandPower power, ActionTarget target) {
        if (power.getStamina() < power.getMaxStamina() * 0.95f) return ActionConditionResult.NEGATIVE;
        return ActionConditionResult.POSITIVE;
    }

    @Override
    public void standPerform(World world, StandEntity standEntity, IStandPower userPower, StandEntityTask task) {
        if (!world.isClientSide) {
            userPower.getUser().addEffect(new EffectInstance(Effects.LEVITATION, 20, 24, true, false));
            standEntity.playSound(InitSounds.SPICE_GIRL_ABILITY_FIRST.get(),1.0f,1.0f);
        }
    }
}