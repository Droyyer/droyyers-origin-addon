package net.droyyer.pooltoyorigin.block;

import net.droyyer.pooltoyorigin.PooltoyOrigin;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;
import net.minecraft.world.WorldView;

public class ModBlocks {
    public static final Block HIGHLIGHTED_SCULK = registerBlock("highlighted_sculk",
            new Block(FabricBlockSettings.copyOf(Blocks.SCULK)
                    .mapColor(MapColor.RED)
                    .emissiveLighting(ModBlocks::always)
                    .luminance(value -> 5)));


    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(PooltoyOrigin.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block) {
        return Registry.register(Registries.ITEM, new Identifier(PooltoyOrigin.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings()));
    }

    public static void registerBlocks() {
        PooltoyOrigin.LOGGER.info("Registering blocks for " + PooltoyOrigin.MOD_ID);
    }

    private static boolean always(BlockState state, BlockView world, BlockPos pos) {
        return true;
    }
}
