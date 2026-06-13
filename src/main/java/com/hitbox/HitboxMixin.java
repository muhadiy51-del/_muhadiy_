package com.hitbox;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.Box;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
@Mixin(Entity.class)
public abstract class HitboxMixin {
    @Inject(at = @At("RETURN"), method = "getBoundingBox", cancellable = true)
    private void bigHitbox(CallbackInfoReturnable<Box> cir) {
        Box box = cir.getReturnValue();
        cir.setReturnValue(box.expand(0.5));
    }
}
