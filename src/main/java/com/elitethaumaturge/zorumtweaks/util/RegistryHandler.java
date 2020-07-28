package com.elitethaumaturge.zorumtweaks.util;

import com.elitethaumaturge.zorumtweaks.ZorumTweaks;
import com.elitethaumaturge.zorumtweaks.blocks.*;
import com.elitethaumaturge.zorumtweaks.entities.VoidWalkerEntity;
import com.elitethaumaturge.zorumtweaks.items.ItemBase;
import com.elitethaumaturge.zorumtweaks.items.food.AppleOfLight;
import com.elitethaumaturge.zorumtweaks.items.food.AppleOfStrength;
import com.elitethaumaturge.zorumtweaks.items.food.GabePepper;
import com.elitethaumaturge.zorumtweaks.items.misc.*;
import com.elitethaumaturge.zorumtweaks.items.tools.*;
import com.elitethaumaturge.zorumtweaks.world.biomes.VoidBiome;
import com.elitethaumaturge.zorumtweaks.world.dimension.ZorumModDimension;
import net.minecraft.block.Block;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.common.ModDimension;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;


public class RegistryHandler
{

    public static final DeferredRegister<Item> ITEMS = new DeferredRegister<>(ForgeRegistries.ITEMS, ZorumTweaks.MOD_ID);
    public static final DeferredRegister<Block> BLOCKS = new DeferredRegister<>(ForgeRegistries.BLOCKS, ZorumTweaks.MOD_ID);
    public static final DeferredRegister<Biome> BIOMES = new DeferredRegister<>(ForgeRegistries.BIOMES, ZorumTweaks.MOD_ID);
    public static final DeferredRegister<SoundEvent> SOUNDS = new DeferredRegister<>(ForgeRegistries.SOUND_EVENTS, ZorumTweaks.MOD_ID);
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = new DeferredRegister<>(ForgeRegistries.ENTITIES, ZorumTweaks.MOD_ID);
    public static final DeferredRegister<ModDimension> MOD_DIMENSIONS = new DeferredRegister<>(ForgeRegistries.MOD_DIMENSIONS, ZorumTweaks.MOD_ID);

    public static void init() {
        ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
        BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
        BIOMES.register(FMLJavaModLoadingContext.get().getModEventBus());
        SOUNDS.register(FMLJavaModLoadingContext.get().getModEventBus());
        MOD_DIMENSIONS.register(FMLJavaModLoadingContext.get().getModEventBus());
        ENTITY_TYPES.register(FMLJavaModLoadingContext.get().getModEventBus());
    }

    //Dust
    public static final RegistryObject<Item> ALCHEMICAL_DUST = ITEMS.register("alchemical_dust", ItemBase::new);
    public static final RegistryObject<Item> ARCAMIRUS_DUST = ITEMS.register("arcamirus_dust", ArcamirusDust::new);
    public static final RegistryObject<Item> ETHEREAL_DUST = ITEMS.register("ethereal_dust", ItemBase::new);
    public static final RegistryObject<Item> MIRCANTERS_DUST = ITEMS.register("mircanters_dust", ItemBase::new);
    public static final RegistryObject<Item> VOID_DUST = ITEMS.register("void_dust", VoidDust::new);

    //Bags of dust
    public static final RegistryObject<Item> BAG_OF_ALCHEMICAL_DUST = ITEMS.register("bag_of_alchemical_dust", AlchemicalBag::new);
    public static final RegistryObject<Item> BAG_OF_ARCAMIRUS_DUST = ITEMS.register("bag_of_arcamirus_dust", ArcamirusBag::new);
    public static final RegistryObject<Item> BAG_OF_ETHEREAL_DUST = ITEMS.register("bag_of_ethereal_dust", EtherealBag::new);
    public static final RegistryObject<Item> BAG_OF_MIRCANTERS_DUST = ITEMS.register("bag_of_mircanters_dust", MircantersBag::new);
    public static final RegistryObject<Item> BAG_OF_VOID_DUST = ITEMS.register("bag_of_void_dust", VoidBag::new);

    //Zorumite
    public static final RegistryObject<Item> ZORUMITE = ITEMS.register("zorumite", ItemBase::new);
    public static final RegistryObject<Item> STRANGE_ZORUMITE = ITEMS.register("strange_zorumite", ItemBase::new);
    public static final RegistryObject<Item> ZORUMITE_OF_STRENGTH = ITEMS.register("zorumite_of_strength", ItemBase::new);
    public static final RegistryObject<Item> ZORUMITE_OF_LIGHT = ITEMS.register("zorumite_of_light", ItemBase::new);

    public static final RegistryObject<Item> UNIVERSE_DUST = ITEMS.register("universe_dust", UniverseDust::new);
    public static final RegistryObject<Item> ESSENCE_OF_THE_UNIVERSE = ITEMS.register("essence_of_the_universe", EssenceOfTheUniverse::new);

    //Useful Utilities
    public static final RegistryObject<Item> OMINOUS_BOOK = ITEMS.register("ominous_book", OminousBook::new);
    public static final RegistryObject<Item> SPECULO_INANIS = ITEMS.register("speculo_inanis", SpeculoInanis::new);
    public static final RegistryObject<Item> APPRENTICES_STONE = ITEMS.register("apprentices_stone", ApprenticesStone::new);
    public static final RegistryObject<Item> ARCAMIRUS_STONE = ITEMS.register("arcamirus_stone", ArcamirusStone::new);

    //Food
    public static final RegistryObject<Item> APPLE_OF_STRENGTH = ITEMS.register("apple_of_strength", AppleOfStrength::new);
    public static final RegistryObject<Item> APPLE_OF_LIGHT = ITEMS.register("apple_of_light", AppleOfLight::new);
    public static final RegistryObject<Item> GABE_PEPPER = ITEMS.register("gabe_pepper", GabePepper::new);

    //Misc
    public static final RegistryObject<Item> GLIMMER_OF_HOPE = ITEMS.register("glimmer_of_hope", GlimmerOfHope::new);
    public static final RegistryObject<Item> SUPERNATURAL_STRENGTH = ITEMS.register("supernatural_strength", SupernaturalStrength::new);
    public static final RegistryObject<Item> STONE_STICK = ITEMS.register("stone_stick", ItemBase::new);
    public static final RegistryObject<Item> CRIMSON_KEY = ITEMS.register("crimson_key", ItemBase::new);

    //public static final RegistryObject<Item> LORE_BOOK_1 = ITEMS.register("lore_book_1", LoreBook1::new);

    //Tools
    public static final RegistryObject<Item> ZORUMITE_AXE = ITEMS.register("zorumite_axe", ZorumAxe::new);
    public static final RegistryObject<Item> ZORUMITE_PICKAXE = ITEMS.register("zorumite_pickaxe", ZorumPickaxe::new);
    public static final RegistryObject<Item> ZORUMITE_SWORD = ITEMS.register("zorumite_sword", ZorumSword::new);
    public static final RegistryObject<Item> ZORUMITE_SHOVEL = ITEMS.register("zorumite_shovel", ZorumShovel::new);
    public static final RegistryObject<Item> ZORUMITE_HOE = ITEMS.register("zorumite_hoe", ZorumHoe::new);
    public static final RegistryObject<Item> ZORUMITE_DAGGER = ITEMS.register("zorumite_dagger", ZorumDagger::new);
    public static final RegistryObject<Item> ZORUMITE_HAMMER = ITEMS.register("zorumite_hammer", ZorumHammer::new);

    public static final RegistryObject<Item> STRANGE_AXE = ITEMS.register("strange_axe", StrangeAxe::new);
    public static final RegistryObject<Item> STRANGE_PICKAXE = ITEMS.register("strange_pickaxe", StrangePickaxe::new);
    public static final RegistryObject<Item> STRANGE_SWORD = ITEMS.register("strange_sword", StrangeSword::new);
    public static final RegistryObject<Item> STRANGE_SHOVEL = ITEMS.register("strange_shovel", StrangeShovel::new);
    public static final RegistryObject<Item> STRANGE_HOE = ITEMS.register("strange_hoe", StrangeHoe::new);
    public static final RegistryObject<Item> STRANGE_DAGGER = ITEMS.register("strange_dagger", StrangeDagger::new);
    public static final RegistryObject<Item> STRANGE_HAMMER = ITEMS.register("strange_hammer", StrangeHammer::new);

    public static final RegistryObject<Item> UNIVERSE_SWORD = ITEMS.register("universe_sword", UniverseSword::new);

    //Misc Blocks
    public static final RegistryObject<Block> DUNGEON_BLOCK = BLOCKS.register("dungeon_block", CrimsonKeyBlock::new);
    public static final RegistryObject<Block> FAILED_PROTOTYPE_BLOCK = BLOCKS.register("failed_prototype_block", FailedPrototypeBlock::new);
    public static final RegistryObject<Block> CRIMSON_KEY_BLOCK = BLOCKS.register("crimson_key_block", CrimsonKeyBlock::new);
    public static final RegistryObject<Block> SOUND_TEST_BLOCK = BLOCKS.register("sound_test_block", SoundTestBlock::new);
    public static final RegistryObject<Block> ALCHEMY_TABLE_BLOCK = BLOCKS.register("alchemy_table_block", AlchemyTableBlock::new);

    //Craftable and useful blocks, then lanterns
    public static final RegistryObject<Block> VOID_BLOCK = BLOCKS.register("void_block", VoidBlock::new);
    public static final RegistryObject<Block> ZORUMITE_LANTERN_BLOCK = BLOCKS.register("zorumite_lantern_block", ZorumiteLanternBlock::new);
    public static final RegistryObject<Block> STRANGE_LANTERN_BLOCK = BLOCKS.register("strange_lantern_block", StrangeLanternBlock::new);
    public static final RegistryObject<Block> VOID_LIGHT_BLOCK = BLOCKS.register("void_light_block", VoidLightBlock::new);

    //Ores (natural spawning ones to created ones)
    public static final RegistryObject<Block> ALCHEMICAL_ORE_BLOCK = BLOCKS.register("alchemical_ore_block", AlchemicalOreBlock::new);
    public static final RegistryObject<Block> ARCAMIRUS_ORE_BLOCK = BLOCKS.register("arcamirus_ore_block", ArcamirusOreBlock::new);
    public static final RegistryObject<Block> FORLORN_STONE_BLOCK = BLOCKS.register("forlorn_stone_block", ForlornStoneBlock::new);
    public static final RegistryObject<Block> ENLIGHTENED_STONE_BLOCK = BLOCKS.register("enlightened_stone_block", EnlightenedStoneBlock::new);

    public static final RegistryObject<Block> INFUSED_NETHERRACK_BLOCK = BLOCKS.register("infused_netherrack_block", InfusedNetherrackBlock::new);
    public static final RegistryObject<Block> INFUSED_END_STONE_BLOCK = BLOCKS.register("infused_end_stone_block", InfusedEndStoneBlock::new);
    public static final RegistryObject<Block> PROTOTYPE_BLOCK = BLOCKS.register("prototype_block", PrototypeBlock::new);
    public static final RegistryObject<Block> ZORUMITE_ORE_BLOCK = BLOCKS.register("zorumite_ore_block", ZorumiteOreBlock::new);
    public static final RegistryObject<Block> STRANGE_ORE_BLOCK = BLOCKS.register("strange_ore_block", StrangeOreBlock::new);
    public static final RegistryObject<Block> UNIVERSE_ORE_BLOCK = BLOCKS.register("universe_ore_block", UniverseOreBlock::new);

    public static final RegistryObject<Block> STAGE2_BLOCK = BLOCKS.register("stage2_block", TransistionOreBlock::new);
    public static final RegistryObject<Block> STAGE3_BLOCK = BLOCKS.register("stage3_block", TransistionOreBlock::new);
    public static final RegistryObject<Block> STAGE4_BLOCK = BLOCKS.register("stage4_block", TransistionOreBlock::new);

    //Block Items
    public static final RegistryObject<Item> DUNGEON_BLOCK_ITEM = ITEMS.register("dungeon_block", () -> new BlockItemBase(DUNGEON_BLOCK.get()));
    public static final RegistryObject<Item> FAILED_PROTOTYPE_BLOCK_ITEM = ITEMS.register("failed_prototype_block", () -> new AbsentBlockItem(FAILED_PROTOTYPE_BLOCK.get()));
    public static final RegistryObject<Item> CRIMSON_KEY_BLOCK_ITEM = ITEMS.register("crimson_key_block", () -> new BlockItemBase(CRIMSON_KEY_BLOCK.get()));
    public static final RegistryObject<Item> SOUND_TEST_BLOCK_ITEM = ITEMS.register("sound_test_block", () -> new BlockItemBase(SOUND_TEST_BLOCK.get()));
    public static final RegistryObject<Item> ALCHEMY_TABLE_BLOCK_ITEM = ITEMS.register("alchemy_table_block", () -> new BlockItemBase(ALCHEMY_TABLE_BLOCK.get()));


    public static final RegistryObject<Item> VOID_BLOCK_ITEM = ITEMS.register("void_block", () -> new BlockItemBase(VOID_BLOCK.get()));
    public static final RegistryObject<Item> ZORUMITE_LANTERN_BLOCK_ITEM = ITEMS.register("zorumite_lantern_block", () -> new BlockItemBase(ZORUMITE_LANTERN_BLOCK.get()));
    public static final RegistryObject<Item> STRANGE_LANTERN_BLOCK_ITEM = ITEMS.register("strange_lantern_block", () -> new BlockItemBase(STRANGE_LANTERN_BLOCK.get()));
    public static final RegistryObject<Item> VOID_LIGHT_BLOCK_ITEM = ITEMS.register("void_light_block", () -> new BlockItemBase(VOID_LIGHT_BLOCK.get()));

    public static final RegistryObject<Item> ALCHEMICAL_ORE_BLOCK_ITEM = ITEMS.register("alchemical_ore_block", () -> new BlockItemBase(ALCHEMICAL_ORE_BLOCK.get()));
    public static final RegistryObject<Item> ARCAMIRUS_ORE_BLOCK_ITEM = ITEMS.register("arcamirus_ore_block", () -> new BlockItemBase(ARCAMIRUS_ORE_BLOCK.get()));
    public static final RegistryObject<Item> FORLORN_STONE_BLOCK_ITEM = ITEMS.register("forlorn_stone_block", () -> new BlockItemBase(FORLORN_STONE_BLOCK.get()));
    public static final RegistryObject<Item> ENLIGHTENED_STONE_BLOCK_ITEM = ITEMS.register("enlightened_stone_block", () -> new AbsentBlockItem(ENLIGHTENED_STONE_BLOCK.get()));

    public static final RegistryObject<Item> INFUSED_NETHERRACK_BLOCK_ITEM = ITEMS.register("infused_netherrack_block", () -> new BlockItemBase(INFUSED_NETHERRACK_BLOCK.get()));
    public static final RegistryObject<Item> INFUSED_END_STONE_ITEM = ITEMS.register("infused_end_stone_block", () -> new BlockItemBase(INFUSED_END_STONE_BLOCK.get()));
    public static final RegistryObject<Item> PROTOTYPE_BLOCK_ITEM = ITEMS.register("prototype_block", () -> new BlockItemBase(PROTOTYPE_BLOCK.get()));
    public static final RegistryObject<Item> ZORUMITE_ORE_BLOCK_ITEM = ITEMS.register("zorumite_ore_block", () -> new BlockItemBase(ZORUMITE_ORE_BLOCK.get()));
    public static final RegistryObject<Item> STRANGE_ORE_BLOCK_ITEM = ITEMS.register("strange_ore_block", () -> new BlockItemBase(STRANGE_ORE_BLOCK.get()));
    public static final RegistryObject<Item> UNIVERSE_ORE_BLOCK_ITEM = ITEMS.register("universe_ore_block", () -> new BlockItemBase(UNIVERSE_ORE_BLOCK.get()));

    public static final RegistryObject<Item> STAGE2_BLOCK_ITEM = ITEMS.register("stage2_block", () -> new AbsentBlockItem(STAGE2_BLOCK.get()));
    public static final RegistryObject<Item> STAGE3_BLOCK_ITEM = ITEMS.register("stage3_block", () -> new AbsentBlockItem(STAGE3_BLOCK.get()));
    public static final RegistryObject<Item> STAGE4_BLOCK_ITEM = ITEMS.register("stage4_block", () -> new AbsentBlockItem(STAGE4_BLOCK.get()));

    //Sounds
    public static final RegistryObject<SoundEvent> TEST_SOUND = SOUNDS.register("test_sound", () -> new SoundEvent(new ResourceLocation(ZorumTweaks.MOD_ID, "test_sound")));
    public static final RegistryObject<SoundEvent> VOID_WALKER_WHISPER = SOUNDS.register("entity.void_walker.whisper", () -> new SoundEvent(new ResourceLocation(ZorumTweaks.MOD_ID, "entity.void_walker.whisper")));
    public static final RegistryObject<SoundEvent> VOID_WALKER_HURT = SOUNDS.register("entity.void_walker.hurt", () -> new SoundEvent(new ResourceLocation(ZorumTweaks.MOD_ID, "entity.void_walker.hurt")));
    public static final RegistryObject<SoundEvent> VOID_WALKER_DEATH = SOUNDS.register("entity.void_walker.death", () -> new SoundEvent(new ResourceLocation(ZorumTweaks.MOD_ID, "entity.void_walker.death")));
    public static final RegistryObject<SoundEvent> VOID_WALKER_STEP = SOUNDS.register("entity.void_walker.step", () -> new SoundEvent(new ResourceLocation(ZorumTweaks.MOD_ID, "entity.void_walker.step")));

    //Entities
    public static final RegistryObject<EntityType<VoidWalkerEntity>> VOID_WALKER_ENTITY = ENTITY_TYPES
            .register("void_walker_entity",
                    () -> EntityType.Builder.<VoidWalkerEntity>create(VoidWalkerEntity::new, EntityClassification.MONSTER)
                            .size(0.9f, 2.0f)
                            .build(new ResourceLocation(ZorumTweaks.MOD_ID, "void_walker_entity").toString()));



    //Dimensions
    public static final RegistryObject<ModDimension> VOID_DIMENSION = MOD_DIMENSIONS.register("void_dimension", () -> new ZorumModDimension());

    //Biomes
    public static final RegistryObject<Biome> VOID_BIOME = BIOMES.register("void_biome", () -> new VoidBiome(new Biome.Builder()));

    public static void registerBiomes() {
        registerBiome(VOID_BIOME.get(), BiomeDictionary.Type.PLAINS, BiomeDictionary.Type.OVERWORLD);
    }

    private static void registerBiome(Biome biome, BiomeDictionary.Type... types) {
        //BiomeManager.addBiome(BiomeManager.BiomeType.COOL, new BiomeManager.BiomeEntry(biome, 100));
        BiomeDictionary.addTypes(biome, types);
        BiomeManager.addSpawnBiome(biome);
    }



}


