package net.mcreator.demonicblessing.procedures;

import net.minecraft.util.DamageSource;
import net.minecraft.entity.Entity;

import net.mcreator.demonicblessing.DemonicblessingMod;

import java.util.Map;

public class LunarianSwordLivingEntityIsHitWithToolProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				DemonicblessingMod.LOGGER.warn("Failed to load dependency entity for procedure LunarianSwordLivingEntityIsHitWithTool!");
			return;
		}
		if (dependencies.get("sourceentity") == null) {
			if (!dependencies.containsKey("sourceentity"))
				DemonicblessingMod.LOGGER.warn("Failed to load dependency sourceentity for procedure LunarianSwordLivingEntityIsHitWithTool!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		Entity sourceentity = (Entity) dependencies.get("sourceentity");
		if (Math.random() < sourceentity.getPersistentData().getDouble("critchance") / 100) {
			entity.attackEntityFrom(DamageSource.STARVE, (float) (4000 + 4000 * 0.01 * sourceentity.getPersistentData().getDouble("critdamage")));
			entity.attackEntityFrom(DamageSource.WITHER, (float) (200 + 200 * 0.01 * sourceentity.getPersistentData().getDouble("critdamage")));
		} else {
			entity.attackEntityFrom(DamageSource.STARVE, (float) 4000);
			entity.attackEntityFrom(DamageSource.WITHER, (float) 200);
		}
	}
}
