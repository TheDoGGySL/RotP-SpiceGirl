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
	private final ModelRenderer eyes;
	private final ModelRenderer breasts;
	private final ModelRenderer chains;
	private final ModelRenderer rightwing_r1;
	private final ModelRenderer breast2_r1;
	private final ModelRenderer breast1_r1;
	private final ModelRenderer chain6_r1;
	private final ModelRenderer chain2_r1;
	private final ModelRenderer chain5_r1;
	private final ModelRenderer chain4_r1;
	private final ModelRenderer chain3_r1;
	private final ModelRenderer chain1_r1;
	private final ModelRenderer leftwing_r1;

	public SpiceGirlModel() {
		super();
		addHumanoidBaseBoxes(null);
		texWidth = 128;
		texHeight = 128;


		eyes = new ModelRenderer(this);
		eyes.setPos(0.0F, -2.9F, -4.025F);
		head.addChild(eyes);
		eyes.texOffs(50, 73).addBox(-3.0F, -1.0F, 0.0F, 2.0F, 1.0F, 0.0F, 0.0F, true);
		eyes.texOffs(50, 73).addBox(1.0F, -1.0F, 0.0F, 2.0F, 1.0F, 0.0F, 0.0F, false);
		eyes.texOffs(34, 1).addBox(-4.0F, -5.1F, 0.025F, 8.0F, 7.0F, 8.0F, 0.0F, false);
		eyes.texOffs(67, 39).addBox(-4.0F, 1.9F, 0.025F, 8.0F, 1.0F, 3.0F, 0.0F, false);
		eyes.texOffs(75, 3).addBox(-4.0F, 1.9F, 5.525F, 8.0F, 1.0F, 3.0F, 0.0F, false);
		eyes.texOffs(62, 59).addBox(-2.0F, 1.9F, 2.525F, 4.0F, 1.0F, 3.0F, 0.025F, false);
		eyes.texOffs(66, 27).addBox(2.5F, -5.6F, -0.475F, 2.0F, 2.0F, 9.0F, 0.0F, false);
		eyes.texOffs(98, 3).addBox(2.5F, -3.6F, 6.525F, 2.0F, 1.0F, 2.0F, 0.0F, false);
		eyes.texOffs(85, 62).addBox(2.5F, -2.6F, 5.525F, 2.0F, 3.0F, 3.0F, 0.0F, false);
		eyes.texOffs(74, 10).addBox(-4.5F, -5.6F, -0.475F, 2.0F, 2.0F, 9.0F, 0.0F, false);
		eyes.texOffs(50, 47).addBox(-4.5F, -3.6F, 6.525F, 2.0F, 1.0F, 2.0F, 0.0F, false);
		eyes.texOffs(74, 62).addBox(-4.5F, -2.6F, 5.525F, 2.0F, 3.0F, 3.0F, 0.0F, false);


		breasts = new ModelRenderer(this);
		breasts.setPos(0.0F, 25.0F, 0.0F);
		torso.addChild(breasts);


		breast2_r1 = new ModelRenderer(this);
		breast2_r1.setPos(-2.2F, -21.0F, -1.55F);
		breasts.addChild(breast2_r1);
		setRotationAngle(breast2_r1, -0.3927F, 0.0873F, 0.0F);
		breast2_r1.texOffs(111, 65).addBox(-1.5F, -2.0F, -1.0F, 3.0F, 3.0F, 2.0F, 0.25F, false);

		breast1_r1 = new ModelRenderer(this);
		breast1_r1.setPos(2.2F, -21.0F, -1.55F);
		breasts.addChild(breast1_r1);
		setRotationAngle(breast1_r1, -0.3927F, -0.0873F, 0.0F);
		breast1_r1.texOffs(113, 58).addBox(-1.5F, -2.0F, -1.0F, 3.0F, 3.0F, 2.0F, 0.25F, false);

		chains = new ModelRenderer(this);
		chains.setPos(0.0F, 24.0F, 0.0F);
		torso.addChild(chains);


		chain6_r1 = new ModelRenderer(this);
		chain6_r1.setPos(-2.75F, -13.1F, 2.15F);
		chains.addChild(chain6_r1);
		setRotationAngle(chain6_r1, 0.0873F, 0.0F, 0.0873F);
		chain6_r1.texOffs(35, 1).addBox(-1.0F, -2.0F, 0.0F, 2.0F, 4.0F, 0.0F, 0.0F, false);

		chain5_r1 = new ModelRenderer(this);
		chain5_r1.setPos(0.0F, -13.0F, 2.15F);
		chains.addChild(chain5_r1);
		setRotationAngle(chain5_r1, 0.0873F, 0.0F, 0.0F);
		chain5_r1.texOffs(96, 62).addBox(-1.0F, -2.0F, 0.0F, 2.0F, 4.0F, 0.0F, 0.0F, false);

		chain4_r1 = new ModelRenderer(this);
		chain4_r1.setPos(2.75F, -13.1F, 2.15F);
		chains.addChild(chain4_r1);
		setRotationAngle(chain4_r1, 0.0873F, 0.0F, -0.0873F);
		chain4_r1.texOffs(112, 14).addBox(-1.0F, -2.0F, 0.0F, 2.0F, 4.0F, 0.0F, 0.0F, false);

		chain3_r1 = new ModelRenderer(this);
		chain3_r1.setPos(2.75F, -13.1F, -2.15F);
		chains.addChild(chain3_r1);
		setRotationAngle(chain3_r1, -0.0873F, 0.0F, -0.0873F);
		chain3_r1.texOffs(96, 67).addBox(-1.0F, -2.0F, 0.0F, 2.0F, 4.0F, 0.0F, 0.0F, false);

		chain2_r1 = new ModelRenderer(this);
		chain2_r1.setPos(-2.75F, -13.1F, -2.15F);
		chains.addChild(chain2_r1);
		setRotationAngle(chain2_r1, -0.0873F, 0.0F, 0.0873F);
		chain2_r1.texOffs(101, 67).addBox(-1.0F, -2.0F, 0.0F, 2.0F, 4.0F, 0.0F, 0.0F, false);

		chain1_r1 = new ModelRenderer(this);
		chain1_r1.setPos(0.0F, -13.0F, -2.15F);
		chains.addChild(chain1_r1);
		setRotationAngle(chain1_r1, -0.0873F, 0.0F, 0.0F);
		chain1_r1.texOffs(106, 67).addBox(-1.0F, -2.0F, 0.0F, 2.0F, 4.0F, 0.0F, 0.0F, false);


		//Left Arm


		leftArm.texOffs(50, 51).addBox(-1.5F, -2.0F, -2.0F, 3.0F, 6.0F, 4.0F, 0.225F, false);
		leftArm.texOffs(50, 77).addBox(-1.0F, 3.0F, 1.4F, 2.0F, 2.0F, 1.0F, 0.1F, false);
		leftArm.texOffs(105, 3).addBox(-1.5F, -2.0F, -2.0F, 3.0F, 6.0F, 4.0F, -0.025F, false);
		leftArm.setPos(5.0F, -10.0F, 0.0F);


		leftForeArm.texOffs(103, 40).addBox(-1.5F, -1.125F, -2.0F, 3.0F, 6.0F, 4.0F, 0.0F, false);

		leftwing_r1 = new ModelRenderer(this);
		leftwing_r1.setPos(1.4653F, 0.9363F, 0.0F);
		leftForeArm.addChild(leftwing_r1);
		setRotationAngle(leftwing_r1, 0.0F, 0.0F, 0.2618F);
		leftwing_r1.texOffs(50, 62).addBox(-0.5F, -2.0F, -2.0F, 1.0F, 4.0F, 4.0F, 0.025F, false);

		//Right Arm


		rightArm.texOffs(101, 15).addBox(-1.5F, -2.0F, -2.0F, 3.0F, 6.0F, 4.0F, -0.025F, false);
		rightArm.texOffs(50, 77).addBox(-1.0F, 3.0F, 1.4F, 2.0F, 2.0F, 1.0F, 0.1F, true);
		rightArm.texOffs(76, 51).addBox(-1.5F, -2.0F, -2.0F, 3.0F, 6.0F, 4.0F, 0.225F, false);
		rightArm.setPos(-5.0F, -10.0F, 0.0F);


		rightForeArm.texOffs(91, 51).addBox(-1.5F, -1.125F, -2.0F, 3.0F, 6.0F, 4.0F, 0.0F, false);

		rightwing_r1 = new ModelRenderer(this);
		rightwing_r1.setPos(-1.4653F, 0.9363F, 0.0F);
		rightForeArm.addChild(rightwing_r1);
		setRotationAngle(rightwing_r1, 0.0F, 0.0F, -0.2618F);
		rightwing_r1.texOffs(102, 58).addBox(-0.5F, -2.0F, -2.0F, 1.0F, 4.0F, 4.0F, 0.025F, false);


		leftLeg.texOffs(96, 108).addBox(-1.9F, 0.0F, -2.0F, 4.0F, 6.0F, 4.0F, 0.0F, false);
		leftLeg.texOffs(76, 44).addBox(-1.5F, 5.0F, -2.4F, 3.0F, 2.0F, 1.0F, 0.1F, false);


		leftLowerLeg.texOffs(96, 118).addBox(-1.9F, -1.125F, -2.0F, 4.0F, 6.0F, 4.0F, -0.025F, false);
		leftLowerLeg.texOffs(80, 22).addBox(-1.9F, -2.125F, -2.0F, 4.0F, 7.0F, 4.0F, 0.225F, false);


		rightLeg.texOffs(64, 108).addBox(-2.1F, 0.0F, -2.0F, 4.0F, 6.0F, 4.0F, 0.0F, false);
		rightLeg.texOffs(75, 22).addBox(-1.5F, 5.0F, -2.4F, 3.0F, 2.0F, 1.0F, 0.1F, false);


		rightLowerLeg.texOffs(64, 118).addBox(-2.1F, -1.125F, -2.0F, 4.0F, 6.0F, 4.0F, -0.025F, false);
		rightLowerLeg.texOffs(50, 36).addBox(-2.1F, -2.125F, -2.0F, 4.0F, 7.0F, 4.0F, 0.225F, false);
	}


	@Override // TODO summon poses
	protected RotationAngle[][] initSummonPoseRotations() {
		return new RotationAngle[][]{
				new RotationAngle[]{
						RotationAngle.fromDegrees(head, -5.0047F, 2.4905F, -0.218F),
						RotationAngle.fromDegrees(leftArm, -224.4129F, 6.5031F, 13.6148F),
						RotationAngle.fromDegrees(leftForeArm, 0F, 0F, 27.5F),
						RotationAngle.fromDegrees(rightArm, -224.8403F, -1.51F, -14.9319F),
						RotationAngle.fromDegrees(rightForeArm, -2.4786F, 0.3262F, -27.5071F),
						RotationAngle.fromDegrees(leftLeg, 0.0F, 0.0F, -7.5F),
						RotationAngle.fromDegrees(leftLowerLeg, 15F, 0F, 0F),
						RotationAngle.fromDegrees(rightLeg, 0.0F, 0.0F, 5.0F),
						RotationAngle.fromDegrees(rightLowerLeg, 12.5F, 0F, 0F)
				},
				new RotationAngle[]{
						RotationAngle.fromDegrees(head, -2.5F, -10F, 0F),
						RotationAngle.fromDegrees(leftArm, 2.5F, 0F, -20F),
						RotationAngle.fromDegrees(leftForeArm, 0F, 0F, 35F),
						RotationAngle.fromDegrees(rightArm, -155.1336F, 47.9464F, 11.6444F),
						RotationAngle.fromDegrees(rightForeArm, -12.5F, 0.0F, 0.0F),
						RotationAngle.fromDegrees(leftLeg, -34.589F, -5.7162F, -10.7189F),
						RotationAngle.fromDegrees(leftLowerLeg, 42.5F, 0F, 0F),
						RotationAngle.fromDegrees(rightLeg, -37.2625F, 4.5575F, 8.4627F),
						RotationAngle.fromDegrees(rightLowerLeg, 47.5F, 0F, 0F)
				},
				new RotationAngle[]{
						RotationAngle.fromDegrees(head, 45F, 7.5F, 0F),
						RotationAngle.fromDegrees(torso, 2.5F, 0F, 0F),
						RotationAngle.fromDegrees(leftArm, 0F, 0F, -7.5F),
						RotationAngle.fromDegrees(leftForeArm, -59.2981F, 17.0434F, -4.4859F),
						RotationAngle.fromDegrees(rightArm, 0F, 0F, 5F),
						RotationAngle.fromDegrees(rightForeArm, -52.0484F, -17.0334F, 5.7929F),
						RotationAngle.fromDegrees(leftLeg, -114.3606F, -3.1034F, -0.6882F),
						RotationAngle.fromDegrees(leftLowerLeg, 72.5F, 0F, 0F),
						RotationAngle.fromDegrees(rightLeg, -110.0F, 0.0F, 0F),
						RotationAngle.fromDegrees(rightLowerLeg, 67.5F, 0F, 2.5F)
				},
		};
	}

	@Override
	protected void initActionPoses() {
		actionAnim.put(SpiceGirlBounce.BOUNCE, new PosedActionAnimation.Builder<SpiceGirlEntity>()
				.addPose(StandEntityAction.Phase.BUTTON_HOLD, new ModelPose<>(new RotationAngle[]{
						new RotationAngle(body, 0.0F, 0.0F, 0.0F),
						new RotationAngle(rightArm, -1.5708F, 0.3927F, 0.1F),
						new RotationAngle(rightForeArm, 0.0F, -1.5708F, -0.3927F),
				}))
				.build(idlePose));
		actionAnim.put(SpiceGirlUp.BOUNCE_UP, new PosedActionAnimation.Builder<SpiceGirlEntity>()
				.addPose(StandEntityAction.Phase.BUTTON_HOLD, new ModelPose<>(new RotationAngle[]{
						new RotationAngle(body, 0.0F, 0.0F, 0.0F),
						new RotationAngle(leftArm, -1.5708F, -0.3927F, 0.0F),
						new RotationAngle(leftForeArm, 0.0F, 1.5708F, 0.3927F),
						new RotationAngle(rightArm, -1.5708F, 0.3927F, 0.0F),
						new RotationAngle(rightForeArm, 0.0F, -1.5708F, -0.3927F),
				}))
				.build(idlePose));
		super.initActionPoses();


	}

	@Override // TODO idle pose
	protected ModelPose<SpiceGirlEntity> initIdlePose() {
		return new ModelPose<>(new RotationAngle[]{
				RotationAngle.fromDegrees(leftArm, -2.1379F, -3.1217F, -19.7644F),
				RotationAngle.fromDegrees(leftForeArm, -7.2472F, 1.936F, 19.8774F),
				RotationAngle.fromDegrees(rightArm, -2.0555F, 2.2454F, 14.8737F),
				RotationAngle.fromDegrees(rightForeArm, -7.4718F, -0.6518F, -14.9574F),
				RotationAngle.fromDegrees(leftLeg, -2.5F, 0F, -2.5F),
				RotationAngle.fromDegrees(leftLowerLeg, 4.9811F, 0.4352F, -4.9811F),
				RotationAngle.fromDegrees(rightLeg, -4.9953F, 0.2178F, 4.9905F),
				RotationAngle.fromDegrees(rightLowerLeg, 7.4929F, -0.3262F, 2.4786F)
		});
	}

	@Override
	protected ModelPose<SpiceGirlEntity> initIdlePose2Loop() {
		return new ModelPose<>(new RotationAngle[]{
				RotationAngle.fromDegrees(leftArm, -1.9996F, -3.212F, -22.2666F),
				RotationAngle.fromDegrees(leftForeArm, -9.6566F, 2.2494F, 22.3593F),
				RotationAngle.fromDegrees(rightArm, -1.9556F, 2.3329F, 17.3741F),
				RotationAngle.fromDegrees(rightForeArm, -9.9366F, -0.9762F, -17.4366F),
				RotationAngle.fromDegrees(leftLeg, -5F, 0F, -2.5F),
				RotationAngle.fromDegrees(leftLowerLeg, 4.9953F, 0.2178F, -2.4905F),
				RotationAngle.fromDegrees(rightLeg, -7.4953F, 0.2178F, 4.9905F),
				RotationAngle.fromDegrees(rightLowerLeg, 7.5F, 0F, 0F)
		});
	}
}



