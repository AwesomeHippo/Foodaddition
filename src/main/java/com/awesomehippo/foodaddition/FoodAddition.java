package com.awesomehippo.foodaddition;

import com.awesomehippo.foodaddition.config.Config;
import com.awesomehippo.foodaddition.config.ConfigItems;
import com.awesomehippo.foodaddition.integrations.ThaumcraftCompat;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.common.MinecraftForge;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(modid = "sheepfood", name = "Food Addition", version = "1.6", acceptedMinecraftVersions = "[1.7.10]")
public class FoodAddition {

    public static final Logger log = LogManager.getLogger("sheepfood");

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        // Exception handler for config loading
        try {
            Config.init(event.getSuggestedConfigurationFile());
        } catch (Exception e) {
            log.error("Food Addition has a problem loading it's config");
        } finally {
            if (Config.config != null) Config.save();
        }

        ConfigItems.init();
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
