package foodaddition;

import cpw.mods.fml.common.event.FMLServerStartingEvent;
import foodaddition.api.handlers.drops.DropHandler;
import foodaddition.api.handlers.effects.PotionEffectHandler;
import foodaddition.api.handlers.commands.RefreshFoodEffects;
import foodaddition.config.Config;
import foodaddition.api.config.ConfigItems;
import foodaddition.model.integrations.ThaumcraftCompat;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import foodaddition.api.recipes.ConfigRecipes;
import net.minecraftforge.common.MinecraftForge;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;

@Mod(modid = FoodAddition.modID, useMetadata = true)
public class FoodAddition {

    public static final String modID = "foodaddition";
    public static final Logger log = LogManager.getLogger(modID);
    public static File configDir;

    private final DropHandler dropHandler = new DropHandler();
    public static PotionEffectHandler effectHandler;

    @SuppressWarnings("ResultOfMethodCallIgnored")
    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        try {
            configDir = new File(event.getModConfigurationDirectory(), modID);
            configDir.mkdirs();
            Config.init(new File(configDir, "foodaddition.cfg"));
        } catch (Exception e) {
            log.error("Food Addition has a problem loading it's config");
        } finally {
            if (Config.config != null) Config.save();
        }

        // Registering items
        ConfigItems.init();
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
        // Mod recipes (Furnace)
        ConfigRecipes.init();
        // Drops from mobs
        MinecraftForge.EVENT_BUS.register(dropHandler);
        // Potion Effects upon eating food
        if (Config.potionEffectsEnabled)
            MinecraftForge.EVENT_BUS.register(new PotionEffectHandler());
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        // Mod is loaded AND config setting is true -> load integration
        if (Loader.isModLoaded("Thaumcraft") && Config.thaumcraftIntegrationEnabled)
            ThaumcraftCompat.init();
    }

    // Register the refresh command
    @Mod.EventHandler
    public void onServerStarting(FMLServerStartingEvent event) {
        event.registerServerCommand(new RefreshFoodEffects());
    }

}
