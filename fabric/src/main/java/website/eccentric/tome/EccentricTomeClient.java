package website.eccentric.tome;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import website.eccentric.tome.client.gui.RenderGameOverlayHandler;

public class EccentricTomeClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        HudRenderCallback.EVENT.register(RenderGameOverlayHandler::onRender);
        //MinecraftForge.EVENT_BUS.addListener(TomeHandler::onOpenTome);
    }
}
