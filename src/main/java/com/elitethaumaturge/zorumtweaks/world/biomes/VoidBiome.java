package com.elitethaumaturge.zorumtweaks.world.biomes;

import com.elitethaumaturge.zorumtweaks.util.RegistryHandler;
import com.elitethaumaturge.zorumtweaks.world.biomes.features.LightFeature;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.BlockBlobConfig;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.placement.*;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;


public class VoidBiome extends Biome {

    public VoidBiome(Builder biomeBuilder) {
        super(biomeBuilder
                .precipitation(RainType.NONE)
                .downfall(0f)
                .scale(0.01f)
                .waterColor(000000)
                .waterFogColor(000000)
                .temperature(0.5f)
                //.surfaceBuilder(SurfaceBuilder.DEFAULT, new SurfaceBuilderConfig(Blocks.GRASS_BLOCK.getDefaultState(), Blocks.GRASS_BLOCK.getDefaultState(), Blocks.GRASS_BLOCK.getDefaultState()))

                .surfaceBuilder(SurfaceBuilder.DEFAULT, new SurfaceBuilderConfig(RegistryHandler.VOID_BLOCK.get().getDefaultState(), RegistryHandler.VOID_BLOCK.get().getDefaultState(), RegistryHandler.VOID_BLOCK.get().getDefaultState()))
                .category(Category.PLAINS)
                .depth(0.125f)
                .parent(null)
        );

        DefaultBiomeFeatures.addOres(this);

        this.addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(EntityType.ENDERMAN, 10, 2, 8));

        addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.FOREST_ROCK.withConfiguration(new BlockBlobConfig(RegistryHandler.VOID_LIGHT_BLOCK.get().getDefaultState(), 0)).withPlacement(Placement.FOREST_ROCK.configure(new FrequencyConfig(10))));

        //addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature..withConfiguration(new BlockBlobConfig(Blocks.GLOWSTONE.getDefaultState(), 0)).withPlacement(Placement.FOREST_ROCK.configure(new FrequencyConfig(10))));
        //addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(DEAD_BUSH_CONFIG).withPlacement(Placement.COUNT_HEIGHTMAP_DOUBLE.configure(new FrequencyConfig(2))));

        //ConfiguredPlacement customConfig2 = Placement.COUNT_RANGE.configure(new CountRangeConfig(3, 0,0,30));
        //addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.BLOCK_PILE.withConfiguration(new BlockBlobConfig(Blocks.GLOWSTONE.getDefaultState(),1)));

    }

    @Override
    public void addFeature(GenerationStage.Decoration decorationStage, ConfiguredFeature<?, ?> featureIn) {
        //addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.BLOCK_PILE.withConfiguration(LightFeature.).withChance(1f));
        super.addFeature(decorationStage, featureIn);
    }

    @OnlyIn(Dist.CLIENT)
    public int getFoliageColor() {
        return 000000;
    }

    @OnlyIn(Dist.CLIENT)
    public int getGrassColor(double posX, double posZ) {
        return 000000;
    }



}
