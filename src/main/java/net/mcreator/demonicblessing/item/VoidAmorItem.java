
package net.mcreator.demonicblessing.item;

import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.World;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.ResourceLocation;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.ArmorItem;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.entity.Entity;
import net.minecraft.client.util.ITooltipFlag;

import net.mcreator.demonicblessing.itemgroup.DemonicBlessingItemGroup;
import net.mcreator.demonicblessing.DemonicblessingModElements;

import java.util.List;

@DemonicblessingModElements.ModElement.Tag
public class VoidAmorItem extends DemonicblessingModElements.ModElement {
	@ObjectHolder("demonicblessing:void_amor_helmet")
	public static final Item helmet = null;
	@ObjectHolder("demonicblessing:void_amor_chestplate")
	public static final Item body = null;
	@ObjectHolder("demonicblessing:void_amor_leggings")
	public static final Item legs = null;
	@ObjectHolder("demonicblessing:void_amor_boots")
	public static final Item boots = null;

	public VoidAmorItem(DemonicblessingModElements instance) {
		super(instance, 183);
	}

	@Override
	public void initElements() {
		IArmorMaterial armormaterial = new IArmorMaterial() {
			@Override
			public int getDurability(EquipmentSlotType slot) {
				return new int[]{13, 15, 16, 11}[slot.getIndex()] * 0;
			}

			@Override
			public int getDamageReductionAmount(EquipmentSlotType slot) {
				return new int[]{5, 5, 5, 5}[slot.getIndex()];
			}

			@Override
			public int getEnchantability() {
				return 0;
			}

			@Override
			public net.minecraft.util.SoundEvent getSoundEvent() {
				return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation(""));
			}

			@Override
			public Ingredient getRepairMaterial() {
				return Ingredient.EMPTY;
			}

			@OnlyIn(Dist.CLIENT)
			@Override
			public String getName() {
				return "void_amor";
			}

			@Override
			public float getToughness() {
				return 0f;
			}

			@Override
			public float getKnockbackResistance() {
				return 2f;
			}
		};
		elements.items.add(() -> new ArmorItem(armormaterial, EquipmentSlotType.HEAD,
				new Item.Properties().group(DemonicBlessingItemGroup.tab).isImmuneToFire()) {
			@Override
			public void addInformation(ItemStack itemstack, World world, List<ITextComponent> list, ITooltipFlag flag) {
				super.addInformation(itemstack, world, list, flag);
				list.add(new StringTextComponent("\u00A7d\u00A7khelmet"));
			}

			@Override
			public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type) {
				return "demonicblessing:textures/models/armor/void_layer_" + (slot == EquipmentSlotType.LEGS ? "2" : "1") + ".png";
			}
		}.setRegistryName("void_amor_helmet"));
		elements.items.add(() -> new ArmorItem(armormaterial, EquipmentSlotType.CHEST,
				new Item.Properties().group(DemonicBlessingItemGroup.tab).isImmuneToFire()) {
			@Override
			public void addInformation(ItemStack itemstack, World world, List<ITextComponent> list, ITooltipFlag flag) {
				super.addInformation(itemstack, world, list, flag);
				list.add(new StringTextComponent(
						"\u00A7d\u0445\u0430\u0442\u044F \u043A\u0440\u0443\u0447\u0435 \u0432\u043E\u043B\u043A\u0430 \u0430\u043B\u044C\u0444\u0430 \u043E\u0431\u0440\u043E\u0442\u0435\u043D\u044C \u0432\u0430\u043C\u043F\u0438\u0440 \u0438 \u043F\u043E\u0447\u0442\u0438 \u0431\u0435\u0441\u043C\u0435\u0440\u0442\u043D\u044B\u0439 \u0442\u043E \u0442\u043E\u0433\u0434\u0430 \u0442\u044B \u043A\u0440\u0443\u0442)"));
			}

			@Override
			public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type) {
				return "demonicblessing:textures/models/armor/void_layer_" + (slot == EquipmentSlotType.LEGS ? "2" : "1") + ".png";
			}
		}.setRegistryName("void_amor_chestplate"));
		elements.items.add(() -> new ArmorItem(armormaterial, EquipmentSlotType.LEGS,
				new Item.Properties().group(DemonicBlessingItemGroup.tab).isImmuneToFire()) {
			@Override
			public void addInformation(ItemStack itemstack, World world, List<ITextComponent> list, ITooltipFlag flag) {
				super.addInformation(itemstack, world, list, flag);
				list.add(new StringTextComponent("\u00A7d\u00A7kleggings"));
			}

			@Override
			public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type) {
				return "demonicblessing:textures/models/armor/void_layer_" + (slot == EquipmentSlotType.LEGS ? "2" : "1") + ".png";
			}
		}.setRegistryName("void_amor_leggings"));
		elements.items.add(() -> new ArmorItem(armormaterial, EquipmentSlotType.FEET,
				new Item.Properties().group(DemonicBlessingItemGroup.tab).isImmuneToFire()) {
			@Override
			public void addInformation(ItemStack itemstack, World world, List<ITextComponent> list, ITooltipFlag flag) {
				super.addInformation(itemstack, world, list, flag);
				list.add(new StringTextComponent("\u00A7d\u00A7kboots"));
			}

			@Override
			public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type) {
				return "demonicblessing:textures/models/armor/void_layer_" + (slot == EquipmentSlotType.LEGS ? "2" : "1") + ".png";
			}
		}.setRegistryName("void_amor_boots"));
	}

}
