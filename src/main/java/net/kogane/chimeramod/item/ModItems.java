package net.kogane.chimeramod.item;

import com.jcraft.jorbis.Block;
import net.kogane.chimeramod.ChimeraMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.*;
import net.minecraft.world.item.equipment.ArmorType;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;
import java.util.function.Function;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, ChimeraMod.MOD_ID);

    public static final RegistryObject<Item> REFINED_IRON_SWORD = registerItem("refined_iron_sword",
            (properties) -> new SwordItem(ModToolTiers.REFINED_IRON, 3, -2.4f, properties));
    public static final RegistryObject<Item> CREEPER_CORE = registerItem("creeper_core",
            Item::new);
    public static final RegistryObject<Item> SKELETON_ARM = registerItem("skeleton_arm",
            Item::new);

    public static RegistryObject<Item> registerItem(String name, Function<Item.Properties, Item> function) {
        return ModItems.ITEMS.register(name, () -> function.apply(new Item.Properties()
                .setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(ChimeraMod.MOD_ID, name)))));
    }

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}