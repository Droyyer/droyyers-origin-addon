package net.droyyer.pooltoyorigin.sound;

import net.droyyer.pooltoyorigin.PooltoyOrigin;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

public class ModSounds {
    public static final SoundEvent SOUND_ENTITY_SQUEAKSTEP = registerSoundEvent("sound_entity_squeakstep");

    private static SoundEvent registerSoundEvent(String name) {
        Identifier id = new Identifier(PooltoyOrigin.MOD_ID, name);
        return Registry.register(Registries.SOUND_EVENT, id, SoundEvent.of(id));
    }

    public static void registerSounds() {
        PooltoyOrigin.LOGGER.info("Registering sounds for " + PooltoyOrigin.MOD_ID);
    }

}
