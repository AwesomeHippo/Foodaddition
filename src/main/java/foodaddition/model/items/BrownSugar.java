package foodaddition.model.items;

import foodaddition.api.items.ItemFoodPlus;

public class BrownSugar extends ItemFoodPlus {
    // RGB : 175, 110, 75 // 0.5 Food + 0.2 Saturation
    public BrownSugar() {
        super(1, 0.2F, "brown_sugar");
    }
}
