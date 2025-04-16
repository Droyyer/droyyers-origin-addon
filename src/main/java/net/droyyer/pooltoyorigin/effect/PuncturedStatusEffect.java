package net.droyyer.pooltoyorigin.effect;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.player.PlayerEntity;

public class PuncturedStatusEffect extends StatusEffect {
    public PuncturedStatusEffect() {
        super(
                StatusEffectCategory.HARMFUL,
                0xC3C2CC);
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {

        return true;
    }

    @Override
    public void applyUpdateEffect(LivingEntity entity, int amplifier) {
        if (entity instanceof PlayerEntity) {
            if (entity.hasStatusEffect(ModEffects.SEALED.value())) { return; }
            if (entity.age % Math.round( -41 * Math.pow(amplifier+1, 0.5) + 140 ) == 0) {
                entity.damage(entity.getDamageSources().magic(), 1);
            }
        }
    }
}
