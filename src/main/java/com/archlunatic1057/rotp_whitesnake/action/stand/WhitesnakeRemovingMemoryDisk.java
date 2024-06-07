package com.archlunatic1057.rotp_whitesnake.action.stand;

import com.archlunatic1057.rotp_whitesnake.init.InitStands;
import com.github.standobyte.jojo.action.Action;
import com.github.standobyte.jojo.action.ActionTarget;
import com.github.standobyte.jojo.action.ActionTarget.TargetType;
import com.github.standobyte.jojo.action.stand.StandEntityAction;
import com.github.standobyte.jojo.entity.stand.StandEntity;
import com.github.standobyte.jojo.entity.stand.StandEntityTask;
import com.github.standobyte.jojo.entity.stand.StandPose;
import com.github.standobyte.jojo.init.ModStatusEffects;
import com.github.standobyte.jojo.power.impl.stand.IStandPower;
import com.github.standobyte.jojo.power.impl.stand.StandUtil;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.MobEntity;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class WhitesnakeRemovingMemoryDisk extends StandEntityAction {
    public static final StandPose WIND_BLOW = new StandPose("WHITESNAKE_REMOVE_STAND_DISC");

    public WhitesnakeRemovingMemoryDisk(StandEntityAction.Builder builder) {
        super(builder);
    }

    @Override
    public void standPerform(World world, StandEntity standEntity, IStandPower userPower, StandEntityTask task) {
        if (!world.isClientSide() && task.getTarget().getType() == TargetType.ENTITY && task.getTarget().getEntity() instanceof LivingEntity) {
            LivingEntity target = StandUtil.getStandUser((LivingEntity) task.getTarget().getEntity());
            target.addEffect(new EffectInstance(ModStatusEffects.STUN.get(), 100, 9, false, false, false));
            target.addEffect(new EffectInstance(Effects.BLINDNESS, 100, 9, false, false, false));
            target.addEffect(new EffectInstance(Effects.CONFUSION, 100, 9, false, false, false));
//            if (target instanceof MobEntity) {
//            }
            IStandPower.getStandPowerOptional(target).ifPresent(power -> {
                if (power.isActive() && power.getStandManifestation() instanceof StandEntity) {
                    ((StandEntity) power.getStandManifestation()).addEffect(new EffectInstance(ModStatusEffects.STUN.get(), 100, 9, false, false, false));
                    ((StandEntity) power.getStandManifestation()).addEffect(new EffectInstance(Effects.BLINDNESS, 100, 9, false, false, false));
                    ((StandEntity) power.getStandManifestation()).addEffect(new EffectInstance(Effects.CONFUSION, 100, 9, false, false, false));
                }
            });
//            if (target instanceof PlayerEntity){
//                String bad = String.valueOf(MCUtil.runCommand(standUser, "getspawnpoint  "+target.getName()));
//                MCUtil.runCommand(standUser, "msg "+standUser.getName()+" coordinates of enemy player: "+bad);
//            }
            standEntity.moveTo(target.position());

            Action<?> WhitesnakeRemovingStandDisc = InitStands.WHITESNAKE_REMOVE_STAND_DISC.get();
            userPower.setCooldownTimer(WhitesnakeRemovingStandDisc, 100);
        }
    }

    @Override
    protected boolean standKeepsTarget(ActionTarget target) {
        return target.getType() == TargetType.ENTITY && target.getEntity() instanceof LivingEntity && !(target.getEntity() instanceof StandEntity);
    }

    @Override
    public TargetRequirement getTargetRequirement() {
        return TargetRequirement.ENTITY;
    }

    @Override
    public boolean cancelHeldOnGettingAttacked(IStandPower power, DamageSource dmgSource, float dmgAmount) {
        return true;
    }

    @Override
    public boolean noAdheringToUserOffset(IStandPower standPower, StandEntity standEntity) {
        return true;
    }
}
