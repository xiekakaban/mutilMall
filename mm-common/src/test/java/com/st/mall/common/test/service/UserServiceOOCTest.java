package com.st.mall.common.test.service;

import com.google.gson.Gson;
import com.st.mall.common.entity.UserEntity;
import com.st.mall.common.service.UserService;
import com.st.mall.common.test.BaseOOCTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 * Created by e604845 on 11/14/2017.
 */
public class UserServiceOOCTest extends BaseOOCTest{

    @Autowired
    private UserService userService;

    @Test
    public void testFindUserEntityById(){
        UserEntity u = userService.findUserById("9999");
        Gson gson = new Gson();
        System.out.println(gson.toJson(u));
    }

}
