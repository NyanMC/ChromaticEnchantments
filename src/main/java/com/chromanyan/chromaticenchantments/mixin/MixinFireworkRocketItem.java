package com.chromanyan.chromaticenchantments.mixin;

import com.chromanyan.chromaticenchantments.config.ModConfig;
import com.chromanyan.chromaticenchantments.init.ModEnchantments;
import net.minecraft.world.entity.player.Abilities;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.FireworkRocketItem;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Level;
import org.objectweb.asm.Opcodes;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(FireworkRocketItem.class)
public class MixinFireworkRocketItem {

    @Redirect(method = "use", at = @At(value = "FIELD", target = "Lnet/minecraft/world/entity/player/Abilities;instabuild:Z", opcode = Opcodes.GETFIELD))
    private boolean procConservation(Abilities instance, Level pLevel, Player pPlayer) {
        if (instance.instabuild) return true; // we don't even need to do anything

        int conservationLevel = EnchantmentHelper.getEnchantmentLevel(ModEnchantments.CONSERVATION.get(), pPlayer);

        if (conservationLevel > 0) {
            return pPlayer.getRandom().nextDouble() < ModConfig.COMMON.conservationChance.get() * conservationLevel;
        }

        return false;
    }

}
