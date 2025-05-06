package foodaddition.api.handlers;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.potion.PotionEffect;
import net.minecraftforge.event.entity.player.PlayerUseItemEvent;

import java.util.ArrayList;

public class PotionEffectHandler {

    @SubscribeEvent
    public void onFoodEaten(PlayerUseItemEvent.Finish event) {
        Item foodEaten = event.entityPlayer.getItemInUse().getItem();
        // ToDo Json config (like HLC) for adding whatever effects you want to food items.
    }

    public void addPotionEffectToPlayer(EntityPlayer player, ArrayList<PotionEffect> effects) {
        effects.forEach(player::addPotionEffect);
    }
}
