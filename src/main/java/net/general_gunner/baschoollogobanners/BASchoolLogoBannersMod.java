package net.general_gunner.baschoollogobanners;

import com.mojang.logging.LogUtils;
import net.general_gunner.baschoollogobanners.datagen.ModLangProvider;
import net.general_gunner.baschoollogobanners.datagen.ModTagProvider;
//import net.general_gunner.baschoollogobanners.init.BannerPatternInit;
import net.general_gunner.baschoollogobanners.init.BannerPatternInit;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.DataGenerator;
import net.minecraft.world.level.block.entity.BannerPattern;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.slf4j.Logger;

import static net.general_gunner.baschoollogobanners.init.BannerPatternInit.registerBannerPattern;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(Constants.MOD_ID)
@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class BASchoolLogoBannersMod
{
/*
    // Define mod id in a common place for everything to reference
    public static final String MOD_ID = Constants.MOD_ID;
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();
*/

    // public static final DeferredRegister<BannerPattern> BANNER_PATTERNS = DeferredRegister.create(Registries.BANNER_PATTERN, Constants.MOD_ID);
    public BASchoolLogoBannersMod(FMLJavaModLoadingContext context)
    {
        IEventBus modEventBus = context.getModEventBus();
        Constants.LOG.info("Hello world!");
        BannerPatternInit.loadClass();
        // BannerPatternInit.loadClass();
        /*modEventBus.addListener(this::setup);

        BANNER_PATTERNS.register(modEventBus);*/
    }


    @SubscribeEvent
    public static void onGatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
        boolean includeServer = event.includeServer();
        generator.addProvider(event.includeClient(), new ModLangProvider(generator.getPackOutput()));
        generator.addProvider(includeServer, new ModTagProvider.BannerPatterns(generator.getPackOutput(),event.getLookupProvider(), existingFileHelper));
    }


    /*private void setup(final FMLCommonSetupEvent event)
    {
        BANNER_PATTERNS.register("pattern_abydos", () -> new BannerPattern("pattern_abydos"));
        BANNER_PATTERNS.register("pattern_arius", () -> new BannerPattern("pattern_arius"));
        BANNER_PATTERNS.register("pattern_gehenna", () -> new BannerPattern("pattern_gehenna"));
        BANNER_PATTERNS.register("pattern_gsc", () -> new BannerPattern("pattern_gsc"));
        BANNER_PATTERNS.register("pattern_highlander", () -> new BannerPattern("pattern_highlander"));
        BANNER_PATTERNS.register("pattern_hyakkiyako", () -> new BannerPattern("pattern_hyakkiyako"));
        BANNER_PATTERNS.register("pattern_millennium", () -> new BannerPattern("pattern_millennium"));
        BANNER_PATTERNS.register("pattern_redwinter", () -> new BannerPattern("pattern_redwinter"));
        BANNER_PATTERNS.register("pattern_schale", () -> new BannerPattern("pattern_schale"));
        BANNER_PATTERNS.register("pattern_srt", () -> new BannerPattern("pattern_srt"));
        BANNER_PATTERNS.register("pattern_trinity", () -> new BannerPattern("pattern_trinity"));
        BANNER_PATTERNS.register("pattern_valkyrie", () -> new BannerPattern("pattern_valkyrie"));
    }
    public static RegistryObject<BannerPattern> registerBannerPattern(String name) {
        return BANNER_PATTERNS.register(name, () -> new BannerPattern(name));
    }*/

    // Add the example block item to the building blocks tab
    private void addCreative(BuildCreativeModeTabContentsEvent event)
    {
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {

    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = Constants.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {

        }
    }
}
