package com.st.service;

import com.st.dao.base.IMapper;
import com.st.dao.customized.IProductMapper;
import com.st.model.Product;
import com.st.model.ProductTag;
import com.st.vo.ProductDetailVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Condition;
import tk.mybatis.mapper.entity.Example;

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

//    public ProductDetailVO getProductDetailById(int productId){
//        Product p = mapper.selectByPrimaryKey(productId);
//        new Condition(ProductTag.class).createCriteria().andCondition("product.");
//        ProductTag pTags = productTagService.selectOneByExample();
//        Category cTags = categoryTagService.selectOneByExample()
//        ProductDetailVO v = new ProductDetailVO();
//
//
//    }
}
