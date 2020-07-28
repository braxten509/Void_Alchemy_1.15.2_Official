package com.elitethaumaturge.zorumtweaks.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

public class StrangeOreBlock extends Block {
    public StrangeOreBlock() {
        super(Properties.create(Material.ROCK)
                .hardnessAndResistance(4.0f, 60.0f)
                .harvestLevel(3)
                .sound(SoundType.STONE)
                .harvestTool(ToolType.PICKAXE)
        );
    }
}
