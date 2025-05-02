package foodaddition.api.items.drops;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import foodaddition.api.config.ConfigItems;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingDropsEvent;

import java.util.Random;

public class DropHandler {
    private int totalDrops;
    private final Random random = new Random();

    /**
     * Method triggered when a mob is killed and will be dropping items
     */
    @SubscribeEvent
    public void onEntityDrops(LivingDropsEvent event) {
        genTotalDrops(event);
        event.entityLiving.entityDropItem(getDrops(event.entityLiving), 0.0F);
    }

    /**
     * Returns the type of item dropped and it's count, depending on the entity
     */
    private ItemStack getDrops(Entity entity) {
        String entityName = entity.getClass().getSimpleName().substring(6); // EntitySheep -> Sheep
        Item itemDropped = entity.isBurning()
                ? ConfigItems.getCookedItem(entityName)
                : ConfigItems.getRawItem(entityName);
        return new ItemStack(itemDropped, totalDrops);
    }

    /**
     * Calculate the number of items dropped by the mob killed.
     */
    private void genTotalDrops(LivingDropsEvent event) {
        this.totalDrops = event.entityLiving.isChild()
                ? 0 : random.nextInt(2) + 1 + (event.lootingLevel > 0 ? random.nextInt(event.lootingLevel) + 1 : 0);
    }
}
