package foodaddition.api.recipes.furnace;

import cpw.mods.fml.common.registry.GameRegistry;
import foodaddition.api.config.ConfigMeatDropItems;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class FurnaceRecipes {

    public static void init() {
        for (String entity : ConfigMeatDropItems.entitiesThatDrop)
            registerRecipe(ConfigMeatDropItems.getRawItem(entity), ConfigMeatDropItems.getCookedItem(entity));
    }

    public static void registerRecipe(Item rawItem, Item cookedItem) {
        GameRegistry.addSmelting(rawItem, new ItemStack(cookedItem), 0.3F);
    }
}
