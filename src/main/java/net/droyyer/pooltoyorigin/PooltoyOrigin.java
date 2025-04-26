package net.droyyer.pooltoyorigin;

import net.droyyer.pooltoyorigin.block.ModBlocks;
import net.droyyer.pooltoyorigin.effect.ModEffects;
import net.droyyer.pooltoyorigin.fluid.ModFluids;
import net.droyyer.pooltoyorigin.item.ModItemGroups;
import net.droyyer.pooltoyorigin.item.ModItems;
import net.droyyer.pooltoyorigin.util.ModRegistries;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PooltoyOrigin implements ModInitializer {
	public static final String MOD_ID = "pooltoy-origin";

	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		LOGGER.info("Loading " + MOD_ID);

		ModItems.registerItems();
		ModItemGroups.registerItemGroups();

		ModBlocks.registerBlocks();
		ModFluids.registerFluids();

		ModEffects.registerEffects();
		ModRegistries.registerCommands();

	}
}