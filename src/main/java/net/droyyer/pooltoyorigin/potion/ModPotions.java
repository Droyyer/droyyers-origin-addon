package net.droyyer.pooltoyorigin.potion;

import net.droyyer.pooltoyorigin.PooltoyOrigin;
import net.droyyer.pooltoyorigin.effect.ModEffects;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.potion.Potion;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;

public class ModPotions {
    public static final RegistryEntry<Potion> POLYMER_POTION = registerPotion("polymer_potion",
            new Potion(new StatusEffectInstance(ModEffects.POLYMER.value(), 72000, 0)));


    private static RegistryEntry<Potion> registerPotion(String name, Potion potion) {
        return Registry.registerReference(Registries.POTION, new Identifier(PooltoyOrigin.MOD_ID, name), potion);
    }

    public static void registerPotions() {
        PooltoyOrigin.LOGGER.info("Registering potions for " + PooltoyOrigin.MOD_ID);
    }

}
