package com.chromanyan.chromaticenchantments.enchantments;

import com.chromanyan.chromaticenchantments.init.ModTags;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ShearsItem;
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
    public boolean canApplyAtEnchantingTable(@NotNull ItemStack pStack) {
        if (config.strictVoidingCheck.get()) {
            return pStack.is(ModTags.Items.VOIDING_APPLICABLE);
        }

        return pStack.getItem() instanceof SwordItem
                || pStack.getItem() instanceof ShearsItem
                || pStack.is(ModTags.Items.VOIDING_APPLICABLE)
                || super.canApplyAtEnchantingTable(pStack);
    }
}
