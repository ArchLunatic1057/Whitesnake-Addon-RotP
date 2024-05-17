package com.bigking123.rotp_whitesnake.init;

import com.bigking123.rotp_whitesnake.entity.stand.stands.WhitesnakeEntity;
import com.github.standobyte.jojo.entity.stand.StandEntityType;
import com.github.standobyte.jojo.init.power.stand.EntityStandRegistryObject.EntityStandSupplier;
import com.github.standobyte.jojo.power.impl.stand.stats.StandStats;
import com.github.standobyte.jojo.power.impl.stand.type.EntityStandType;

public class AddonStands {

    public static final EntityStandSupplier<EntityStandType<StandStats>, StandEntityType<WhitesnakeEntity>> 
    WHITESNAKE = new EntityStandSupplier<>(InitStands.STAND_WHITESNAKE);
}
