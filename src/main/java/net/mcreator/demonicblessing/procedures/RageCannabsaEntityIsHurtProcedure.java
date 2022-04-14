package net.mcreator.demonicblessing.procedures;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.demonicblessing.DemonicblessingMod;

import java.util.Map;

public class RageCannabsaEntityIsHurtProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				DemonicblessingMod.LOGGER.warn("Failed to load dependency entity for procedure RageCannabsaEntityIsHurt!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (Math.random() > 0.9) {
			if (Math.random() > 0.5) {
				if (entity instanceof LivingEntity)
					((LivingEntity) entity).setHealth((float) (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1) + 300));
			}
		}
	}
}
