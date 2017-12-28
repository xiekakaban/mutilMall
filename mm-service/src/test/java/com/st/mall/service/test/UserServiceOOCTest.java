package com.st.mall.service.test;

import com.st.mall.model.vo.UserWithGrantVO;
import com.st.mall.service.SprintTestApplication;
import com.st.mall.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author bobo.
 * @date 12/27/2017
 * @email ruantianbo@163.com
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes=SprintTestApplication.class)
public class UserServiceOOCTest {

    @Autowired
    UserService userService;

    @Test
    public void testSelectUserWithGrantByUsername(){
        UserWithGrantVO u = userService.selectUserWithGrantByUsername("tianyeling");
        System.out.println(u.toString());
//        System.out.println("Hello world");
    }
}
