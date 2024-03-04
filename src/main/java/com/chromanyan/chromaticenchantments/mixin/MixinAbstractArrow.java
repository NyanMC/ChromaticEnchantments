package com.chromanyan.chromaticenchantments.mixin;

import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.phys.BlockHitResult;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(AbstractArrow.class)
public class MixinAbstractArrow {

    @Unique
    private AbstractArrow chromaticEnchantments$trueThis() {
        return (AbstractArrow)(Object) this;
    }

    @Unique
    private void chromaticEnchantments$cleanup() {
        AbstractArrow trueThis = chromaticEnchantments$trueThis();

        trueThis.setNoGravity(false);
        trueThis.getPersistentData().putBoolean("chromaticenchantments.starshot", false);
    }

    @Unique
    private boolean chromaticEnchantments$isStarshot() {
        return chromaticEnchantments$trueThis().getPersistentData().getBoolean("chromaticenchantments.starshot");
    }

    @ModifyVariable(method = "tick", at = @At("STORE"))
    private float speedLossAmount(float x) {
        if (chromaticEnchantments$isStarshot()) {
            return 1;
        }

        return x;
    }

    @Inject(method = "tick", at = @At("HEAD"))
    private void tick(CallbackInfo ci) {
        if (chromaticEnchantments$trueThis().isInWater() && chromaticEnchantments$isStarshot()) {
            chromaticEnchantments$cleanup();
        }
    }

    @Inject(method = "onHitBlock", at = @At("TAIL"))
    private void onHitBlock(BlockHitResult pResult, CallbackInfo ci) {
        if (chromaticEnchantments$isStarshot()) {
            chromaticEnchantments$cleanup();
        }
    }

}
