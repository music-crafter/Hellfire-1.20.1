package com.musiccrafter.hellfire_api.item;

import com.musiccrafter.hellfire_api.HellfireAPI;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, HellfireAPI.MOD_ID);

    // Chthonium
    public static final RegistryObject<Item> RAW_CHTHONIUM = ITEMS.register("raw_chthonium",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> CHTHONIUM_INGOT = ITEMS.register("chthonium_ingot",
            () -> new Item(new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
