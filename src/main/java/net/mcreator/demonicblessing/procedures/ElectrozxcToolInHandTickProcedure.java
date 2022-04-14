package net.mcreator.demonicblessing.procedures;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.math.RayTraceContext;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.scoreboard.Scoreboard;
import net.minecraft.scoreboard.ScoreObjective;
import net.minecraft.scoreboard.ScoreCriteria;
import net.minecraft.scoreboard.Score;
import net.minecraft.potion.Effects;
import net.minecraft.potion.EffectInstance;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.effect.LightningBoltEntity;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.Entity;

import net.mcreator.demonicblessing.item.ElectrozxcItem;
import net.mcreator.demonicblessing.item.Crystal1Item;
import net.mcreator.demonicblessing.item.AmethystItem;
import net.mcreator.demonicblessing.DemonicblessingMod;

import java.util.stream.Collectors;
import java.util.function.Function;
import java.util.Map;
import java.util.List;
import java.util.Comparator;
import java.util.Collections;

public class ElectrozxcToolInHandTickProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				DemonicblessingMod.LOGGER.warn("Failed to load dependency world for procedure ElectrozxcToolInHandTick!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				DemonicblessingMod.LOGGER.warn("Failed to load dependency x for procedure ElectrozxcToolInHandTick!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				DemonicblessingMod.LOGGER.warn("Failed to load dependency y for procedure ElectrozxcToolInHandTick!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				DemonicblessingMod.LOGGER.warn("Failed to load dependency z for procedure ElectrozxcToolInHandTick!");
			return;
		}
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				DemonicblessingMod.LOGGER.warn("Failed to load dependency entity for procedure ElectrozxcToolInHandTick!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		Entity entity = (Entity) dependencies.get("entity");
		if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY).getItem() == ElectrozxcItem.block) {
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.HASTE, (int) 40, (int) 7));
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.SPEED, (int) 40, (int) 15));
			if ((entity instanceof PlayerEntity) ? ((PlayerEntity) entity).inventory.hasItemStack(new ItemStack(Crystal1Item.block)) : false) {
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
				}.getScore("tp") >= 1 && new Object() {
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
				}.getScore("cd") < 4) {
					{
						Entity _ent = entity;
						_ent.setPositionAndUpdate(
								(entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
										entity.getEyePosition(1f).add(entity.getLook(1f).x * 5, entity.getLook(1f).y * 5, entity.getLook(1f).z * 5),
										RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos().getX()),
								(entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
										entity.getEyePosition(1f).add(entity.getLook(1f).x * 5, entity.getLook(1f).y * 5, entity.getLook(1f).z * 5),
										RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos().getY()),
								(entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
										entity.getEyePosition(1f).add(entity.getLook(1f).x * 5, entity.getLook(1f).y * 5, entity.getLook(1f).z * 5),
										RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos().getZ()));
						if (_ent instanceof ServerPlayerEntity) {
							((ServerPlayerEntity) _ent).connection.setPlayerLocation(
									(entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
											entity.getEyePosition(1f).add(entity.getLook(1f).x * 5, entity.getLook(1f).y * 5,
													entity.getLook(1f).z * 5),
											RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos().getX()),
									(entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
											entity.getEyePosition(1f).add(entity.getLook(1f).x * 5, entity.getLook(1f).y * 5,
													entity.getLook(1f).z * 5),
											RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos().getY()),
									(entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
											entity.getEyePosition(1f).add(entity.getLook(1f).x * 5, entity.getLook(1f).y * 5,
													entity.getLook(1f).z * 5),
											RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos().getZ()),
									_ent.rotationYaw, _ent.rotationPitch, Collections.emptySet());
						}
					}
					{
						Entity _ent = entity;
						if (_ent instanceof PlayerEntity) {
							Scoreboard _sc = ((PlayerEntity) _ent).getWorldScoreboard();
							ScoreObjective _so = _sc.getObjective("tp");
							if (_so == null) {
								_so = _sc.addObjective("tp", ScoreCriteria.DUMMY, new StringTextComponent("tp"), ScoreCriteria.RenderType.INTEGER);
							}
							Score _scr = _sc.getOrCreateScore(((PlayerEntity) _ent).getScoreboardName(), _so);
							_scr.setScorePoints((int) 0);
						}
					}
					if (entity instanceof LivingEntity)
						((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.SLOW_FALLING, (int) 30, (int) 60));
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
					}.getScore("cd") == 1) {
						new Object() {
							private int ticks = 0;
							private float waitTicks;
							private IWorld world;

							public void start(IWorld world, int waitTicks) {
								this.waitTicks = waitTicks;
								MinecraftForge.EVENT_BUS.register(this);
								this.world = world;
							}

							@SubscribeEvent
							public void tick(TickEvent.ServerTickEvent event) {
								if (event.phase == TickEvent.Phase.END) {
									this.ticks += 1;
									if (this.ticks >= this.waitTicks)
										run();
								}
							}

							private void run() {
								{
									Entity _ent = entity;
									if (_ent instanceof PlayerEntity) {
										Scoreboard _sc = ((PlayerEntity) _ent).getWorldScoreboard();
										ScoreObjective _so = _sc.getObjective("cd");
										if (_so == null) {
											_so = _sc.addObjective("cd", ScoreCriteria.DUMMY, new StringTextComponent("cd"),
													ScoreCriteria.RenderType.INTEGER);
										}
										Score _scr = _sc.getOrCreateScore(((PlayerEntity) _ent).getScoreboardName(), _so);
										_scr.setScorePoints((int) 0);
									}
								}
								MinecraftForge.EVENT_BUS.unregister(this);
							}
						}.start(world, (int) 360);
					}
					if (world instanceof ServerWorld) {
						Entity entityToSpawn = new LightningBoltEntity(EntityType.LIGHTNING_BOLT, (World) world);
						entityToSpawn.setLocationAndAngles(x, y, z, world.getRandom().nextFloat() * 360F, 0);
						if (entityToSpawn instanceof MobEntity)
							((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
									world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED, (ILivingEntityData) null,
									(CompoundNBT) null);
						world.addEntity(entityToSpawn);
					}
					if (!((entity instanceof PlayerEntity)
							? ((PlayerEntity) entity).inventory.hasItemStack(new ItemStack(AmethystItem.block))
							: false)) {
						if (Math.random() < entity.getPersistentData().getDouble("critchance") / 100) {
							{
								List<Entity> _entfound = world.getEntitiesWithinAABB(Entity.class,
										new AxisAlignedBB(x - (20 / 2d), y - (20 / 2d), z - (20 / 2d), x + (20 / 2d), y + (20 / 2d), z + (20 / 2d)),
										null).stream().sorted(new Object() {
											Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
												return Comparator
														.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
											}
										}.compareDistOf(x, y, z)).collect(Collectors.toList());
								for (Entity entityiterator : _entfound) {
									if (entityiterator.getPersistentData().getBoolean("evade") == false) {
										entityiterator.attackEntityFrom(DamageSource.LIGHTNING_BOLT,
												(float) (1200 + 1200 * 0.01 * entity.getPersistentData().getDouble("critdamage")));
										entityiterator.attackEntityFrom(DamageSource.OUT_OF_WORLD,
												(float) (1300 + 1300 * 0.01 * entity.getPersistentData().getDouble("critdamage")));
									}
								}
							}
						} else {
							{
								List<Entity> _entfound = world.getEntitiesWithinAABB(Entity.class,
										new AxisAlignedBB(x - (20 / 2d), y - (20 / 2d), z - (20 / 2d), x + (20 / 2d), y + (20 / 2d), z + (20 / 2d)),
										null).stream().sorted(new Object() {
											Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
												return Comparator
														.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
											}
										}.compareDistOf(x, y, z)).collect(Collectors.toList());
								for (Entity entityiterator : _entfound) {
									if (entityiterator.getPersistentData().getBoolean("evade") == false) {
										entityiterator.attackEntityFrom(DamageSource.LIGHTNING_BOLT, (float) 1200);
										entityiterator.attackEntityFrom(DamageSource.OUT_OF_WORLD, (float) 1050);
									}
								}
							}
						}
					} else {
						if (Math.random() < entity.getPersistentData().getDouble("critchance") / 100) {
							{
								List<Entity> _entfound = world.getEntitiesWithinAABB(Entity.class,
										new AxisAlignedBB(x - (20 / 2d), y - (20 / 2d), z - (20 / 2d), x + (20 / 2d), y + (20 / 2d), z + (20 / 2d)),
										null).stream().sorted(new Object() {
											Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
												return Comparator
														.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
											}
										}.compareDistOf(x, y, z)).collect(Collectors.toList());
								for (Entity entityiterator : _entfound) {
									if (entityiterator.getPersistentData().getBoolean("evade") == false) {
										entityiterator.attackEntityFrom(DamageSource.OUT_OF_WORLD,
												(float) (1300 + 1300 * 0.01 * entity.getPersistentData().getDouble("critdamage")));
									}
								}
							}
						} else {
							{
								List<Entity> _entfound = world.getEntitiesWithinAABB(Entity.class,
										new AxisAlignedBB(x - (20 / 2d), y - (20 / 2d), z - (20 / 2d), x + (20 / 2d), y + (20 / 2d), z + (20 / 2d)),
										null).stream().sorted(new Object() {
											Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
												return Comparator
														.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
											}
										}.compareDistOf(x, y, z)).collect(Collectors.toList());
								for (Entity entityiterator : _entfound) {
									if (entityiterator.getPersistentData().getBoolean("evade") == false) {
										entityiterator.attackEntityFrom(DamageSource.OUT_OF_WORLD, (float) 1300);
									}
								}
							}
						}
					}
				}
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
				}.getScore("tp") >= 1 && new Object() {
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
				}.getScore("cd") >= 4) {
					{
						Entity _ent = entity;
						if (_ent instanceof PlayerEntity) {
							Scoreboard _sc = ((PlayerEntity) _ent).getWorldScoreboard();
							ScoreObjective _so = _sc.getObjective("tp");
							if (_so == null) {
								_so = _sc.addObjective("tp", ScoreCriteria.DUMMY, new StringTextComponent("tp"), ScoreCriteria.RenderType.INTEGER);
							}
							Score _scr = _sc.getOrCreateScore(((PlayerEntity) _ent).getScoreboardName(), _so);
							_scr.setScorePoints((int) 0);
						}
					}
				}
			}
			if (!((entity instanceof PlayerEntity) ? ((PlayerEntity) entity).inventory.hasItemStack(new ItemStack(Crystal1Item.block)) : false)) {
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
				}.getScore("tp") >= 1 && new Object() {
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
				}.getScore("cd") <= 1) {
					{
						Entity _ent = entity;
						_ent.setPositionAndUpdate(
								(entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
										entity.getEyePosition(1f).add(entity.getLook(1f).x * 5, entity.getLook(1f).y * 5, entity.getLook(1f).z * 5),
										RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos().getX()),
								(entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
										entity.getEyePosition(1f).add(entity.getLook(1f).x * 5, entity.getLook(1f).y * 5, entity.getLook(1f).z * 5),
										RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos().getY()),
								(entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
										entity.getEyePosition(1f).add(entity.getLook(1f).x * 5, entity.getLook(1f).y * 5, entity.getLook(1f).z * 5),
										RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos().getZ()));
						if (_ent instanceof ServerPlayerEntity) {
							((ServerPlayerEntity) _ent).connection.setPlayerLocation(
									(entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
											entity.getEyePosition(1f).add(entity.getLook(1f).x * 5, entity.getLook(1f).y * 5,
													entity.getLook(1f).z * 5),
											RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos().getX()),
									(entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
											entity.getEyePosition(1f).add(entity.getLook(1f).x * 5, entity.getLook(1f).y * 5,
													entity.getLook(1f).z * 5),
											RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos().getY()),
									(entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
											entity.getEyePosition(1f).add(entity.getLook(1f).x * 5, entity.getLook(1f).y * 5,
													entity.getLook(1f).z * 5),
											RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos().getZ()),
									_ent.rotationYaw, _ent.rotationPitch, Collections.emptySet());
						}
					}
					{
						Entity _ent = entity;
						if (_ent instanceof PlayerEntity) {
							Scoreboard _sc = ((PlayerEntity) _ent).getWorldScoreboard();
							ScoreObjective _so = _sc.getObjective("tp");
							if (_so == null) {
								_so = _sc.addObjective("tp", ScoreCriteria.DUMMY, new StringTextComponent("tp"), ScoreCriteria.RenderType.INTEGER);
							}
							Score _scr = _sc.getOrCreateScore(((PlayerEntity) _ent).getScoreboardName(), _so);
							_scr.setScorePoints((int) 0);
						}
					}
					if (entity instanceof LivingEntity)
						((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.SLOW_FALLING, (int) 30, (int) 60));
					if (world instanceof ServerWorld) {
						Entity entityToSpawn = new LightningBoltEntity(EntityType.LIGHTNING_BOLT, (World) world);
						entityToSpawn.setLocationAndAngles(x, y, z, world.getRandom().nextFloat() * 360F, 0);
						if (entityToSpawn instanceof MobEntity)
							((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
									world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED, (ILivingEntityData) null,
									(CompoundNBT) null);
						world.addEntity(entityToSpawn);
					}
					new Object() {
						private int ticks = 0;
						private float waitTicks;
						private IWorld world;

						public void start(IWorld world, int waitTicks) {
							this.waitTicks = waitTicks;
							MinecraftForge.EVENT_BUS.register(this);
							this.world = world;
						}

						@SubscribeEvent
						public void tick(TickEvent.ServerTickEvent event) {
							if (event.phase == TickEvent.Phase.END) {
								this.ticks += 1;
								if (this.ticks >= this.waitTicks)
									run();
							}
						}

						private void run() {
							{
								Entity _ent = entity;
								if (_ent instanceof PlayerEntity) {
									Scoreboard _sc = ((PlayerEntity) _ent).getWorldScoreboard();
									ScoreObjective _so = _sc.getObjective("cd");
									if (_so == null) {
										_so = _sc.addObjective("cd", ScoreCriteria.DUMMY, new StringTextComponent("cd"),
												ScoreCriteria.RenderType.INTEGER);
									}
									Score _scr = _sc.getOrCreateScore(((PlayerEntity) _ent).getScoreboardName(), _so);
									_scr.setScorePoints((int) 0);
								}
							}
							MinecraftForge.EVENT_BUS.unregister(this);
						}
					}.start(world, (int) 80);
					if (!((entity instanceof PlayerEntity)
							? ((PlayerEntity) entity).inventory.hasItemStack(new ItemStack(AmethystItem.block))
							: false)) {
						if (Math.random() < entity.getPersistentData().getDouble("critchance") / 100) {
							{
								List<Entity> _entfound = world.getEntitiesWithinAABB(Entity.class,
										new AxisAlignedBB(x - (20 / 2d), y - (20 / 2d), z - (20 / 2d), x + (20 / 2d), y + (20 / 2d), z + (20 / 2d)),
										null).stream().sorted(new Object() {
											Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
												return Comparator
														.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
											}
										}.compareDistOf(x, y, z)).collect(Collectors.toList());
								for (Entity entityiterator : _entfound) {
									if (entityiterator.getPersistentData().getBoolean("evade") == false) {
										entityiterator.attackEntityFrom(DamageSource.LIGHTNING_BOLT,
												(float) (1200 + 1200 * 0.01 * entity.getPersistentData().getDouble("critdamage")));
										entityiterator.attackEntityFrom(DamageSource.OUT_OF_WORLD,
												(float) (1300 + 1300 * 0.01 * entity.getPersistentData().getDouble("critdamage")));
									}
								}
							}
						} else {
							{
								List<Entity> _entfound = world.getEntitiesWithinAABB(Entity.class,
										new AxisAlignedBB(x - (20 / 2d), y - (20 / 2d), z - (20 / 2d), x + (20 / 2d), y + (20 / 2d), z + (20 / 2d)),
										null).stream().sorted(new Object() {
											Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
												return Comparator
														.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
											}
										}.compareDistOf(x, y, z)).collect(Collectors.toList());
								for (Entity entityiterator : _entfound) {
									if (entityiterator.getPersistentData().getBoolean("evade") == false) {
										entityiterator.attackEntityFrom(DamageSource.LIGHTNING_BOLT, (float) 1200);
										entityiterator.attackEntityFrom(DamageSource.OUT_OF_WORLD, (float) 1050);
									}
								}
							}
						}
					} else {
						if (Math.random() < entity.getPersistentData().getDouble("critchance") / 100) {
							{
								List<Entity> _entfound = world.getEntitiesWithinAABB(Entity.class,
										new AxisAlignedBB(x - (20 / 2d), y - (20 / 2d), z - (20 / 2d), x + (20 / 2d), y + (20 / 2d), z + (20 / 2d)),
										null).stream().sorted(new Object() {
											Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
												return Comparator
														.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
											}
										}.compareDistOf(x, y, z)).collect(Collectors.toList());
								for (Entity entityiterator : _entfound) {
									if (entityiterator.getPersistentData().getBoolean("evade") == false) {
										entityiterator.attackEntityFrom(DamageSource.OUT_OF_WORLD,
												(float) (1300 + 1300 * 0.01 * entity.getPersistentData().getDouble("critdamage")));
									}
								}
							}
						} else {
							{
								List<Entity> _entfound = world.getEntitiesWithinAABB(Entity.class,
										new AxisAlignedBB(x - (20 / 2d), y - (20 / 2d), z - (20 / 2d), x + (20 / 2d), y + (20 / 2d), z + (20 / 2d)),
										null).stream().sorted(new Object() {
											Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
												return Comparator
														.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
											}
										}.compareDistOf(x, y, z)).collect(Collectors.toList());
								for (Entity entityiterator : _entfound) {
									if (entityiterator.getPersistentData().getBoolean("evade") == false) {
										entityiterator.attackEntityFrom(DamageSource.OUT_OF_WORLD, (float) 1300);
									}
								}
							}
						}
					}
				}
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
				}.getScore("tp") >= 1 && new Object() {
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
				}.getScore("cd") > 1) {
					{
						Entity _ent = entity;
						if (_ent instanceof PlayerEntity) {
							Scoreboard _sc = ((PlayerEntity) _ent).getWorldScoreboard();
							ScoreObjective _so = _sc.getObjective("tp");
							if (_so == null) {
								_so = _sc.addObjective("tp", ScoreCriteria.DUMMY, new StringTextComponent("tp"), ScoreCriteria.RenderType.INTEGER);
							}
							Score _scr = _sc.getOrCreateScore(((PlayerEntity) _ent).getScoreboardName(), _so);
							_scr.setScorePoints((int) 0);
						}
					}
				}
			}
		}
	}
}
