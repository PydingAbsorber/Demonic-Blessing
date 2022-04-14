
package net.mcreator.demonicblessing.gui;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.World;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.client.gui.widget.button.Button;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.client.Minecraft;

import net.mcreator.demonicblessing.DemonicblessingModVariables;
import net.mcreator.demonicblessing.DemonicblessingMod;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.matrix.MatrixStack;

@OnlyIn(Dist.CLIENT)
public class GemSocketsGuiWindow extends ContainerScreen<GemSocketsGui.GuiContainerMod> {
	private World world;
	private int x, y, z;
	private PlayerEntity entity;
	private final static HashMap guistate = GemSocketsGui.guistate;

	public GemSocketsGuiWindow(GemSocketsGui.GuiContainerMod container, PlayerInventory inventory, ITextComponent text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.xSize = 176;
		this.ySize = 166;
	}

	private static final ResourceLocation texture = new ResourceLocation("demonicblessing:textures/gem_sockets.png");

	@Override
	public void render(MatrixStack ms, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(ms);
		super.render(ms, mouseX, mouseY, partialTicks);
		this.renderHoveredTooltip(ms, mouseX, mouseY);
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(MatrixStack ms, float partialTicks, int gx, int gy) {
		RenderSystem.color4f(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		Minecraft.getInstance().getTextureManager().bindTexture(texture);
		int k = (this.width - this.xSize) / 2;
		int l = (this.height - this.ySize) / 2;
		this.blit(ms, k, l, 0, 0, this.xSize, this.ySize, this.xSize, this.ySize);
		RenderSystem.disableBlend();
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeScreen();
			return true;
		}
		return super.keyPressed(key, b, c);
	}

	@Override
	public void tick() {
		super.tick();
	}

	@Override
	protected void drawGuiContainerForegroundLayer(MatrixStack ms, int mouseX, int mouseY) {
		this.font.drawString(ms, "" + ((entity.getCapability(DemonicblessingModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new DemonicblessingModVariables.PlayerVariables())).critdamage) + "", -11, -38, -10092289);
		this.font.drawString(ms, "" + ((entity.getCapability(DemonicblessingModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new DemonicblessingModVariables.PlayerVariables())).critchance) + "", -11, -20, -13382401);
		this.font.drawString(ms, "Crit Damage", -74, -38, -10092289);
		this.font.drawString(ms, "Crit Chance", -74, -20, -13382401);
		this.font.drawString(ms, "Quellement:", 132, -38, -10092493);
		this.font.drawString(ms, "Hp regen", 132, -20, -16724941);
		this.font.drawString(ms, "" + ((entity.getCapability(DemonicblessingModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new DemonicblessingModVariables.PlayerVariables())).maxhp) + "", 195, -38, -10092493);
		this.font.drawString(ms, "" + ((entity.getCapability(DemonicblessingModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new DemonicblessingModVariables.PlayerVariables())).hpregen) + "", 186, -20, -16724941);
		this.font.drawString(ms, "Power Rank:", 60, 25, -16777216);
		this.font.drawString(ms, "" + (int) ((entity.getCapability(DemonicblessingModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new DemonicblessingModVariables.PlayerVariables())).powerrank) + "", 60, 34, -16777216);
		this.font.drawString(ms, "1280 Max", 60, 43, -12829636);
	}

	@Override
	public void onClose() {
		super.onClose();
		Minecraft.getInstance().keyboardListener.enableRepeatEvents(false);
	}

	@Override
	public void init(Minecraft minecraft, int width, int height) {
		super.init(minecraft, width, height);
		minecraft.keyboardListener.enableRepeatEvents(true);
		this.addButton(new Button(this.guiLeft + 58, this.guiTop + 59, 56, 20, new StringTextComponent("Refresh"), e -> {
			if (true) {
				DemonicblessingMod.PACKET_HANDLER.sendToServer(new GemSocketsGui.ButtonPressedMessage(0, x, y, z));
				GemSocketsGui.handleButtonAction(entity, 0, x, y, z);
			}
		}));
	}
}
