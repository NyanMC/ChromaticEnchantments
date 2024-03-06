package com.chromanyan.chromaticenchantments.enchantments;

import com.chromanyan.chromaticenchantments.init.ModTags;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ElytraItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import org.jetbrains.annotations.NotNull;

public class ConservationEnchantment extends EnchantmentBase {

    public ConservationEnchantment() {
        super(Rarity.UNCOMMON, EnchantmentCategory.ARMOR_CHEST, EquipmentSlot.CHEST);
    }

    public int getMinCost(int pEnchantmentLevel) {
        return 5 + (pEnchantmentLevel - 1) * 8;
    }

    public int getMaxCost(int pEnchantmentLevel) {
        return super.getMinCost(pEnchantmentLevel) + 50;
    }

    public int getMaxLevel() {
        return config.conservationMaxLevel.get();
    }

    public boolean canEnchant(@NotNull ItemStack pStack) {
        return pStack.is(ModTags.Items.ELYTRAS) || pStack.getItem() instanceof ElytraItem;
    }
}
