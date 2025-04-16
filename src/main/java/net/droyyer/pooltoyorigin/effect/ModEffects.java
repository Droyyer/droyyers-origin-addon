package net.droyyer.pooltoyorigin.effect;

import net.droyyer.pooltoyorigin.PooltoyOrigin;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;

public class ModEffects {
    public static final RegistryEntry<StatusEffect> PUNCTURED = registerStatusEffect("punctured", new PuncturedStatusEffect());
    public static final RegistryEntry<StatusEffect> SEALED = registerStatusEffect("sealed", new SealedStatusEffect());


    private static RegistryEntry<StatusEffect> registerStatusEffect(String name, StatusEffect statusEffect) {
        return Registry.registerReference(Registries.STATUS_EFFECT, Identifier.of(PooltoyOrigin.MOD_ID, name), statusEffect);
    }

    public static void registerEffects() {
        PooltoyOrigin.LOGGER.info("Registering effects for " + PooltoyOrigin.MOD_ID);
    }
}
