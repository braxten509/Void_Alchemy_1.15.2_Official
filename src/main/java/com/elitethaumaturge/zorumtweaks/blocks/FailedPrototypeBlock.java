package com.elitethaumaturge.zorumtweaks.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraftforge.common.ToolType;
import java.util.stream.Stream;

public class FailedPrototypeBlock extends Block {

    //Get voxel shape of the block
    public static final VoxelShape SHAPE = Stream.of(
            Block.makeCuboidShape(0, 0, 0, 16, 4, 16),
            Block.makeCuboidShape(0, 4, 0, 14, 6, 16),
            Block.makeCuboidShape(0, 6, 0, 12, 8, 16),
            Block.makeCuboidShape(2, 8, 0, 8, 10, 13),
            Block.makeCuboidShape(2, 10, 0, 8, 12, 13),
            Block.makeCuboidShape(2, 12, 0, 8, 14, 11),
            Block.makeCuboidShape(4, 14, 0, 8, 16, 9),
            Block.makeCuboidShape(2, 14, 4, 4, 16, 9),
            Block.makeCuboidShape(8, 8, 0, 16, 10, 9),
            Block.makeCuboidShape(8, 10, 0, 14, 14, 7),
            Block.makeCuboidShape(8, 14, 0, 14, 16, 4),
            Block.makeCuboidShape(8, 8, 9, 10, 10, 11),
            Block.makeCuboidShape(10, 8, 9, 12, 10, 11),
            Block.makeCuboidShape(14, 10, 4, 16, 12, 6),
            Block.makeCuboidShape(10, 10, 7, 12, 12, 9),
            Block.makeCuboidShape(8, 10, 7, 10, 12, 11),
            Block.makeCuboidShape(14, 10, 0, 16, 14, 4),
            Block.makeCuboidShape(0, 8, 0, 2, 10, 15),
            Block.makeCuboidShape(0, 10, 0, 2, 12, 13),
            Block.makeCuboidShape(0, 12, 2, 2, 14, 13),
            Block.makeCuboidShape(8, 8, 11, 10, 10, 13),
            Block.makeCuboidShape(2, 12, 11, 6, 14, 13),
            Block.makeCuboidShape(2, 8, 13, 6, 10, 15),
            Block.makeCuboidShape(14, 4, 0, 16, 6, 14),
            Block.makeCuboidShape(12, 6, 0, 16, 8, 12)
    ).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();

    public FailedPrototypeBlock() {
        super(Block.Properties.create(Material.ROCK)
                .hardnessAndResistance(4.0f, 60.0f)
                .harvestLevel(2)
                .sound(SoundType.STONE)
                .harvestTool(ToolType.PICKAXE)
        );    }

    @Override
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        return SHAPE;
    }

    @Override
    public float getAmbientOcclusionLightValue(BlockState state, IBlockReader worldIn, BlockPos pos) {
        return 0.6f;
    }
}
