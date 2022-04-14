package net.mcreator.demonicblessing.procedures;

import net.minecraft.util.DamageSource;
import net.minecraft.entity.Entity;

import net.mcreator.demonicblessing.DemonicblessingMod;

import java.util.Map;

public class IchigoSwordLivingEntityIsHitWithToolProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				DemonicblessingMod.LOGGER.warn("Failed to load dependency entity for procedure IchigoSwordLivingEntityIsHitWithTool!");
			return;
		}
		if (dependencies.get("sourceentity") == null) {
			if (!dependencies.containsKey("sourceentity"))
				DemonicblessingMod.LOGGER.warn("Failed to load dependency sourceentity for procedure IchigoSwordLivingEntityIsHitWithTool!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		Entity sourceentity = (Entity) dependencies.get("sourceentity");
		if (Math.random() < sourceentity.getPersistentData().getDouble("critchance") / 100) {
			entity.attackEntityFrom(DamageSource.DRAGON_BREATH, (float) (50 + 50 * 0.01 * sourceentity.getPersistentData().getDouble("critdamage")));
		} else {
			entity.attackEntityFrom(DamageSource.DRAGON_BREATH, (float) 50);
		}
	}
}
