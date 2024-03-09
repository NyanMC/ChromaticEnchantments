package com.chromanyan.chromaticenchantments.mixin;

import com.chromanyan.chromaticenchantments.init.ModEnchantments;
import com.chromanyan.chromaticenchantments.init.ModStats;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Block.class)
public class MixinBlock {

    @Inject(method = "playerDestroy", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/block/Block;dropResources(Lnet/minecraft/world/level/block/state/BlockState;Lnet/minecraft/world/level/Level;Lnet/minecraft/core/BlockPos;Lnet/minecraft/world/level/block/entity/BlockEntity;Lnet/minecraft/world/entity/Entity;Lnet/minecraft/world/item/ItemStack;)V"), cancellable = true)
    private void checkVoiding(Level pLevel, Player pPlayer, BlockPos pPos, BlockState pState, BlockEntity pBlockEntity, ItemStack pTool, CallbackInfo ci) {
        if (pTool.getEnchantmentLevel(ModEnchantments.VOIDING_CURSE.get()) > 0) {
            pPlayer.awardStat(ModStats.DROPS_VOIDED);
            ci.cancel();
        }
    }

}
