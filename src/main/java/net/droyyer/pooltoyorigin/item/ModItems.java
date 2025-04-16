package net.droyyer.pooltoyorigin.item;

import net.droyyer.pooltoyorigin.PooltoyOrigin;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item SPRUCE_RESIN = registerItem("spruce_resin", new Item(new FabricItemSettings()));
    public static final Item RUBBER = registerItem("rubber", new Item(new FabricItemSettings()));

    public static final Item RUBBER_PATCH = registerItem("rubber_patch", new Item(new FabricItemSettings()));
    public static final Item DUCTTAPE = registerItem("ducttape", new Item(new FabricItemSettings()
            .maxDamage(3)
    ));


    private static void addItemsToIngredientItemGroup(FabricItemGroupEntries entries) {
        entries.add(SPRUCE_RESIN);
        entries.add(RUBBER);
    }
    private static void addItemsToUtilityItemGroup(FabricItemGroupEntries entries) {
        entries.add(RUBBER_PATCH);
        entries.add(DUCTTAPE);
    }

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(PooltoyOrigin.MOD_ID, name), item);
    }

    public static void registerItems() {
        PooltoyOrigin.LOGGER.info("Registering items for " + PooltoyOrigin.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::addItemsToIngredientItemGroup);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(ModItems::addItemsToUtilityItemGroup);
    }

}
