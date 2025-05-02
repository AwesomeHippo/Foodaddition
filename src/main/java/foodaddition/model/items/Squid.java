package foodaddition.model.items;

import foodaddition.config.Config;
import foodaddition.api.items.FoodAdditionItem;

public class Squid extends FoodAdditionItem {

    public Squid() {
        super(3, 0.783F);
    }

    @Override
    public boolean isItemEnabled() {
        return Config.squidFoodEnabled;
    }

    @Override
    public String getItemName() {
        return "Calamari";
    }
    @Override
    public String getEntityName() {
        return "Squid";
    }
}
