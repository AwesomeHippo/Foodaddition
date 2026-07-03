package foodaddition.model.integrations;

import foodaddition.FoodAddition;
import foodaddition.model.config.ConfigItems;
import foodaddition.api.config.ConfigMeatDropItems;
import foodaddition.model.items.meatDrop.Horse;
import foodaddition.model.items.meatDrop.Sheep;
import foodaddition.model.items.meatDrop.Squid;
import foodaddition.model.items.meatDrop.Wolf;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import thaumcraft.api.ThaumcraftApi;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectList;

public class ThaumcraftCompat {

    public static void init() {
        // Brown Sugar
        setAspects(ConfigItems.brownSugar, new AspectList()
                .add(Aspect.HUNGER, 1));
        // Sheep
        setAspects(ConfigMeatDropItems.getRawItem(Sheep.class.getSimpleName()), new AspectList()
                .add(Aspect.FLESH, 3)
                .add(Aspect.LIFE, 1)
                .add(Aspect.BEAST, 1));
        setAspects(ConfigMeatDropItems.getCookedItem(Sheep.class.getSimpleName()), new AspectList()
                .add(Aspect.FLESH, 4)
                .add(Aspect.HUNGER, 3)
                .add(Aspect.CRAFT, 1));
        // Squid
        setAspects(ConfigMeatDropItems.getRawItem(Squid.class.getSimpleName()), new AspectList()
                .add(Aspect.FLESH, 2)
                .add(Aspect.LIFE, 1)
                .add(Aspect.WATER, 1));
        setAspects(ConfigMeatDropItems.getCookedItem(Squid.class.getSimpleName()), new AspectList()
                .add(Aspect.FLESH, 3)
                .add(Aspect.HUNGER, 2)
                .add(Aspect.CRAFT, 1));
        // Horse
        setAspects(ConfigMeatDropItems.getRawItem(Horse.class.getSimpleName()), new AspectList()
                .add(Aspect.FLESH, 3)
                .add(Aspect.LIFE, 1)
                .add(Aspect.BEAST, 1));
        setAspects(ConfigMeatDropItems.getCookedItem(Horse.class.getSimpleName()), new AspectList()
                .add(Aspect.FLESH, 4)
                .add(Aspect.HUNGER, 3)
                .add(Aspect.CRAFT, 1));
        // Wolf
        setAspects(ConfigMeatDropItems.getRawItem(Wolf.class.getSimpleName()), new AspectList()
                .add(Aspect.FLESH, 3)
                .add(Aspect.LIFE, 1)
                .add(Aspect.BEAST, 2));
        setAspects(ConfigMeatDropItems.getCookedItem(Wolf.class.getSimpleName()), new AspectList()
                .add(Aspect.FLESH, 3)
                .add(Aspect.HUNGER, 3)
                .add(Aspect.CRAFT, 1));
        FoodAddition.log("[Food Addition] Thaumcraft Integration loaded !");
    }
    
    protected static void setAspects(Item item, AspectList aspects) {
        ThaumcraftApi.registerObjectTag(new ItemStack(item), aspects);
    }
}