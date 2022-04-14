package net.mcreator.demonicblessing.procedures;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.entity.effect.LightningBoltEntity;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.Entity;
import net.minecraft.block.Blocks;

import net.mcreator.demonicblessing.entity.FuckJreskoEntity;
import net.mcreator.demonicblessing.entity.ArthasEntity;
import net.mcreator.demonicblessing.DemonicblessingMod;

import java.util.Map;

public class FuckJreskoSummonItemIsDroppedByPlayerProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				DemonicblessingMod.LOGGER.warn("Failed to load dependency world for procedure FuckJreskoSummonItemIsDroppedByPlayer!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				DemonicblessingMod.LOGGER.warn("Failed to load dependency x for procedure FuckJreskoSummonItemIsDroppedByPlayer!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				DemonicblessingMod.LOGGER.warn("Failed to load dependency y for procedure FuckJreskoSummonItemIsDroppedByPlayer!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				DemonicblessingMod.LOGGER.warn("Failed to load dependency z for procedure FuckJreskoSummonItemIsDroppedByPlayer!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		if (world instanceof ServerWorld) {
			IWorld _worldorig = world;
			world = ((ServerWorld) world).getServer().getWorld(World.THE_NETHER);
			if (world != null) {
				if ((world.getFluidState(new BlockPos((int) x, (int) y, (int) z)).getBlockState()).getBlock() == Blocks.LAVA) {
					if (world instanceof ServerWorld) {
						Entity entityToSpawn = new LightningBoltEntity(EntityType.LIGHTNING_BOLT, (World) world);
						entityToSpawn.setLocationAndAngles(x, y, z, world.getRandom().nextFloat() * 360F, 0);
						if (entityToSpawn instanceof MobEntity)
							((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
									world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED, (ILivingEntityData) null,
									(CompoundNBT) null);
						world.addEntity(entityToSpawn);
					}
					if (world instanceof ServerWorld) {
						Entity entityToSpawn = new ArthasEntity.CustomEntity(ArthasEntity.entity, (World) world);
						entityToSpawn.setLocationAndAngles(x, (y + 4), z, world.getRandom().nextFloat() * 360F, 0);
						if (entityToSpawn instanceof MobEntity)
							((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
									world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED, (ILivingEntityData) null,
									(CompoundNBT) null);
						world.addEntity(entityToSpawn);
					}
				} else if ((world.getFluidState(new BlockPos((int) x, (int) (y - 1), (int) z)).getBlockState()).getBlock() == Blocks.LAVA) {
					if (world instanceof ServerWorld) {
						Entity entityToSpawn = new LightningBoltEntity(EntityType.LIGHTNING_BOLT, (World) world);
						entityToSpawn.setLocationAndAngles(x, (y - 1), z, world.getRandom().nextFloat() * 360F, 0);
						if (entityToSpawn instanceof MobEntity)
							((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
									world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED, (ILivingEntityData) null,
									(CompoundNBT) null);
						world.addEntity(entityToSpawn);
					}
					if (world instanceof ServerWorld) {
						Entity entityToSpawn = new FuckJreskoEntity.CustomEntity(FuckJreskoEntity.entity, (World) world);
						entityToSpawn.setLocationAndAngles(x, (y + 5), z, world.getRandom().nextFloat() * 360F, 0);
						if (entityToSpawn instanceof MobEntity)
							((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
									world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED, (ILivingEntityData) null,
									(CompoundNBT) null);
						world.addEntity(entityToSpawn);
					}
				} else if ((world.getFluidState(new BlockPos((int) x, (int) (y - 2), (int) z)).getBlockState()).getBlock() == Blocks.LAVA) {
					if (world instanceof ServerWorld) {
						Entity entityToSpawn = new LightningBoltEntity(EntityType.LIGHTNING_BOLT, (World) world);
						entityToSpawn.setLocationAndAngles(x, (y - 2), z, world.getRandom().nextFloat() * 360F, 0);
						if (entityToSpawn instanceof MobEntity)
							((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
									world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED, (ILivingEntityData) null,
									(CompoundNBT) null);
						world.addEntity(entityToSpawn);
					}
					if (world instanceof ServerWorld) {
						Entity entityToSpawn = new FuckJreskoEntity.CustomEntity(FuckJreskoEntity.entity, (World) world);
						entityToSpawn.setLocationAndAngles(x, (y + 6), z, world.getRandom().nextFloat() * 360F, 0);
						if (entityToSpawn instanceof MobEntity)
							((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
									world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED, (ILivingEntityData) null,
									(CompoundNBT) null);
						world.addEntity(entityToSpawn);
					}
				}
			}
			world = _worldorig;
		}
	}
}
