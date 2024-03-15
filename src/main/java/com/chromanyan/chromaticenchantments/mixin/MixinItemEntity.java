package com.chromanyan.chromaticenchantments.mixin;

import com.chromanyan.chromaticenchantments.init.ModEnchantments;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ItemEntity.class)
public abstract class MixinItemEntity {

    @Unique
    private boolean chromaticEnchantments$hasPersistenceEnchantment() {
        ItemStack itemStack = ((ItemEntity)(Object)this).getItem();
        if (itemStack.isEmpty()) return false;

        return (itemStack.getEnchantmentLevel(ModEnchantments.PERSISTENCE.get()) > 0);
    }

    @Inject(method = "fireImmune", at = @At("RETURN"), cancellable = true)
    private void fireImmune(CallbackInfoReturnable<Boolean> cir) {
        if (chromaticEnchantments$hasPersistenceEnchantment()) {
            cir.setReturnValue(true);
        }
    }

    @Inject(method = "hurt", at = @At("HEAD"), cancellable = true)
    private void hurt(DamageSource pSource, float pAmount, CallbackInfoReturnable<Boolean> cir) {
        if (chromaticEnchantments$hasPersistenceEnchantment() && !pSource.isBypassInvul()) {
            cir.setReturnValue(false);
        }
    }

}
