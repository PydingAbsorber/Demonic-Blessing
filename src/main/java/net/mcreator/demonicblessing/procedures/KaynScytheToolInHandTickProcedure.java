package net.mcreator.demonicblessing.procedures;

import net.minecraft.scoreboard.Scoreboard;
import net.minecraft.scoreboard.ScoreObjective;
import net.minecraft.scoreboard.Score;
import net.minecraft.potion.Effects;
import net.minecraft.potion.EffectInstance;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.demonicblessing.item.KaynScytheItem;
import net.mcreator.demonicblessing.DemonicblessingMod;

import java.util.Map;

public class KaynScytheToolInHandTickProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				DemonicblessingMod.LOGGER.warn("Failed to load dependency entity for procedure KaynScytheToolInHandTick!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY).getItem() == KaynScytheItem.block) {
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.STRENGTH, (int) 42, (int) 5));
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.SPEED, (int) 41, (int) 3));
			if (new Object() {
				public int getScore(String score) {
					if (entity instanceof PlayerEntity) {
						Scoreboard _sc = ((PlayerEntity) entity).getWorldScoreboard();
						ScoreObjective _so = _sc.getObjective(score);
						if (_so != null) {
							Score _scr = _sc.getOrCreateScore(((PlayerEntity) entity).getScoreboardName(), _so);
							return _scr.getScorePoints();
						}
					}
					return 0;
				}
			}.getScore("night") == 1) {
				if (entity instanceof LivingEntity)
					((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.INVISIBILITY, (int) 40, (int) 3));
			}
		}
	}
}
