package com.st.mall.dao.customized;

import com.st.mall.dao.base.IMapper;
import com.st.mall.model.entity.Category;
import com.st.mall.model.vo.CategoryContentVO;
import com.st.mall.model.vo.CategoryDetailVO;

/**
 * @author bobo.
 * @date 12/13/2017
 * @email ruantianbo@163.com
 */
public interface ICategoryMapper extends IMapper<Category> {

    CategoryDetailVO selectCategoryDetailByPrimaryKey(Object key);
    CategoryDetailVO selectCategoryDetailByCategory(Category category);

    CategoryContentVO getCategoryContent(Object key);

}
