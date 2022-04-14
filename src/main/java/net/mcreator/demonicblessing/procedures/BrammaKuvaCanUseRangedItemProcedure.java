package net.mcreator.demonicblessing.procedures;

import net.minecraft.item.ItemStack;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.demonicblessing.item.BrammaKuvaItem;
import net.mcreator.demonicblessing.DemonicblessingMod;

import java.util.Map;

public class BrammaKuvaCanUseRangedItemProcedure {

	public static boolean executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				DemonicblessingMod.LOGGER.warn("Failed to load dependency entity for procedure BrammaKuvaCanUseRangedItem!");
			return false;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY).getItem() == BrammaKuvaItem.block) {
			return true;
		}
		return false;
	}
}
