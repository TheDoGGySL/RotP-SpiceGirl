package com.thedoggy.spice_girl_addon.client.render.entity.renderer.stand;

import com.github.standobyte.jojo.client.render.entity.model.stand.StandEntityModel;
import com.github.standobyte.jojo.client.render.entity.model.stand.StandModelRegistry;
import com.github.standobyte.jojo.client.render.entity.renderer.stand.StandEntityRenderer;
import com.thedoggy.spice_girl_addon.SpiceGirl;
import com.thedoggy.spice_girl_addon.client.render.entity.model.stand.SpiceGirlModel;
import com.thedoggy.spice_girl_addon.entity.SpiceGirlEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.util.ResourceLocation;

public class SpiceGirlRenderer extends StandEntityRenderer<SpiceGirlEntity, StandEntityModel<SpiceGirlEntity>> {

    public SpiceGirlRenderer(EntityRendererManager renderManager) {
        super(renderManager,
                StandModelRegistry.registerModel(new ResourceLocation(SpiceGirl.MOD_ID, "spice_girl"), SpiceGirlModel::new),
                new ResourceLocation(SpiceGirl.MOD_ID, "textures/entity/stand/spice_girl.png"), 0);
    }
}