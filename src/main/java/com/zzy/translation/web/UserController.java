package com.zzy.translation.web;

import com.zzy.translation.config.session.MySessionContext;
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
        HttpSession session = request.getSession();
        System.out.println("loginUser " + session.getId());
        session.setAttribute("loginUser", loginUser);
        modelMap.put("success", flag);
        modelMap.put("user", loginUser);
        return modelMap;
    }
    @RequestMapping(value = "/getSession",method = RequestMethod.GET)
    private Map<String, Object> getSession(){
        Map<String, Object> modelMap = new HashMap<String, Object>();
        HttpSession session1 = request.getSession();
        System.out.println("getSession " + session1);
        modelMap.put("sessionId", session1.getId());
        return modelMap;
    }
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    private Map<String, Object>logOut(){
        Map<String, Object>modelMap = new HashMap<String, Object>();
        HttpSession session = request.getSession(false);
        session.invalidate();
        modelMap.put("success", true);
        return modelMap;
    }

    @RequestMapping(value = "/queryuserbyuserid", method = RequestMethod.GET)
    private Map<String, Object>queryUserByUserId(){
        Map<String, Object> modelMap = new HashMap<String, Object>();
        //TODO
//        User loginUser = (User) request.getSession(false).getAttribute("loginUser");
        User user = userService.getUserByUserId("e3c0c0ad585a3264b111b3e788213654");
        modelMap.put("user", user);
        return modelMap;
    }

    @RequestMapping(value = "/modifyuser", method = RequestMethod.POST)
    private Map<String, Object> modifyUser(User user){
        Map<String, Object> modelMap = new HashMap<String, Object>();
        //TODO
        //        User loginUser = (User) request.getSession(false).getAttribute("loginUser");
        user.setUserId("e3c0c0ad585a3264b111b3e788213654");
        boolean flag = userService.modifyUser(user);
        modelMap.put("success", flag);
        return modelMap;
    }
}
