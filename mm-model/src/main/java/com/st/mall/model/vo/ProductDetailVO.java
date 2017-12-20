package com.st.mall.model.vo;

import com.st.mall.model.entity.Product;
import com.st.mall.model.entity.ProductTag;

import java.util.List;

/**
 * @author bobo.
 * @date 12/14/2017
 * @email ruantianbo@163.com
 */
public class ProductDetailVO extends Product {

    CategoryDetailVO categoryDetailVO;

    List<ProductTag> productTags;

    public CategoryDetailVO getCategoryDetailVO() {
        return categoryDetailVO;
    }

    public void setCategoryDetailVO(CategoryDetailVO categoryDetailVO) {
        this.categoryDetailVO = categoryDetailVO;
    }

    public List<ProductTag> getProductTags() {
        return productTags;
    }

    public void setProductTags(List<ProductTag> productTags) {
        this.productTags = productTags;
    }
}
