package net.mcreator.demonicblessing.procedures;

import net.minecraft.entity.Entity;

import net.mcreator.demonicblessing.DemonicblessingMod;

import java.util.Map;

public class TimerDisplayOverlayIngameProcedure {

	public static boolean executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				DemonicblessingMod.LOGGER.warn("Failed to load dependency entity for procedure TimerDisplayOverlayIngame!");
			return false;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity.getPersistentData().getDouble("timer") > 0) {
			return true;
		}
		return false;
	}
}
