package com.chromanyan.chromaticenchantments.enchantments;

import com.chromanyan.chromaticenchantments.init.ModEnchantments;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.enchantment.Enchantment;

public class ConservationEnchantment extends Enchantment {
    public ConservationEnchantment() {
        super(Rarity.UNCOMMON, ModEnchantments.ELYTRA, new EquipmentSlot[]{EquipmentSlot.CHEST});
    }
}
