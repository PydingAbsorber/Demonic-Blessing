package net.mcreator.demonicblessing.procedures;

import net.mcreator.demonicblessing.item.FrostMourneItem;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EntityDamageSource;
import net.minecraft.util.Hand;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.eventbus.api.EventPriority;

import net.minecraft.world.World;
import net.minecraft.entity.Entity;

import java.util.Map;
import java.util.HashMap;

public class HurtEntityProcedure {
	@Mod.EventBusSubscriber
	private static class GlobalTrigger {
		@SubscribeEvent(priority = EventPriority.LOWEST) 
		public static void onEntityAttacked(LivingAttackEvent event) {
			if (event != null && event.getEntity() != null) {
				if (event.getEntity() instanceof PlayerEntity) {
					Entity entity = event.getEntity();
					ItemStack helditem = ((PlayerEntity) entity).getHeldItem(Hand.MAIN_HAND);
					if (helditem.getItem() != null && helditem.getItem() == FrostMourneItem.block) {
						if (helditem.getTag() != null) {
							int soul = helditem.getTag().getInt("souls");
							if (soul == 10000) {
								if (event.getSource() == DamageSource.OUT_OF_WORLD || event.getSource().isDamageAbsolute() == true && event.getSource().getDamageType() != "qwe_resictansetypoutofworld" && entity instanceof LivingEntity) {
									event.setCanceled(true);
									double damagecurrent = event.getAmount() * 0.25F;
									if (event.getSource().getTrueSource() != null) {
										entity.attackEntityFrom(new EntityDamageSource("qwe_resictansetypoutofworld", event.getSource().getTrueSource()).setDamageIsAbsolute(), (float) damagecurrent);
									} else {
										entity.attackEntityFrom(new DamageSource("qwe_resictansetypoutofworld").setDamageIsAbsolute(), (float) damagecurrent);
									}
								}
							}
						}
					}
				}
			}
		

		}
	}
	public static void executeProcedure(Map<String, Object> dependencies) {
	}
}
