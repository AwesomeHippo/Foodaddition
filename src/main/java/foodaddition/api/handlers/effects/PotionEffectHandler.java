package foodaddition.api.handlers.effects;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import foodaddition.FoodAddition;
import foodaddition.api.handlers.effects.types.EffectEntry;
import foodaddition.api.handlers.effects.types.FoodEffectEntry;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraftforge.event.entity.player.PlayerUseItemEvent;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.File;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class PotionEffectHandler {

    // hashmap
    private static final Map<String, List<PotionEffect>> effectMap = new HashMap<>();
    private static final Gson gson = new Gson();
    public static final File effectJson = new File(FoodAddition.configDir, "potion_effects.json");

    public PotionEffectHandler() {
        loadConfig();
    }

    @SubscribeEvent
    public void onFoodEaten(PlayerUseItemEvent.Finish event) {
        if (!(event.item.getItem() instanceof ItemFood)) return;

        ItemStack eatenStack = event.item;
        String registryName = Item.itemRegistry.getNameForObject(eatenStack.getItem());
        int meta = eatenStack.getItemDamage();
        String key = registryName.concat("@").concat(String.valueOf(meta));

        List<PotionEffect> effects = effectMap.get(key);
        if (effects != null)
            addPotionEffectToPlayer(event.entityPlayer, effects);
    }

    private void loadConfig() {
        try {
            if (!effectJson.exists()) {
                // default config for apple -> regen II for 20 seconds lol
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
                java.nio.file.Files.write(effectJson.toPath(), defaultJson.getBytes(StandardCharsets.UTF_8));
                System.out.println("[Food Addition] created default potion_effects.json at: " + effectJson.getAbsolutePath());
            }

            // ToDo - Optimize
            Type listType = new TypeToken<ArrayList<FoodEffectEntry>>() {}.getType();
            try (FileReader reader = new FileReader(effectJson)) {
                List<FoodEffectEntry> entries = gson.fromJson(reader, listType);
                if (entries != null) {
                    for (FoodEffectEntry entry : entries) {
                        String key = entry.item.concat("@").concat(String.valueOf(entry.meta));
                        List<PotionEffect> potionEffects = new ArrayList<>();
                        for (EffectEntry effect : entry.effects)
                            potionEffects.add(new PotionEffect(effect.id, effect.duration * 20, effect.amplifier));
                        effectMap.put(key, potionEffects);
                    }
                }
            }
        } catch (Exception e) {
            System.err.println(FoodAddition.modID.concat(" - Failed to load potion effects config : " + e.getMessage()));
        }
    }

    public void reload() {
        effectMap.clear();
        this.loadConfig();
    }

    public void addPotionEffectToPlayer(EntityPlayer player, List<PotionEffect> effects) {
        effects.forEach(player::addPotionEffect);
    }
}
