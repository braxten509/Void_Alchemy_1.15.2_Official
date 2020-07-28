package com.elitethaumaturge.zorumtweaks.client.render;

import com.elitethaumaturge.zorumtweaks.ZorumTweaks;
import com.elitethaumaturge.zorumtweaks.entities.VoidWalkerEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.model.PlayerModel;
import net.minecraft.util.ResourceLocation;

public class VoidWalkerRenderer extends MobRenderer<VoidWalkerEntity, PlayerModel<VoidWalkerEntity>> {

    protected static final ResourceLocation TEXTURE = new ResourceLocation(ZorumTweaks.MOD_ID, "textures/entity/void_walker_entity.png");

    public VoidWalkerRenderer(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new PlayerModel<>(0.0F, false), 0.5F);
    }

    @Override
    public ResourceLocation getEntityTexture(VoidWalkerEntity entity) {
        return TEXTURE;
    }

}
