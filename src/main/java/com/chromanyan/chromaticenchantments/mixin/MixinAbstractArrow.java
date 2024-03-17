package com.chromanyan.chromaticenchantments.mixin;

import com.chromanyan.chromaticenchantments.init.ModEnchantments;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
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
    private void chromaticEnchantments$cleanupStarshot() {
        AbstractArrow trueThis = chromaticEnchantments$trueThis();

        trueThis.setNoGravity(false);
        trueThis.getPersistentData().putBoolean("chromaticenchantments.starshot", false);
    }

    @Unique
    private boolean chromaticEnchantments$isStarshot() {
        return chromaticEnchantments$trueThis().getPersistentData().getBoolean("chromaticenchantments.starshot");
    }

    @Unique
    private boolean chromaticEnchantments$isRiding() {
        return chromaticEnchantments$trueThis().getPersistentData().getBoolean("chromaticenchantments.riding");
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
            chromaticEnchantments$cleanupStarshot();
        }
    }

    @Inject(method = "onHitBlock", at = @At("TAIL"))
    private void onHitBlock(BlockHitResult pResult, CallbackInfo ci) {
        if (chromaticEnchantments$isStarshot()) {
            chromaticEnchantments$cleanupStarshot();
        }
        if (!(chromaticEnchantments$trueThis().getFirstPassenger() instanceof Player) && chromaticEnchantments$isRiding()) {
            chromaticEnchantments$trueThis().ejectPassengers();
        }
    }

    @Inject(method = "setEnchantmentEffectsFromEntity", at = @At("TAIL"))
    private void setEnchantmentEffectsFromEntity(LivingEntity pShooter, float pVelocity, CallbackInfo ci) {
        if (EnchantmentHelper.getEnchantmentLevel(ModEnchantments.RIDING.get(), pShooter) > 0 && pShooter.getVehicle() == null) {
            chromaticEnchantments$trueThis().getPersistentData().putBoolean("chromaticenchantments.riding", true);
            pShooter.startRiding(chromaticEnchantments$trueThis());
        }
    }

}
