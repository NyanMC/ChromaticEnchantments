package com.chromanyan.chromaticenchantments.enchantments;

import com.chromanyan.chromaticenchantments.config.ModConfig;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;

public class EnchantmentBase extends Enchantment {

    protected static final ModConfig.Common config = ModConfig.COMMON;

    public EnchantmentBase(Rarity pRarity, EnchantmentCategory pCategory, EquipmentSlot[] pApplicableSlots) {
        super(pRarity, pCategory, pApplicableSlots);
    }

    /**
     * Alternative constructor which takes a single EquipmentSlot instead of an array.
     */
    public EnchantmentBase(Rarity pRarity, EnchantmentCategory pCategory, EquipmentSlot pApplicableSlot) {
        this(pRarity, pCategory, new EquipmentSlot[]{pApplicableSlot});
    }
}
