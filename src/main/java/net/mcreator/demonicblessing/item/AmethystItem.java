
package net.mcreator.demonicblessing.item;

import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

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
public class AmethystItem extends DemonicblessingModElements.ModElement {
	@ObjectHolder("demonicblessing:amethyst")
	public static final Item block = null;

	public AmethystItem(DemonicblessingModElements instance) {
		super(instance, 224);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}

	public static class ItemCustom extends Item {
		public ItemCustom() {
			super(new Item.Properties().group(DemonicBlessingItemGroup.tab).maxStackSize(1).rarity(Rarity.COMMON));
			setRegistryName("amethyst");
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
		@OnlyIn(Dist.CLIENT)
		public boolean hasEffect(ItemStack itemstack) {
			return true;
		}

		@Override
		public void addInformation(ItemStack itemstack, World world, List<ITextComponent> list, ITooltipFlag flag) {
			super.addInformation(itemstack, world, list, flag);
			list.add(new StringTextComponent(
					"\u00A74\u0414\u043E\u0431\u0430\u0432\u043B\u044F\u0435\u0442 \u00A7c\u0440\u0430\u0441\u0441\u0435\u043A\u0430\u044E\u0449\u0435\u043C\u0443 \u00A76\u0442\u0443\u043C\u0430\u043D\u0443 \u00A7e\u043A\u043E \u00A72\u0432\u0441\u0435\u043C \u00A7a\u0430\u0442\u0430\u043A\u0430\u043C \u00A7b\u0434\u043E\u043F\u043E\u043B\u043D\u0438\u0442\u0435\u043B\u044C\u043D\u044B\u0439 \u00A7b\u0432\u043E\u0438\u0434 \u00A71\u0443\u0440\u043E\u043D"));
			list.add(new StringTextComponent(
					"\u00A79\u0433\u0430\u0440\u0430\u043D\u0442\u0438\u0440\u0443\u0435\u0442 \u00A7d50% \u00A75\u0448\u0430\u043D\u0441 \u00A7f\u043D\u0435 \u00A74\u043F\u043E\u043B\u0443\u0447\u0438\u0442\u044C \u00A7c\u043A\u0434 \u00A76\u043F\u043E\u0441\u043B\u0435 \u00A7e\u0430\u043A\u0442\u0438\u0432\u0430\u0446\u0438\u0438 \u00A72\u0443\u043B\u044C\u0442\u044B(\u0447\u043E \u0437\u0435 gay\u0441\u043A\u0438\u0439 cum\u0435\u043D\u044C?)"));
		}
	}
}
