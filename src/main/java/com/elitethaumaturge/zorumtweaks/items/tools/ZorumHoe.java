package com.elitethaumaturge.zorumtweaks.items.tools;

import com.elitethaumaturge.zorumtweaks.ZorumTweaks;
import com.elitethaumaturge.zorumtweaks.items.tools.tiersandtypes.ZorumTier;
import net.minecraft.item.HoeItem;


public class ZorumHoe extends HoeItem {

    public ZorumHoe() {
        super(ZorumTier.ZORUMITE, 0.0f, new Properties().group(ZorumTweaks.TAB));
    }

}
