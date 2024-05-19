package com.thedoggy.spice_girl_addon.entity;

import com.github.standobyte.jojo.entity.stand.StandEntity;
import com.github.standobyte.jojo.entity.stand.StandEntityType;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.world.World;

public class SpiceGirlEntity extends StandEntity {

    public SpiceGirlEntity(StandEntityType<SpiceGirlEntity> type, World world) {
        super(type, world);
    }

    @Override
    public void tick() {
        super.tick();
        getUser().addEffect(new EffectInstance(Effects.SLOW_FALLING, 10, 0, true, false));
    }


}
