package com.st.service;

import com.st.dao.base.IMapper;
import com.st.dao.customized.IUserMapper;
import com.st.mall.common.util.SecurityUtil;
import com.st.model.User;
import com.st.service.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author Sanmu.
 * @date 11/26/2017
 * @email 1215148017@qq.com
 */
@Service
public class UserService extends AbstractService<User> {

    @Autowired
    private IUserMapper mapper;

    public UserService() {

    }

    public User selectUserByPrimaryKey(Integer key) {
        return selectByPrimaryKey(key);
    }

    @Override
    public List<User> selectAll() {
        return super.selectAll();
    }

    @Override
    public IMapper<User> getIMapper() {
        return mapper;
    }

    @Override
    public int insert(User record) {
        record.setPwd(SecurityUtil.eccryptMD5(record.getPwd()));
        record.setCreateTime(new Date());
        record.setLastModifyTime(new Date());
        record.setAvatar("default.jpg");
        return super.insert(record);
    }

    @Override
    public int updateByPrimaryKeySelective(User record) {
        if(record.getPwd() != null) {
            record.setPwd(SecurityUtil.eccryptMD5(record.getPwd()));
        }
        record.setLastModifyTime(new Date());
        return super.updateByPrimaryKeySelective(record);
    }

}
