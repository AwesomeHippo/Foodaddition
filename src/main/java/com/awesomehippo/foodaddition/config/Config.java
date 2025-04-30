package com.awesomehippo.foodaddition.config;

import net.minecraftforge.common.config.Configuration;

import java.io.File;

public class Config {

    public static Configuration config;
    public static boolean sheepFoodEnabled, squidFoodEnabled, horseFoodEnabled, wolfFoodEnabled;

    public static void init(File file) {
        config = new Configuration(file);
        config.load();
        loadConfig();
    }

    private static void loadConfig() {
        config.addCustomCategoryComment("Food Items enabled", "Here you can disable/enable back food items. Change value to false to disable food linked to the animal.");
        sheepFoodEnabled = config.get("Food Items enabled", "Sheep", true).getBoolean(true);
        squidFoodEnabled = config.get("Food Items enabled", "Squid", true).getBoolean(true);
        horseFoodEnabled = config.get("Food Items enabled", "Horse", true).getBoolean(true);
        wolfFoodEnabled = config.get("Food Items enabled", "Wolf", true).getBoolean(true);
    }

    public static void save() {
        config.save();
    }
}
