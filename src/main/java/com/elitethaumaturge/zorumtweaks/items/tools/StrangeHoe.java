package com.elitethaumaturge.zorumtweaks.items.tools;

import com.elitethaumaturge.zorumtweaks.ZorumTweaks;
import com.elitethaumaturge.zorumtweaks.items.tools.tiersandtypes.StrangeTier;
import com.elitethaumaturge.zorumtweaks.items.tools.tiersandtypes.ZorumTier;
import net.minecraft.item.HoeItem;


public class StrangeHoe extends HoeItem {

    public StrangeHoe() {
        super(StrangeTier.STRANGE, 0.0f, new Properties().group(ZorumTweaks.TAB));
    }

}
