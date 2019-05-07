package com.zzy.translation.web;

import com.zzy.translation.api.MD5;
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
import java.util.List;
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
        StringBuilder sb = new StringBuilder();
        sb.append(word.getTransDst());
        sb.append(word.getTransSrc());
        sb.append(wxInfo.getOpenId());
        String wordId = MD5.stringMD5(sb.toString());
        word.setWordId(wordId);
        if (wordService.queryWordByWordId(wordId) != null ){
            return null;
        }else {

            word.setOpenId(wxInfo.getOpenId());
            boolean flag = wordService.addWord(word);
            modelMap.put("success", flag);
            return modelMap;
        }

    }

    @RequestMapping(value = "/querywordbyopenid", method = RequestMethod.GET)
    private Map<String, Object> queryWordByOpenId(@CookieValue("JSESSIONID") String sessionId){
        Map<String, Object> modelMap = new HashMap<String, Object>();
        MySessionContext mySessionContext = MySessionContext.getInstance();
        HttpSession session = mySessionContext.getSession(sessionId);
        WxInfo wxInfo = (WxInfo) session.getAttribute("WxInfo");
        List<Word> listWord = wordService.queryWordByOpenId(wxInfo.getOpenId());
        modelMap.put("listWord", listWord);
        return modelMap;
    }

    @RequestMapping(value = "/modifywithcolletion", method = RequestMethod.GET)
    private Map<String, Object> modifyWithColletion(Word word){
        Map<String, Object> modelMap = new HashMap<String, Object>();
        //收藏单词
        modelMap.put("success", wordService.modifyWithColletion(word));
        return modelMap;
    }

    @RequestMapping(value = "/modifywithdelete", method = RequestMethod.GET)
    private Map<String, Object>modifyWithDelete(Word word){
        Map<String, Object> modelMap = new HashMap<String, Object>();
        //删除单词
        modelMap.put("success", wordService.modifyWithDelete(word));
        return modelMap;
    }

}
