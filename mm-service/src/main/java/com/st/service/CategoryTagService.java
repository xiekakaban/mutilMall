package com.st.service;

import com.st.dao.base.IMapper;
import com.st.dao.customized.ICategoryTagMapper;
import com.st.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author bobo.
 * @date 12/14/2017
 * @email ruantianbo@163.com
 */
@Service
public class CategoryTagService extends AbstractService<Category> {
    @Autowired
    private ICategoryTagMapper mapper;

    @Override
    public IMapper<Category> getIMapper() {
        return mapper;
    }
}
