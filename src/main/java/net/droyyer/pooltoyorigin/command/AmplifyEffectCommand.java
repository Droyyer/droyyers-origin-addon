package net.droyyer.pooltoyorigin.command;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.IntegerArgumentType;
import net.minecraft.command.CommandRegistryAccess;
import net.minecraft.command.argument.EntityArgumentType;
import net.minecraft.command.argument.RegistryEntryArgumentType;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;

import java.util.Collection;

public class AmplifyEffectCommand {
    public static void register(CommandDispatcher<ServerCommandSource> dispatcher, CommandRegistryAccess registryAccess, CommandManager.RegistrationEnvironment dedicated) {
        dispatcher.register(CommandManager.literal("amplifyeffect")
                .requires(source -> source.hasPermissionLevel(2))
                .then(
                        CommandManager.argument("targets", EntityArgumentType.entities())
                                .then(
                                        CommandManager.argument("effect", RegistryEntryArgumentType.registryEntry(registryAccess, RegistryKeys.STATUS_EFFECT))
                                                .then(
                                                        CommandManager.argument("amplifier", IntegerArgumentType.integer(0, 255))
                                                                .executes(
                                                                        context -> executeAmplify(
                                                                                context.getSource(),
                                                                                EntityArgumentType.getEntities(context, "targets"),
                                                                                RegistryEntryArgumentType.getStatusEffect(context, "effect"),
                                                                                IntegerArgumentType.getInteger(context, "amplifier"),
                                                                                255,
                                                                                1
                                                                        )
                                                                )
                                                                .then(
                                                                        CommandManager.argument("amplifier_limit", IntegerArgumentType.integer(0, 255))
                                                                                .executes(
                                                                                        context -> executeAmplify(
                                                                                                context.getSource(),
                                                                                                EntityArgumentType.getEntities(context, "targets"),
                                                                                                RegistryEntryArgumentType.getStatusEffect(context, "effect"),
                                                                                                IntegerArgumentType.getInteger(context, "amplifier"),
                                                                                                IntegerArgumentType.getInteger(context, "amplifier_limit"),
                                                                                                1
                                                                                        )
                                                                                )
                                                                                .then(
                                                                                        CommandManager.argument("modifier", IntegerArgumentType.integer(-1, 1))
                                                                                                .executes(
                                                                                                        context -> executeAmplify(
                                                                                                                context.getSource(),
                                                                                                                EntityArgumentType.getEntities(context, "targets"),
                                                                                                                RegistryEntryArgumentType.getStatusEffect(context, "effect"),
                                                                                                                IntegerArgumentType.getInteger(context, "amplifier"),
                                                                                                                IntegerArgumentType.getInteger(context, "amplifier_limit"),
                                                                                                                IntegerArgumentType.getInteger(context, "modifier")
                                                                                                        )
                                                                                                )
                                                                                )
                                                                )
                                                )
                                )

                )
        );
    }

    private static int executeAmplify(
            ServerCommandSource source,
            Collection<? extends Entity> targets,
            RegistryEntry<StatusEffect> statusEffect,
            int amplifier,
            int amplifier_limit,
            int modifier
    ) {
        StatusEffect statusEffect2 = statusEffect.value();
        int i = 0;

        for (Entity entity : targets) {
            if (entity instanceof LivingEntity) {
                int armor = ((LivingEntity) entity).getArmor();
                if (modifier > 0 && armor > 0) {
                    if ( (int)(Math.random() * ((float)armor/6+1)) != 0 ) { return 0; }
                }
                StatusEffectInstance currentStatusEffect = ((LivingEntity) entity).getStatusEffect(statusEffect2);
                if (currentStatusEffect != null) {
                    int newAmplifier = currentStatusEffect.getAmplifier() + (amplifier * modifier);
                    if (newAmplifier > amplifier_limit) {
                        newAmplifier = amplifier_limit;
                    } else if (newAmplifier < 0) {
                        ((LivingEntity) entity).removeStatusEffect(statusEffect2);
                        return i;
                    }

                    StatusEffectInstance statusEffectInstance = new StatusEffectInstance(
                            statusEffect2,
                            currentStatusEffect.getDuration(),
                            newAmplifier,
                            currentStatusEffect.isAmbient(),
                            currentStatusEffect.shouldShowParticles(),
                            currentStatusEffect.shouldShowIcon()
                    );
                    if (modifier < 0) {
                        ((LivingEntity) entity).removeStatusEffect(statusEffect2);
                    }
                    ((LivingEntity) entity).addStatusEffect(statusEffectInstance, source.getEntity());
                } else {
                    if (modifier < 0) { return i; }
                    StatusEffectInstance statusEffectInstance = new StatusEffectInstance(
                            statusEffect2,
                            -1,
                            amplifier - 1,
                            true,
                            false,
                            true
                    );
                    ((LivingEntity) entity).addStatusEffect(statusEffectInstance, source.getEntity());
                }
            }
        }
        return i;
    }
}
