package foodaddition.api.handlers;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import foodaddition.api.config.EffectEntry;
import foodaddition.api.config.FoodEffectEntry;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraftforge.event.entity.player.PlayerUseItemEvent;
import net.minecraft.item.ItemFood;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.File;
import java.lang.reflect.Type;
import java.util.*;

public class PotionEffectHandler {

    // hashmap
    private static final Map<String, List<PotionEffect>> effectMap = new HashMap<>();

    public PotionEffectHandler(File configDir) {
        //TODO: we could also put both configs files in a custom dir like HLC
        loadConfig(new File(configDir, "foodaddition_potion_effects.json"));
    }

    @SubscribeEvent
    public void onFoodEaten(PlayerUseItemEvent.Finish event) {
        if (!(event.item.getItem() instanceof ItemFood)) return;

        ItemStack eatenStack = event.item;
        String registryName = Item.itemRegistry.getNameForObject(eatenStack.getItem());
        int meta = eatenStack.getItemDamage();

        String key = registryName.concat("@").concat(String.valueOf(meta));
        List<PotionEffect> effects = effectMap.get(key);
        if (effects != null) {
            addPotionEffectToPlayer(event.entityPlayer, effects);
        }
    }

    private void loadConfig(File file) {
        try {
            if (!file.exists()) {
                file.getParentFile().mkdirs();

                // default config for apple -> regen II for 20 seconds lol - TODO: change?
                // TODO: just initialize it as empty?
                String defaultJson = "[\n".concat(
                        "  {\n").concat(
                        "    \"item\": \"minecraft:apple\",\n").concat(
                        "    \"meta\": 0,\n").concat(
                        "    \"effects\": [\n").concat(
                        "      { \"id\": 10, \"duration\": 20, \"amplifier\": 1 }\n").concat(
                        "    ]\n").concat(
                        "  }\n").concat(
                        "]"
                );
                java.nio.file.Files.write(file.toPath(), defaultJson.getBytes("UTF-8"));

                System.out.println("[Food Addition] created default foodaddition_potion_effects.json at: " + file.getAbsolutePath());
            }

            Gson gson = new Gson();
            Type listType = new TypeToken<ArrayList<FoodEffectEntry>>() {}.getType();
            try (FileReader reader = new FileReader(file)) {
                List<FoodEffectEntry> entries = gson.fromJson(reader, listType);
                if (entries != null) {
                    for (FoodEffectEntry entry : entries) {
                        String key = entry.item.concat("@").concat(String.valueOf(entry.meta));
                        List<PotionEffect> potionEffects = new ArrayList<>();
                        for (EffectEntry effect : entry.effects) {
                            potionEffects.add(new PotionEffect(effect.id, effect.duration * 20, effect.amplifier));
                        }
                        effectMap.put(key, potionEffects);
                    }
                }
            }
        } catch (Exception e) {
            System.err.println("[Food Addition] failed to load potion effects config: " + e.getMessage());
        }
    }

    public void addPotionEffectToPlayer(EntityPlayer player, List<PotionEffect> effects) {
        effects.forEach(player::addPotionEffect);
    }
}
