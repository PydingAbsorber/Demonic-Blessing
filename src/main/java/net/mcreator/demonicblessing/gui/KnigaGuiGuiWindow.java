
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
public class KnigaGuiGuiWindow extends ContainerScreen<KnigaGuiGui.GuiContainerMod> {
	private World world;
	private int x, y, z;
	private PlayerEntity entity;
	private final static HashMap guistate = KnigaGuiGui.guistate;

	public KnigaGuiGuiWindow(KnigaGuiGui.GuiContainerMod container, PlayerInventory inventory, ITextComponent text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.xSize = 176;
		this.ySize = 166;
	}

	private static final ResourceLocation texture = new ResourceLocation("demonicblessing:textures/kniga_gui.png");

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

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("demonicblessing:textures/strelka.png"));
		this.blit(ms, this.guiLeft + 24, this.guiTop + 25, 0, 0, 16, 16, 16, 16);

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("demonicblessing:textures/strelka2.png"));
		this.blit(ms, this.guiLeft + 132, this.guiTop + 25, 0, 0, 16, 16, 16, 16);

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("demonicblessing:textures/mem1.png"));
		this.blit(ms, this.guiLeft + -254, this.guiTop + -65, 0, 0, 256, 256, 256, 256);

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("demonicblessing:textures/mem2.png"));
		this.blit(ms, this.guiLeft + 177, this.guiTop + -65, 0, 0, 256, 256, 256, 256);

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("demonicblessing:textures/screenshot_94.png"));
		this.blit(ms, this.guiLeft + -56, this.guiTop + 169, 0, 0, 301, 207, 301, 207);

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
		this.addButton(new Button(this.guiLeft + 42, this.guiTop + 52, 90, 20, new StringTextComponent("ÊÀÊòèâèðîâÀÒÜ"), e -> {
			if (true) {
				DemonicblessingMod.PACKET_HANDLER.sendToServer(new KnigaGuiGui.ButtonPressedMessage(0, x, y, z));
				KnigaGuiGui.handleButtonAction(entity, 0, x, y, z);
			}
		}));
	}
}
