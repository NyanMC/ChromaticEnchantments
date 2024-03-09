package com.chromanyan.chromaticenchantments.enchantments;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.item.enchantment.LootBonusEnchantment;
import org.jetbrains.annotations.NotNull;

public class VoidingCurseEnchantment extends EnchantmentBase {

    public VoidingCurseEnchantment() {
        super(Enchantment.Rarity.VERY_RARE, EnchantmentCategory.DIGGER, EquipmentSlot.MAINHAND);
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

    public boolean isCurse() {
        return true;
    }

    public boolean checkCompatibility(@NotNull Enchantment pEnch) {
        return super.checkCompatibility(pEnch) && pEnch != Enchantments.SILK_TOUCH && !(pEnch instanceof LootBonusEnchantment);
    }

    @Override
    public boolean canEnchant(@NotNull ItemStack pStack) {
        return pStack.getItem() instanceof SwordItem || super.canEnchant(pStack);
    }
}
