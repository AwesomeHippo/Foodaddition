package foodaddition.model.config;

import cpw.mods.fml.common.registry.GameRegistry;
import foodaddition.api.items.ItemFoodPlus;
import foodaddition.model.items.BrownSugar;

public class ConfigItems {

    public static ItemFoodPlus brownSugar;

    public static void init() {
        brownSugar = new BrownSugar();
        GameRegistry.registerItem(brownSugar, brownSugar.getUnlocalizedName());
    }
}
