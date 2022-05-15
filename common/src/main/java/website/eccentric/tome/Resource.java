package website.eccentric.tome;

import net.minecraft.resources.ResourceLocation;

public class Resource {
    public static final String NAMESPACE = "eccentrictome";

    public static ResourceLocation location(String path) {
        return new ResourceLocation(NAMESPACE, path);
    }
}
