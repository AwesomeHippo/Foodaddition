package foodaddition.model.integrations;

import foodaddition.FoodAddition;
import foodaddition.model.items.*;
import foodaddition.api.config.ConfigItems;
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
        setAspects(ConfigItems.getRawItem(Sheep.class.getSimpleName()), new AspectList()
                .add(Aspect.FLESH, 3)
                .add(Aspect.LIFE, 1)
                .add(Aspect.BEAST, 1));
        setAspects(ConfigItems.getCookedItem(Sheep.class.getSimpleName()), new AspectList()
                .add(Aspect.FLESH, 4)
                .add(Aspect.HUNGER, 3)
                .add(Aspect.CRAFT, 1));
        // Squid
        setAspects(ConfigItems.getRawItem(Squid.class.getSimpleName()), new AspectList()
                .add(Aspect.FLESH, 2)
                .add(Aspect.LIFE, 1)
                .add(Aspect.WATER, 1));
        setAspects(ConfigItems.getCookedItem(Squid.class.getSimpleName()), new AspectList()
                .add(Aspect.FLESH, 3)
                .add(Aspect.HUNGER, 2)
                .add(Aspect.CRAFT, 1));
        // Horse
        setAspects(ConfigItems.getRawItem(Horse.class.getSimpleName()), new AspectList()
                .add(Aspect.FLESH, 3)
                .add(Aspect.LIFE, 1)
                .add(Aspect.BEAST, 1));
        setAspects(ConfigItems.getCookedItem(Horse.class.getSimpleName()), new AspectList()
                .add(Aspect.FLESH, 4)
                .add(Aspect.HUNGER, 3)
                .add(Aspect.CRAFT, 1));
        // Wolf
        setAspects(ConfigItems.getRawItem(Wolf.class.getSimpleName()), new AspectList()
                .add(Aspect.FLESH, 3)
                .add(Aspect.LIFE, 1)
                .add(Aspect.BEAST, 2));
        setAspects(ConfigItems.getCookedItem(Wolf.class.getSimpleName()), new AspectList()
                .add(Aspect.FLESH, 3)
                .add(Aspect.HUNGER, 3)
                .add(Aspect.CRAFT, 1));
        FoodAddition.log("[Food Addition] Thaumcraft Integration loaded !");
    }
    
    protected static void setAspects(Item item, AspectList aspects) {
        ThaumcraftApi.registerObjectTag(new ItemStack(item), aspects);
    }
}