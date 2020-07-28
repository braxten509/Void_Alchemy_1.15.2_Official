package com.elitethaumaturge.zorumtweaks.blocks;

import com.elitethaumaturge.zorumtweaks.ZorumTweaks;
import com.elitethaumaturge.zorumtweaks.util.RegistryHandler;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.common.ToolType;

import java.util.Random;

public class CrimsonKeyBlock extends Block {
    public CrimsonKeyBlock() {
        super(Block.Properties.create(Material.ROCK)
                .hardnessAndResistance(-1.0f, 60.0f)
                .sound(SoundType.STONE)
                .harvestTool(ToolType.PICKAXE)
                .noDrops()
        );
    }

    @Override
    public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
        //Crimson Block being right clicked with key
        Block block = worldIn.getBlockState(pos).getBlock();

        if (player.getHeldItemMainhand().getItem() == RegistryHandler.CRIMSON_KEY.get()) {
            ZorumTweaks.LOGGER.info("RightclickEvent passed");
            worldIn.setBlockState(pos, Blocks.AIR.getDefaultState());

            //particles
            for(int countparticles = 0; countparticles <= 100; ++countparticles) {
                Random rand = new Random();
                worldIn.addParticle(ParticleTypes.POOF,pos.getX() + (rand.nextDouble()), pos.getY() + (rand.nextDouble()), pos.getZ()+ (rand.nextDouble()), 0.1, 0.1, 0.1);
            }

            player.inventory.clearMatchingItems(item -> item.getItem().equals(player.getHeldItemMainhand().getItem()), 1);


            if (!worldIn.isRemote) {
                double d0 = player.getPosX();
                double d1 = player.getPosY();
                double d2 = player.getPosZ();

                worldIn.playSound((PlayerEntity)null, d0, d1, d2, SoundEvents.BLOCK_ANVIL_USE, SoundCategory.PLAYERS, 1.0F, 1.0F);
                player.playSound(SoundEvents.BLOCK_ANVIL_USE, 1.0F, 1.0F);
            }
        }
        return super.onBlockActivated(state, worldIn, pos, player, handIn, hit);
    }
}
