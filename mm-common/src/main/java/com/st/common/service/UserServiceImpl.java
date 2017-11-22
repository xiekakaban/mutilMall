package com.st.common.service;

import com.st.common.entity.UserEntity;
import org.springframework.stereotype.Service;

/**
 * Created by e604845 on 11/14/2017.
 */
@Service("userService")
public class UserServiceImpl  implements UserService  {


    @Override
    public UserEntity findUserById(String id) {
        return null;
    }
}
