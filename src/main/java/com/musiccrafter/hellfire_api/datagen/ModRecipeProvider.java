package com.musiccrafter.hellfire_api.datagen;

import com.musiccrafter.hellfire_api.HellfireAPI;
import com.musiccrafter.hellfire_api.block.ModBlocks;
import com.musiccrafter.hellfire_api.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.util.List;
import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    private static final List<ItemLike> CHTHONIUM_SMELTABLES = List.of(
            ModItems.RAW_CHTHONIUM.get(),
            ModBlocks.CHTHONIUM_ORE.get());
    private static final List<ItemLike> POMEGRANATE_WOODS = List.of(
            ModBlocks.POMEGRANATE_LOG.get().asItem(),
            ModBlocks.POMEGRANATE_WOOD.get().asItem(),
            ModBlocks.STRIPPED_POMEGRANATE_LOG.get().asItem(),
            ModBlocks.STRIPPED_POMEGRANATE_WOOD.get().asItem());

    public ModRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> pWriter) {

        // Ore Smelting
        oreSmelting(pWriter, CHTHONIUM_SMELTABLES, RecipeCategory.MISC, ModItems.CHTHONIUM_INGOT.get(), 0.25f, 200, "chthonium");
        oreBlasting(pWriter, CHTHONIUM_SMELTABLES, RecipeCategory.MISC, ModItems.CHTHONIUM_INGOT.get(), 0.25f, 100, "chthonium");

        // Crafting
        // Chthonium
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.CHTHONIUM_BLOCK.get())
                .pattern("CCC")
                .pattern("CCC")
                .pattern("CCC")
                .define('C', ModItems.CHTHONIUM_INGOT.get())
                .unlockedBy(getHasName(ModItems.CHTHONIUM_INGOT.get()), has(ModItems.CHTHONIUM_INGOT.get()))
                .save(pWriter);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.CHTHONIUM_INGOT.get(), 9)
                .requires(ModBlocks.CHTHONIUM_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.CHTHONIUM_BLOCK.get()), has(ModBlocks.CHTHONIUM_BLOCK.get()))
                .save(pWriter);

        threeByThreePack(RecipeCategory.MISC, ModBlocks.RAW_CHTHONIUM_BLOCK.get(), ModItems.RAW_CHTHONIUM.get());
        threeByThreeUnpack(RecipeCategory.MISC, ModBlocks.RAW_CHTHONIUM_BLOCK.get(), ModItems.RAW_CHTHONIUM.get());

    }

    // Crafting

    protected static void threeByThreeUnpack(RecipeCategory pCategory, ItemLike pPacked, ItemLike pUnpacked) {
        ShapelessRecipeBuilder.shapeless(pCategory, pPacked)
                .requires(pUnpacked, 9).unlockedBy(getHasName(pUnpacked), has(pUnpacked));
    }

    protected static void threeByThreePack(RecipeCategory pCategory, ItemLike pPacked, ItemLike pUnpacked) {
        ShapedRecipeBuilder.shaped(pCategory, pPacked)
                .pattern("UUU")
                .pattern("UUU")
                .pattern("UUU")
                .define('U', pUnpacked)
                .unlockedBy(getHasName(pUnpacked), has(pUnpacked));
    }

    // Ore Smelting

    protected static void oreSmelting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTIme, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.SMELTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTIme, pGroup, "_from_smelting");
    }

    protected static void oreBlasting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.BLASTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    protected static void oreCooking(Consumer<FinishedRecipe> pFinishedRecipeConsumer, RecipeSerializer<? extends AbstractCookingRecipe> pCookingSerializer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pRecipeName) {
        for(ItemLike itemlike : pIngredients) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), pCategory, pResult, pExperience, pCookingTime, pCookingSerializer)
                    .group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(pFinishedRecipeConsumer, HellfireAPI.MOD_ID + ":" + getItemName(pResult) + pRecipeName + "_" + getItemName(itemlike));
        }

    }

}
