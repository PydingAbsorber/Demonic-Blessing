package net.mcreator.demonicblessing.procedures;

import net.minecraft.world.World;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.demonicblessing.DemonicblessingMod;

import java.util.Map;

public class EkumeaOnEntityTickUpdateProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				DemonicblessingMod.LOGGER.warn("Failed to load dependency entity for procedure EkumeaOnEntityTickUpdate!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if ((entity.world.getDimensionKey()) == (World.OVERWORLD) || (entity.world.getDimensionKey()) == (World.THE_NETHER)
				|| (entity.world.getDimensionKey()) == (World.THE_END)) {
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).setHealth((float) 0);
		}
	}
}
