package com.elitethaumaturge.zorumtweaks.items.misc;

import com.elitethaumaturge.zorumtweaks.ZorumTweaks;
import com.elitethaumaturge.zorumtweaks.other.KeyboardHelper;
import com.elitethaumaturge.zorumtweaks.other.GlobalVariables;
import com.elitethaumaturge.zorumtweaks.util.RegistryHandler;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.*;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;

public class ArcamirusStone extends Item {

    public static int activationRequirement = 100;
    private int stoneStage = 0;

    public ArcamirusStone() {
        super(new Item.Properties().group(ZorumTweaks.TAB).maxStackSize(1));
        setNBTData(this.getDefaultInstance(), 0);
    }

    private void setNBTData(ItemStack stack, int data)
    {
        stack.getOrCreateTag().putInt("stoneStage", data);
    }

    private int getNBTData(ItemStack stack)
    {
            return stack.getOrCreateTag().getInt("stoneStage");
    }



    //Tooltips
    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {

        tooltip.add(new StringTextComponent("Void Energy: " + GlobalVariables.voidEnergy + "/" + activationRequirement).applyTextStyle(TextFormatting.GRAY));

    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {

        //Only works on client
        if (!(worldIn.isRemote)) {


            /** CHANGES STONE STAGE **/
            if (KeyboardHelper.isHoldingShift()) {
                stoneStage++;
                stoneStage %= 5;

                setNBTData(playerIn.getHeldItemMainhand(), stoneStage);
            }

            int nbtData = getNBTData(playerIn.getHeldItemMainhand());


            /** DESCRIPTIONS **/
            switch(nbtData) {

                case 0 :
                    playerIn.sendStatusMessage(new StringTextComponent("Absorption II").applyTextStyle(TextFormatting.GRAY), true);
                    break;

                case 1 :
                    playerIn.sendStatusMessage(new StringTextComponent("Resistance II").applyTextStyle(TextFormatting.GRAY), true);
                    break;

                case 2 :
                    playerIn.sendStatusMessage(new StringTextComponent("Invisibility").applyTextStyle(TextFormatting.GRAY), true);
                    break;

                case 3 :
                    playerIn.sendStatusMessage(new StringTextComponent("Haste II").applyTextStyle(TextFormatting.GRAY), true);
                    break;

                case 4 :
                    playerIn.sendStatusMessage(new StringTextComponent("Create Void Dust").applyTextStyle(TextFormatting.GRAY), true);
                    break;

            }

            /** SPECIAL ABILITIES **/
            if (!KeyboardHelper.isHoldingShift() && GlobalVariables.voidEnergy >= activationRequirement) {

                switch(nbtData) {

                    case 0 :
                        playerIn.addPotionEffect(new EffectInstance(Effects.ABSORPTION, 600, 1));
                        break;

                    case 1 :
                        playerIn.addPotionEffect(new EffectInstance(Effects.RESISTANCE, 600, 1));
                        break;

                    case 2 :
                        playerIn.addPotionEffect(new EffectInstance(Effects.INVISIBILITY, 1200, 0));
                        break;

                    case 3 :
                        playerIn.addPotionEffect(new EffectInstance(Effects.HASTE, 1200, 1));
                        break;

                    case 4 :
                        playerIn.inventory.addItemStackToInventory(new ItemStack(RegistryHandler.VOID_DUST.get(), 2));
                        break;

                }

                /** GLOBAL HAPPENINGS **/
                GlobalVariables.voidEnergy -= activationRequirement;
                if (GlobalVariables.voidEnergy < 0) { GlobalVariables.voidEnergy = 0; }

                worldIn.playSound((PlayerEntity) null, playerIn.getPosX(), playerIn.getPosY(), playerIn.getPosZ(), SoundEvents.BLOCK_END_PORTAL_SPAWN, SoundCategory.PLAYERS, 1.0F, 1.0F);
                playerIn.playSound(SoundEvents.BLOCK_END_PORTAL_SPAWN, 1.0F, 1.0F);
                playerIn.getCooldownTracker().setCooldown(this, 600);
            }
        }

        return super.onItemRightClick(worldIn, playerIn, handIn);

    }
}
