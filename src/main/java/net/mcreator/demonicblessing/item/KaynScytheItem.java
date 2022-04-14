
package net.mcreator.demonicblessing.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.world.World;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.Hand;
import net.minecraft.util.ActionResult;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;
import net.minecraft.client.util.ITooltipFlag;

import net.mcreator.demonicblessing.procedures.KaynScytheToolInHandTickProcedure;
import net.mcreator.demonicblessing.procedures.KaynScytheRightClickedInAirProcedure;
import net.mcreator.demonicblessing.procedures.KaynScytheOnPlayerStoppedUsingProcedure;
import net.mcreator.demonicblessing.procedures.KaynScytheLivingEntityIsHitWithToolProcedure;
import net.mcreator.demonicblessing.procedures.KaynScytheItemIsCraftedsmeltedProcedure;
import net.mcreator.demonicblessing.itemgroup.DemonicBlessingItemGroup;
import net.mcreator.demonicblessing.DemonicblessingModElements;

import java.util.stream.Stream;
import java.util.Map;
import java.util.List;
import java.util.HashMap;
import java.util.AbstractMap;

@DemonicblessingModElements.ModElement.Tag
public class KaynScytheItem extends DemonicblessingModElements.ModElement {
	@ObjectHolder("demonicblessing:kayn_scythe")
	public static final Item block = null;

	public KaynScytheItem(DemonicblessingModElements instance) {
		super(instance, 12);
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
				return 396f;
			}

			public int getHarvestLevel() {
				return 1;
			}

			public int getEnchantability() {
				return 22;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.EMPTY;
			}
		}, 3, -1f, new Item.Properties().group(DemonicBlessingItemGroup.tab).isImmuneToFire()) {
			@Override
			public void addInformation(ItemStack itemstack, World world, List<ITextComponent> list, ITooltipFlag flag) {
				super.addInformation(itemstack, world, list, flag);
				list.add(new StringTextComponent(
						"\u00A79\u0414\u0430\u0440\u043A\u0438\u043D\u0430 \u0431\u043E\u043B\u044C\u0448\u0435 \u043D\u0435\u0442. \u041D\u0430 \u043E\u0447\u0435\u0440\u0435\u0434\u0438 \u043D\u0430\u0448\u0438 \u0432\u0440\u0430\u0433\u0438."));
			}

			@Override
			public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity entity, Hand hand) {
				ActionResult<ItemStack> retval = super.onItemRightClick(world, entity, hand);
				ItemStack itemstack = retval.getResult();
				double x = entity.getPosX();
				double y = entity.getPosY();
				double z = entity.getPosZ();

				KaynScytheRightClickedInAirProcedure.executeProcedure(Stream
						.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("x", x),
								new AbstractMap.SimpleEntry<>("y", y), new AbstractMap.SimpleEntry<>("z", z),
								new AbstractMap.SimpleEntry<>("entity", entity), new AbstractMap.SimpleEntry<>("itemstack", itemstack))
						.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				return retval;
			}

			@Override
			public void onCreated(ItemStack itemstack, World world, PlayerEntity entity) {
				super.onCreated(itemstack, world, entity);
				double x = entity.getPosX();
				double y = entity.getPosY();
				double z = entity.getPosZ();

				KaynScytheItemIsCraftedsmeltedProcedure.executeProcedure(Stream
						.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("x", x),
								new AbstractMap.SimpleEntry<>("y", y), new AbstractMap.SimpleEntry<>("z", z))
						.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			}

			@Override
			public boolean hitEntity(ItemStack itemstack, LivingEntity entity, LivingEntity sourceentity) {
				boolean retval = super.hitEntity(itemstack, entity, sourceentity);
				double x = entity.getPosX();
				double y = entity.getPosY();
				double z = entity.getPosZ();
				World world = entity.world;

				KaynScytheLivingEntityIsHitWithToolProcedure.executeProcedure(Stream
						.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("x", x),
								new AbstractMap.SimpleEntry<>("y", y), new AbstractMap.SimpleEntry<>("z", z),
								new AbstractMap.SimpleEntry<>("entity", entity), new AbstractMap.SimpleEntry<>("sourceentity", sourceentity))
						.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				return retval;
			}

			@Override
			public void onPlayerStoppedUsing(ItemStack itemstack, World world, LivingEntity entity, int time) {
				super.onPlayerStoppedUsing(itemstack, world, entity, time);
				double x = entity.getPosX();
				double y = entity.getPosY();
				double z = entity.getPosZ();

				KaynScytheOnPlayerStoppedUsingProcedure.executeProcedure(Stream
						.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("x", x),
								new AbstractMap.SimpleEntry<>("y", y), new AbstractMap.SimpleEntry<>("z", z),
								new AbstractMap.SimpleEntry<>("entity", entity))
						.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			}

			@Override
			public void inventoryTick(ItemStack itemstack, World world, Entity entity, int slot, boolean selected) {
				super.inventoryTick(itemstack, world, entity, slot, selected);
				double x = entity.getPosX();
				double y = entity.getPosY();
				double z = entity.getPosZ();
				if (selected)

					KaynScytheToolInHandTickProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity))
							.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			}
		}.setRegistryName("kayn_scythe"));
	}
}
