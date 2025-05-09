package com.thedoggy.spice_girl_addon.action;

import com.github.standobyte.jojo.action.stand.StandEntityHeavyAttack;
import com.github.standobyte.jojo.action.stand.punch.StandEntityPunch;
import com.github.standobyte.jojo.entity.stand.StandEntity;
import com.github.standobyte.jojo.entity.stand.StandPose;
import com.github.standobyte.jojo.util.mc.damage.StandEntityDamageSource;
import com.thedoggy.spice_girl_addon.init.InitEffects;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;

public class SpiceGirlHeavy extends StandEntityHeavyAttack {
    public SpiceGirlHeavy(StandEntityHeavyAttack.Builder builder) {
        super(builder);
    }

    public PlayerEntity getPlayer() {
        return player;
    }

    PlayerEntity player;

    @Override
    public StandEntityPunch punchEntity(StandEntity stand, Entity target, StandEntityDamageSource dmgSource) {
        LivingEntity living = (LivingEntity) target;
        if (target != null) {

            living.addEffect(new EffectInstance(InitEffects.BOUNCE_EFFECT.get(), 300, 0, false, false, false));
            living.addEffect(new EffectInstance(Effects.CONFUSION, 50, 0, false, false, false));
        }

        return super.punchEntity(stand, target, dmgSource).addKnockback(0.5F + stand.getLastHeavyFinisherValue())
                .knockbackXRot(-10.0F);
    }
}

