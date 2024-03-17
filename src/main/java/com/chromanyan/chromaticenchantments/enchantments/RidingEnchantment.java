package com.chromanyan.chromaticenchantments.enchantments;

import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.enchantment.*;
import org.jetbrains.annotations.NotNull;

public class RidingEnchantment extends EnchantmentBase {

    public static final DamageSource RIDING_DAMAGE = new DamageSource("chromaticenchantments.riding").setProjectile();

    public RidingEnchantment() {
        super(Rarity.VERY_RARE, EnchantmentCategory.BOW, EquipmentSlot.MAINHAND);
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

    public static void doEffects(AbstractArrow arrow, LivingEntity entity) {
        arrow.getPersistentData().putBoolean("chromaticenchantments.riding", true);
        entity.startRiding(arrow);
        entity.hurt(RidingEnchantment.RIDING_DAMAGE, 4);
    }

    public boolean checkCompatibility(@NotNull Enchantment pEnch) {
        return super.checkCompatibility(pEnch) && !(pEnch instanceof ArrowInfiniteEnchantment);
    }
}
