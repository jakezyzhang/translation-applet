package com.zzy.translation.web;

import com.zzy.translation.entity.User;
import com.zzy.translation.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RequestMapping("/User")
@RestController
@CrossOrigin
public class UserController {
    @Autowired
    private HttpServletRequest request;
    @Autowired
    private UserService userService;
    @RequestMapping(value = "/login")
    private ModelAndView login(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:http://127.0.0.1:8848/News-UI/pages/login.html");
        return modelAndView;
    }
    @RequestMapping(value = "/registerUser", method = RequestMethod.POST)
    private Map<String, Object>addUser(User user){
        Map<String, Object> modelMap = new HashMap<String, Object>();
        User exUser =  userService.getUserByUserName(user.getUserName());
        if (exUser != null){
            modelMap.put("result", "该用户名已被注册");
            return modelMap;
        }
        boolean flag = userService.addUser(user);
        modelMap.put("success", flag);
        return modelMap;
    }
}
