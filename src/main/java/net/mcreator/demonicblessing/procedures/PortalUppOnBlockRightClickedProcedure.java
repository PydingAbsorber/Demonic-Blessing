package net.mcreator.demonicblessing.procedures;

import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.Entity;

import net.mcreator.demonicblessing.DemonicblessingMod;

import java.util.Map;
import java.util.Collections;

public class PortalUppOnBlockRightClickedProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				DemonicblessingMod.LOGGER.warn("Failed to load dependency x for procedure PortalUppOnBlockRightClicked!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				DemonicblessingMod.LOGGER.warn("Failed to load dependency y for procedure PortalUppOnBlockRightClicked!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				DemonicblessingMod.LOGGER.warn("Failed to load dependency z for procedure PortalUppOnBlockRightClicked!");
			return;
		}
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				DemonicblessingMod.LOGGER.warn("Failed to load dependency entity for procedure PortalUppOnBlockRightClicked!");
			return;
		}
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		Entity entity = (Entity) dependencies.get("entity");
		{
			Entity _ent = entity;
			_ent.setPositionAndUpdate(x, (y + 21), z);
			if (_ent instanceof ServerPlayerEntity) {
				((ServerPlayerEntity) _ent).connection.setPlayerLocation(x, (y + 21), z, _ent.rotationYaw, _ent.rotationPitch,
						Collections.emptySet());
			}
		}
	}
}
