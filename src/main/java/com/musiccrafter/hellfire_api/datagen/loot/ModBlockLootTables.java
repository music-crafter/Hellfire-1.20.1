package com.musiccrafter.hellfire_api.datagen.loot;

import com.musiccrafter.hellfire_api.block.ModBlocks;
import com.musiccrafter.hellfire_api.item.ModItems;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider {
    public ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {

        // Metals
        // Chthonium
        this.dropSelf(ModBlocks.CHTHONIUM_BLOCK.get());
        this.dropSelf(ModBlocks.RAW_CHTHONIUM_BLOCK.get());

        // Woods
        // Pomegranate
        this.dropSelf(ModBlocks.POMEGRANATE_LOG.get());
        this.dropSelf(ModBlocks.POMEGRANATE_WOOD.get());
        this.dropSelf(ModBlocks.STRIPPED_POMEGRANATE_LOG.get());
        this.dropSelf(ModBlocks.STRIPPED_POMEGRANATE_WOOD.get());
        this.dropSelf(ModBlocks.POMEGRANATE_PLANKS.get());

        this.add(ModBlocks.POMEGRANATE_LEAVES.get(), block ->
                createLeavesDrops(block, ModBlocks.POMEGRANATE_LEAVES.get(), NORMAL_LEAVES_SAPLING_CHANCES)); // TODO: Change to sapling

        // Ores
        this.add(ModBlocks.CHTHONIUM_ORE.get(),
                block -> createOreDrop(ModBlocks.CHTHONIUM_ORE.get(), ModItems.RAW_CHTHONIUM.get()));

    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
