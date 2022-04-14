package net.mcreator.demonicblessing.procedures;

import net.minecraft.util.DamageSource;
import net.minecraft.entity.Entity;

import net.mcreator.demonicblessing.DemonicblessingMod;

import java.util.Map;

public class BankaiLivingEntityIsHitWithToolProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				DemonicblessingMod.LOGGER.warn("Failed to load dependency entity for procedure BankaiLivingEntityIsHitWithTool!");
			return;
		}
		if (dependencies.get("sourceentity") == null) {
			if (!dependencies.containsKey("sourceentity"))
				DemonicblessingMod.LOGGER.warn("Failed to load dependency sourceentity for procedure BankaiLivingEntityIsHitWithTool!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		Entity sourceentity = (Entity) dependencies.get("sourceentity");
		if (Math.random() < sourceentity.getPersistentData().getDouble("critchance") / 100) {
			entity.attackEntityFrom(DamageSource.OUT_OF_WORLD, (float) (100 + 100 * 0.01 * sourceentity.getPersistentData().getDouble("critdamage")));
			entity.attackEntityFrom(DamageSource.LIGHTNING_BOLT,
					(float) (100 + 100 * 0.01 * sourceentity.getPersistentData().getDouble("critdamage")));
		} else {
			entity.attackEntityFrom(DamageSource.OUT_OF_WORLD, (float) 100);
			entity.attackEntityFrom(DamageSource.LIGHTNING_BOLT, (float) 100);
		}
	}
}
