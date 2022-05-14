package website.eccentric.tome.services;

import net.minecraft.world.item.ItemStack;

public class DispatchImpl implements Dispatch {

    @Override
    public void openTome(ItemStack tome) {
        //MinecraftForge.EVENT_BUS.post(new OpenTomeEvent(tome));
    }
}
