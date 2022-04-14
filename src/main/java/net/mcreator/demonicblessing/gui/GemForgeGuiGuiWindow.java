
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

import net.mcreator.demonicblessing.DemonicblessingMod;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.matrix.MatrixStack;

@OnlyIn(Dist.CLIENT)
public class GemForgeGuiGuiWindow extends ContainerScreen<GemForgeGuiGui.GuiContainerMod> {
	private World world;
	private int x, y, z;
	private PlayerEntity entity;
	private final static HashMap guistate = GemForgeGuiGui.guistate;

	public GemForgeGuiGuiWindow(GemForgeGuiGui.GuiContainerMod container, PlayerInventory inventory, ITextComponent text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.xSize = 260;
		this.ySize = 167;
	}

	private static final ResourceLocation texture = new ResourceLocation("demonicblessing:textures/gem_forge_gui.png");

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

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("demonicblessing:textures/screenshot_105.png"));
		this.blit(ms, this.guiLeft + -104, this.guiTop + -82, 0, 0, 506, 30, 506, 30);

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("demonicblessing:textures/gui3.png"));
		this.blit(ms, this.guiLeft + 0, this.guiTop + -56, 0, 0, 260, 224, 260, 224);

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
		this.addButton(new Button(this.guiLeft + 21, this.guiTop + 61, 87, 20, new StringTextComponent("Imrpove Stat"), e -> {
			if (true) {
				DemonicblessingMod.PACKET_HANDLER.sendToServer(new GemForgeGuiGui.ButtonPressedMessage(0, x, y, z));
				GemForgeGuiGui.handleButtonAction(entity, 0, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 147, this.guiTop + 61, 87, 20, new StringTextComponent("Reroll Stats"), e -> {
			if (true) {
				DemonicblessingMod.PACKET_HANDLER.sendToServer(new GemForgeGuiGui.ButtonPressedMessage(1, x, y, z));
				GemForgeGuiGui.handleButtonAction(entity, 1, x, y, z);
			}
		}));
	}
}
