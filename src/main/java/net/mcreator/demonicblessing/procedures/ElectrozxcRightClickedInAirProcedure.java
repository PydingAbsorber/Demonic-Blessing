package net.mcreator.demonicblessing.procedures;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.scoreboard.Scoreboard;
import net.minecraft.scoreboard.ScoreObjective;
import net.minecraft.scoreboard.ScoreCriteria;
import net.minecraft.scoreboard.Score;
import net.minecraft.potion.Effects;
import net.minecraft.potion.EffectInstance;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.effect.LightningBoltEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.Entity;

import net.mcreator.demonicblessing.item.ElectrozxcItem;
import net.mcreator.demonicblessing.item.Crystal2Item;
import net.mcreator.demonicblessing.item.AmethystItem;
import net.mcreator.demonicblessing.DemonicblessingMod;

import java.util.stream.Collectors;
import java.util.function.Function;
import java.util.Map;
import java.util.List;
import java.util.Comparator;
import java.util.Collections;

public class ElectrozxcRightClickedInAirProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				DemonicblessingMod.LOGGER.warn("Failed to load dependency world for procedure ElectrozxcRightClickedInAir!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				DemonicblessingMod.LOGGER.warn("Failed to load dependency x for procedure ElectrozxcRightClickedInAir!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				DemonicblessingMod.LOGGER.warn("Failed to load dependency y for procedure ElectrozxcRightClickedInAir!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				DemonicblessingMod.LOGGER.warn("Failed to load dependency z for procedure ElectrozxcRightClickedInAir!");
			return;
		}
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				DemonicblessingMod.LOGGER.warn("Failed to load dependency entity for procedure ElectrozxcRightClickedInAir!");
			return;
		}
		if (dependencies.get("itemstack") == null) {
			if (!dependencies.containsKey("itemstack"))
				DemonicblessingMod.LOGGER.warn("Failed to load dependency itemstack for procedure ElectrozxcRightClickedInAir!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		Entity entity = (Entity) dependencies.get("entity");
		ItemStack itemstack = (ItemStack) dependencies.get("itemstack");
		if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY).getItem() == ElectrozxcItem.block) {
			if ((entity instanceof PlayerEntity) ? ((PlayerEntity) entity).inventory.hasItemStack(new ItemStack(AmethystItem.block)) : false) {
				if (Math.random() < 0.5) {
					if (entity instanceof PlayerEntity)
						((PlayerEntity) entity).getCooldownTracker().setCooldown(itemstack.getItem(), (int) 200);
				}
			} else {
				if (entity instanceof PlayerEntity)
					((PlayerEntity) entity).getCooldownTracker().setCooldown(itemstack.getItem(), (int) 200);
			}
			{
				Entity _ent = entity;
				_ent.setPositionAndUpdate((x + 5), y, z);
				if (_ent instanceof ServerPlayerEntity) {
					((ServerPlayerEntity) _ent).connection.setPlayerLocation((x + 5), y, z, _ent.rotationYaw, _ent.rotationPitch,
							Collections.emptySet());
				}
			}
			if (world instanceof ServerWorld) {
				LightningBoltEntity _ent = EntityType.LIGHTNING_BOLT.create((World) world);
				_ent.moveForced(Vector3d.copyCenteredHorizontally(new BlockPos((int) x, (int) y, (int) z)));
				_ent.setEffectOnly(true);
				((World) world).addEntity(_ent);
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
						_ent.setPositionAndUpdate((x - 5), y, (z + 5));
						if (_ent instanceof ServerPlayerEntity) {
							((ServerPlayerEntity) _ent).connection.setPlayerLocation((x - 5), y, (z + 5), _ent.rotationYaw, _ent.rotationPitch,
									Collections.emptySet());
						}
					}
					if (world instanceof ServerWorld) {
						LightningBoltEntity _ent = EntityType.LIGHTNING_BOLT.create((World) world);
						_ent.moveForced(Vector3d.copyCenteredHorizontally(new BlockPos((int) x, (int) y, (int) z)));
						_ent.setEffectOnly(true);
						((World) world).addEntity(_ent);
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
								_ent.setPositionAndUpdate((x - 5), y, (z - 5));
								if (_ent instanceof ServerPlayerEntity) {
									((ServerPlayerEntity) _ent).connection.setPlayerLocation((x - 5), y, (z - 5), _ent.rotationYaw,
											_ent.rotationPitch, Collections.emptySet());
								}
							}
							if (world instanceof ServerWorld) {
								LightningBoltEntity _ent = EntityType.LIGHTNING_BOLT.create((World) world);
								_ent.moveForced(Vector3d.copyCenteredHorizontally(new BlockPos((int) x, (int) y, (int) z)));
								_ent.setEffectOnly(true);
								((World) world).addEntity(_ent);
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
										_ent.setPositionAndUpdate((x + 5), y, (z - 5));
										if (_ent instanceof ServerPlayerEntity) {
											((ServerPlayerEntity) _ent).connection.setPlayerLocation((x + 5), y, (z - 5), _ent.rotationYaw,
													_ent.rotationPitch, Collections.emptySet());
										}
									}
									if (world instanceof ServerWorld) {
										LightningBoltEntity _ent = EntityType.LIGHTNING_BOLT.create((World) world);
										_ent.moveForced(Vector3d.copyCenteredHorizontally(new BlockPos((int) x, (int) y, (int) z)));
										_ent.setEffectOnly(true);
										((World) world).addEntity(_ent);
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
												_ent.setPositionAndUpdate(x, (y + 5), (z + 5));
												if (_ent instanceof ServerPlayerEntity) {
													((ServerPlayerEntity) _ent).connection.setPlayerLocation(x, (y + 5), (z + 5), _ent.rotationYaw,
															_ent.rotationPitch, Collections.emptySet());
												}
											}
											if (world instanceof ServerWorld) {
												LightningBoltEntity _ent = EntityType.LIGHTNING_BOLT.create((World) world);
												_ent.moveForced(Vector3d.copyCenteredHorizontally(new BlockPos((int) x, (int) y, (int) z)));
												_ent.setEffectOnly(true);
												((World) world).addEntity(_ent);
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
														_ent.setPositionAndUpdate(x, (y - 10), z);
														if (_ent instanceof ServerPlayerEntity) {
															((ServerPlayerEntity) _ent).connection.setPlayerLocation(x, (y - 10), z, _ent.rotationYaw,
																	_ent.rotationPitch, Collections.emptySet());
														}
													}
													if (world instanceof ServerWorld) {
														LightningBoltEntity _ent = EntityType.LIGHTNING_BOLT.create((World) world);
														_ent.moveForced(Vector3d.copyCenteredHorizontally(new BlockPos((int) x, (int) y, (int) z)));
														_ent.setEffectOnly(true);
														((World) world).addEntity(_ent);
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
																_ent.setPositionAndUpdate((x - 5), y, (z - 5));
																if (_ent instanceof ServerPlayerEntity) {
																	((ServerPlayerEntity) _ent).connection.setPlayerLocation((x - 5), y, (z - 5),
																			_ent.rotationYaw, _ent.rotationPitch, Collections.emptySet());
																}
															}
															if (world instanceof ServerWorld) {
																LightningBoltEntity _ent = EntityType.LIGHTNING_BOLT.create((World) world);
																_ent.moveForced(
																		Vector3d.copyCenteredHorizontally(new BlockPos((int) x, (int) y, (int) z)));
																_ent.setEffectOnly(true);
																((World) world).addEntity(_ent);
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
																		_ent.setPositionAndUpdate((x + 10), y, z);
																		if (_ent instanceof ServerPlayerEntity) {
																			((ServerPlayerEntity) _ent).connection.setPlayerLocation((x + 10), y, z,
																					_ent.rotationYaw, _ent.rotationPitch, Collections.emptySet());
																		}
																	}
																	if (world instanceof ServerWorld) {
																		LightningBoltEntity _ent = EntityType.LIGHTNING_BOLT.create((World) world);
																		_ent.moveForced(Vector3d
																				.copyCenteredHorizontally(new BlockPos((int) x, (int) y, (int) z)));
																		_ent.setEffectOnly(true);
																		((World) world).addEntity(_ent);
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
																				_ent.setPositionAndUpdate(x, y, (z + 10));
																				if (_ent instanceof ServerPlayerEntity) {
																					((ServerPlayerEntity) _ent).connection.setPlayerLocation(x, y,
																							(z + 10), _ent.rotationYaw, _ent.rotationPitch,
																							Collections.emptySet());
																				}
																			}
																			if (world instanceof ServerWorld) {
																				LightningBoltEntity _ent = EntityType.LIGHTNING_BOLT
																						.create((World) world);
																				_ent.moveForced(Vector3d.copyCenteredHorizontally(
																						new BlockPos((int) x, (int) y, (int) z)));
																				_ent.setEffectOnly(true);
																				((World) world).addEntity(_ent);
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
																						_ent.setPositionAndUpdate((x - 10), y, z);
																						if (_ent instanceof ServerPlayerEntity) {
																							((ServerPlayerEntity) _ent).connection.setPlayerLocation(
																									(x - 10), y, z, _ent.rotationYaw,
																									_ent.rotationPitch, Collections.emptySet());
																						}
																					}
																					if (world instanceof ServerWorld) {
																						LightningBoltEntity _ent = EntityType.LIGHTNING_BOLT
																								.create((World) world);
																						_ent.moveForced(Vector3d.copyCenteredHorizontally(
																								new BlockPos((int) x, (int) y, (int) z)));
																						_ent.setEffectOnly(true);
																						((World) world).addEntity(_ent);
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
																								_ent.setPositionAndUpdate(x, (y + 10), z);
																								if (_ent instanceof ServerPlayerEntity) {
																									((ServerPlayerEntity) _ent).connection
																											.setPlayerLocation(x, (y + 10), z,
																													_ent.rotationYaw,
																													_ent.rotationPitch,
																													Collections.emptySet());
																								}
																							}
																							if (world instanceof ServerWorld) {
																								LightningBoltEntity _ent = EntityType.LIGHTNING_BOLT
																										.create((World) world);
																								_ent.moveForced(Vector3d.copyCenteredHorizontally(
																										new BlockPos((int) x, (int) y, (int) z)));
																								_ent.setEffectOnly(true);
																								((World) world).addEntity(_ent);
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
																										_ent.setPositionAndUpdate((x + 10), y, z);
																										if (_ent instanceof ServerPlayerEntity) {
																											((ServerPlayerEntity) _ent).connection
																													.setPlayerLocation((x + 10), y, z,
																															_ent.rotationYaw,
																															_ent.rotationPitch,
																															Collections.emptySet());
																										}
																									}
																									if (world instanceof ServerWorld) {
																										LightningBoltEntity _ent = EntityType.LIGHTNING_BOLT
																												.create((World) world);
																										_ent.moveForced(
																												Vector3d.copyCenteredHorizontally(
																														new BlockPos((int) x, (int) y,
																																(int) z)));
																										_ent.setEffectOnly(true);
																										((World) world).addEntity(_ent);
																									}
																									new Object() {
																										private int ticks = 0;
																										private float waitTicks;
																										private IWorld world;

																										public void start(IWorld world,
																												int waitTicks) {
																											this.waitTicks = waitTicks;
																											MinecraftForge.EVENT_BUS.register(this);
																											this.world = world;
																										}

																										@SubscribeEvent
																										public void tick(
																												TickEvent.ServerTickEvent event) {
																											if (event.phase == TickEvent.Phase.END) {
																												this.ticks += 1;
																												if (this.ticks >= this.waitTicks)
																													run();
																											}
																										}

																										private void run() {
																											{
																												Entity _ent = entity;
																												_ent.setPositionAndUpdate(x, y,
																														(z - 10));
																												if (_ent instanceof ServerPlayerEntity) {
																													((ServerPlayerEntity) _ent).connection
																															.setPlayerLocation(x, y,
																																	(z - 10),
																																	_ent.rotationYaw,
																																	_ent.rotationPitch,
																																	Collections
																																			.emptySet());
																												}
																											}
																											if (world instanceof ServerWorld) {
																												LightningBoltEntity _ent = EntityType.LIGHTNING_BOLT
																														.create((World) world);
																												_ent.moveForced(Vector3d
																														.copyCenteredHorizontally(
																																new BlockPos((int) x,
																																		(int) y,
																																		(int) z)));
																												_ent.setEffectOnly(true);
																												((World) world).addEntity(_ent);
																											}
																											new Object() {
																												private int ticks = 0;
																												private float waitTicks;
																												private IWorld world;

																												public void start(IWorld world,
																														int waitTicks) {
																													this.waitTicks = waitTicks;
																													MinecraftForge.EVENT_BUS
																															.register(this);
																													this.world = world;
																												}

																												@SubscribeEvent
																												public void tick(
																														TickEvent.ServerTickEvent event) {
																													if (event.phase == TickEvent.Phase.END) {
																														this.ticks += 1;
																														if (this.ticks >= this.waitTicks)
																															run();
																													}
																												}

																												private void run() {
																													{
																														Entity _ent = entity;
																														_ent.setPositionAndUpdate(
																																(x - 10), y, z);
																														if (_ent instanceof ServerPlayerEntity) {
																															((ServerPlayerEntity) _ent).connection
																																	.setPlayerLocation(
																																			(x - 10),
																																			y, z,
																																			_ent.rotationYaw,
																																			_ent.rotationPitch,
																																			Collections
																																					.emptySet());
																														}
																													}
																													if (world instanceof ServerWorld) {
																														LightningBoltEntity _ent = EntityType.LIGHTNING_BOLT
																																.create((World) world);
																														_ent.moveForced(Vector3d
																																.copyCenteredHorizontally(
																																		new BlockPos(
																																				(int) x,
																																				(int) y,
																																				(int) z)));
																														_ent.setEffectOnly(true);
																														((World) world)
																																.addEntity(_ent);
																													}
																													new Object() {
																														private int ticks = 0;
																														private float waitTicks;
																														private IWorld world;

																														public void start(
																																IWorld world,
																																int waitTicks) {
																															this.waitTicks = waitTicks;
																															MinecraftForge.EVENT_BUS
																																	.register(this);
																															this.world = world;
																														}

																														@SubscribeEvent
																														public void tick(
																																TickEvent.ServerTickEvent event) {
																															if (event.phase == TickEvent.Phase.END) {
																																this.ticks += 1;
																																if (this.ticks >= this.waitTicks)
																																	run();
																															}
																														}

																														private void run() {
																															{
																																Entity _ent = entity;
																																_ent.setPositionAndUpdate(
																																		x, (y + 5),
																																		z);
																																if (_ent instanceof ServerPlayerEntity) {
																																	((ServerPlayerEntity) _ent).connection
																																			.setPlayerLocation(
																																					x,
																																					(y + 5),
																																					z,
																																					_ent.rotationYaw,
																																					_ent.rotationPitch,
																																					Collections
																																							.emptySet());
																																}
																															}
																															if (world instanceof ServerWorld) {
																																LightningBoltEntity _ent = EntityType.LIGHTNING_BOLT
																																		.create((World) world);
																																_ent.moveForced(
																																		Vector3d.copyCenteredHorizontally(
																																				new BlockPos(
																																						(int) x,
																																						(int) y,
																																						(int) z)));
																																_ent.setEffectOnly(
																																		true);
																																((World) world)
																																		.addEntity(
																																				_ent);
																															}
																															if ((entity instanceof PlayerEntity)
																																	? ((PlayerEntity) entity).inventory
																																			.hasItemStack(
																																					new ItemStack(
																																							Crystal2Item.block))
																																	: false) {
																																{
																																	Entity _ent = entity;
																																	if (_ent instanceof PlayerEntity) {
																																		Scoreboard _sc = ((PlayerEntity) _ent)
																																				.getWorldScoreboard();
																																		ScoreObjective _so = _sc
																																				.getObjective(
																																						"cd");
																																		if (_so == null) {
																																			_so = _sc
																																					.addObjective(
																																							"cd",
																																							ScoreCriteria.DUMMY,
																																							new StringTextComponent(
																																									"cd"),
																																							ScoreCriteria.RenderType.INTEGER);
																																		}
																																		Score _scr = _sc
																																				.getOrCreateScore(
																																						((PlayerEntity) _ent)
																																								.getScoreboardName(),
																																						_so);
																																		_scr.setScorePoints(
																																				(int) 0);
																																	}
																																}
																															}
																															MinecraftForge.EVENT_BUS
																																	.unregister(this);
																														}
																													}.start(world, (int) 3);
																													MinecraftForge.EVENT_BUS
																															.unregister(this);
																												}
																											}.start(world, (int) 3);
																											MinecraftForge.EVENT_BUS.unregister(this);
																										}
																									}.start(world, (int) 3);
																									MinecraftForge.EVENT_BUS.unregister(this);
																								}
																							}.start(world, (int) 3);
																							MinecraftForge.EVENT_BUS.unregister(this);
																						}
																					}.start(world, (int) 3);
																					MinecraftForge.EVENT_BUS.unregister(this);
																				}
																			}.start(world, (int) 3);
																			MinecraftForge.EVENT_BUS.unregister(this);
																		}
																	}.start(world, (int) 3);
																	MinecraftForge.EVENT_BUS.unregister(this);
																}
															}.start(world, (int) 3);
															MinecraftForge.EVENT_BUS.unregister(this);
														}
													}.start(world, (int) 3);
													MinecraftForge.EVENT_BUS.unregister(this);
												}
											}.start(world, (int) 3);
											MinecraftForge.EVENT_BUS.unregister(this);
										}
									}.start(world, (int) 3);
									MinecraftForge.EVENT_BUS.unregister(this);
								}
							}.start(world, (int) 3);
							MinecraftForge.EVENT_BUS.unregister(this);
						}
					}.start(world, (int) 3);
					MinecraftForge.EVENT_BUS.unregister(this);
				}
			}.start(world, (int) 3);
			if (!((entity instanceof PlayerEntity) ? ((PlayerEntity) entity).inventory.hasItemStack(new ItemStack(AmethystItem.block)) : false)) {
				if (Math.random() < entity.getPersistentData().getDouble("critchance") / 100) {
					{
						List<Entity> _entfound = world.getEntitiesWithinAABB(Entity.class,
								new AxisAlignedBB(x - (30 / 2d), y - (30 / 2d), z - (30 / 2d), x + (30 / 2d), y + (30 / 2d), z + (30 / 2d)), null)
								.stream().sorted(new Object() {
									Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
										return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
									}
								}.compareDistOf(x, y, z)).collect(Collectors.toList());
						for (Entity entityiterator : _entfound) {
							if (entityiterator.getPersistentData().getBoolean("evade") == false) {
								entityiterator.attackEntityFrom(DamageSource.OUT_OF_WORLD,
										(float) (1080 * entity.getPersistentData().getDouble("critdamage") / 100));
								entityiterator.attackEntityFrom(DamageSource.LIGHTNING_BOLT,
										(float) (1500 * entity.getPersistentData().getDouble("critdamage") / 100));
								if (entityiterator instanceof LivingEntity)
									((LivingEntity) entityiterator).addPotionEffect(new EffectInstance(Effects.SLOWNESS, (int) 60, (int) 70));
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
										if (entityiterator.getPersistentData().getBoolean("evade") == false) {
											entityiterator.attackEntityFrom(DamageSource.OUT_OF_WORLD,
													(float) (1080 * entity.getPersistentData().getDouble("critdamage") / 100));
											entityiterator.attackEntityFrom(DamageSource.LIGHTNING_BOLT,
													(float) (1500 * entity.getPersistentData().getDouble("critdamage") / 100));
											if (entityiterator instanceof LivingEntity)
												((LivingEntity) entityiterator)
														.addPotionEffect(new EffectInstance(Effects.SLOWNESS, (int) 60, (int) 70));
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
													if (entityiterator.getPersistentData().getBoolean("evade") == false) {
														entityiterator.attackEntityFrom(DamageSource.OUT_OF_WORLD,
																(float) (1080 * entity.getPersistentData().getDouble("critdamage") / 100));
														entityiterator.attackEntityFrom(DamageSource.LIGHTNING_BOLT,
																(float) (1500 * entity.getPersistentData().getDouble("critdamage") / 100));
														if (entityiterator instanceof LivingEntity)
															((LivingEntity) entityiterator)
																	.addPotionEffect(new EffectInstance(Effects.SLOWNESS, (int) 60, (int) 70));
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
																if (entityiterator.getPersistentData().getBoolean("evade") == false) {
																	entityiterator.attackEntityFrom(DamageSource.OUT_OF_WORLD, (float) (1080
																			* entity.getPersistentData().getDouble("critdamage") / 100));
																	entityiterator.attackEntityFrom(DamageSource.LIGHTNING_BOLT, (float) (1500
																			* entity.getPersistentData().getDouble("critdamage") / 100));
																	if (entityiterator instanceof LivingEntity)
																		((LivingEntity) entityiterator).addPotionEffect(
																				new EffectInstance(Effects.SLOWNESS, (int) 60, (int) 70));
																}
																MinecraftForge.EVENT_BUS.unregister(this);
															}
														}.start(world, (int) 11);
													}
													MinecraftForge.EVENT_BUS.unregister(this);
												}
											}.start(world, (int) 11);
										}
										MinecraftForge.EVENT_BUS.unregister(this);
									}
								}.start(world, (int) 11);
							}
						}
					}
				} else {
					{
						List<Entity> _entfound = world.getEntitiesWithinAABB(Entity.class,
								new AxisAlignedBB(x - (30 / 2d), y - (30 / 2d), z - (30 / 2d), x + (30 / 2d), y + (30 / 2d), z + (30 / 2d)), null)
								.stream().sorted(new Object() {
									Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
										return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
									}
								}.compareDistOf(x, y, z)).collect(Collectors.toList());
						for (Entity entityiterator : _entfound) {
							if (entityiterator.getPersistentData().getBoolean("evade") == false) {
								entityiterator.attackEntityFrom(DamageSource.OUT_OF_WORLD, (float) 1080);
								entityiterator.attackEntityFrom(DamageSource.LIGHTNING_BOLT, (float) 1500);
								if (entityiterator instanceof LivingEntity)
									((LivingEntity) entityiterator).addPotionEffect(new EffectInstance(Effects.SLOWNESS, (int) 60, (int) 70));
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
										if (entityiterator.getPersistentData().getBoolean("evade") == false) {
											entityiterator.attackEntityFrom(DamageSource.OUT_OF_WORLD, (float) 1080);
											entityiterator.attackEntityFrom(DamageSource.LIGHTNING_BOLT, (float) 1500);
											if (entityiterator instanceof LivingEntity)
												((LivingEntity) entityiterator)
														.addPotionEffect(new EffectInstance(Effects.SLOWNESS, (int) 60, (int) 70));
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
													if (entityiterator.getPersistentData().getBoolean("evade") == false) {
														entityiterator.attackEntityFrom(DamageSource.OUT_OF_WORLD, (float) 1080);
														entityiterator.attackEntityFrom(DamageSource.LIGHTNING_BOLT, (float) 1500);
														if (entityiterator instanceof LivingEntity)
															((LivingEntity) entityiterator)
																	.addPotionEffect(new EffectInstance(Effects.SLOWNESS, (int) 60, (int) 70));
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
																if (entityiterator.getPersistentData().getBoolean("evade") == false) {
																	entityiterator.attackEntityFrom(DamageSource.OUT_OF_WORLD, (float) 1080);
																	entityiterator.attackEntityFrom(DamageSource.LIGHTNING_BOLT, (float) 1500);
																	if (entityiterator instanceof LivingEntity)
																		((LivingEntity) entityiterator).addPotionEffect(
																				new EffectInstance(Effects.SLOWNESS, (int) 60, (int) 70));
																}
																MinecraftForge.EVENT_BUS.unregister(this);
															}
														}.start(world, (int) 11);
													}
													MinecraftForge.EVENT_BUS.unregister(this);
												}
											}.start(world, (int) 11);
										}
										MinecraftForge.EVENT_BUS.unregister(this);
									}
								}.start(world, (int) 11);
							}
						}
					}
				}
			} else {
				if (Math.random() < entity.getPersistentData().getDouble("critchance") / 100) {
					{
						List<Entity> _entfound = world.getEntitiesWithinAABB(Entity.class,
								new AxisAlignedBB(x - (30 / 2d), y - (30 / 2d), z - (30 / 2d), x + (30 / 2d), y + (30 / 2d), z + (30 / 2d)), null)
								.stream().sorted(new Object() {
									Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
										return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
									}
								}.compareDistOf(x, y, z)).collect(Collectors.toList());
						for (Entity entityiterator : _entfound) {
							if (entityiterator.getPersistentData().getBoolean("evade") == false) {
								entityiterator.attackEntityFrom(DamageSource.OUT_OF_WORLD,
										(float) (1200 * entity.getPersistentData().getDouble("critdamage") / 100));
								entityiterator.attackEntityFrom(DamageSource.LIGHTNING_BOLT,
										(float) (2000 * entity.getPersistentData().getDouble("critdamage") / 100));
								if (entityiterator instanceof LivingEntity)
									((LivingEntity) entityiterator).addPotionEffect(new EffectInstance(Effects.SLOWNESS, (int) 60, (int) 70));
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
										if (entityiterator.getPersistentData().getBoolean("evade") == false) {
											entityiterator.attackEntityFrom(DamageSource.OUT_OF_WORLD,
													(float) (1200 * entity.getPersistentData().getDouble("critdamage") / 100));
											entityiterator.attackEntityFrom(DamageSource.LIGHTNING_BOLT,
													(float) (2000 * entity.getPersistentData().getDouble("critdamage") / 100));
											if (entityiterator instanceof LivingEntity)
												((LivingEntity) entityiterator)
														.addPotionEffect(new EffectInstance(Effects.SLOWNESS, (int) 60, (int) 70));
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
													if (entityiterator.getPersistentData().getBoolean("evade") == false) {
														entityiterator.attackEntityFrom(DamageSource.OUT_OF_WORLD,
																(float) (1200 * entity.getPersistentData().getDouble("critdamage") / 100));
														entityiterator.attackEntityFrom(DamageSource.LIGHTNING_BOLT,
																(float) (2000 * entity.getPersistentData().getDouble("critdamage") / 100));
														if (entityiterator instanceof LivingEntity)
															((LivingEntity) entityiterator)
																	.addPotionEffect(new EffectInstance(Effects.SLOWNESS, (int) 60, (int) 70));
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
																if (entityiterator.getPersistentData().getBoolean("evade") == false) {
																	entityiterator.attackEntityFrom(DamageSource.OUT_OF_WORLD, (float) (1200
																			* entity.getPersistentData().getDouble("critdamage") / 100));
																	entityiterator.attackEntityFrom(DamageSource.LIGHTNING_BOLT, (float) (2000
																			* entity.getPersistentData().getDouble("critdamage") / 100));
																	if (entityiterator instanceof LivingEntity)
																		((LivingEntity) entityiterator).addPotionEffect(
																				new EffectInstance(Effects.SLOWNESS, (int) 60, (int) 70));
																}
																MinecraftForge.EVENT_BUS.unregister(this);
															}
														}.start(world, (int) 11);
													}
													MinecraftForge.EVENT_BUS.unregister(this);
												}
											}.start(world, (int) 11);
										}
										MinecraftForge.EVENT_BUS.unregister(this);
									}
								}.start(world, (int) 11);
							}
						}
					}
				} else {
					{
						List<Entity> _entfound = world.getEntitiesWithinAABB(Entity.class,
								new AxisAlignedBB(x - (30 / 2d), y - (30 / 2d), z - (30 / 2d), x + (30 / 2d), y + (30 / 2d), z + (30 / 2d)), null)
								.stream().sorted(new Object() {
									Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
										return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
									}
								}.compareDistOf(x, y, z)).collect(Collectors.toList());
						for (Entity entityiterator : _entfound) {
							if (entityiterator.getPersistentData().getBoolean("evade") == false) {
								entityiterator.attackEntityFrom(DamageSource.OUT_OF_WORLD, (float) 1200);
								entityiterator.attackEntityFrom(DamageSource.LIGHTNING_BOLT, (float) 2000);
								if (entityiterator instanceof LivingEntity)
									((LivingEntity) entityiterator).addPotionEffect(new EffectInstance(Effects.SLOWNESS, (int) 60, (int) 70));
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
										if (entityiterator.getPersistentData().getBoolean("evade") == false) {
											entityiterator.attackEntityFrom(DamageSource.OUT_OF_WORLD, (float) 1200);
											entityiterator.attackEntityFrom(DamageSource.LIGHTNING_BOLT, (float) 2000);
											if (entityiterator instanceof LivingEntity)
												((LivingEntity) entityiterator)
														.addPotionEffect(new EffectInstance(Effects.SLOWNESS, (int) 60, (int) 70));
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
													if (entityiterator.getPersistentData().getBoolean("evade") == false) {
														entityiterator.attackEntityFrom(DamageSource.OUT_OF_WORLD, (float) 1200);
														entityiterator.attackEntityFrom(DamageSource.LIGHTNING_BOLT, (float) 2000);
														if (entityiterator instanceof LivingEntity)
															((LivingEntity) entityiterator)
																	.addPotionEffect(new EffectInstance(Effects.SLOWNESS, (int) 60, (int) 70));
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
																if (entityiterator.getPersistentData().getBoolean("evade") == false) {
																	entityiterator.attackEntityFrom(DamageSource.OUT_OF_WORLD, (float) 1200);
																	entityiterator.attackEntityFrom(DamageSource.LIGHTNING_BOLT, (float) 2000);
																	if (entityiterator instanceof LivingEntity)
																		((LivingEntity) entityiterator).addPotionEffect(
																				new EffectInstance(Effects.SLOWNESS, (int) 60, (int) 70));
																}
																MinecraftForge.EVENT_BUS.unregister(this);
															}
														}.start(world, (int) 11);
													}
													MinecraftForge.EVENT_BUS.unregister(this);
												}
											}.start(world, (int) 11);
										}
										MinecraftForge.EVENT_BUS.unregister(this);
									}
								}.start(world, (int) 11);
							}
						}
					}
				}
			}
		}
	}
}
