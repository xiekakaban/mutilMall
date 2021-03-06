package com.st.mall.service;

import com.st.mall.dao.base.IMapper;
import com.st.mall.dao.customized.IProductMapper;
import com.st.mall.model.entity.Product;
import com.st.mall.model.vo.ProductCommentVO;
import com.st.mall.model.vo.ProductContentVO;
import com.st.mall.model.vo.ProductDetailVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author bobo.
 * @date 12/14/2017
 * @email ruantianbo@163.com
 */
@Service
public class ProductService extends AbstractService<Product> {

    @Autowired
    private IProductMapper mapper;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ProductTagService productTagService;

    @Autowired
    private CategoryTagService categoryTagService;


    public ProductService(){

    }
    @Override
    public IMapper<Product> getIMapper() {
        return mapper;
    }

    public ProductDetailVO selectOneProductDetailVOByPrimaryKey(Object key){
        return mapper.getProductDetailByProductId(key);
    }

    public ProductContentVO selectOneProductContentByPrimaryKey(Object key){
        return mapper.getProductContent(key);
    }

    public List<ProductCommentVO> selectOneProductCommentsByPrimarykey(Object key){
        return mapper.getProductComments(key);
    }


}
