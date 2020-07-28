package com.elitethaumaturge.zorumtweaks.events;

import com.elitethaumaturge.zorumtweaks.ZorumTweaks;
import com.elitethaumaturge.zorumtweaks.other.GlobalVariables;
import com.elitethaumaturge.zorumtweaks.util.RegistryHandler;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = ZorumTweaks.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class SpeculoInanisResearch {

    @SubscribeEvent
    public static void rightClickBlock(PlayerInteractEvent.RightClickBlock event) {
        LivingEntity livingEntity = event.getEntityLiving();
        PlayerEntity playerEntity = event.getPlayer();
        World world = livingEntity.getEntityWorld();
        BlockPos pos = event.getPos();
        Block block = world.getBlockState(pos).getBlock();


        double d0 = livingEntity.getPosX();
        double d1 = livingEntity.getPosY();
        double d2 = livingEntity.getPosZ();

        //research !(worldIn.isRemote) means ClientSide only!
        if (!(world.isRemote) && livingEntity.getHeldItemMainhand().getItem() == RegistryHandler.SPECULO_INANIS.get() && playerEntity.inventory.hasItemStack(new ItemStack(RegistryHandler.OMINOUS_BOOK.get(), (int) (1))) && !playerEntity.getCooldownTracker().hasCooldown(RegistryHandler.SPECULO_INANIS.get())) {

            playerEntity.getCooldownTracker().setCooldown(RegistryHandler.SPECULO_INANIS.get(), 20);

            if (block == Blocks.EMERALD_BLOCK && GlobalVariables.researchEmerald != true) {
                ZorumTweaks.LOGGER.info("RightclickEvent passed");


                    playerEntity.getCooldownTracker().setCooldown(RegistryHandler.OMINOUS_BOOK.get(), 20);


                world.playSound((PlayerEntity) null, d0, d1, d2, SoundEvents.ENTITY_PLAYER_LEVELUP, SoundCategory.PLAYERS, 1.0F, 1.0F);
                livingEntity.playSound(SoundEvents.ENTITY_PLAYER_LEVELUP, 1.0F, 1.0F);

                playerEntity.sendStatusMessage(new StringTextComponent("You understand greed...").applyTextStyle(TextFormatting.DARK_PURPLE), false);

                GlobalVariables.researchPoints += 1;
                GlobalVariables.researchEmerald = true;

            } else if (block == Blocks.CARVED_PUMPKIN && GlobalVariables.researchJackolantern != true) {

                ZorumTweaks.LOGGER.info("RightclickEvent passed");


                    playerEntity.getCooldownTracker().setCooldown(RegistryHandler.OMINOUS_BOOK.get(), 20);


                world.playSound((PlayerEntity) null, d0, d1, d2, SoundEvents.ENTITY_PLAYER_LEVELUP, SoundCategory.PLAYERS, 1.0F, 1.0F);
                livingEntity.playSound(SoundEvents.ENTITY_PLAYER_LEVELUP, 1.0F, 1.0F);

                playerEntity.sendStatusMessage(new StringTextComponent("You understand fear...").applyTextStyle(TextFormatting.DARK_PURPLE), false);


                GlobalVariables.researchPoints += 1;
                GlobalVariables.researchJackolantern = true;
            } else if (block == Blocks.SOUL_SAND && GlobalVariables.researchSoulsand != true) {
                ZorumTweaks.LOGGER.info("RightclickEvent passed");

                    playerEntity.getCooldownTracker().setCooldown(RegistryHandler.OMINOUS_BOOK.get(), 20);


                world.playSound((PlayerEntity) null, d0, d1, d2, SoundEvents.ENTITY_PLAYER_LEVELUP, SoundCategory.PLAYERS, 1.0F, 1.0F);
                livingEntity.playSound(SoundEvents.ENTITY_PLAYER_LEVELUP, 1.0F, 1.0F);

                playerEntity.sendStatusMessage(new StringTextComponent("You understand what it's like to feel lost...").applyTextStyle(TextFormatting.DARK_PURPLE), false);


                GlobalVariables.researchPoints += 1;
                GlobalVariables.researchSoulsand = true;

            } else if (block == RegistryHandler.VOID_BLOCK.get() && GlobalVariables.researchVoid != true) {
                ZorumTweaks.LOGGER.info("RightclickEvent passed");

                    playerEntity.getCooldownTracker().setCooldown(RegistryHandler.OMINOUS_BOOK.get(), 20);


                world.playSound((PlayerEntity) null, d0, d1, d2, SoundEvents.ENTITY_PLAYER_LEVELUP, SoundCategory.PLAYERS, 1.0F, 1.0F);
                livingEntity.playSound(SoundEvents.ENTITY_PLAYER_LEVELUP, 1.0F, 1.0F);

                playerEntity.sendStatusMessage(new StringTextComponent("You feel empty...").applyTextStyle(TextFormatting.DARK_PURPLE), false);


                GlobalVariables.researchPoints += 1;
                GlobalVariables.researchVoid = true;

            } else if (block == RegistryHandler.ALCHEMICAL_ORE_BLOCK.get()) {

                playerEntity.sendStatusMessage(new StringTextComponent("A long time ago, there was a wizard was so powerful that his power imploded him, and the remains of his power are in the dust within these blocks...").applyTextStyle(TextFormatting.GRAY), false);
                world.playSound((PlayerEntity) null, d0, d1, d2, SoundEvents.ENTITY_PLAYER_LEVELUP, SoundCategory.PLAYERS, 1.0F, 1.0F);
                livingEntity.playSound(SoundEvents.ENTITY_PLAYER_LEVELUP, 0.5F, 1.0F);

            } else if (block == Blocks.IRON_ORE.getBlock()) {

                playerEntity.sendStatusMessage(new StringTextComponent("Bag of Alchemical Dust can be used on Iron Ore").applyTextStyle(TextFormatting.GRAY), false);
                world.playSound((PlayerEntity) null, d0, d1, d2, SoundEvents.ENTITY_PLAYER_LEVELUP, SoundCategory.PLAYERS, 1.0F, 1.0F);
                livingEntity.playSound(SoundEvents.ENTITY_PLAYER_LEVELUP, 0.5F, 1.0F);

            } else if (block == RegistryHandler.PROTOTYPE_BLOCK.get() || block == RegistryHandler.STAGE2_BLOCK.get() || block == RegistryHandler.STAGE3_BLOCK.get() || block == RegistryHandler.STAGE4_BLOCK.get()) {

                playerEntity.sendStatusMessage(new StringTextComponent("Bag of Alchemical, Arcamirus, Ethereal, or Void dust can be used. Only one will succeed...").applyTextStyle(TextFormatting.GRAY), false);
                world.playSound((PlayerEntity) null, d0, d1, d2, SoundEvents.ENTITY_PLAYER_LEVELUP, SoundCategory.PLAYERS, 1.0F, 1.0F);
                livingEntity.playSound(SoundEvents.ENTITY_PLAYER_LEVELUP, 0.5F, 1.0F);

            } else if (block == RegistryHandler.FORLORN_STONE_BLOCK.get()) {

                playerEntity.sendStatusMessage(new StringTextComponent("It's a Forlorn Stone. Too dark in he depths of sorrow to show any sign of hope. Perhaps it would help to lighten its load...").applyTextStyle(TextFormatting.GRAY), false);
                world.playSound((PlayerEntity) null, d0, d1, d2, SoundEvents.ENTITY_PLAYER_LEVELUP, SoundCategory.PLAYERS, 1.0F, 1.0F);
                livingEntity.playSound(SoundEvents.ENTITY_PLAYER_LEVELUP, 0.5F, 1.0F);

            } else if (block == RegistryHandler.ENLIGHTENED_STONE_BLOCK.get()) {

                playerEntity.sendStatusMessage(new StringTextComponent("A stone filled with light, it has something to offer...").applyTextStyle(TextFormatting.GRAY), false);
                world.playSound((PlayerEntity) null, d0, d1, d2, SoundEvents.ENTITY_PLAYER_LEVELUP, SoundCategory.PLAYERS, 1.0F, 1.0F);
                livingEntity.playSound(SoundEvents.ENTITY_PLAYER_LEVELUP, 0.5F, 1.0F);

            } else {

                playerEntity.sendStatusMessage(new StringTextComponent("Nothing to research").applyTextStyle(TextFormatting.GRAY), true);

            }



            } else if (livingEntity.getHeldItemMainhand().getItem() == RegistryHandler.SPECULO_INANIS.get() && !playerEntity.inventory.hasItemStack(new ItemStack(RegistryHandler.OMINOUS_BOOK.get(), (int) (1)))) {

                playerEntity.sendStatusMessage(new StringTextComponent("Missing Ominous Book").applyTextStyle(TextFormatting.GRAY), true);

            }
    }

}
