package com.awesomehippo.foodaddition;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.entity.passive.EntityHorse;
import net.minecraft.entity.passive.EntitySquid;
import net.minecraft.entity.passive.EntityWolf;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingDropsEvent;

import java.util.Random;

public class DropHandler {
    private static final Random random = new Random();

    @SubscribeEvent
    public void onEntityDrop(LivingDropsEvent event) {
        if (event.entityLiving instanceof EntitySheep) {
            int baseAmount = random.nextInt(2) + 1;
            int lootingBonus = event.lootingLevel > 0 ? random.nextInt(event.lootingLevel + 1) : 0;
            int totalDrops = baseAmount + lootingBonus;
            ItemStack drop = event.entityLiving.isBurning()
                    ? new ItemStack(FoodItems.cookedMutton, totalDrops)
                    : new ItemStack(FoodItems.rawMutton, totalDrops);
            event.entityLiving.entityDropItem(drop, 0.0F);

        } else if (event.entityLiving instanceof EntityHorse) {
            int baseAmount = random.nextInt(2) + 1;
            int lootingBonus = event.lootingLevel > 0 ? random.nextInt(event.lootingLevel + 1) : 0;
            int totalDrops = baseAmount + lootingBonus;
            ItemStack drop = event.entityLiving.isBurning()
                    ? new ItemStack(FoodItems.cookedHorse, totalDrops)
                    : new ItemStack(FoodItems.rawHorse, totalDrops);
            event.entityLiving.entityDropItem(drop, 0.0F);

        } else if (event.entityLiving instanceof EntitySquid) {
            int baseAmount = random.nextInt(2) + 1;
            int lootingBonus = event.lootingLevel > 0 ? random.nextInt(event.lootingLevel + 1) : 0;
            int totalDrops = baseAmount + lootingBonus;
            ItemStack drop = event.entityLiving.isBurning()
                    ? new ItemStack(FoodItems.cookedCalamari, totalDrops)
                    : new ItemStack(FoodItems.rawCalamari, totalDrops);
            event.entityLiving.entityDropItem(drop, 0.0F);

        } else if (event.entityLiving instanceof EntityWolf) {
            int baseAmount = random.nextInt(2) + 1;
            int lootingBonus = event.lootingLevel > 0 ? random.nextInt(event.lootingLevel + 1) : 0;
            int totalDrops = baseAmount + lootingBonus;
            ItemStack drop = event.entityLiving.isBurning()
                    ? new ItemStack(FoodItems.cookedWolf, totalDrops)
                    : new ItemStack(FoodItems.rawWolf, totalDrops);
            event.entityLiving.entityDropItem(drop, 0.0F);
        }
    }
}
