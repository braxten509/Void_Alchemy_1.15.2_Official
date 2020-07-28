package com.elitethaumaturge.zorumtweaks.items.tools;

import com.elitethaumaturge.zorumtweaks.ZorumTweaks;
import com.elitethaumaturge.zorumtweaks.items.tools.tiersandtypes.StrangeTier;
import com.elitethaumaturge.zorumtweaks.items.tools.tiersandtypes.ZorumTier;
import net.minecraft.item.PickaxeItem;


public class StrangePickaxe extends PickaxeItem {

    public StrangePickaxe() {
        super(StrangeTier.STRANGE, 1, -2.4f, new Properties().group(ZorumTweaks.TAB));
    }

}
