package com.st.webapi.controller;

import com.st.webapi.annotation.AuthorCheckAnnotation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author bobo.
 * @date 11/28/2017
 * @email ruantianbo@163.com
 */
@RestController
public class IndexController {


    @GetMapping("/")
    @AuthorCheckAnnotation
    public ModelAndView login() {
        ModelAndView modelAndView = new ModelAndView("index");
        return modelAndView;
    }
}
