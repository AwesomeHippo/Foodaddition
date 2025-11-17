package foodaddition.model.config;

import foodaddition.config.Config;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;

public class ConfigTweaks {

    public static void init() {
        addWheatToGrassDrops();
    }

    protected static void addWheatToGrassDrops() {
        MinecraftForge.addGrassSeed(new ItemStack(Items.wheat), Config.wheatDropWeight);
    }
}
