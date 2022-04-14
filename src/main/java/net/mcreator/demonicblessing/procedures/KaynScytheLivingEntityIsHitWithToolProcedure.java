package net.mcreator.demonicblessing.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.DamageSource;
import net.minecraft.potion.Effects;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.demonicblessing.DemonicblessingMod;

import java.util.Map;

public class KaynScytheLivingEntityIsHitWithToolProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				DemonicblessingMod.LOGGER.warn("Failed to load dependency world for procedure KaynScytheLivingEntityIsHitWithTool!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				DemonicblessingMod.LOGGER.warn("Failed to load dependency x for procedure KaynScytheLivingEntityIsHitWithTool!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				DemonicblessingMod.LOGGER.warn("Failed to load dependency y for procedure KaynScytheLivingEntityIsHitWithTool!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				DemonicblessingMod.LOGGER.warn("Failed to load dependency z for procedure KaynScytheLivingEntityIsHitWithTool!");
			return;
		}
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				DemonicblessingMod.LOGGER.warn("Failed to load dependency entity for procedure KaynScytheLivingEntityIsHitWithTool!");
			return;
		}
		if (dependencies.get("sourceentity") == null) {
			if (!dependencies.containsKey("sourceentity"))
				DemonicblessingMod.LOGGER.warn("Failed to load dependency sourceentity for procedure KaynScytheLivingEntityIsHitWithTool!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		Entity entity = (Entity) dependencies.get("entity");
		Entity sourceentity = (Entity) dependencies.get("sourceentity");
		if (sourceentity.isAlive()) {
			if (sourceentity.getPersistentData().getBoolean("kaynbuff") == false) {
				if (Math.random() < sourceentity.getPersistentData().getDouble("critchance") / 100) {
					entity.attackEntityFrom(DamageSource.OUT_OF_WORLD,
							(float) (800 + 800 * 0.01 * sourceentity.getPersistentData().getDouble("critdamage")));
				} else {
					entity.attackEntityFrom(DamageSource.OUT_OF_WORLD, (float) 800);
				}
			} else if (sourceentity.getPersistentData().getBoolean("kaynbuff") == true) {
				if (Math.random() < sourceentity.getPersistentData().getDouble("critchance") / 100) {
					entity.attackEntityFrom(DamageSource.OUT_OF_WORLD,
							(float) (268
									* (((sourceentity instanceof LivingEntity) ? ((LivingEntity) sourceentity).getMaxHealth() : -1)
											/ ((sourceentity instanceof LivingEntity) ? ((LivingEntity) sourceentity).getHealth() : -1))
									+ 268 * (((sourceentity instanceof LivingEntity) ? ((LivingEntity) sourceentity).getMaxHealth() : -1)
											/ ((sourceentity instanceof LivingEntity) ? ((LivingEntity) sourceentity).getHealth() : -1)) * 0.01
											* sourceentity.getPersistentData().getDouble("critdamage")));
				} else {
					entity.attackEntityFrom(DamageSource.OUT_OF_WORLD,
							(float) (268 * (((sourceentity instanceof LivingEntity) ? ((LivingEntity) sourceentity).getMaxHealth() : -1)
									/ ((sourceentity instanceof LivingEntity) ? ((LivingEntity) sourceentity).getHealth() : -1))));
				}
				if (entity instanceof LivingEntity)
					((LivingEntity) entity).setHealth((float) (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1)
							- sourceentity.getPersistentData().getDouble("sethealth")));
			}
			if (Math.random() > 0.95) {
				if (Math.random() < 0.5) {
					if (Math.random() < 0.5) {
						if (world instanceof World && !world.isRemote()) {
							((World) world).playSound(null, new BlockPos((int) x, (int) y, (int) z),
									(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
											.getValue(new ResourceLocation("demonicblessing:stkaynattack1")),
									SoundCategory.BLOCKS, (float) 1, (float) 1);
						} else {
							((World) world).playSound(x, y, z,
									(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
											.getValue(new ResourceLocation("demonicblessing:stkaynattack1")),
									SoundCategory.BLOCKS, (float) 1, (float) 1, false);
						}
					} else {
						if (world instanceof World && !world.isRemote()) {
							((World) world).playSound(null, new BlockPos((int) x, (int) y, (int) z),
									(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
											.getValue(new ResourceLocation("demonicblessing:stkaynattack2")),
									SoundCategory.BLOCKS, (float) 1, (float) 1);
						} else {
							((World) world).playSound(x, y, z,
									(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
											.getValue(new ResourceLocation("demonicblessing:stkaynattack2")),
									SoundCategory.BLOCKS, (float) 1, (float) 1, false);
						}
					}
				} else {
					if (Math.random() < 0.5) {
						if (world instanceof World && !world.isRemote()) {
							((World) world).playSound(null, new BlockPos((int) x, (int) y, (int) z),
									(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
											.getValue(new ResourceLocation("demonicblessing:stkaynattack3")),
									SoundCategory.BLOCKS, (float) 1, (float) 1);
						} else {
							((World) world).playSound(x, y, z,
									(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
											.getValue(new ResourceLocation("demonicblessing:stkaynattack3")),
									SoundCategory.BLOCKS, (float) 1, (float) 1, false);
						}
					} else {
						if (world instanceof World && !world.isRemote()) {
							((World) world).playSound(null, new BlockPos((int) x, (int) y, (int) z),
									(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
											.getValue(new ResourceLocation("demonicblessing:stkaynattack4")),
									SoundCategory.BLOCKS, (float) 1, (float) 1);
						} else {
							((World) world).playSound(x, y, z,
									(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
											.getValue(new ResourceLocation("demonicblessing:stkaynattack4")),
									SoundCategory.BLOCKS, (float) 1, (float) 1, false);
						}
					}
				}
			}
			if (sourceentity instanceof LivingEntity) {
				((LivingEntity) sourceentity).removePotionEffect(Effects.INVISIBILITY);
			}
		}
	}
}
