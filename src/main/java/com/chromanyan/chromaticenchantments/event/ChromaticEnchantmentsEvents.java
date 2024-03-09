package com.chromanyan.chromaticenchantments.event;

import com.chromanyan.chromaticenchantments.init.ModEnchantments;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
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
}
