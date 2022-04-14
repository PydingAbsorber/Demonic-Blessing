
package net.mcreator.demonicblessing.item;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.registries.ForgeRegistries;
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
public class FrostMourneItem extends DemonicblessingModElements.ModElement {
	@ObjectHolder("demonicblessing:frost_mourne")
	public static final Item block = null;
	public FrostMourneItem(DemonicblessingModElements instance) {
		super(instance, 131);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}
	public static class ItemCustom extends Item {
		public ItemCustom() {
			super(new Item.Properties().group(DemonicBlessingItemGroup.tab).maxStackSize(1).isImmuneToFire().rarity(Rarity.EPIC));
			setRegistryName("frost_mourne");
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
		@OnlyIn(Dist.CLIENT)
		public void onCreated(ItemStack stack, World worldIn, PlayerEntity playerIn) {
			super.onCreated(stack, worldIn, playerIn);
			playerIn.playSound((net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("demonicblessing:involaugh")), 5.0F, 0.8F);
			stack.getOrCreateTag().putInt("souls", 1);
		}

		@Override
		@OnlyIn(Dist.CLIENT)
		public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
			super.addInformation(stack, worldIn, tooltip, flagIn);
			if (Screen.hasControlDown()) {
				if (stack.getTag() != null) {
					int soulscap = stack.getTag().getInt("souls");
					tooltip.add(new StringTextComponent("§4\u0414\u0443\u0448 §4\u043f\u043e\u0433\u043b\u043e\u0449\u0435\u043d\u043e:§4§l " + soulscap));
					int result = soulscap += 10;
					tooltip.add(new StringTextComponent("§5+" + result + " \u043a\u043c\u0430\u0433\u0438\u0447\u0435\u0441\u043a\u043e\u043c\u0443 \u0443\u0440\u043e\u043d\u0443"));
				} else {
					tooltip.add(new StringTextComponent("§5+10 \u043a\u043c\u0430\u0433\u0438\u0447\u0435\u0441\u043a\u043e\u043c\u0443 \u0443\u0440\u043e\u043d\u0443"));
				}
				tooltip.add(new StringTextComponent(""));
				tooltip.add(new StringTextComponent("§3\u0423 \u043c\u0435\u043d\u044f \u043f\u043e\u043b\u0443\u0447\u0438\u043b\u043e\u0441\u044c! \u042f \u0441\u043e\u0437\u0434\u0430\u043b \u0441\u0432\u043e\u044e \u041b\u0435\u0434\u044f\u043d\u0443\u044e \u0421\u043a\u043e\u0440\u0431\u044c, \u043d\u043e \u043f\u043e \u043b\u0435\u0433\u0435\u043d\u0434\u0430\u043c \u043c\u0435\u0447 \u0437\u0430\u0431\u0438\u0440\u0430\u0435\u0442 \u0434\u0443\u0448\u0443 \u043d\u043e\u0441\u0438\u0442\u0435\u043b\u044f \u0438 \u043f\u0430\u0432\u0448\u0438\u0445 \u043e\u0442 \u043d\u0435\u0433\u043e \u0438 \u0441\u0432\u043e\u0434\u0438\u0442 \u0441 \u0443\u043c\u0430 \u043d\u043e\u0441\u0438\u0442\u0435\u043b\u044f, \u0447\u0443\u0448\u044c \u043a\u0430\u043a\u0430\u044f-\u0442\u043e."));
			} else if (Screen.hasShiftDown()) {
				if (stack.getTag() != null) {
					int soulscap = stack.getTag().getInt("souls");
					tooltip.add(new StringTextComponent("§4\u0414\u0443\u0448 §4\u043f\u043e\u0433\u043b\u043e\u0449\u0435\u043d\u043e:§4§l " + soulscap));
					int result = soulscap += 10;
					tooltip.add(new StringTextComponent("§5+" + result + " \u043a\u043c\u0430\u0433\u0438\u0447\u0435\u0441\u043a\u043e\u043c\u0443 \u0443\u0440\u043e\u043d\u0443"));
				} else {
					tooltip.add(new StringTextComponent("§510 \u043a\u043c\u0430\u0433\u0438\u0447\u0435\u0441\u043a\u043e\u043c\u0443 \u0443\u0440\u043e\u043d\u0443"));
				}
				tooltip.add(new StringTextComponent(""));
				tooltip.add(new StringTextComponent("§3\u0421 \u043a\u0430\u0436\u0434\u044b\u043c \u0443\u0431\u0438\u0442\u044b\u043c \u043c\u043e\u0431\u043e\u043c \u043f\u043e\u0433\u043b\u0430\u0449\u044f\u0435\u0442 \u0435\u0433\u043e \u0434\u0443\u0448\u0443 \u0438 \u0434\u043e\u0431\u0430\u0432\u043b\u044f\u0435\u0442 \u043e\u0434\u0438\u043d §5\u043c\u0430\u0433\u0438\u0447\u0435\u0441\u043a\u0438\u0439 \u0443\u0440\u043e\u043d§r§3 \u043c\u0435\u0447\u0443"));
			} else {
				if (stack.getTag() != null) {
					int soulscap = stack.getTag().getInt("souls");
					tooltip.add(new StringTextComponent("§4\u0414\u0443\u0448 §4\u043f\u043e\u0433\u043b\u043e\u0449\u0435\u043d\u043e:§4§l " + soulscap));
					int result = soulscap += 10;
					tooltip.add(new StringTextComponent("§5+" + result + " \u043a\u043c\u0430\u0433\u0438\u0447\u0435\u0441\u043a\u043e\u043c\u0443 \u0443\u0440\u043e\u043d\u0443"));
				} else {
					tooltip.add(new StringTextComponent("§510 \u043a\u043c\u0430\u0433\u0438\u0447\u0435\u0441\u043a\u043e\u043c\u0443 \u0443\u0440\u043e\u043d\u0443"));
				}
				tooltip.add(new StringTextComponent("§b\u041d\u0430\u0436\u043c\u0438\u0442\u0435 SHIFT \u0434\u043b\u044f \u0434\u043e\u043f\u043e\u043b\u043d\u0438\u0442\u0435\u043b\u044c\u043d\u043e\u0439 \u0438\u043d\u0444\u043e\u0440\u043c\u0430\u0446\u0438\u0438"));
				tooltip.add(new StringTextComponent("§b\u041d\u0430\u0436\u043c\u0438\u0442\u0435 CTRL \u0434\u043b\u044f \u043f\u0440\u043e\u0447\u0442\u0435\u043d\u0438\u044f \u043b\u043e\u0440\u0430"));
			}
		}

		@Override
		public boolean onLeftClickEntity(ItemStack stack, PlayerEntity player, Entity entity) {
			if (stack.getTag() != null) {
				int souls = stack.getTag().getInt("souls");
				if (souls == 10000) {
					entity.attackEntityFrom(DamageSource.causePlayerDamage(player).setDamageIsAbsolute(), (float) 1500.0);
					entity.attackEntityFrom(DamageSource.causePlayerDamage(player).setMagicDamage(), (float) 1500.0);;
				} else {
					entity.attackEntityFrom(DamageSource.causePlayerDamage(player).setMagicDamage(), 10 + souls);
				}
			} else {
				entity.attackEntityFrom(DamageSource.causePlayerDamage(player).setMagicDamage(), 10);
			}
			return true;
		}
	}
}
