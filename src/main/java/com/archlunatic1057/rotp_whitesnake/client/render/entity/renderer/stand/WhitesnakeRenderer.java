package com.archlunatic1057.rotp_whitesnake.client.render.entity.renderer.stand;

import com.archlunatic1057.rotp_whitesnake.RotpWhitesnakeAddon;
import com.archlunatic1057.rotp_whitesnake.client.render.entity.model.stand.WhitesnakeModel;
import com.archlunatic1057.rotp_whitesnake.entity.stand.stands.WhitesnakeEntity;
import com.github.standobyte.jojo.client.render.entity.model.stand.StandEntityModel;
import com.github.standobyte.jojo.client.render.entity.model.stand.StandModelRegistry;
import com.github.standobyte.jojo.client.render.entity.renderer.stand.StandEntityRenderer;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.util.ResourceLocation;

public class WhitesnakeRenderer extends StandEntityRenderer<WhitesnakeEntity, StandEntityModel<WhitesnakeEntity>> {

    public WhitesnakeRenderer(EntityRendererManager renderManager) {
        super(renderManager,
                StandModelRegistry.registerModel(new ResourceLocation(RotpWhitesnakeAddon.MOD_ID, "whitesnake"), WhitesnakeModel::new),
                new ResourceLocation(RotpWhitesnakeAddon.MOD_ID, "textures/entity/stand/whitesnake.png"), 0);
    }
}
