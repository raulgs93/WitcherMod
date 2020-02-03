package com.musgo.examplemod;

import com.musgo.examplemod.init.ModItemGroups;
import com.musgo.examplemod.init.ModToolMaterials;
import com.musgo.examplemod.items.LunarPotion;
import com.musgo.examplemod.lib.ModItemIDs;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.SwordItem;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.stream.Collectors;

@Mod(Main.MODID)
public class Main {
    // Directly reference a log4j logger.
    public static final String MODID = "examplemod";
    private static final Logger LOGGER = LogManager.getLogger();

    public Main() {
        // Register the setup method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);

        // Register the doClientStuff method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event)
    {
        // some preinit code

    }

    private void doClientStuff(final FMLClientSetupEvent event) {
        // do something that can only be done on the client

    }


    // You can use EventBusSubscriber to automatically subscribe events on the contained class (this is subscribing to the MOD
    // Event bus for receiving Registry Events)
    @Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
    public static class RegistryEvents {

        @SubscribeEvent
        public static void onBlocksRegistry(final RegistryEvent.Register<Block> event) {
            // register a new block here
            LOGGER.info("Blocks Registered");
        }

        @SubscribeEvent
        public static void onItemsRegistry(final RegistryEvent.Register<Item> event){

            //add new items here!
            event.getRegistry().registerAll(
                   // new Item(new Item.Properties().group(ModItemGroups.MOD_ITEM_GROUP)).setRegistryName(location("lunar_potion"))
                    new LunarPotion(new Item.Properties().group(ModItemGroups.MOD_ITEM_GROUP)).setRegistryName(location(ModItemIDs.LUNAR_POTION_ID)),
                    new Item(new Item.Properties().group(ModItemGroups.MOD_ITEM_GROUP)).setRegistryName(location(ModItemIDs.SILVER_INGOT)),
                    new SwordItem(ModToolMaterials.silver, 0, 6.0f, new Item.Properties().group(ModItemGroups.MOD_ITEM_GROUP)).setRegistryName(location(ModItemIDs.WITCHER_SWORD))
            );

            LOGGER.info("Items Registered");
        }

        private static ResourceLocation location(String name){
            return new ResourceLocation(MODID, name);
        }
    }

}
