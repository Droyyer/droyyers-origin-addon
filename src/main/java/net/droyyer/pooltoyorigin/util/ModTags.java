package net.droyyer.pooltoyorigin.util;

import net.droyyer.pooltoyorigin.PooltoyOrigin;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.damage.DamageType;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class ModTags {
    public static class Blocks {
        public static final TagKey<Block> SHARP_BLOCKS =
                createTag("sharp_blocks");
        public static final TagKey<Block> CRITICALLY_SHARP_BLOCKS =
                createTag("critically_sharp_blocks");
        public static final TagKey<Block> OUTDOOR_BLOCKS =
                createTag("outdoor_blocks");
        public static final TagKey<Block> SOFT_BLOCKS =
                createTag("soft_blocks");


        private static TagKey<Block> createTag(String name) {
            return TagKey.of(RegistryKeys.BLOCK, new Identifier(PooltoyOrigin.MOD_ID, name));
        }
    }

    public static class Items {
        public static final TagKey<Item> SHARP_ITEMS =
                createTag("sharp_items");
        public static final TagKey<Item> VERY_SHARP_ITEMS =
                createTag("very_sharp_items");

        private static TagKey<Item> createTag(String name) {
            return TagKey.of(RegistryKeys.ITEM, new Identifier(PooltoyOrigin.MOD_ID, name));
        }
    }

    public static class MobEntities {
        public static TagKey<EntityType<?>> SHARP_ENTITIES =
                createTag("sharp_entities");
        public static TagKey<EntityType<?>> HESITANT =
                createTag("hesitant");


        public static TagKey<EntityType<?>> createTag(String name) {
            return TagKey.of(RegistryKeys.ENTITY_TYPE, new Identifier(PooltoyOrigin.MOD_ID, name));
        }
    }

    public static class DamageTypes {
        public static TagKey<DamageType> CRITICAL_AIR_LOSS =
                createTag("critical_air_loss");

        public static TagKey<DamageType> createTag(String name) {
            return TagKey.of(RegistryKeys.DAMAGE_TYPE, new Identifier(PooltoyOrigin.MOD_ID, name));
        }
    }
}
