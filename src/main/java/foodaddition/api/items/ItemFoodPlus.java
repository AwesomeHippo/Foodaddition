package foodaddition.api.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemFood;

import static foodaddition.FoodAddition.*;

public abstract class ItemFoodPlus extends ItemFood {

    public ItemFoodPlus(int hunger, float saturation, String unlocalizedName) {
        super(hunger, saturation, false);
        this.setUnlocalizedName(unlocalizedName);
        this.setTextureName(modID.concat(":").concat(unlocalizedName));
        this.setCreativeTab(CreativeTabs.tabFood);
    }
}
