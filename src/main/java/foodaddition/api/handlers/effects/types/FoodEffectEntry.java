package foodaddition.api.handlers.effects.types;

import java.util.List;

public class FoodEffectEntry {
    public String item;
    public int meta;
    public List<EffectEntry> effects;

    @Override
    public String toString() {
        return getClass().getSimpleName()
                .concat(" : ").concat(item)
                .concat(" - ").concat(String.valueOf(meta))
                .concat(" - ").concat(effects.toString());
    }
}