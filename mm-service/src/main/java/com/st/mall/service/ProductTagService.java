package com.st.mall.service;

import com.st.mall.dao.base.IMapper;
import com.st.mall.dao.customized.IProductTagMapper;
import com.st.mall.model.entity.ProductTag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author bobo.
 * @date 12/14/2017
 * @email ruantianbo@163.com
 */
@Service
public class ProductTagService extends AbstractService<ProductTag> {

    @Autowired
    private IProductTagMapper mapper;

    @Override
    public IMapper<ProductTag> getIMapper() {
        return mapper;
    }
}
