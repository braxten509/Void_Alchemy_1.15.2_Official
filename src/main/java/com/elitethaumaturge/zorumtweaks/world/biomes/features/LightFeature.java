package com.elitethaumaturge.zorumtweaks.world.biomes.features;

import net.minecraft.block.Blocks;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.BlockBlobConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.placement.FrequencyConfig;
import net.minecraft.world.gen.placement.Placement;

public class LightFeature {

    public static void addVoidLight(Biome biomeIn) {
        biomeIn.addFeature(GenerationStage.Decoration.LOCAL_MODIFICATIONS, Feature.FOREST_ROCK.withConfiguration(new BlockBlobConfig(Blocks.GLOWSTONE.getDefaultState(), 0)).withPlacement(Placement.FOREST_ROCK.configure(new FrequencyConfig(1))));
    }
}
