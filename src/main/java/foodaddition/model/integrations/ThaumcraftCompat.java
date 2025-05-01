package foodaddition.model.integrations;

import foodaddition.FoodAddition;
import foodaddition.model.items.*;
import foodaddition.config.ConfigItems;
import net.minecraft.item.ItemStack;
import thaumcraft.api.ThaumcraftApi;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectList;

public class ThaumcraftCompat {

    public static void init() {
        // Sheep
        ThaumcraftApi.registerObjectTag(new ItemStack(ConfigItems.getRawItem(Sheep.class.getSimpleName())), new AspectList()
                .add(Aspect.FLESH, 3)
                .add(Aspect.LIFE, 1)
                .add(Aspect.BEAST, 1));
        ThaumcraftApi.registerObjectTag(new ItemStack(ConfigItems.getCookedItem(Sheep.class.getSimpleName())), new AspectList()
                .add(Aspect.FLESH, 4)
                .add(Aspect.HUNGER, 3)
                .add(Aspect.CRAFT, 1));
        // Squid
        ThaumcraftApi.registerObjectTag(new ItemStack(ConfigItems.getRawItem(Squid.class.getSimpleName())), new AspectList()
                .add(Aspect.FLESH, 2)
                .add(Aspect.LIFE, 1)
                .add(Aspect.WATER, 1));
        ThaumcraftApi.registerObjectTag(new ItemStack(ConfigItems.getCookedItem(Squid.class.getSimpleName())), new AspectList()
                .add(Aspect.FLESH, 3)
                .add(Aspect.HUNGER, 2)
                .add(Aspect.CRAFT, 1));
        // Horse
        ThaumcraftApi.registerObjectTag(new ItemStack(ConfigItems.getRawItem(Horse.class.getSimpleName())), new AspectList()
                .add(Aspect.FLESH, 3)
                .add(Aspect.LIFE, 1)
                .add(Aspect.BEAST, 1));
        ThaumcraftApi.registerObjectTag(new ItemStack(ConfigItems.getCookedItem(Horse.class.getSimpleName())), new AspectList()
                .add(Aspect.FLESH, 4)
                .add(Aspect.HUNGER, 3)
                .add(Aspect.CRAFT, 1));
        // Wolf
        ThaumcraftApi.registerObjectTag(new ItemStack(ConfigItems.getRawItem(Wolf.class.getSimpleName())), new AspectList()
                .add(Aspect.FLESH, 3)
                .add(Aspect.LIFE, 1)
                .add(Aspect.BEAST, 2));
        ThaumcraftApi.registerObjectTag(new ItemStack(ConfigItems.getCookedItem(Wolf.class.getSimpleName())), new AspectList()
                .add(Aspect.FLESH, 3)
                .add(Aspect.HUNGER, 3)
                .add(Aspect.CRAFT, 1));
        FoodAddition.log.info(FoodAddition.modID,"Food Addition : Thaumcraft Integration loaded !");
    }
}
