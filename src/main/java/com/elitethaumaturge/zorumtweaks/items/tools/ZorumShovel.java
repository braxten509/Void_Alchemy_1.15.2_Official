package com.elitethaumaturge.zorumtweaks.items.tools;

import com.elitethaumaturge.zorumtweaks.ZorumTweaks;
import com.elitethaumaturge.zorumtweaks.items.tools.tiersandtypes.ZorumTier;
import net.minecraft.item.ShovelItem;


public class ZorumShovel extends ShovelItem {

    public ZorumShovel() {
        super(ZorumTier.ZORUMITE, 0, -2.0f, new Properties().group(ZorumTweaks.TAB));
    }

}
