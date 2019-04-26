package com.zzy.translation.web;

import com.zzy.translation.config.session.MySessionContext;
import com.zzy.translation.entity.Word;
import com.zzy.translation.entity.WxInfo;
import com.zzy.translation.service.WordService;
import com.zzy.translation.utils.Json2String;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.server.Session;
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

@RestController
@RequestMapping("/Word")
public class WordController {
    @Autowired
    private HttpServletRequest request;
    @Autowired
    private WordService wordService;
    @RequestMapping(value = "/translation", method = RequestMethod.GET)
    private JSONObject translationInterface(Word word){
        String result = wordService.translationWord(word);
        JSONObject resultJson = Json2String.jsonString2String(result);
        return resultJson;
    }

    @RequestMapping(value = "/getopenid", method = RequestMethod.GET)
    private void getOpenId(WxInfo wxInfo, @CookieValue("code") String code){
        try {
            URL url = new URL("https://api.weixin.qq.com/sns/jscode2session?appid=" + wxInfo.getAppId() + "&secret=" + wxInfo.getSecret() + "&js_code=" + wxInfo.getCode() + "&grant_type=authorization_code");
            InputStream is = url.openStream();
            BufferedReader bf = new BufferedReader(new InputStreamReader(is));
            String info = null;
            StringBuilder sb = new StringBuilder();
            while ((info = bf.readLine()) != null){
                sb.append(info);
            }
            JSONObject jsonObject = JSONObject.fromObject(sb.toString());
            String openId = jsonObject.getString("openid");
//            System.out.println(openId);
            wxInfo.setOpenId(openId);
            HttpSession httpSession = request.getSession();
            httpSession.setAttribute("openId", openId);
            System.out.println(httpSession.getId());
            MySessionContext myc = MySessionContext.getInstance();
            myc.addSession(httpSession);
            HttpSession session = myc.getSession(httpSession.getId());
            System.out.println("openId==" + session.getAttribute("openId"));
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
