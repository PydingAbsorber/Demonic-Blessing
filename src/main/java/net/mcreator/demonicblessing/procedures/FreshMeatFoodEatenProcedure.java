package net.mcreator.demonicblessing.procedures;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.demonicblessing.DemonicblessingMod;

import java.util.Map;

public class FreshMeatFoodEatenProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				DemonicblessingMod.LOGGER.warn("Failed to load dependency entity for procedure FreshMeatFoodEaten!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if ((entity.getPersistentData().getBoolean("angel") && entity.getPersistentData().getBoolean("demon")
				&& entity.getPersistentData().getBoolean("elf") && entity.getPersistentData().getBoolean("vampire")) == false) {
			entity.getPersistentData().putDouble("meat", (entity.getPersistentData().getDouble("tagName") + 1));
			if (entity.getPersistentData().getDouble("meat") == 993) {
				entity.getPersistentData().putBoolean("ghoul", (true));
			}
		}
		if (entity instanceof LivingEntity)
			((LivingEntity) entity).setHealth((float) (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1) - 20));
	}
}
