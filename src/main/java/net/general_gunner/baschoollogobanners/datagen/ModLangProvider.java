package net.general_gunner.baschoollogobanners.datagen;

import com.google.common.collect.ImmutableMap;
import net.general_gunner.baschoollogobanners.Constants;
import net.general_gunner.baschoollogobanners.init.BannerPatternInit;
import net.minecraft.data.PackOutput;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BannerPattern;
import net.minecraftforge.common.data.LanguageProvider;
import net.minecraftforge.registries.RegistryObject;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static net.minecraft.world.level.block.entity.BlockEntity.addEntityType;

public class ModLangProvider extends LanguageProvider {
    protected static final Map<String, String> REPLACE_LIST = ImmutableMap.of(
            "tnt", "TNT",
            "sus", ""
    );

    public ModLangProvider(PackOutput gen) {
        super(gen, Constants.MOD_ID, "en_us");
    }

    @Override
    protected void addTranslations() {
        BannerPatternInit.BANNER_PATTERNS.getEntries().forEach(this::bannerPatternLang);
    }

    private void bannerPatternLang(RegistryObject<BannerPattern> entry) {
        for(DyeColor color : DyeColor.values()){
            add("block.minecraft.banner."+entry.getId().getNamespace()+"." + entry.getId().getPath() + "." + color.getName(), checkReplace(color.getName()) + " " + checkReplace(entry));
        }
    }


    protected void blockLang(RegistryObject<Block> entry) {
        addBlock(entry, checkReplace(entry));
    }

    protected void entityLang(RegistryObject<EntityType<?>> entry) {
        addEntityType(entry, checkReplace(entry));
    }


    protected String checkReplaceBannerItem(RegistryObject<?> registryObject) {
        return Arrays.stream(registryObject.getId().getPath().split("_"))
                .filter(s -> !s.isBlank() && List.of("banner", "pattern").contains(s))
                .map(this::checkReplace)
                .collect(Collectors.joining(" "))
                .trim();
    }
    protected String checkReplaceBannerItemDesc(RegistryObject<?> registryObject) {
        return Arrays.stream(registryObject.getId().getPath().split("_"))
                .filter(s -> !s.isBlank() && !List.of("banner", "pattern").contains(s))
                .map(this::checkReplace)
                .collect(Collectors.joining(" "))
                .trim();
    }

    protected String checkReplace(RegistryObject<?> registryObject) {
        return Arrays.stream(registryObject.getId().getPath().split("_"))
                .map(this::checkReplace)
                .filter(s -> !s.isBlank())
                .collect(Collectors.joining(" "))
                .trim();
    }

    protected String checkReplace(String string) {
        return REPLACE_LIST.containsKey(string) ? REPLACE_LIST.get(string) : StringUtils.capitalize(string);
    }
}