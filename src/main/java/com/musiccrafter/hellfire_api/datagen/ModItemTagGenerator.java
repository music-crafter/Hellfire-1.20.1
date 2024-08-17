package com.musiccrafter.hellfire_api.datagen;

import com.musiccrafter.hellfire_api.HellfireAPI;
import com.musiccrafter.hellfire_api.block.ModBlocks;
import com.musiccrafter.hellfire_api.item.ModItems;
import com.musiccrafter.hellfire_api.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModItemTagGenerator extends ItemTagsProvider {
    public ModItemTagGenerator(PackOutput pOutput, CompletableFuture<HolderLookup.Provider> pLookupProvider, CompletableFuture<TagLookup<Block>> pBlockTags, @Nullable ExistingFileHelper existingFileHelper) {
        super(pOutput, pLookupProvider, pBlockTags, HellfireAPI.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {

        // Metals
        // Ingots
        this.tag(ModTags.Items.INGOTS_CHTHONIUM)
                .add(ModItems.CHTHONIUM_INGOT.get());

        // Woods
        this.tag(ItemTags.LOGS_THAT_BURN)
                .add(ModBlocks.POMEGRANATE_LOG.get().asItem())
                .add(ModBlocks.POMEGRANATE_WOOD.get().asItem())
                .add(ModBlocks.STRIPPED_POMEGRANATE_LOG.get().asItem())
                .add(ModBlocks.STRIPPED_POMEGRANATE_WOOD.get().asItem());
        this.tag(ItemTags.PLANKS)
                .add(ModBlocks.POMEGRANATE_PLANKS.get().asItem());

    }
}
