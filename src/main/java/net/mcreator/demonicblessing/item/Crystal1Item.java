
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
public class Crystal1Item extends DemonicblessingModElements.ModElement {
	@ObjectHolder("demonicblessing:crystal_1")
	public static final Item block = null;

	public Crystal1Item(DemonicblessingModElements instance) {
		super(instance, 219);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}

	public static class ItemCustom extends Item {
		public ItemCustom() {
			super(new Item.Properties().group(DemonicBlessingItemGroup.tab).maxStackSize(1).isImmuneToFire().rarity(Rarity.RARE));
			setRegistryName("crystal_1");
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
					"\u00A7b\u0423\u0432\u0435\u043B\u0438\u0447\u0438\u0432\u0430\u0435\u0442 \u043A\u043E\u043B\u0438\u0447\u0435\u0441\u0442\u0432\u043E \u0437\u0430\u0440\u044F\u0434\u043E\u0432 \u0442\u0435\u043B\u0435\u043F\u043E\u0440\u0442\u0430 \u0441 1 \u0434\u043E 3"));
			list.add(new StringTextComponent(
					"\u00A7b\u043D\u043E \u0432\u0437\u0430\u043C\u0435\u043D \u0437\u0430\u0440\u044F\u0434\u044B \u0432\u043E\u0441\u0441\u0442\u0430\u043D\u0430\u0432\u043B\u0438\u0432\u0430\u044E\u0442\u0441\u044F \u0442\u0435\u043F\u0435\u0440\u044C \u0437\u0430 \u0432\u0440\u0435\u043C\u044F 3 \u0437\u0430\u0440\u044F\u0434\u043E\u0432 \u0438 \u0441\u0440\u0430\u0437\u0443 \u0432\u0441\u0435"));
		}
	}
}
