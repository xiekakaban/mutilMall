package com.st.mall.common.service;

import com.st.mall.common.entity.UserEntity;
import com.st.mall.common.mapper.IUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * Created by e604845 on 11/14/2017.
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private IUserMapper userMapper;

    @Override
    public UserEntity findUserById(String id) {
        return userMapper.selectUserById(id);
    }
}
