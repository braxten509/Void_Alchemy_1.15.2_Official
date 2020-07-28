package com.elitethaumaturge.zorumtweaks.items.tools;

import com.elitethaumaturge.zorumtweaks.ZorumTweaks;
import com.elitethaumaturge.zorumtweaks.items.tools.tiersandtypes.ZorumTier;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.*;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;


public class ZorumHammer extends PickaxeItem {

    public ZorumHammer() {
        super(ZorumTier.ZORUMITE, 8, -3.4f, new Properties().group(ZorumTweaks.TAB));
    }

    //Tooltips
    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {

        tooltip.add(new StringTextComponent("On critical hit: Jumpboost, 3 Health, Creates Void Energy").applyTextStyle(TextFormatting.GREEN));

    }


}
