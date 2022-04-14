package net.mcreator.demonicblessing.procedures;

import net.minecraftforge.items.ItemHandlerHelper;

import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import net.mcreator.demonicblessing.item.YellowdiamondItem;
import net.mcreator.demonicblessing.item.RutilItem;
import net.mcreator.demonicblessing.item.RedBerillItem;
import net.mcreator.demonicblessing.item.MorganitItem;
import net.mcreator.demonicblessing.item.KinovariItem;
import net.mcreator.demonicblessing.item.JadeitItem;
import net.mcreator.demonicblessing.item.GoshenitItem;
import net.mcreator.demonicblessing.item.FossItem;
import net.mcreator.demonicblessing.item.BeniotitItem;
import net.mcreator.demonicblessing.item.AlmazItem;
import net.mcreator.demonicblessing.DemonicblessingMod;

import java.util.Map;

public class MoonblockBlockDestroyedByPlayerProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				DemonicblessingMod.LOGGER.warn("Failed to load dependency entity for procedure MoonblockBlockDestroyedByPlayer!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (Math.random() > 0.9) {
			if (Math.random() > 0.9) {
				if (Math.random() > 0.9) {
					if (Math.random() > 0.1) {
						if (entity instanceof PlayerEntity) {
							ItemStack _setstack = new ItemStack(FossItem.block);
							_setstack.setCount((int) 1);
							ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
						}
					}
					if (Math.random() > 0.1) {
						if (entity instanceof PlayerEntity) {
							ItemStack _setstack = new ItemStack(MorganitItem.block);
							_setstack.setCount((int) 1);
							ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
						}
					}
					if (Math.random() > 0.1) {
						if (entity instanceof PlayerEntity) {
							ItemStack _setstack = new ItemStack(GoshenitItem.block);
							_setstack.setCount((int) 1);
							ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
						}
					}
					if (Math.random() > 0.1) {
						if (entity instanceof PlayerEntity) {
							ItemStack _setstack = new ItemStack(RutilItem.block);
							_setstack.setCount((int) 1);
							ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
						}
					}
					if (Math.random() > 0.1) {
						if (entity instanceof PlayerEntity) {
							ItemStack _setstack = new ItemStack(RedBerillItem.block);
							_setstack.setCount((int) 1);
							ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
						}
					}
					if (Math.random() > 0.1) {
						if (entity instanceof PlayerEntity) {
							ItemStack _setstack = new ItemStack(BeniotitItem.block);
							_setstack.setCount((int) 1);
							ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
						}
					}
					if (Math.random() > 0.1) {
						if (entity instanceof PlayerEntity) {
							ItemStack _setstack = new ItemStack(KinovariItem.block);
							_setstack.setCount((int) 1);
							ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
						}
					}
					if (Math.random() > 0.1) {
						if (entity instanceof PlayerEntity) {
							ItemStack _setstack = new ItemStack(JadeitItem.block);
							_setstack.setCount((int) 1);
							ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
						}
					}
					if (Math.random() > 0.1) {
						if (entity instanceof PlayerEntity) {
							ItemStack _setstack = new ItemStack(AlmazItem.block);
							_setstack.setCount((int) 1);
							ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
						}
					}
					if (Math.random() > 0.1) {
						if (entity instanceof PlayerEntity) {
							ItemStack _setstack = new ItemStack(YellowdiamondItem.block);
							_setstack.setCount((int) 1);
							ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
						}
					}
				}
			}
		}
	}
}
