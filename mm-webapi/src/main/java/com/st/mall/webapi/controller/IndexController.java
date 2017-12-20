package com.st.mall.webapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author bobo.
 * @date 11/28/2017
 * @email ruantianbo@163.com
 */
@RestController
public class IndexController {

    @Autowired
    private MessageSource messageSource;




//    @GetMapping("/")
//    public ModelAndView index() {
//        ModelAndView modelAndView = new ModelAndView("index");
//        return modelAndView;
//    }
//    @GetMapping("/version")
//    @AuthorCheckAnnotation
//    public ModelAndView version(){
//        ModelAndView modelAndView = new ModelAndView("version");
//        return modelAndView;
//    }

}
