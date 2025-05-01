package foodaddition;

import foodaddition.config.Config;
import foodaddition.config.ConfigItems;
import foodaddition.model.integrations.ThaumcraftCompat;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import foodaddition.config.ConfigRecipes;
import net.minecraftforge.common.MinecraftForge;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(modid = "foodaddition", name = "Food Addition", version = "2.0", acceptedMinecraftVersions = "[1.7.10]")
public class FoodAddition {

    public static final String modID = "foodaddition";
    public static final Logger log = LogManager.getLogger(modID);

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        try {
            Config.init(event.getSuggestedConfigurationFile());
        } catch (Exception e) {
            log.error("Food Addition has a problem loading it's config");
        } finally {
            if (Config.config != null) Config.save();
        }
        try {
            ConfigItems.init();
        } catch (InstantiationException | IllegalAccessException e) {
            FoodAddition.log.fatal(FoodAddition.modID, "A fatal error occured in the definition of items.");
        }
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
        MinecraftForge.EVENT_BUS.register(new DropHandler());
        ConfigRecipes.init();
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        // Mod is loaded AND config setting is true -> load integration
        if (Loader.isModLoaded("Thaumcraft") && Config.thaumcraftIntegrationEnabled) ThaumcraftCompat.init();
    }
}
