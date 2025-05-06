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
        String itemsCat = "Food Items Config", expertCat = "Expert Mode";
        config.addCustomCategoryComment(itemsCat, "Here you can disable/enable back food items. Change value to false to disable the food linked to the animal.");
        sheepFoodEnabled = config.get(itemsCat, "Sheep", true).getBoolean(true);
        squidFoodEnabled = config.get(itemsCat, "Squid", true).getBoolean(true);
        horseFoodEnabled = config.get(itemsCat, "Horse", true).getBoolean(true);
        wolfFoodEnabled = config.get(itemsCat, "Wolf", true).getBoolean(true);
        config.addCustomCategoryComment(expertCat, "The Expert Mode set potion effects on the player after eating specific food");
        potionEffectsEnabled = config.get(expertCat, "Potion Effects", false).getBoolean(false);
        thaumcraftIntegrationEnabled = config.get("Mod Integration Enabled", "Thaumcraft", true).getBoolean(true);
    }

    public static void save() {
        config.save();
    }
}
