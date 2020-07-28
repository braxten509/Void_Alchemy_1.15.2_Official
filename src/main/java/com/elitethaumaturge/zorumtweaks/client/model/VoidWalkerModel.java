package com.elitethaumaturge.zorumtweaks.client.model;

import com.elitethaumaturge.zorumtweaks.entities.VoidWalkerEntity;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.model.QuadrupedModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

public class VoidWalkerModel<T extends VoidWalkerEntity> extends EntityModel<T> {

    // Made with Blockbench 3.6.5
// Exported for Minecraft version 1.15
// Paste this class into your mod and generate all required imports

        private final ModelRenderer head;
        private final ModelRenderer headwear;
        private final ModelRenderer body;
        private final ModelRenderer left_arm;
        private final ModelRenderer right_arm;
        private final ModelRenderer left_leg;
        private final ModelRenderer right_leg;

        public VoidWalkerModel() {
            textureWidth = 64;
            textureHeight = 64;

            head = new ModelRenderer(this);
            head.setRotationPoint(0.0F, 0.0F, 0.0F);
            head.setTextureOffset(0, 0).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, 0.0F, false);

            headwear = new ModelRenderer(this);
            headwear.setRotationPoint(0.0F, 0.0F, 0.0F);
            headwear.setTextureOffset(32, 0).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, 0.25F, false);

            body = new ModelRenderer(this);
            body.setRotationPoint(0.0F, 0.0F, 0.0F);
            body.setTextureOffset(16, 16).addBox(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, 0.0F, false);

            left_arm = new ModelRenderer(this);
            left_arm.setRotationPoint(4.0F, 2.0F, 0.0F);
            left_arm.setTextureOffset(40, 16).addBox(0.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F, true);

            right_arm = new ModelRenderer(this);
            right_arm.setRotationPoint(-4.0F, 2.0F, 0.0F);
            right_arm.setTextureOffset(40, 16).addBox(-4.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F, false);

            left_leg = new ModelRenderer(this);
            left_leg.setRotationPoint(0.1F, 12.0F, 0.0F);
            left_leg.setTextureOffset(0, 16).addBox(-0.1F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F, true);

            right_leg = new ModelRenderer(this);
            right_leg.setRotationPoint(-1.1F, 12.0F, 0.0F);
            right_leg.setTextureOffset(0, 16).addBox(-2.9F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F, false);
        }

    @Override
    public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
      //FINISH LATER

    }

    @Override
        public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
            head.render(matrixStack, buffer, packedLight, packedOverlay);
            headwear.render(matrixStack, buffer, packedLight, packedOverlay);
            body.render(matrixStack, buffer, packedLight, packedOverlay);
            left_arm.render(matrixStack, buffer, packedLight, packedOverlay);
            right_arm.render(matrixStack, buffer, packedLight, packedOverlay);
            left_leg.render(matrixStack, buffer, packedLight, packedOverlay);
            right_leg.render(matrixStack, buffer, packedLight, packedOverlay);
        }

        public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
            modelRenderer.rotateAngleX = x;
            modelRenderer.rotateAngleY = y;
            modelRenderer.rotateAngleZ = z;
        }
}
