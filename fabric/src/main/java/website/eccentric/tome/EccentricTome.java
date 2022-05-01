package website.eccentric.tome;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.SimpleRecipeSerializer;
import website.eccentric.tome.client.gui.RenderGameOverlayHandler;
import website.eccentric.tome.client.gui.TomeHandler;
import website.eccentric.tome.network.RevertMessage;
import website.eccentric.tome.network.TomeChannel;
import website.eccentric.tome.services.Configuration;
import website.eccentric.tome.services.Services;
import website.eccentric.tome.services.Tome;

public class EccentricTome implements ModInitializer {
    
    public static final String ID = "eccentrictome";

    public static final AttachmentRecipeSerializer ATTACHMENT_SERIALIZER = new AttachmentRecipeSerializer();
    public static final TomeItem TOME = new TomeItem();

    public void onInitialize() {
        Registry.register(Registry.RECIPE_SERIALIZER, new ResourceLocation(ID, "attachment"), ATTACHMENT_SERIALIZER);
        Registry.register(Registry.ITEM, new ResourceLocation(ID, "tome"), TOME);
        
        minecraftEvent.addListener(this::onPlayerLeftClick);
        minecraftEvent.addListener(EventPriority.LOW, this::onItemDropped);
    }

    private void onPlayerLeftClick(PlayerInteractEvent.LeftClickEmpty event) {
        var stack = event.getItemStack();
        if (TomeItem.isTome(stack) && !(stack.getItem() instanceof TomeItem)) {
            CHANNEL.sendToServer(new RevertMessage());
        }
    }

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
}
