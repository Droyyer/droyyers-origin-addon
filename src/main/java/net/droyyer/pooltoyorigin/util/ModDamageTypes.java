package net.droyyer.pooltoyorigin.util;

import net.droyyer.pooltoyorigin.PooltoyOrigin;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.damage.DamageType;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;

public class ModDamageTypes {

    public static final RegistryKey<DamageType> AIR_LOSS =
            RegistryKey.of(RegistryKeys.DAMAGE_TYPE, new Identifier(PooltoyOrigin.MOD_ID, "air_loss"));
    public static final RegistryKey<DamageType> FULL_AIR_LOSS =
            RegistryKey.of(RegistryKeys.DAMAGE_TYPE, new Identifier(PooltoyOrigin.MOD_ID, "full_air_loss"));

    public static DamageSource of(World world, RegistryKey<DamageType> key) {
        return new DamageSource(world.getRegistryManager().get(RegistryKeys.DAMAGE_TYPE).entryOf(key));
    }
}
