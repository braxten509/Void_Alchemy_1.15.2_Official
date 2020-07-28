package com.elitethaumaturge.zorumtweaks.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

public class PrototypeBlock extends Block {
    public PrototypeBlock() {
        super(Properties.create(Material.ROCK)
                .hardnessAndResistance(4.0f, 60.0f)
                .harvestLevel(2)
                .sound(SoundType.STONE)
                .harvestTool(ToolType.PICKAXE)
        );
    }
}
