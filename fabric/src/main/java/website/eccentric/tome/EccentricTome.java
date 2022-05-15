package website.eccentric.tome;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.core.Registry;
import net.minecraft.world.item.crafting.SimpleRecipeSerializer;
import website.eccentric.tome.network.ConvertHandler;
import website.eccentric.tome.network.RevertHandler;

public class EccentricTome implements ModInitializer {
    
    public static final TomeItem TOME = new TomeItem();

    public void onInitialize() {
        AttachmentRecipe.SERIALIZER = Registry.register(
            Registry.RECIPE_SERIALIZER,
            Resource.location("attachment"),
            new SimpleRecipeSerializer<AttachmentRecipe>(AttachmentRecipe::new));

        Registry.register(Registry.ITEM, Resource.location("tome"), TOME);
        ServerPlayNetworking.registerGlobalReceiver(ConvertHandler.LOCATION, new ConvertHandler());
        ServerPlayNetworking.registerGlobalReceiver(RevertHandler.LOCATION, new RevertHandler());
    }
}
