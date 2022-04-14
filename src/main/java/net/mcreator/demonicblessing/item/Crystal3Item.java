
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
public class Crystal3Item extends DemonicblessingModElements.ModElement {
	@ObjectHolder("demonicblessing:crystal_3")
	public static final Item block = null;

	public Crystal3Item(DemonicblessingModElements instance) {
		super(instance, 221);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}

	public static class ItemCustom extends Item {
		public ItemCustom() {
			super(new Item.Properties().group(DemonicBlessingItemGroup.tab).maxStackSize(1).rarity(Rarity.UNCOMMON));
			setRegistryName("crystal_3");
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
					"\u00A76\u0423\u0432\u0435\u043B\u0438\u0447\u0438\u0432\u0430\u0435\u0442 \u0437\u0430\u0449\u0438\u0442\u0443 \u0441\u0435\u0442\u0430 \u043D\u0438\u043D\u0437\u0438"));
			list.add(new StringTextComponent(
					"\u00A76\u043F\u043E\u043A\u0430 \u0432 \u0438\u043D\u0432\u0435\u043D\u0442\u0430\u0440\u0435 \u043A\u0430\u043C\u0435\u043D\u044C \u0438 \u0432 \u0440\u0443\u043A\u0430\u0445 \u0440\u0430\u0441\u0441\u0435\u043A\u0430\u044E\u0449\u0438\u0439 \u0442\u0443\u043C\u0430\u043D\u00A76\u0430 \u043D\u0430 \u0441\u043A\u043E\u043B\u044C\u043A\u043E \u043D\u0435 \u0441\u043A\u0430\u0436\u0443 \u00A76:))) \u00A76\u0422\u0430\u043A\u0436\u0435 \u0434\u043E\u0431\u0430\u0432\u043B\u044F\u0435\u0442 \u0430\u0442\u0430\u043A\u0435 \u043F\u043E \u043F\u043B\u043E\u0449\u0430\u0434\u0438 \u043C\u0430\u043B\u0435\u043D\u044C\u043A\u0438\u0439 \u0441\u044D\u0442\u0445\u044D\u043B\u0441 \u0438 \u0448\u0430\u043D\u0441 10% \u043D\u0435 \u043F\u043E\u0442\u0440\u0430\u0442\u0438\u0442\u044C \u044D\u043D\u0435\u0440\u0433\u0438\u044E \u043D\u0430 \u0442\u0435\u043B\u0435\u043F\u043E\u0440\u0442\u0430\u0446\u0438\u044E"));
		}
	}
}
