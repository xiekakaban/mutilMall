package com.st.mutilmall.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Sanmu.
 * @date 11/25/2017
 * @email 1215148017@qq.com
 */
@Controller
public class WelcomeController {


    @RequestMapping("/")
    public String welcome() {
        return "welcome";
    }
}
