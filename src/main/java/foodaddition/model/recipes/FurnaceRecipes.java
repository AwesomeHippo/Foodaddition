package foodaddition.model.recipes;

import cpw.mods.fml.common.registry.GameRegistry;
import foodaddition.config.ConfigItems;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class FurnaceRecipes {

    public static void init() {
        for (String entity : ConfigItems.entities)
            registerRecipe(ConfigItems.getRawItem(entity), ConfigItems.getCookedItem(entity));
    }

    public static void registerRecipe(Item rawItem, Item cookedItem) {
        GameRegistry.addSmelting(rawItem, new ItemStack(cookedItem), 0.3F);
    }
}
