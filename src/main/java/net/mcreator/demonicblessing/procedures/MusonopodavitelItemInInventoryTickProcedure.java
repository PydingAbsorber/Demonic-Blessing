package net.mcreator.demonicblessing.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.RayTraceContext;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.potion.Effects;
import net.minecraft.potion.EffectInstance;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.demonicblessing.DemonicblessingMod;

import java.util.stream.Collectors;
import java.util.function.Function;
import java.util.Map;
import java.util.List;
import java.util.Comparator;

public class MusonopodavitelItemInInventoryTickProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				DemonicblessingMod.LOGGER.warn("Failed to load dependency world for procedure MusonopodavitelItemInInventoryTick!");
			return;
		}
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				DemonicblessingMod.LOGGER.warn("Failed to load dependency entity for procedure MusonopodavitelItemInInventoryTick!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		Entity entity = (Entity) dependencies.get("entity");
		{
			List<Entity> _entfound = world
					.getEntitiesWithinAABB(Entity.class,
							new AxisAlignedBB(
									(entity.world.rayTraceBlocks(
											new RayTraceContext(entity.getEyePosition(1f),
													entity.getEyePosition(1f).add(entity.getLook(1f).x * 60, entity.getLook(1f).y * 60,
															entity.getLook(1f).z * 60),
													RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
											.getPos().getX()) - (2 / 2d),
									(entity.world
											.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
													entity.getEyePosition(1f)
															.add(entity.getLook(1f).x * 60, entity.getLook(1f).y * 60, entity.getLook(1f).z * 60),
													RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
											.getPos().getY())
											- (2 / 2d),
									(entity.world
											.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
													entity.getEyePosition(1f)
															.add(entity.getLook(1f).x * 60, entity.getLook(1f).y * 60, entity.getLook(1f).z * 60),
													RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
											.getPos().getZ())
											- (2 / 2d),
									(entity.world
											.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
													entity.getEyePosition(1f)
															.add(entity.getLook(1f).x * 60, entity.getLook(1f).y * 60, entity.getLook(1f).z * 60),
													RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
											.getPos().getX()) + (2 / 2d),
									(entity.world
											.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
													entity.getEyePosition(1f)
															.add(entity.getLook(1f).x * 60, entity.getLook(1f).y * 60, entity.getLook(1f).z * 60),
													RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
											.getPos().getY()) + (2 / 2d),
									(entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
											entity.getEyePosition(1f).add(entity.getLook(1f).x * 60, entity.getLook(1f).y * 60,
													entity.getLook(1f).z * 60),
											RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos().getZ()) + (2 / 2d)),
							null)
					.stream().sorted(new Object() {
						Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
							return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
						}
					}.compareDistOf(
							(entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
									entity.getEyePosition(1f).add(entity.getLook(1f).x * 60, entity.getLook(1f).y * 60, entity.getLook(1f).z * 60),
									RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos().getX()),
							(entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
									entity.getEyePosition(1f).add(entity.getLook(1f).x * 60, entity.getLook(1f).y * 60, entity.getLook(1f).z * 60),
									RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos().getY()),
							(entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
									entity.getEyePosition(1f).add(entity.getLook(1f).x * 60, entity.getLook(1f).y * 60, entity.getLook(1f).z * 60),
									RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos().getZ())))
					.collect(Collectors.toList());
			for (Entity entityiterator : _entfound) {
				if (entityiterator instanceof LivingEntity)
					((LivingEntity) entityiterator).addPotionEffect(new EffectInstance(Effects.BLINDNESS, (int) 20, (int) 3));
				if (entityiterator instanceof LivingEntity)
					((LivingEntity) entityiterator).addPotionEffect(new EffectInstance(Effects.SLOWNESS, (int) 20, (int) 250));
				if (entityiterator instanceof LivingEntity)
					((LivingEntity) entityiterator).addPotionEffect(new EffectInstance(Effects.WITHER, (int) 20, (int) 250));
			}
		}
	}
}
