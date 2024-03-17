package com.chromanyan.chromaticenchantments.mixin;

import com.chromanyan.chromaticenchantments.init.ModEnchantments;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ArrowItem;
import net.minecraft.world.item.BowItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

@Mixin(BowItem.class)
public class MixinBowItem {

    @Inject(method = "releaseUsing", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/projectile/AbstractArrow;setCritArrow(Z)V"), locals = LocalCapture.CAPTURE_FAILHARD)
    private void onCritArrow(ItemStack pStack, Level pLevel, LivingEntity pEntityLiving, int pTimeLeft, CallbackInfo ci, Player player, boolean flag, ItemStack itemstack, int i, float f, boolean flag1, ArrowItem arrowitem, AbstractArrow abstractarrow) {
        if (pStack.getEnchantmentLevel(ModEnchantments.RIDING.get()) > 0 && pEntityLiving.isOnGround() && pEntityLiving.getVehicle() == null) {
            abstractarrow.getPersistentData().putBoolean("chromaticenchantments.riding", true);
            pEntityLiving.startRiding(abstractarrow);
        }
    }

}
