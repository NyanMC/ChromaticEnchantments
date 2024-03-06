package com.chromanyan.chromaticenchantments.enchantments;

import com.chromanyan.chromaticenchantments.init.ModEnchantments;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.enchantment.Enchantment;

public class ConservationEnchantment extends Enchantment {
    public ConservationEnchantment() {
        super(Rarity.UNCOMMON, ModEnchantments.ELYTRA, new EquipmentSlot[]{EquipmentSlot.CHEST});
    }

    public int getMinCost(int pEnchantmentLevel) {
        return 5 + (pEnchantmentLevel - 1) * 8;
    }

    public int getMaxCost(int pEnchantmentLevel) {
        return super.getMinCost(pEnchantmentLevel) + 50;
    }

    public int getMaxLevel() {
        return 4;
    }
}
