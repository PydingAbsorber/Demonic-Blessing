package net.mcreator.demonicblessing.procedures;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.world.BlockEvent;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.Entity;
import net.minecraft.block.Blocks;

import net.mcreator.demonicblessing.entity.DiediCanditoEntity;
import net.mcreator.demonicblessing.block.NetherStarBlockBlock;
import net.mcreator.demonicblessing.DemonicblessingMod;

import java.util.Map;
import java.util.HashMap;

public class NetherStarBlockIsPlacedByEntityProcedure {
	@Mod.EventBusSubscriber
	private static class GlobalTrigger {
		@SubscribeEvent
		public static void onBlockPlace(BlockEvent.EntityPlaceEvent event) {
			Entity entity = event.getEntity();
			IWorld world = event.getWorld();
			Map<String, Object> dependencies = new HashMap<>();
			dependencies.put("x", event.getPos().getX());
			dependencies.put("y", event.getPos().getY());
			dependencies.put("z", event.getPos().getZ());
			dependencies.put("px", entity.getPosX());
			dependencies.put("py", entity.getPosY());
			dependencies.put("pz", entity.getPosZ());
			dependencies.put("world", world);
			dependencies.put("entity", entity);
			dependencies.put("blockstate", event.getState());
			dependencies.put("placedagainst", event.getPlacedAgainst());
			dependencies.put("event", event);
			executeProcedure(dependencies);
		}
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				DemonicblessingMod.LOGGER.warn("Failed to load dependency world for procedure NetherStarBlockIsPlacedByEntity!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				DemonicblessingMod.LOGGER.warn("Failed to load dependency x for procedure NetherStarBlockIsPlacedByEntity!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				DemonicblessingMod.LOGGER.warn("Failed to load dependency y for procedure NetherStarBlockIsPlacedByEntity!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				DemonicblessingMod.LOGGER.warn("Failed to load dependency z for procedure NetherStarBlockIsPlacedByEntity!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		if ((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == NetherStarBlockBlock.block
				&& (world.getBlockState(new BlockPos((int) (x + 1), (int) (y - 2), (int) z))).getBlock() == NetherStarBlockBlock.block
				&& (world.getBlockState(new BlockPos((int) (x - 1), (int) (y - 2), (int) z))).getBlock() == NetherStarBlockBlock.block
				&& (world.getBlockState(new BlockPos((int) x, (int) (y - 1), (int) z))).getBlock() == NetherStarBlockBlock.block
				&& (world.getBlockState(new BlockPos((int) x, (int) (y - 2), (int) z))).getBlock() == NetherStarBlockBlock.block) {
			if (world instanceof ServerWorld) {
				Entity entityToSpawn = new DiediCanditoEntity.CustomEntity(DiediCanditoEntity.entity, (World) world);
				entityToSpawn.setLocationAndAngles(x, y, z, world.getRandom().nextFloat() * 360F, 0);
				if (entityToSpawn instanceof MobEntity)
					((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world, world.getDifficultyForLocation(entityToSpawn.getPosition()),
							SpawnReason.MOB_SUMMONED, (ILivingEntityData) null, (CompoundNBT) null);
				world.addEntity(entityToSpawn);
			}
			if (world.isRemote()) {
				if (world instanceof World && !world.isRemote()) {
					((World) world)
							.playSound(null, new BlockPos((int) x, (int) y, (int) z),
									(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
											.getValue(new ResourceLocation("demonicblessing:dungeontomas")),
									SoundCategory.NEUTRAL, (float) 0.3, (float) 1);
				} else {
					((World) world).playSound(x, y, z,
							(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
									.getValue(new ResourceLocation("demonicblessing:dungeontomas")),
							SoundCategory.NEUTRAL, (float) 0.3, (float) 1, false);
				}
			}
			world.setBlockState(new BlockPos((int) x, (int) y, (int) z), Blocks.AIR.getDefaultState(), 3);
			world.setBlockState(new BlockPos((int) (x + 1), (int) (y - 2), (int) z), Blocks.AIR.getDefaultState(), 3);
			world.setBlockState(new BlockPos((int) (x - 1), (int) (y - 2), (int) z), Blocks.AIR.getDefaultState(), 3);
			world.setBlockState(new BlockPos((int) x, (int) (y - 1), (int) z), Blocks.AIR.getDefaultState(), 3);
			world.setBlockState(new BlockPos((int) x, (int) (y - 2), (int) z), Blocks.AIR.getDefaultState(), 3);
		}
	}
}
