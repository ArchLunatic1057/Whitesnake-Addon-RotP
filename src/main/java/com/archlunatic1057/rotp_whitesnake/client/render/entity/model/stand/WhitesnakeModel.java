package com.archlunatic1057.rotp_whitesnake.client.render.entity.model.stand;

import com.archlunatic1057.rotp_whitesnake.entity.stand.stands.WhitesnakeEntity;
import com.archlunatic1057.rotp_whitesnake.action.stand.WhitesnakeRemoveStandDisc;
import com.github.standobyte.jojo.action.stand.StandEntityAction;
import com.github.standobyte.jojo.client.render.entity.model.stand.HumanoidStandModel;
import com.github.standobyte.jojo.client.render.entity.pose.ModelPose;
import com.github.standobyte.jojo.client.render.entity.pose.RotationAngle;
import com.github.standobyte.jojo.client.render.entity.pose.anim.PosedActionAnimation;
import com.github.standobyte.jojo.entity.stand.StandPose;

public class WhitesnakeModel extends HumanoidStandModel<WhitesnakeEntity> {
	public static final StandPose REMOVE_DISC = null;

	public WhitesnakeModel() {
		super();
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
		actionAnim.put(WhitesnakeRemoveStandDisc.REMOVE_DISC, new PosedActionAnimation.Builder<WhitesnakeEntity>()
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
