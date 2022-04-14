
package net.mcreator.demonicblessing.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.Rarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.block.BlockState;

import net.mcreator.demonicblessing.DemonicblessingModElements;

@DemonicblessingModElements.ModElement.Tag
public class UlquiorraDeathItem extends DemonicblessingModElements.ModElement {
	@ObjectHolder("demonicblessing:ulquiorra_death")
	public static final Item block = null;

	public UlquiorraDeathItem(DemonicblessingModElements instance) {
		super(instance, 123);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}

	public static class ItemCustom extends Item {
		public ItemCustom() {
			super(new Item.Properties().group(null).maxStackSize(0).rarity(Rarity.COMMON));
			setRegistryName("ulquiorra_death");
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
			return 1F;
		}
	}
}
