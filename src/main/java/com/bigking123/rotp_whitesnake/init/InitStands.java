package com.bigking123.rotp_whitesnake.init;

import com.bigking123.rotp_whitesnake.entity.stand.stands.WhitesnakeEntity;
import com.bigking123.rotp_whitesnake.RotpWhitesnakeAddon;
import com.bigking123.rotp_whitesnake.action.stand.*;
import com.github.standobyte.jojo.action.Action;
import com.github.standobyte.jojo.action.stand.*;
import com.github.standobyte.jojo.entity.stand.StandEntityType;
import com.github.standobyte.jojo.init.power.stand.EntityStandRegistryObject;
import com.github.standobyte.jojo.init.power.stand.ModStandsInit;
import com.github.standobyte.jojo.power.impl.stand.StandInstance.StandPart;
import com.github.standobyte.jojo.power.impl.stand.stats.StandStats;
import com.github.standobyte.jojo.power.impl.stand.stats.TimeStopperStandStats;
import com.github.standobyte.jojo.power.impl.stand.type.EntityStandType;
import com.github.standobyte.jojo.power.impl.stand.type.StandType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;

public class InitStands {
    @SuppressWarnings("unchecked")
    public static final DeferredRegister<Action<?>> ACTIONS = DeferredRegister.create(
            (Class<Action<?>>) ((Class<?>) Action.class), RotpWhitesnakeAddon.MOD_ID);
    @SuppressWarnings("unchecked")
    public static final DeferredRegister<StandType<?>> STANDS = DeferredRegister.create(
            (Class<StandType<?>>) ((Class<?>) StandType.class), RotpWhitesnakeAddon.MOD_ID);
    
 // ======================================== WhitesnakeModel ========================================
    
    public static final RegistryObject<StandEntityAction> WHITESNAKE_PUNCH = ACTIONS.register("whitesnake_punch", 
            () -> new StandEntityLightAttack(new StandEntityLightAttack.Builder()
                    .punchSound(InitSounds.WHITESNAKE_PUNCH_LIGHT)
                    .standSound(StandEntityAction.Phase.WINDUP,InitSounds.WHITESNAKE_USHYA)));

    public static final RegistryObject<StandEntityAction> WHITESNAKE_BARRAGE = ACTIONS.register("whitesnake_barrage", 
            () -> new StandEntityMeleeBarrage(new StandEntityMeleeBarrage.Builder()
                    .barrageHitSound(InitSounds.WHITESNAKE_BARRAGE)));
    
    public static final RegistryObject<StandEntityHeavyAttack> WHITESNAKE_COMBO_PUNCH = ACTIONS.register("whitesnake_combo_punch", 
            () -> new StandEntityHeavyAttack(new StandEntityHeavyAttack.Builder()
                    .punchSound(InitSounds.WHITESNAKE_PUNCH_HEAVY)
                    .partsRequired(StandPart.ARMS)));
    
    public static final RegistryObject<StandEntityHeavyAttack> WHITESNAKE_HEAVY_PUNCH = ACTIONS.register("whitesnake_heavy_punch", 
            () -> new StandEntityHeavyAttack(new StandEntityHeavyAttack.Builder()
                    .punchSound(InitSounds.WHITESNAKE_PUNCH_HEAVY)
                    .partsRequired(StandPart.ARMS)
                    .setFinisherVariation(WHITESNAKE_COMBO_PUNCH)
                    .shiftVariationOf(WHITESNAKE_PUNCH).shiftVariationOf(WHITESNAKE_BARRAGE)));


    public static final RegistryObject<StandEntityAction> WHITESNAKE_BLOCK = ACTIONS.register("whitesnake_block", 
            () -> new StandEntityBlock());

    public static final RegistryObject<Blindness> BLINDNESS = ACTIONS.register("blindness",
            () -> new Blindness(new Blindness.Builder().holdType().staminaCostTick(50F)
                    .resolveLevelToUnlock(2)
                    .holdToFire(15, false)
                    .partsRequired(StandPart.ARMS)));

    public static final RegistryObject<RemovingTheMemoryDisk> REMOVING_THE_MEMORY_DISK = ACTIONS.register("removing_the_memory_disk",
            () -> new RemovingTheMemoryDisk(new RemovingTheMemoryDisk.Builder().cooldown(20).standPose(WhitesnakeRemoveStandDisc.WIND_BLOW)
                    .standSound(InitSounds.WHITESNAKE_REMOVE_STAND_DISC).standPerformDuration(5)
                    .resolveLevelToUnlock(2)
                    .holdToFire(15, true)
                    .partsRequired(StandPart.ARMS)));

    public static final RegistryObject<StandEntityAction> WHITESNAKE_REMOVE_STAND_DISC = ACTIONS.register("whitesnake_remove_stand_disc",
            () -> new WhitesnakeRemoveStandDisc(new WhitesnakeRemoveStandDisc.Builder().holdType().staminaCostTick(1000F).standPose(WhitesnakeRemoveStandDisc.WIND_BLOW).cooldown(200)
                    .standSound(InitSounds.WHITESNAKE_REMOVE_STAND_DISC)
                    .standPerformDuration(5)
                    .resolveLevelToUnlock(0)
                    .holdToFire(10, true)
                    .standOffsetFromUser(0.667, 0.2, 0)
                    .shiftVariationOf(REMOVING_THE_MEMORY_DISK)
                    .partsRequired(StandPart.ARMS)));

    public static final EntityStandRegistryObject<EntityStandType<StandStats>, StandEntityType<WhitesnakeEntity>> STAND_WHITESNAKE = 
            new EntityStandRegistryObject<>("whitesnake", 
                    STANDS,
                    () -> new EntityStandType.Builder<StandStats>()
                            .color(0xD5D5D5)
                            .storyPartName(ModStandsInit.PART_6_NAME)
                            .leftClickHotbar(
                                    WHITESNAKE_PUNCH.get(),
                                    WHITESNAKE_BARRAGE.get()
                            )
                            .rightClickHotbar(
                                    WHITESNAKE_BLOCK.get(),
                                    BLINDNESS.get(),
                                    REMOVING_THE_MEMORY_DISK.get()
                            )
                            .defaultStats(StandStats.class, new StandStats.Builder()
                                    .tier(6)
                                    .power(13.0)
                                    .speed(14.0)
                                    .range(15.0, 20.0)
                                    .durability(16.0)
                                    .precision(14.0)
                                    .randomWeight(2)
                            )
                            .addSummonShout(InitSounds.PUCCI_WHITESNAKE)
                            .addOst(InitSounds.WHITESNAKE_OST)
                            .build(),

                    InitEntities.ENTITIES, 
                    () -> new StandEntityType<WhitesnakeEntity>(WhitesnakeEntity::new, 0.65F, 1.95F)
                    .summonSound(InitSounds.WHITESNAKE_SUMMON)
                    .unsummonSound(InitSounds.WHITESNAKE_UNSUMMON))
            .withDefaultStandAttributes();
}
