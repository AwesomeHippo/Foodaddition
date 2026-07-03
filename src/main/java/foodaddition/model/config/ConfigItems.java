package foodaddition.model.config;

import cpw.mods.fml.common.registry.GameRegistry;
import foodaddition.api.config.ConfigMeatDropItems;
import foodaddition.api.items.ItemFoodPlus;
import foodaddition.config.Config;
import foodaddition.model.items.BrownSugar;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.ShapedRecipes;

public class ConfigItems {

    public static ItemFoodPlus brownSugar;

    public static void init() {
        ConfigMeatDropItems.init();
        if (Config.brownSugarEnabled) initBrownSugar();
    }

    protected static void initBrownSugar() {
        // Registering item
        brownSugar = new BrownSugar();
        GameRegistry.registerItem(brownSugar, brownSugar.getUnlocalizedName());

        // Removing recipe for white sugar
        {
        ShapedRecipes sugarRecipe = null;
        for (Object o : CraftingManager.getInstance().getRecipeList())
            if (o instanceof ShapedRecipes) {
                ShapedRecipes r = (ShapedRecipes) o;
                if (r.getRecipeOutput() != null & r.getRecipeOutput().getItem() != null
                        && r.getRecipeOutput().getItem().equals(Items.sugar) && r.getRecipeOutput().stackSize == 1 && r.recipeItems[0].getItem().equals(Items.reeds))
                    sugarRecipe = r;
            }
        if (sugarRecipe == null) throw new RuntimeException("Recipe for sugar not found, report to author");
        else CraftingManager.getInstance().getRecipeList().remove(sugarRecipe);}
        // Adding recipe for reed -> brown sugar
        GameRegistry.addShapelessRecipe(new ItemStack(brownSugar), new ItemStack(Items.reeds));
        // Adding recipe for brown sugar -> sugar
        GameRegistry.addShapelessRecipe(new ItemStack(Items.sugar), new ItemStack(brownSugar));
    }
}
