package com.st.service;

import com.st.dao.base.IMapper;
import com.st.dao.customized.ICategoryMapper;
import com.st.model.Category;
import com.st.service.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author bobo.
 * @date 12/14/2017
 * @email ruantianbo@163.com
 */
@Service
public class CategoryService extends AbstractService<Category> {

    @Autowired
    private ICategoryMapper mapper;

    @Override
    public IMapper<Category> getIMapper() {
        return null;
    }

}
