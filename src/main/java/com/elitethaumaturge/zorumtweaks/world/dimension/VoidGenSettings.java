package com.elitethaumaturge.zorumtweaks.world.dimension;

import com.elitethaumaturge.zorumtweaks.util.RegistryHandler;
import net.minecraft.block.Blocks;
import net.minecraft.world.gen.GenerationSettings;

public class VoidGenSettings extends GenerationSettings {

    public int getBiomeSize() {
        return 4;
    }

    public int getRiverSize() {
        return 0;
    }

    public int getBiomeId() {
        return -2;
    }

    @Override
    public int getBedrockFloorHeight() {
        return 0;
    }

}
