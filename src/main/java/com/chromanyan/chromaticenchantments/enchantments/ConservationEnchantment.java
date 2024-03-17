package com.chromanyan.chromaticenchantments.enchantments;

import com.chromanyan.chromaticenchantments.ChromaticEnchantments;
import com.chromanyan.chromaticenchantments.init.ModTags;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ElytraItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import org.jetbrains.annotations.NotNull;

public class ConservationEnchantment extends EnchantmentBase {

    public static final int DEFAULT_MAX = 4;

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
        try {
            return config.conservationMaxLevel.get();
        } catch (IllegalStateException e) {
            ChromaticEnchantments.LOGGER.error("Caught IllegalStateException from getMaxLevel() in ConservationEnchantment, returning hardcoded constant of " + DEFAULT_MAX, e);
            return DEFAULT_MAX;
        }
    }

    @Override
    public boolean canApplyAtEnchantingTable(@NotNull ItemStack stack) {
        return stack.is(ModTags.Items.ELYTRAS) || (stack.getItem() instanceof ElytraItem && !config.strictElytraCheck.get());
    }
}
