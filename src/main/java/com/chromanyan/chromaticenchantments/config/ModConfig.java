package com.chromanyan.chromaticenchantments.config;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.common.ForgeConfigSpec.*;
import org.apache.commons.lang3.tuple.Pair;

public class ModConfig {

    public static class Common {
        public final IntValue conservationMaxLevel;
        public final DoubleValue conservationChance;
        public final BooleanValue strictElytraCheck;

        public final BooleanValue strictVoidingCheck;

        public final BooleanValue loosePersistenceCheck;

        public Common(ForgeConfigSpec.Builder builder) {
            builder.push("ConservationEnchantmentSettings");
                conservationMaxLevel = builder
                        .comment("The maximum level for the Conservation enchantment.")
                        .defineInRange("conservationMaxLevel", 4, 1, Integer.MAX_VALUE);
                conservationChance = builder
                        .comment("The chance for a firework to not be consumed, multiplied by the enchantment level. 1 is equal to a 100% chance. Setting to 0 effectively disables the enchantment.")
                        .defineInRange("conservationChance", 0.05, 0, 1);
                strictElytraCheck = builder
                        .comment("If set to true, this enchantment will only be applicable to items in the chromaticenchantments:elytras tag.")
                        .define("strictElytraCheck", false);
            builder.pop();
            builder.push("VoidingCurseSettings");
                strictVoidingCheck = builder
                        .comment("If set to true, this enchantment will only be applicable to items in the chromaticenchantments:voiding_applicable tag.")
                        .define("strictVoidingCheck", false);
            builder.pop();
            builder.push("PersistenceSettings");
            loosePersistenceCheck = builder
                    .comment("If set to true, this enchantment will be applicable to any item that has a maximum stack size of 1. This config option is buggy, do not expect support for any issues it causes.")
                    .define("loosePersistenceCheck", false);
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
