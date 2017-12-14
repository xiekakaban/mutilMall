package com.st.webapi.controller;

import com.st.model.Product;
import com.st.service.ProductService;
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

    @RequestMapping(value = "/",method= RequestMethod.POST)
    public void addProduct(@RequestBody Product product){
        productService.insert(product);
    }

    @RequestMapping(value = "/{productId}",method = RequestMethod.DELETE)
    public void deleteProduct(@PathVariable("productId") Integer productId){
        productService.deleteByPrimaryKey(productId);
    }

    @RequestMapping(value="/",method = RequestMethod.PUT)
    public void UpdateProduct(@RequestBody Product product){
        productService.updateByPrimaryKeySelective(product);
    }
    @RequestMapping(value="/{productId}",method = RequestMethod.GET)
    public Product findOneProduct(@PathVariable("productId") Integer productId){
        return productService.selectByPrimaryKey(productId);
    }
    @RequestMapping(value="/",method = RequestMethod.GET)
    public List<Product> findAllProducts() {
        return productService.selectAll();
    }
}
