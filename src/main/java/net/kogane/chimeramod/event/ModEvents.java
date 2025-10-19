package net.kogane.chimeramod.event;

import net.kogane.chimeramod.ChimeraMod;
import net.kogane.chimeramod.item.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.animal.Sheep;
import net.minecraft.world.entity.monster.Creeper;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.PotionBrewing;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.item.trading.ItemCost;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.brewing.BrewingRecipeRegisterEvent;
import net.minecraftforge.event.entity.living.LivingDamageEvent;
import net.minecraftforge.event.level.BlockEvent;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.event.village.WandererTradesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Mod.EventBusSubscriber(modid = ChimeraMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ModEvents {
    @SubscribeEvent
    public static void onCreeperiumHold(TickEvent.PlayerTickEvent event) {
        Player player = event.player;
        Level level = player.level();

        // Only run on the server side to avoid doing logic twice
        if (level.isClientSide()) return;
        ItemStack mainHandItem = player.getMainHandItem();
        ItemStack offHandItem = player.getOffhandItem();

        boolean holdingCreeperium = mainHandItem.is(ModItems.CREEPERIUM_INGOT.get()) || offHandItem.is(ModItems.CREEPERIUM_INGOT.get());

        if(holdingCreeperium)
        {
            BlockPos playerPos = player.blockPosition();
            int radius = 10;

            AABB area = new AABB(
                    playerPos.getX() - radius, playerPos.getY() - radius, playerPos.getZ() - radius,
                    playerPos.getX() + radius, playerPos.getY() + radius, playerPos.getZ() + radius
            );

            // Find all Creepers in area.
            List<Creeper> creepers = level.getEntitiesOfClass(Creeper.class, area);

            if (!creepers.isEmpty()) {
                for (Creeper creeper : creepers) {
                    if (creeper.tickCount % 10 == 0) {
                        computeFleeBehavior(creeper, player);
                    }
                }
            }
        }
    }

    public static void computeFleeBehavior(Mob mob, Player player) {
        System.out.println("Creeper fleeing from player!");
        BlockPos mobPos = mob.blockPosition();
        BlockPos playerPos = player.blockPosition();

        // Compute direction away from the player
        Vec3 awayDirection = new Vec3(
                mobPos.getX() - playerPos.getX(),
                mobPos.getY() - playerPos.getY(),
                mobPos.getZ() - playerPos.getZ()
        ).normalize();

        // Move target position some blocks away
        Vec3 targetPos = new Vec3(
                mobPos.getX() + awayDirection.x * 8,
                mobPos.getY() + awayDirection.y * 8,
                mobPos.getZ() + awayDirection.z * 8
        );

        mob.getNavigation().moveTo(targetPos.x, targetPos.y, targetPos.z, 1.2);
    }


    // Done with the help of https://github.com/CoFH/CoFHCore/blob/1.19.x/src/main/java/cofh/core/event/AreaEffectEvents.java
    // Don't be a jerk License
}