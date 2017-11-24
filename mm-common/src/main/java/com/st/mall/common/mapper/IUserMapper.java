package com.st.mall.common.mapper;

import com.st.mall.common.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * Created by e604845 on 11/21/2017.
 */
public interface IUserMapper {

    UserEntity selectUserById(String id);
}
