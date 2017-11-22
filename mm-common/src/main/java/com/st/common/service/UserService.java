package com.st.common.service;

import com.st.common.entity.UserEntity;

/**
 * Created by e604845 on 11/14/2017.
 */
public interface UserService{
    UserEntity findUserById(String id);
}
