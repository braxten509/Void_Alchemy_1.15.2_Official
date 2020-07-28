package com.elitethaumaturge.zorumtweaks.items.tools;

import com.elitethaumaturge.zorumtweaks.ZorumTweaks;
import com.elitethaumaturge.zorumtweaks.items.tools.tiersandtypes.DaggerItem;
import com.elitethaumaturge.zorumtweaks.items.tools.tiersandtypes.StrangeDaggerTier;
import com.elitethaumaturge.zorumtweaks.items.tools.tiersandtypes.StrangeTier;
import com.elitethaumaturge.zorumtweaks.items.tools.tiersandtypes.ZorumTier;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;


public class StrangeDagger extends DaggerItem {

    public StrangeDagger() {
        super(StrangeDaggerTier.STRANGE, 1, -1.2f, new Properties().group(ZorumTweaks.TAB));
    }

    //Tooltips
    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {

        tooltip.add(new StringTextComponent("On critical hit: Jumpboost & Speed, 1 Health, Creates Void Energy").applyTextStyle(TextFormatting.GREEN));

    }

}
