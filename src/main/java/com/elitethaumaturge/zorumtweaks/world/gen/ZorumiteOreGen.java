package com.elitethaumaturge.zorumtweaks.world.gen;

import com.elitethaumaturge.zorumtweaks.ZorumTweaks;
import com.elitethaumaturge.zorumtweaks.util.RegistryHandler;
import net.minecraft.block.Blocks;
import net.minecraft.block.pattern.BlockMatcher;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.biome.ForestBiome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.placement.ConfiguredPlacement;
import net.minecraft.world.gen.placement.CountRangeConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.registries.ForgeRegistries;
import org.apache.logging.log4j.core.config.CustomLevelConfig;

public class ZorumiteOreGen {
    public static void generateOre() {
        for (Biome biome : ForgeRegistries.BIOMES) {
            ConfiguredPlacement customConfig = Placement.COUNT_RANGE.configure(new CountRangeConfig(2, 0,0,30));
            biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, RegistryHandler.ALCHEMICAL_ORE_BLOCK.get().getDefaultState(), 6)).withPlacement(customConfig));

            if (biome == RegistryHandler.VOID_BIOME.get()) {
                //change filler block to void
                ConfiguredPlacement customConfig2 = Placement.COUNT_RANGE.configure(new CountRangeConfig(2, 0,0,30));
                biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, RegistryHandler.ARCAMIRUS_ORE_BLOCK.get().getDefaultState(), 6)).withPlacement(customConfig2));

                ConfiguredPlacement customConfig4 = Placement.COUNT_RANGE.configure(new CountRangeConfig(1, 0,0,20));
                biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, RegistryHandler.FORLORN_STONE_BLOCK.get().getDefaultState(), 4)).withPlacement(customConfig4));
            }
                //change filler block to void
                ConfiguredPlacement customConfig3 = Placement.COUNT_RANGE.configure(new CountRangeConfig(100, 0,0,200));
                biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NETHERRACK, RegistryHandler.INFUSED_NETHERRACK_BLOCK.get().getDefaultState(), 3)).withPlacement(customConfig3));

            Biomes.END_HIGHLANDS.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(
                    new OreFeatureConfig(OreFeatureConfig.FillerBlockType.create("end_stone", null, new BlockMatcher(Blocks.END_STONE)), RegistryHandler.INFUSED_END_STONE_BLOCK.get().getDefaultState(), 3)).withPlacement(Placement.COUNT_RANGE.configure(
                    new CountRangeConfig(1, 0, 0, 200))));

            Biomes.END_BARRENS.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(
                    new OreFeatureConfig(OreFeatureConfig.FillerBlockType.create("end_stone", null, new BlockMatcher(Blocks.END_STONE)), RegistryHandler.INFUSED_END_STONE_BLOCK.get().getDefaultState(), 3)).withPlacement(Placement.COUNT_RANGE.configure(
                    new CountRangeConfig(1, 0, 0, 200))));

            Biomes.END_MIDLANDS.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(
                    new OreFeatureConfig(OreFeatureConfig.FillerBlockType.create("end_stone", null, new BlockMatcher(Blocks.END_STONE)), RegistryHandler.INFUSED_END_STONE_BLOCK.get().getDefaultState(), 3)).withPlacement(Placement.COUNT_RANGE.configure(
                    new CountRangeConfig(1, 0, 0, 200))));

            Biomes.SMALL_END_ISLANDS.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(
                    new OreFeatureConfig(OreFeatureConfig.FillerBlockType.create("end_stone", null, new BlockMatcher(Blocks.END_STONE)), RegistryHandler.INFUSED_END_STONE_BLOCK.get().getDefaultState(), 3)).withPlacement(Placement.COUNT_RANGE.configure(
                    new CountRangeConfig(1, 0, 0, 200))));
        }
    }
}
