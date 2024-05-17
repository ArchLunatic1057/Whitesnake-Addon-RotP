package com.bigking123.rotp_whitesnake.client.render.entity.model.stand;

import com.bigking123.rotp_whitesnake.entity.stand.stands.WhitesnakeEntity;
import com.bigking123.rotp_whitesnake.action.stand.WhitesnakeRemoveStandDisc;
import com.github.standobyte.jojo.action.stand.StandEntityAction;
import com.github.standobyte.jojo.client.render.entity.model.stand.HumanoidStandModel;
import com.github.standobyte.jojo.client.render.entity.pose.ModelPose;
import com.github.standobyte.jojo.client.render.entity.pose.RotationAngle;
import com.github.standobyte.jojo.client.render.entity.pose.anim.PosedActionAnimation;
import com.github.standobyte.jojo.entity.stand.StandPose;
import net.minecraft.client.renderer.model.ModelRenderer;

// Made with Blockbench 4.8.3
// Exported for Minecraft version 1.15 - 1.16 with Mojang mappings
// Paste this class into your mod and generate all required imports


public class WhitesnakeModel extends HumanoidStandModel<WhitesnakeEntity> {
	public static final StandPose WIND_BLOW = null;
	private final ModelRenderer hat;
	private final ModelRenderer hat_r1;
	private final ModelRenderer hat_r2;

	public WhitesnakeModel() {
		super();
		
		addHumanoidBaseBoxes(null);
		texWidth = 128;
		texHeight = 128;

		head.texOffs(0, 0).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, 0.0F, false);

		hat = new ModelRenderer(this);
		hat.setPos(0.0F, 0.0F, 0.0F);
		head.addChild(hat);
		hat.texOffs(36, 64).addBox(-4.0F, -11.1F, -4.3F, 1.6F, 5.1F, 0.3F, 0.0F, false);
		hat.texOffs(3, 19).addBox(-4.0F, -4.0F, -4.3F, 0.4F, 1.0F, 0.3F, 0.0F, false);
		hat.texOffs(10, 64).addBox(-4.0F, -11.1F, 4.0F, 1.6F, 5.1F, 0.3F, 0.0F, false);
		hat.texOffs(5, 64).addBox(2.4F, -11.1F, 4.0F, 1.6F, 5.1F, 0.3F, 0.0F, false);
		hat.texOffs(0, 73).addBox(-4.3F, -4.0F, -3.9F, 8.6F, 1.0F, 8.2F, 0.0F, false);
		hat.texOffs(0, 72).addBox(-4.3F, -6.0F, -3.9F, 8.6F, 1.3F, 8.2F, 0.0F, false);
		hat.texOffs(31, 64).addBox(-0.8F, -11.1F, -4.3F, 1.6F, 5.1F, 0.3F, 0.0F, false);
		hat.texOffs(31, 64).addBox(-0.8F, -11.1F, 4.0F, 1.6F, 5.1F, 0.3F, 0.0F, false);
		hat.texOffs(11, 61).addBox(-2.4F, -8.0F, -4.3F, 4.8F, 2.0F, 0.3F, 0.0F, false);
		hat.texOffs(47, 0).addBox(-4.0F, -6.0F, -4.3F, 8.0F, 2.0F, 0.3F, 0.0F, false);
		hat.texOffs(0, 61).addBox(-2.4F, -6.0F, -4.3F, 4.8F, 2.0F, 0.3F, 0.0F, false);
		hat.texOffs(33, 15).addBox(-1.0F, -4.0F, -4.3F, 2.0F, 1.0F, 0.3F, 0.0F, false);
		hat.texOffs(21, 19).addBox(-4.0F, -3.0F, -4.3F, 3.1F, 1.0F, 0.3F, 0.0F, false);
		hat.texOffs(21, 17).addBox(0.9F, -3.0F, -4.3F, 3.1F, 1.0F, 0.3F, 0.0F, false);
		hat.texOffs(0, 17).addBox(-4.3F, -4.7F, -4.0F, 0.3F, 0.7F, 0.7F, 0.0F, false);
		hat.texOffs(30, 34).addBox(-1.0F, -3.2F, -4.3F, 2.0F, 0.9F, 0.3F, 0.0F, false);
		hat.texOffs(5, 5).addBox(4.0F, -4.7F, -4.0F, 0.3F, 0.7F, 0.7F, 0.0F, false);
		hat.texOffs(15, 64).addBox(2.4F, -11.1F, -4.3F, 1.6F, 5.1F, 0.3F, 0.0F, false);
		hat.texOffs(22, 61).addBox(-1.0F, -2.0F, -1.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);
		hat.texOffs(3, 17).addBox(3.6F, -4.0F, -4.3F, 0.4F, 1.0F, 0.3F, 0.0F, false);

		hat_r1 = new ModelRenderer(this);
		hat_r1.setPos(0.0F, 0.0F, 0.0F);
		hat.addChild(hat_r1);
		setRotationAngle(hat_r1, 0.0F, 1.5708F, 0.0F);
		hat_r1.texOffs(63, 15).addBox(-0.8F, -11.1F, 4.0F, 1.6F, 5.1F, 0.3F, 0.0F, false);

		hat_r2 = new ModelRenderer(this);
		hat_r2.setPos(0.0F, 0.0F, 0.0F);
		hat.addChild(hat_r2);
		setRotationAngle(hat_r2, 0.0F, -1.5708F, 0.0F);
		hat_r2.texOffs(0, 64).addBox(-0.8F, -11.1F, 4.0F, 1.6F, 5.1F, 0.3F, 0.0F, false);

		setRotationAngle(head, 0.0F, 1.5708F, 0.0F);
		head.texOffs(63, 15).addBox(-0.8F, -11.1F, 4.0F, 1.6F, 5.1F, 0.3F, 0.0F, false);

		setRotationAngle(head, 0.0F, -1.5708F, 0.0F);
		head.texOffs(0, 64).addBox(-0.8F, -11.1F, 4.0F, 1.6F, 5.1F, 0.3F, 0.0F, false);

		torso.texOffs(0, 17).addBox(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, 0.0F, false);
		torso.texOffs(25, 0).addBox(-3.8F, -0.2F, -2.4F, 7.6F, 2.2F, 4.8F, 0.0F, false);
		torso.texOffs(0, 0).addBox(-1.0F, 4.5F, -2.2F, 2.0F, 5.5F, 0.2F, 0.0F, false);
		torso.texOffs(25, 0).addBox(-1.0F, 2.0F, -2.4F, 2.0F, 2.5F, 0.2F, 0.0F, false);
		torso.texOffs(34, 56).addBox(-2.5F, 4.0F, -2.1F, 5.0F, 6.0F, 0.8F, 0.0F, false);
		torso.texOffs(58, 40).addBox(-3.5F, 1.1F, -1.8F, 7.0F, 3.0F, 0.8F, 0.4F, false);
		torso.texOffs(25, 17).addBox(-4.2F, 10.0F, -2.2F, 8.4F, 1.4F, 4.4F, 0.0F, false);
		torso.texOffs(48, 4).addBox(-4.2F, 11.4F, -2.2F, 3.2F, 2.4F, 4.4F, 0.0F, false);
		torso.texOffs(47, 41).addBox(1.0F, 11.4F, -2.2F, 3.2F, 2.4F, 4.4F, 0.0F, false);
		torso.texOffs(52, 45).addBox(-1.0F, 11.4F, 2.0F, 2.0F, 2.4F, 0.2F, 0.0F, false);

		leftArm.texOffs(0, 73).addBox(-2.5F, -2.25F, -2.25F, 3.5F, 0.75F, 4.5F, 0.0F, false);
		leftArm.texOffs(34, 45).addBox(-2.0F, -2.0F, -2.0F, 4.0F, 6.0F, 4.0F, 0.0F, false);

		leftArmJoint.texOffs(60, 59).addBox(-1.5F, -1.5F, -1.5F, 3.0F, 3.0F, 3.0F, -0.1F, false);

		leftForeArm.texOffs(17, 45).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 6.0F, 4.0F, -0.001F, false);
		leftForeArm.texOffs(47, 54).addBox(-2.1F, 0.0F, -2.1F, 4.2F, 0.4F, 4.2F, 0.0F, false);
		leftForeArm.texOffs(50, 18).addBox(-2.1F, 3.6F, -2.1F, 4.2F, 0.4F, 4.2F, 0.0F, false);
		leftForeArm.texOffs(33, 8).addBox(2.0F, 5.2F, -1.7F, 0.1F, 0.5F, 0.5F, 0.0F, false);
		leftForeArm.texOffs(76, 41).addBox(2.0F, 5.2F, -0.8F, 0.1F, 0.5F, 0.5F, 0.0F, false);
		leftForeArm.texOffs(34, 35).addBox(2.0F, 5.2F, 0.3F, 0.1F, 0.5F, 0.5F, 0.0F, false);
		leftForeArm.texOffs(75, 32).addBox(2.0F, 5.2F, 1.2F, 0.1F, 0.5F, 0.5F, 0.0F, false);

		rightArm.texOffs(0, 45).addBox(-2.0F, -2.0F, -2.0F, 4.0F, 6.0F, 4.0F, 0.0F, false);
		rightArm.texOffs(0, 73).addBox(-1.0F, -2.25F, -2.25F, 3.5F, 0.75F, 4.5F, 0.0F, true);

		rightArmJoint.texOffs(60, 8).addBox(-1.5F, -1.5F, -1.5F, 3.0F, 3.0F, 3.0F, -0.1F, false);

		rightForeArm.texOffs(42, 23).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 6.0F, 4.0F, -0.001F, false);
		rightForeArm.texOffs(17, 56).addBox(-2.1F, 0.0F, -2.1F, 4.2F, 0.4F, 4.2F, 0.0F, false);
		rightForeArm.texOffs(0, 56).addBox(-2.1F, 3.6F, -2.1F, 4.2F, 0.4F, 4.2F, 0.0F, false);
		rightForeArm.texOffs(87, 44).addBox(-2.1F, 5.2F, 1.2F, 0.1F, 0.5F, 0.5F, 0.0F, false);
		rightForeArm.texOffs(94, 68).addBox(-2.1F, 5.2F, 0.3F, 0.1F, 0.5F, 0.5F, 0.0F, false);
		rightForeArm.texOffs(80, 59).addBox(-2.1F, 5.2F, -0.8F, 0.1F, 0.5F, 0.5F, 0.0F, false);
		rightForeArm.texOffs(104, 69).addBox(-2.1F, 5.2F, -1.7F, 0.1F, 0.5F, 0.5F, 0.0F, false);

		leftLeg.texOffs(34, 34).addBox(-1.9F, 0.0F, -2.0F, 4.0F, 6.0F, 4.0F, 0.0F, false);

		leftLegJoint.setPos(0.0F, 6.0F, 0.0F);
		leftLeg.addChild(leftLegJoint);
		leftLegJoint.texOffs(47, 59).addBox(-1.5F, -1.5F, -1.5F, 3.0F, 3.0F, 3.0F, -0.1F, false);

		leftLowerLeg.setPos(0.0F, 6.0F, 0.0F);
		leftLeg.addChild(leftLowerLeg);
		leftLowerLeg.texOffs(17, 34).addBox(-1.9F, 0.0F, -2.0F, 4.0F, 6.0F, 4.0F, -0.001F, false);
		leftLowerLeg.texOffs(51, 48).addBox(-2.0F, 0.0F, -2.1F, 4.2F, 0.7F, 4.2F, 0.0F, false);
		leftLowerLeg.texOffs(80, 21).addBox(-2.0F, 3.7F, -2.1F, 4.2F, 2.3F, 4.2F, 0.0F, false);
		leftLowerLeg.texOffs(64, 45).addBox(-0.5F, 0.7F, -2.1F, 1.1F, 3.0F, 0.2F, 0.0F, false);

		rightLeg.texOffs(0, 34).addBox(-2.1F, 0.0F, -2.0F, 4.0F, 6.0F, 4.0F, 0.0F, false);

		rightLegJoint.texOffs(59, 27).addBox(-1.5F, -1.5F, -1.5F, 3.0F, 3.0F, 3.0F, -0.1F, false);

		rightLowerLeg.texOffs(25, 23).addBox(-2.1F, 0.0F, -2.0F, 4.0F, 6.0F, 4.0F, -0.001F, false);
		rightLowerLeg.texOffs(51, 34).addBox(-2.2F, 0.0F, -2.1F, 4.2F, 0.7F, 4.2F, 0.0F, false);
		rightLowerLeg.texOffs(80, 21).addBox(-2.2F, 3.7F, -2.1F, 4.2F, 2.3F, 4.2F, 0.0F, false);
		rightLowerLeg.texOffs(5, 0).addBox(-0.7F, 0.7F, -2.1F, 1.1F, 3.0F, 0.2F, 0.0F, false);
	}

        @Override
	protected RotationAngle[][] initSummonPoseRotations() {
		return new RotationAngle[][] {
				new RotationAngle[] {
						RotationAngle.fromDegrees(head, -16F, 0, 0),
						RotationAngle.fromDegrees(body, -10F, -10F, 0),
						RotationAngle.fromDegrees(upperPart, 0, 0, 0),
						RotationAngle.fromDegrees(leftArm, 0, 0, -38F),
						RotationAngle.fromDegrees(leftForeArm, 0, 0, 72F),
						RotationAngle.fromDegrees(rightArm, 0, 0, 38F),
						RotationAngle.fromDegrees(rightForeArm, 0, 0, -72F),
						RotationAngle.fromDegrees(leftLeg, 13F, 0, -10F),
						RotationAngle.fromDegrees(leftLowerLeg, 29F, 0, 0),
						RotationAngle.fromDegrees(rightLeg, 13F, 0, 10F),
						RotationAngle.fromDegrees(rightLowerLeg, 29F, 0, 0)
				},
				new RotationAngle[] {
						RotationAngle.fromDegrees(head, 0, -18F, 0),
						RotationAngle.fromDegrees(body, -10F, -10F, 0),
						RotationAngle.fromDegrees(upperPart, 0, 0, 0),
						RotationAngle.fromDegrees(leftArm, 0, 0, -38F),
						RotationAngle.fromDegrees(leftForeArm, 0, 0, 72F),
						RotationAngle.fromDegrees(rightArm, 0, 0, 12F),
						RotationAngle.fromDegrees(rightForeArm, 0, 0, 0),
						RotationAngle.fromDegrees(leftLeg, 13F, 0, -10F),
						RotationAngle.fromDegrees(leftLowerLeg, 29F, 0, 0),
						RotationAngle.fromDegrees(rightLeg, 13F, 0, 10F),
						RotationAngle.fromDegrees(rightLowerLeg, 29F, 0, 0)
				}
	        };
        }

	@Override
	protected void initActionPoses() {
        actionAnim.put(StandPose.RANGED_ATTACK, new PosedActionAnimation.Builder<WhitesnakeEntity>()
                .addPose(StandEntityAction.Phase.BUTTON_HOLD, new ModelPose<>(new RotationAngle[] {
                        new RotationAngle(body, 0.0F, -0.48F, 0.0F),
                        new RotationAngle(leftArm, 0.0F, 0.0F, 0.0F),
                        new RotationAngle(leftForeArm, 0.0F, 0.0F, 0.0F),
                        new RotationAngle(rightArm, -1.0908F, 0.0F, 1.5708F), 
                        new RotationAngle(rightForeArm, 0.0F, 0.0F, 0.0F)
				}))
				.build(idlePose));
		actionAnim.put(WhitesnakeRemoveStandDisc.WIND_BLOW, new PosedActionAnimation.Builder<WhitesnakeEntity>()
				.addPose(StandEntityAction.Phase.BUTTON_HOLD, new ModelPose<>(new RotationAngle[] {
						new RotationAngle(body, 0.0F, 0.0F, 0.0F),
						new RotationAngle(leftArm, -1.5708F, -0.3927F, 0.0F),
						new RotationAngle(leftForeArm, 0.0F, 1.5708F, 0.3927F),
						new RotationAngle(rightArm, 0.0F, 0.0F, 0.0F),
						new RotationAngle(rightForeArm, 0.0F, 0.0F, 0.0F),
                }))
                .build(idlePose));

		super.initActionPoses();
        }
        
        @Override
        protected ModelPose<WhitesnakeEntity> initIdlePose() {
                return new ModelPose<>(new RotationAngle[] {
				RotationAngle.fromDegrees(body, 0.0F, 0.0F, 0.0F),
				RotationAngle.fromDegrees(upperPart, 0.0F, 0.0F, 0.0F), RotationAngle.fromDegrees(torso, 0.0F, 0.0F, 0.0F),
				RotationAngle.fromDegrees(leftArm, -32F, 0.0F, 0.0F),
				RotationAngle.fromDegrees(leftForeArm, 0.1F, 0.4F, 57.9F),
				RotationAngle.fromDegrees(rightArm, 0.0F, 0.0F, 20F),
				RotationAngle.fromDegrees(rightForeArm, 0.0F, 0.0F, -43F),
				RotationAngle.fromDegrees(leftLeg, -6F, -47F, 0.0F),
				RotationAngle.fromDegrees(leftLowerLeg, 7F, 0.0F, 0.0F),
				RotationAngle.fromDegrees(rightLeg, 1.7F, 28.6F, 11F),
				RotationAngle.fromDegrees(rightLowerLeg, 0.0F, 0.0F, 0.0F)
                });
        }
        
        @Override
        protected ModelPose<WhitesnakeEntity> initIdlePose2Loop() {
                return new ModelPose<>(new RotationAngle[] {RotationAngle.fromDegrees(leftArm, -32F, 0.0F, 0.0F),
				RotationAngle.fromDegrees(leftForeArm, 0.1F, 0.4F, 57.9F),
				RotationAngle.fromDegrees(rightArm, 0.0F, 0.0F, 20F),
				RotationAngle.fromDegrees(rightForeArm, 0.0F, 0.0F, -43F),
                });
        }                  
}  
