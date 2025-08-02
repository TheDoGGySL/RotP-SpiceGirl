package com.thedoggy.spice_girl_addon.action;


import com.github.standobyte.jojo.action.stand.StandEntityHeavyAttack;
import com.github.standobyte.jojo.action.stand.punch.StandEntityPunch;
import com.github.standobyte.jojo.client.sound.ClientTickingSoundsHelper;
import com.github.standobyte.jojo.entity.stand.StandEntity;
import com.github.standobyte.jojo.entity.stand.StandPose;
import com.github.standobyte.jojo.util.mc.damage.StandEntityDamageSource;
import com.thedoggy.spice_girl_addon.init.InitEffects;
import com.thedoggy.spice_girl_addon.init.InitSounds;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.SoundCategory;


public class SpiceGirlFinisher extends StandEntityHeavyAttack {
    public static final StandPose FINISHER = new StandPose("finisherPunch");

    public SpiceGirlFinisher(StandEntityHeavyAttack.Builder builder) {
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
//            if (living.hasEffect(InitEffects.BOUNCE_EFFECT.get())) {
//                ClientTickingSoundsHelper.playVoiceLine(stand.getUser(), InitSounds.TRISH_ARIVIDERCHI.get(), SoundCategory.PLAYERS, 1f, 1f, true);
//            }
            if (target instanceof LivingEntity) {
                living.addEffect(new EffectInstance(InitEffects.BOUNCE_EFFECT.get(), 300, 1, false, false, false));
                living.addEffect(new EffectInstance(Effects.CONFUSION, 50, 0, false, false, false));
                // хуйня living.addEffect(new EffectInstance(Effects.GLOWING, 600, 0, false, false, false));
            }
        }
        return super.punchEntity(stand, target, dmgSource).addKnockback(0.5F + stand.getLastHeavyFinisherValue())
                .knockbackXRot(-10.0F);
    }
}



