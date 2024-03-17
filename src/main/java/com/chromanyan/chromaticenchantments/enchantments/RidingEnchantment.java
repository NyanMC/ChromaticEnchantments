package com.chromanyan.chromaticenchantments.enchantments;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.enchantment.*;
import org.jetbrains.annotations.NotNull;

public class RidingEnchantment extends EnchantmentBase {
    public RidingEnchantment() {
        super(Rarity.VERY_RARE, EnchantmentCategory.BOW, EquipmentSlot.MAINHAND);
    }

    public int getMinCost(int pEnchantmentLevel) {
        return 25;
    }

    public int getMaxCost(int pEnchantmentLevel) {
        return 50;
    }

    public boolean isTreasureOnly() {
        return true;
    }

    public boolean checkCompatibility(@NotNull Enchantment pEnch) {
        return super.checkCompatibility(pEnch) && !(pEnch instanceof ArrowInfiniteEnchantment);
    }
}
