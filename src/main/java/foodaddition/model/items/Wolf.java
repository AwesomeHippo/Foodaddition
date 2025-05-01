package foodaddition.model.items;

import foodaddition.config.Config;
import foodaddition.api.FoodAdditionItem;

public class Wolf extends FoodAdditionItem {

    public Wolf() {
        super(8, 0.5F);
    }

    @Override
    public boolean canBeFeedToWolf() {
        return false;
    }
    @Override
    public boolean isItemEnabled() {
        return Config.wolfFoodEnabled;
    }
}
