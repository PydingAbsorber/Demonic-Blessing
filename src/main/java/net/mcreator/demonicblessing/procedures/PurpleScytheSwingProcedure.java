package net.mcreator.demonicblessing.procedures;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.IWorld;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.math.RayTraceContext;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.ResourceLocation;
import net.minecraft.server.MinecraftServer;
import net.minecraft.scoreboard.Scoreboard;
import net.minecraft.scoreboard.ScoreObjective;
import net.minecraft.scoreboard.ScoreCriteria;
import net.minecraft.scoreboard.Score;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.advancements.Advancement;

import net.mcreator.demonicblessing.DemonicblessingMod;

import java.util.stream.Collectors;
import java.util.function.Function;
import java.util.Map;
import java.util.List;
import java.util.Iterator;
import java.util.Comparator;

public class PurpleScytheSwingProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				DemonicblessingMod.LOGGER.warn("Failed to load dependency world for procedure PurpleScytheSwing!");
			return;
		}
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				DemonicblessingMod.LOGGER.warn("Failed to load dependency entity for procedure PurpleScytheSwing!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		Entity entity = (Entity) dependencies.get("entity");
		if (entity.isAlive()) {
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
			}.getScore("slash") == 0) {
				if (Math.random() < entity.getPersistentData().getDouble("critchance") / 100) {
					{
						List<Entity> _entfound = world.getEntitiesWithinAABB(Entity.class,
								new AxisAlignedBB(
										(entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
												entity.getEyePosition(1f).add(entity.getLook(1f).x * 5, entity.getLook(1f).y * 5,
														entity.getLook(1f).z * 5),
												RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos().getX())
												- (6 / 2d),
										(entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
												entity.getEyePosition(1f).add(entity.getLook(1f).x * 5, entity.getLook(1f).y * 5,
														entity.getLook(1f).z * 5),
												RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos().getY())
												- (6 / 2d),
										(entity.world
												.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
														entity.getEyePosition(1f).add(entity.getLook(1f).x * 5, entity.getLook(1f).y * 5,
																entity.getLook(1f).z * 5),
														RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
												.getPos().getZ()) - (6 / 2d),
										(entity.world
												.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
														entity.getEyePosition(1f).add(entity.getLook(1f).x * 5, entity.getLook(1f).y * 5,
																entity.getLook(1f).z * 5),
														RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
												.getPos().getX()) + (6 / 2d),
										(entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
												entity.getEyePosition(1f).add(entity.getLook(1f).x * 5, entity.getLook(1f).y * 5,
														entity.getLook(1f).z * 5),
												RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos().getY())
												+ (6 / 2d),
										(entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
												entity.getEyePosition(1f).add(entity.getLook(1f).x * 5, entity.getLook(1f).y * 5,
														entity.getLook(1f).z * 5),
												RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos().getZ())
												+ (6 / 2d)),
								null).stream().sorted(new Object() {
									Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
										return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
									}
								}.compareDistOf(
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
												RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos().getZ())))
								.collect(Collectors.toList());
						for (Entity entityiterator : _entfound) {
							if (!(entityiterator == entity)) {
								if (entityiterator instanceof LivingEntity)
									((LivingEntity) entityiterator).setHealth(
											(float) (((entityiterator instanceof LivingEntity) ? ((LivingEntity) entityiterator).getHealth() : -1)
                                                - (0.71 * entity.getPersistentData().getDouble("hpregen") * 100
                                                * entity.getPersistentData().getDouble("critdamage") / 100)));
							}
						}
					}
					if (world instanceof ServerWorld) {
						((ServerWorld) world).spawnParticle(ParticleTypes.SWEEP_ATTACK,
								(entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
										entity.getEyePosition(1f).add(entity.getLook(1f).x * 5, entity.getLook(1f).y * 5, entity.getLook(1f).z * 5),
										RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos().getX()),
								(entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
										entity.getEyePosition(1f).add(entity.getLook(1f).x * 5, entity.getLook(1f).y * 5, entity.getLook(1f).z * 5),
										RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos().getY()),
								(entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
										entity.getEyePosition(1f).add(entity.getLook(1f).x * 5, entity.getLook(1f).y * 5, entity.getLook(1f).z * 5),
										RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos().getZ()),
								(int) 40, 5, 5, 5, 1);
					}
				} else {
					{
						List<Entity> _entfound = world.getEntitiesWithinAABB(Entity.class,
								new AxisAlignedBB(
										(entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
												entity.getEyePosition(1f).add(entity.getLook(1f).x * 5, entity.getLook(1f).y * 5,
														entity.getLook(1f).z * 5),
												RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos().getX())
												- (6 / 2d),
										(entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
												entity.getEyePosition(1f).add(entity.getLook(1f).x * 5, entity.getLook(1f).y * 5,
														entity.getLook(1f).z * 5),
												RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos().getY())
												- (6 / 2d),
										(entity.world
												.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
														entity.getEyePosition(1f).add(entity.getLook(1f).x * 5, entity.getLook(1f).y * 5,
																entity.getLook(1f).z * 5),
														RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
												.getPos().getZ()) - (6 / 2d),
										(entity.world
												.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
														entity.getEyePosition(1f).add(entity.getLook(1f).x * 5, entity.getLook(1f).y * 5,
																entity.getLook(1f).z * 5),
														RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
												.getPos().getX()) + (6 / 2d),
										(entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
												entity.getEyePosition(1f).add(entity.getLook(1f).x * 5, entity.getLook(1f).y * 5,
														entity.getLook(1f).z * 5),
												RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos().getY())
												+ (6 / 2d),
										(entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
												entity.getEyePosition(1f).add(entity.getLook(1f).x * 5, entity.getLook(1f).y * 5,
														entity.getLook(1f).z * 5),
												RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos().getZ())
												+ (6 / 2d)),
								null).stream().sorted(new Object() {
									Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
										return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
									}
								}.compareDistOf(
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
												RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos().getZ())))
								.collect(Collectors.toList());
						for (Entity entityiterator : _entfound) {
							if (!(entityiterator == entity)) {
								if (entityiterator instanceof LivingEntity)
									((LivingEntity) entityiterator).setHealth(
											(float) (((entityiterator instanceof LivingEntity) ? ((LivingEntity) entityiterator).getHealth() : -1)
                                                - (0.71 * entity.getPersistentData().getDouble("hpregen") * 100)));
							}
						}
					}
					if (world instanceof ServerWorld) {
						((ServerWorld) world).spawnParticle(ParticleTypes.SWEEP_ATTACK,
								(entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
										entity.getEyePosition(1f).add(entity.getLook(1f).x * 5, entity.getLook(1f).y * 5, entity.getLook(1f).z * 5),
										RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos().getX()),
								(entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
										entity.getEyePosition(1f).add(entity.getLook(1f).x * 5, entity.getLook(1f).y * 5, entity.getLook(1f).z * 5),
										RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos().getY()),
								(entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
										entity.getEyePosition(1f).add(entity.getLook(1f).x * 5, entity.getLook(1f).y * 5, entity.getLook(1f).z * 5),
										RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos().getZ()),
								(int) 40, 5, 5, 5, 1);
					}
				}
				if (!(((entity instanceof ServerPlayerEntity) && (entity.world instanceof ServerWorld))
						? ((ServerPlayerEntity) entity).getAdvancements()
								.getProgress(((MinecraftServer) ((ServerPlayerEntity) entity).server).getAdvancementManager()
										.getAdvancement(new ResourceLocation("demonicblessing:smert")))
								.isDone()
						: false)) {
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
							if (!entity.isAlive()) {
								if (entity instanceof ServerPlayerEntity) {
									Advancement _adv = ((MinecraftServer) ((ServerPlayerEntity) entity).server).getAdvancementManager()
											.getAdvancement(new ResourceLocation("demonicblessing:smert"));
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
							MinecraftForge.EVENT_BUS.unregister(this);
						}
					}.start(world, (int) 10);
				}
				if (entity instanceof PlayerEntity)
					((PlayerEntity) entity).closeScreen();
				{
					Entity _ent = entity;
					if (_ent instanceof PlayerEntity) {
						Scoreboard _sc = ((PlayerEntity) _ent).getWorldScoreboard();
						ScoreObjective _so = _sc.getObjective("slash");
						if (_so == null) {
							_so = _sc.addObjective("slash", ScoreCriteria.DUMMY, new StringTextComponent("slash"), ScoreCriteria.RenderType.INTEGER);
						}
						Score _scr = _sc.getOrCreateScore(((PlayerEntity) _ent).getScoreboardName(), _so);
						_scr.setScorePoints((int) (new Object() {
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
						}.getScore("slash") + 1));
					}
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
						}.getScore("slash") == 1) {
							{
								Entity _ent = entity;
								if (_ent instanceof PlayerEntity) {
									Scoreboard _sc = ((PlayerEntity) _ent).getWorldScoreboard();
									ScoreObjective _so = _sc.getObjective("slash");
									if (_so == null) {
										_so = _sc.addObjective("slash", ScoreCriteria.DUMMY, new StringTextComponent("slash"),
												ScoreCriteria.RenderType.INTEGER);
									}
									Score _scr = _sc.getOrCreateScore(((PlayerEntity) _ent).getScoreboardName(), _so);
									_scr.setScorePoints((int) 0);
								}
							}
						}
						MinecraftForge.EVENT_BUS.unregister(this);
					}
				}.start(world, (int) 5);
			}
		}
	}
}
