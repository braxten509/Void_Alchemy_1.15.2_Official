package com.elitethaumaturge.zorumtweaks.world.dimension;

import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.dimension.Dimension;
import net.minecraft.world.dimension.DimensionType;
import net.minecraft.world.gen.ChunkGenerator;

import javax.annotation.Nullable;

public class VoidDimension extends Dimension {

    public VoidDimension(World world, DimensionType type) {
        super(world, type, 0.0f);
    }

    @Override
    public ChunkGenerator<?> createChunkGenerator() {
        return new VoidChunkGenerator(world, new VoidBiomeProvider(), new VoidGenSettings());
    }

    @Nullable
    @Override
    public BlockPos findSpawn(ChunkPos chunkPosIn, boolean checkValid) {
        return null;
    }

    @Nullable
    @Override
    public BlockPos findSpawn(int posX, int posZ, boolean checkValid) {
        return null;
    }

    @Override
    public float calculateCelestialAngle(long worldTime, float partialTicks) {
        return 0.0F;
    }

    @Override
    public boolean isSurfaceWorld() {
        return false;
    }

    @Override
    public Vec3d getFogColor(float celestialAngle, float partialTicks) {
        return Vec3d.ZERO;
    }

    @Override
    public boolean canRespawnHere() {
        return false;
    }

    @Override
    public boolean doesXZShowFog(int x, int z) {
        // (VoidMagic.researchPoints < 4) {
            return true;
       // } else {
            //return false;
        //}
    }

    @Override
    public boolean canDoRainSnowIce(Chunk chunk) {
        return false;
    }

    /*@Override
    public double getVoidFogYFactor() {
        return super.getVoidFogYFactor();
    }*/

    @Nullable
    @Override
    public float[] calcSunriseSunsetColors(float celestialAngle, float partialTicks) {
        return super.calcSunriseSunsetColors(celestialAngle, partialTicks);
    }

    //@Override
    //public boolean isDaytime() {
        //return false;
    //}

    //Endermen are peaceful creatures
    @Override
    public void setAllowedSpawnTypes(boolean allowHostile, boolean allowPeaceful) {
        allowHostile = true;
        allowPeaceful = true;
    }

}
