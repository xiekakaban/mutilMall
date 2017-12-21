package com.st.mall.service;

import com.st.mall.dao.base.IMapper;
import com.st.mall.dao.customized.ICategoryTagMapper;
import com.st.mall.model.entity.CategoryTag;
import com.st.mall.model.vo.CategoryContentVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author bobo.
 * @date 12/14/2017
 * @email ruantianbo@163.com
 */
@Service
public class CategoryTagService extends AbstractService<CategoryTag> {
    @Autowired
    private ICategoryTagMapper mapper;

    @Override
    public IMapper<CategoryTag> getIMapper() {
        return mapper;
    }


}
