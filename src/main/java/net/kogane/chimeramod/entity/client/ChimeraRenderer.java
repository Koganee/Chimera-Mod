package net.kogane.chimeramod.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.kogane.chimeramod.ChimeraMod;
import net.kogane.chimeramod.entity.custom.ChimeraEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.state.EntityRenderState;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;

public class ChimeraRenderer extends EntityRenderer<ChimeraEntity, EntityRenderState> {
    private ChimeraModel model;

    // Single texture for all Chimeras
    private static final ResourceLocation CHIMERA_TEXTURE =
            ResourceLocation.fromNamespaceAndPath(ChimeraMod.MOD_ID, "textures/entity/chimera/chimera.png");

    public ChimeraRenderer(EntityRendererProvider.Context pContext) {
        super(pContext);
        this.model = new ChimeraModel(pContext.bakeLayer(ChimeraModel.LAYER_LOCATION));
    }

    public ResourceLocation getTextureLocation() {
        return CHIMERA_TEXTURE;
    }

    @Override
    public void render(EntityRenderState state, PoseStack poseStack, MultiBufferSource buffer, int packedLight) {
        poseStack.pushPose();
        poseStack.scale(1.0F, -1.0F, 1.0F); // Flip Y axis so model isn't upside down

        VertexConsumer vertexconsumer = ItemRenderer.getFoilBuffer(
                buffer, this.model.renderType(this.getTextureLocation()), false, false);

        this.model.renderToBuffer(poseStack, vertexconsumer, packedLight, OverlayTexture.NO_OVERLAY);
        poseStack.popPose();

        super.render(state, poseStack, buffer, packedLight);
    }


    @Override
    public EntityRenderState createRenderState() {
        return new EntityRenderState();
    }
}
