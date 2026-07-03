package foodaddition.model.config;

import cpw.mods.fml.common.registry.GameRegistry;
import foodaddition.api.config.ConfigMeatDropItems;
import foodaddition.api.items.ItemFoodPlus;
import foodaddition.model.items.BrownSugar;

public class ConfigItems {

    public static ItemFoodPlus brownSugar;

    public static void init() {
        ConfigMeatDropItems.init();
         initBrownSugar();
    }

    protected static void initBrownSugar() {
        brownSugar = new BrownSugar();
        GameRegistry.registerItem(brownSugar, brownSugar.getUnlocalizedName());
    }
}
