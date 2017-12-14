package com.st.service;

import com.st.dao.base.IMapper;
import com.st.dao.customized.IProductTagMapper;
import com.st.model.ProductTag;
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
