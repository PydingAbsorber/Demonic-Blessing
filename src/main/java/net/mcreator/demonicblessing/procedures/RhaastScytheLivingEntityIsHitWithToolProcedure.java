package net.mcreator.demonicblessing.procedures;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.items.ItemHandlerHelper;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.DamageSource;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import net.mcreator.demonicblessing.item.RedsoulItem;
import net.mcreator.demonicblessing.item.BlueSoulItem;
import net.mcreator.demonicblessing.DemonicblessingMod;

import java.util.Map;

public class RhaastScytheLivingEntityIsHitWithToolProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				DemonicblessingMod.LOGGER.warn("Failed to load dependency world for procedure RhaastScytheLivingEntityIsHitWithTool!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				DemonicblessingMod.LOGGER.warn("Failed to load dependency x for procedure RhaastScytheLivingEntityIsHitWithTool!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				DemonicblessingMod.LOGGER.warn("Failed to load dependency y for procedure RhaastScytheLivingEntityIsHitWithTool!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				DemonicblessingMod.LOGGER.warn("Failed to load dependency z for procedure RhaastScytheLivingEntityIsHitWithTool!");
			return;
		}
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				DemonicblessingMod.LOGGER.warn("Failed to load dependency entity for procedure RhaastScytheLivingEntityIsHitWithTool!");
			return;
		}
		if (dependencies.get("sourceentity") == null) {
			if (!dependencies.containsKey("sourceentity"))
				DemonicblessingMod.LOGGER.warn("Failed to load dependency sourceentity for procedure RhaastScytheLivingEntityIsHitWithTool!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		Entity entity = (Entity) dependencies.get("entity");
		Entity sourceentity = (Entity) dependencies.get("sourceentity");
		if (Math.random() < sourceentity.getPersistentData().getDouble("critchance") / 100) {
			entity.attackEntityFrom(DamageSource.OUT_OF_WORLD, (float) (100 + 100 * 0.01 * sourceentity.getPersistentData().getDouble("critdamage")));
		} else {
			entity.attackEntityFrom(DamageSource.OUT_OF_WORLD, (float) 100);
		}
		if (Math.random() > 0.9) {
			if (sourceentity instanceof PlayerEntity) {
				ItemStack _setstack = new ItemStack(BlueSoulItem.block);
				_setstack.setCount((int) 1);
				ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) sourceentity), _setstack);
			}
		}
		if (Math.random() > 0.9) {
			if (sourceentity instanceof PlayerEntity) {
				ItemStack _setstack = new ItemStack(RedsoulItem.block);
				_setstack.setCount((int) 1);
				ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) sourceentity), _setstack);
			}
		}
		if (Math.random() > 0.8) {
			if (Math.random() > 0.5) {
				if (Math.random() > 0.5) {
					if (world instanceof World && !world.isRemote()) {
						((World) world).playSound(null, new BlockPos((int) x, (int) y, (int) z),
								(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("demonicblessing:kishki")),
								SoundCategory.BLOCKS, (float) 1, (float) 1);
					} else {
						((World) world).playSound(x, y, z,
								(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("demonicblessing:kishki")),
								SoundCategory.BLOCKS, (float) 1, (float) 1, false);
					}
				} else {
					if (world instanceof World && !world.isRemote()) {
						((World) world).playSound(null, new BlockPos((int) x, (int) y, (int) z),
								(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
										.getValue(new ResourceLocation("demonicblessing:chembolshevrag")),
								SoundCategory.BLOCKS, (float) 1, (float) 1);
					} else {
						((World) world).playSound(x, y, z,
								(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
										.getValue(new ResourceLocation("demonicblessing:chembolshevrag")),
								SoundCategory.BLOCKS, (float) 1, (float) 1, false);
					}
				}
			} else {
				if (Math.random() > 0.5) {
					if (world instanceof World && !world.isRemote()) {
						((World) world).playSound(null, new BlockPos((int) x, (int) y, (int) z),
								(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
										.getValue(new ResourceLocation("demonicblessing:onsleduyushiy")),
								SoundCategory.PLAYERS, (float) 1, (float) 1);
					} else {
						((World) world).playSound(x, y, z,
								(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
										.getValue(new ResourceLocation("demonicblessing:onsleduyushiy")),
								SoundCategory.PLAYERS, (float) 1, (float) 1, false);
					}
				} else {
					if (world instanceof World && !world.isRemote()) {
						((World) world)
								.playSound(null, new BlockPos((int) x, (int) y, (int) z),
										(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
												.getValue(new ResourceLocation("demonicblessing:novayateli")),
										SoundCategory.PLAYERS, (float) 1, (float) 1);
					} else {
						((World) world).playSound(x, y, z,
								(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
										.getValue(new ResourceLocation("demonicblessing:novayateli")),
								SoundCategory.PLAYERS, (float) 1, (float) 1, false);
					}
				}
			}
		}
	}
}
