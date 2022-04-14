package net.mcreator.demonicblessing.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.demonicblessing.item.Crystal3Item;
import net.mcreator.demonicblessing.item.AmethystItem;
import net.mcreator.demonicblessing.DemonicblessingMod;

import java.util.stream.Collectors;
import java.util.function.Function;
import java.util.Map;
import java.util.List;
import java.util.Comparator;

public class ElectrozxcLivingEntityIsHitWithToolProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				DemonicblessingMod.LOGGER.warn("Failed to load dependency world for procedure ElectrozxcLivingEntityIsHitWithTool!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				DemonicblessingMod.LOGGER.warn("Failed to load dependency x for procedure ElectrozxcLivingEntityIsHitWithTool!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				DemonicblessingMod.LOGGER.warn("Failed to load dependency y for procedure ElectrozxcLivingEntityIsHitWithTool!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				DemonicblessingMod.LOGGER.warn("Failed to load dependency z for procedure ElectrozxcLivingEntityIsHitWithTool!");
			return;
		}
		if (dependencies.get("sourceentity") == null) {
			if (!dependencies.containsKey("sourceentity"))
				DemonicblessingMod.LOGGER.warn("Failed to load dependency sourceentity for procedure ElectrozxcLivingEntityIsHitWithTool!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		Entity sourceentity = (Entity) dependencies.get("sourceentity");
		if ((sourceentity instanceof PlayerEntity)
				? ((PlayerEntity) sourceentity).inventory.hasItemStack(new ItemStack(AmethystItem.block))
				: false) {
			if (Math.random() < sourceentity.getPersistentData().getDouble("critchance") / 100) {
				{
					List<Entity> _entfound = world
							.getEntitiesWithinAABB(Entity.class,
									new AxisAlignedBB(x - (1 / 2d), y - (1 / 2d), z - (1 / 2d), x + (1 / 2d), y + (1 / 2d), z + (1 / 2d)), null)
							.stream().sorted(new Object() {
								Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
									return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
								}
							}.compareDistOf(x, y, z)).collect(Collectors.toList());
					for (Entity entityiterator : _entfound) {
						entityiterator.attackEntityFrom(DamageSource.OUT_OF_WORLD,
								(float) (1200 * sourceentity.getPersistentData().getDouble("critdamage") / 100));
					}
				}
			} else {
				{
					List<Entity> _entfound = world
							.getEntitiesWithinAABB(Entity.class,
									new AxisAlignedBB(x - (1 / 2d), y - (1 / 2d), z - (1 / 2d), x + (1 / 2d), y + (1 / 2d), z + (1 / 2d)), null)
							.stream().sorted(new Object() {
								Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
									return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
								}
							}.compareDistOf(x, y, z)).collect(Collectors.toList());
					for (Entity entityiterator : _entfound) {
						entityiterator.attackEntityFrom(DamageSource.OUT_OF_WORLD, (float) 1250);
					}
				}
			}
		} else {
			if (Math.random() < sourceentity.getPersistentData().getDouble("critchance") / 100) {
				{
					List<Entity> _entfound = world
							.getEntitiesWithinAABB(Entity.class,
									new AxisAlignedBB(x - (1 / 2d), y - (1 / 2d), z - (1 / 2d), x + (1 / 2d), y + (1 / 2d), z + (1 / 2d)), null)
							.stream().sorted(new Object() {
								Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
									return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
								}
							}.compareDistOf(x, y, z)).collect(Collectors.toList());
					for (Entity entityiterator : _entfound) {
						entityiterator.attackEntityFrom(DamageSource.LIGHTNING_BOLT,
								(float) (1300 + 1600 * 0.01 * sourceentity.getPersistentData().getDouble("critdamage")));
					}
				}
			} else {
				{
					List<Entity> _entfound = world
							.getEntitiesWithinAABB(Entity.class,
									new AxisAlignedBB(x - (1 / 2d), y - (1 / 2d), z - (1 / 2d), x + (1 / 2d), y + (1 / 2d), z + (1 / 2d)), null)
							.stream().sorted(new Object() {
								Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
									return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
								}
							}.compareDistOf(x, y, z)).collect(Collectors.toList());
					for (Entity entityiterator : _entfound) {
						entityiterator.attackEntityFrom(DamageSource.LIGHTNING_BOLT, (float) 1350);
					}
				}
			}
		}
		if ((sourceentity instanceof PlayerEntity)
				? ((PlayerEntity) sourceentity).inventory.hasItemStack(new ItemStack(Crystal3Item.block))
				: false) {
			{
				List<Entity> _entfound = world
						.getEntitiesWithinAABB(Entity.class,
								new AxisAlignedBB(x - (1 / 2d), y - (1 / 2d), z - (1 / 2d), x + (1 / 2d), y + (1 / 2d), z + (1 / 2d)), null)
						.stream().sorted(new Object() {
							Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
								return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
							}
						}.compareDistOf(x, y, z)).collect(Collectors.toList());
				for (Entity entityiterator : _entfound) {
					if (entityiterator instanceof LivingEntity)
						((LivingEntity) entityiterator).setHealth(
								(float) (((entityiterator instanceof LivingEntity) ? ((LivingEntity) entityiterator).getHealth() : -1) - 2));
				}
			}
		}
	}
}
