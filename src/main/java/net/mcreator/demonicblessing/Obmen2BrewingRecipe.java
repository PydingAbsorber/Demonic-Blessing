
package net.mcreator.demonicblessing;

import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.common.brewing.IBrewingRecipe;
import net.minecraftforge.common.brewing.BrewingRecipeRegistry;

import net.minecraft.item.ItemStack;
import net.minecraft.block.Blocks;

import net.mcreator.demonicblessing.item.KaynScytheItem;
import net.mcreator.demonicblessing.item.DarkinScytheItem;

@DemonicblessingModElements.ModElement.Tag
public class Obmen2BrewingRecipe extends DemonicblessingModElements.ModElement {
	public Obmen2BrewingRecipe(DemonicblessingModElements instance) {
		super(instance, 150);
	}

	@Override
	public void init(FMLCommonSetupEvent event) {
		BrewingRecipeRegistry.addRecipe(new CustomBrewingRecipe());
	}

	public static class CustomBrewingRecipe implements IBrewingRecipe {
		@Override
		public boolean isInput(ItemStack input) {
			return input.getItem() == KaynScytheItem.block;
		}

		@Override
		public boolean isIngredient(ItemStack ingredient) {
			return ingredient.getItem() == Blocks.DRAGON_EGG.asItem();
		}

		@Override
		public ItemStack getOutput(ItemStack input, ItemStack ingredient) {
			if (isInput(input) && isIngredient(ingredient)) {
				return new ItemStack(DarkinScytheItem.block);
			}
			return ItemStack.EMPTY;
		}
	}
}
