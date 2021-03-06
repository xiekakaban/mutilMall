package com.st.mall.dao.customized;

import com.st.mall.dao.base.IMapper;
import com.st.mall.model.entity.User;
import com.st.mall.model.vo.UserWithGrantVO;

/**
 * @author Sanmu.
 * @date 11/26/2017
 * @email 1215148017@qq.com
 */
public interface IUserMapper extends IMapper<User> {

    UserWithGrantVO getUserWithGrantByUserName(String username);

}
