package com.st.service.user;

import com.st.dao.base.IMapper;
import com.st.dao.customized.user.IUserMapper;
import com.st.model.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Sanmu.
 * @date 11/26/2017
 * @email 1215148017@qq.com
 */
@Service
public class UserService implements IUserService {

    @Autowired
    private IUserMapper mapper;

    @Override
    public User selectUserByPrimaryKey(Integer key) {
        return mapper.selectByPrimaryKey(key);
    }

    @Override
    public List<User> selectAll() {
        return mapper.selectAll();
    }

    @Override
    public IMapper<User> getIMapper() {
        return mapper;
    }
}
