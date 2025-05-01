package foodaddition.config;

import net.minecraftforge.common.config.Configuration;

import java.io.File;

public class Config {

    public static Configuration config;
    public static boolean sheepFoodEnabled, squidFoodEnabled, horseFoodEnabled, wolfFoodEnabled;
    public static boolean thaumcraftIntegrationEnabled;

    public static void init(File file) {
        config = new Configuration(file);
        config.load();
        loadConfig();
    }

    private static void loadConfig() {
        String itemsCat = "Food ConfigItems";
        config.addCustomCategoryComment(itemsCat, "Here you can disable/enable back food items. Change value to false to disable the food linked to the animal.");
        sheepFoodEnabled = config.get(itemsCat, "Sheep", true).getBoolean(true);
        squidFoodEnabled = config.get(itemsCat, "Squid", true).getBoolean(true);
        horseFoodEnabled = config.get(itemsCat, "Horse", true).getBoolean(true);
        wolfFoodEnabled = config.get(itemsCat, "Wolf", true).getBoolean(true);
        thaumcraftIntegrationEnabled = config.get("Mod Integration Enabled", "Thaumcraft", true).getBoolean(true);
    }

    public static void save() {
        config.save();
    }
}
