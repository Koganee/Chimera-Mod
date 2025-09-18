package net.kogane.chimeramod.entity.client;// Made with Blockbench 4.12.6
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


import net.kogane.chimeramod.ChimeraMod;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.client.renderer.entity.state.EntityRenderState;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;

public class ChimeraModel<T extends EntityRenderState> extends EntityModel<T>
{
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(ChimeraMod.MOD_ID, "chimera_entity"), "main");
	private final ModelPart body;
	private final ModelPart Head;
	private final ModelPart arm0;
	private final ModelPart arm1;
	private final ModelPart leg0;
	private final ModelPart leg1;
	private final ModelPart bigger_arm;
	private final ModelPart bigger_arm2;

	public ChimeraModel(ModelPart root) {
		super(root); // REQUIRED in 1.21+

		this.body = root.getChild("body");
		this.Head = this.body.getChild("Head");
		this.arm0 = this.body.getChild("arm0");
		this.arm1 = this.body.getChild("arm1");
		this.leg0 = this.body.getChild("leg0");
		this.leg1 = this.body.getChild("leg1");
		this.bigger_arm = root.getChild("bigger_arm");
		this.bigger_arm2 = root.getChild("bigger_arm2");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 40).addBox(-9.0F, -10.0F, -6.0F, 18.0F, 22.0F, 11.0F, new CubeDeformation(0.0F))
		.texOffs(0, 80).addBox(-7.5F, -15.0F, -3.0F, 15.0F, 5.0F, 6.0F, new CubeDeformation(0.5F)), PartPose.offset(0.0F, 31.0F, 0.0F));

		PartDefinition Head = body.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, 12.0F, -5.5F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, -2.0F));

		PartDefinition arm0 = body.addOrReplaceChild("arm0", CubeListBuilder.create().texOffs(60, 21).addBox(-13.0F, -18.5F, -3.0F, 4.0F, 30.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition arm1 = body.addOrReplaceChild("arm1", CubeListBuilder.create().texOffs(60, 58).addBox(9.0F, -18.5F, -3.0F, 4.0F, 30.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition leg0 = body.addOrReplaceChild("leg0", CubeListBuilder.create().texOffs(36, 0).addBox(-4.5F, -13.0F, -3.0F, 8.0F, 16.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(-4.0F, -18.0F, 0.0F));

		PartDefinition leg1 = body.addOrReplaceChild("leg1", CubeListBuilder.create().texOffs(59, 0).mirror().addBox(-4.5F, -13.0F, -3.0F, 8.0F, 16.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(5.0F, -18.0F, 0.0F));

		PartDefinition bigger_arm = partdefinition.addOrReplaceChild("bigger_arm", CubeListBuilder.create().texOffs(87, 40).addBox(-8.0F, -11.5F, -3.0F, 2.0F, 30.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(21.0F, 24.0F, 0.0F));

		PartDefinition bigger_arm2 = partdefinition.addOrReplaceChild("bigger_arm2", CubeListBuilder.create(), PartPose.offset(21.0F, 24.0F, 0.0F));

		PartDefinition cube_r1 = bigger_arm2.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(85, 1).addBox(-1.0F, -12.0F, -1.0F, 2.0F, 30.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-35.0F, 0.5F, 2.0F, 0.0F, 3.1416F, 0.0F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}
	public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

	}
}