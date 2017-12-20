package com.st.mall.webapi.controller;

import com.st.mall.model.entity.Product;
import com.st.mall.service.ProductTagService;
import com.st.mall.model.entity.ProductTag;
import com.st.mall.service.ProductService;
import com.st.mall.model.vo.ProductDetailVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public void addProduct(@RequestBody Product product){
        productService.insert(product);
    }

    /**Product Delete*/
    @RequestMapping(value = "/{productId}", method = RequestMethod.DELETE)
    public void deleteProduct(@PathVariable("productId") Integer productId) {
        productService.deleteByPrimaryKey(productId);
    }

    /**Product Modify*/
    @RequestMapping(value="/",method = RequestMethod.PUT)
    public void UpdateProduct(@RequestBody Product product){
        productService.updateByPrimaryKeySelective(product);
    }

    /**Product Select One*/
    @RequestMapping(value="/{productId}",method = RequestMethod.GET)
    public Product findOneProduct(@PathVariable("productId") Integer productId,@RequestParam(value = "detail", defaultValue = "false") Boolean detail){
        if(detail){
            return productService.selectOneProductDetailVOByPrimaryKey(productId);
        }else {
            return productService.selectByPrimaryKey(productId);
        }
    }

    /**Product Select All*/
    @RequestMapping(value="/",method = RequestMethod.GET)
    public List<Product> findAllProducts() {
        return productService.selectAll();
    }

    /****************************** Product Tag **********************************************/

    /**Product Tag Add*/
    @RequestMapping(value="/productTags",method = RequestMethod.POST)
    public void addProductTag(@RequestBody ProductTag productTag){
        productTagService.insert(productTag);
    }
    /**Product Tag Delete*/
    @RequestMapping(value="/productTags/{productTagId}",method = RequestMethod.DELETE)
    public void deleteProductTag(@PathVariable("productTagId") Integer productTagId){
        productTagService.deleteByPrimaryKey(productTagId);
    }

    /**Product Tag Modify*/
    @RequestMapping(value="/productTags",method = RequestMethod.PUT)
    public void modifyProductTag(@RequestBody ProductTag productTag){
        productTagService.updateByPrimaryKeySelective(productTag);
    }

    @RequestMapping(value = "/productTags/{productTagId}",method = RequestMethod.GET)
    public ProductTag findOneProductTag(@PathVariable("productTagId") Integer productTagId){
        return productTagService.selectByPrimaryKey(productTagId);
    }

    /**Product Tag Select ALl*/
    @RequestMapping(value = "/productTags",method = RequestMethod.GET)
    public List<ProductTag> findAllProductTags(){
        return productTagService.selectAll();
    }

    /**************************Product Detail **************/
    @RequestMapping(value="/detail/{productDetailId}",method = RequestMethod.GET)
    public ProductDetailVO findOneProductDetail(@PathVariable("productDetailId") Integer productDetailId){
        return productService.selectOneProductDetailVOByPrimaryKey(productDetailId);
    }




}
