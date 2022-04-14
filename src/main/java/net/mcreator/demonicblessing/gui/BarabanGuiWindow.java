
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
public class BarabanGuiWindow extends ContainerScreen<BarabanGui.GuiContainerMod> {
	private World world;
	private int x, y, z;
	private PlayerEntity entity;
	private final static HashMap guistate = BarabanGui.guistate;

	public BarabanGuiWindow(BarabanGui.GuiContainerMod container, PlayerInventory inventory, ITextComponent text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.xSize = 500;
		this.ySize = 400;
	}

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

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("demonicblessing:textures/1chaka.png"));
		this.blit(ms, this.guiLeft + 206, this.guiTop + 79, 0, 0, 64, 64, 64, 64);

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("demonicblessing:textures/1don.png"));
		this.blit(ms, this.guiLeft + 231, this.guiTop + 248, 0, 0, 64, 64, 64, 64);

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("demonicblessing:textures/1pata.png"));
		this.blit(ms, this.guiLeft + 91, this.guiTop + 165, 0, 0, 64, 64, 64, 64);

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("demonicblessing:textures/1pon.png"));
		this.blit(ms, this.guiLeft + 331, this.guiTop + 164, 0, 0, 64, 64, 64, 64);

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
		this.addButton(new Button(this.guiLeft + 178, this.guiTop + 187, 45, 20, new StringTextComponent("Pata"), e -> {
			if (true) {
				DemonicblessingMod.PACKET_HANDLER.sendToServer(new BarabanGui.ButtonPressedMessage(0, x, y, z));
				BarabanGui.handleButtonAction(entity, 0, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 281, this.guiTop + 187, 40, 20, new StringTextComponent("Pon"), e -> {
			if (true) {
				DemonicblessingMod.PACKET_HANDLER.sendToServer(new BarabanGui.ButtonPressedMessage(1, x, y, z));
				BarabanGui.handleButtonAction(entity, 1, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 229, this.guiTop + 223, 40, 20, new StringTextComponent("Don"), e -> {
			if (true) {
				DemonicblessingMod.PACKET_HANDLER.sendToServer(new BarabanGui.ButtonPressedMessage(2, x, y, z));
				BarabanGui.handleButtonAction(entity, 2, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 224, this.guiTop + 148, 50, 20, new StringTextComponent("Chaka"), e -> {
			if (true) {
				DemonicblessingMod.PACKET_HANDLER.sendToServer(new BarabanGui.ButtonPressedMessage(3, x, y, z));
				BarabanGui.handleButtonAction(entity, 3, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 235, this.guiTop + 187, 30, 20, new StringTextComponent("обновить"), e -> {
			if (true) {
				DemonicblessingMod.PACKET_HANDLER.sendToServer(new BarabanGui.ButtonPressedMessage(4, x, y, z));
				BarabanGui.handleButtonAction(entity, 4, x, y, z);
			}
		}));
	}
}
