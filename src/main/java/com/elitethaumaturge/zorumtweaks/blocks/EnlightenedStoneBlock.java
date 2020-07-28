package com.elitethaumaturge.zorumtweaks.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

public class EnlightenedStoneBlock extends Block {
    public EnlightenedStoneBlock() {
        super(Properties.create(Material.ROCK)
                .hardnessAndResistance(8.0f, 100.0f)
                .harvestLevel(3)
                .sound(SoundType.STONE)
                .lightValue(10)
                .harvestTool(ToolType.PICKAXE)
        );
    }
}
