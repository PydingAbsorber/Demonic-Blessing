
package net.mcreator.demonicblessing.itemgroup;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

import net.mcreator.demonicblessing.item.GodlyredsoulItem;
import net.mcreator.demonicblessing.DemonicblessingModElements;

@DemonicblessingModElements.ModElement.Tag
public class DemonicBlessingItemGroup extends DemonicblessingModElements.ModElement {
	public DemonicBlessingItemGroup(DemonicblessingModElements instance) {
		super(instance, 45);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabdemonic_blessing") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(GodlyredsoulItem.block);
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}

	public static ItemGroup tab;
}
