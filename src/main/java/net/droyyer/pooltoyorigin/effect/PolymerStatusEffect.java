package net.droyyer.pooltoyorigin.effect;

import io.github.apace100.apoli.component.PowerHolderComponent;
import io.github.apace100.apoli.component.PowerHolderComponentImpl;
import io.github.apace100.apoli.power.Power;
import io.github.apace100.apoli.power.PowerType;
import io.github.apace100.origins.Origins;
import io.github.apace100.origins.component.OriginComponent;
import io.github.apace100.origins.component.PlayerOriginComponent;
import io.github.apace100.origins.origin.Origin;
import io.github.apace100.origins.origin.OriginLayer;
import io.github.apace100.origins.origin.OriginLayers;
import io.github.apace100.origins.origin.OriginRegistry;
import io.github.apace100.origins.registry.ModComponents;
import net.droyyer.pooltoyorigin.PooltoyOrigin;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.Identifier;

public class PolymerStatusEffect extends StatusEffect {
    public PolymerStatusEffect() {
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
           OriginComponent originComponent = ModComponents.ORIGIN.get(entity);

           if (originComponent.getOrigin(OriginLayers.getLayer(new Identifier("origins:origin"))).equals(OriginRegistry.get(new Identifier("pooltoy-origin:pooltoy")))) {
               // Clear effect if the target is a pooltoy
               entity.removeStatusEffect(ModEffects.POLYMER.value());
           }
        }
    }
}
