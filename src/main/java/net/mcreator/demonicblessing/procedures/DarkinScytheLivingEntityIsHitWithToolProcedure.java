package net.mcreator.demonicblessing.procedures;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.fml.network.NetworkHooks;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.DamageSource;
import net.minecraft.network.PacketBuffer;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.inventory.container.Container;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.demonicblessing.gui.BonkGui;
import net.mcreator.demonicblessing.DemonicblessingMod;

import java.util.Map;

import io.netty.buffer.Unpooled;

public class DarkinScytheLivingEntityIsHitWithToolProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				DemonicblessingMod.LOGGER.warn("Failed to load dependency world for procedure DarkinScytheLivingEntityIsHitWithTool!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				DemonicblessingMod.LOGGER.warn("Failed to load dependency x for procedure DarkinScytheLivingEntityIsHitWithTool!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				DemonicblessingMod.LOGGER.warn("Failed to load dependency y for procedure DarkinScytheLivingEntityIsHitWithTool!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				DemonicblessingMod.LOGGER.warn("Failed to load dependency z for procedure DarkinScytheLivingEntityIsHitWithTool!");
			return;
		}
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				DemonicblessingMod.LOGGER.warn("Failed to load dependency entity for procedure DarkinScytheLivingEntityIsHitWithTool!");
			return;
		}
		if (dependencies.get("sourceentity") == null) {
			if (!dependencies.containsKey("sourceentity"))
				DemonicblessingMod.LOGGER.warn("Failed to load dependency sourceentity for procedure DarkinScytheLivingEntityIsHitWithTool!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		Entity entity = (Entity) dependencies.get("entity");
		Entity sourceentity = (Entity) dependencies.get("sourceentity");
		if (sourceentity.isAlive()) {
			if (sourceentity.getPersistentData().getBoolean("darkinbuff") == false) {
				if (Math.random() < sourceentity.getPersistentData().getDouble("critchance") / 100) {
					entity.attackEntityFrom(DamageSource.OUT_OF_WORLD,
							(float) (400 + 400 * 0.01 * sourceentity.getPersistentData().getDouble("critdamage")));
				} else {
					entity.attackEntityFrom(DamageSource.OUT_OF_WORLD, (float) 400);
				}
			} else if (sourceentity.getPersistentData().getBoolean("darkinbuff") == true) {
				if (Math.random() < sourceentity.getPersistentData().getDouble("critchance") / 100) {
					entity.attackEntityFrom(DamageSource.OUT_OF_WORLD,
							(float) (500 * ((sourceentity instanceof LivingEntity) ? ((LivingEntity) sourceentity).getMaxHealth() : -1) / 50
									+ 500 * ((sourceentity instanceof LivingEntity) ? ((LivingEntity) sourceentity).getMaxHealth() : -1) / 50 * 0.01
											* sourceentity.getPersistentData().getDouble("critdamage")));
				} else {
					entity.attackEntityFrom(DamageSource.OUT_OF_WORLD,
							(float) (500 * ((sourceentity instanceof LivingEntity) ? ((LivingEntity) sourceentity).getMaxHealth() : -1) / 50));
				}
			}
			if (Math.random() > 0.95) {
				if (Math.random() < 0.5) {
					if (Math.random() < 0.5) {
						if (world instanceof World && !world.isRemote()) {
							((World) world).playSound(null, new BlockPos((int) x, (int) y, (int) z),
									(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
											.getValue(new ResourceLocation("demonicblessing:darkinattack1")),
									SoundCategory.BLOCKS, (float) 1, (float) 1);
						} else {
							((World) world).playSound(x, y, z,
									(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
											.getValue(new ResourceLocation("demonicblessing:darkinattack1")),
									SoundCategory.BLOCKS, (float) 1, (float) 1, false);
						}
					} else {
						if (world instanceof World && !world.isRemote()) {
							((World) world).playSound(null, new BlockPos((int) x, (int) y, (int) z),
									(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
											.getValue(new ResourceLocation("demonicblessing:darkinattack2")),
									SoundCategory.BLOCKS, (float) 1, (float) 1);
						} else {
							((World) world).playSound(x, y, z,
									(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
											.getValue(new ResourceLocation("demonicblessing:darkinattack2")),
									SoundCategory.BLOCKS, (float) 1, (float) 1, false);
						}
					}
				} else {
					if (Math.random() > 0.5) {
						if (world instanceof World && !world.isRemote()) {
							((World) world).playSound(null, new BlockPos((int) x, (int) y, (int) z),
									(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
											.getValue(new ResourceLocation("demonicblessing:darkinattack3")),
									SoundCategory.BLOCKS, (float) 1, (float) 1);
						} else {
							((World) world).playSound(x, y, z,
									(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
											.getValue(new ResourceLocation("demonicblessing:darkinattack3")),
									SoundCategory.BLOCKS, (float) 1, (float) 1, false);
						}
					} else {
						if (world instanceof World && !world.isRemote()) {
							((World) world).playSound(null, new BlockPos((int) x, (int) y, (int) z),
									(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
											.getValue(new ResourceLocation("demonicblessing:darkinattack4")),
									SoundCategory.BLOCKS, (float) 1, (float) 1);
						} else {
							((World) world).playSound(x, y, z,
									(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
											.getValue(new ResourceLocation("demonicblessing:darkinattack4")),
									SoundCategory.BLOCKS, (float) 1, (float) 1, false);
						}
					}
				}
			}
			if (Math.random() < 0.1) {
				if (entity.isNonBoss()) {
					{
						Entity _ent = entity;
						if (_ent instanceof ServerPlayerEntity) {
							BlockPos _bpos = new BlockPos((int) x, (int) y, (int) z);
							NetworkHooks.openGui((ServerPlayerEntity) _ent, new INamedContainerProvider() {
								@Override
								public ITextComponent getDisplayName() {
									return new StringTextComponent("Bonk");
								}

								@Override
								public Container createMenu(int id, PlayerInventory inventory, PlayerEntity player) {
									return new BonkGui.GuiContainerMod(id, inventory, new PacketBuffer(Unpooled.buffer()).writeBlockPos(_bpos));
								}
							}, _bpos);
						}
					}
				}
			}
		}
	}
}
