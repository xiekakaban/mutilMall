package com.st.mall.common.service;

import com.st.mall.common.entity.UserEntity;

/**
 * Created by e604845 on 11/14/2017.
 */
public interface UserService{
    UserEntity findUserById(String id);
}
