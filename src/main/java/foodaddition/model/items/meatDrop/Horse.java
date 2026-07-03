package foodaddition.model.items.meatDrop;

import foodaddition.config.Config;
import foodaddition.api.items.FoodAdditionItem;

public class Horse extends FoodAdditionItem {

    public Horse() {
        super(9, 0.6F);
    }

    @Override
    public boolean isItemEnabled() {
        return Config.horseFoodEnabled;
    }
}
