
package net.mcreator.demonicblessing.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.world.World;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.item.Rarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.block.BlockState;

import net.mcreator.demonicblessing.itemgroup.DemonicBlessingItemGroup;
import net.mcreator.demonicblessing.DemonicblessingModElements;

import java.util.List;

@DemonicblessingModElements.ModElement.Tag
public class RedsoulItem extends DemonicblessingModElements.ModElement {
	@ObjectHolder("demonicblessing:redsoul")
	public static final Item block = null;

	public RedsoulItem(DemonicblessingModElements instance) {
		super(instance, 14);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}

	public static class ItemCustom extends Item {
		public ItemCustom() {
			super(new Item.Properties().group(DemonicBlessingItemGroup.tab).maxStackSize(64).rarity(Rarity.UNCOMMON));
			setRegistryName("redsoul");
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

		@Override
		public void addInformation(ItemStack itemstack, World world, List<ITextComponent> list, ITooltipFlag flag) {
			super.addInformation(itemstack, world, list, flag);
			list.add(new StringTextComponent(
					"\u0434\u0443\u0448\u0430 \u0434\u043B\u044F \u043F\u0440\u043E\u0431\u0443\u0436\u0434\u0435\u043D\u0438\u044F \u0432 \u0444\u043E\u0440\u043C\u0443 \u0414\u0430\u0440\u043A\u0438\u043D\u0430-\u0434\u0443\u0448\u0435\u0433\u0443\u0431\u0430"));
		}
	}
}
