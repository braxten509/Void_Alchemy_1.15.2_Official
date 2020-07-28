package com.elitethaumaturge.zorumtweaks.items.misc;

import com.elitethaumaturge.zorumtweaks.ZorumTweaks;
import com.elitethaumaturge.zorumtweaks.other.GlobalVariables;
import com.elitethaumaturge.zorumtweaks.util.RegistryHandler;
import com.elitethaumaturge.zorumtweaks.world.dimension.VoidTeleporter;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
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
import net.minecraft.world.dimension.DimensionType;
import net.minecraft.world.server.ServerWorld;

import javax.annotation.Nullable;
import java.util.List;

public class OminousBook extends Item {

    //no parameters can be in the constructor
    public OminousBook() {

        super(new Item.Properties().group(ZorumTweaks.TAB).maxStackSize(1));

    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
        ActionResult<ItemStack> actionResult = super.onItemRightClick(worldIn, playerIn, handIn);

        //fix teleporter
        if (!worldIn.isRemote && GlobalVariables.researchPoints >= 4 && playerIn.dimension != DimensionType.byName(ZorumTweaks.VOID_DIMENSION_TYPE)) {

            double d0 = playerIn.getPosX();
            double d1 = playerIn.getPosY();
            double d2 = playerIn.getPosZ();

            worldIn.playSound((PlayerEntity) null, d0, d1, d2, SoundEvents.ENTITY_LIGHTNING_BOLT_THUNDER, SoundCategory.PLAYERS, 1.0F, 1.0F);
            playerIn.playSound(SoundEvents.ENTITY_LIGHTNING_BOLT_THUNDER, 1.0F, 1.0F);

            for (int repeat = 0; repeat <= 7; ++repeat) {
                playerIn.sendStatusMessage(new StringTextComponent(""), false);
            }

            playerIn.sendStatusMessage(new StringTextComponent("You're afraid. Lost. Desperate. Hopeless...").applyTextStyle(TextFormatting.GRAY), false);
            playerIn.sendStatusMessage(new StringTextComponent("But in the midst of darkness, there is always a ").applyTextStyle(TextFormatting.GRAY), false);
            playerIn.sendStatusMessage(new StringTextComponent("Light").applyTextStyle(TextFormatting.YELLOW), false);


            if (playerIn instanceof ServerPlayerEntity && !playerIn.getCooldownTracker().hasCooldown(RegistryHandler.OMINOUS_BOOK.get())) {

                ServerPlayerEntity serverPlayerEntity = (ServerPlayerEntity) playerIn;
                ServerWorld serverWorld = (ServerWorld) worldIn;

                if (playerIn.dimension == DimensionType.OVERWORLD) {
                    serverPlayerEntity.changeDimension(DimensionType.byName(ZorumTweaks.VOID_DIMENSION_TYPE), new VoidTeleporter(serverWorld));
                } else if (playerIn.dimension == DimensionType.byName(ZorumTweaks.VOID_DIMENSION_TYPE)) {
                    serverPlayerEntity.changeDimension(DimensionType.OVERWORLD, new VoidTeleporter(serverWorld));
                }
            }

                playerIn.getCooldownTracker().setCooldown(this, 20);

        }
        //the return is always the last statement
        return actionResult;
    }


    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        if (GlobalVariables.researchPoints < 4) {
            tooltip.add(new StringTextComponent("Very few things have ever frightened you,").applyTextStyle(TextFormatting.GRAY));
            tooltip.add(new StringTextComponent("but this is one of those few things that has...").applyTextStyle(TextFormatting.GRAY));
            tooltip.add(new StringTextComponent("Research Points: " + GlobalVariables.researchPoints + "/4").applyTextStyle(TextFormatting.GRAY));
        } else if (GlobalVariables.researchPoints >= 4){
            tooltip.add(new StringTextComponent("Very few things have ever frightened you,").applyTextStyle(TextFormatting.GRAY));
            tooltip.add(new StringTextComponent("but this is one of those few things that has...").applyTextStyle(TextFormatting.GRAY));
            tooltip.add(new StringTextComponent("Right-click to go to The Void").applyTextStyle(TextFormatting.GRAY));
        }
    }

}
