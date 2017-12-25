package com.st.mall.webapi.controller;

import com.st.mall.model.entity.Product;
import com.st.mall.service.ProductTagService;
import com.st.mall.model.entity.ProductTag;
import com.st.mall.service.ProductService;
import com.st.mall.model.vo.ProductDetailVO;
import com.st.mall.webapi.entity.ResultBack;
import com.st.mall.webapi.util.ResultBackUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * @author bobo.
 * @date 12/14/2017
 * @email ruantianbo@163.com
 */
@RestController
@RequestMapping("/v1/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private ProductTagService productTagService;

    /**Product Add*/
    @RequestMapping(value = "/",method= RequestMethod.POST)
    public ResultBack addProduct(@RequestBody Product product){
        productService.insert(product);
        return ResultBackUtil.success();
    }

    /**Product Delete*/
    @RequestMapping(value = "/{productId}", method = RequestMethod.DELETE)
    public ResultBack deleteProduct(@PathVariable("productId") Integer productId) {
        productService.deleteByPrimaryKey(productId);
        return ResultBackUtil.success();
    }

    /**Product Modify*/
    @RequestMapping(value="/",method = RequestMethod.PUT)
    public ResultBack UpdateProduct(@RequestBody Product product){
        productService.updateByPrimaryKeySelective(product);
        return ResultBackUtil.success();
    }

    /**Product Select One*/
    @RequestMapping(value="/{productId}",method = RequestMethod.GET)
    public ResultBack findOneProduct(@PathVariable("productId") Integer productId){
        return ResultBackUtil.success(productService.selectByPrimaryKey(productId));

    }

    /**Product Select All*/
    @RequestMapping(value="/",method = RequestMethod.GET)
    public ResultBack findAllProducts() {
        return ResultBackUtil.success(productService.selectAll());
    }

    /****************************** Product Tag **********************************************/

    /**Product Tag Add*/
    @RequestMapping(value="/{productId}/productTags",method = RequestMethod.POST)
    public ResultBack addProductTag(@PathVariable("productId") Integer productId,@RequestBody ProductTag productTag){
        productTag.setProduct(productId);
        productTag.setCreateTime(new Date());
        productTag.setLastModifyTime(new Date());
        productTagService.insert(productTag);
        return ResultBackUtil.success();
    }
    /**Product Tag Delete*/
    @RequestMapping(value="/productTags/{productTagId}",method = RequestMethod.DELETE)
    public ResultBack deleteProductTag(@PathVariable("productTagId") Integer productTagId){
        productTagService.deleteByPrimaryKey(productTagId);
        return ResultBackUtil.success();
    }

    /**Product Tag Modify*/
    @RequestMapping(value="/productTags",method = RequestMethod.PUT)
    public ResultBack modifyProductTag(@RequestBody ProductTag productTag){
        productTagService.updateByPrimaryKeySelective(productTag);
        return ResultBackUtil.success();
    }

    @RequestMapping(value = "/productTags/{productTagId}",method = RequestMethod.GET)
    public ResultBack findOneProductTag(@PathVariable("productTagId") Integer productTagId){
        return ResultBackUtil.success(productTagService.selectByPrimaryKey(productTagId));

    }

    /**Product Tag Select ALl*/
    @RequestMapping(value = "/productTags",method = RequestMethod.GET)
    public ResultBack findAllProductTags(){
        return ResultBackUtil.success(productTagService.selectAll());
    }

    /**************************Product Detail **************/
    @RequestMapping(value="/details/{productDetailId}",method = RequestMethod.GET)
    public ResultBack findOneProductDetail(@RequestParam(value = "content",defaultValue = "false")Boolean content,@RequestParam(value = "comments",defaultValue = "false")Boolean comments,@PathVariable("productDetailId") Integer productDetailId){
        if(content){
            return ResultBackUtil.success(productService.selectOneProductContentByPrimaryKey(productDetailId));
        }else if(comments){
            return ResultBackUtil.success(productService.selectOneProductCommentsByPrimarykey(productDetailId));
        }
        else{
            return ResultBackUtil.success(productService.selectOneProductDetailVOByPrimaryKey(productDetailId));
        }
    }


}
