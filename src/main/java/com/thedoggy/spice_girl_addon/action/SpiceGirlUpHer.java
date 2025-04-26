package com.thedoggy.spice_girl_addon.action;

import com.github.standobyte.jojo.action.stand.StandEntityAction;
import com.github.standobyte.jojo.entity.stand.StandEntity;
import com.github.standobyte.jojo.entity.stand.StandEntityTask;
import com.github.standobyte.jojo.entity.stand.StandPose;
import com.github.standobyte.jojo.power.impl.stand.IStandPower;
import com.thedoggy.spice_girl_addon.init.InitSounds;
import net.minecraft.command.arguments.EntityAnchorArgument;
import net.minecraft.entity.LivingEntity;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.World;


public class SpiceGirlUpHer extends StandEntityAction {
    public SpiceGirlUpHer(Builder builder) {
        super(builder);
    }

    public static final StandPose BOUNCE_UP_HER = new StandPose("groundPunchSelf");

    @Override
    public void standPerform(World world, StandEntity standEntity, IStandPower userPower, StandEntityTask task) {
        if (!world.isClientSide) {
            LivingEntity user = userPower.getUser();
            if (user.isOnGround()) {
                Vector3d currentMotion = user.getDeltaMovement();
                user.setDeltaMovement(currentMotion.x, 1.7D, currentMotion.z);
                user.hurtMarked = true;
                standEntity.lookAt(EntityAnchorArgument.Type.EYES, user.position());

                world.playSound(null, user.getX(), user.getY(), user.getZ(),
                        InitSounds.SPICE_GIRL_ABILITY_FIRST.get(), SoundCategory.PLAYERS,
                        1.0F, 1.0F);
            }
        }
    }
}