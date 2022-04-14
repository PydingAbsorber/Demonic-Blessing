package net.mcreator.demonicblessing.procedures;

import net.minecraftforge.items.ItemHandlerHelper;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.ResourceLocation;
import net.minecraft.server.MinecraftServer;
import net.minecraft.scoreboard.Scoreboard;
import net.minecraft.scoreboard.ScoreObjective;
import net.minecraft.scoreboard.ScoreCriteria;
import net.minecraft.scoreboard.Score;
import net.minecraft.potion.EffectInstance;
import net.minecraft.item.ItemStack;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.advancements.Advancement;

import net.mcreator.demonicblessing.potion.BankaiEffectPotionEffect;
import net.mcreator.demonicblessing.item.StarArmorItem;
import net.mcreator.demonicblessing.item.RosaItem;
import net.mcreator.demonicblessing.item.Popoo2Item;
import net.mcreator.demonicblessing.item.MusonopodavitelItem;
import net.mcreator.demonicblessing.item.IchigoSwordItem;
import net.mcreator.demonicblessing.item.GovnoresourceItem;
import net.mcreator.demonicblessing.item.ElectriccrystalItem;
import net.mcreator.demonicblessing.item.BrammaKuvaItem;
import net.mcreator.demonicblessing.item.BerserkArmorItem;
import net.mcreator.demonicblessing.item.BankaiItem;
import net.mcreator.demonicblessing.block.NetherStarBlockBlock;
import net.mcreator.demonicblessing.DemonicblessingModVariables;
import net.mcreator.demonicblessing.DemonicblessingMod;

import java.util.stream.Collectors;
import java.util.function.Function;
import java.util.Map;
import java.util.List;
import java.util.Iterator;
import java.util.HashMap;
import java.util.Comparator;
import java.util.Collection;

public class PlayerTickupdateProcedure {
	@Mod.EventBusSubscriber
	private static class GlobalTrigger {
		@SubscribeEvent
		public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
			if (event.phase == TickEvent.Phase.END) {
				Entity entity = event.player;
				World world = entity.world;
				double i = entity.getPosX();
				double j = entity.getPosY();
				double k = entity.getPosZ();
				Map<String, Object> dependencies = new HashMap<>();
				dependencies.put("x", i);
				dependencies.put("y", j);
				dependencies.put("z", k);
				dependencies.put("world", world);
				dependencies.put("entity", entity);
				dependencies.put("event", event);
				executeProcedure(dependencies);
			}
		}
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				DemonicblessingMod.LOGGER.warn("Failed to load dependency world for procedure PlayerTickupdate!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				DemonicblessingMod.LOGGER.warn("Failed to load dependency x for procedure PlayerTickupdate!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				DemonicblessingMod.LOGGER.warn("Failed to load dependency y for procedure PlayerTickupdate!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				DemonicblessingMod.LOGGER.warn("Failed to load dependency z for procedure PlayerTickupdate!");
			return;
		}
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				DemonicblessingMod.LOGGER.warn("Failed to load dependency entity for procedure PlayerTickupdate!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		Entity entity = (Entity) dependencies.get("entity");
		if ((entity instanceof PlayerEntity) ? ((PlayerEntity) entity).inventory.hasItemStack(new ItemStack(BankaiItem.block)) : false) {
			if (!(new Object() {
				boolean check(Entity _entity) {
					if (_entity instanceof LivingEntity) {
						Collection<EffectInstance> effects = ((LivingEntity) _entity).getActivePotionEffects();
						for (EffectInstance effect : effects) {
							if (effect.getPotion() == BankaiEffectPotionEffect.potion)
								return true;
						}
					}
					return false;
				}
			}.check(entity))) {
				if (entity instanceof PlayerEntity) {
					ItemStack _stktoremove = new ItemStack(BankaiItem.block);
					((PlayerEntity) entity).inventory.func_234564_a_(p -> _stktoremove.getItem() == p.getItem(), (int) 1,
							((PlayerEntity) entity).container.func_234641_j_());
				}
				if (entity instanceof PlayerEntity) {
					ItemStack _setstack = new ItemStack(IchigoSwordItem.block);
					_setstack.setCount((int) 1);
					ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
				}
				if (entity instanceof PlayerEntity)
					((PlayerEntity) entity).getCooldownTracker().setCooldown(IchigoSwordItem.block, (int) 6000);
			}
		}
		if ((entity instanceof PlayerEntity) ? ((PlayerEntity) entity).inventory.hasItemStack(new ItemStack(Popoo2Item.block)) : false) {
			if (entity instanceof ServerPlayerEntity) {
				Advancement _adv = ((MinecraftServer) ((ServerPlayerEntity) entity).server).getAdvancementManager()
						.getAdvancement(new ResourceLocation("demonicblessing:bankai_achive"));
				AdvancementProgress _ap = ((ServerPlayerEntity) entity).getAdvancements().getProgress(_adv);
				if (!_ap.isDone()) {
					Iterator _iterator = _ap.getRemaningCriteria().iterator();
					while (_iterator.hasNext()) {
						String _criterion = (String) _iterator.next();
						((ServerPlayerEntity) entity).getAdvancements().grantCriterion(_adv, _criterion);
					}
				}
			}
		}
		if ((entity instanceof PlayerEntity) ? ((PlayerEntity) entity).inventory.hasItemStack(new ItemStack(GovnoresourceItem.block)) : false) {
			if (entity instanceof ServerPlayerEntity) {
				Advancement _adv = ((MinecraftServer) ((ServerPlayerEntity) entity).server).getAdvancementManager()
						.getAdvancement(new ResourceLocation("demonicblessing:prepare_final"));
				AdvancementProgress _ap = ((ServerPlayerEntity) entity).getAdvancements().getProgress(_adv);
				if (!_ap.isDone()) {
					Iterator _iterator = _ap.getRemaningCriteria().iterator();
					while (_iterator.hasNext()) {
						String _criterion = (String) _iterator.next();
						((ServerPlayerEntity) entity).getAdvancements().grantCriterion(_adv, _criterion);
					}
				}
			}
		}
		if ((entity instanceof PlayerEntity) ? ((PlayerEntity) entity).inventory.hasItemStack(new ItemStack(MusonopodavitelItem.block)) : false) {
			if (entity instanceof ServerPlayerEntity) {
				Advancement _adv = ((MinecraftServer) ((ServerPlayerEntity) entity).server).getAdvancementManager()
						.getAdvancement(new ResourceLocation("demonicblessing:death_of_ulquiorra"));
				AdvancementProgress _ap = ((ServerPlayerEntity) entity).getAdvancements().getProgress(_adv);
				if (!_ap.isDone()) {
					Iterator _iterator = _ap.getRemaningCriteria().iterator();
					while (_iterator.hasNext()) {
						String _criterion = (String) _iterator.next();
						((ServerPlayerEntity) entity).getAdvancements().grantCriterion(_adv, _criterion);
					}
				}
			}
		}
		if (world.getWorldInfo().getDayTime() < 12566 || world.getWorldInfo().getDayTime() > 22916) {
			{
				Entity _ent = entity;
				if (_ent instanceof PlayerEntity) {
					Scoreboard _sc = ((PlayerEntity) _ent).getWorldScoreboard();
					ScoreObjective _so = _sc.getObjective("night");
					if (_so == null) {
						_so = _sc.addObjective("night", ScoreCriteria.DUMMY, new StringTextComponent("night"), ScoreCriteria.RenderType.INTEGER);
					}
					Score _scr = _sc.getOrCreateScore(((PlayerEntity) _ent).getScoreboardName(), _so);
					_scr.setScorePoints((int) 0);
				}
			}
		}
		if (world.getWorldInfo().getDayTime() > 12566 && world.getWorldInfo().getDayTime() < 22916) {
			{
				Entity _ent = entity;
				if (_ent instanceof PlayerEntity) {
					Scoreboard _sc = ((PlayerEntity) _ent).getWorldScoreboard();
					ScoreObjective _so = _sc.getObjective("night");
					if (_so == null) {
						_so = _sc.addObjective("night", ScoreCriteria.DUMMY, new StringTextComponent("night"), ScoreCriteria.RenderType.INTEGER);
					}
					Score _scr = _sc.getOrCreateScore(((PlayerEntity) _ent).getScoreboardName(), _so);
					_scr.setScorePoints((int) 1);
				}
			}
		}
		if ((entity instanceof PlayerEntity) ? ((PlayerEntity) entity).inventory.hasItemStack(new ItemStack(MusonopodavitelItem.block)) : false) {
			if (new Object() {
				public int getScore(String score) {
					if (entity instanceof PlayerEntity) {
						Scoreboard _sc = ((PlayerEntity) entity).getWorldScoreboard();
						ScoreObjective _so = _sc.getObjective(score);
						if (_so != null) {
							Score _scr = _sc.getOrCreateScore(((PlayerEntity) entity).getScoreboardName(), _so);
							return _scr.getScorePoints();
						}
					}
					return 0;
				}
			}.getScore("muslo") == 1) {
				{
					List<Entity> _entfound = world
							.getEntitiesWithinAABB(Entity.class,
									new AxisAlignedBB(x - (10 / 2d), y - (10 / 2d), z - (10 / 2d), x + (10 / 2d), y + (10 / 2d), z + (10 / 2d)), null)
							.stream().sorted(new Object() {
								Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
									return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
								}
							}.compareDistOf(x, y, z)).collect(Collectors.toList());
					for (Entity entityiterator : _entfound) {
						if (!(entityiterator == entity)) {
							if (entityiterator instanceof LivingEntity)
								((LivingEntity) entityiterator).clearActivePotions();
						}
					}
				}
			}
		}
		if (entity.getPersistentData().getDouble("timer") > 0) {
			entity.getPersistentData().putDouble("timer", (entity.getPersistentData().getDouble("timer") - 1));
			entity.getPersistentData().putDouble("sec", (entity.getPersistentData().getDouble("timer") / 20));
		}
		if (entity.isAlive()) {
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).setHealth((float) (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1)
						+ entity.getPersistentData().getDouble("hpregen")));
		}
		if (!(((entity instanceof LivingEntity) ? ((LivingEntity) entity).getItemStackFromSlot(EquipmentSlotType.FEET) : ItemStack.EMPTY)
				.getItem() == StarArmorItem.boots)
				|| !(((entity instanceof LivingEntity) ? ((LivingEntity) entity).getItemStackFromSlot(EquipmentSlotType.LEGS) : ItemStack.EMPTY)
						.getItem() == StarArmorItem.legs)
				|| !(((entity instanceof LivingEntity) ? ((LivingEntity) entity).getItemStackFromSlot(EquipmentSlotType.CHEST) : ItemStack.EMPTY)
						.getItem() == StarArmorItem.body)
				|| !(((entity instanceof LivingEntity) ? ((LivingEntity) entity).getItemStackFromSlot(EquipmentSlotType.HEAD) : ItemStack.EMPTY)
						.getItem() == StarArmorItem.helmet)) {
			entity.getPersistentData().putBoolean("evade", (false));
		}
		{
			double _setval = ((1000 - (entity.getCapability(DemonicblessingModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new DemonicblessingModVariables.PlayerVariables())).fly_speed) / 20);
			entity.getCapability(DemonicblessingModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.fly_time = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		if (((entity instanceof PlayerEntity) ? ((PlayerEntity) entity).inventory.hasItemStack(new ItemStack(ElectriccrystalItem.block)) : false)
				|| ((entity instanceof PlayerEntity) ? ((PlayerEntity) entity).inventory.hasItemStack(new ItemStack(BrammaKuvaItem.block)) : false)) {
			if (entity instanceof ServerPlayerEntity) {
				Advancement _adv = ((MinecraftServer) ((ServerPlayerEntity) entity).server).getAdvancementManager()
						.getAdvancement(new ResourceLocation("demonicblessing:fuck_jresco"));
				AdvancementProgress _ap = ((ServerPlayerEntity) entity).getAdvancements().getProgress(_adv);
				if (!_ap.isDone()) {
					Iterator _iterator = _ap.getRemaningCriteria().iterator();
					while (_iterator.hasNext()) {
						String _criterion = (String) _iterator.next();
						((ServerPlayerEntity) entity).getAdvancements().grantCriterion(_adv, _criterion);
					}
				}
			}
		}
		if ((entity instanceof PlayerEntity) ? ((PlayerEntity) entity).inventory.hasItemStack(new ItemStack(RosaItem.block)) : false) {
			if (entity instanceof ServerPlayerEntity) {
				Advancement _adv = ((MinecraftServer) ((ServerPlayerEntity) entity).server).getAdvancementManager()
						.getAdvancement(new ResourceLocation("demonicblessing:second_step"));
				AdvancementProgress _ap = ((ServerPlayerEntity) entity).getAdvancements().getProgress(_adv);
				if (!_ap.isDone()) {
					Iterator _iterator = _ap.getRemaningCriteria().iterator();
					while (_iterator.hasNext()) {
						String _criterion = (String) _iterator.next();
						((ServerPlayerEntity) entity).getAdvancements().grantCriterion(_adv, _criterion);
					}
				}
			}
		}
		if ((entity instanceof PlayerEntity) ? ((PlayerEntity) entity).inventory.hasItemStack(new ItemStack(NetherStarBlockBlock.block)) : false) {
			if (entity instanceof ServerPlayerEntity) {
				Advancement _adv = ((MinecraftServer) ((ServerPlayerEntity) entity).server).getAdvancementManager()
						.getAdvancement(new ResourceLocation("demonicblessing:astral_step"));
				AdvancementProgress _ap = ((ServerPlayerEntity) entity).getAdvancements().getProgress(_adv);
				if (!_ap.isDone()) {
					Iterator _iterator = _ap.getRemaningCriteria().iterator();
					while (_iterator.hasNext()) {
						String _criterion = (String) _iterator.next();
						((ServerPlayerEntity) entity).getAdvancements().grantCriterion(_adv, _criterion);
					}
				}
			}
		}
		if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getItemStackFromSlot(EquipmentSlotType.FEET) : ItemStack.EMPTY)
				.getItem() == BerserkArmorItem.boots) {
			if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getItemStackFromSlot(EquipmentSlotType.LEGS) : ItemStack.EMPTY)
					.getItem() == BerserkArmorItem.legs) {
				if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getItemStackFromSlot(EquipmentSlotType.CHEST) : ItemStack.EMPTY)
						.getItem() == BerserkArmorItem.body) {
					if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getItemStackFromSlot(EquipmentSlotType.HEAD) : ItemStack.EMPTY)
							.getItem() == BerserkArmorItem.helmet) {
						entity.getPersistentData().putDouble("basecritchance",
								((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getMaxHealth() : -1)
										/ ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1) - 1) * 16));
						entity.getPersistentData().putDouble("basecritdamage",
								((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getMaxHealth() : -1)
										/ ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1) - 1) * 133));
						entity.getPersistentData().putDouble("basemaxhp",
								((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getMaxHealth() : -1)
										/ ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1) - 1) * 266));
						entity.getPersistentData().putDouble("basehpregen",
								((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getMaxHealth() : -1)
										/ ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1) - 1) * 0.015));
					}
				}
			}
		}
		entity.getPersistentData().putDouble("sethealth", (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getMaxHealth() : -1)
				/ ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1)));
	}
}
