package com.elitethaumaturge.zorumtweaks.blocks;

import com.elitethaumaturge.zorumtweaks.ZorumTweaks;
import com.elitethaumaturge.zorumtweaks.other.KeyboardHelper;
import com.elitethaumaturge.zorumtweaks.util.RegistryHandler;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.common.ToolType;

import java.util.Random;

public class SoundTestBlock extends Block {
    public SoundTestBlock() {
        super(Properties.create(Material.WOOL)
                .hardnessAndResistance(-1.0f, 60.0f)
                .sound(SoundType.CLOTH)
                .harvestTool(ToolType.PICKAXE)
                .noDrops()
        );
    }

    private int soundStage = 0;

    @Override
    public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {

        Block block = worldIn.getBlockState(pos).getBlock();


            double d0 = player.getPosX();
            double d1 = player.getPosY();
            double d2 = player.getPosZ();

            if (KeyboardHelper.isHoldingShift()) {
                soundStage++;
                soundStage %= 5;
            }

            player.sendStatusMessage(new StringTextComponent("Sound Number: " + soundStage).applyTextStyle(TextFormatting.GRAY), true);

            if (!KeyboardHelper.isHoldingShift() && !worldIn.isRemote) {
                switch (soundStage) {
                    case 0:
                        worldIn.playSound((PlayerEntity) null, d0, d1, d2, RegistryHandler.TEST_SOUND.get(), SoundCategory.PLAYERS, 1.0F, 1.0F);
                        player.playSound(RegistryHandler.TEST_SOUND.get(), 1.0F, 1.0F);
                        break;

                    case 1:
                        worldIn.playSound((PlayerEntity) null, d0, d1, d2, RegistryHandler.VOID_WALKER_WHISPER.get(), SoundCategory.PLAYERS, 1.0F, 1.0F);
                        player.playSound(RegistryHandler.VOID_WALKER_WHISPER.get(), 1.0F, 1.0F);
                        break;

                    case 2:
                        worldIn.playSound((PlayerEntity) null, d0, d1, d2, RegistryHandler.VOID_WALKER_HURT.get(), SoundCategory.PLAYERS, 1.0F, 1.0F);
                        player.playSound(RegistryHandler.VOID_WALKER_HURT.get(), 1.0F, 1.0F);
                        break;

                    case 3:
                        worldIn.playSound((PlayerEntity) null, d0, d1, d2, RegistryHandler.VOID_WALKER_DEATH.get(), SoundCategory.PLAYERS, 1.0F, 1.0F);
                        player.playSound(RegistryHandler.VOID_WALKER_DEATH.get(), 1.0F, 1.0F);
                        break;

                    case 4:
                        worldIn.playSound((PlayerEntity) null, d0, d1, d2, RegistryHandler.VOID_WALKER_STEP.get(), SoundCategory.PLAYERS, 1.0F, 1.0F);
                        player.playSound(RegistryHandler.VOID_WALKER_STEP.get(), 1.0F, 1.0F);
                        break;
            }
        }

        return super.onBlockActivated(state, worldIn, pos, player, handIn, hit);
    }
}
