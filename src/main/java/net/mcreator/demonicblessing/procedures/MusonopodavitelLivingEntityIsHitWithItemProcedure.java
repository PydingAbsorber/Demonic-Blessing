package net.mcreator.demonicblessing.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.eventbus.api.Event.Result;
import net.minecraftforge.eventbus.api.EventPriority;

import net.minecraft.world.World;
import net.minecraft.util.DamageSource;
import net.minecraft.potion.Effects;
import net.minecraft.potion.EffectInstance;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;
import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.potion.Effects;
import net.minecraft.potion.EffectInstance;
import net.minecraft.item.ItemStack;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EntityDamageSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.server.ServerBossInfo;
import net.minecraft.world.World;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.IServerWorld;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.BossInfo;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.DamageSource;
import net.minecraft.pathfinding.FlyingPathNavigator;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.network.IPacket;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.item.Item;
import net.minecraft.entity.projectile.PotionEntity;
import net.minecraft.entity.projectile.ArrowEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.ai.goal.RandomWalkingGoal;
import net.minecraft.entity.ai.goal.NearestAttackableTargetGoal;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
import net.minecraft.entity.ai.goal.LookAtGoal;
import net.minecraft.entity.ai.goal.HurtByTargetGoal;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.ai.controller.FlyingMovementController;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.Entity;
import net.minecraft.entity.CreatureAttribute;
import net.minecraft.block.BlockState;
import net.minecraft.entity.CreatureEntity;

import net.mcreator.demonicblessing.potion.KaynBuffPotionEffect;
import net.mcreator.demonicblessing.potion.DarkinBuffPotionEffect;
import net.mcreator.demonicblessing.item.MusonopodavitelItem;
import net.mcreator.demonicblessing.DemonicblessingMod;

import java.util.Map;
import java.util.HashMap;
import net.minecraftforge.eventbus.api.EventPriority;

public class MusonopodavitelLivingEntityIsHitWithItemProcedure {
	@Mod.EventBusSubscriber
	private static class GlobalTrigger {
		@SubscribeEvent
		public static void onEntityAttacked(LivingAttackEvent event) {
			if (event != null && event.getEntity() != null) {
				Entity entity = event.getEntity();
				Entity sourceentity = event.getSource().getTrueSource();
				Entity imediatesourceentity = event.getSource().getImmediateSource();
				double i = entity.getPosX();
				double j = entity.getPosY();
				double k = entity.getPosZ();
				double amount = event.getAmount();
				World world = entity.world;
				Map<String, Object> dependencies = new HashMap<>();
				dependencies.put("x", i);
				dependencies.put("y", j);
				dependencies.put("z", k);
				dependencies.put("amount", amount);
				dependencies.put("world", world);
				dependencies.put("entity", entity);
				dependencies.put("sourceentity", sourceentity);
				dependencies.put("imediatesourceentity", imediatesourceentity);
				dependencies.put("event", event);
				executeProcedure(dependencies);
			}
			     
									
		}
	}
	@SubscribeEvent(priority = EventPriority.HIGHEST)     
										public void onLivingDeath(LivingDeathEvent event) {
											if (event.getEntityLiving() instanceof PlayerEntity) {   
												PlayerEntity player = (PlayerEntity) event.getEntityLiving();
												
									
															event.setCanceled(false);
														
												}
												}
	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				DemonicblessingMod.LOGGER.warn("Failed to load dependency entity for procedure MusonopodavitelLivingEntityIsHitWithItem!");
			return;
		}
		if (dependencies.get("sourceentity") == null) {
			if (!dependencies.containsKey("sourceentity"))
				DemonicblessingMod.LOGGER.warn("Failed to load dependency sourceentity for procedure MusonopodavitelLivingEntityIsHitWithItem!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		Entity sourceentity = (Entity) dependencies.get("sourceentity");
		if (((sourceentity instanceof PlayerEntity)
				? ((PlayerEntity) sourceentity).inventory.hasItemStack(new ItemStack(MusonopodavitelItem.block))
				: false)) {
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.SLOWNESS, (int) 100, (int) 30));
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.BLINDNESS, (int) 100, (int) 30));
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.WEAKNESS, (int) 100, (int) 10));
			if (entity instanceof LivingEntity) {
				((LivingEntity) entity).removePotionEffect(Effects.STRENGTH);
			}
			if (entity instanceof LivingEntity) {
				((LivingEntity) entity).removePotionEffect(Effects.REGENERATION);
			}
			if (entity instanceof LivingEntity) {
				((LivingEntity) entity).removePotionEffect(Effects.RESISTANCE);
			}
			if (entity instanceof LivingEntity) {
				((LivingEntity) entity).removePotionEffect(Effects.INVISIBILITY);
			}
			if (entity instanceof LivingEntity) {
				((LivingEntity) entity).removePotionEffect(Effects.HEALTH_BOOST);
			}
			if (entity instanceof LivingEntity) {
				((LivingEntity) entity).removePotionEffect(Effects.ABSORPTION);
			}
			if (entity instanceof LivingEntity) {
				((LivingEntity) entity).removePotionEffect(Effects.HASTE);
			}
			if (entity instanceof LivingEntity) {
				((LivingEntity) entity).removePotionEffect(Effects.SPEED);
			}
			if (entity instanceof LivingEntity) {
				((LivingEntity) entity).removePotionEffect(DarkinBuffPotionEffect.potion);
			}
			if (entity instanceof LivingEntity) {
				((LivingEntity) entity).removePotionEffect(KaynBuffPotionEffect.potion);
			}
			if ((((entity instanceof LivingEntity)
					? ((LivingEntity) entity).getHealth()
					: -1) <= (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getMaxHealth() : -1) * 0.15))) {
				
				
			}
		}
	}

	

 
}
