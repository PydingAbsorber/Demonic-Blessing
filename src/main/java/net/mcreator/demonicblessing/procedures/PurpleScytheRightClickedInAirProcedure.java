package net.mcreator.demonicblessing.procedures;

import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import net.mcreator.demonicblessing.DemonicblessingModVariables;
import net.mcreator.demonicblessing.DemonicblessingMod;

import java.util.Map;

public class PurpleScytheRightClickedInAirProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				DemonicblessingMod.LOGGER.warn("Failed to load dependency entity for procedure PurpleScytheRightClickedInAir!");
			return;
		}
		if (dependencies.get("itemstack") == null) {
			if (!dependencies.containsKey("itemstack"))
				DemonicblessingMod.LOGGER.warn("Failed to load dependency itemstack for procedure PurpleScytheRightClickedInAir!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		ItemStack itemstack = (ItemStack) dependencies.get("itemstack");
		if (entity.getPersistentData().getBoolean("fly") == false) {
			entity.getPersistentData().putBoolean("fly", (true));
		} else {
			entity.getPersistentData().putBoolean("fly", (false));
			if (entity instanceof PlayerEntity)
				((PlayerEntity) entity).getCooldownTracker().setCooldown(itemstack.getItem(),
						(int) ((entity.getCapability(DemonicblessingModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new DemonicblessingModVariables.PlayerVariables())).fly_speed * 2));
			{
				double _setval = 0;
				entity.getCapability(DemonicblessingModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.fly_speed = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		{
			double _setval = (entity.getPersistentData().getDouble("hpregen") * 22.7);
			entity.getCapability(DemonicblessingModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.flyspeedreal = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
	}
}
