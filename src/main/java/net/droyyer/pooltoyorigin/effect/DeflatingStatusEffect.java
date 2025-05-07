package net.droyyer.pooltoyorigin.effect;

import net.droyyer.pooltoyorigin.PooltoyOrigin;
import net.droyyer.pooltoyorigin.item.ModItems;
import net.droyyer.pooltoyorigin.util.ModDamageTypes;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.player.PlayerEntity;

public class DeflatingStatusEffect extends StatusEffect {
    public DeflatingStatusEffect() {
        super(
                StatusEffectCategory.NEUTRAL,
                0xC3C2CC);
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {

        return true;
    }

    @Override
    public void applyUpdateEffect(LivingEntity entity, int amplifier) {
        if (entity instanceof PlayerEntity) {
            if (entity.age % 25 == 0 && !(entity.getMainHandStack().getItem() == ModItems.AIR_PUMP)) {
                entity.damage(ModDamageTypes.of(entity.getWorld(), ModDamageTypes.AIR_LOSS), 1.0f);
            }
        }
    }
}
