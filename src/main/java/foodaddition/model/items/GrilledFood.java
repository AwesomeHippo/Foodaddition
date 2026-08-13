package foodaddition.model.items;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import foodaddition.FoodAddition;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

import java.util.List;

@SuppressWarnings("unchecked")
public class GrilledFood extends ItemFood {

    private static final String[] names = {"grilled_beef", "grilled_pork", "grilled_chicken", "grilled_fish", "grilled_mutton", "grilled_horse", "grilled_squid", "grilled_wolf"};
    private static final int[] hunger = {4, 4, 3, 2, 5, 5, 2, 4};
    private static final float[] saturation = {0.875F, 0.875F, 0.6666F, 0.75F, 0.6F, 0.6F, 0.75F, 0.5F};
    private static final int nbSubTypes = saturation.length;
    public static final String unlocalizedLocalName = "grilledFood";

    @SideOnly(Side.CLIENT)
    private IIcon[] icons;

    public GrilledFood() {
        super(hunger[0], saturation[0], true);
        this.setHasSubtypes(true);
        this.setMaxDamage(0);
        this.setUnlocalizedName(unlocalizedLocalName);
        this.setCreativeTab(CreativeTabs.tabFood);
    }

    @Override public IIcon getIconFromDamage(int meta) {
        return this.icons[meta < 0 || meta >= nbSubTypes ? 0 : meta];
    }
    @Override public void registerIcons(IIconRegister register) {
        this.icons = new IIcon[nbSubTypes];
        for (int i = 0; i < nbSubTypes; i++)
            this.icons[i] = register.registerIcon(FoodAddition.modID.concat(":").concat(names[i]));
    }
    @Override public void getSubItems(Item item, CreativeTabs tab, List list) {
        for (int i = 0; i < nbSubTypes; i++)
            list.add(new ItemStack(item, 1, i));
    }
    @Override public String getUnlocalizedName(ItemStack item) {
        int meta = item.getItemDamage();
        return super.getUnlocalizedName().concat(".").concat(names[meta < 0 || meta >= nbSubTypes ? 0 : meta]);
    }

    /**
     * Returns hunger, depending on metadata
     */
    @Override public int func_150905_g(ItemStack item) {
        int meta = item.getItemDamage();
        return hunger[meta < 0 || meta >= nbSubTypes ? 0 : meta];
    }
    /**
     * Returns saturation, depending on metadata
     */
    @Override public float func_150906_h(ItemStack item) {
        int meta = item.getItemDamage();
        return saturation[meta < 0 || meta >= nbSubTypes ? 0 : meta];
    }
}
