package net.mcreator.demonicblessing.procedures;

import net.minecraft.entity.Entity;

import net.mcreator.demonicblessing.DemonicblessingMod;

import java.util.Map;

public class ResetClassProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				DemonicblessingMod.LOGGER.warn("Failed to load dependency entity for procedure ResetClass!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		entity.getPersistentData().putBoolean("vampire", (false));
		entity.getPersistentData().putBoolean("angel", (false));
		entity.getPersistentData().putBoolean("demon", (false));
		entity.getPersistentData().putBoolean("elf", (false));
		entity.getPersistentData().putBoolean("ghoul", (false));
	}
}
