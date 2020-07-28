package com.elitethaumaturge.zorumtweaks.events;

import com.elitethaumaturge.zorumtweaks.ZorumTweaks;
import com.elitethaumaturge.zorumtweaks.util.RegistryHandler;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
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
public class RightClickBlock {

    private static java.util.function.Predicate<ItemStack> Predicate;
    private static Object ItemStack;

    @SubscribeEvent
    public static void rightClickBlock(PlayerInteractEvent.RightClickBlock event) {

        //world.setBlockState()
        //ZorumTweaks.LOGGER.info(world.getBlockState(pos).getBlock());
        LivingEntity livingEntity = event.getEntityLiving();
        PlayerEntity playerEntity = event.getPlayer();
        World world = livingEntity.getEntityWorld();
        BlockPos pos = event.getPos();
        Block block = world.getBlockState(pos).getBlock();

        Item[] dustBags = {RegistryHandler.BAG_OF_ALCHEMICAL_DUST.get(), RegistryHandler.BAG_OF_ARCAMIRUS_DUST.get(),
                RegistryHandler.BAG_OF_ETHEREAL_DUST.get(), RegistryHandler.BAG_OF_MIRCANTERS_DUST.get(), RegistryHandler.BAG_OF_VOID_DUST.get()};

        Item playerMain = playerEntity.getHeldItemMainhand().getItem();



        /** ZORUMITE ORE **/
        if (playerMain == dustBags[0] && block == Blocks.IRON_ORE) {

            ZorumTweaks.LOGGER.info("RightclickEvent passed");
            world.setBlockState(pos, RegistryHandler.ZORUMITE_ORE_BLOCK.get().getDefaultState());

            playerEntity.inventory.clearMatchingItems(item -> item.getItem().equals((RegistryHandler.BAG_OF_ALCHEMICAL_DUST).get()), 1);

            for(int countparticles = 0; countparticles <= 100; ++countparticles) {
                Random rand = new Random();
                world.addParticle(ParticleTypes.INSTANT_EFFECT, pos.getX() + (rand.nextDouble()), pos.getY() + (rand.nextDouble()), pos.getZ()+ (rand.nextDouble()), 0.1, 0.1, 0.1);
            }

            if (!world.isRemote) {
                double d0 = livingEntity.getPosX();
                double d1 = livingEntity.getPosY();
                double d2 = livingEntity.getPosZ();

                world.playSound((PlayerEntity)null, d0, d1, d2, SoundEvents.BLOCK_LAVA_EXTINGUISH, SoundCategory.PLAYERS, 1.0F, 1.0F);
                livingEntity.playSound(SoundEvents.BLOCK_LAVA_EXTINGUISH, 1.0F, 1.0F);
            }
        }



        /** STRANGE ORE **/
        if (playerMain == dustBags[1] && block == Blocks.GOLD_ORE) {

            ZorumTweaks.LOGGER.info("RightclickEvent passed");
            world.setBlockState(pos, RegistryHandler.STRANGE_ORE_BLOCK.get().getDefaultState());

            //predicate of an itemStack: item -> item.getItem.equals(Items.WHEAT), takes 1 alchemical dust away
            playerEntity.inventory.clearMatchingItems(item -> item.getItem().equals((RegistryHandler.BAG_OF_ARCAMIRUS_DUST).get()), 1);


            //particles
            for(int countparticles = 0; countparticles <= 100; ++countparticles) {
                Random rand = new Random();
                world.addParticle(ParticleTypes.INSTANT_EFFECT, pos.getX() + (rand.nextDouble()), pos.getY() + (rand.nextDouble()), pos.getZ()+ (rand.nextDouble()), 0.1, 0.1, 0.1);
            }

            if (!world.isRemote) {
                double d0 = livingEntity.getPosX();
                double d1 = livingEntity.getPosY();
                double d2 = livingEntity.getPosZ();

                world.playSound((PlayerEntity)null, d0, d1, d2, SoundEvents.BLOCK_LAVA_EXTINGUISH, SoundCategory.PLAYERS, 1.0F, 1.0F);
                livingEntity.playSound(SoundEvents.BLOCK_LAVA_EXTINGUISH, 1.0F, 1.0F);
            }



        }

        //Enlightened Stone
        if (playerMain == dustBags[3] && block == RegistryHandler.FORLORN_STONE_BLOCK.get()) {

            ZorumTweaks.LOGGER.info("RightclickEvent passed");
            world.setBlockState(pos, RegistryHandler.ENLIGHTENED_STONE_BLOCK.get().getDefaultState());

            playerEntity.inventory.clearMatchingItems(item -> item.getItem().equals((RegistryHandler.BAG_OF_MIRCANTERS_DUST).get()), 1);

            for(int countparticles = 0; countparticles <= 100; ++countparticles) {
                Random rand = new Random();
                world.addParticle(ParticleTypes.INSTANT_EFFECT, pos.getX() + (rand.nextDouble()), pos.getY() + (rand.nextDouble()), pos.getZ()+ (rand.nextDouble()), 0.1, 0.1, 0.1);
            }

            if (!world.isRemote) {
                double d0 = livingEntity.getPosX();
                double d1 = livingEntity.getPosY();
                double d2 = livingEntity.getPosZ();

                playerEntity.sendStatusMessage(new StringTextComponent("[Enlightened Stone] Thank you...").applyTextStyle(TextFormatting.WHITE), false);

                world.playSound((PlayerEntity)null, d0, d1, d2, RegistryHandler.TEST_SOUND.get(), SoundCategory.PLAYERS, 1.0F, 1.0F);
                livingEntity.playSound(RegistryHandler.TEST_SOUND.get(), 1.0F, 1.0F);
            }
        }








    }
}
