package com.st.webapi.controller;

import com.st.model.user.User;
import com.st.service.user.UserService;
import com.st.webapi.annotation.AuthorCheckAnnotation;
import com.st.webapi.util.Constants;
import org.apache.ibatis.io.Resources;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import tk.mybatis.mapper.util.StringUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
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


    @PostMapping("/regiester")
    public ModelAndView register(@Valid User u,BindingResult bindingResult,RedirectAttributes redirectAttributes){
        if(bindingResult.hasErrors()){
            StringBuilder sb = new StringBuilder();
            sb.append("Please check your input:");
            for(FieldError fieldError : bindingResult.getFieldErrors()){
                sb.append(fieldError.getField()).append(",");
            }
            redirectAttributes.addAttribute("info",sb.subSequence(0,sb.length()-2));
            return new ModelAndView("redirect:/user/login?isRegiester=true");
        }
        else{
            userService.insert(u);
            return new ModelAndView("redirect:/");
        }

    }
    private class RegisterCheckResult{
        public String info;
        public Boolean flag = Boolean.TRUE;
    }


    @RequestMapping(value = "/login",method = {RequestMethod.GET,RequestMethod.POST})
    public ModelAndView login(String username, String password, String info,@RequestParam(defaultValue = "false") boolean isRegiester,HttpServletRequest request, HttpSession httpSession,RedirectAttributes redirectAttributes) {
        if(request.getMethod().equalsIgnoreCase("POST")){
            User u = userService.checkLogin(username,password);
            if(u!=null){
                u.setPwd("Eccrypt");
                httpSession.setAttribute(Constants.SESS_USER,u);
                return new ModelAndView("redirect:/");
            }else{
                ModelAndView modelAndView = new ModelAndView("login");
                modelAndView.addObject("info","Please check username/password");
                return modelAndView;
            }
        }
        ModelAndView modelAndView = new ModelAndView("login");
        modelAndView.addObject("info",info);
        modelAndView.addObject("isRegiester",isRegiester);
        return modelAndView;
    }

    @GetMapping("/logout")
    public ModelAndView adminLogout(HttpSession session){
        session.removeAttribute(Constants.SESS_USER);
        return new ModelAndView("redirect:/user/login/");
    }
}
