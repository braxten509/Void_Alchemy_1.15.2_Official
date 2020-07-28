package com.elitethaumaturge.zorumtweaks.util;

import com.elitethaumaturge.zorumtweaks.ZorumTweaks;
import net.minecraft.world.dimension.DimensionType;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.event.world.RegisterDimensionsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import static net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@Mod.EventBusSubscriber(modid = ZorumTweaks.MOD_ID, bus = Bus.FORGE)
public class ForgeEventBusSubscriber {

    @SubscribeEvent
    public static void registerDimensions(final RegisterDimensionsEvent event) {
        if (DimensionType.byName(ZorumTweaks.VOID_DIMENSION_TYPE) == null) {
            DimensionManager.registerDimension(ZorumTweaks.VOID_DIMENSION_TYPE, RegistryHandler.VOID_DIMENSION.get(), null, true);
        }
        ZorumTweaks.LOGGER.info("Dimensions Registered");
    }
}
