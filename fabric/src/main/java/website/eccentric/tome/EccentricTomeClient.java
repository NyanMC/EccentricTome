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
        minecraftEvent.addListener(EventPriority.LOW, this::onItemDropped);
        */
    }

    /*

    private void onItemDropped(ItemTossEvent event) {
        if (!event.getPlayer().isShiftKeyDown()) return;

        var entity = event.getEntityItem();
        var stack = entity.getItem();

        if (TomeItem.isTome(stack) && !(stack.getItem() instanceof TomeItem)) {
            var detatchment = Services.load(Tome.class).revert(stack);
            var level = entity.getCommandSenderWorld();

            if (!level.isClientSide) {
                level.addFreshEntity(new ItemEntity(level, entity.getX(), entity.getY(), entity.getZ(), detatchment));
            }

            entity.setItem(stack);
        }
    }
    */
}
