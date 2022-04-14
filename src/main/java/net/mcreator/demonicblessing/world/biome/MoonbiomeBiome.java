
package net.mcreator.demonicblessing.world.biome;

import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.common.BiomeDictionary;

import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.biome.MobSpawnInfo;
import net.minecraft.world.biome.BiomeGenerationSettings;
import net.minecraft.world.biome.BiomeAmbience;
import net.minecraft.world.biome.Biome;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.RegistryKey;
import net.minecraft.entity.EntityClassification;

import net.mcreator.demonicblessing.entity.EkumeaEntity;
import net.mcreator.demonicblessing.block.MoonblockBlock;
import net.mcreator.demonicblessing.DemonicblessingModElements;

@DemonicblessingModElements.ModElement.Tag
public class MoonbiomeBiome extends DemonicblessingModElements.ModElement {
	public static Biome biome;

	public MoonbiomeBiome(DemonicblessingModElements instance) {
		super(instance, 165);
		FMLJavaModLoadingContext.get().getModEventBus().register(new BiomeRegisterHandler());
	}

	private static class BiomeRegisterHandler {
		@SubscribeEvent
		public void registerBiomes(RegistryEvent.Register<Biome> event) {
			if (biome == null) {
				BiomeAmbience effects = new BiomeAmbience.Builder().setFogColor(-16777216).setWaterColor(4159204).setWaterFogColor(329011)
						.withSkyColor(-16777216).withFoliageColor(10387789).withGrassColor(9470285).build();
				BiomeGenerationSettings.Builder biomeGenerationSettings = new BiomeGenerationSettings.Builder()
						.withSurfaceBuilder(SurfaceBuilder.DEFAULT.func_242929_a(new SurfaceBuilderConfig(MoonblockBlock.block.getDefaultState(),
								MoonblockBlock.block.getDefaultState(), MoonblockBlock.block.getDefaultState())));
				MobSpawnInfo.Builder mobSpawnInfo = new MobSpawnInfo.Builder().isValidSpawnBiomeForPlayer();
				mobSpawnInfo.withSpawner(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EkumeaEntity.entity, 1, 1, 1));
				biome = new Biome.Builder().precipitation(Biome.RainType.NONE).category(Biome.Category.NONE).depth(0.1f).scale(0.1f).temperature(0f)
						.downfall(0f).setEffects(effects).withMobSpawnSettings(mobSpawnInfo.copy())
						.withGenerationSettings(biomeGenerationSettings.build()).build();
				event.getRegistry().register(biome.setRegistryName("demonicblessing:moonbiome"));
			}
		}
	}

	@Override
	public void init(FMLCommonSetupEvent event) {
		BiomeDictionary.addTypes(RegistryKey.getOrCreateKey(Registry.BIOME_KEY, WorldGenRegistries.BIOME.getKey(biome)),
				BiomeDictionary.Type.MODIFIED, BiomeDictionary.Type.COLD, BiomeDictionary.Type.DEAD, BiomeDictionary.Type.VOID,
				BiomeDictionary.Type.DRY);
	}
}
