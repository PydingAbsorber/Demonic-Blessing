
package net.mcreator.demonicblessing.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.world.World;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.Direction;
import net.minecraft.util.ActionResultType;
import net.minecraft.item.Rarity;
import net.minecraft.item.ItemUseContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.block.BlockState;

import net.mcreator.demonicblessing.procedures.SecretBossSpawnRightClickedOnBlockProcedure;
import net.mcreator.demonicblessing.itemgroup.DemonicBlessingItemGroup;
import net.mcreator.demonicblessing.DemonicblessingModElements;

import java.util.stream.Stream;
import java.util.Map;
import java.util.List;
import java.util.HashMap;
import java.util.AbstractMap;

@DemonicblessingModElements.ModElement.Tag
public class SecretBossSpawnItem extends DemonicblessingModElements.ModElement {
	@ObjectHolder("demonicblessing:secret_boss_spawn")
	public static final Item block = null;

	public SecretBossSpawnItem(DemonicblessingModElements instance) {
		super(instance, 104);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}

	public static class ItemCustom extends Item {
		public ItemCustom() {
			super(new Item.Properties().group(DemonicBlessingItemGroup.tab).maxStackSize(64).rarity(Rarity.EPIC));
			setRegistryName("secret_boss_spawn");
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
					"1000-7 993-7 986-7 979-7 972-7 965-7 958-7 951-7 944-7 937-7 930-7 923-7 916-7 909-7 902-7 895-7 888-7 881-7 874-7 867-7 860-7 853-7 846-7 839-7 832-7 825-7 818-7 811-7 804-7 797-7 790-7 783-7 776-7 769-7 762-7 755-7 748-7 741-7 734-7 727-7 720-7 713-7 706-7 699-7 692-7 685-7 678-7 671-7 664-7 657-7 650-7 643-7 636-7 629-7 622-7 615-7 608-7 601-7 594-7 587-7 580-7 573-7 566-7 559-7 552-7 545-7 538-7 531-7 524-7 517-7 510-7 503-7 496-7 489-7 482-7 475-7 468-7 461-7 454-7 447-7 440-7 433-7 426-7 419-7 412-7 405-7 398-7 391-7 384-7 377-7 370-7 363-7 356-7 349-7 342-7 335-7 328-7 321-7 314-7 307-7 300-7 293-7 286-7 279-7 272-7 265-7 258-7 251-7 244-7 237-7 230-7 223-7 216-7 209-7 202-7 195-7 188-7 181-7 174-7 167-7 160-7 153-7 146-7 139-7 132-7 125-7 118-7 111-7 104-7 97-7 90-7 83-7 76-7 69-7 62-7 55-7 48-7 41-7 34-7 27-7 20-7 13-7 6"));
		}

		@Override
		public ActionResultType onItemUseFirst(ItemStack stack, ItemUseContext context) {
			ActionResultType retval = super.onItemUseFirst(stack, context);
			World world = context.getWorld();
			BlockPos pos = context.getPos();
			PlayerEntity entity = context.getPlayer();
			Direction direction = context.getFace();
			BlockState blockstate = world.getBlockState(pos);
			int x = pos.getX();
			int y = pos.getY();
			int z = pos.getZ();
			ItemStack itemstack = context.getItem();

			SecretBossSpawnRightClickedOnBlockProcedure.executeProcedure(Stream
					.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("x", x), new AbstractMap.SimpleEntry<>("y", y),
							new AbstractMap.SimpleEntry<>("z", z), new AbstractMap.SimpleEntry<>("entity", entity))
					.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			return retval;
		}
	}
}
