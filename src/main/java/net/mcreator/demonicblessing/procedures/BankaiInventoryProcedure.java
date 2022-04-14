package net.mcreator.demonicblessing.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Direction;
import net.minecraft.scoreboard.Scoreboard;
import net.minecraft.scoreboard.ScoreObjective;
import net.minecraft.scoreboard.ScoreCriteria;
import net.minecraft.scoreboard.Score;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.demonicblessing.item.BankaiItem;
import net.mcreator.demonicblessing.DemonicblessingMod;

import java.util.Map;
import java.util.Collections;

public class BankaiInventoryProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				DemonicblessingMod.LOGGER.warn("Failed to load dependency world for procedure BankaiInventory!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				DemonicblessingMod.LOGGER.warn("Failed to load dependency x for procedure BankaiInventory!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				DemonicblessingMod.LOGGER.warn("Failed to load dependency y for procedure BankaiInventory!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				DemonicblessingMod.LOGGER.warn("Failed to load dependency z for procedure BankaiInventory!");
			return;
		}
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				DemonicblessingMod.LOGGER.warn("Failed to load dependency entity for procedure BankaiInventory!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		Entity entity = (Entity) dependencies.get("entity");
		if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY).getItem() == BankaiItem.block
				&& !(((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY)
						.getItem() == BankaiItem.block)) {
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
			}.getScore("aa") == 2) {
				if ((entity.getHorizontalFacing()) == Direction.EAST) {
					{
						Entity _ent = entity;
						_ent.setPositionAndUpdate(x, y, (z - 6));
						if (_ent instanceof ServerPlayerEntity) {
							((ServerPlayerEntity) _ent).connection.setPlayerLocation(x, y, (z - 6), _ent.rotationYaw, _ent.rotationPitch,
									Collections.emptySet());
						}
					}
					{
						Entity _ent = entity;
						if (_ent instanceof PlayerEntity) {
							Scoreboard _sc = ((PlayerEntity) _ent).getWorldScoreboard();
							ScoreObjective _so = _sc.getObjective("aa");
							if (_so == null) {
								_so = _sc.addObjective("aa", ScoreCriteria.DUMMY, new StringTextComponent("aa"), ScoreCriteria.RenderType.INTEGER);
							}
							Score _scr = _sc.getOrCreateScore(((PlayerEntity) _ent).getScoreboardName(), _so);
							_scr.setScorePoints((int) 0);
						}
					}
				} else if ((entity.getHorizontalFacing()) == Direction.WEST) {
					{
						Entity _ent = entity;
						_ent.setPositionAndUpdate(x, y, (z + 6));
						if (_ent instanceof ServerPlayerEntity) {
							((ServerPlayerEntity) _ent).connection.setPlayerLocation(x, y, (z + 6), _ent.rotationYaw, _ent.rotationPitch,
									Collections.emptySet());
						}
					}
					{
						Entity _ent = entity;
						if (_ent instanceof PlayerEntity) {
							Scoreboard _sc = ((PlayerEntity) _ent).getWorldScoreboard();
							ScoreObjective _so = _sc.getObjective("aa");
							if (_so == null) {
								_so = _sc.addObjective("aa", ScoreCriteria.DUMMY, new StringTextComponent("aa"), ScoreCriteria.RenderType.INTEGER);
							}
							Score _scr = _sc.getOrCreateScore(((PlayerEntity) _ent).getScoreboardName(), _so);
							_scr.setScorePoints((int) 0);
						}
					}
				} else if ((entity.getHorizontalFacing()) == Direction.NORTH) {
					{
						Entity _ent = entity;
						_ent.setPositionAndUpdate((x - 6), y, z);
						if (_ent instanceof ServerPlayerEntity) {
							((ServerPlayerEntity) _ent).connection.setPlayerLocation((x - 6), y, z, _ent.rotationYaw, _ent.rotationPitch,
									Collections.emptySet());
						}
					}
					{
						Entity _ent = entity;
						if (_ent instanceof PlayerEntity) {
							Scoreboard _sc = ((PlayerEntity) _ent).getWorldScoreboard();
							ScoreObjective _so = _sc.getObjective("aa");
							if (_so == null) {
								_so = _sc.addObjective("aa", ScoreCriteria.DUMMY, new StringTextComponent("aa"), ScoreCriteria.RenderType.INTEGER);
							}
							Score _scr = _sc.getOrCreateScore(((PlayerEntity) _ent).getScoreboardName(), _so);
							_scr.setScorePoints((int) 0);
						}
					}
				} else if ((entity.getHorizontalFacing()) == Direction.SOUTH) {
					{
						Entity _ent = entity;
						_ent.setPositionAndUpdate((x + 6), y, z);
						if (_ent instanceof ServerPlayerEntity) {
							((ServerPlayerEntity) _ent).connection.setPlayerLocation((x + 6), y, z, _ent.rotationYaw, _ent.rotationPitch,
									Collections.emptySet());
						}
					}
					{
						Entity _ent = entity;
						if (_ent instanceof PlayerEntity) {
							Scoreboard _sc = ((PlayerEntity) _ent).getWorldScoreboard();
							ScoreObjective _so = _sc.getObjective("aa");
							if (_so == null) {
								_so = _sc.addObjective("aa", ScoreCriteria.DUMMY, new StringTextComponent("aa"), ScoreCriteria.RenderType.INTEGER);
							}
							Score _scr = _sc.getOrCreateScore(((PlayerEntity) _ent).getScoreboardName(), _so);
							_scr.setScorePoints((int) 0);
						}
					}
				}
				if (world.isRemote()) {
					if (world instanceof World && !world.isRemote()) {
						((World) world).playSound(null, new BlockPos((int) x, (int) y, (int) z),
								(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("demonicblessing:sonido")),
								SoundCategory.BLOCKS, (float) 1, (float) 1);
					} else {
						((World) world).playSound(x, y, z,
								(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("demonicblessing:sonido")),
								SoundCategory.BLOCKS, (float) 1, (float) 1, false);
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
			}.getScore("dd") == 2) {
				if ((entity.getHorizontalFacing()) == Direction.EAST) {
					{
						Entity _ent = entity;
						_ent.setPositionAndUpdate(x, y, (z + 6));
						if (_ent instanceof ServerPlayerEntity) {
							((ServerPlayerEntity) _ent).connection.setPlayerLocation(x, y, (z + 6), _ent.rotationYaw, _ent.rotationPitch,
									Collections.emptySet());
						}
					}
					{
						Entity _ent = entity;
						if (_ent instanceof PlayerEntity) {
							Scoreboard _sc = ((PlayerEntity) _ent).getWorldScoreboard();
							ScoreObjective _so = _sc.getObjective("dd");
							if (_so == null) {
								_so = _sc.addObjective("dd", ScoreCriteria.DUMMY, new StringTextComponent("dd"), ScoreCriteria.RenderType.INTEGER);
							}
							Score _scr = _sc.getOrCreateScore(((PlayerEntity) _ent).getScoreboardName(), _so);
							_scr.setScorePoints((int) 0);
						}
					}
				} else if ((entity.getHorizontalFacing()) == Direction.WEST) {
					{
						Entity _ent = entity;
						_ent.setPositionAndUpdate(x, y, (z - 6));
						if (_ent instanceof ServerPlayerEntity) {
							((ServerPlayerEntity) _ent).connection.setPlayerLocation(x, y, (z - 6), _ent.rotationYaw, _ent.rotationPitch,
									Collections.emptySet());
						}
					}
					{
						Entity _ent = entity;
						if (_ent instanceof PlayerEntity) {
							Scoreboard _sc = ((PlayerEntity) _ent).getWorldScoreboard();
							ScoreObjective _so = _sc.getObjective("dd");
							if (_so == null) {
								_so = _sc.addObjective("dd", ScoreCriteria.DUMMY, new StringTextComponent("dd"), ScoreCriteria.RenderType.INTEGER);
							}
							Score _scr = _sc.getOrCreateScore(((PlayerEntity) _ent).getScoreboardName(), _so);
							_scr.setScorePoints((int) 0);
						}
					}
				} else if ((entity.getHorizontalFacing()) == Direction.NORTH) {
					{
						Entity _ent = entity;
						_ent.setPositionAndUpdate((x + 6), y, z);
						if (_ent instanceof ServerPlayerEntity) {
							((ServerPlayerEntity) _ent).connection.setPlayerLocation((x + 6), y, z, _ent.rotationYaw, _ent.rotationPitch,
									Collections.emptySet());
						}
					}
					{
						Entity _ent = entity;
						if (_ent instanceof PlayerEntity) {
							Scoreboard _sc = ((PlayerEntity) _ent).getWorldScoreboard();
							ScoreObjective _so = _sc.getObjective("dd");
							if (_so == null) {
								_so = _sc.addObjective("dd", ScoreCriteria.DUMMY, new StringTextComponent("dd"), ScoreCriteria.RenderType.INTEGER);
							}
							Score _scr = _sc.getOrCreateScore(((PlayerEntity) _ent).getScoreboardName(), _so);
							_scr.setScorePoints((int) 0);
						}
					}
				} else if ((entity.getHorizontalFacing()) == Direction.SOUTH) {
					{
						Entity _ent = entity;
						_ent.setPositionAndUpdate((x - 6), y, z);
						if (_ent instanceof ServerPlayerEntity) {
							((ServerPlayerEntity) _ent).connection.setPlayerLocation((x - 6), y, z, _ent.rotationYaw, _ent.rotationPitch,
									Collections.emptySet());
						}
					}
					{
						Entity _ent = entity;
						if (_ent instanceof PlayerEntity) {
							Scoreboard _sc = ((PlayerEntity) _ent).getWorldScoreboard();
							ScoreObjective _so = _sc.getObjective("dd");
							if (_so == null) {
								_so = _sc.addObjective("dd", ScoreCriteria.DUMMY, new StringTextComponent("dd"), ScoreCriteria.RenderType.INTEGER);
							}
							Score _scr = _sc.getOrCreateScore(((PlayerEntity) _ent).getScoreboardName(), _so);
							_scr.setScorePoints((int) 0);
						}
					}
				}
				if (world.isRemote()) {
					if (world instanceof World && !world.isRemote()) {
						((World) world).playSound(null, new BlockPos((int) x, (int) y, (int) z),
								(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("demonicblessing:sonido")),
								SoundCategory.BLOCKS, (float) 1, (float) 1);
					} else {
						((World) world).playSound(x, y, z,
								(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("demonicblessing:sonido")),
								SoundCategory.BLOCKS, (float) 1, (float) 1, false);
					}
				}
			}
		}
	}
}
