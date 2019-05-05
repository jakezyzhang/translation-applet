package com.zzy.translation.web;

import com.zzy.translation.config.session.MySessionContext;
import com.zzy.translation.entity.Word;
import com.zzy.translation.entity.WxInfo;
import com.zzy.translation.service.WordService;
import com.zzy.translation.utils.Json2String;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

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

    @RequestMapping(value = "/addword", method = RequestMethod.POST)
    private Map<String, Object> addWord(Word word, @CookieValue("JSESSIONID") String sessionId){
        Map<String, Object> modelMap = new HashMap<String, Object>();
        MySessionContext mySessionContext = MySessionContext.getInstance();
        HttpSession session = mySessionContext.getSession(sessionId);
        WxInfo wxInfo = (WxInfo) session.getAttribute("WxInfo");
        System.out.println("from:" + word.getFromWord());
        System.out.println("to:" + word.getToWord());
        System.out.println("query:" + word.getQuery());
        word.setOpenId(wxInfo.getOpenId());
        boolean flag = wordService.addWord(word);
        modelMap.put("success", flag);
        return modelMap;
    }

}
