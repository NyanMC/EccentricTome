package website.eccentric.tome.mixins;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import website.eccentric.tome.TomeItem;
import website.eccentric.tome.services.Services;
import website.eccentric.tome.services.Tome;

@Mixin(Player.class)
public class PlayerMixin {
    
    @Inject(method = "drop(Lnet/minecraft/world/item/ItemStack;ZZ)Lnet/minecraft/world/entity/item/ItemEntity;", at = @At("TAIL"))
    public void dropTome(ItemStack itemStack, boolean bl, boolean bl2, CallbackInfoReturnable<ItemEntity> info) {
        var player = (Player) (Object) this;
        if (!player.isShiftKeyDown()) return;

        var entity = info.getReturnValue();

        if (TomeItem.isTome(itemStack) && !(itemStack.getItem() instanceof TomeItem)) {
            var detatchment = Services.load(Tome.class).revert(itemStack);
            var level = entity.getLevel();

            if (!level.isClientSide()) {
                level.addFreshEntity(new ItemEntity(level, entity.getX(), entity.getY(), entity.getZ(), detatchment));
            }

            entity.setItem(itemStack);
            info.setReturnValue(entity);
        }
    }
}
