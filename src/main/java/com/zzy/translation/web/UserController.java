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
import javax.servlet.http.HttpSession;
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
    @RequestMapping(value = "/registerUser", method = RequestMethod.POST)
    private Map<String, Object>addUser(User user){
        Map<String, Object> modelMap = new HashMap<String, Object>();
        User exUser =  userService.getUserByUserName(user);
        if (exUser != null){
            modelMap.put("result", "该用户名已被注册");
            return modelMap;
        }
        boolean flag = userService.addUser(user);
        modelMap.put("success", flag);
        return modelMap;
    }

    @RequestMapping(value = "/loginUser", method = RequestMethod.POST)
    private Map<String, Object>loginUser(User user){
        Map<String, Object>modelMap = new HashMap<String, Object>();
        boolean flag = userService.checkPwdByUserName(user);
        User loginUser = userService.getUserByUserName(user);
        request.getSession().setAttribute("loginUser", loginUser);
        modelMap.put("success", flag);
        modelMap.put("user", loginUser);
        return modelMap;
    }
    @RequestMapping(value = "/getSession",method = RequestMethod.GET)
    private String getSession(){
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("loginUser");
        return user.getUserName();
    }

}
