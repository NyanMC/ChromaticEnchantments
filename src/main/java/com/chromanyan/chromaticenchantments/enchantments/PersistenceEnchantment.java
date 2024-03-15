package com.chromanyan.chromaticenchantments.enchantments;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.enchantment.EnchantmentCategory;

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
}
