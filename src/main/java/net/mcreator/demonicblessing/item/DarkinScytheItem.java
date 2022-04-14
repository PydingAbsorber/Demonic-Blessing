
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

import net.mcreator.demonicblessing.procedures.DarkinScytheToolInHandTickProcedure;
import net.mcreator.demonicblessing.procedures.DarkinScytheRightClickedInAirProcedure;
import net.mcreator.demonicblessing.procedures.DarkinScytheOnPlayerStoppedUsingProcedure;
import net.mcreator.demonicblessing.procedures.DarkinScytheLivingEntityIsHitWithToolProcedure;
import net.mcreator.demonicblessing.procedures.DarkinScytheItemIsCraftedsmeltedProcedure;
import net.mcreator.demonicblessing.itemgroup.DemonicBlessingItemGroup;
import net.mcreator.demonicblessing.DemonicblessingModElements;

import java.util.stream.Stream;
import java.util.Map;
import java.util.List;
import java.util.HashMap;
import java.util.AbstractMap;

@DemonicblessingModElements.ModElement.Tag
public class DarkinScytheItem extends DemonicblessingModElements.ModElement {
	@ObjectHolder("demonicblessing:darkin_scythe")
	public static final Item block = null;

	public DarkinScytheItem(DemonicblessingModElements instance) {
		super(instance, 7);
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
		}, 3, -2f, new Item.Properties().group(DemonicBlessingItemGroup.tab).isImmuneToFire()) {
			@Override
			public void addInformation(ItemStack itemstack, World world, List<ITextComponent> list, ITooltipFlag flag) {
				super.addInformation(itemstack, world, list, flag);
				list.add(new StringTextComponent(
						"\u00A7c\u041A\u0430\u0438\u043D \u043D\u0435 \u0446\u0435\u043D\u0438\u043B \u0441\u0432\u043E\u0435\u0439 \u043F\u043B\u043E\u0442\u0438. \u0420\u0430\u0430\u0441\u0442 \u043D\u0435 \u0442\u0430\u043A\u043E\u0439 \u0433\u043B\u0443\u043F\u0435\u0446!"));
			}

			@Override
			public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity entity, Hand hand) {
				ActionResult<ItemStack> retval = super.onItemRightClick(world, entity, hand);
				ItemStack itemstack = retval.getResult();
				double x = entity.getPosX();
				double y = entity.getPosY();
				double z = entity.getPosZ();

				DarkinScytheRightClickedInAirProcedure.executeProcedure(Stream
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

				DarkinScytheItemIsCraftedsmeltedProcedure.executeProcedure(Stream
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

				DarkinScytheLivingEntityIsHitWithToolProcedure.executeProcedure(Stream
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

				DarkinScytheOnPlayerStoppedUsingProcedure.executeProcedure(Stream
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

					DarkinScytheToolInHandTickProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity))
							.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			}
		}.setRegistryName("darkin_scythe"));
	}
}
