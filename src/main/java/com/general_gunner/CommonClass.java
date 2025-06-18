package com.general_gunner;

import com.general_gunner.baschoollogobanners.init.BannerPatternInit;
import com.general_gunner.baschoollogobanners.init.TagInit;

public class CommonClass {

    public static void init() {
        BannerPatternInit.loadClass();
        TagInit.loadClass();
    }
}
