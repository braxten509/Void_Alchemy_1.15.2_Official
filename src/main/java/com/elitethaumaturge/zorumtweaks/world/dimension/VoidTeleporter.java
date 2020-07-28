package com.elitethaumaturge.zorumtweaks.world.dimension;

import net.minecraft.block.pattern.BlockPattern;
import net.minecraft.entity.Entity;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.Teleporter;
import net.minecraft.world.server.ServerWorld;

import javax.annotation.Nullable;
import java.util.Random;


public class VoidTeleporter extends Teleporter {

    public VoidTeleporter(ServerWorld worldIn) {
        super(worldIn);
    }

    @Override
    public boolean makePortal(Entity entityIn) {
        return true;
    }

    @Override
    public boolean placeInPortal(Entity p_222268_1_, float p_222268_2_) {
        return false;
    }

}
