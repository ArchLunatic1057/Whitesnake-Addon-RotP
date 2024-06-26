package com.archlunatic1057.rotp_whitesnake;

import com.archlunatic1057.rotp_whitesnake.init.InitEntities;
import com.archlunatic1057.rotp_whitesnake.init.InitSounds;
import com.archlunatic1057.rotp_whitesnake.init.InitStands;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(RotpWhitesnakeAddon.MOD_ID)
public class RotpWhitesnakeAddon {
    // The value here should match an entry in the META-INF/mods.toml file
    public static final String MOD_ID = "rotp_whitesnake";
    private static final Logger LOGGER = LogManager.getLogger();

    public RotpWhitesnakeAddon() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        InitEntities.ENTITIES.register(modEventBus);
        InitSounds.SOUNDS.register(modEventBus);
        InitStands.ACTIONS.register(modEventBus);
        InitStands.STANDS.register(modEventBus);
    }

    public static Logger getLogger() {
        return LOGGER;
    }
}
