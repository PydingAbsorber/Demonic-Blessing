package net.mcreator.demonicblessing.procedures;

import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.demonicblessing.item.Mod3Item;
import net.mcreator.demonicblessing.item.Mod2Item;
import net.mcreator.demonicblessing.item.BrammaKuvaItem;
import net.mcreator.demonicblessing.DemonicblessingMod;

import java.util.Random;
import java.util.Map;

public class BrammaKuvaRangedItemUsedProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				DemonicblessingMod.LOGGER.warn("Failed to load dependency entity for procedure BrammaKuvaRangedItemUsed!");
			return;
		}
		if (dependencies.get("itemstack") == null) {
			if (!dependencies.containsKey("itemstack"))
				DemonicblessingMod.LOGGER.warn("Failed to load dependency itemstack for procedure BrammaKuvaRangedItemUsed!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		ItemStack itemstack = (ItemStack) dependencies.get("itemstack");
		if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY).getItem() == BrammaKuvaItem.block) {
			if ((entity instanceof PlayerEntity) ? ((PlayerEntity) entity).inventory.hasItemStack(new ItemStack(Mod3Item.block)) : false) {
				if (entity instanceof PlayerEntity)
					((PlayerEntity) entity).getCooldownTracker().setCooldown(itemstack.getItem(), (int) 10);
			} else {
				if (entity instanceof PlayerEntity)
					((PlayerEntity) entity).getCooldownTracker().setCooldown(itemstack.getItem(), (int) 28);
			}
		}
		if ((entity instanceof PlayerEntity) ? ((PlayerEntity) entity).inventory.hasItemStack(new ItemStack(Mod2Item.block)) : false) {
			if (Math.random() < 0.9) {
				if (entity instanceof LivingEntity) {
					Entity _ent = entity;
					if (!_ent.world.isRemote()) {
						BrammaKuvaItem.shoot(_ent.world, (LivingEntity) entity, new Random(), (float) 1, (float) 1050, (int) 0);
					}
				}
			}
		}
		if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY).getItem() == BrammaKuvaItem.block) {
			if (entity instanceof PlayerEntity)
				((PlayerEntity) entity).getCooldownTracker().setCooldown(itemstack.getItem(), (int) 200);
		}
	}
}
