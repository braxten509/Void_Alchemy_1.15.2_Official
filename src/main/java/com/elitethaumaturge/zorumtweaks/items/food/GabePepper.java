package com.elitethaumaturge.zorumtweaks.items.food;

import com.elitethaumaturge.zorumtweaks.ZorumTweaks;
import com.elitethaumaturge.zorumtweaks.items.ItemBase;
import com.elitethaumaturge.zorumtweaks.util.RegistryHandler;
import com.elitethaumaturge.zorumtweaks.world.dimension.VoidTeleporter;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ChorusFruitItem;
import net.minecraft.world.dimension.DimensionType;
import com.elitethaumaturge.zorumtweaks.world.dimension.VoidTeleporter;
import net.minecraftforge.common.util.ITeleporter;


import javax.swing.*;


//duration is in ticks

public class GabePepper extends Item {
    public GabePepper() {

        //Anything in the 'event.getRegistry().register' from the video goes in the super!
        super(new Item.Properties().group(ZorumTweaks.TAB).food(new Food.Builder()
                .hunger(6)
                .saturation(6)
                .setAlwaysEdible()
                .effect(new EffectInstance(Effects.WITHER, 120, 1), 0.8f)
                .build()
        ));



    }

    public ItemStack onItemUseFinish(ItemStack stack, World worldIn, LivingEntity entityLiving) {
        ItemStack itemstack = super.onItemUseFinish(stack, worldIn, entityLiving);

        if (!worldIn.isRemote) {
            double d0 = entityLiving.getPosX();
            double d1 = entityLiving.getPosY();
            double d2 = entityLiving.getPosZ();

            worldIn.playSound((PlayerEntity)null, d0, d1, d2, SoundEvents.ENTITY_GHAST_SCREAM, SoundCategory.PLAYERS, 1.0F, 1.0F);
            entityLiving.playSound(SoundEvents.BLOCK_GLASS_BREAK, 1.0F, 1.0F);

            if (entityLiving instanceof PlayerEntity) {
                ((PlayerEntity)entityLiving).getCooldownTracker().setCooldown(this, 20);
            }
        }

        return itemstack;
    }

}
