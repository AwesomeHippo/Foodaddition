package foodaddition.config;

import foodaddition.api.FoodAdditionItem;
import foodaddition.model.items.*;
import net.minecraft.item.Item;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class ConfigItems {

    private static final HashMap<String, Item> rawItems = new HashMap<>(4), cookedItems = new HashMap<>(4);
    private static final ArrayList<Class<? extends FoodAdditionItem>> classes = new ArrayList<>(4);
    public static final ArrayList<String> entities = new ArrayList<>(4);

    public static void init() throws InstantiationException, IllegalAccessException {
        registerClass(Sheep.class, Horse.class, Squid.class, Wolf.class);
        // For each class : make a new instance, then store entity name as key + Item as value
        for (Class<?> clazz : classes) {
            entities.add(clazz.getSimpleName());
            FoodAdditionItem i = (FoodAdditionItem) clazz.newInstance();
            rawItems.put(i.getEntityName(), i.getItemRaw());
            cookedItems.put(i.getEntityName(), i.getItemCooked());
        }
    }

    /**
     * Method used to register new Food Addition Item classes.
     */
    @SafeVarargs
    public static void registerClass(Class<? extends FoodAdditionItem> ... classes) {
        ConfigItems.classes.addAll(Arrays.asList(classes));
    }

    /**
     * Returns the Raw food item for the given entity if it exists, else null.
     */
    public static Item getRawItem(String entityName) {
        return rawItems.get(entityName);
    }
    /**
     * Returns the Cooked food item for the given entity if it exists, else null.
     */
    public static Item getCookedItem(String entityName) {
        return cookedItems.get(entityName);
    }
}
