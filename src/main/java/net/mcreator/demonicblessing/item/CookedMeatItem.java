
package net.mcreator.demonicblessing.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.UseAction;
import net.minecraft.item.Rarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.Food;

import net.mcreator.demonicblessing.itemgroup.DemonicBlessingItemGroup;
import net.mcreator.demonicblessing.DemonicblessingModElements;

@DemonicblessingModElements.ModElement.Tag
public class CookedMeatItem extends DemonicblessingModElements.ModElement {
	@ObjectHolder("demonicblessing:cooked_meat")
	public static final Item block = null;

	public CookedMeatItem(DemonicblessingModElements instance) {
		super(instance, 371);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new FoodItemCustom());
	}

	public static class FoodItemCustom extends Item {
		public FoodItemCustom() {
			super(new Item.Properties().group(DemonicBlessingItemGroup.tab).maxStackSize(64).rarity(Rarity.RARE)
					.food((new Food.Builder()).hunger(16).saturation(10f)

							.build()));
			setRegistryName("cooked_meat");
		}

		@Override
		public int getUseDuration(ItemStack stack) {
			return 20;
		}

		@Override
		public UseAction getUseAction(ItemStack itemstack) {
			return UseAction.EAT;
		}
	}
}
