package com.hitbox;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.Box;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
@Mixin(Entity.class)
public abstract class HitboxMixin {
    @Inject(method = "getBoundingBox", at = @At("RETURN"), cancellable = true)
    private void expandHitbox(CallbackInfoReturnable<Box> cir) {
        cir.setReturnValue(cir.getReturnValue().expand(0.5));
    }
}
