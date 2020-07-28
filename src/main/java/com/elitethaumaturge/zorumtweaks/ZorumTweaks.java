package com.elitethaumaturge.zorumtweaks;

import com.elitethaumaturge.zorumtweaks.util.RegistryHandler;
import com.elitethaumaturge.zorumtweaks.world.gen.ZorumiteOreGen;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.network.play.server.SSpawnGlobalEntityPacket;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.DeferredWorkQueue;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLLoadCompleteEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.lwjgl.system.CallbackI;

//mod id
@Mod("zorummod")
@Mod.EventBusSubscriber(modid = ZorumTweaks.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ZorumTweaks
{

    public static final Logger LOGGER = LogManager.getLogger();
    public static final String MOD_ID = "zorummod";
    public static final ResourceLocation VOID_DIMENSION_TYPE = new ResourceLocation(MOD_ID, "void");

    public ZorumTweaks() {

        //FMLJavaModLoadingContext.get().getModEventBus().addListener(this::onRegisterBiomes);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::loadCompleteEvent);

        RegistryHandler.init();

        MinecraftForge.EVENT_BUS.register(this);
    }



    @SubscribeEvent
    public static void onRegisterBiomes(final RegistryEvent.Register<Biome> event) { RegistryHandler.registerBiomes(); }

    private void setup(final FMLCommonSetupEvent event) {

            //RenderingRegistry.registerEntityRenderingHandler(RegistryHandler.VOID_WALKER_ENTITY.get(), VoidEntityRender::new);

    }

    private void doClientStuff(final FMLClientSetupEvent event) { }

    public void loadCompleteEvent(FMLLoadCompleteEvent event)
    {
        ZorumiteOreGen.generateOre();
    }

    public static final ItemGroup TAB = new ItemGroup("zorumTab"){
        @Override
        public ItemStack createIcon() {
            return new ItemStack(RegistryHandler.ZORUMITE.get());
        }
    };


}
