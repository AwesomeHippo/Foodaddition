package com.awesomehippo.foodaddition;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.common.MinecraftForge;

@Mod(modid = "sheepfood", version = "1.4", acceptedMinecraftVersions = "[1.7.10]")
public class FoodAddition {
    @EventHandler
    public void initialize(FMLInitializationEvent event) {
        FoodItems.initialize();
        MinecraftForge.EVENT_BUS.register(new DropHandler());
    }
}
