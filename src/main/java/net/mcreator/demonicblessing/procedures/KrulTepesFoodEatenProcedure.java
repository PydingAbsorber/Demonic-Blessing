package net.mcreator.demonicblessing.procedures;

import net.minecraft.entity.Entity;

import net.mcreator.demonicblessing.DemonicblessingMod;

import java.util.Map;

public class KrulTepesFoodEatenProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				DemonicblessingMod.LOGGER.warn("Failed to load dependency entity for procedure KrulTepesFoodEaten!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if ((entity.getPersistentData().getBoolean("angel") && entity.getPersistentData().getBoolean("demon")
				&& entity.getPersistentData().getBoolean("elf") && entity.getPersistentData().getBoolean("ghoul")) == false) {
			entity.getPersistentData().putBoolean("vampire", (true));
		}
	}
}
