package com.elitethaumaturge.zorumtweaks.events;

import com.elitethaumaturge.zorumtweaks.ZorumTweaks;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = ZorumTweaks.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class LivingDamageEvent {

    @SubscribeEvent
    public static void livingDamageEvent(net.minecraftforge.event.entity.living.LivingDamageEvent event) {

    }

}
