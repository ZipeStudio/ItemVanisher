package me.zipestudio.itemvanisher.mixin;

import me.zipestudio.itemvanisher.client.IVClient;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.feature.StuckArrowsFeatureRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(StuckArrowsFeatureRenderer.class)
public class ArrowInPlayerRenderMixin {

    @Inject(
            method = "renderObject",
            at = @At("HEAD"),
            cancellable = true
    )
    private void renderArrowInject(MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, Entity entity, float directionX, float directionY, float directionZ, float tickDelta, CallbackInfo ci) {
        if (!IVClient.getClientConfig().isToggle()) {
            return;
        }

        ci.cancel();
    }
}
