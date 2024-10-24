package com.musiccrafter.hellfire_api.datagen;

import com.musiccrafter.hellfire_api.HellfireAPI;
import com.musiccrafter.hellfire_api.block.ModBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagGenerator extends BlockTagsProvider {

    public ModBlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, HellfireAPI.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        // example
        // this.tag(ModTags.Blocks.BLOCK_TAG)
        // .add(ModBlocks.EXAMPLE_BLOCK.get()).addTag(Tags.Blocks.ORES);

        this.tag(BlockTags.NEEDS_STONE_TOOL)
                .add(ModBlocks.CHTHONIUM_BLOCK.get(),
                        ModBlocks.RAW_CHTHONIUM_BLOCK.get(),
                        ModBlocks.CHTHONIUM_ORE.get()
                );

        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.CHTHONIUM_BLOCK.get(),
                        ModBlocks.RAW_CHTHONIUM_BLOCK.get(),
                        ModBlocks.CHTHONIUM_ORE.get()
                );
    }
}
