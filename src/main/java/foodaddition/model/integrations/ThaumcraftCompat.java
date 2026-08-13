package foodaddition.model.integrations;

import foodaddition.FoodAddition;
import foodaddition.api.config.ConfigMeatDropItems;
import foodaddition.model.items.GrilledFood;
import foodaddition.model.items.meatDrop.Horse;
import foodaddition.model.items.meatDrop.Sheep;
import foodaddition.model.items.meatDrop.Squid;
import foodaddition.model.items.meatDrop.Wolf;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import thaumcraft.api.ThaumcraftApi;
import thaumcraft.api.aspects.AspectList;

import static foodaddition.config.Config.*;
import static foodaddition.model.config.ConfigItems.*;
import static thaumcraft.api.aspects.Aspect.*;

public class ThaumcraftCompat {

    public static void init() {
        // Brown Sugar
        if (brownSugarEnabled) {
            setAspects(brownSugar, new AspectList()
                    .add(HUNGER, 1));
        }
        // Grilled Food
        if (grilledFoodEnabled) {
            AspectList aspects = new AspectList()
                    .add(FLESH, 1)
                    .add(HUNGER, 1)
                    .add(FIRE, 1);
            for (int i = 0; i < GrilledFood.nbSubTypes; i++)
                setAspects(grilledFood, i, aspects);
        }
        // Food Addition
        {
            // Sheep
            setAspects(ConfigMeatDropItems.getRawItem(Sheep.class.getSimpleName()), new AspectList()
                    .add(FLESH, 3)
                    .add(LIFE, 1)
                    .add(BEAST, 1));
            setAspects(ConfigMeatDropItems.getCookedItem(Sheep.class.getSimpleName()), new AspectList()
                    .add(FLESH, 4)
                    .add(HUNGER, 3)
                    .add(CRAFT, 1));
            // Squid
            setAspects(ConfigMeatDropItems.getRawItem(Squid.class.getSimpleName()), new AspectList()
                    .add(FLESH, 2)
                    .add(LIFE, 1)
                    .add(WATER, 1));
            setAspects(ConfigMeatDropItems.getCookedItem(Squid.class.getSimpleName()), new AspectList()
                    .add(FLESH, 3)
                    .add(HUNGER, 2)
                    .add(CRAFT, 1));
            // Horse
            setAspects(ConfigMeatDropItems.getRawItem(Horse.class.getSimpleName()), new AspectList()
                    .add(FLESH, 3)
                    .add(LIFE, 1)
                    .add(BEAST, 1));
            setAspects(ConfigMeatDropItems.getCookedItem(Horse.class.getSimpleName()), new AspectList()
                    .add(FLESH, 4)
                    .add(HUNGER, 3)
                    .add(CRAFT, 1));
            // Wolf
            setAspects(ConfigMeatDropItems.getRawItem(Wolf.class.getSimpleName()), new AspectList()
                    .add(FLESH, 3)
                    .add(LIFE, 1)
                    .add(BEAST, 2));
            setAspects(ConfigMeatDropItems.getCookedItem(Wolf.class.getSimpleName()), new AspectList()
                    .add(FLESH, 3)
                    .add(HUNGER, 3)
                    .add(CRAFT, 1));
        }
        FoodAddition.log("[Food Addition] Thaumcraft Integration loaded !");
    }
    
    private static void setAspects(Item item, AspectList aspects) {
        setAspects(item, 0, aspects);
    }

    private static void setAspects(Item item, int meta, AspectList aspects) {
        ThaumcraftApi.registerObjectTag(new ItemStack(item, 1, meta), aspects);
    }
}