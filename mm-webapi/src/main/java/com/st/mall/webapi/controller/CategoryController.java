package com.st.mall.webapi.controller;

import com.st.mall.model.entity.CategoryTag;
import com.st.mall.model.entity.Category;
import com.st.mall.model.vo.CategoryDetailVO;
import com.st.mall.service.CategoryService;
import com.st.mall.service.CategoryTagService;
import com.st.mall.webapi.entity.ResultBack;
import com.st.mall.webapi.util.ResultBackUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResultBack addCategory(@RequestBody Category category){
        category.setCreateTime(new Date());
        category.setLastModifyTime(new Date());
        categoryService.insert(category);
        return ResultBackUtil.success();

    }
    @RequestMapping(value = "/{categoryId:[^categoryTags]}",method = RequestMethod.DELETE)
    public ResultBack deleteCategory(@PathVariable Integer categoryId){
        categoryService.deleteByPrimaryKey(categoryId);
        return ResultBackUtil.success();
    }

    @RequestMapping(value = "/",method = RequestMethod.PUT)
    public ResultBack modifyCategory(@RequestBody Category category){
        categoryService.updateByPrimaryKeySelective(category);
        return ResultBackUtil.success();
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResultBack findCategorys(){
        return ResultBackUtil.success(categoryService.selectAll());
    }

    @RequestMapping(value = "/{categoryId}" , method = RequestMethod.GET)
    public ResultBack findOneCategory(@PathVariable("categoryId") Integer categoryId,@RequestParam(value = "detail",defaultValue="false") Boolean detail){
        return ResultBackUtil.success(categoryService.selectByPrimaryKey(categoryId));
    }

    @RequestMapping(value = "/details/{categoryId}",method = RequestMethod.GET)
    public ResultBack findOneCategoryDetail(@RequestParam(value = "content",defaultValue = "false")Boolean content,@PathVariable("categoryId")Integer categoryId){
        if(content){
            return ResultBackUtil.success(categoryService.selectCategoryContentByPrimaryKey(categoryId));
        }else{
            return ResultBackUtil.success(categoryService.selectCategoryDetailByPrimaryKey(categoryId));
        }
    }

    /****************************Category Tag**********************************/

    @RequestMapping(value = "/{categoryId}/categoryTags",method = RequestMethod.POST)
    public ResultBack addCategoryTag(@RequestBody CategoryTag categoryTag,@PathVariable("categoryId") Integer categoryId){
        categoryTag.setCategoryId(categoryId);
        categoryTag.setCreateTime(new Date());
        categoryTag.setLastModifyTime(new Date());
        categoryTagService.insert(categoryTag);

        return ResultBackUtil.success();
    }

    @RequestMapping(value = "/categoryTags/{categoryTagId}",method = RequestMethod.DELETE)
    public ResultBack deleteCategoryTag(@PathVariable Integer categoryTagId){
        categoryTagService.deleteByPrimaryKey(categoryTagId);
        return ResultBackUtil.success();
    }

    @RequestMapping(value = "/categoryTags",method = RequestMethod.PUT)
    public ResultBack modifyCategoryTag(@RequestBody CategoryTag categoryTag){
        categoryTagService.updateByPrimaryKeySelective(categoryTag);
        return ResultBackUtil.success();
    }

    @RequestMapping(value = "/{categoryId}/categoryTags",method = RequestMethod.GET)
    public ResultBack findAllCategoryTags(@PathVariable("categoryId") Integer categoryId){
        return ResultBackUtil.success(categoryTagService.selectAll());
    }

    @RequestMapping(value = "/categoryTags",method = RequestMethod.GET)
    public ResultBack findAllCategory(){
        return ResultBackUtil.success(categoryTagService.selectAll());
    }



}
