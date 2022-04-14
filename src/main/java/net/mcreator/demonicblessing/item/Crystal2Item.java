
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
public class Crystal2Item extends DemonicblessingModElements.ModElement {
	@ObjectHolder("demonicblessing:crystal_2")
	public static final Item block = null;

	public Crystal2Item(DemonicblessingModElements instance) {
		super(instance, 220);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}

	public static class ItemCustom extends Item {
		public ItemCustom() {
			super(new Item.Properties().group(DemonicBlessingItemGroup.tab).maxStackSize(1).rarity(Rarity.EPIC));
			setRegistryName("crystal_2");
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
					"\u00A7d\u041F\u0435\u0440\u0435\u0437\u0430\u0440\u044F\u0436\u0430\u0435\u0442 \u0432\u0441\u0435 \u0437\u0430\u0440\u044F\u0434\u044B \u0442\u0435\u043B\u0435\u043F\u043E\u0440\u0442\u0430 \u043F\u043E\u0441\u043B\u0435 \u0438\u0441\u043F\u043E\u043B\u044C\u0437\u043E\u0432\u0430\u043D\u0438\u044F \u043E\u0441\u043E\u0431\u043E\u0439 \u0441\u043F\u043E\u0441\u043E\u0431\u043D\u043E\u0441\u0442\u0438"));
		}
	}
}
