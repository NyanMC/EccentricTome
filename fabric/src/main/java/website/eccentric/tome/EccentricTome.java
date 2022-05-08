package website.eccentric.tome;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import website.eccentric.tome.network.ConvertHandler;
import website.eccentric.tome.network.RevertHandler;

public class EccentricTome implements ModInitializer {
    
    public static final String ID = "eccentrictome";

    public static final AttachmentRecipeSerializer ATTACHMENT_SERIALIZER = new AttachmentRecipeSerializer();
    public static final TomeItem TOME = new TomeItem();

    public void onInitialize() {
        Registry.register(Registry.RECIPE_SERIALIZER, new ResourceLocation(ID, "attachment"), ATTACHMENT_SERIALIZER);
        Registry.register(Registry.ITEM, new ResourceLocation(ID, "tome"), TOME);
        ServerPlayNetworking.registerGlobalReceiver(ConvertHandler.LOCATION, new ConvertHandler());
        ServerPlayNetworking.registerGlobalReceiver(RevertHandler.LOCATION, new RevertHandler());
    }
}
