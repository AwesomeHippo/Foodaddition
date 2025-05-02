package foodaddition.api.items;

import cpw.mods.fml.common.registry.GameRegistry;
import foodaddition.config.Config;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.potion.Potion;

public abstract class FoodAdditionItem {
    private static final String editedModID = "foodaddition", rawID = "Raw", cookedID = "Cooked";
    private static final int hunger = 2;
    private static final float saturation = 0.3F;
    private final int hungerCooked;
    private final float saturationCooked;
    private Item itemRaw, itemCooked;

    /**
     * Constructor for the item API.
     * All you need to do for the children class is to register it to ConfigItems, and it will do all the work.
     * The texture files need to be named "RawX" and "CookedX", X being the Class's simple. The method getItemName() can be Override if needed.
     * @param hungerCooked Hunger points restored by the food when eaten
     * @param saturationCooked Saturation restored by the food when eaten
     */
    public FoodAdditionItem(int hungerCooked, float saturationCooked) {
        this.hungerCooked = hungerCooked;
        this.saturationCooked = saturationCooked;
        init();
    }

    public void init() {
        if (isItemEnabled()) {
            this.itemRaw = new ItemFood(hunger, saturation, canBeFeedToWolf())
                    .setPotionEffect(Potion.confusion.id, 15, 1, isRawEffectsEnabled())
                    // ToDo The method only allows for one potion-effect per item ... Gonna fire event
                    //.setPotionEffect(Potion.moveSlowdown.id, 15, 1, isRawEffectsEnabled())
                    //.setPotionEffect(Potion.weakness.id, 30, 1, isRawEffectsEnabled())
                    .setUnlocalizedName(getUnlocalizedName(rawID))
                    .setTextureName(getTextureName(rawID));
            GameRegistry.registerItem(itemRaw, itemRaw.getUnlocalizedName().substring(5));
            itemCooked = new ItemFood(hungerCooked, saturationCooked, canBeFeedToWolf())
                    .setUnlocalizedName(getUnlocalizedName(cookedID))
                    .setTextureName(getTextureName(cookedID));
            GameRegistry.registerItem(itemCooked, itemCooked.getUnlocalizedName().substring(5));
        }
    }

    public Item getItemRaw() {
        return itemRaw;
    }
    public Item getItemCooked() {
        return itemCooked;
    }

    public boolean canBeFeedToWolf() {
        return true;
    }
    public float isRawEffectsEnabled() {
        return Config.rawEffectsEnabled ? 1.0F : 0.0F;
    }
    public float isCookedEffectsEnabled() {
        return Config.cookedEffectsEnabled ? 1.0F : 0.0F;
    }
    public abstract boolean isItemEnabled();

    /**
     * Returns the Entity's name linked to the food item
     */
    public String getEntityName() {
        return getClass().getSimpleName();
    }
    /**
     * Return the Item's text, depending on the class name
     */
    public String getItemName() {
        return getClass().getSimpleName();
    }
    /**
     * Returns the Item's unlocalized name, depending on child class name and raw/cooked state
     */
    public String getUnlocalizedName(String id) {
        return editedModID.concat(".").concat(id).concat(getItemName());
    }
    /**
     * Returns the Item's texture name, depending on child class name and raw/cooked state
     */
    public String getTextureName(String id) {
        return editedModID.concat(":").concat(id).concat(getItemName());
    }
}
