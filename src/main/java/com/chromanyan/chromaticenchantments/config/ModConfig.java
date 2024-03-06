package com.chromanyan.chromaticenchantments.config;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.common.ForgeConfigSpec.*;
import org.apache.commons.lang3.tuple.Pair;

public class ModConfig {

    public static class Common {
        public final IntValue conservationMaxLevel;
        public final DoubleValue conservationChance;
        public final BooleanValue strictElytraCheck;

        public Common(ForgeConfigSpec.Builder builder) {
            builder.push("ConservationEnchantmentSettings");
                conservationMaxLevel = builder
                        .comment("The maximum level for the Conservation enchantment.")
                        .defineInRange("conservationMaxLevel", 4, 1, Integer.MAX_VALUE);
                conservationChance = builder
                        .comment("The chance for a firework to not be consumed, multiplied by the enchantment level. 1 is equal to a 100% chance. Setting to 0 effectively disables the enchantment.")
                        .defineInRange("conservationChance", 0.05, 0, 1);
                strictElytraCheck = builder
                        .comment("By default, when checking if this enchantment can be applied to an item, it checks if the an is part of the chromaticenchantments:elytras tag, and then if it is an instancof ElytraItem. Set this to true to disable the second check. If you have no idea what any of that means, you shouldn't be touching this value.")
                        .define("strictElytraCheck", false);
            builder.pop();
        }
    }

    public static final ForgeConfigSpec commonSpec;
    public static final Common COMMON;

    static {
        final Pair<Common, ForgeConfigSpec> specPair = new ForgeConfigSpec.Builder().configure(Common::new);
        commonSpec = specPair.getRight();
        COMMON = specPair.getLeft();
    }
}
