package net.droyyer.pooltoyorigin.item;

import net.droyyer.pooltoyorigin.PooltoyOrigin;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;

public class ModItems {
    public static final Item SPRUCE_RESIN = registerItem("spruce_resin", new Item(new FabricItemSettings()));
    public static final Item RUBBER = registerItem("rubber", new Item(new FabricItemSettings()));
    public static final Item CRUSHED_NETHER_STAR = registerItem("crushed_nether_star", new Item(new FabricItemSettings()));
    public static final Item CONSCIOUS_EYE = registerItem("conscious_eye", new Item(new FabricItemSettings()
            .rarity(Rarity.RARE)));
    public static final Item VINYL_POLYMER = registerItem("vinyl_polymer", new Item(new FabricItemSettings()));
    public static final Item CONVERGENCE = registerItem("convergence", new Item(new FabricItemSettings()
            .rarity(Rarity.EPIC)));

    public static final Item RUBBER_PATCH = registerItem("rubber_patch", new Item(new FabricItemSettings()));
    public static final Item DUCTTAPE = registerItem("ducttape", new Item(new FabricItemSettings()
            .maxDamage(3)
    ));
    public static final Item AIR_PUMP = registerItem("air_pump", new Item(new FabricItemSettings()));

    public static final Item DEFLATED_PLAYER = registerItem("deflated_player", new Item(new FabricItemSettings()));


    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(PooltoyOrigin.MOD_ID, name), item);
    }

    public static void registerItems() {
        PooltoyOrigin.LOGGER.info("Registering items for " + PooltoyOrigin.MOD_ID);
    }

}
