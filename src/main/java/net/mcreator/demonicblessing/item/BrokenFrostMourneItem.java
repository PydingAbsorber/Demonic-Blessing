
package net.mcreator.demonicblessing.item;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.Rarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.block.BlockState;

import net.mcreator.demonicblessing.itemgroup.DemonicBlessingItemGroup;
import net.mcreator.demonicblessing.DemonicblessingModElements;

import javax.annotation.Nullable;
import java.util.List;

@DemonicblessingModElements.ModElement.Tag
public class BrokenFrostMourneItem extends DemonicblessingModElements.ModElement {
	@ObjectHolder("demonicblessing:broken_frost_mourne")
	public static final Item block = null;
	public BrokenFrostMourneItem(DemonicblessingModElements instance) {
		super(instance, 135);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}
	public static class ItemCustom extends Item {
		public ItemCustom() {
			super(new Item.Properties().group(DemonicBlessingItemGroup.tab).maxStackSize(1).isImmuneToFire().rarity(Rarity.RARE));
			setRegistryName("broken_frost_mourne");
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
		public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
			super.addInformation(stack, worldIn, tooltip, flagIn);
			if (Screen.hasControlDown()) {
				tooltip.add(new StringTextComponent(""));
//				tooltip.add(new StringTextComponent("§7§oа рукоять была уничтожена окончательно, но я чувствую что меч можно восстановить\""));
			}
			tooltip.add(new StringTextComponent(""));
		}
	}
}
