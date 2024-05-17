package com.bigking123.rotp_whitesnake.action.stand;

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
import net.minecraft.world.World;

import java.util.Optional;

public class WhitesnakeRemoveStandDisc extends StandEntityAction {
    public static final StandPose WIND_BLOW = new StandPose("WHITESNAKE_REMOVE_STAND_DISC");

    public WhitesnakeRemoveStandDisc(StandEntityAction.Builder builder) {
        super(builder);
    }

    @Override
    public void standPerform(World world, StandEntity standEntity, IStandPower userPower, StandEntityTask task) {
        if (!world.isClientSide()) {
            ActionTarget t = task.getTarget();
            if (t.getType() == TargetType.ENTITY && t.getEntity() instanceof LivingEntity) {
                LivingEntity target = (LivingEntity) t.getEntity();
                IStandPower.getStandPowerOptional(target).ifPresent(power -> {
                    if (power.hasPower()) {
                        Optional<StandInstance> previousDiscStand = power.putOutStand();
                        previousDiscStand.ifPresent(prevStand ->
                                MCUtil.giveItemTo(userPower.getUser(), StandDiscItem.withStand(new ItemStack(ModItems.STAND_DISC.get()), prevStand), true));
                    }
                });
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