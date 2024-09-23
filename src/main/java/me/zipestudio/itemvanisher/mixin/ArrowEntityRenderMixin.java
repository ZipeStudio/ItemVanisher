package me.zipestudio.itemvanisher.mixin;

import me.zipestudio.itemvanisher.client.IVClient;
import me.zipestudio.itemvanisher.utils.ArrowUtils;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;
import net.minecraft.entity.projectile.ArrowEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(EntityRenderDispatcher.class)
public class ArrowEntityRenderMixin {
    @Inject(
            method = "renderHitbox",
            at = @At("HEAD"),
            cancellable = true
    )
    private static void renderArrowHitboxInject(MatrixStack matrices, VertexConsumer vertices, Entity entity, float tickDelta, float red, float green, float blue, CallbackInfo ci) {

        if (!(entity instanceof ArrowEntity arrowEntity)) {
            return;
        }

        if (!ArrowUtils.isArrowFreeze(arrowEntity)) {
            return;
        }

        if (!IVClient.getClientConfig().isToggle()) {
            return;
        }

        ci.cancel();
    }

    @Inject(
            method = "render",
            at = @At("HEAD"),
            cancellable = true
    )
    private void renderArrowHitboxInject(Entity entity, double x, double y, double z, float yaw, float tickDelta, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, CallbackInfo ci) {

        if (!(entity instanceof ArrowEntity arrowEntity)) {
            return;
        }

        if (!ArrowUtils.isArrowFreeze(arrowEntity)) {
            return;
        }

        if (!IVClient.getClientConfig().isToggle()) {
            return;
        }

        ci.cancel();
    }
}
