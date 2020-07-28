package com.elitethaumaturge.zorumtweaks.items.tools;

import com.elitethaumaturge.zorumtweaks.ZorumTweaks;
import com.elitethaumaturge.zorumtweaks.items.tools.tiersandtypes.StrangeTier;
import com.elitethaumaturge.zorumtweaks.items.tools.tiersandtypes.ZorumTier;
import net.minecraft.item.ShovelItem;


public class StrangeShovel extends ShovelItem {

    public StrangeShovel() {
        super(StrangeTier.STRANGE, 0, -2.0f, new Properties().group(ZorumTweaks.TAB));
    }

}
