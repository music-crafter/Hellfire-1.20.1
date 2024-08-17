package com.musiccrafter.hellfire_api.datagen;

import com.musiccrafter.hellfire_api.HellfireAPI;
import com.musiccrafter.hellfire_api.block.ModBlocks;
import com.musiccrafter.hellfire_api.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.Tags;
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
        // Tool tiers
        this.tag(BlockTags.NEEDS_STONE_TOOL)
                .add(ModBlocks.CHTHONIUM_ORE.get(),
                        ModBlocks.CHTHONIUM_BLOCK.get(),
                        ModBlocks.RAW_CHTHONIUM_BLOCK.get()
                );
        this.tag(BlockTags.NEEDS_IRON_TOOL);
        this.tag(BlockTags.NEEDS_DIAMOND_TOOL);
        this.tag(Tags.Blocks.NEEDS_NETHERITE_TOOL);
        // Tool types
        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.CHTHONIUM_ORE.get(),
                        ModBlocks.CHTHONIUM_BLOCK.get(),
                        ModBlocks.RAW_CHTHONIUM_BLOCK.get()
                );
        this.tag(BlockTags.MINEABLE_WITH_AXE);
        this.tag(BlockTags.MINEABLE_WITH_SHOVEL);
        this.tag(BlockTags.MINEABLE_WITH_HOE);

        // Ores
        this.tag(ModTags.Blocks.NETHER_ORES)
                .add(ModBlocks.CHTHONIUM_ORE.get());

        // Woods
        // Pomegranate
        this.tag(BlockTags.LOGS_THAT_BURN)
                .add(ModBlocks.POMEGRANATE_LOG.get())
                .add(ModBlocks.POMEGRANATE_WOOD.get())
                .add(ModBlocks.STRIPPED_POMEGRANATE_LOG.get())
                .add(ModBlocks.STRIPPED_POMEGRANATE_WOOD.get());
        this.tag(BlockTags.PLANKS)
                .add(ModBlocks.POMEGRANATE_PLANKS.get());
    }

}
