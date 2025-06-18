package com.general_gunner.baschoollogobanners.init;

import com.general_gunner.baschoollogobanners.Constants;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BannerPattern;

public class TagInit {

    public static void loadClass() {

    }

    public static TagKey<Block> blockTag(String path) {
        return TagKey.create(Registries.BLOCK, new ResourceLocation(Constants.MOD_ID, path));
    }

    public static TagKey<BannerPattern> bannerPatternTag(String path) {
        return TagKey.create(Registries.BANNER_PATTERN, new ResourceLocation(Constants.MOD_ID, path));
    }

}
