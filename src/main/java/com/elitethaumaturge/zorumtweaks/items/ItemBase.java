package com.elitethaumaturge.zorumtweaks.items;

import com.elitethaumaturge.zorumtweaks.ZorumTweaks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;

public class ItemBase extends Item {
    public ItemBase() {
        super(new Item.Properties().group(ZorumTweaks.TAB));
    }
}
