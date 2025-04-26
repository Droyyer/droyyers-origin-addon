package net.droyyer.pooltoyorigin.item;

import net.droyyer.pooltoyorigin.PooltoyOrigin;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {
    public static final ItemGroup POOLTOY_ORIGIN = Registry.register(Registries.ITEM_GROUP,
            new Identifier(PooltoyOrigin.MOD_ID, "pooltoy_origin"), FabricItemGroup.builder()
                    .displayName(Text.translatable("itemgroup.pooltoy_origin"))
                    .icon(() -> new ItemStack(ModItems.AIR_PUMP))
                    .entries((displayContext, entries) -> {

                        entries.add(ModItems.AIR_PUMP);
                        entries.add(ModItems.RUBBER_PATCH);
                        entries.add(ModItems.DUCTTAPE);

                        entries.add(ModItems.RUBBER);
                        entries.add(ModItems.SPRUCE_RESIN);

                    }).build());

    public static void registerItemGroups() {
        PooltoyOrigin.LOGGER.info("Registering item groups for " + PooltoyOrigin.MOD_ID);
    }
}
