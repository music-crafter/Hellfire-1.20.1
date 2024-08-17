package com.musiccrafter.hellfire_api.datagen;

import com.musiccrafter.hellfire_api.HellfireAPI;
import com.musiccrafter.hellfire_api.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, HellfireAPI.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {

        // Metals
        // Chthonium
        blockWithItem(ModBlocks.CHTHONIUM_BLOCK);
        blockWithItem(ModBlocks.RAW_CHTHONIUM_BLOCK);
        blockWithItem(ModBlocks.CHTHONIUM_ORE);

        // Woods
        // Pomegranate
        logBlock(((RotatedPillarBlock) ModBlocks.POMEGRANATE_LOG.get()));
        axisBlock(((RotatedPillarBlock) ModBlocks.POMEGRANATE_WOOD.get()), blockTexture(ModBlocks.POMEGRANATE_LOG.get()),
                blockTexture(ModBlocks.POMEGRANATE_LOG.get()));
        axisBlock(((RotatedPillarBlock) ModBlocks.STRIPPED_POMEGRANATE_LOG.get()), blockTexture(ModBlocks.STRIPPED_POMEGRANATE_LOG.get()),
                new ResourceLocation(HellfireAPI.MOD_ID, "block/stripped_pomegranate_log_top"));
        axisBlock(((RotatedPillarBlock) ModBlocks.STRIPPED_POMEGRANATE_WOOD.get()), blockTexture(ModBlocks.STRIPPED_POMEGRANATE_LOG.get()),
                blockTexture(ModBlocks.STRIPPED_POMEGRANATE_LOG.get()));

        blockItem(ModBlocks.POMEGRANATE_LOG);
        blockItem(ModBlocks.POMEGRANATE_WOOD);
        blockItem(ModBlocks.STRIPPED_POMEGRANATE_LOG);
        blockItem(ModBlocks.STRIPPED_POMEGRANATE_WOOD);

        blockWithItem(ModBlocks.POMEGRANATE_PLANKS);

        leavesBlock(ModBlocks.POMEGRANATE_LEAVES);

    }

    private void leavesBlock(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(),
                models().singleTexture(ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath(),
                        new ResourceLocation("minecraft:block/leaves"),
                        "all", blockTexture(blockRegistryObject.get())).renderType("cutout"));
    }

    private void blockItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), new ModelFile.UncheckedModelFile(HellfireAPI.MOD_ID +
                ":block/" + ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath()));
    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }

}
