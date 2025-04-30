package com.awesomehippo.foodaddition.integrations;

import com.awesomehippo.foodaddition.config.ConfigItems;
import net.minecraft.item.ItemStack;
import thaumcraft.api.ThaumcraftApi;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectList;

public class ThaumcraftCompat {

    public ThaumcraftCompat() {
        this.registerItemAspects();
    }

    private void registerItemAspects() {
        ThaumcraftApi.registerObjectTag(new ItemStack(ConfigItems.rawMutton), new AspectList()
                .add(Aspect.FLESH, 3)
                .add(Aspect.LIFE, 1)
                .add(Aspect.BEAST, 1));
        ThaumcraftApi.registerObjectTag(new ItemStack(ConfigItems.cookedMutton), new AspectList()
                .add(Aspect.FLESH, 4)
                .add(Aspect.HUNGER, 3)
                .add(Aspect.CRAFT, 1));
        ThaumcraftApi.registerObjectTag(new ItemStack(ConfigItems.rawCalamari), new AspectList()
                .add(Aspect.FLESH, 2)
                .add(Aspect.LIFE, 1)
                .add(Aspect.WATER, 1));
        ThaumcraftApi.registerObjectTag(new ItemStack(ConfigItems.cookedCalamari), new AspectList()
                .add(Aspect.FLESH, 3)
                .add(Aspect.HUNGER, 2)
                .add(Aspect.CRAFT, 1));
        ThaumcraftApi.registerObjectTag(new ItemStack(ConfigItems.rawHorse), new AspectList()
                .add(Aspect.FLESH, 3)
                .add(Aspect.LIFE, 1)
                .add(Aspect.BEAST, 1));
        ThaumcraftApi.registerObjectTag(new ItemStack(ConfigItems.cookedHorse), new AspectList()
                .add(Aspect.FLESH, 4)
                .add(Aspect.HUNGER, 3)
                .add(Aspect.CRAFT, 1));
        ThaumcraftApi.registerObjectTag(new ItemStack(ConfigItems.rawWolf), new AspectList()
                .add(Aspect.FLESH, 3)
                .add(Aspect.LIFE, 1)
                .add(Aspect.BEAST, 2));
        ThaumcraftApi.registerObjectTag(new ItemStack(ConfigItems.cookedWolf), new AspectList()
                .add(Aspect.FLESH, 3)
                .add(Aspect.HUNGER, 3)
                .add(Aspect.CRAFT, 1));
    }
}
