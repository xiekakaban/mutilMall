package com.st.webapi.controller;

import com.st.model.User;
import com.st.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Sanmu.
 * @date 11/26/2017
 * @email 1215148017@qq.com
 */
@RestController
@RequestMapping("/v1/users")
public class UserController {
    //Https 协议
    //域名，尽量在 API部署专用服务器下 https://api.example.com/..
    //版本 https://api.example.com/v1
    //网址中不能有动词。要用名词,常用复数。url代表资源的访问
    //Get-Select,Post-Create,Put->Update(提供完整的资源),Patch->Upgate(提供部分资源熟悉),DELETE->(DELETE)
    //过滤信息。api 后面带有参数, ?limit=10, ?offset=10 , ?page=2&per_page=100, sortBy=name&order=asc
    //OAuth2 验证
    //JSON 传输

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/",method=RequestMethod.POST)
    public void addUser(@RequestBody User user){
        userService.insert(user);
    }

    @RequestMapping(value = "/{userId}",method = RequestMethod.DELETE)
    public void deleteUser(@PathVariable("userId") Integer userId){
        userService.deleteByPrimaryKey(userId);
    }

    @RequestMapping(value="/",method = RequestMethod.PUT)
    public void UpdateUser(@RequestBody User user){
        userService.updateByPrimaryKeySelective(user);
    }
    @RequestMapping(value="/{userId}",method = RequestMethod.GET)
    public User findOneUser(@PathVariable("userId") Integer userId){
        return userService.selectUserByPrimaryKey(userId);
    }
    @RequestMapping(value="/",method = RequestMethod.GET)
    public List<User> findAllUsers() {
        return userService.selectAll();
    }



//    @Autowired
//    public UserController(UserService userService) {
//        this.userService = userService;
//    }
//
//    @RequestMapping("/{userID}")
//    public User selectOne(@PathVariable("userID") Integer userID) {
//        return userService.selectUserByPrimaryKey(userID);
//    }
//
//    @RequestMapping
//    public List<User> selectAll() {
//        return userService.selectAll();
//    }
//
//
//    @PostMapping("/regiester")
//    public ModelAndView register(@Valid User u,BindingResult bindingResult,RedirectAttributes redirectAttributes){
//        if(bindingResult.hasErrors()){
//            StringBuilder sb = new StringBuilder();
//            sb.append("Please check your input:");
//            for(FieldError fieldError : bindingResult.getFieldErrors()){
//                sb.append(fieldError.getField()).append(",");
//            }
//            redirectAttributes.addAttribute("info",sb.subSequence(0,sb.length()-2));
//            return new ModelAndView("redirect:/user/login?isRegiester=true");
//        }
//        else{
//            userService.insert(u);
//            return new ModelAndView("redirect:/");
//        }
//
//    }
//    private class RegisterCheckResult{
//        public String info;
//        public Boolean flag = Boolean.TRUE;
//    }
//
//
//    @RequestMapping(value = "/login",method = {RequestMethod.GET,RequestMethod.POST})
//    public ModelAndView login(String username, String password, String info,@RequestParam(defaultValue = "false") boolean isRegiester,HttpServletRequest request, HttpSession httpSession,RedirectAttributes redirectAttributes) {
//        if(request.getMethod().equalsIgnoreCase("POST")){
//            User u = userService.checkLogin(username,password);
//            if(u!=null){
//                u.setPwd("Eccrypt");
//                httpSession.setAttribute(Constants.SESS_USER,u);
//                return new ModelAndView("redirect:/");
//            }else{
//                ModelAndView modelAndView = new ModelAndView("login");
//                modelAndView.addObject("info","Please check username/password");
//                return modelAndView;
//            }
//        }
//        ModelAndView modelAndView = new ModelAndView("login");
//        modelAndView.addObject("info",info);
//        modelAndView.addObject("isRegiester",isRegiester);
//        return modelAndView;
//    }
//
//    @GetMapping("/logout")
//    public ModelAndView adminLogout(HttpSession session){
//        session.removeAttribute(Constants.SESS_USER);
//        return new ModelAndView("redirect:/user/login/");
//    }
}
