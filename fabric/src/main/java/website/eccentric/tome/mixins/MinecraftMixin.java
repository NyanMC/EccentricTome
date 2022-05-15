package website.eccentric.tome.mixins;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.util.thread.ReentrantBlockableEventLoop;
import website.eccentric.tome.TomeItem;
import website.eccentric.tome.network.RevertHandler;

@Mixin(Minecraft.class)
public abstract class MinecraftMixin extends ReentrantBlockableEventLoop<Runnable> {

    @Shadow
    public LocalPlayer player;

    public MinecraftMixin(String string) {
        super(string);
    }

    @Inject(method = "startAttack", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/player/Player;resetAttackStrengthTicker()V"))
    public void onMiss(CallbackInfoReturnable<Boolean> cir) {
        var stack = this.player.getMainHandItem();
        if (TomeItem.isTome(stack) && !(stack.getItem() instanceof TomeItem)) {
            ClientPlayNetworking.send(RevertHandler.LOCATION, PacketByteBufs.empty());
        }
    }
}
