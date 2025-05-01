package foodaddition.model.items;

import foodaddition.config.Config;
import foodaddition.api.FoodAdditionItem;

public class Sheep extends FoodAdditionItem {

    public Sheep() {
        super(9, 0.6F);
    }

    @Override
    public boolean isItemEnabled() {
        return Config.sheepFoodEnabled;
    }

    @Override
    public String getItemName() {
        return "Mutton";
    }
    @Override
    public String getEntityName() {
        return "Sheep";
    }
}
