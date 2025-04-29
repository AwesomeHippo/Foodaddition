package com.awesomehippo.foodaddition;

import com.awesomehippo.foodaddition.integrations.ThaumcraftCompat;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.common.MinecraftForge;

@Mod(modid = "sheepfood", name = "Food Addition", version = "1.5", acceptedMinecraftVersions = "[1.7.10]")
public class FoodAddition {

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        new FoodItems();
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
        MinecraftForge.EVENT_BUS.register(new DropHandler());
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        if (Loader.isModLoaded("Thaumcraft")) new ThaumcraftCompat();
    }
}
