package website.eccentric.tome.client.gui;

import net.minecraftforge.client.event.RenderGameOverlayEvent;

public class ForgeRenderGameOverlayHandler {

	public static void onRender(RenderGameOverlayEvent.Post event) {
		RenderGameOverlayHandler.onRender(event.getMatrixStack(), event.getPartialTicks());
	}
}
