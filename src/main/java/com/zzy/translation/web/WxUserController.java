package com.zzy.translation.web;

import com.zzy.translation.entity.WxUser;
import com.zzy.translation.service.WxUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
    private Map<String, Object> addWxUser(@RequestBody WxUser wxUser){
        Map<String, Object> modelMap = new HashMap<String, Object>();
        boolean flag = wxUserService.addWxUser(wxUser);
        modelMap.put("success", flag);
        return modelMap;
    }
}
