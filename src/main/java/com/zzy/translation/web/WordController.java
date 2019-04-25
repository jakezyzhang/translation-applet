package com.zzy.translation.web;

import com.zzy.translation.entity.Word;
import com.zzy.translation.entity.WxInfo;
import com.zzy.translation.service.WordService;
import com.zzy.translation.utils.Json2String;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
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
    private WordService wordService;
    @RequestMapping(value = "/translation", method = RequestMethod.GET)
    private JSONObject translationInterface(Word word){
        String result = wordService.translationWord(word);
        JSONObject resultJson = Json2String.jsonString2String(result);
        return resultJson;
    }

    @RequestMapping(value = "/getopenid", method = RequestMethod.GET)
    private void getOpenId( WxInfo wxInfo){
        try {
            URL url = new URL("https://api.weixin.qq.com/sns/jscode2session?appid=" + wxInfo.getAppId() + "&secret=" + wxInfo.getSecret() + "&js_code=" + wxInfo.getCode() + "&grant_type=authorization_code");
            InputStream is = url.openStream();
            BufferedReader bf = new BufferedReader(new InputStreamReader(is));
            String info = null;
            while ((info = bf.readLine()) != null){
                System.out.println(info);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
