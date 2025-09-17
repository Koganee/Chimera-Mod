package net.kogane.chimeramod.entity;

import net.kogane.chimeramod.ChimeraMod;
import net.kogane.chimeramod.entity.custom.ChimeraEntity;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, ChimeraMod.MOD_ID);


    public static final RegistryObject<EntityType<ChimeraEntity>> CHIMERA =
            ENTITY_TYPES.register("chimera", () ->
                    EntityType.Builder.of(ChimeraEntity::new, MobCategory.MONSTER)
                            .sized(1.5f, 1.5f)
                            .build(ResourceKey.create(
                                    Registries.ENTITY_TYPE,
                                    ResourceLocation.fromNamespaceAndPath(ChimeraMod.MOD_ID, "chimera")
                            ))
            );



    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}