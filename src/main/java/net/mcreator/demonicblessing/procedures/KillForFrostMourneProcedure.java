package net.mcreator.demonicblessing.procedures;

import net.mcreator.demonicblessing.item.FrostMourneItem;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;

import net.minecraft.world.World;
import net.minecraft.entity.Entity;

import java.util.Map;
import java.util.HashMap;

public class KillForFrostMourneProcedure {
	@Mod.EventBusSubscriber
	private static class GlobalTrigger {
		@SubscribeEvent
		public static void onEntityDeath(LivingDeathEvent event) {
			if (event.getSource().getTrueSource() != null && event.getSource().getTrueSource() instanceof PlayerEntity) {
				PlayerEntity player = (PlayerEntity) event.getSource().getTrueSource();
				ItemStack helditems = player.getHeldItem(Hand.MAIN_HAND);
				if (helditems.getItem() != null && helditems.getItem() == FrostMourneItem.block) {
					if (helditems.getOrCreateTag().getCompound("souls") == null) {
						helditems.getOrCreateTag().putInt("souls", 1);
					} else if (helditems.getTag().getInt("souls") < 10000) {
						helditems.getOrCreateTag().putInt("souls", helditems.getTag().getInt("souls")+1);
					}
				}
			}
		}
	}
	public static void executeProcedure(Map<String, Object> dependencies) {
	}
}
