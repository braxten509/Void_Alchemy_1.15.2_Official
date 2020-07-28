package com.elitethaumaturge.zorumtweaks.events;

import com.elitethaumaturge.zorumtweaks.ZorumTweaks;
import com.elitethaumaturge.zorumtweaks.util.RegistryHandler;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.Random;

@Mod.EventBusSubscriber(modid = ZorumTweaks.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class DustEvents {



    @SubscribeEvent
    public static void rightClickBlock(PlayerInteractEvent.RightClickBlock event) {
        LivingEntity livingEntity = event.getEntityLiving();
        PlayerEntity playerEntity = event.getPlayer();
        World world = livingEntity.getEntityWorld();
        BlockPos pos = event.getPos();
        Block block = world.getBlockState(pos).getBlock();

        Item[] dustBags = {RegistryHandler.BAG_OF_ALCHEMICAL_DUST.get(), RegistryHandler.BAG_OF_ARCAMIRUS_DUST.get(),
                RegistryHandler.BAG_OF_ETHEREAL_DUST.get(), RegistryHandler.BAG_OF_MIRCANTERS_DUST.get(), RegistryHandler.BAG_OF_VOID_DUST.get()};

        Item playerMain = playerEntity.getHeldItemMainhand().getItem();



        /** STAGE 1 **/
        if (playerEntity.getCooldownTracker().hasCooldown(dustBags[1]) != true) {
            if (playerMain != dustBags[1] && block == RegistryHandler.PROTOTYPE_BLOCK.get()) {
                if (playerMain == dustBags[0] || playerMain == dustBags[2] || playerMain == dustBags[4] || playerMain == dustBags[3]) {


                    ZorumTweaks.LOGGER.info("RightclickEvent passed");
                    world.setBlockState(pos, RegistryHandler.FAILED_PROTOTYPE_BLOCK.get().getDefaultState());

                    playerEntity.inventory.clearMatchingItems(item -> item.getItem().equals(playerMain), 1);
                    playerEntity.sendStatusMessage(new StringTextComponent("Failure").applyTextStyle(TextFormatting.RED), true);

                    for (int countparticles = 0; countparticles <= 50; ++countparticles) {
                        Random rand = new Random();
                        world.addParticle(ParticleTypes.EXPLOSION, pos.getX() + (rand.nextDouble()), pos.getY() + (rand.nextDouble()), pos.getZ() + (rand.nextDouble()), 0.1, 0.1, 0.1);
                    }

                    playerEntity.getCooldownTracker().setCooldown(playerMain, 20);

                    if (!world.isRemote) {
                        double d0 = livingEntity.getPosX();
                        double d1 = livingEntity.getPosY();
                        double d2 = livingEntity.getPosZ();

                        world.playSound((PlayerEntity) null, d0, d1, d2, SoundEvents.ENTITY_GENERIC_EXPLODE, SoundCategory.PLAYERS, 1.0F, 1.0F);
                        livingEntity.playSound(SoundEvents.ENTITY_GENERIC_EXPLODE, 1.0F, 1.0F);
                    }
                }
            } else if (playerMain == dustBags[1] && block == RegistryHandler.PROTOTYPE_BLOCK.get()) {
                ZorumTweaks.LOGGER.info("RightclickEvent passed");
                world.setBlockState(pos, RegistryHandler.STAGE2_BLOCK.get().getDefaultState());

                playerEntity.inventory.clearMatchingItems(item -> item.getItem().equals(playerMain), 1);
                playerEntity.sendStatusMessage(new StringTextComponent("Success!").applyTextStyle(TextFormatting.GREEN), true);


                for (int countparticles = 0; countparticles <= 100; ++countparticles) {
                    Random rand = new Random();
                    world.addParticle(ParticleTypes.EFFECT, pos.getX() + (rand.nextDouble()), pos.getY() + (rand.nextDouble()), pos.getZ() + (rand.nextDouble()), 0.1, 0.1, 0.1);
                }

                playerEntity.getCooldownTracker().setCooldown(playerMain, 20);

                if (!world.isRemote) {
                    double d0 = livingEntity.getPosX();
                    double d1 = livingEntity.getPosY();
                    double d2 = livingEntity.getPosZ();

                    world.playSound((PlayerEntity) null, d0, d1, d2, SoundEvents.ENTITY_FIREWORK_ROCKET_LARGE_BLAST, SoundCategory.PLAYERS, 1.0F, 1.0F);
                    livingEntity.playSound(SoundEvents.ENTITY_FIREWORK_ROCKET_LARGE_BLAST, 1.0F, 1.0F);
                }
            }
        }

        /** STAGE 2 **/
        if (playerEntity.getCooldownTracker().hasCooldown(dustBags[1]) != true && playerEntity.getCooldownTracker().hasCooldown(dustBags[2]) != true) {
            if (playerMain != dustBags[2] && block == RegistryHandler.STAGE2_BLOCK.get()) {
                if (playerMain == dustBags[0] || playerMain == dustBags[1] || playerMain == dustBags[4] || playerMain == dustBags[3]) {


                    ZorumTweaks.LOGGER.info("RightclickEvent passed");
                    world.setBlockState(pos, RegistryHandler.FAILED_PROTOTYPE_BLOCK.get().getDefaultState());

                    playerEntity.inventory.clearMatchingItems(item -> item.getItem().equals(playerMain), 1);
                    playerEntity.sendStatusMessage(new StringTextComponent("Failure").applyTextStyle(TextFormatting.RED), true);

                    for (int countparticles = 0; countparticles <= 50; ++countparticles) {
                        Random rand = new Random();
                        world.addParticle(ParticleTypes.EXPLOSION, pos.getX() + (rand.nextDouble()), pos.getY() + (rand.nextDouble()), pos.getZ() + (rand.nextDouble()), 0.1, 0.1, 0.1);
                    }

                    playerEntity.getCooldownTracker().setCooldown(playerMain, 20);

                    if (!world.isRemote) {
                        double d0 = livingEntity.getPosX();
                        double d1 = livingEntity.getPosY();
                        double d2 = livingEntity.getPosZ();

                        world.playSound((PlayerEntity) null, d0, d1, d2, SoundEvents.ENTITY_GENERIC_EXPLODE, SoundCategory.PLAYERS, 1.0F, 1.0F);
                        livingEntity.playSound(SoundEvents.ENTITY_GENERIC_EXPLODE, 1.0F, 1.0F);
                    }
                }
            } else if (playerMain == dustBags[2] && block == RegistryHandler.STAGE2_BLOCK.get()) {
                ZorumTweaks.LOGGER.info("RightclickEvent passed");
                world.setBlockState(pos, RegistryHandler.STAGE3_BLOCK.get().getDefaultState());

                playerEntity.inventory.clearMatchingItems(item -> item.getItem().equals(playerMain), 1);
                playerEntity.sendStatusMessage(new StringTextComponent("Success!").applyTextStyle(TextFormatting.GREEN), true);


                for (int countparticles = 0; countparticles <= 100; ++countparticles) {
                    Random rand = new Random();
                    world.addParticle(ParticleTypes.EFFECT, pos.getX() + (rand.nextDouble()), pos.getY() + (rand.nextDouble()), pos.getZ() + (rand.nextDouble()), 0.1, 0.1, 0.1);
                }

                playerEntity.getCooldownTracker().setCooldown(playerMain, 20);

                if (!world.isRemote) {
                    double d0 = livingEntity.getPosX();
                    double d1 = livingEntity.getPosY();
                    double d2 = livingEntity.getPosZ();

                    world.playSound((PlayerEntity) null, d0, d1, d2, SoundEvents.ENTITY_FIREWORK_ROCKET_LARGE_BLAST, SoundCategory.PLAYERS, 1.0F, 1.0F);
                    livingEntity.playSound(SoundEvents.ENTITY_FIREWORK_ROCKET_LARGE_BLAST, 1.0F, 1.0F);
                }
            }
        }


        /** STAGE 3 **/
        if (playerEntity.getCooldownTracker().hasCooldown(dustBags[2]) != true && playerEntity.getCooldownTracker().hasCooldown(dustBags[3]) != true) {
            if (playerMain != dustBags[3] && block == RegistryHandler.STAGE3_BLOCK.get()) {
                if (playerMain == dustBags[0] || playerMain == dustBags[2] || playerMain == dustBags[4] || playerMain == dustBags[1]) {


                    ZorumTweaks.LOGGER.info("RightclickEvent passed");
                    world.setBlockState(pos, RegistryHandler.FAILED_PROTOTYPE_BLOCK.get().getDefaultState());

                    playerEntity.inventory.clearMatchingItems(item -> item.getItem().equals(playerMain), 1);
                    playerEntity.sendStatusMessage(new StringTextComponent("Failure").applyTextStyle(TextFormatting.RED), true);

                    for (int countparticles = 0; countparticles <= 50; ++countparticles) {
                        Random rand = new Random();
                        world.addParticle(ParticleTypes.EXPLOSION, pos.getX() + (rand.nextDouble()), pos.getY() + (rand.nextDouble()), pos.getZ() + (rand.nextDouble()), 0.1, 0.1, 0.1);
                    }

                    playerEntity.getCooldownTracker().setCooldown(playerMain, 20);

                    if (!world.isRemote) {
                        double d0 = livingEntity.getPosX();
                        double d1 = livingEntity.getPosY();
                        double d2 = livingEntity.getPosZ();

                        world.playSound((PlayerEntity) null, d0, d1, d2, SoundEvents.ENTITY_GENERIC_EXPLODE, SoundCategory.PLAYERS, 1.0F, 1.0F);
                        livingEntity.playSound(SoundEvents.ENTITY_GENERIC_EXPLODE, 1.0F, 1.0F);
                    }
                }
            } else if (playerMain == dustBags[3] && block == RegistryHandler.STAGE3_BLOCK.get()) {
                ZorumTweaks.LOGGER.info("RightclickEvent passed");
                world.setBlockState(pos, RegistryHandler.STAGE4_BLOCK.get().getDefaultState());

                playerEntity.inventory.clearMatchingItems(item -> item.getItem().equals(playerMain), 1);
                playerEntity.sendStatusMessage(new StringTextComponent("Success!").applyTextStyle(TextFormatting.GREEN), true);


                for (int countparticles = 0; countparticles <= 100; ++countparticles) {
                    Random rand = new Random();
                    world.addParticle(ParticleTypes.EFFECT, pos.getX() + (rand.nextDouble()), pos.getY() + (rand.nextDouble()), pos.getZ() + (rand.nextDouble()), 0.1, 0.1, 0.1);
                }

                playerEntity.getCooldownTracker().setCooldown(playerMain, 20);

                if (!world.isRemote) {
                    double d0 = livingEntity.getPosX();
                    double d1 = livingEntity.getPosY();
                    double d2 = livingEntity.getPosZ();

                    world.playSound((PlayerEntity) null, d0, d1, d2, SoundEvents.ENTITY_FIREWORK_ROCKET_LARGE_BLAST, SoundCategory.PLAYERS, 1.0F, 1.0F);
                    livingEntity.playSound(SoundEvents.ENTITY_FIREWORK_ROCKET_LARGE_BLAST, 1.0F, 1.0F);
                }
            }
        }

        /** STAGE 4 **/
        if (playerEntity.getCooldownTracker().hasCooldown(dustBags[4]) != true && playerEntity.getCooldownTracker().hasCooldown(dustBags[3]) != true) {
            if (playerMain != dustBags[4] && block == RegistryHandler.STAGE4_BLOCK.get()) {
                if (playerMain == dustBags[0] || playerMain == dustBags[2] || playerMain == dustBags[1] || playerMain == dustBags[3]) {


                    ZorumTweaks.LOGGER.info("RightclickEvent passed");
                    world.setBlockState(pos, RegistryHandler.FAILED_PROTOTYPE_BLOCK.get().getDefaultState());

                    playerEntity.inventory.clearMatchingItems(item -> item.getItem().equals(playerMain), 1);
                    playerEntity.sendStatusMessage(new StringTextComponent("Failure").applyTextStyle(TextFormatting.RED), true);

                    for (int countparticles = 0; countparticles <= 50; ++countparticles) {
                        Random rand = new Random();
                        world.addParticle(ParticleTypes.EXPLOSION, pos.getX() + (rand.nextDouble()), pos.getY() + (rand.nextDouble()), pos.getZ() + (rand.nextDouble()), 0.1, 0.1, 0.1);
                    }

                    playerEntity.getCooldownTracker().setCooldown(playerMain, 20);

                    if (!world.isRemote) {
                        double d0 = livingEntity.getPosX();
                        double d1 = livingEntity.getPosY();
                        double d2 = livingEntity.getPosZ();

                        world.playSound((PlayerEntity) null, d0, d1, d2, SoundEvents.ENTITY_GENERIC_EXPLODE, SoundCategory.PLAYERS, 1.0F, 1.0F);
                        livingEntity.playSound(SoundEvents.ENTITY_GENERIC_EXPLODE, 1.0F, 1.0F);
                    }
                }
            } else if (playerMain == dustBags[4] && block == RegistryHandler.STAGE4_BLOCK.get()) {
                ZorumTweaks.LOGGER.info("RightclickEvent passed");
                world.setBlockState(pos, RegistryHandler.UNIVERSE_ORE_BLOCK.get().getDefaultState());

                playerEntity.inventory.clearMatchingItems(item -> item.getItem().equals(playerMain), 1);
                playerEntity.sendStatusMessage(new StringTextComponent("Success!").applyTextStyle(TextFormatting.GREEN), true);


                for (int countparticles = 0; countparticles <= 100; ++countparticles) {
                    Random rand = new Random();
                    world.addParticle(ParticleTypes.EFFECT, pos.getX() + (rand.nextDouble()), pos.getY() + (rand.nextDouble()), pos.getZ() + (rand.nextDouble()), 0.1, 0.1, 0.1);
                    world.addParticle(ParticleTypes.POOF, pos.getX() + (rand.nextDouble()), pos.getY() + (rand.nextDouble()), pos.getZ() + (rand.nextDouble()), 0.1, 0.1, 0.1);

                }

                playerEntity.getCooldownTracker().setCooldown(playerMain, 20);

                if (!world.isRemote) {
                    double d0 = livingEntity.getPosX();
                    double d1 = livingEntity.getPosY();
                    double d2 = livingEntity.getPosZ();

                    world.playSound((PlayerEntity) null, d0, d1, d2, SoundEvents.ITEM_TOTEM_USE, SoundCategory.PLAYERS, 1.0F, 1.0F);
                    livingEntity.playSound(SoundEvents.ITEM_TOTEM_USE, 1.0F, 1.0F);
                }
            }
        }
    }

}
