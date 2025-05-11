package foodaddition.api.config;

import foodaddition.api.items.FoodAdditionItem;
import foodaddition.model.items.*;
import net.minecraft.item.Item;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class ConfigItems {

    private static final ArrayList<FoodAdditionItem> instances = new ArrayList<>(4);
    private static final HashMap<String, Item> rawItems, cookedItems;
    public static final ArrayList<String> entitiesThatDrop;

    static {
        registerFoodAdditionItem(new Horse(), new Sheep(), new Squid(), new Wolf());
        int length = instances.size();
        rawItems = new HashMap<>(length);
        cookedItems = new HashMap<>(length);
        entitiesThatDrop = new ArrayList<>(length);
    }

    public static void init() {

        // For instance : store entity name as key + Item as value
        clearCollections();
        for (FoodAdditionItem instance : instances) {
                entitiesThatDrop.add(instance.getEntityName());
            if (instance.isItemEnabled()) {
                rawItems.put(instance.getEntityName(), instance.getItemRaw());
                cookedItems.put(instance.getEntityName(), instance.getItemCooked());
            }
        }
    }

    private static void clearCollections() {
        rawItems.clear();
        cookedItems.clear();
        entitiesThatDrop.clear();
    }

    /**
     * Method used to register new Food Addition Item classes.
     * Don't forget to launch init() once you're done registering.
     */
    public static void registerFoodAdditionItem(FoodAdditionItem ... instances) {
        ConfigItems.instances.addAll(Arrays.asList(instances));
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
