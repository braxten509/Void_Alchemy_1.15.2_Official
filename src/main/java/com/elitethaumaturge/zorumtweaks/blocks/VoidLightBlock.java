package com.elitethaumaturge.zorumtweaks.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

public class VoidLightBlock extends Block {
    public VoidLightBlock() {
        //be sure to change 'Material.' to whatever type of material you are using
        super(Properties.create(Material.ROCK)
                .hardnessAndResistance(1.0f, 30.0f)
                .sound(SoundType.GLASS)
                .harvestTool(ToolType.PICKAXE)
                .harvestLevel(2)
                .lightValue(15)
        );
    }
}

