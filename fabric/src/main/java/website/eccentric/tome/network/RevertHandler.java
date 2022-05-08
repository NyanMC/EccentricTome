package website.eccentric.tome.network;

import net.fabricmc.fabric.api.networking.v1.PacketSender;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking.PlayChannelHandler;
import net.minecraft.client.Minecraft;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.network.ServerGamePacketListenerImpl;
import website.eccentric.tome.EccentricTome;
import website.eccentric.tome.TomeItem;
import website.eccentric.tome.services.Services;
import website.eccentric.tome.services.Tome;

public class RevertHandler implements PlayChannelHandler {
    public static final ResourceLocation LOCATION = new ResourceLocation(EccentricTome.ID, "revert");
    
    @SuppressWarnings("resource")
    @Override
    public void receive(
        MinecraftServer server,
        ServerPlayer player,
        ServerGamePacketListenerImpl handler,
        FriendlyByteBuf buffer,
        PacketSender responseSender) {
        
        var hand = TomeItem.inHand(player);

        if (hand != null) {
            var tomeService = Services.load(Tome.class);
            var stack = player.getItemInHand(hand);
            var tome = tomeService.revert(stack);
            player.setItemInHand(hand, tomeService.attach(tome, stack));

            if (player.level.isClientSide) {
                Minecraft.getInstance().gameRenderer.itemInHandRenderer.itemUsed(hand);
            }
        }
    }
}