package net.general_gunner.baschoollogobanners.datagen;

import net.general_gunner.baschoollogobanners.BASchoolLogoBannersMod;
import net.general_gunner.baschoollogobanners.Constants;
import net.general_gunner.baschoollogobanners.init.BannerPatternInit;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.BannerPatternTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.Registry;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.BannerPatternTagsProvider;
import net.minecraft.data.tags.TagsProvider;
import net.minecraft.tags.BannerPatternTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;
import java.util.function.Supplier;

public class ModTagProvider {

    public static class BannerPatterns extends BannerPatternTagsProvider {

        public BannerPatterns(PackOutput pGenerator, CompletableFuture<HolderLookup.Provider> completableFuture, @Nullable ExistingFileHelper existingFileHelper) {
            super(pGenerator, completableFuture, Constants.MOD_ID, existingFileHelper);
        }

        @Override
        protected void addTags(HolderLookup.Provider pProvider) {
            tag(BannerPatternTags.NO_ITEM_REQUIRED).add(BannerPatternInit.PATTERN_ABYDOS.getKey(),
                    BannerPatternInit.PATTERN_ARIUS.getKey(),
                    BannerPatternInit.PATTERN_GEHENNA.getKey(),
                    BannerPatternInit.PATTERN_GSC.getKey(),
                    BannerPatternInit.PATTERN_HIGHLANDER.getKey(),
                    BannerPatternInit.PATTERN_HYAKKIYAKO.getKey(),
                    BannerPatternInit.PATTERN_MILLENNIUM.getKey(),
                    BannerPatternInit.PATTERN_REDWINTER.getKey(),
                    BannerPatternInit.PATTERN_SCHALE.getKey(),
                    BannerPatternInit.PATTERN_SRT.getKey(),
                    BannerPatternInit.PATTERN_TRINITY.getKey(),
                    BannerPatternInit.PATTERN_VALKYRIE.getKey());
        }
    }
}
