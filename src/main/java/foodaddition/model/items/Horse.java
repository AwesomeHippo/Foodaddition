package foodaddition.model.items;

import foodaddition.config.Config;
import foodaddition.api.FoodAdditionItem;

public class Horse extends FoodAdditionItem {

    public Horse() {
        super(9, 0.6F);
    }

    @Override
    public boolean isItemEnabled() {
        return Config.horseFoodEnabled;
    }
}
