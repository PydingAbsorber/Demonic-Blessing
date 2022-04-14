
package net.mcreator.demonicblessing.block;

import net.mcreator.demonicblessing.entity.ArthasEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.IBlockReader;
import net.minecraft.util.math.BlockPos;
import net.minecraft.loot.LootContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.BlockItem;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.block.material.Material;
import net.minecraft.block.SoundType;
import net.minecraft.block.BlockState;
import net.minecraft.block.Block;

import net.mcreator.demonicblessing.itemgroup.DemonicBlessingItemGroup;
import net.mcreator.demonicblessing.DemonicblessingModElements;

import java.util.List;
import java.util.Collections;

@DemonicblessingModElements.ModElement.Tag
public class PostamentArtasaBlock extends DemonicblessingModElements.ModElement {
	@ObjectHolder("demonicblessing:postament_artasa")
	public static final Block block = null;
	public PostamentArtasaBlock(DemonicblessingModElements instance) {
		super(instance, 136);
	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new CustomBlock());
		elements.items
				.add(() -> new BlockItem(block, new Item.Properties().group(DemonicBlessingItemGroup.tab)).setRegistryName(block.getRegistryName()));
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public void clientLoad(FMLClientSetupEvent event) {
		RenderTypeLookup.setRenderLayer(block, RenderType.getCutout());
	}
	public static class CustomBlock extends Block {
		public CustomBlock() {
			super(Block.Properties.create(Material.ROCK).sound(SoundType.METAL).hardnessAndResistance(10000f, 10118f).setLightLevel(s -> 0).notSolid()
					.setOpaque((bs, br, bp) -> false));
			setRegistryName("postament_artasa");
		}

		@Override
		public boolean propagatesSkylightDown(BlockState state, IBlockReader reader, BlockPos pos) {
			return true;
		}

		@Override
		public int getOpacity(BlockState state, IBlockReader worldIn, BlockPos pos) {
			return 0;
		}

		@Override
		public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
			List<ItemStack> dropsOriginal = super.getDrops(state, builder);
			if (!dropsOriginal.isEmpty())
				return dropsOriginal;
			return Collections.singletonList(new ItemStack(this, 0));
		}

		@Override
		public ActionResultType onBlockActivated(BlockState blockstate, World world, BlockPos pos, PlayerEntity entity, Hand hand,
												 BlockRayTraceResult hit) {
			super.onBlockActivated(blockstate, world, pos, entity, hand, hit);
			if (world instanceof ServerWorld) {
				Entity entityToSpawn = new ArthasEntity.CustomEntity(ArthasEntity.entity, (World) world);
				entityToSpawn.setLocationAndAngles(pos.getX()+0.5F, pos.getY(), pos.getZ()+0.5F, 360F, 0);
				if (entityToSpawn instanceof MobEntity) {
					((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world, world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED, null, null);
					world.destroyBlock(pos, false);
					world.addEntity(entityToSpawn);
				}
			}
			return ActionResultType.SUCCESS;
		}
	}
}
