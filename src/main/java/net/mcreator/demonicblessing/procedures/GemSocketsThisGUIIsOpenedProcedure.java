package net.mcreator.demonicblessing.procedures;

import net.minecraft.entity.Entity;

import net.mcreator.demonicblessing.DemonicblessingModVariables;
import net.mcreator.demonicblessing.DemonicblessingMod;

import java.util.Map;

public class GemSocketsThisGUIIsOpenedProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				DemonicblessingMod.LOGGER.warn("Failed to load dependency entity for procedure GemSocketsThisGUIIsOpened!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		{
			double _setval = (entity.getPersistentData().getDouble("critdamage"));
			entity.getCapability(DemonicblessingModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.critdamage = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		{
			double _setval = (entity.getPersistentData().getDouble("critchance"));
			entity.getCapability(DemonicblessingModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.critchance = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		{
			double _setval = (entity.getPersistentData().getDouble("maxhp"));
			entity.getCapability(DemonicblessingModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.maxhp = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		{
			double _setval = (entity.getPersistentData().getDouble("hpregen"));
			entity.getCapability(DemonicblessingModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.hpregen = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		{
			double _setval = (entity.getPersistentData().getDouble("powerrank"));
			entity.getCapability(DemonicblessingModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.powerrank = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
	}
}
