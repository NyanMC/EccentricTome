package website.eccentric.tome;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import website.eccentric.tome.client.gui.RenderGameOverlayHandler;

public class EccentricTomeClient implements ClientModInitializer {
    public static final Logger LOG = LoggerFactory.getLogger(Resource.NAMESPACE);

    @Override
    public void onInitializeClient() {
        HudRenderCallback.EVENT.register(RenderGameOverlayHandler::onRender);
        /*
        MinecraftForge.EVENT_BUS.addListener(TomeHandler::onOpenTome);
        */
    }
}
