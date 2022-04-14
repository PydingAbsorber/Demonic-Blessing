package net.mcreator.demonicblessing.procedures;

import net.minecraft.world.gen.Heightmap;
import net.minecraft.world.IWorld;

import net.mcreator.demonicblessing.DemonicblessingMod;

import java.util.Map;

public class DungeonAdditionalGenerationConditionProcedure {

	public static boolean executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				DemonicblessingMod.LOGGER.warn("Failed to load dependency world for procedure DungeonAdditionalGenerationCondition!");
			return false;
		}
		IWorld world = (IWorld) dependencies.get("world");
		if (world.getHeight(Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, (int) 0, (int) 0) == 70) {
			return true;
		}
		return false;
	}
}
