package net.mcreator.demonicblessing.procedures;

import net.minecraft.util.text.StringTextComponent;
import net.minecraft.item.ItemStack;

import net.mcreator.demonicblessing.DemonicblessingMod;

import java.util.Map;

public class BigGemCraftedProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("itemstack") == null) {
			if (!dependencies.containsKey("itemstack"))
				DemonicblessingMod.LOGGER.warn("Failed to load dependency itemstack for procedure BigGemCrafted!");
			return;
		}
		ItemStack itemstack = (ItemStack) dependencies.get("itemstack");
		if (Math.random() < 0.5) {
			if (Math.random() < 0.5) {
				itemstack.getOrCreateTag().putDouble("critdamage", (80 * Math.random()));
				itemstack.getOrCreateTag().putDouble("maxhp", (94 * Math.random()));
			} else {
				if (Math.random() < 0.5) {
					itemstack.getOrCreateTag().putDouble("critchance", (17.6 * Math.random()));
					itemstack.getOrCreateTag().putDouble("maxhp", (94 * Math.random()));
				} else {
					itemstack.getOrCreateTag().putDouble("hpregen", (0.022 * Math.random()));
					itemstack.getOrCreateTag().putDouble("maxhp", (94 * Math.random()));
				}
			}
		} else {
			if (Math.random() < 0.25) {
				itemstack.getOrCreateTag().putDouble("critdamage", (80 * Math.random()));
				itemstack.getOrCreateTag().putDouble("critchance", (17.6 * Math.random()));
			} else {
				if (Math.random() < 0.5) {
					itemstack.getOrCreateTag().putDouble("critdamage", (80 * Math.random()));
					itemstack.getOrCreateTag().putDouble("hpregen", (0.022 * Math.random()));
				} else {
					itemstack.getOrCreateTag().putDouble("hpregen", (0.022 * Math.random()));
					itemstack.getOrCreateTag().putDouble("critchance", (17.6 * Math.random()));
				}
			}
		}
		itemstack.getOrCreateTag().putDouble("powerrank",
				(itemstack.getOrCreateTag().getDouble("hpregen") * 3636 + itemstack.getOrCreateTag().getDouble("maxhp") * 0.851
						+ itemstack.getOrCreateTag().getDouble("critdamage") * 1 + itemstack.getOrCreateTag().getDouble("critchance") * 4.4));
		if (itemstack.getOrCreateTag().getDouble("critdamage") > 0 && itemstack.getOrCreateTag().getDouble("critchance") > 0) {
			(itemstack).setDisplayName(
					new StringTextComponent(("Gem" + "\u00A7bCritDamage:" + Math.round(itemstack.getOrCreateTag().getDouble("critdamage"))
							+ "\u00A7bCritChance:" + Math.round(itemstack.getOrCreateTag().getDouble("critchance")) + "\u00A7ePowerRank:"
							+ Math.round(itemstack.getOrCreateTag().getDouble("powerrank")))));
		}
		if (itemstack.getOrCreateTag().getDouble("critdamage") > 0 && itemstack.getOrCreateTag().getDouble("maxhp") > 0) {
			(itemstack).setDisplayName(
					new StringTextComponent(("Gem" + "\u00A7bCritDamage:" + Math.round(itemstack.getOrCreateTag().getDouble("critdamage"))
							+ "\u00A75Quellement:" + Math.round(itemstack.getOrCreateTag().getDouble("maxhp")) + "\u00A7ePowerRank:"
							+ Math.round(itemstack.getOrCreateTag().getDouble("powerrank")))));
		}
		if (itemstack.getOrCreateTag().getDouble("critdamage") > 0 && itemstack.getOrCreateTag().getDouble("hpregen") > 0) {
			(itemstack).setDisplayName(
					new StringTextComponent(("Gem" + "\u00A7bCritDamage:" + Math.round(itemstack.getOrCreateTag().getDouble("critdamage"))
							+ "\u00A74HpRegen:" + Math.round(itemstack.getOrCreateTag().getDouble("hpregen")) + "\u00A7ePowerRank:"
							+ Math.round(itemstack.getOrCreateTag().getDouble("powerrank")))));
		}
		if (itemstack.getOrCreateTag().getDouble("critchance") > 0 && itemstack.getOrCreateTag().getDouble("maxhp") > 0) {
			(itemstack).setDisplayName(
					new StringTextComponent(("Gem" + "\u00A7bCritChance:" + Math.round(itemstack.getOrCreateTag().getDouble("critchance"))
							+ "\u00A75Quellement:" + Math.round(itemstack.getOrCreateTag().getDouble("maxhp")) + "\u00A7ePowerRank:"
							+ Math.round(itemstack.getOrCreateTag().getDouble("powerrank")))));
		}
		if (itemstack.getOrCreateTag().getDouble("critchance") > 0 && itemstack.getOrCreateTag().getDouble("hpregen") > 0) {
			(itemstack).setDisplayName(
					new StringTextComponent(("Gem" + "\u00A7bCritChance:" + Math.round(itemstack.getOrCreateTag().getDouble("critchance"))
							+ "\u00A74HpRegen:" + Math.round(itemstack.getOrCreateTag().getDouble("hpregen")) + "\u00A7ePowerRank:"
							+ Math.round(itemstack.getOrCreateTag().getDouble("powerrank")))));
		}
		if (itemstack.getOrCreateTag().getDouble("critdamage") > 0 && itemstack.getOrCreateTag().getDouble("hpregen") > 0) {
			(itemstack).setDisplayName(
					new StringTextComponent(("Gem" + "\u00A7bCritDamage:" + Math.round(itemstack.getOrCreateTag().getDouble("critdamage"))
							+ "\u00A74HpRegen:" + Math.round(itemstack.getOrCreateTag().getDouble("hpregen")) + "\u00A7ePowerRank:"
							+ Math.round(itemstack.getOrCreateTag().getDouble("powerrank")))));
		}
		if (itemstack.getOrCreateTag().getDouble("maxhp") > 0 && itemstack.getOrCreateTag().getDouble("hpregen") > 0) {
			(itemstack)
					.setDisplayName(new StringTextComponent(("Gem" + "\u00A75Quellement:" + Math.round(itemstack.getOrCreateTag().getDouble("maxhp"))
							+ "\u00A74HpRegen:" + Math.round(itemstack.getOrCreateTag().getDouble("hpregen")) + "\u00A7ePowerRank:"
							+ Math.round(itemstack.getOrCreateTag().getDouble("powerrank")))));
		}
		if (itemstack.getOrCreateTag().getDouble("maxhp") > 0 && itemstack.getOrCreateTag().getDouble("critdamage") > 0) {
			(itemstack)
					.setDisplayName(new StringTextComponent(("Gem" + "\u00A75Quellement:" + Math.round(itemstack.getOrCreateTag().getDouble("maxhp"))
							+ "\u00A7bCritDamage:" + Math.round(itemstack.getOrCreateTag().getDouble("critdamage")) + "\u00A7ePowerRank:"
							+ Math.round(itemstack.getOrCreateTag().getDouble("powerrank")))));
		}
		if (itemstack.getOrCreateTag().getDouble("maxhp") > 0 && itemstack.getOrCreateTag().getDouble("\u00A7bCritChance:") > 0) {
			(itemstack)
					.setDisplayName(new StringTextComponent(("Gem" + "\u00A75Quellement:" + Math.round(itemstack.getOrCreateTag().getDouble("maxhp"))
							+ "\u00A7bCritChance:" + Math.round(itemstack.getOrCreateTag().getDouble("critchance")) + "\u00A7ePowerRank:"
							+ Math.round(itemstack.getOrCreateTag().getDouble("powerrank")))));
		}
	}
}
