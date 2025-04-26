package net.droyyer.pooltoyorigin.fluid;

import net.droyyer.pooltoyorigin.PooltoyOrigin;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.FluidBlock;
import net.minecraft.fluid.FlowableFluid;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModFluids {
    public static FlowableFluid STILL_LIQUID_MAGIC;
    public static FlowableFluid FLOWING_LIQUID_MAGIC;
    public static Block LIQUID_MAGIC_BLOCK;

    public static void registerFluids() {
        STILL_LIQUID_MAGIC = Registry.register(Registries.FLUID,
                new Identifier(PooltoyOrigin.MOD_ID, "liquid_magic"), new LiquidMagicFluid.Still());
        FLOWING_LIQUID_MAGIC = Registry.register(Registries.FLUID,
                new Identifier(PooltoyOrigin.MOD_ID, "flowing_liquid_magic"), new LiquidMagicFluid.Flowing());
        LIQUID_MAGIC_BLOCK = Registry.register(Registries.BLOCK, new Identifier(PooltoyOrigin.MOD_ID, "liquid_magic_block"),
                new FluidBlock(ModFluids.STILL_LIQUID_MAGIC, FabricBlockSettings.copyOf(Blocks.WATER)){});
    }

}
