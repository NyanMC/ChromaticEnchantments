package com.chromanyan.chromaticenchantments.init;

import com.chromanyan.chromaticenchantments.ChromaticEnchantments;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.stats.Stat;
import net.minecraft.stats.Stats;

public class ModStats {
    public static Stat<ResourceLocation> CONSERVATION_FIREWORKS_SAVED;
    public static Stat<ResourceLocation> DROPS_VOIDED;

    public static ResourceLocation CONSERVATION_FIREWORKS_SAVED_LOCATION = new ResourceLocation(ChromaticEnchantments.MODID, "conservation_fireworks_saved");
    public static ResourceLocation DROPS_VOIDED_LOCATION = new ResourceLocation(ChromaticEnchantments.MODID, "drops_voided");

    public static void registerStats() {
        Registry.register(Registry.CUSTOM_STAT, ModStats.CONSERVATION_FIREWORKS_SAVED_LOCATION, ModStats.CONSERVATION_FIREWORKS_SAVED_LOCATION);
        Registry.register(Registry.CUSTOM_STAT, ModStats.DROPS_VOIDED_LOCATION, ModStats.DROPS_VOIDED_LOCATION);

        CONSERVATION_FIREWORKS_SAVED = Stats.CUSTOM.get(CONSERVATION_FIREWORKS_SAVED_LOCATION);
        DROPS_VOIDED = Stats.CUSTOM.get(DROPS_VOIDED_LOCATION);
    }
}
