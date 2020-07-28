package com.elitethaumaturge.zorumtweaks.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

public class InfusedNetherrackBlock extends Block {
    public InfusedNetherrackBlock() {
        super(Properties.create(Material.ROCK)
                .hardnessAndResistance(2.0f, 30.0f)
                .harvestLevel(2)
                .sound(SoundType.STONE)
                .harvestTool(ToolType.PICKAXE)
        );
    }
}
