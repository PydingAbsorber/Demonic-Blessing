package net.mcreator.demonicblessing.procedures;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.item.ItemEntity;

import net.mcreator.demonicblessing.item.VoidAmorItem;
import net.mcreator.demonicblessing.item.MusonopodavitelItem;
import net.mcreator.demonicblessing.DemonicblessingMod;

import java.util.Map;

public class FinalSecretBossEntityDiesProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				DemonicblessingMod.LOGGER.warn("Failed to load dependency world for procedure FinalSecretBossEntityDies!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				DemonicblessingMod.LOGGER.warn("Failed to load dependency x for procedure FinalSecretBossEntityDies!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				DemonicblessingMod.LOGGER.warn("Failed to load dependency y for procedure FinalSecretBossEntityDies!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				DemonicblessingMod.LOGGER.warn("Failed to load dependency z for procedure FinalSecretBossEntityDies!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		if (0.2 > Math.random()) {
			if (world instanceof World && !world.isRemote()) {
				ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z, new ItemStack(MusonopodavitelItem.block));
				entityToSpawn.setPickupDelay((int) 10);
				entityToSpawn.setNoDespawn();
				world.addEntity(entityToSpawn);
			}
		}
		if (0.5 > Math.random()) {
			if (0.5 > Math.random()) {
				if (world instanceof World && !world.isRemote()) {
					ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z, new ItemStack(VoidAmorItem.helmet));
					entityToSpawn.setPickupDelay((int) 10);
					entityToSpawn.setNoDespawn();
					world.addEntity(entityToSpawn);
				}
			} else {
				if (world instanceof World && !world.isRemote()) {
					ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z, new ItemStack(VoidAmorItem.body));
					entityToSpawn.setPickupDelay((int) 10);
					entityToSpawn.setNoDespawn();
					world.addEntity(entityToSpawn);
				}
			}
		} else {
			if (0.5 > Math.random()) {
				if (world instanceof World && !world.isRemote()) {
					ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z, new ItemStack(VoidAmorItem.legs));
					entityToSpawn.setPickupDelay((int) 10);
					entityToSpawn.setNoDespawn();
					world.addEntity(entityToSpawn);
				}
			} else {
				if (world instanceof World && !world.isRemote()) {
					ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z, new ItemStack(VoidAmorItem.boots));
					entityToSpawn.setPickupDelay((int) 10);
					entityToSpawn.setNoDespawn();
					world.addEntity(entityToSpawn);
				}
			}
		}
	}
}
