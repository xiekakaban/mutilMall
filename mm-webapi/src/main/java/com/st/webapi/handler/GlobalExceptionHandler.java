package com.st.webapi.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.naming.NoPermissionException;

/**
 * @author bobo.
 * @date 11/27/2017
 * @email ruantianbo@163.com
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    private final static Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(value= Exception.class)
    public ModelAndView handler(Exception e, RedirectAttributes redirectAttributes){
        if(e instanceof NoPermissionException){
            return noPermissionExceptionHandler(e,redirectAttributes);
        }else{
            return commonExceptionHandler(e);
        }
    }
    private ModelAndView  noPermissionExceptionHandler(Exception e,RedirectAttributes redirectAttributes){
        ModelAndView modelAndView = new ModelAndView("redirect:/user/login");
        redirectAttributes.addFlashAttribute("loginCheck", "You need Login First.");
        return modelAndView;
    }

    private ModelAndView commonExceptionHandler(Exception e){
        ModelAndView modelAndView = new ModelAndView("redirect:/user/login");
        return modelAndView;
    }
}
