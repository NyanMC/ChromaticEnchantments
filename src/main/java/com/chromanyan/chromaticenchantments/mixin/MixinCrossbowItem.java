package com.chromanyan.chromaticenchantments.mixin;

import com.chromanyan.chromaticenchantments.init.ModEnchantments;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ArrowItem;
import net.minecraft.world.item.CrossbowItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

@Mixin(CrossbowItem.class)
public class MixinCrossbowItem {

    @Inject(method = "getArrow", at = @At("RETURN"), locals = LocalCapture.CAPTURE_FAILHARD)
    private static void mixinGetArrow(Level pLevel, LivingEntity pLivingEntity, ItemStack pCrossbowStack, ItemStack pAmmoStack, CallbackInfoReturnable<AbstractArrow> cir, ArrowItem arrowitem, AbstractArrow abstractarrow, int i) {
        if (pCrossbowStack.getEnchantmentLevel(ModEnchantments.STARSHOT.get()) > 0) {
            abstractarrow.setNoGravity(true);
            // give the arrow persistent data that we can access in a different mixin
            abstractarrow.getPersistentData().putBoolean("chromaticenchantments.starshot", true);
        }
    }
}
