package net.mcreator.demonicblessing.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.eventbus.api.Event.Result;
import net.minecraftforge.eventbus.api.EventPriority;

import net.minecraft.world.World;
import net.minecraft.potion.EffectInstance;
import net.minecraft.item.ItemStack;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
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



import net.mcreator.demonicblessing.potion.AbobochkaPotionEffect;
import net.mcreator.demonicblessing.item.StarArmorItem;
import net.mcreator.demonicblessing.DemonicblessingMod;
import net.mcreator.demonicblessing.item.ShadowArmorItem;
import net.mcreator.demonicblessing.item.VoidAmorItem;
import net.mcreator.demonicblessing.item.Crystal3Item;
import net.mcreator.demonicblessing.item.ElectrozxcItem;


import java.util.Map;
import java.util.HashMap;

public class StarArmorLeggingsTickEventProcedure {
	@Mod.EventBusSubscriber
	private static class GlobalTrigger {
		@SubscribeEvent(priority = EventPriority.HIGHEST) 
		public static void onEntityAttacked(LivingHurtEvent event) {
			if (event != null && event.getEntity() != null) {
				Entity entity = event.getEntity();
				Entity sourceentity = event.getSource().getTrueSource();
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
				dependencies.put("event", event);
				executeProcedure(dependencies);


				                  if ((((entity instanceof LivingEntity)
				? ((LivingEntity) entity).getItemStackFromSlot(EquipmentSlotType.fromSlotTypeAndIndex(EquipmentSlotType.Group.ARMOR, (int) 0))
				: ItemStack.EMPTY).getItem() == StarArmorItem.boots)) {
			if ((((entity instanceof LivingEntity)
					? ((LivingEntity) entity).getItemStackFromSlot(EquipmentSlotType.fromSlotTypeAndIndex(EquipmentSlotType.Group.ARMOR, (int) 1))
					: ItemStack.EMPTY).getItem() == StarArmorItem.legs)) {
				if ((((entity instanceof LivingEntity)
						? ((LivingEntity) entity).getItemStackFromSlot(EquipmentSlotType.fromSlotTypeAndIndex(EquipmentSlotType.Group.ARMOR, (int) 2))
						: ItemStack.EMPTY).getItem() == StarArmorItem.body)) {
					if ((((entity instanceof LivingEntity)
							? ((LivingEntity) entity)
									.getItemStackFromSlot(EquipmentSlotType.fromSlotTypeAndIndex(EquipmentSlotType.Group.ARMOR, (int) 3))
							: ItemStack.EMPTY).getItem() == StarArmorItem.helmet)) {
						

                                    //ya bydlo 
                                    if ((Math.random() < (0.75+((entity.getPersistentData().getDouble("maxhp"))/10000)))) {   
							        		event.setCanceled(true);
												
																	   
									}                                      
                                                          
											else	if (((sourceentity instanceof PlayerEntity)
												? ((PlayerEntity) sourceentity).inventory.hasItemStack(new ItemStack(Crystal3Item.block))
												: false)) {
														     if ((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
															.getItem() == ElectrozxcItem.block)) 
															{
	
							                                                     if ((Math.random() < (0.90+((entity.getPersistentData().getDouble("maxhp"))/10000)))) {   
																			        		event.setCanceled(true);
																								                                  
												                                    }         
												                          
															
															}
												         }						
															 }            
													}
                                                


													
												}
											}


											if ((((entity instanceof LivingEntity)
													? ((LivingEntity) entity).getItemStackFromSlot(EquipmentSlotType.fromSlotTypeAndIndex(EquipmentSlotType.Group.ARMOR, (int) 0))
													: ItemStack.EMPTY).getItem() == VoidAmorItem.boots)) {
												if ((((entity instanceof LivingEntity)
														? ((LivingEntity) entity).getItemStackFromSlot(EquipmentSlotType.fromSlotTypeAndIndex(EquipmentSlotType.Group.ARMOR, (int) 1))
														: ItemStack.EMPTY).getItem() == VoidAmorItem.legs)) {
													if ((((entity instanceof LivingEntity)
															? ((LivingEntity) entity)
																	.getItemStackFromSlot(EquipmentSlotType.fromSlotTypeAndIndex(EquipmentSlotType.Group.ARMOR, (int) 2))
															: ItemStack.EMPTY).getItem() == VoidAmorItem.body)) {
														if ((((entity instanceof LivingEntity)
																? ((LivingEntity) entity)
																		.getItemStackFromSlot(EquipmentSlotType.fromSlotTypeAndIndex(EquipmentSlotType.Group.ARMOR, (int) 3))
																: ItemStack.EMPTY).getItem() == VoidAmorItem.helmet)) {
															if (entity instanceof LivingEntity)
																                        ((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.RESISTANCE, (int) 10, (int) 3));															
																						event.setCanceled(true);
																						((LivingEntity) entity).setHealth((float) (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1) - ((20 * Math.random())-((entity.getPersistentData().getDouble("maxhp"))/200))));		   
																					}  
															
														}
													}
												}
											}
										



                                








										
		      
				  


			}
		}
	
	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				DemonicblessingMod.LOGGER.warn("Failed to load dependency entity for procedure StarArmorLeggingsTickEvent!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		
	}
}

