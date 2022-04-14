package net.mcreator.demonicblessing.procedures;

import net.minecraft.util.text.StringTextComponent;
import net.minecraft.scoreboard.Scoreboard;
import net.minecraft.scoreboard.ScoreObjective;
import net.minecraft.scoreboard.ScoreCriteria;
import net.minecraft.scoreboard.Score;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import net.mcreator.demonicblessing.DemonicblessingMod;

import java.util.Map;

public class SsOnKeyPressedProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				DemonicblessingMod.LOGGER.warn("Failed to load dependency entity for procedure SsOnKeyPressed!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		{
			Entity _ent = entity;
			if (_ent instanceof PlayerEntity) {
				Scoreboard _sc = ((PlayerEntity) _ent).getWorldScoreboard();
				ScoreObjective _so = _sc.getObjective("ss");
				if (_so == null) {
					_so = _sc.addObjective("ss", ScoreCriteria.DUMMY, new StringTextComponent("ss"), ScoreCriteria.RenderType.INTEGER);
				}
				Score _scr = _sc.getOrCreateScore(((PlayerEntity) _ent).getScoreboardName(), _so);
				_scr.setScorePoints((int) (new Object() {
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
				}.getScore("ss") + 1));
			}
		}
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
		}.getScore("ss") >= 4) {
			{
				Entity _ent = entity;
				if (_ent instanceof PlayerEntity) {
					Scoreboard _sc = ((PlayerEntity) _ent).getWorldScoreboard();
					ScoreObjective _so = _sc.getObjective("ss");
					if (_so == null) {
						_so = _sc.addObjective("ss", ScoreCriteria.DUMMY, new StringTextComponent("ss"), ScoreCriteria.RenderType.INTEGER);
					}
					Score _scr = _sc.getOrCreateScore(((PlayerEntity) _ent).getScoreboardName(), _so);
					_scr.setScorePoints((int) 0);
				}
			}
		}
	}
}
