package com.elitethaumaturge.zorumtweaks.entities;

import com.elitethaumaturge.zorumtweaks.util.RegistryHandler;
import net.minecraft.block.BlockState;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Difficulty;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import javax.swing.text.MutableAttributeSet;

public class VoidWalkerEntity extends MonsterEntity {

    public VoidWalkerEntity(EntityType<? extends MonsterEntity> type, World worldIn) {
        super(type, worldIn);
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(3, new LookAtGoal(this, PlayerEntity.class, 8.0F));
        this.goalSelector.addGoal(3, new LookRandomlyGoal(this));
        this.goalSelector.addGoal(1, new SwimGoal(this));
        this.goalSelector.addGoal(4, new WaterAvoidingRandomWalkingGoal(this, 1.0D));
        this.goalSelector.addGoal(5, new MeleeAttackGoal(this, 1.0D, false));
        //this.targetSelector.addGoal(1, (new HurtByTargetGoal(this)).setCallsForHelp());
        this.targetSelector.addGoal(10, new NearestAttackableTargetGoal<>(this, PlayerEntity.class, true));

    }

    protected void setEquipmentBasedOnDifficulty(DifficultyInstance difficulty) {
        super.setEquipmentBasedOnDifficulty(difficulty);
        if (this.world.getDifficulty() == Difficulty.HARD || this.world.getDifficulty() == Difficulty.NORMAL || this.world.getDifficulty() == Difficulty.EASY) {
            int i = this.rand.nextInt(3);

                this.setItemStackToSlot(EquipmentSlotType.MAINHAND, new ItemStack(Items.IRON_SWORD));

        }

    }

    @Override
    protected void registerAttributes() {
        super.registerAttributes();
        this.getAttribute(SharedMonsterAttributes.ARMOR_TOUGHNESS).setBaseValue(8);
        this.getAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(20);
        this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(10);
        this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(50);
        this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue((double)0.4F);
        this.getAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(40);
    }

    @Override
    protected void updateAITasks() {
        super.updateAITasks();
    }

    @Nullable
    @Override
    protected SoundEvent getAmbientSound() {
        return RegistryHandler.VOID_WALKER_WHISPER.get();
    }

    @Override
    protected SoundEvent getDeathSound() {
        return RegistryHandler.VOID_WALKER_DEATH.get();
    }

    @Override
    protected void playStepSound(BlockPos pos, BlockState blockIn) {
        RegistryHandler.VOID_WALKER_STEP.get();
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
        return RegistryHandler.VOID_WALKER_HURT.get();
    }



    @Override
    protected int getExperiencePoints(PlayerEntity player) {
        return 10 + this.world.rand.nextInt(22);
    }

    protected boolean shouldDrown() {
        return false;
    }



}
