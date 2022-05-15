package website.eccentric.tome.network;

import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.network.NetworkRegistry;
import net.minecraftforge.network.simple.SimpleChannel;
import website.eccentric.tome.Resource;

public class TomeChannel {

    public static final ResourceLocation NAME = Resource.location("general");
    public static final String VERSION = Resource.location("1").toString();

    public static SimpleChannel register() {
        var channel = NetworkRegistry.ChannelBuilder.named(NAME)
            .clientAcceptedVersions(version -> true)
            .serverAcceptedVersions(version -> true)
            .networkProtocolVersion(() -> VERSION)
            .simpleChannel();
        
        channel.registerMessage(1, ConvertMessage.class, ConvertMessage::encode, ConvertMessage::decode, ConvertMessage::handle);
        channel.registerMessage(2, RevertMessage.class, RevertMessage::encode, RevertMessage::decode, RevertMessage::handle);

        return channel;
    }
}
