package com.musiccrafter.hellfire_api.util;

import com.musiccrafter.hellfire_api.HellfireAPI;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class ModTags {

    public static class Blocks {

        // Ores
        public static final TagKey<Block> NETHER_ORES = tag("ores/nether");

        private static TagKey<Block> tag (String name) {
            return BlockTags.create(new ResourceLocation(HellfireAPI.MOD_ID, name));
        }
    }

    public static class Items {

        // Chthonium
        public static final TagKey<Item> INGOTS_CHTHONIUM = tag("ingots/chthonium");

        private static TagKey<Item> tag (String name) {
            return ItemTags.create(new ResourceLocation(HellfireAPI.MOD_ID, name));
        }
    }
}
