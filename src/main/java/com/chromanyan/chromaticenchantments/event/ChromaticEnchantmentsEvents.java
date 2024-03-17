package com.chromanyan.chromaticenchantments.event;

import com.chromanyan.chromaticenchantments.init.ModEnchantments;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.phys.HitResult;
import net.minecraftforge.event.entity.ProjectileImpactEvent;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class ChromaticEnchantmentsEvents {

    @SubscribeEvent
    public void livingDrops(LivingDropsEvent event) {
        // don't proc for players, idk if that would void their inventory drops and i'd rather not find out
        if (event.isCanceled() || event.getEntity() instanceof Player) return;

        Entity entity = event.getSource().getEntity();
        if (!(entity instanceof LivingEntity livingEntity)) return;

        if (livingEntity.getMainHandItem().getEnchantmentLevel(ModEnchantments.VOIDING_CURSE.get()) > 0) {
            event.setCanceled(true);
        }
    }

    @SubscribeEvent
    public void projectileImpact(ProjectileImpactEvent event) {
        if (!(event.getProjectile() instanceof AbstractArrow abstractArrow)) return;

        CompoundTag compoundTag = abstractArrow.getPersistentData();

        if (!(event.getRayTraceResult().getType() == HitResult.Type.BLOCK)) return;

        if (compoundTag.getBoolean("chromaticenchantments.starshot")) {
            abstractArrow.setNoGravity(false);
            compoundTag.putBoolean("chromaticenchantments.starshot", false);
        }
        if (compoundTag.getBoolean("chromaticenchantments.riding")) {
            abstractArrow.ejectPassengers();
        }
    }
}
