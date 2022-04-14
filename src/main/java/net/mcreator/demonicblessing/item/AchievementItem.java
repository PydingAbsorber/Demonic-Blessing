
package net.mcreator.demonicblessing.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.world.World;
import net.minecraft.item.Rarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.entity.LivingEntity;
import net.minecraft.block.BlockState;

import net.mcreator.demonicblessing.procedures.AchievementOnPlayerStoppedUsingProcedure;
import net.mcreator.demonicblessing.DemonicblessingModElements;

import java.util.Collections;

@DemonicblessingModElements.ModElement.Tag
public class AchievementItem extends DemonicblessingModElements.ModElement {
	@ObjectHolder("demonicblessing:achievement")
	public static final Item block = null;

	public AchievementItem(DemonicblessingModElements instance) {
		super(instance, 34);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}

	public static class ItemCustom extends Item {
		public ItemCustom() {
			super(new Item.Properties().group(null).maxStackSize(0).rarity(Rarity.COMMON));
			setRegistryName("achievement");
		}

		@Override
		public int getItemEnchantability() {
			return 0;
		}

		@Override
		public int getUseDuration(ItemStack itemstack) {
			return 0;
		}

		@Override
		public float getDestroySpeed(ItemStack par1ItemStack, BlockState par2Block) {
			return 0F;
		}

		@Override
		public void onPlayerStoppedUsing(ItemStack itemstack, World world, LivingEntity entity, int time) {
			double x = entity.getPosX();
			double y = entity.getPosY();
			double z = entity.getPosZ();

			AchievementOnPlayerStoppedUsingProcedure.executeProcedure(Collections.EMPTY_MAP);
		}
	}
}
