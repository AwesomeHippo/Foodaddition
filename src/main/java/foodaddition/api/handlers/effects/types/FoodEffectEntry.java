package foodaddition.api.handlers.effects.types;

import java.util.Iterator;
import java.util.List;

@SuppressWarnings({"unused", "MismatchedQueryAndUpdateOfCollection"})
public class FoodEffectEntry implements Iterable<EffectEntry> {
    private String item;
    private int meta;
    private List<EffectEntry> effects;

    public String getItem() {
        return item;
    }
    public int getMeta() {
        return meta;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName()
                .concat(" : ").concat(item)
                .concat(" - ").concat(String.valueOf(meta))
                .concat(" - ").concat(effects.toString());
    }

    @Override @SuppressWarnings("NullableProblems")
    public Iterator<EffectEntry> iterator() {
        return effects.iterator();
    }
}