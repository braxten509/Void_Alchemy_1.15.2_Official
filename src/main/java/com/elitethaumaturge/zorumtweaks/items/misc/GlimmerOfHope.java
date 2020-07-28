package com.elitethaumaturge.zorumtweaks.items.misc;

import com.elitethaumaturge.zorumtweaks.ZorumTweaks;
import com.elitethaumaturge.zorumtweaks.util.RegistryHandler;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;

public class GlimmerOfHope extends Item {
    public GlimmerOfHope() {
        super(new Properties().group(ZorumTweaks.TAB));
    }

    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        //tooltip.add(new StringTextComponent("For even in the midst of darkness there is light...").applyTextStyle(TextFormatting.WHITE));
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
        ActionResult<ItemStack> actionResult = super.onItemRightClick(worldIn, playerIn, handIn);

        ZorumTweaks.LOGGER.info("RightclickEvent passed");

        //predicate of an itemStack: item -> item.getItem.equals(Items.WHEAT), takes 1 alchemical dust away
        playerIn.inventory.clearMatchingItems(item -> item.getItem().equals((RegistryHandler.GLIMMER_OF_HOPE).get()), 1);
        playerIn.addPotionEffect(new EffectInstance(Effects.REGENERATION, 2400, 2));
        playerIn.addPotionEffect(new EffectInstance(Effects.HASTE, 2400, 2));


        if (!worldIn.isRemote) {
            double d0 = playerIn.getPosX();
            double d1 = playerIn.getPosY();
            double d2 = playerIn.getPosZ();

            worldIn.playSound((PlayerEntity)null, d0, d1, d2, SoundEvents.BLOCK_BEACON_POWER_SELECT, SoundCategory.PLAYERS, 1.0F, 1.0F);
            playerIn.playSound(SoundEvents.BLOCK_BEACON_POWER_SELECT, 1.0F, 1.0F);
            playerIn.sendStatusMessage(new StringTextComponent("Your spirits are lifted!").applyTextStyle(TextFormatting.YELLOW), true);


            if (playerIn instanceof PlayerEntity) {
                ((PlayerEntity)playerIn).getCooldownTracker().setCooldown(this, 40);
            }
        }

        return actionResult;
    }

}
