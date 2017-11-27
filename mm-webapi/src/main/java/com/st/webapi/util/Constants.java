package com.st.webapi.util;

import java.io.File;

/**
 * @author bobo.
 * @date 11/27/2017
 * @email ruantianbo@163.com
 */
public class Constants {
    //baserul
    public static final String BASERESOURCEDIR = Constants.class.getClassLoader().getResource(".").getPath();
    // web
    public static final String SESS_USER = "LoginUser";
    //fileStoreBaseUrl
    public static final String BASE_STORE = BASERESOURCEDIR+ File.separator+"store";

}
