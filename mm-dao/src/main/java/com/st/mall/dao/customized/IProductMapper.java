package com.st.mall.dao.customized;

import com.st.mall.dao.base.IMapper;
import com.st.mall.model.entity.Product;
import com.st.mall.model.vo.ProductCommentVO;
import com.st.mall.model.vo.ProductContentVO;
import com.st.mall.model.vo.ProductDetailVO;

import java.util.List;

/**
 * @author bobo.
 * @date 12/13/2017
 * @email ruantianbo@163.com
 */
public interface IProductMapper extends IMapper<Product> {

    ProductDetailVO getProductDetailByProductId(Object key);

    ProductContentVO getProductContent(Object key);

    List<ProductCommentVO> getProductComments(Object key);
}
