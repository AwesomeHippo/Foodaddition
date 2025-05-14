package foodaddition.api.handlers.effects.types;

@SuppressWarnings("unused")
public class EffectEntry {
    private int id;
    private int duration;
    private int amplifier;

    public int getId() {
        return id;
    }
    public int getDuration() {
        return duration * 20;
    }
    public int getAmplifier() {
        return amplifier - 1;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName()
                .concat(" : ").concat(String.valueOf(id))
                .concat(" - ").concat(String.valueOf(duration))
                .concat("s - lvl.").concat(String.valueOf(amplifier));
    }
}
