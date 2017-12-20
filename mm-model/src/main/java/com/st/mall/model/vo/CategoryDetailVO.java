package com.st.mall.model.vo;

import com.st.mall.model.entity.Category;
import com.st.mall.model.entity.CategoryTag;

import java.util.List;

/**
 * @author bobo.
 * @date 12/19/2017
 * @email ruantianbo@163.com
 */
public class CategoryDetailVO extends Category{

    List<CategoryTag> categoryTags;

    public List<CategoryTag> getCategoryTags() {
        return categoryTags;
    }

    public void setCategoryTags(List<CategoryTag> categoryTags) {
        this.categoryTags = categoryTags;
    }
}
