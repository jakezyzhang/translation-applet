package com.zzy.translation.web;

import com.zzy.translation.config.session.MySessionContext;
import com.zzy.translation.entity.WxInfo;
import com.zzy.translation.entity.WxUser;
import com.zzy.translation.service.WxUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/WxUser")
public class WxUserController {

    @Autowired
    private WxUserService wxUserService;
    @RequestMapping(value = "/userbyopenid", method = RequestMethod.GET)
    private Map<String, Object> queryWxUserByOpenId(String openId){
        Map<String, Object> modelMap = new HashMap<String, Object>();
        boolean flag = wxUserService.queryWxUserByOpenId(openId);
        modelMap.put("success", flag);
        return modelMap;
    }

    @RequestMapping(value = "/addwxuser", method = RequestMethod.POST)
    private Map<String, Object> addWxUser(@CookieValue("JSESSIONID") String sessionId,@RequestBody WxUser wxUser){
        Map<String, Object> modelMap = new HashMap<String, Object>();
        MySessionContext mySessionContext = MySessionContext.getInstance();
        HttpSession session = mySessionContext.getSession(sessionId);
        WxInfo wxInfo = (WxInfo) session.getAttribute("WxInfo");
        wxUser.setOpenId(wxInfo.getOpenId());
        boolean flag = wxUserService.addWxUser(wxUser);
        modelMap.put("success", flag);
        return modelMap;
    }



}
