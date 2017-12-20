package com.st.mall.webapi.controller;

import com.st.mall.model.entity.CategoryTag;
import com.st.mall.model.entity.Category;
import com.st.mall.model.vo.CategoryDetailVO;
import com.st.mall.service.CategoryService;
import com.st.mall.service.CategoryTagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

/**
 * @author bobo.
 * @date 12/19/2017
 * @email ruantianbo@163.com
 */
@RestController
@RequestMapping("/v1/categorys")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @Autowired
    private CategoryTagService categoryTagService;

    @RequestMapping(value = "/",method = RequestMethod.POST)
    public void addCategory(@RequestBody Category category){
        category.setCreateTime(new Date());
        category.setLastModifyTime(new Date());
        categoryService.insert(category);
    }
    @RequestMapping(value = "/{categoryId:[^categoryTags]}",method = RequestMethod.DELETE)
    public void deleteCategory(@PathVariable Integer categoryId){
        categoryService.deleteByPrimaryKey(categoryId);
    }

    @RequestMapping(value = "/",method = RequestMethod.PUT)
    public void modifyCategory(@RequestBody Category category){
        categoryService.updateByPrimaryKeySelective(category);
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<Category> findCategorys(){
        return categoryService.selectAll();
    }

    @RequestMapping(value = "/{categoryId}" , method = RequestMethod.GET)
    public Category findOneCategory(@PathVariable("categoryId") Integer categoryId,@RequestParam(value = "detail",defaultValue="false") Boolean detail){
        if(detail){
            return categoryService.selectCategoryDetailByPrimaryKey(categoryId);
        }else{
            return categoryService.selectByPrimaryKey(categoryId);
        }
    }

    /****************************Category Tag**********************************/

    @RequestMapping(value = "/{categoryId}/categoryTags",method = RequestMethod.POST)
    public void addCategoryTag(@RequestBody CategoryTag categoryTag,@PathVariable("categoryId") Integer categoryId){
        categoryTag.setCategoryId(categoryId);
        categoryTag.setCreateTime(new Date());
        categoryTag.setLastModifyTime(new Date());
        categoryTagService.insert(categoryTag);
    }

    @RequestMapping(value = "/categoryTags/{categoryTagId}",method = RequestMethod.DELETE)
    public void deleteCategoryTag(@PathVariable Integer categoryTagId){
        categoryTagService.deleteByPrimaryKey(categoryTagId);
    }

    @RequestMapping(value = "/categoryTags",method = RequestMethod.PUT)
    public void modifyCategoryTag(@RequestBody CategoryTag categoryTag){
        categoryTagService.updateByPrimaryKeySelective(categoryTag);
    }

    @RequestMapping(value = "/{categoryId}/categoryTags",method = RequestMethod.GET)
    public List<CategoryTag> findAllCategoryTags(@PathVariable("categoryId") Integer categoryId){
        return categoryTagService.selectAll();
    }

    @RequestMapping(value = "/categoryTags",method = RequestMethod.GET)
    public List<CategoryTag> findAllCategory(){
        return categoryTagService.selectAll();
    }


}
