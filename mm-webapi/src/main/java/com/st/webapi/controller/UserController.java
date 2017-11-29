package com.st.webapi.controller;

import com.st.model.user.User;
import com.st.service.user.UserService;
import com.st.webapi.annotation.AuthorCheckAnnotation;
import com.st.webapi.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author Sanmu.
 * @date 11/26/2017
 * @email 1215148017@qq.com
 */
@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/{userID}")
    public User selectOne(@PathVariable("userID") Integer userID) {
        return userService.selectUserByPrimaryKey(userID);
    }

    @RequestMapping
    public List<User> selectAll() {
        return userService.selectAll();
    }

    @RequestMapping(value = "/login",method = {RequestMethod.GET,RequestMethod.POST})
    public ModelAndView login(String username, String password, HttpServletRequest request, HttpSession httpSession,RedirectAttributes redirectAttributes) {
        if(request.getMethod().equalsIgnoreCase("POST")){
            User u = userService.checkLogin(username,password);
            if(u!=null){
                u.setPwd("Eccrypt");
                httpSession.setAttribute(Constants.SESS_USER,u);
                return new ModelAndView("index");
            }else{
                redirectAttributes.addFlashAttribute("Please check username/password");
                return new ModelAndView("redirect:/user/login");
            }
        }
        ModelAndView modelAndView = new ModelAndView("login");
        return modelAndView;
    }

    @GetMapping("/logout")
    public ModelAndView adminLogout(HttpSession session){
        session.removeAttribute(Constants.SESS_USER);
        return new ModelAndView("redirect:/user/login/");
    }






}
