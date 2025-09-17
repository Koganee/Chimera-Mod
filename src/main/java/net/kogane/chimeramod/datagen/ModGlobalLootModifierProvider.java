package net.kogane.chimeramod.datagen;

import net.kogane.chimeramod.ChimeraMod;
import net.kogane.chimeramod.item.ModItems;
import net.kogane.chimeramod.loot.AddItemModifier;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.minecraftforge.common.data.GlobalLootModifierProvider;
import net.minecraftforge.common.loot.LootTableIdCondition;

import java.util.concurrent.CompletableFuture;

public class ModGlobalLootModifierProvider extends GlobalLootModifierProvider {
    public ModGlobalLootModifierProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, ChimeraMod.MOD_ID, registries);
    }

    @Override
    protected void start(HolderLookup.Provider registries) {
        add("creeper_core_from_creeper", new AddItemModifier(new LootItemCondition[] {
                new LootTableIdCondition.Builder(ResourceLocation.withDefaultNamespace("entities/creeper"))
                        .and(LootItemRandomChanceCondition.randomChance(0.1f)).build() }, // modified by the creeper's own loot table
                ModItems.CREEPER_CORE.get()));
        add("skeleton_arm_from_skeleton", new AddItemModifier(new LootItemCondition[] {
                new LootTableIdCondition.Builder(ResourceLocation.withDefaultNamespace("entities/skeleton"))
                        .and(LootItemRandomChanceCondition.randomChance(0.1f)).build() }, // modified by the creeper's own loot table
                ModItems.SKELETON_ARM.get()));
        add("ender_flesh_from_enderman", new AddItemModifier(new LootItemCondition[] {
                new LootTableIdCondition.Builder(ResourceLocation.withDefaultNamespace("entities/enderman"))
                        .and(LootItemRandomChanceCondition.randomChance(0.15f)).build() }, // modified by the creeper's own loot table
                ModItems.ENDER_FLESH.get()));
    }
}