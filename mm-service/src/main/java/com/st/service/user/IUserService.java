package com.st.service.user;

import com.st.model.user.User;
import com.st.service.IService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Sanmu.
 * @date 11/26/2017
 * @email 1215148017@qq.com
 */
@Service
public interface IUserService extends IService<User> {

    User selectUserByPrimaryKey(Integer key);
    List<User> selectAll();
}
