
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
public class Walletx8Item extends DemonicblessingModElements.ModElement {
	@ObjectHolder("demonicblessing:walletx_8")
	public static final Item block = null;

	public Walletx8Item(DemonicblessingModElements instance) {
		super(instance, 236);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}

	public static class ItemCustom extends Item {
		public ItemCustom() {
			super(new Item.Properties().group(DemonicBlessingItemGroup.tab).maxStackSize(64).rarity(Rarity.COMMON));
			setRegistryName("walletx_8");
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
					"\u0418\u043C\u0435\u0435\u0442 \u0431\u043E\u043B\u044C\u0448\u0438\u0439 \u0441\u043F\u0435\u043A\u0442\u0440 \u043D\u0430\u0433\u0440\u0430\u0434 \u0438 \u043E\u0447\u0435\u043D\u044C \u043C\u0430\u043B\u0435\u043D\u044C\u043A\u0438\u0439 \u0448\u0430\u043D\u0441 \u043D\u0430 \u043D\u0435\u0440\u0435\u0430\u043B\u044C\u043D\u043E \u0446\u0435\u043D\u043D\u044B\u0439 \u043B\u0443\u0442"));
		}
	}
}
