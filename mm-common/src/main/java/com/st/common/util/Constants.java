package com.statestr.mall.util;

import java.io.File;

/**
 * Created by e604845 on 8/12/2017.
 */
public class Constants {
    //baserul
    public static final String BASERESOURCEDIR = Constants.class.getClassLoader().getResource(".").getPath();
    // web
    public static final String ADMINSESS_USER = "AdminLoginUser";
    //fileStoreBaseUrl
    public static final String BASE_STORE = BASERESOURCEDIR+ File.separator+"store";
    //categoryBannerStore
    public static final String CATEGORY_BANNER_STORE = BASE_STORE+ File.separator+"categoryBanner";

}
