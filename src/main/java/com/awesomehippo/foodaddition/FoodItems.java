package com.awesomehippo.foodaddition;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;

public class FoodItems {
    public static Item rawMutton;
    public static Item cookedMutton;
    public static Item rawHorse;
    public static Item cookedHorse;
    public static Item rawCalamari;
    public static Item cookedCalamari;

    public static void initialize() {
        rawMutton = new ItemFood(2, 0.3F, true)
                .setUnlocalizedName("foodaddition.rawMutton")
                .setTextureName("foodaddition:raw_mutton");

        cookedMutton = new ItemFood(6, 0.783F, true)
                .setUnlocalizedName("foodaddition.cookedMutton")
                .setTextureName("foodaddition:cooked_mutton");

        rawHorse = new ItemFood(2, 0.3F, true)
                .setUnlocalizedName("foodaddition.rawHorse")
                .setTextureName("foodaddition:raw_horse");

        cookedHorse = new ItemFood(9, 0.6F, true)
                .setUnlocalizedName("foodaddition.cookedHorse")
                .setTextureName("foodaddition:cooked_horse");

        rawCalamari = new ItemFood(2, 0.3F, true)
                .setUnlocalizedName("foodaddition.rawCalamari")
                .setTextureName("foodaddition:raw_calamari");

        cookedCalamari = new ItemFood(3, 0.783F, true)
                .setUnlocalizedName("foodaddition.cookedCalamari")
                .setTextureName("foodaddition:cooked_calamari");

        GameRegistry.registerItem(rawMutton, "rawMutton");
        GameRegistry.registerItem(cookedMutton, "cookedMutton");
        GameRegistry.registerItem(rawHorse, "rawHorse");
        GameRegistry.registerItem(cookedHorse, "cookedHorse");
        GameRegistry.registerItem(rawCalamari, "rawCalamari");
        GameRegistry.registerItem(cookedCalamari, "cookedCalamari");

        GameRegistry.addSmelting(rawMutton, new ItemStack(cookedMutton), 0.35F);
        GameRegistry.addSmelting(rawHorse, new ItemStack(cookedHorse), 0.35F);
        GameRegistry.addSmelting(rawCalamari, new ItemStack(cookedCalamari), 0.35F);
    }
}
