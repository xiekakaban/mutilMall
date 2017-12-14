package com.st.vo;

import com.st.model.CategoryTag;
import com.st.model.Domain;
import com.st.model.Product;
import com.st.model.ProductTag;

import java.util.List;

/**
 * @author bobo.
 * @date 12/14/2017
 * @email ruantianbo@163.com
 */
public class ProductDetailVO{

    private Product product;
    private List<ProductTag> productTags;
    private List<CategoryTag> categoryTags;

    public ProductDetailVO(Product product, List<ProductTag> productTags, List<CategoryTag> categoryTags) {
        this.product = product;
        this.productTags = productTags;
        this.categoryTags = categoryTags;
    }

    public List<ProductTag> getProductTags() {
        return productTags;
    }

    public void setProductTags(List<ProductTag> productTags) {
        this.productTags = productTags;
    }

    public List<CategoryTag> getCategoryTags() {
        return categoryTags;
    }

    public void setCategoryTags(List<CategoryTag> categoryTags) {
        this.categoryTags = categoryTags;
    }
}
