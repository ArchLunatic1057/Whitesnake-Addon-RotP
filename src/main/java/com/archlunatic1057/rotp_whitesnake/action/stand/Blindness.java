package com.archlunatic1057.rotp_whitesnake.action.stand;

import com.github.standobyte.jojo.action.ActionTarget;
import com.github.standobyte.jojo.action.stand.StandEntityAction;
import com.github.standobyte.jojo.entity.stand.StandEntity;
import com.github.standobyte.jojo.entity.stand.StandEntityTask;
import com.github.standobyte.jojo.power.impl.stand.IStandPower;
import com.github.standobyte.jojo.power.impl.stand.StandUtil;
import com.github.standobyte.jojo.util.general.LazySupplier;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.MobEntity;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.IFormattableTextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public class Blindness extends StandEntityAction {

    public Blindness(StandEntityAction.Builder builder) {
        super(builder);
    }

    @Override
    public void standPerform(World world, StandEntity standEntity, IStandPower userPower, StandEntityTask task) {
        if (!world.isClientSide()) {
            LivingEntity user = userPower.getUser();
            if(isShiftVariation()) {
                if (!user.hasEffect(Effects.BLINDNESS)) {
                    user.addEffect(new EffectInstance(Effects.BLINDNESS, 99999999, 999999, false, false, false));
                } else {
                    user.removeEffect(Effects.BLINDNESS);
                }
            }else {
                if (task.getTarget().getType() == ActionTarget.TargetType.ENTITY && task.getTarget().getEntity() instanceof LivingEntity) {
                    LivingEntity target = StandUtil.getStandUser((LivingEntity) task.getTarget().getEntity());
                    target.addEffect(new EffectInstance(Effects.BLINDNESS, 2000, 9));

                    if (target instanceof MobEntity) {
                    }
                    IStandPower.getStandPowerOptional(target).ifPresent(power -> {
                        if (power.isActive() && power.getStandManifestation() instanceof StandEntity) {
                            ((StandEntity) power.getStandManifestation()).addEffect(new EffectInstance(Effects.BLINDNESS, 200, 9));
                        }
                    });
                }
            }
        }
    }

    @Override
    public IFormattableTextComponent getTranslatedName(IStandPower power, String key) { return new TranslationTextComponent(key, String.format("%.2f", (float) 99999 / 20));}

    private final LazySupplier<ResourceLocation> disableTex =
            new LazySupplier<>(() -> makeIconVariant(this, "_disable"));

    @Override
    public ResourceLocation getIconTexturePath(@Nullable IStandPower power) {
        if (power != null) {
            if (power.getUser().hasEffect(Effects.BLINDNESS)) { return this.disableTex.get();}
        }
        return super.getIconTexturePath(power);
    }

//    @Override
//    public boolean greenSelection(IStandPower power, ActionConditionResult conditionCheck) {
//        return super.greenSelection(power, conditionCheck);
//        return power.getStandManifestation().;
//    }
}
