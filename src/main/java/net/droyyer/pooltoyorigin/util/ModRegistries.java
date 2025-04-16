package net.droyyer.pooltoyorigin.util;

import net.droyyer.pooltoyorigin.command.AmplifyEffectCommand;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;

public class ModRegistries {
    public static void registerCommands() {
        CommandRegistrationCallback.EVENT.register(AmplifyEffectCommand::register);
    }
}
