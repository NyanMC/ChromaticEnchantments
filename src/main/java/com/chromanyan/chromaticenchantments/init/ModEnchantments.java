package com.chromanyan.chromaticenchantments.init;

import com.chromanyan.chromaticenchantments.ChromaticEnchantments;
import com.chromanyan.chromaticenchantments.enchantments.*;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEnchantments {

    public static final DeferredRegister<Enchantment> ENCHANTMENTS_REGISTRY = DeferredRegister.create(ForgeRegistries.ENCHANTMENTS, ChromaticEnchantments.MODID);

    public static final RegistryObject<Enchantment> STARSHOT = ENCHANTMENTS_REGISTRY.register("starshot", StarshotEnchantment::new);
    public static final RegistryObject<Enchantment> CONSERVATION = ENCHANTMENTS_REGISTRY.register("conservation", ConservationEnchantment::new);
    public static final RegistryObject<Enchantment> VOIDING_CURSE = ENCHANTMENTS_REGISTRY.register("voiding_curse", VoidingCurseEnchantment::new);
    public static final RegistryObject<Enchantment> PERSISTENCE = ENCHANTMENTS_REGISTRY.register("persistence", PersistenceEnchantment::new);
    public static final RegistryObject<Enchantment> RIDING = ENCHANTMENTS_REGISTRY.register("riding", RidingEnchantment::new);
}
