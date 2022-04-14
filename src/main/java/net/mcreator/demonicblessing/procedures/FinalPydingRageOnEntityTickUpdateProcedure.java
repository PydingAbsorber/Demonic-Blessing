package net.mcreator.demonicblessing.procedures;

import net.minecraft.potion.Effects;
import net.minecraft.potion.EffectInstance;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.demonicblessing.DemonicblessingMod;

import java.util.Map;

public class FinalPydingRageOnEntityTickUpdateProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				DemonicblessingMod.LOGGER.warn("Failed to load dependency entity for procedure FinalPydingRageOnEntityTickUpdate!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof LivingEntity)
			((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.REGENERATION, (int) 60, (int) 255, (false), (false)));
		if (entity instanceof LivingEntity)
			((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.RESISTANCE, (int) 60, (int) 255, (false), (false)));
		if (entity instanceof LivingEntity)
			((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.ABSORPTION, (int) 60, (int) 255, (false), (false)));
		if (entity.isAlive()) {
			if (entity.rotationPitch > -22.5 && entity.rotationPitch < 22.5) {
				entity.getPersistentData().putDouble("angle", 0);
			}
			if (entity.rotationPitch < -22.5 && entity.rotationPitch > -45) {
				entity.getPersistentData().putDouble("angle", 0.25);
			}
			if (entity.rotationPitch < -45 && entity.rotationPitch > -67.5) {
				entity.getPersistentData().putDouble("angle", 0.6);
			}
			if (entity.rotationPitch < -67.5 && entity.rotationPitch > -90) {
				entity.getPersistentData().putDouble("angle", 1);
			}
			if (entity.rotationPitch > 22.5 && entity.rotationPitch < 45) {
				entity.getPersistentData().putDouble("angle", (-0.1));
			}
			if (entity.rotationPitch > 45 && entity.rotationPitch < 67.5) {
				entity.getPersistentData().putDouble("angle", (-0.25));
			}
			if (entity.rotationPitch > 67.5 && entity.rotationPitch < 90) {
				entity.getPersistentData().putDouble("angle", (-0.5));
			}
			entity.setMotion((4 * Math.cos((entity.rotationYaw + 90) * Math.PI / 180)), (4 * entity.getPersistentData().getDouble("angle")),
					(4 * Math.sin((entity.rotationYaw + 90) * Math.PI / 180)));
		}
	}
}
