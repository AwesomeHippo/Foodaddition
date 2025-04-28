package com.awesomehippo.foodaddition;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingDropsEvent;

import java.util.HashMap;
import java.util.Random;

public class DropHandler {
    private int totalDrops;
    private final HashMap<String, Item> rawDropMap = new HashMap<>(), cookedDropMap = new HashMap<>();
    private static final Random random = new Random();

    public DropHandler(){
        rawDropMap.put("Sheep", FoodItems.rawMutton);
        rawDropMap.put("Horse", FoodItems.rawHorse);
        rawDropMap.put("Squid", FoodItems.rawCalamari);
        rawDropMap.put("Wolf", FoodItems.rawWolf);
        cookedDropMap.put("Sheep", FoodItems.cookedMutton);
        cookedDropMap.put("Horse", FoodItems.cookedHorse);
        cookedDropMap.put("Squid", FoodItems.cookedCalamari);
        cookedDropMap.put("Wolf", FoodItems.cookedWolf);
    }

    @SubscribeEvent
    public void onEntityDrops(LivingDropsEvent event) {
        genTotalDrops(event.lootingLevel);
        event.entityLiving.entityDropItem(getDrops(event.entityLiving), 0.0F);
    }

    private ItemStack getDrops(Entity entity) {
        String entityName = entity.getClass().getSimpleName().substring(6); // EntitySheep -> Sheep
        Item itemDropped = entity.isBurning()
                ? cookedDropMap.get(entityName)
                : rawDropMap.get(entityName);
        return new ItemStack(itemDropped, totalDrops);
    }

    private void genTotalDrops(int looting) {
        this.totalDrops = random.nextInt(2) + 1 + (looting > 0 ? random.nextInt(looting + 1) : 0);

    }
}
