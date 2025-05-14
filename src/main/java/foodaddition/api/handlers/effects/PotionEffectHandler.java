package foodaddition.api.handlers.effects;

import com.google.gson.reflect.TypeToken;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import foodaddition.FoodAddition;
import foodaddition.api.handlers.effects.types.EffectEntry;
import foodaddition.api.handlers.effects.types.FoodEffectEntry;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.potion.PotionEffect;
import net.minecraftforge.event.entity.player.PlayerUseItemEvent;

import com.google.gson.Gson;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.*;

import static foodaddition.FoodAddition.log;

public class PotionEffectHandler {

    private static final Map<String, List<PotionEffect>> effectMap = new HashMap<>(20);
    private static final Gson gson = new Gson();
    private static final Type listType = new TypeToken<ArrayList<FoodEffectEntry>>() {}.getType();
    public static final File effectJson = new File(FoodAddition.configDir, "potion_effects.json");

    public PotionEffectHandler() {
        doJsonExists();
        loadConfig();
    }

    @SubscribeEvent
    public void onFoodEaten(PlayerUseItemEvent.Finish event) {
        if (!(event.item.getItem() instanceof ItemFood)) return;
        String registryName = Item.itemRegistry.getNameForObject(event.item.getItem());
        String key = registryName.concat("@").concat(String.valueOf(event.item.getItemDamage())); // mod:item_name @ metadata
        List<PotionEffect> effects = effectMap.get(key);
        if (effects != null)
            for (PotionEffect effect : effects)
                event.entityPlayer.addPotionEffect(new PotionEffect(effect));
    }

    private void loadConfig() {
        try {
            FileReader reader = new FileReader(effectJson);
            List<FoodEffectEntry> entries = gson.fromJson(reader, listType);
            for (FoodEffectEntry entry : entries) {
                String key = entry.item.concat("@").concat(String.valueOf(entry.meta));
                List<PotionEffect> potionEffects = new ArrayList<>();
                for (EffectEntry effect : entry.effects)
                    potionEffects.add(new PotionEffect(effect.id, effect.duration * 20, effect.amplifier));
                effectMap.put(key, potionEffects);
            }
        } catch (Exception e) {
            System.err.println(FoodAddition.modID.concat(" - Failed to load potion effects config : ".concat(e.getMessage())));
        }
    }

    public void reload() {
        effectMap.clear();
        this.loadConfig();
    }

    public void doJsonExists() {
        if (!effectJson.exists()) {
            // default config for apple -> regen II for 20 seconds lol
            String defaultJson = "[\n".concat(
                    "  {\n").concat(
                    "    \"item\": \"minecraft:apple\",\n").concat(
                    "    \"meta\": 0,\n").concat(
                    "    \"effects\": [\n").concat(
                    "      { \"id\": 10, \"duration\": 20, \"amplifier\": 1 }\n").concat(
                    "    ]\n").concat(
                    "  }\n").concat(
                    "]" );
            try {
                Files.write(effectJson.toPath(), defaultJson.getBytes(StandardCharsets.UTF_8));
                log("[Food Addition] created default potion_effects.json at: " + effectJson.getAbsolutePath());
            } catch (IOException e) {
                System.err.println(e.getMessage());
            }
        }
    }
}
