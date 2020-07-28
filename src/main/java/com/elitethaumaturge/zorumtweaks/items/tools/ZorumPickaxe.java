package com.elitethaumaturge.zorumtweaks.items.tools;

import com.elitethaumaturge.zorumtweaks.ZorumTweaks;
import com.elitethaumaturge.zorumtweaks.items.tools.tiersandtypes.ZorumTier;
import net.minecraft.item.PickaxeItem;


public class ZorumPickaxe extends PickaxeItem {

    public ZorumPickaxe() {
        super(ZorumTier.ZORUMITE, 1, -2.4f, new Properties().group(ZorumTweaks.TAB));
    }

}
