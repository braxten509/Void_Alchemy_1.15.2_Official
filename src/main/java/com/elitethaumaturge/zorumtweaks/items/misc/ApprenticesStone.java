package com.elitethaumaturge.zorumtweaks.items.misc;

import com.elitethaumaturge.zorumtweaks.ZorumTweaks;
import com.elitethaumaturge.zorumtweaks.other.KeyboardHelper;
import com.elitethaumaturge.zorumtweaks.other.GlobalVariables;
import com.elitethaumaturge.zorumtweaks.util.RegistryHandler;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
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

public class ApprenticesStone extends Item {

    public ApprenticesStone() {
        super(new Properties().group(ZorumTweaks.TAB).maxStackSize(1));
    }




    //Tooltips
    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        tooltip.add(new StringTextComponent("Void Energy: " + GlobalVariables.voidEnergy + "/" + ArcamirusStone.activationRequirement).applyTextStyle(TextFormatting.GRAY));

    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
        //Only works on client
        if (!(worldIn.isRemote)) {

            if (KeyboardHelper.isHoldingShift()) {
                playerIn.sendStatusMessage(new StringTextComponent("Create Void Dust").applyTextStyle(TextFormatting.GRAY), true);

            }

            //Actions of the special abilities
            if (!KeyboardHelper.isHoldingShift()) {

                playerIn.sendStatusMessage(new StringTextComponent("Create Void Dust").applyTextStyle(TextFormatting.GRAY), true);


                if (GlobalVariables.voidEnergy >= ArcamirusStone.activationRequirement) {
                            GlobalVariables.voidEnergy -= ArcamirusStone.activationRequirement;

                            if (GlobalVariables.voidEnergy < 0) {
                                GlobalVariables.voidEnergy = 0;
                            }

                            playerIn.inventory.addItemStackToInventory(new ItemStack(RegistryHandler.VOID_DUST.get(), 1));

                            worldIn.playSound((PlayerEntity) null, playerIn.getPosX(), playerIn.getPosY(), playerIn.getPosZ(), SoundEvents.BLOCK_END_PORTAL_SPAWN, SoundCategory.PLAYERS, 1.0F, 1.0F);
                            playerIn.playSound(SoundEvents.BLOCK_END_PORTAL_SPAWN, 1.0F, 1.0F);

                            if (playerIn instanceof PlayerEntity) {
                                ((PlayerEntity) playerIn).getCooldownTracker().setCooldown(this, 600);
                            }
                        }
                    }
                 }

        return super.onItemRightClick(worldIn, playerIn, handIn);

    }



}
