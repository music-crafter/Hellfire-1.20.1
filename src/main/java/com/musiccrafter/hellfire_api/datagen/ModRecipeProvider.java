package com.musiccrafter.hellfire_api.datagen;

import com.musiccrafter.hellfire_api.HellfireAPI;
import com.musiccrafter.hellfire_api.block.ModBlocks;
import com.musiccrafter.hellfire_api.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import javax.annotation.Nullable;
import java.util.List;
import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {

    private static final List<ItemLike> CHTHONIUM_SMELTABLES = List.of(ModItems.RAW_CHTHONIUM.get(), ModBlocks.CHTHONIUM_ORE.get());

    public ModRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> pWriter) {
        oreSmelting(pWriter, CHTHONIUM_SMELTABLES, RecipeCategory.MISC, ModItems.CHTHONIUM_INGOT.get(), 0.25f, 200, "chthonium");
        oreBlasting(pWriter, CHTHONIUM_SMELTABLES, RecipeCategory.MISC, ModItems.CHTHONIUM_INGOT.get(), 0.25f, 100, "chthonium");

        simpleNineBlockStorage(pWriter,
                RecipeCategory.MISC, RecipeCategory.MISC,
                ModBlocks.CHTHONIUM_BLOCK.get(), ModItems.CHTHONIUM_INGOT.get(),
                "chthonium_block", "chthonium_ingot",
                "chthonium", "chthonium");
        simpleNineBlockStorage(pWriter,
                RecipeCategory.MISC, RecipeCategory.MISC,
                ModBlocks.RAW_CHTHONIUM_BLOCK.get(), ModItems.RAW_CHTHONIUM.get(),
                "raw_chthonium_block", "raw_chthonium",
                "chthonium", "chthonium");

    }

    protected static void simpleNineBlockStorage(Consumer<FinishedRecipe> pFinishedRecipeConsumer,
                                                 RecipeCategory pPackedCategory, RecipeCategory pUnpackedCategory,
                                                 ItemLike pPacked, ItemLike pUnpacked,
                                                 String pPackedName, String pUnpackedName,
                                                 @Nullable String pPackedGroup, @Nullable String pUnpackedGroup) {
        ShapedRecipeBuilder.shaped(pPackedCategory, pPacked).define('#', pUnpacked)
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .group(pPackedGroup)
                .unlockedBy(getHasName(pUnpacked), has(pUnpacked))
                .save(pFinishedRecipeConsumer, HellfireAPI.MOD_ID + ":" + pPackedName + "_from_packing_" + pUnpackedName);
        ShapelessRecipeBuilder.shapeless(pUnpackedCategory, pUnpacked, 9)
                .requires(pPacked)
                .group(pUnpackedGroup)
                .unlockedBy(getHasName(pPacked), has(pPacked))
                .save(pFinishedRecipeConsumer, HellfireAPI.MOD_ID + ":" + pUnpackedName + "_from_unpacking_" + pPackedName);
    }

    protected static void oreSmelting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTIme, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.SMELTING_RECIPE, pIngredients, pCategory, pResult,
                pExperience, pCookingTIme, pGroup, "_from_smelting");
    }

    protected static void oreBlasting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.BLASTING_RECIPE, pIngredients, pCategory, pResult,
                pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    protected static void oreCooking(Consumer<FinishedRecipe> pFinishedRecipeConsumer, RecipeSerializer<? extends AbstractCookingRecipe> pCookingSerializer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pRecipeName) {
        for(ItemLike itemlike : pIngredients) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), pCategory, pResult, pExperience, pCookingTime,
                    pCookingSerializer).group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike)).save(pFinishedRecipeConsumer,
                    HellfireAPI.MOD_ID + ":" + getItemName(pResult) + pRecipeName + "_" + getItemName(itemlike));
        }

    }
}
