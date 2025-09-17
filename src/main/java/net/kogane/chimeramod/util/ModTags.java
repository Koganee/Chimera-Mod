package net.kogane.chimeramod.util;

import net.kogane.chimeramod.ChimeraMod;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class ModTags {
    public static class Blocks {
        public static final TagKey<Block> NEEDS_REFINED_IRON_TOOL = createTag("needs_refined_iron_tool");
        public static final TagKey<Block> INCORRECT_FOR_REFINED_IRON_TOOL = createTag("incorrect_for_refined_iron_tool");

        private static TagKey<Block> createTag(String name) {
            return BlockTags.create(ResourceLocation.fromNamespaceAndPath(ChimeraMod.MOD_ID, name));
        }
    }

    public static class Items {
        public static final TagKey<Item> TRANSFORMABLE_ITEMS = createTag("transformable_items");
        public static final TagKey<Item> REFINED_IRON_REPAIRABLE = createTag("refined_iron_repairables");

        private static TagKey<Item> createTag(String name) {
            return ItemTags.create(ResourceLocation.fromNamespaceAndPath(ChimeraMod.MOD_ID, name));
        }
    }
}