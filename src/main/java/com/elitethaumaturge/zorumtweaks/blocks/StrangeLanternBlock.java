package com.elitethaumaturge.zorumtweaks.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class StrangeLanternBlock extends Block {
    public StrangeLanternBlock() {
        //be sure to change 'Material.' to whatever type of material you are using
        super(Properties.create(Material.GLASS)
                .hardnessAndResistance(0.4f, 3.0f)
                .sound(SoundType.GLASS)
                .harvestLevel(0)
                .lightValue(15)
        );
    }
}

