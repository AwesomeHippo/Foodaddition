package com.awesomehippo.foodaddition;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.common.MinecraftForge;

@Mod(modid = "sheepfood", name = "Food Addition", version = "1.5", acceptedMinecraftVersions = "[1.7.10]")
public class FoodAddition {

    @EventHandler
    public void initialize(FMLInitializationEvent event) {
        new FoodItems();
        MinecraftForge.EVENT_BUS.register(new DropHandler());
    }
}
