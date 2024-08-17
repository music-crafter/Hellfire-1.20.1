package com.musiccrafter.hellfire_api.datagen;

import com.musiccrafter.hellfire_api.HellfireAPI;
import com.musiccrafter.hellfire_api.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, HellfireAPI.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {

        // Chthonium
        simpleItem(ModItems.CHTHONIUM_INGOT);
        simpleItem(ModItems.RAW_CHTHONIUM);

    }

    private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(HellfireAPI.MOD_ID, "item/" + item.getId().getPath()));
    }
}
