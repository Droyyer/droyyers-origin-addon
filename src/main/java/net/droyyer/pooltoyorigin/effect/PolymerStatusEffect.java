package net.droyyer.pooltoyorigin.effect;

import io.github.apace100.origins.component.OriginComponent;
import io.github.apace100.origins.origin.OriginLayers;
import io.github.apace100.origins.origin.OriginRegistry;
import io.github.apace100.origins.registry.ModComponents;
import net.droyyer.pooltoyorigin.util.PowerRegistry;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.Identifier;

public class PolymerStatusEffect extends StatusEffect {
    public PolymerStatusEffect() {
        super(
                StatusEffectCategory.NEUTRAL,
                0xAF8CCF);
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {

        return true;
    }

    @Override
    public void applyUpdateEffect(LivingEntity entity, int amplifier) {
        if (entity instanceof PlayerEntity) {
           OriginComponent originComponent = ModComponents.ORIGIN.get(entity);
           boolean isPooltoy = originComponent.getOrigin(OriginLayers.getLayer(new Identifier("origins:origin"))).equals(OriginRegistry.get(new Identifier("pooltoy-origin:pooltoy")));
           boolean isPactee = originComponent.getOrigin(OriginLayers.getLayer(new Identifier("ensculked:pact"))).equals(OriginRegistry.get(new Identifier("ensculked:pact")));
           boolean isSerperior = originComponent.getOrigin(OriginLayers.getLayer(new Identifier("origins:origin"))).equals(OriginRegistry.get(new Identifier("origins:phantom")));
           if ((isPooltoy || isPactee) && !isSerperior) {
               // Clear effect if the target is a pooltoy
               entity.removeStatusEffect(ModEffects.POLYMER.value());
           } else if (!PowerRegistry.POLYMER_POWER.isActive(entity)) {
               if (entity.getWorld().isClient()) { return; }
               MinecraftServer server = entity.getServer();
               server.getCommandManager().executeWithPrefix(server.getCommandSource().withSilent(), "power grant %s pooltoy-origin:polymer".formatted(entity.getUuid()));
           }
        }
    }
}
