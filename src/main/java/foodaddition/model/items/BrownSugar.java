package foodaddition.model.items;

import foodaddition.api.items.ItemFoodPlus;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;

public class BrownSugar extends ItemFoodPlus {
    // RGB : 175, 110, 75 // 0.5 Food + 0.2 Saturation
    public BrownSugar() {
        super(1, 0.2F, "brown_sugar");
        // Speed, 2 seconds, lvl.1, 100%
        setPotionEffect(Potion.moveSpeed.id, 2, 0, 1.0F);
    }

    @Override
    public int getMaxItemUseDuration(ItemStack stack) {
        return 10;
    }
}
