package com.elitethaumaturge.zorumtweaks.world.dimension;

import com.elitethaumaturge.zorumtweaks.util.RegistryHandler;
import com.google.common.collect.ImmutableSet;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.biome.provider.BiomeProvider;

import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class VoidBiomeProvider extends BiomeProvider {

    private Random rand;

    //rivate static final List<Biome> SPAWN = Collections.singletonList(RegistryHandler.VOID_BIOME.get());

    public VoidBiomeProvider() {
        super(biomeList);
        rand = new Random();
    }

    private static final Set<Biome> biomeList = ImmutableSet.of(RegistryHandler.VOID_BIOME.get());

    @Override
    public Biome getNoiseBiome(int x, int y, int z) {
        return RegistryHandler.VOID_BIOME.get();
    }


}
