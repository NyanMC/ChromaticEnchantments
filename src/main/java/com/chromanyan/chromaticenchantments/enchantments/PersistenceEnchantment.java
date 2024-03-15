package com.chromanyan.chromaticenchantments.enchantments;

import com.chromanyan.chromaticenchantments.config.ModConfig;
import com.chromanyan.chromaticenchantments.init.ModTags;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraft.world.item.enchantment.Enchantments;
import org.jetbrains.annotations.NotNull;

public class PersistenceEnchantment extends EnchantmentBase {
    public PersistenceEnchantment() {
        super(Rarity.RARE, EnchantmentCategory.VANISHABLE, EquipmentSlot.values());
    }

    public int getMinCost(int pEnchantmentLevel) {
        return 10;
    }

    public int getMaxCost(int pEnchantmentLevel) {
        return 20;
    }

    @Override
    public boolean canApplyAtEnchantingTable(@NotNull ItemStack stack) {
        if (ModConfig.COMMON.loosePersistenceCheck.get() && stack.getMaxStackSize() == 1) return true;

        // some items (e.g. curios) can receive vanishing but aren't vanishable
        return super.canApplyAtEnchantingTable(stack) || stack.canApplyAtEnchantingTable(Enchantments.VANISHING_CURSE) || stack.is(ModTags.Items.PERSISTENCE_APPLICABLE);
    }
}
