package net.droyyer.pooltoyorigin;

import net.droyyer.pooltoyorigin.fluid.ModFluids;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.render.fluid.v1.FluidRenderHandlerRegistry;
import net.fabricmc.fabric.api.client.render.fluid.v1.SimpleFluidRenderHandler;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.util.Identifier;

public class PooltoyOriginClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		// This entrypoint is suitable for setting up client-specific logic, such as rendering.

		FluidRenderHandlerRegistry.INSTANCE.register(ModFluids.STILL_LIQUID_MAGIC, ModFluids.FLOWING_LIQUID_MAGIC,
			new SimpleFluidRenderHandler(
					new Identifier("minecraft:block/lava_still"),
					new Identifier("minecraft:block/lava_flow"),
					0x00E052
		));
		BlockRenderLayerMap.INSTANCE.putFluids(RenderLayer.getTranslucent(),
				ModFluids.STILL_LIQUID_MAGIC, ModFluids.FLOWING_LIQUID_MAGIC);
	}
}