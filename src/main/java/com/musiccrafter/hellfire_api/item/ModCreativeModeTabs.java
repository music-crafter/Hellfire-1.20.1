package com.musiccrafter.hellfire_api.item;

import com.musiccrafter.hellfire_api.HellfireAPI;
import com.musiccrafter.hellfire_api.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, HellfireAPI.MOD_ID);

    public static final RegistryObject<CreativeModeTab> HELLFIRE_API = CREATIVE_MODE_TABS.register("hellfire_api",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.CHTHONIUM_INGOT.get()))
                    .title(Component.translatable("creativetab.hellfire_api"))
                    .displayItems((pParameters, pOutput) -> {

                        // Metals
                        // Chthonium
                        pOutput.accept(ModItems.RAW_CHTHONIUM.get());
                        pOutput.accept(ModItems.CHTHONIUM_INGOT.get());
                        pOutput.accept(ModBlocks.CHTHONIUM_BLOCK.get());
                        pOutput.accept(ModBlocks.RAW_CHTHONIUM_BLOCK.get());
                        pOutput.accept(ModBlocks.CHTHONIUM_ORE.get());

                        // Woods
                        // Pomegranate
                        pOutput.accept(ModBlocks.POMEGRANATE_LOG.get());
                        pOutput.accept(ModBlocks.POMEGRANATE_WOOD.get());
                        pOutput.accept(ModBlocks.STRIPPED_POMEGRANATE_LOG.get());
                        pOutput.accept(ModBlocks.STRIPPED_POMEGRANATE_WOOD.get());
                        pOutput.accept(ModBlocks.POMEGRANATE_PLANKS.get());
                        pOutput.accept(ModBlocks.POMEGRANATE_LEAVES.get());

                    })
                    .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
