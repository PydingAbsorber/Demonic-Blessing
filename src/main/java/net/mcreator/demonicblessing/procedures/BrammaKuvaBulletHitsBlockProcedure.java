package net.mcreator.demonicblessing.procedures;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.fml.network.NetworkHooks;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.DamageSource;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.network.PacketBuffer;
import net.minecraft.item.ItemStack;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.inventory.container.Container;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.demonicblessing.item.Mod2Item;
import net.mcreator.demonicblessing.item.Mod1Item;
import net.mcreator.demonicblessing.item.BrammaKuvaItem;
import net.mcreator.demonicblessing.gui.BonkGui;
import net.mcreator.demonicblessing.DemonicblessingMod;

import java.util.stream.Collectors;
import java.util.function.Function;
import java.util.Map;
import java.util.List;
import java.util.Comparator;

import io.netty.buffer.Unpooled;

public class BrammaKuvaBulletHitsBlockProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				DemonicblessingMod.LOGGER.warn("Failed to load dependency world for procedure BrammaKuvaBulletHitsBlock!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				DemonicblessingMod.LOGGER.warn("Failed to load dependency x for procedure BrammaKuvaBulletHitsBlock!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				DemonicblessingMod.LOGGER.warn("Failed to load dependency y for procedure BrammaKuvaBulletHitsBlock!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				DemonicblessingMod.LOGGER.warn("Failed to load dependency z for procedure BrammaKuvaBulletHitsBlock!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		if (world instanceof ServerWorld) {
			((ServerWorld) world).spawnParticle(ParticleTypes.EXPLOSION, x, y, z, (int) 40, 3, 3, 3, 1);
		}
		if (world.isRemote()) {
			if (world instanceof World && !world.isRemote()) {
				((World) world).playSound(null, new BlockPos((int) x, (int) y, (int) z),
						(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("demonicblessing:shotbramma")),
						SoundCategory.BLOCKS, (float) 1, (float) 1);
			} else {
				((World) world).playSound(x, y, z,
						(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("demonicblessing:shotbramma")),
						SoundCategory.BLOCKS, (float) 1, (float) 1, false);
			}
		}
		{
			List<Entity> _entfound = world
					.getEntitiesWithinAABB(Entity.class,
							new AxisAlignedBB(x - (12 / 2d), y - (12 / 2d), z - (12 / 2d), x + (12 / 2d), y + (12 / 2d), z + (12 / 2d)), null)
					.stream().sorted(new Object() {
						Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
							return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
						}
					}.compareDistOf(x, y, z)).collect(Collectors.toList());
			for (Entity entityiterator : _entfound) {
				if (!((entityiterator instanceof PlayerEntity)
						? ((PlayerEntity) entityiterator).inventory.hasItemStack(new ItemStack(Mod2Item.block))
						: false)) {
					entityiterator.attackEntityFrom(DamageSource.OUT_OF_WORLD, (float) 1400);
					entityiterator.attackEntityFrom(DamageSource.LIGHTNING_BOLT, (float) 666);
				} else {
					if (!(((entityiterator instanceof LivingEntity) ? ((LivingEntity) entityiterator).getHeldItemMainhand() : ItemStack.EMPTY)
							.getItem() == BrammaKuvaItem.block)) {
						entityiterator.attackEntityFrom(DamageSource.OUT_OF_WORLD, (float) 1400);
						entityiterator.attackEntityFrom(DamageSource.LIGHTNING_BOLT, (float) 666);
					}
				}
				if (!((entityiterator instanceof PlayerEntity)
						? ((PlayerEntity) entityiterator).inventory.hasItemStack(new ItemStack(Mod1Item.block))
						: false)) {
					{
						Entity _ent = entityiterator;
						if (_ent instanceof ServerPlayerEntity) {
							BlockPos _bpos = new BlockPos((int) x, (int) y, (int) z);
							NetworkHooks.openGui((ServerPlayerEntity) _ent, new INamedContainerProvider() {
								@Override
								public ITextComponent getDisplayName() {
									return new StringTextComponent("Bonk");
								}

								@Override
								public Container createMenu(int id, PlayerInventory inventory, PlayerEntity player) {
									return new BonkGui.GuiContainerMod(id, inventory, new PacketBuffer(Unpooled.buffer()).writeBlockPos(_bpos));
								}
							}, _bpos);
						}
					}
				} else {
					if (!(((entityiterator instanceof LivingEntity) ? ((LivingEntity) entityiterator).getHeldItemMainhand() : ItemStack.EMPTY)
							.getItem() == BrammaKuvaItem.block)) {
						{
							Entity _ent = entityiterator;
							if (_ent instanceof ServerPlayerEntity) {
								BlockPos _bpos = new BlockPos((int) x, (int) y, (int) z);
								NetworkHooks.openGui((ServerPlayerEntity) _ent, new INamedContainerProvider() {
									@Override
									public ITextComponent getDisplayName() {
										return new StringTextComponent("Bonk");
									}

									@Override
									public Container createMenu(int id, PlayerInventory inventory, PlayerEntity player) {
										return new BonkGui.GuiContainerMod(id, inventory, new PacketBuffer(Unpooled.buffer()).writeBlockPos(_bpos));
									}
								}, _bpos);
							}
						}
					}
				}
			}
		}
	}
}
