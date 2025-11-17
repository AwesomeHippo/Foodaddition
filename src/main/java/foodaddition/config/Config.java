package foodaddition.config;

import net.minecraftforge.common.config.Configuration;

import java.io.File;

public class Config {

    public static Configuration config;
    public static boolean sheepFoodEnabled, squidFoodEnabled, horseFoodEnabled, wolfFoodEnabled;
    public static boolean customMobDropsEnabled, potionEffectsEnabled, wheatDropFromGrass;
    public static boolean thaumcraftIntegrationEnabled;
    public static int wheatDropWeight;

    public static void init(File file) {
        config = new Configuration(file, "1.1");
        config.load();
        loadConfig();
    }

    private static void loadConfig() {
        String itemsCat = "Items", modOptions = "Mod-Options", integs = "Integrations";
        config.addCustomCategoryComment(itemsCat, "Here you can disable/enable back food items. Change value to false to disable the food linked to the animal.");
        sheepFoodEnabled = config.get(itemsCat, "Sheep", true).getBoolean(true);
        squidFoodEnabled = config.get(itemsCat, "Squid", true).getBoolean(true);
        horseFoodEnabled = config.get(itemsCat, "Horse", true).getBoolean(true);
        wolfFoodEnabled = config.get(itemsCat, "Wolf", true).getBoolean(true);
        config.addCustomCategoryComment(modOptions, "Here you can turn on/off mechanics added my the mod");
        customMobDropsEnabled = config.get(modOptions, "Custom Drops", true, "Turn off/on new raw meat items dropped by the right mobs when killed").getBoolean(true);
        potionEffectsEnabled = config.get(modOptions, "Potion Effects", false, "Turn on/off to generate a new json file, that will allow you to quickly add potion effects of your choice upon eating food items of your choice").getBoolean(false);
        wheatDropFromGrass = config.get(modOptions, "Wheat Drop From Grass", true).getBoolean(true);
        wheatDropWeight = config.get(modOptions, "Wheat Drop chance", 2, "Wheat drop chance from grass. 1 means 1/80 or 1.25% ; 10 means 1/8 or 12.5%", 1, 10).getInt(2);
        config.addCustomCategoryComment(integs, "Here you can tweak which integrations you want running or not.");
        thaumcraftIntegrationEnabled = config.get(integs, "Thaumcraft", true, "Set aspects to new items added").getBoolean(true);
    }

    public static void save() {
        config.save();
    }
}
