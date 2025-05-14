package foodaddition.config;

import net.minecraftforge.common.config.Configuration;

import java.io.File;

public class Config {

    public static Configuration config;
    public static boolean sheepFoodEnabled, squidFoodEnabled, horseFoodEnabled, wolfFoodEnabled;
    public static boolean potionEffectsEnabled;
    public static boolean thaumcraftIntegrationEnabled;

    public static void init(File file) {
        config = new Configuration(file);
        config.load();
        loadConfig();
    }

    private static void loadConfig() {
        String itemsCat = "Items", modOptions = "Mod Options", integs = "Integrations";
        config.addCustomCategoryComment(itemsCat, "Here you can disable/enable back food items. Change value to false to disable the food linked to the animal.");
        sheepFoodEnabled = config.get(itemsCat, "Sheep", true).getBoolean(true);
        squidFoodEnabled = config.get(itemsCat, "Squid", true).getBoolean(true);
        horseFoodEnabled = config.get(itemsCat, "Horse", true).getBoolean(true);
        wolfFoodEnabled = config.get(itemsCat, "Wolf", true).getBoolean(true);
        config.addCustomCategoryComment(modOptions, "Here you can turn on/off mechanics added my the mod");
        potionEffectsEnabled = config.get(modOptions, "Potion Effects", false).getBoolean(false);
        config.addCustomCategoryComment(integs, "Here you can tweak which integrations you want running or not.");
        thaumcraftIntegrationEnabled = config.get(integs, "Thaumcraft", true).getBoolean(true);
    }

    public static void save() {
        config.save();
    }
}
