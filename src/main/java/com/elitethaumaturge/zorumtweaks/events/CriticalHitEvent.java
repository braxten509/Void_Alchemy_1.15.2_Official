package com.elitethaumaturge.zorumtweaks.events;

import com.elitethaumaturge.zorumtweaks.ZorumTweaks;
import com.elitethaumaturge.zorumtweaks.items.misc.ArcamirusStone;
import com.elitethaumaturge.zorumtweaks.other.GlobalVariables;
import com.elitethaumaturge.zorumtweaks.util.RegistryHandler;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.world.World;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

/*EVENT LIST
- AttackEntityEvent


 */



@Mod.EventBusSubscriber(modid = ZorumTweaks.MOD_ID, bus = Bus.FORGE)
public class CriticalHitEvent {

    //Runs everytime player hits an entity, capable of returning if the strike was critical
    @SubscribeEvent
    public static void criticalHitEvent(net.minecraftforge.event.entity.player.CriticalHitEvent event) {
        ZorumTweaks.LOGGER.info("CriticalHitEvent Fired");
        LivingEntity livingEntity = event.getEntityLiving();
        World world = livingEntity.getEntityWorld();
        PlayerEntity playerEntity = event.getPlayer();

        Item playerMain = livingEntity.getHeldItemMainhand().getItem();


        /** ZORUMITE WEAPONS **/
        if (event.isVanillaCritical() == true && !world.isRemote) {
            if (playerMain == RegistryHandler.ZORUMITE_SWORD.get() ||
                    playerMain == RegistryHandler.ZORUMITE_AXE.get() ||
                        playerMain == RegistryHandler.ZORUMITE_DAGGER.get() ||
                            playerMain == RegistryHandler.ZORUMITE_HAMMER.get()) {

                    double d0 = livingEntity.getPosX();
                    double d1 = livingEntity.getPosY();
                    double d2 = livingEntity.getPosZ();

                    //If you want to head a certain amount

                    livingEntity.addPotionEffect(new EffectInstance(Effects.JUMP_BOOST, 100, 0));

                    world.playSound((PlayerEntity) null, d0, d1, d2, SoundEvents.BLOCK_GLASS_BREAK, SoundCategory.PLAYERS, 1.0F, 1.0F);
                    livingEntity.playSound(SoundEvents.BLOCK_GLASS_BREAK, 1.0F, 1.0F);

            }

            /** STRANGE WEAPONS **/
            if (playerMain == RegistryHandler.STRANGE_SWORD.get() ||
                    playerMain == RegistryHandler.STRANGE_AXE.get() ||
                    playerMain == RegistryHandler.STRANGE_DAGGER.get() ||
                    playerMain == RegistryHandler.STRANGE_HAMMER.get()) {

                    double d0 = livingEntity.getPosX();
                    double d1 = livingEntity.getPosY();
                    double d2 = livingEntity.getPosZ();

                livingEntity.addPotionEffect(new EffectInstance(Effects.SPEED, 100, 0));
                livingEntity.addPotionEffect(new EffectInstance(Effects.JUMP_BOOST, 100, 0));

                    world.playSound((PlayerEntity) null, d0, d1, d2, SoundEvents.BLOCK_GLASS_BREAK, SoundCategory.PLAYERS, 1.0F, 1.0F);
                    livingEntity.playSound(SoundEvents.BLOCK_GLASS_BREAK, 1.0F, 1.0F);


            }

            /** UNIVERSE SWORD **/
            if (playerMain == RegistryHandler.UNIVERSE_SWORD.get()) {

                    double d0 = livingEntity.getPosX();
                    double d1 = livingEntity.getPosY();
                    double d2 = livingEntity.getPosZ();

                    livingEntity.addPotionEffect(new EffectInstance(Effects.SPEED, 200, 0));
                    livingEntity.addPotionEffect(new EffectInstance(Effects.JUMP_BOOST, 200, 0));
                    livingEntity.addPotionEffect(new EffectInstance(Effects.INVISIBILITY, 100, 0));
                    livingEntity.addPotionEffect(new EffectInstance(Effects.RESISTANCE, 100, 0));

                    world.playSound((PlayerEntity) null, d0, d1, d2, SoundEvents.BLOCK_GLASS_BREAK, SoundCategory.PLAYERS, 1.0F, 1.0F);
                    livingEntity.playSound(SoundEvents.BLOCK_GLASS_BREAK, 1.0F, 1.0F);

            }

            /** HEALING & MANA **/
            if (playerMain == RegistryHandler.ZORUMITE_SWORD.get() ||
                    playerMain == RegistryHandler.STRANGE_SWORD.get() ||
                        playerMain == RegistryHandler.UNIVERSE_SWORD.get() ||
                            playerMain == RegistryHandler.ZORUMITE_AXE.get() ||
                                playerMain == RegistryHandler.STRANGE_AXE.get()) {

                if (playerEntity.inventory.hasItemStack(new ItemStack(RegistryHandler.ARCAMIRUS_STONE.get(), (int) (1))) ||
                        playerEntity.inventory.hasItemStack(new ItemStack(RegistryHandler.APPRENTICES_STONE.get(), (int) (1)))) {

                    GlobalVariables.voidEnergy += 5;

                }

                livingEntity.heal(2.0f);

            } else if (playerMain == RegistryHandler.ZORUMITE_DAGGER.get() ||
                        playerMain == RegistryHandler.STRANGE_DAGGER.get()) {

                if (playerEntity.inventory.hasItemStack(new ItemStack(RegistryHandler.ARCAMIRUS_STONE.get(), (int) (1))) ||
                        playerEntity.inventory.hasItemStack(new ItemStack(RegistryHandler.APPRENTICES_STONE.get(), (int) (1)))) {

                    GlobalVariables.voidEnergy += 3;

                }

                livingEntity.heal(1.0f);

            } else if (playerMain == RegistryHandler.ZORUMITE_HAMMER.get() ||
                        playerMain == RegistryHandler.STRANGE_HAMMER.get()) {

                if (playerEntity.inventory.hasItemStack(new ItemStack(RegistryHandler.ARCAMIRUS_STONE.get(), (int) (1))) ||
                        playerEntity.inventory.hasItemStack(new ItemStack(RegistryHandler.APPRENTICES_STONE.get(), (int) (1)))) {

                    GlobalVariables.voidEnergy += 7;

                }

                livingEntity.heal(3.0f);

            }

            /** NO OVERFLOW **/
            if (GlobalVariables.voidEnergy >= ArcamirusStone.activationRequirement) {
                GlobalVariables.voidEnergy = ArcamirusStone.activationRequirement;
            }

        }
    }
}
