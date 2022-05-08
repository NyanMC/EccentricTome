package website.eccentric.tome.services;

import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.minecraft.world.item.ItemStack;
import website.eccentric.tome.network.ConvertHandler;

public class NetworkImpl implements Network {
    @Override
    public void convert(ItemStack book) {
        var buffer = PacketByteBufs.create().writeItem(book);
        ClientPlayNetworking.send(ConvertHandler.LOCATION, buffer);
    }
}
