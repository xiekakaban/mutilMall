package com.st.common.mapper;

import com.st.common.entity.UserEntity;

/**
 * Created by e604845 on 11/21/2017.
 */
public interface IUserInterface {

    public UserEntity selectUserById(int id);
}
