package net.mcreator.demonicblessing.procedures;

import net.minecraft.item.ItemStack;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.demonicblessing.item.PurpleScytheItem;
import net.mcreator.demonicblessing.DemonicblessingMod;

import java.util.Map;

public class FlyTimeDisplayOverlayIngameProcedure {

	public static boolean executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				DemonicblessingMod.LOGGER.warn("Failed to load dependency entity for procedure FlyTimeDisplayOverlayIngame!");
			return false;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
				.getItem() == PurpleScytheItem.block) {
			return true;
		}
		return false;
	}
}
