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
    private final Random random = new Random();

    /**
     * Contructor of the class - will only put the right keys and values in the Maps
     */
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

    /**
     * Method triggered when a mob is killed and will be dropping items
     */
    @SubscribeEvent
    public void onEntityDrops(LivingDropsEvent event) {
        genTotalDrops(event);
        event.entityLiving.entityDropItem(getDrops(event.entityLiving), 0.0F);
    }

    /**
     * Returns the type of item dropped and it's count, depending on the entity
     */
    private ItemStack getDrops(Entity entity) {
        String entityName = entity.getClass().getSimpleName().substring(6); // EntitySheep -> Sheep
        Item itemDropped = entity.isBurning()
                ? cookedDropMap.get(entityName)
                : rawDropMap.get(entityName);
        return new ItemStack(itemDropped, totalDrops);
    }

    /**
     * Calculate the number of items dropped by the mob killed.
     */
    private void genTotalDrops(LivingDropsEvent event) {
        this.totalDrops = event.entityLiving.isChild()
                ? 0 : random.nextInt(2) + 1 + (event.lootingLevel > 0 ? random.nextInt(event.lootingLevel) + 1 : 0);
    }
}
