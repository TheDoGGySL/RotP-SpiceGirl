package com.thedoggy.spice_girl_addon.client.render.entity.model.stand;

import com.github.standobyte.jojo.action.stand.StandEntityAction;
import com.github.standobyte.jojo.client.render.entity.model.stand.HumanoidStandModel;
import com.github.standobyte.jojo.client.render.entity.pose.ModelPose;
import com.github.standobyte.jojo.client.render.entity.pose.RotationAngle;
import com.github.standobyte.jojo.client.render.entity.pose.anim.PosedActionAnimation;
import com.thedoggy.spice_girl_addon.action.SpiceGirlBounce;
import com.thedoggy.spice_girl_addon.action.SpiceGirlUp;
import com.thedoggy.spice_girl_addon.entity.SpiceGirlEntity;
import net.minecraft.client.renderer.model.ModelRenderer;

public class SpiceGirlModel extends HumanoidStandModel<SpiceGirlEntity> {

	public SpiceGirlModel() {
		super();
	}
	@Override
	public void prepareMobModel(SpiceGirlEntity entity, float walkAnimPos, float walkAnimSpeed, float partialTick) {
		super.prepareMobModel(entity, walkAnimPos, walkAnimSpeed, partialTick);
		}
	}



