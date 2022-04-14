package net.mcreator.demonicblessing.procedures;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.items.ItemHandlerHelper;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.world.Difficulty;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.state.Property;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.Entity;
import net.minecraft.block.BlockState;

import net.mcreator.demonicblessing.item.Walletx8Item;
import net.mcreator.demonicblessing.item.SecretBossSpawnItem;
import net.mcreator.demonicblessing.item.Mod2Item;
import net.mcreator.demonicblessing.item.MegafluxTankItem;
import net.mcreator.demonicblessing.item.Crystal3Item;
import net.mcreator.demonicblessing.entity.NiceclockbigfootEntity;
import net.mcreator.demonicblessing.block.ChestBlock;
import net.mcreator.demonicblessing.DemonicblessingMod;

import java.util.stream.Collectors;
import java.util.function.Function;
import java.util.Map;
import java.util.List;
import java.util.Comparator;

public class MediumChestOnBlockRightClickedProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				DemonicblessingMod.LOGGER.warn("Failed to load dependency world for procedure MediumChestOnBlockRightClicked!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				DemonicblessingMod.LOGGER.warn("Failed to load dependency x for procedure MediumChestOnBlockRightClicked!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				DemonicblessingMod.LOGGER.warn("Failed to load dependency y for procedure MediumChestOnBlockRightClicked!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				DemonicblessingMod.LOGGER.warn("Failed to load dependency z for procedure MediumChestOnBlockRightClicked!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		if (new Object() {
			public double getValue(IWorld world, BlockPos pos, String tag) {
				TileEntity tileEntity = world.getTileEntity(pos);
				if (tileEntity != null)
					return tileEntity.getTileData().getDouble(tag);
				return -1;
			}
		}.getValue(world, new BlockPos((int) x, (int) y, (int) z), "chest") == 0) {
			if (!world.isRemote()) {
				BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
				TileEntity _tileEntity = world.getTileEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_tileEntity != null)
					_tileEntity.getTileData().putDouble("chest", 1);
				if (world instanceof World)
					((World) world).notifyBlockUpdate(_bp, _bs, _bs, 3);
			}
			if (world instanceof ServerWorld) {
				Entity entityToSpawn = new NiceclockbigfootEntity.CustomEntity(NiceclockbigfootEntity.entity, (World) world);
				entityToSpawn.setLocationAndAngles((x + 4), y, z, world.getRandom().nextFloat() * 360F, 0);
				if (entityToSpawn instanceof MobEntity)
					((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world, world.getDifficultyForLocation(entityToSpawn.getPosition()),
							SpawnReason.MOB_SUMMONED, (ILivingEntityData) null, (CompoundNBT) null);
				world.addEntity(entityToSpawn);
			}
			if (world instanceof ServerWorld) {
				Entity entityToSpawn = new NiceclockbigfootEntity.CustomEntity(NiceclockbigfootEntity.entity, (World) world);
				entityToSpawn.setLocationAndAngles((x - 4), y, z, world.getRandom().nextFloat() * 360F, 0);
				if (entityToSpawn instanceof MobEntity)
					((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world, world.getDifficultyForLocation(entityToSpawn.getPosition()),
							SpawnReason.MOB_SUMMONED, (ILivingEntityData) null, (CompoundNBT) null);
				world.addEntity(entityToSpawn);
			}
			if (world instanceof ServerWorld) {
				Entity entityToSpawn = new NiceclockbigfootEntity.CustomEntity(NiceclockbigfootEntity.entity, (World) world);
				entityToSpawn.setLocationAndAngles(x, y, (z + 4), world.getRandom().nextFloat() * 360F, 0);
				if (entityToSpawn instanceof MobEntity)
					((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world, world.getDifficultyForLocation(entityToSpawn.getPosition()),
							SpawnReason.MOB_SUMMONED, (ILivingEntityData) null, (CompoundNBT) null);
				world.addEntity(entityToSpawn);
			}
			if (world instanceof ServerWorld) {
				Entity entityToSpawn = new NiceclockbigfootEntity.CustomEntity(NiceclockbigfootEntity.entity, (World) world);
				entityToSpawn.setLocationAndAngles(x, y, (z - 4), world.getRandom().nextFloat() * 360F, 0);
				if (entityToSpawn instanceof MobEntity)
					((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world, world.getDifficultyForLocation(entityToSpawn.getPosition()),
							SpawnReason.MOB_SUMMONED, (ILivingEntityData) null, (CompoundNBT) null);
				world.addEntity(entityToSpawn);
			}
			if (world instanceof ServerWorld) {
				Entity entityToSpawn = new NiceclockbigfootEntity.CustomEntity(NiceclockbigfootEntity.entity, (World) world);
				entityToSpawn.setLocationAndAngles((x + 4), y, (z + 4), world.getRandom().nextFloat() * 360F, 0);
				if (entityToSpawn instanceof MobEntity)
					((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world, world.getDifficultyForLocation(entityToSpawn.getPosition()),
							SpawnReason.MOB_SUMMONED, (ILivingEntityData) null, (CompoundNBT) null);
				world.addEntity(entityToSpawn);
			}
			if (world instanceof ServerWorld) {
				Entity entityToSpawn = new NiceclockbigfootEntity.CustomEntity(NiceclockbigfootEntity.entity, (World) world);
				entityToSpawn.setLocationAndAngles((x + 4), y, (z - 4), world.getRandom().nextFloat() * 360F, 0);
				if (entityToSpawn instanceof MobEntity)
					((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world, world.getDifficultyForLocation(entityToSpawn.getPosition()),
							SpawnReason.MOB_SUMMONED, (ILivingEntityData) null, (CompoundNBT) null);
				world.addEntity(entityToSpawn);
			}
			if (world instanceof ServerWorld) {
				Entity entityToSpawn = new NiceclockbigfootEntity.CustomEntity(NiceclockbigfootEntity.entity, (World) world);
				entityToSpawn.setLocationAndAngles((x - 4), y, (z + 4), world.getRandom().nextFloat() * 360F, 0);
				if (entityToSpawn instanceof MobEntity)
					((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world, world.getDifficultyForLocation(entityToSpawn.getPosition()),
							SpawnReason.MOB_SUMMONED, (ILivingEntityData) null, (CompoundNBT) null);
				world.addEntity(entityToSpawn);
			}
			if (world instanceof ServerWorld) {
				Entity entityToSpawn = new NiceclockbigfootEntity.CustomEntity(NiceclockbigfootEntity.entity, (World) world);
				entityToSpawn.setLocationAndAngles((x - 4), y, (z - 4), world.getRandom().nextFloat() * 360F, 0);
				if (entityToSpawn instanceof MobEntity)
					((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world, world.getDifficultyForLocation(entityToSpawn.getPosition()),
							SpawnReason.MOB_SUMMONED, (ILivingEntityData) null, (CompoundNBT) null);
				world.addEntity(entityToSpawn);
			}
			{
				List<Entity> _entfound = world
						.getEntitiesWithinAABB(Entity.class,
								new AxisAlignedBB(x - (60 / 2d), y - (60 / 2d), z - (60 / 2d), x + (60 / 2d), y + (60 / 2d), z + (60 / 2d)), null)
						.stream().sorted(new Object() {
							Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
								return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
							}
						}.compareDistOf(x, y, z)).collect(Collectors.toList());
				for (Entity entityiterator : _entfound) {
					entityiterator.getPersistentData().putDouble("timer", 2100);
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
					if (!(world.getDifficulty() == Difficulty.PEACEFUL)) {
						if (((Entity) world.getEntitiesWithinAABB(NiceclockbigfootEntity.CustomEntity.class,
								new AxisAlignedBB(x - (60 / 2d), y - (60 / 2d), z - (60 / 2d), x + (60 / 2d), y + (60 / 2d), z + (60 / 2d)), null)
								.stream().sorted(new Object() {
									Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
										return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
									}
								}.compareDistOf(x, y, z)).findFirst().orElse(null)) != null) {
							if (!world.isRemote()) {
								BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
								TileEntity _tileEntity = world.getTileEntity(_bp);
								BlockState _bs = world.getBlockState(_bp);
								if (_tileEntity != null)
									_tileEntity.getTileData().putDouble("chest", 0);
								if (world instanceof World)
									((World) world).notifyBlockUpdate(_bp, _bs, _bs, 3);
							}
						} else {
							world.destroyBlock(new BlockPos((int) x, (int) y, (int) z), false);
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
									if (Math.random() < 0.98) {
										{
											List<Entity> _entfound = world
													.getEntitiesWithinAABB(Entity.class, new AxisAlignedBB(x - (20 / 2d), y - (20 / 2d),
															z - (20 / 2d), x + (20 / 2d), y + (20 / 2d), z + (20 / 2d)), null)
													.stream().sorted(new Object() {
														Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
															return Comparator.comparing(
																	(Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
														}
													}.compareDistOf(x, y, z)).collect(Collectors.toList());
											for (Entity entityiterator : _entfound) {
												if (entityiterator.isAlive()) {
													if (entityiterator instanceof PlayerEntity) {
														ItemStack _setstack = new ItemStack(Walletx8Item.block);
														_setstack.setCount((int) 1);
														ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entityiterator), _setstack);
													}
												}
											}
										}
									} else {
										{
											List<Entity> _entfound = world
													.getEntitiesWithinAABB(Entity.class, new AxisAlignedBB(x - (20 / 2d), y - (20 / 2d),
															z - (20 / 2d), x + (20 / 2d), y + (20 / 2d), z + (20 / 2d)), null)
													.stream().sorted(new Object() {
														Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
															return Comparator.comparing(
																	(Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
														}
													}.compareDistOf(x, y, z)).collect(Collectors.toList());
											for (Entity entityiterator : _entfound) {
												if (entityiterator.isAlive()) {
													if (entityiterator instanceof PlayerEntity) {
														ItemStack _setstack = new ItemStack(SecretBossSpawnItem.block);
														_setstack.setCount((int) 1);
														ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entityiterator), _setstack);
													}
												}
											}
										}
									}
									if (Math.random() > 0.95) {
										{
											List<Entity> _entfound = world
													.getEntitiesWithinAABB(Entity.class, new AxisAlignedBB(x - (20 / 2d), y - (20 / 2d),
															z - (20 / 2d), x + (20 / 2d), y + (20 / 2d), z + (20 / 2d)), null)
													.stream().sorted(new Object() {
														Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
															return Comparator.comparing(
																	(Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
														}
													}.compareDistOf(x, y, z)).collect(Collectors.toList());
											for (Entity entityiterator : _entfound) {
												if (entityiterator.isAlive()) {
													if (entityiterator instanceof PlayerEntity) {
														ItemStack _setstack = new ItemStack(Mod2Item.block);
														_setstack.setCount((int) 1);
														ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entityiterator), _setstack);
													}
												}
											}
										}
									}
									if (Math.random() > 0.98) {
										{
											List<Entity> _entfound = world
													.getEntitiesWithinAABB(Entity.class, new AxisAlignedBB(x - (20 / 2d), y - (20 / 2d),
															z - (20 / 2d), x + (20 / 2d), y + (20 / 2d), z + (20 / 2d)), null)
													.stream().sorted(new Object() {
														Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
															return Comparator.comparing(
																	(Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
														}
													}.compareDistOf(x, y, z)).collect(Collectors.toList());
											for (Entity entityiterator : _entfound) {
												if (entityiterator.isAlive()) {
													if (entityiterator instanceof PlayerEntity) {
														ItemStack _setstack = new ItemStack(Crystal3Item.block);
														_setstack.setCount((int) 1);
														ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entityiterator), _setstack);
													}
												}
											}
										}
									}
									if (Math.random() < 0.7) {
										{
											List<Entity> _entfound = world
													.getEntitiesWithinAABB(Entity.class, new AxisAlignedBB(x - (20 / 2d), y - (20 / 2d),
															z - (20 / 2d), x + (20 / 2d), y + (20 / 2d), z + (20 / 2d)), null)
													.stream().sorted(new Object() {
														Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
															return Comparator.comparing(
																	(Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
														}
													}.compareDistOf(x, y, z)).collect(Collectors.toList());
											for (Entity entityiterator : _entfound) {
												if (entityiterator.isAlive()) {
													if (entityiterator instanceof PlayerEntity) {
														ItemStack _setstack = new ItemStack(Walletx8Item.block);
														_setstack.setCount((int) 1);
														ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entityiterator), _setstack);
													}
													if (entityiterator instanceof PlayerEntity) {
														ItemStack _setstack = new ItemStack(MegafluxTankItem.block);
														_setstack.setCount((int) 1);
														ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entityiterator), _setstack);
													}
												}
											}
										}
									} else {
										{
											List<Entity> _entfound = world
													.getEntitiesWithinAABB(Entity.class, new AxisAlignedBB(x - (20 / 2d), y - (20 / 2d),
															z - (20 / 2d), x + (20 / 2d), y + (20 / 2d), z + (20 / 2d)), null)
													.stream().sorted(new Object() {
														Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
															return Comparator.comparing(
																	(Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
														}
													}.compareDistOf(x, y, z)).collect(Collectors.toList());
											for (Entity entityiterator : _entfound) {
												if (entityiterator.isAlive()) {
													if (entityiterator instanceof PlayerEntity) {
														ItemStack _setstack = new ItemStack(Walletx8Item.block);
														_setstack.setCount((int) 2);
														ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entityiterator), _setstack);
													}
													if (entityiterator instanceof PlayerEntity) {
														ItemStack _setstack = new ItemStack(MegafluxTankItem.block);
														_setstack.setCount((int) 2);
														ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entityiterator), _setstack);
													}
												}
											}
										}
									}
									MinecraftForge.EVENT_BUS.unregister(this);
								}
							}.start(world, (int) 20);
							if (world instanceof World && !world.isRemote()) {
								((World) world).playSound(null, new BlockPos((int) x, (int) y, (int) z),
										(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
												.getValue(new ResourceLocation("demonicblessing:chestopening")),
										SoundCategory.BLOCKS, (float) 2, (float) 1);
							} else {
								((World) world).playSound(x, y, z,
										(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
												.getValue(new ResourceLocation("demonicblessing:chestopening")),
										SoundCategory.BLOCKS, (float) 2, (float) 1, false);
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
										BlockPos _bp = new BlockPos((int) x, (int) (y + 21), (int) z);
										BlockState _bs = ChestBlock.block.getDefaultState();
										BlockState _bso = world.getBlockState(_bp);
										for (Map.Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
											Property _property = _bs.getBlock().getStateContainer().getProperty(entry.getKey().getName());
											if (_property != null && _bs.get(_property) != null)
												try {
													_bs = _bs.with(_property, (Comparable) entry.getValue());
												} catch (Exception e) {
												}
										}
										world.setBlockState(_bp, _bs, 3);
									}
									MinecraftForge.EVENT_BUS.unregister(this);
								}
							}.start(world, (int) 84000);
						}
					} else {
						if (!world.isRemote()) {
							BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
							TileEntity _tileEntity = world.getTileEntity(_bp);
							BlockState _bs = world.getBlockState(_bp);
							if (_tileEntity != null)
								_tileEntity.getTileData().putDouble("chest", 0);
							if (world instanceof World)
								((World) world).notifyBlockUpdate(_bp, _bs, _bs, 3);
						}
					}
					MinecraftForge.EVENT_BUS.unregister(this);
				}
			}.start(world, (int) 2100);
		}
	}
}
