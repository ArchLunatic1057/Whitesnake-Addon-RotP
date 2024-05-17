package com.bigking123.rotp_whitesnake.action.stand;

import com.bigking123.rotp_whitesnake.entity.stand.stands.WhitesnakeEntity;
import com.github.standobyte.jojo.action.ActionTarget;
import com.github.standobyte.jojo.action.ActionTarget.TargetType;
import com.github.standobyte.jojo.action.stand.StandEntityAction;
import com.github.standobyte.jojo.entity.stand.StandEntity;
import com.github.standobyte.jojo.entity.stand.StandEntityTask;
import com.github.standobyte.jojo.entity.stand.StandPose;
import com.github.standobyte.jojo.power.impl.stand.IStandManifestation;
import com.github.standobyte.jojo.power.impl.stand.IStandPower;
import com.github.standobyte.jojo.power.impl.stand.StandUtil;
import com.github.standobyte.jojo.util.general.LazySupplier;
import com.github.standobyte.jojo.util.mc.MCUtil;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.IFormattableTextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.event.world.NoteBlockEvent;

import javax.annotation.Nullable;
import javax.swing.text.PlainDocument;

public class RemovingTheMemoryDisk extends StandEntityAction {
    public static final StandPose WIND_BLOW = new StandPose("WHITESNAKE_REMOVE_STAND_DISC");

    public RemovingTheMemoryDisk(StandEntityAction.Builder builder) {
        super(builder);
    }

    @Override
    public void standPerform(World world, StandEntity standEntity, IStandPower userPower, StandEntityTask task) {
        if (!world.isClientSide() && task.getTarget().getType() == TargetType.ENTITY && task.getTarget().getEntity() instanceof LivingEntity) {
            LivingEntity target = StandUtil.getStandUser((LivingEntity) task.getTarget().getEntity());
            LivingEntity standUser = userPower.getUser();
            target.addEffect(new EffectInstance(Effects.WEAKNESS, 2000, 9));
            target.addEffect(new EffectInstance(Effects.MOVEMENT_SLOWDOWN, 2000, 9));
            target.addEffect(new EffectInstance(Effects.BLINDNESS, 2000, 9));
            target.addEffect(new EffectInstance(Effects.CONFUSION, 2000, 9));
            if (target instanceof MobEntity) {
            }
            IStandPower.getStandPowerOptional(target).ifPresent(power -> {
                if (power.isActive() && power.getStandManifestation() instanceof StandEntity) {
                    ((StandEntity) power.getStandManifestation()).addEffect(new EffectInstance(Effects.WEAKNESS, 200, 9));
                    ((StandEntity) power.getStandManifestation()).addEffect(new EffectInstance(Effects.MOVEMENT_SLOWDOWN, 200, 9));
                    ((StandEntity) power.getStandManifestation()).addEffect(new EffectInstance(Effects.BLINDNESS, 200, 9));
                    ((StandEntity) power.getStandManifestation()).addEffect(new EffectInstance(Effects.CONFUSION, 200, 9));
                }
            });
            if (target instanceof PlayerEntity){
                int experienceLevel = ((PlayerEntity) target).experienceLevel;
                MCUtil.runCommand(standUser, "xp set "+target.getName()+" 0 levels");
                MCUtil.runCommand(standUser, "xp set "+standUser.getName()+" "+experienceLevel+" levels");
            }
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



}
