package net.mcreator.demonicblessing.procedures;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.IWorld;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.demonicblessing.item.PurpleScytheItem;
import net.mcreator.demonicblessing.DemonicblessingModVariables;
import net.mcreator.demonicblessing.DemonicblessingMod;

import java.util.Map;

public class PurpleScytheItemInHandTickProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				DemonicblessingMod.LOGGER.warn("Failed to load dependency world for procedure PurpleScytheItemInHandTick!");
			return;
		}
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				DemonicblessingMod.LOGGER.warn("Failed to load dependency entity for procedure PurpleScytheItemInHandTick!");
			return;
		}
		if (dependencies.get("itemstack") == null) {
			if (!dependencies.containsKey("itemstack"))
				DemonicblessingMod.LOGGER.warn("Failed to load dependency itemstack for procedure PurpleScytheItemInHandTick!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		Entity entity = (Entity) dependencies.get("entity");
		ItemStack itemstack = (ItemStack) dependencies.get("itemstack");
		if (entity.isAlive()) {
			if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
					.getItem() == PurpleScytheItem.block) {
				if (entity.getPersistentData().getBoolean("fly") == true) {
					if (entity.rotationPitch > -22.5 && entity.rotationPitch < 22.5) {
						{
							double _setval = 0;
							entity.getCapability(DemonicblessingModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.fly_y = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
					}
					if (entity.rotationPitch < -22.5 && entity.rotationPitch > -45) {
						{
							double _setval = 0.25;
							entity.getCapability(DemonicblessingModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.fly_y = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
					}
					if (entity.rotationPitch < -45 && entity.rotationPitch > -67.5) {
						{
							double _setval = 0.6;
							entity.getCapability(DemonicblessingModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.fly_y = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
					}
					if (entity.rotationPitch < -67.5 && entity.rotationPitch > -90) {
						{
							double _setval = 1;
							entity.getCapability(DemonicblessingModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.fly_y = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
					}
					if (entity.rotationPitch > 22.5 && entity.rotationPitch < 45) {
						{
							double _setval = (-0.1);
							entity.getCapability(DemonicblessingModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.fly_y = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
					}
					if (entity.rotationPitch > 45 && entity.rotationPitch < 67.5) {
						{
							double _setval = (-0.25);
							entity.getCapability(DemonicblessingModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.fly_y = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
					}
					if (entity.rotationPitch > 67.5 && entity.rotationPitch < 90) {
						{
							double _setval = (-0.5);
							entity.getCapability(DemonicblessingModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.fly_y = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
					}
					entity.setMotion(
							((entity.getCapability(DemonicblessingModVariables.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new DemonicblessingModVariables.PlayerVariables())).flyspeedreal
									* Math.cos((entity.rotationYaw + 90) * Math.PI / 180)),
							((entity.getCapability(DemonicblessingModVariables.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new DemonicblessingModVariables.PlayerVariables())).fly_y
									* (entity.getCapability(DemonicblessingModVariables.PLAYER_VARIABLES_CAPABILITY, null)
											.orElse(new DemonicblessingModVariables.PlayerVariables())).flyspeedreal),
							((entity.getCapability(DemonicblessingModVariables.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new DemonicblessingModVariables.PlayerVariables())).flyspeedreal
									* Math.sin((entity.rotationYaw + 90) * Math.PI / 180)));
					{
						double _setval = ((entity.getCapability(DemonicblessingModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new DemonicblessingModVariables.PlayerVariables())).fly_speed + 1);
						entity.getCapability(DemonicblessingModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.fly_speed = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof LivingEntity)
						((LivingEntity) entity).setHealth((float) (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1)
								+ entity.getPersistentData().getDouble("hpregen") * 2));
					if ((entity.getCapability(DemonicblessingModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new DemonicblessingModVariables.PlayerVariables())).fly_speed == 1000) {
						if (entity instanceof PlayerEntity)
							((PlayerEntity) entity).getCooldownTracker().setCooldown(itemstack.getItem(),
									(int) ((entity.getCapability(DemonicblessingModVariables.PLAYER_VARIABLES_CAPABILITY, null)
											.orElse(new DemonicblessingModVariables.PlayerVariables())).fly_speed / 2));
						entity.getPersistentData().putBoolean("fly", (false));
						{
							double _setval = 0;
							entity.getCapability(DemonicblessingModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.fly_speed = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
					}
				} else {
					if (entity.getPersistentData().getBoolean("purplehurt") == false) {
						if (entity instanceof LivingEntity)
							((LivingEntity) entity)
									.setHealth((float) (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1) - 1));
						entity.getPersistentData().putBoolean("purplehurt", (true));
						new Object() {
							private int ticks = 0;
							private float waitTicks;
							private IWorld world;

							public void start(IWorld world, int waitTicks) {
								this.waitTicks = waitTicks;
								MinecraftForge.EVENT_BUS.register(this);
								this.world = world;
							}

							@SubscribeEvent
							public void tick(TickEvent.ServerTickEvent event) {
								if (event.phase == TickEvent.Phase.END) {
									this.ticks += 1;
									if (this.ticks >= this.waitTicks)
										run();
								}
							}

							private void run() {
								entity.getPersistentData().putBoolean("purplehurt", (false));
								MinecraftForge.EVENT_BUS.unregister(this);
							}
						}.start(world, (int) 20);
					}
				}
			}
		}
	}
}
