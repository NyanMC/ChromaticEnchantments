package com.chromanyan.chromaticenchantments.init;

import com.chromanyan.chromaticenchantments.ChromaticEnchantments;
import com.chromanyan.chromaticenchantments.enchantments.StarshotEnchantment;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEnchantments {
    public static final DeferredRegister<Enchantment> ENCHANTMENTS_REGISTRY = DeferredRegister.create(ForgeRegistries.ENCHANTMENTS, ChromaticEnchantments.MODID);

    public static final RegistryObject<Enchantment> STARSHOT = ENCHANTMENTS_REGISTRY.register("starshot", StarshotEnchantment::new);
}