package com.archlunatic1057.rotp_whitesnake.action.stand;

import com.archlunatic1057.rotp_whitesnake.init.InitStands;
import com.github.standobyte.jojo.action.Action;
import com.github.standobyte.jojo.action.ActionTarget;
import com.github.standobyte.jojo.action.ActionTarget.TargetType;
import com.github.standobyte.jojo.action.stand.StandEntityAction;
import com.github.standobyte.jojo.entity.stand.StandEntity;
import com.github.standobyte.jojo.entity.stand.StandEntityTask;
import com.github.standobyte.jojo.entity.stand.StandPose;
import com.github.standobyte.jojo.init.ModItems;
import com.github.standobyte.jojo.item.StandDiscItem;
import com.github.standobyte.jojo.power.impl.stand.IStandPower;
import com.github.standobyte.jojo.power.impl.stand.StandInstance;
import com.github.standobyte.jojo.util.mc.MCUtil;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

import java.util.Optional;

public class WhitesnakeRemovingStandDisc extends StandEntityAction {
    public static final StandPose REMOVE_DISC = new StandPose("WHITESNAKE_REMOVE_STAND_DISC");

    public WhitesnakeRemovingStandDisc(StandEntityAction.Builder builder) {
        super(builder);
    }

    @Override
    public void standPerform(World world, StandEntity standEntity, IStandPower userPower, StandEntityTask task) {
        if (!world.isClientSide()) {
            ActionTarget t = task.getTarget();
            if (t.getType() == TargetType.ENTITY && t.getEntity() instanceof LivingEntity) {
                LivingEntity target = (LivingEntity) t.getEntity();
                standEntity.moveTo(target.position());
                IStandPower.getStandPowerOptional(target).ifPresent(power -> {
                    if (power.hasPower()) {
                        Optional<StandInstance> previousDiscStand = power.putOutStand();
                        previousDiscStand.ifPresent(prevStand ->
                                MCUtil.giveItemTo(userPower.getUser(), StandDiscItem.withStand(new ItemStack(ModItems.STAND_DISC.get()), prevStand), true));
                    }
                });
            }
            Action<?> RemovingTheMemoryDisk = InitStands.REMOVING_THE_MEMORY_DISK.get();
            userPower.setCooldownTimer(RemovingTheMemoryDisk, 100);
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