package com.chromanyan.chromaticenchantments.enchantments;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.enchantment.EnchantmentCategory;

public class StarshotEnchantment extends EnchantmentBase {

    public StarshotEnchantment() {
        super(Rarity.RARE, EnchantmentCategory.CROSSBOW, EquipmentSlot.MAINHAND);
    }

    public int getMinCost(int p_45111_) {
        return 20;
    }

    public int getMaxCost(int p_45115_) {
        return 50;
    }
}
