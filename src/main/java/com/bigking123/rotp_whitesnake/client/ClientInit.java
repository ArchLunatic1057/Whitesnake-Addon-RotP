package com.bigking123.rotp_whitesnake.client;

import com.bigking123.rotp_whitesnake.RotpWhitesnakeAddon;
import com.bigking123.rotp_whitesnake.client.render.entity.renderer.stand.WhitesnakeRenderer;
import com.bigking123.rotp_whitesnake.init.AddonStands;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@EventBusSubscriber(modid = RotpWhitesnakeAddon.MOD_ID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientInit {
    
    @SubscribeEvent
    public static void onFMLClientSetup(FMLClientSetupEvent event) {
        RenderingRegistry.registerEntityRenderingHandler(AddonStands.WHITESNAKE.getEntityType(), WhitesnakeRenderer::new);
    }
}
