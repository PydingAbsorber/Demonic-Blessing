package net.mcreator.demonicblessing.procedures;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.world.Explosion;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.demonicblessing.DemonicblessingMod;

import java.util.stream.Collectors;
import java.util.function.Function;
import java.util.Map;
import java.util.List;
import java.util.Comparator;

public class FinalPydingRageEntityIsHurtProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				DemonicblessingMod.LOGGER.warn("Failed to load dependency world for procedure FinalPydingRageEntityIsHurt!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				DemonicblessingMod.LOGGER.warn("Failed to load dependency x for procedure FinalPydingRageEntityIsHurt!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				DemonicblessingMod.LOGGER.warn("Failed to load dependency y for procedure FinalPydingRageEntityIsHurt!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				DemonicblessingMod.LOGGER.warn("Failed to load dependency z for procedure FinalPydingRageEntityIsHurt!");
			return;
		}
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				DemonicblessingMod.LOGGER.warn("Failed to load dependency entity for procedure FinalPydingRageEntityIsHurt!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		Entity entity = (Entity) dependencies.get("entity");
		if (entity.isAlive()) {
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).setHealth((float) (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1) + 20));
		}
		{
			List<Entity> _entfound = world
					.getEntitiesWithinAABB(Entity.class,
							new AxisAlignedBB(x - (30 / 2d), y - (30 / 2d), z - (30 / 2d), x + (30 / 2d), y + (30 / 2d), z + (30 / 2d)), null)
					.stream().sorted(new Object() {
						Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
							return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
						}
					}.compareDistOf(x, y, z)).collect(Collectors.toList());
			for (Entity entityiterator : _entfound) {
				if (!(entityiterator == entity)) {
					if (entityiterator instanceof LivingEntity)
						((LivingEntity) entityiterator).setHealth(
								(float) (((entityiterator instanceof LivingEntity) ? ((LivingEntity) entityiterator).getHealth() : -1) - 20));
				}
			}
		}
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
				if (!entity.world.isRemote())
					entity.remove();
				if (world instanceof ServerWorld) {
					((ServerWorld) world).spawnParticle(ParticleTypes.FLASH, x, y, z, (int) 40, 10, 10, 10, 2);
				}
				if (world instanceof World && !((World) world).isRemote) {
					((World) world).createExplosion(null, (int) x, (int) y, (int) z, (float) 10, Explosion.Mode.NONE);
				}
				MinecraftForge.EVENT_BUS.unregister(this);
			}
		}.start(world, (int) 666);
	}
}
