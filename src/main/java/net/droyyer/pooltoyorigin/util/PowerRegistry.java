package net.droyyer.pooltoyorigin.util;

import io.github.apace100.apoli.power.PowerType;
import io.github.apace100.apoli.power.PowerTypeReference;
import net.minecraft.util.Identifier;

public class PowerRegistry {
    public static final PowerType<?> POLYMER_POWER = new PowerTypeReference<>
            (new Identifier("pooltoy-origin:polymer"));
}
