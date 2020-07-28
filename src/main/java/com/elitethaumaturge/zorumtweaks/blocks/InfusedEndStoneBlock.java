package com.elitethaumaturge.zorumtweaks.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

public class InfusedEndStoneBlock extends Block {
    public InfusedEndStoneBlock() {
        super(Properties.create(Material.ROCK)
                .hardnessAndResistance(8.0f, 80.0f)
                .harvestLevel(3)
                .sound(SoundType.STONE)
                .harvestTool(ToolType.PICKAXE)
        );
    }
}
