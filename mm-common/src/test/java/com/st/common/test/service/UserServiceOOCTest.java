package com.st.common.test.service;

import com.st.common.service.UserService;
import com.st.common.test.BaseOOCTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 * Created by e604845 on 11/14/2017.
 */
public class UserServiceOOCTest extends BaseOOCTest{

    @Autowired
    @Qualifier("userService")
    private UserService userService;

    @Test
    public void testFindUserEntityById(){
        userService.findUserById("");
    }

}
