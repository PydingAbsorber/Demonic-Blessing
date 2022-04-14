package net.mcreator.demonicblessing.procedures;

import net.minecraft.util.Direction;
import net.minecraft.potion.Effects;
import net.minecraft.potion.EffectInstance;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.demonicblessing.DemonicblessingMod;

import java.util.Map;

public class Popoo2LivingEntityIsHitWithItemProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("direction") == null) {
			if (!dependencies.containsKey("direction"))
				DemonicblessingMod.LOGGER.warn("Failed to load dependency direction for procedure Popoo2LivingEntityIsHitWithItem!");
			return;
		}
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				DemonicblessingMod.LOGGER.warn("Failed to load dependency entity for procedure Popoo2LivingEntityIsHitWithItem!");
			return;
		}
		Direction direction = (Direction) dependencies.get("direction");
		Entity entity = (Entity) dependencies.get("entity");
		if (direction.getAxis() == (entity.getHorizontalFacing()).getAxis()) {
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.WITHER, (int) 100, (int) 30));
		}
	}
}
