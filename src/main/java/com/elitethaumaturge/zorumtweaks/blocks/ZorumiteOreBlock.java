package com.elitethaumaturge.zorumtweaks.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

public class ZorumiteOreBlock extends Block {
    public ZorumiteOreBlock() {
        super(Block.Properties.create(Material.ROCK)
                .hardnessAndResistance(6.0f, 40.0f)
                .harvestLevel(2)
                .sound(SoundType.STONE)
                .harvestTool(ToolType.PICKAXE)
        );
    }
}
