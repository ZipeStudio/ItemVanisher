package me.zipestudio.itemvanisher.mixin;

import me.zipestudio.itemvanisher.client.IVClient;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ItemEntity;
import net.minecraft.world.WorldView;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(EntityRenderDispatcher.class)
public class ItemShadowHitBoxRenderMixin {

    @Inject(
            method = "renderShadow",
            at = @At("HEAD"),
            cancellable = true
    )
    private static void renderShadowInject(MatrixStack matrices, VertexConsumerProvider vertexConsumers, Entity entity, float opacity, float tickDelta, WorldView world, float radius, CallbackInfo ci) {
        if (!(entity instanceof ItemEntity)) {
            return;
        }

        if (!IVClient.getClientConfig().isToggle()) {
            return;
        }

        ci.cancel();
    }


    @Inject(
            method = "renderHitbox",
            at = @At("HEAD"),
            cancellable = true
    )
    private static void renderHitBoxInject(MatrixStack matrices, VertexConsumer vertices, Entity entity, float tickDelta, float red, float green, float blue, CallbackInfo ci) {
        if (!(entity instanceof ItemEntity)) {
            return;
        }

        if (!IVClient.getClientConfig().isToggle()) {
            return;
        }

        ci.cancel();
    }
}
