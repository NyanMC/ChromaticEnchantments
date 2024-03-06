package com.chromanyan.chromaticenchantments.util;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraftforge.fml.ModList;
import top.theillusivec4.curios.api.CuriosApi;
import top.theillusivec4.curios.api.SlotResult;

import java.util.List;

public class ChromaticEnchantmentHelper {

    /**
     * Returns the combined level of the given Enchantment on all equipped curios. Returns 0 if curios is not installed.
     * @param enchantment The Enchantment to check for.
     * @param livingEntity The LivingEntity to check on.
     * @return The combined enchantment level on all equipped curios.
     */
    public static int getCuriosEnchantmentLevel(Enchantment enchantment, LivingEntity livingEntity) {
        if (!ModList.get().isLoaded("curios")) return 0;

        List<SlotResult> validCurios = CuriosApi.getCuriosHelper().findCurios(livingEntity, itemStack -> itemStack.getEnchantmentLevel(enchantment) > 0);

        int total = 0;
        for (SlotResult result : validCurios) {
            total += result.stack().getEnchantmentLevel(enchantment);
        }

        return total;
    }

    /**
     * Returns the combined value of {@link ChromaticEnchantmentHelper#getCuriosEnchantmentLevel} and {@link EnchantmentHelper#getEnchantmentLevel}.
     * @param enchantment The Enchantment to check for.
     * @param livingEntity The LivingEntity to check on.
     * @return The combined enchantment level on all equipped curios.
     */
    public static int getFullEnchantmentLevel(Enchantment enchantment, LivingEntity livingEntity) {
        return EnchantmentHelper.getEnchantmentLevel(enchantment, livingEntity) + getCuriosEnchantmentLevel(enchantment, livingEntity);
    }

}
