package com.st.mall.service;

import com.st.mall.dao.base.IMapper;
import com.st.mall.dao.customized.ICategoryMapper;
import com.st.mall.model.entity.Category;
import com.st.mall.model.vo.CategoryContentVO;
import com.st.mall.model.vo.CategoryDetailVO;
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
        return mapper;
    }

    public CategoryDetailVO selectCategoryDetailByPrimaryKey(Object key){
        return mapper.selectCategoryDetailByPrimaryKey(key);
    }

    public CategoryContentVO selectCategoryContentByPrimaryKey(Object key){
        return mapper.getCategoryContent(key);
    }


}
