package net.mcreator.demonicblessing.procedures;

import net.minecraftforge.items.ItemHandlerHelper;

import net.minecraft.item.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.inventory.container.Slot;
import net.minecraft.inventory.container.Container;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;
import net.minecraft.block.Blocks;

import net.mcreator.demonicblessing.item.StarItem;
import net.mcreator.demonicblessing.item.ShadowzxcItem;
import net.mcreator.demonicblessing.item.ShadowingotItem;
import net.mcreator.demonicblessing.item.SecretBossSpawnItem;
import net.mcreator.demonicblessing.item.Mod1Item;
import net.mcreator.demonicblessing.item.MegafluxTankItem;
import net.mcreator.demonicblessing.item.FuckJreskoSummonItem;
import net.mcreator.demonicblessing.item.FluxItem;
import net.mcreator.demonicblessing.item.Crystal1Item;
import net.mcreator.demonicblessing.item.ChaosSparkItem;
import net.mcreator.demonicblessing.item.BuildersForucsItem;
import net.mcreator.demonicblessing.item.BiletItem;
import net.mcreator.demonicblessing.block.NetherStarBlockBlock;
import net.mcreator.demonicblessing.DemonicblessingMod;

import java.util.function.Supplier;
import java.util.Map;

public class KnigaButtonProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				DemonicblessingMod.LOGGER.warn("Failed to load dependency entity for procedure KnigaButton!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (new Object() {
			public int getAmount(int sltid) {
				if (entity instanceof ServerPlayerEntity) {
					Container _current = ((ServerPlayerEntity) entity).openContainer;
					if (_current instanceof Supplier) {
						Object invobj = ((Supplier) _current).get();
						if (invobj instanceof Map) {
							ItemStack stack = ((Slot) ((Map) invobj).get(sltid)).getStack();;
							if (stack != null)
								return stack.getCount();
						}
					}
				}
				return 0;
			}
		}.getAmount((int) (0)) >= 16) {
			{
				Entity _ent = entity;
				if (_ent instanceof ServerPlayerEntity) {
					Container _current = ((ServerPlayerEntity) _ent).openContainer;
					if (_current instanceof Supplier) {
						Object invobj = ((Supplier) _current).get();
						if (invobj instanceof Map) {
							((Slot) ((Map) invobj).get((int) (0))).decrStackSize((int) (16));
							_current.detectAndSendChanges();
						}
					}
				}
			}
			if (Math.random() < 0.5) {
				if (Math.random() > 0.9) {
					if (entity instanceof PlayerEntity) {
						ItemStack _setstack = new ItemStack(Items.NETHER_STAR);
						_setstack.setCount((int) 1);
						ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
					}
				} else {
					if (entity instanceof PlayerEntity) {
						ItemStack _setstack = new ItemStack(Blocks.IRON_ORE);
						_setstack.setCount((int) 64);
						ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
					}
				}
			} else {
				if (Math.random() < 0.5) {
					if (Math.random() > 0.7) {
						if (entity instanceof PlayerEntity) {
							ItemStack _setstack = new ItemStack(Blocks.DIAMOND_ORE);
							_setstack.setCount((int) 16);
							ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
						}
					} else {
						if (entity instanceof PlayerEntity) {
							ItemStack _setstack = new ItemStack(Blocks.GOLD_ORE);
							_setstack.setCount((int) 32);
							ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
						}
					}
				} else {
					if (Math.random() > 0.9) {
						if (entity instanceof PlayerEntity) {
							ItemStack _setstack = new ItemStack(NetherStarBlockBlock.block);
							_setstack.setCount((int) 1);
							ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
						}
					} else {
						if (entity instanceof PlayerEntity) {
							ItemStack _setstack = new ItemStack(Blocks.LAPIS_ORE);
							_setstack.setCount((int) 64);
							ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
						}
					}
				}
			}
		}
		if (new Object() {
			public int getAmount(int sltid) {
				if (entity instanceof ServerPlayerEntity) {
					Container _current = ((ServerPlayerEntity) entity).openContainer;
					if (_current instanceof Supplier) {
						Object invobj = ((Supplier) _current).get();
						if (invobj instanceof Map) {
							ItemStack stack = ((Slot) ((Map) invobj).get(sltid)).getStack();;
							if (stack != null)
								return stack.getCount();
						}
					}
				}
				return 0;
			}
		}.getAmount((int) (1)) >= 2) {
			{
				Entity _ent = entity;
				if (_ent instanceof ServerPlayerEntity) {
					Container _current = ((ServerPlayerEntity) _ent).openContainer;
					if (_current instanceof Supplier) {
						Object invobj = ((Supplier) _current).get();
						if (invobj instanceof Map) {
							((Slot) ((Map) invobj).get((int) (1))).decrStackSize((int) (2));
							_current.detectAndSendChanges();
						}
					}
				}
			}
			if (Math.random() < 0.9) {
				if (Math.random() < 0.5) {
					if (Math.random() > 0.9) {
						if (entity instanceof PlayerEntity) {
							ItemStack _setstack = new ItemStack(ShadowingotItem.block);
							_setstack.setCount((int) 1);
							ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
						}
					} else {
						if (Math.random() > 0.7) {
							if (entity instanceof PlayerEntity) {
								ItemStack _setstack = new ItemStack(BuildersForucsItem.block);
								_setstack.setCount((int) 1);
								ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
							}
						} else {
							if (entity instanceof PlayerEntity) {
								ItemStack _setstack = new ItemStack(MegafluxTankItem.block);
								_setstack.setCount((int) 1);
								ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
							}
						}
					}
				} else {
					if (Math.random() < 0.5) {
						if (Math.random() > 0.7) {
							if (entity instanceof PlayerEntity) {
								ItemStack _setstack = new ItemStack(Items.NETHERITE_INGOT);
								_setstack.setCount((int) 4);
								ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
							}
						} else {
							if (entity instanceof PlayerEntity) {
								ItemStack _setstack = new ItemStack(Blocks.GOLD_ORE);
								_setstack.setCount((int) 32);
								ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
							}
						}
					} else {
						if (Math.random() > 0.9) {
							if (entity instanceof PlayerEntity) {
								ItemStack _setstack = new ItemStack(NetherStarBlockBlock.block);
								_setstack.setCount((int) 1);
								ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
							}
						} else {
							if (entity instanceof PlayerEntity) {
								ItemStack _setstack = new ItemStack(FluxItem.block);
								_setstack.setCount((int) 1);
								ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
							}
						}
					}
				}
			} else {
				if (Math.random() < 0.4) {
					if (Math.random() > 0.9) {
						if (entity instanceof PlayerEntity) {
							ItemStack _setstack = new ItemStack(BiletItem.block);
							_setstack.setCount((int) 1);
							ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
						}
					} else {
						if (Math.random() > 0.9) {
							if (Math.random() > 0.7) {
								if (Math.random() > 0.9) {
									if (entity instanceof PlayerEntity) {
										ItemStack _setstack = new ItemStack(Mod1Item.block);
										_setstack.setCount((int) 1);
										ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
									}
								} else {
									if (entity instanceof PlayerEntity) {
										ItemStack _setstack = new ItemStack(SecretBossSpawnItem.block);
										_setstack.setCount((int) 1);
										ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
									}
								}
							} else {
								if (entity instanceof PlayerEntity) {
									ItemStack _setstack = new ItemStack(ChaosSparkItem.block);
									_setstack.setCount((int) 1);
									ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
								}
							}
						} else {
							if (Math.random() > 0.9) {
								if (entity instanceof PlayerEntity) {
									ItemStack _setstack = new ItemStack(StarItem.block);
									_setstack.setCount((int) 1);
									ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
								}
							} else {
								if (entity instanceof PlayerEntity) {
									ItemStack _setstack = new ItemStack(Blocks.GOLD_ORE);
									_setstack.setCount((int) 64);
									ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
								}
							}
						}
					}
				} else {
					if (Math.random() < 0.9) {
						if (Math.random() > 0.5) {
							if (entity instanceof PlayerEntity) {
								ItemStack _setstack = new ItemStack(ShadowzxcItem.block);
								_setstack.setCount((int) 1);
								ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
							}
						} else {
							if (entity instanceof PlayerEntity) {
								ItemStack _setstack = new ItemStack(Blocks.DIAMOND_ORE);
								_setstack.setCount((int) 32);
								ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
							}
						}
					} else {
						if (Math.random() > 0.7) {
							if (entity instanceof PlayerEntity) {
								ItemStack _setstack = new ItemStack(Crystal1Item.block);
								_setstack.setCount((int) 1);
								ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
							}
						} else {
							if (entity instanceof PlayerEntity) {
								ItemStack _setstack = new ItemStack(FuckJreskoSummonItem.block);
								_setstack.setCount((int) 1);
								ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
							}
						}
					}
				}
			}
		}
	}
}
