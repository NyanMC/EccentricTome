package website.eccentric.tome;

import com.google.gson.JsonObject;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.RecipeSerializer;

public class AttachmentRecipeSerializer implements RecipeSerializer<AttachmentRecipe> {
    public AttachmentRecipe fromJson(ResourceLocation location, JsonObject json) {
       return new AttachmentRecipe(location);
    }
 
    public AttachmentRecipe fromNetwork(ResourceLocation location, FriendlyByteBuf buffer) {
       return new AttachmentRecipe(location);
    }
 
    public void toNetwork(FriendlyByteBuf location, AttachmentRecipe recipe) {
    }
}
