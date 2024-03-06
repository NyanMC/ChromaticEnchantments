package com.chromanyan.chromaticenchantments.init;

import com.chromanyan.chromaticenchantments.ChromaticEnchantments;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

public class ModTags {

    public static class Items {
        /**
         * Items which should be considered elytras for enchantments only applicable to elytras such as Conservation.
         */
        public static final TagKey<Item> ELYTRAS = ItemTags.create(new ResourceLocation(ChromaticEnchantments.MODID, "elytras"));
    }

}
