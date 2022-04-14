
package net.mcreator.demonicblessing.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.world.World;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.item.Rarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.block.BlockState;

import net.mcreator.demonicblessing.procedures.FuckJreskoSummonItemIsDroppedByPlayerProcedure;
import net.mcreator.demonicblessing.itemgroup.DemonicBlessingItemGroup;
import net.mcreator.demonicblessing.DemonicblessingModElements;

import java.util.stream.Stream;
import java.util.Map;
import java.util.List;
import java.util.HashMap;
import java.util.AbstractMap;

@DemonicblessingModElements.ModElement.Tag
public class FuckJreskoSummonItem extends DemonicblessingModElements.ModElement {
	@ObjectHolder("demonicblessing:fuck_jresko_summon")
	public static final Item block = null;

	public FuckJreskoSummonItem(DemonicblessingModElements instance) {
		super(instance, 141);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}

	public static class ItemCustom extends Item {
		public ItemCustom() {
			super(new Item.Properties().group(DemonicBlessingItemGroup.tab).maxStackSize(1).rarity(Rarity.EPIC));
			setRegistryName("fuck_jresko_summon");
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
					"\u041C\u043E\u0436\u0435\u0442 \u0442\u0435\u0440\u0440\u0430\u0440\u0438\u044F \u043F\u043E\u0434\u0441\u043A\u0430\u0436\u0435\u0442"));
			list.add(new StringTextComponent(
					"\u0447\u0442\u043E \u0441 \u043D\u0435\u0439 \u043D\u0430\u0434\u043E \u0441\u0434\u0435\u043B\u0430\u0442\u044C?"));
		}

		@Override
		public boolean onDroppedByPlayer(ItemStack itemstack, PlayerEntity entity) {
			double x = entity.getPosX();
			double y = entity.getPosY();
			double z = entity.getPosZ();
			World world = entity.world;

			FuckJreskoSummonItemIsDroppedByPlayerProcedure.executeProcedure(Stream
					.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("x", x), new AbstractMap.SimpleEntry<>("y", y),
							new AbstractMap.SimpleEntry<>("z", z))
					.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			return true;
		}
	}
}
