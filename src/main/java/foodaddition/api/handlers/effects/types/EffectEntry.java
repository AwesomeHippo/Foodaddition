package foodaddition.api.handlers.effects.types;

public class EffectEntry {
    public int id;
    public int duration;
    public int amplifier;

    @Override
    public String toString() {
        return getClass().getSimpleName()
                .concat(" : ").concat(String.valueOf(id))
                .concat(" - ").concat(String.valueOf(duration))
                .concat("s - lvl.").concat(String.valueOf(amplifier));
    }
}
