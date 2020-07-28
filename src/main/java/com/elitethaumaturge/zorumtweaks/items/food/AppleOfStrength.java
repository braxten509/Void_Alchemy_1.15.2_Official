package com.elitethaumaturge.zorumtweaks.items.food;

import com.elitethaumaturge.zorumtweaks.ZorumTweaks;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.world.World;


//duration is in ticks

public class AppleOfStrength extends Item {
    public AppleOfStrength() {

        //Anything in the 'event.getRegistry().register' from the video goes in the super!
        super(new Properties().group(ZorumTweaks.TAB).food(new Food.Builder()
                .hunger(20)
                .saturation(20)
                .setAlwaysEdible()
                .effect(new EffectInstance(Effects.ABSORPTION, 3600, 1), 1f)
                .effect(new EffectInstance(Effects.HEALTH_BOOST, 3600, 5), 1f)
                .effect(new EffectInstance(Effects.STRENGTH, 3600, 1), 1f)
                .effect(new EffectInstance(Effects.REGENERATION, 3600, 0), 1f)
                .build()
        ));



    }

    public ItemStack onItemUseFinish(ItemStack stack, World worldIn, LivingEntity entityLiving) {
        ItemStack itemstack = super.onItemUseFinish(stack, worldIn, entityLiving);

        if (!worldIn.isRemote) {
            double d0 = entityLiving.getPosX();
            double d1 = entityLiving.getPosY();
            double d2 = entityLiving.getPosZ();

            worldIn.playSound((PlayerEntity)null, d0, d1, d2, SoundEvents.ENTITY_LIGHTNING_BOLT_THUNDER, SoundCategory.PLAYERS, 1.0F, 1.0F);
            entityLiving.playSound(SoundEvents.ENTITY_LIGHTNING_BOLT_THUNDER, 1.0F, 1.0F);

            if (entityLiving instanceof PlayerEntity) {
                ((PlayerEntity)entityLiving).getCooldownTracker().setCooldown(this, 20);
            }
        }

        return itemstack;
    }

}
