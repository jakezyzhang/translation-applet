package com.zzy.translation.web;

import com.zzy.translation.config.session.MySessionContext;
import com.zzy.translation.entity.WxInfo;
import com.zzy.translation.service.WxInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/WxInfo")
public class WxInfoController {
    @Autowired
    private WxInfoService wxInfoService;
    @Autowired
    private HttpServletRequest request;

    @RequestMapping(value = "/getopenid", method = RequestMethod.GET)
    private Map<String, Object> getOpenId(WxInfo wxInfo, @CookieValue("code") String code){
        Map<String, Object> modelMap = new HashMap<String, Object>();
        String openId = wxInfoService.getOpenIdByWxInfo(wxInfo);
        wxInfo.setOpenId(openId);
        HttpSession httpSession = request.getSession();
        httpSession.setAttribute("WxInfo", wxInfo);
        wxInfo.setSessionId(httpSession.getId());
        modelMap.put("WxInfo", wxInfo);
        return modelMap;
    }
    @RequestMapping(value = "/getsessionid", method = RequestMethod.GET)
    private void getSessionId(@CookieValue("JSESSIONID") String sessionId){
        System.out.println(sessionId);
        MySessionContext mySessionContext = MySessionContext.getInstance();
        HttpSession session = mySessionContext.getSession(sessionId);
        WxInfo wxInfo = (WxInfo) session.getAttribute("WxInfo");
        System.out.println(wxInfo.getOpenId());
    }
}
