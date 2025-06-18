package net.general_gunner.baschoollogobanners.init;

import net.general_gunner.baschoollogobanners.BASchoolLogoBannersMod;
import net.general_gunner.baschoollogobanners.Constants;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.entity.BannerPattern;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;

public class BannerPatternInit {
    public static final DeferredRegister<BannerPattern> BANNER_PATTERNS = DeferredRegister.create(Registries.BANNER_PATTERN, Constants.MOD_ID);

    public static final RegistryObject<BannerPattern> PATTERN_ABYDOS = registerBannerPattern("pattern_abydos");
    public static final RegistryObject<BannerPattern> PATTERN_ARIUS = registerBannerPattern("pattern_arius");
    public static final RegistryObject<BannerPattern> PATTERN_GEHENNA = registerBannerPattern("pattern_gehenna");
    public static final RegistryObject<BannerPattern> PATTERN_GSC = registerBannerPattern("pattern_gsc");
    public static final RegistryObject<BannerPattern> PATTERN_HIGHLANDER = registerBannerPattern("pattern_highlander");
    public static final RegistryObject<BannerPattern> PATTERN_HYAKKIYAKO = registerBannerPattern("pattern_hyakkiyako");
    public static final RegistryObject<BannerPattern> PATTERN_MILLENNIUM = registerBannerPattern("pattern_millennium");
    public static final RegistryObject<BannerPattern> PATTERN_REDWINTER = registerBannerPattern("pattern_redwinter");
    public static final RegistryObject<BannerPattern> PATTERN_SCHALE = registerBannerPattern("pattern_schale");
    public static final RegistryObject<BannerPattern> PATTERN_SRT = registerBannerPattern("pattern_srt");
    public static final RegistryObject<BannerPattern> PATTERN_TRINITY = registerBannerPattern("pattern_trinity");
    public static final RegistryObject<BannerPattern> PATTERN_VALKYRIE = registerBannerPattern("pattern_valkyrie");

    public static RegistryObject<BannerPattern> registerBannerPattern(String name) {
        return BANNER_PATTERNS.register(name, () -> new BannerPattern(name));
    }

    public static void loadClass() {

    }
}
