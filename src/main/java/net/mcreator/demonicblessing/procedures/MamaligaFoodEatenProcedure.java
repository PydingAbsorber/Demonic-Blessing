package net.mcreator.demonicblessing.procedures;

import net.minecraft.potion.Effects;
import net.minecraft.potion.EffectInstance;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.demonicblessing.DemonicblessingMod;

import java.util.Map;

public class MamaligaFoodEatenProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				DemonicblessingMod.LOGGER.warn("Failed to load dependency entity for procedure MamaligaFoodEaten!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof LivingEntity)
			((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.RESISTANCE, (int) 2000, (int) 3));
		if (entity instanceof LivingEntity)
			((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.REGENERATION, (int) 400, (int) 3));
		if (entity instanceof LivingEntity) {
			((LivingEntity) entity).removePotionEffect(Effects.BLINDNESS);
		}
		if (entity instanceof LivingEntity) {
			((LivingEntity) entity).removePotionEffect(Effects.HUNGER);
		}
		if (entity instanceof LivingEntity) {
			((LivingEntity) entity).removePotionEffect(Effects.WEAKNESS);
		}
		if (entity instanceof LivingEntity) {
			((LivingEntity) entity).removePotionEffect(Effects.POISON);
		}
		if (entity instanceof LivingEntity) {
			((LivingEntity) entity).removePotionEffect(Effects.WITHER);
		}
		if (entity instanceof LivingEntity) {
			((LivingEntity) entity).removePotionEffect(Effects.UNLUCK);
		}
		if (entity instanceof LivingEntity) {
			((LivingEntity) entity).removePotionEffect(Effects.BAD_OMEN);
		}
	}
}
