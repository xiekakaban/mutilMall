package com.st.webapi.controller;

import com.st.model.user.User;
import com.st.service.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Sanmu.
 * @date 11/26/2017
 * @email 1215148017@qq.com
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    IUserService userService;

    @RequestMapping("/{userID}")
    public User selectOne(@PathVariable("userID") Integer userID) {
        return userService.selectUserByPrimaryKey(userID);
    }

    @RequestMapping
    public List<User> selectAll() {
        return userService.selectAll();
    }

}
