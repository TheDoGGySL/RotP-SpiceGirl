package com.thedoggy.spice_girl_addon.action;

import com.github.standobyte.jojo.action.stand.StandEntityAction;
import com.github.standobyte.jojo.entity.stand.StandEntity;
import com.github.standobyte.jojo.entity.stand.StandEntityTask;
import com.github.standobyte.jojo.entity.stand.StandPose;
import com.github.standobyte.jojo.power.impl.stand.IStandPower;
import com.thedoggy.spice_girl_addon.init.InitEffects;
import com.thedoggy.spice_girl_addon.init.InitSounds;
import net.minecraft.potion.EffectInstance;
import net.minecraft.world.World;


public class SpiceGirlBounceHer extends StandEntityAction {
    public SpiceGirlBounceHer(StandEntityAction.Builder builder) {
        super(builder);
    }
    public static final StandPose BOUNCE_HER = new StandPose("selfPunch");

    @Override
    public void standPerform(World world, StandEntity standEntity, IStandPower userPower, StandEntityTask task) {
        if (!world.isClientSide) {
            userPower.getUser().addEffect(new EffectInstance(InitEffects.BOUNCE_EFFECT.get(), 750, 0, false, false));
            standEntity.playSound(InitSounds.SPICE_GIRL_ABILITY_FIRST.get(),1.0f,1.0f);
        }
    }
}