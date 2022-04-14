
package net.mcreator.demonicblessing.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.world.World;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;
import net.minecraft.client.util.ITooltipFlag;

import net.mcreator.demonicblessing.procedures.LunarianSwordToolInHandTickProcedure;
import net.mcreator.demonicblessing.procedures.LunarianSwordLivingEntityIsHitWithToolProcedure;
import net.mcreator.demonicblessing.itemgroup.DemonicBlessingItemGroup;
import net.mcreator.demonicblessing.DemonicblessingModElements;

import java.util.stream.Stream;
import java.util.Map;
import java.util.List;
import java.util.HashMap;
import java.util.AbstractMap;

@DemonicblessingModElements.ModElement.Tag
public class LunarianSwordItem extends DemonicblessingModElements.ModElement {
	@ObjectHolder("demonicblessing:lunarian_sword")
	public static final Item block = null;

	public LunarianSwordItem(DemonicblessingModElements instance) {
		super(instance, 144);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new SwordItem(new IItemTier() {
			public int getMaxUses() {
				return 0;
			}

			public float getEfficiency() {
				return 4f;
			}

			public float getAttackDamage() {
				return -2f;
			}

			public int getHarvestLevel() {
				return 1;
			}

			public int getEnchantability() {
				return 2;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.EMPTY;
			}
		}, 3, -1f, new Item.Properties().group(DemonicBlessingItemGroup.tab).isImmuneToFire()) {
			@Override
			public void addInformation(ItemStack itemstack, World world, List<ITextComponent> list, ITooltipFlag flag) {
				super.addInformation(itemstack, world, list, flag);
				list.add(new StringTextComponent(
						"\u0417\u0430\u0449\u0438\u0442\u0430 \u0437\u0430 \u0433\u0440\u0430\u043D\u044C\u044E \u043F\u043E\u043D\u0438\u043C\u0430\u043D\u0438\u044F"));
				list.add(new StringTextComponent(
						"\u043D\u043E \u043E\u043D\u0430 \u043D\u0435 \u0432\u0441\u0435\u0441\u0438\u043B\u044C\u043D\u0430"));
				list.add(new StringTextComponent(
						"\u0438\u0442\u0442\u0435\u0440\u0430\u0442\u043E\u0440 \u0442\u0435\u0431\u044F \u043F\u043E\u0433\u0443\u0431\u0438\u0442!"));
			}

			@Override
			public boolean hitEntity(ItemStack itemstack, LivingEntity entity, LivingEntity sourceentity) {
				boolean retval = super.hitEntity(itemstack, entity, sourceentity);
				double x = entity.getPosX();
				double y = entity.getPosY();
				double z = entity.getPosZ();
				World world = entity.world;

				LunarianSwordLivingEntityIsHitWithToolProcedure.executeProcedure(
						Stream.of(new AbstractMap.SimpleEntry<>("entity", entity), new AbstractMap.SimpleEntry<>("sourceentity", sourceentity))
								.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				return retval;
			}

			@Override
			public void inventoryTick(ItemStack itemstack, World world, Entity entity, int slot, boolean selected) {
				super.inventoryTick(itemstack, world, entity, slot, selected);
				double x = entity.getPosX();
				double y = entity.getPosY();
				double z = entity.getPosZ();
				if (selected)

					LunarianSwordToolInHandTickProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity))
							.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			}
		}.setRegistryName("lunarian_sword"));
	}
}
