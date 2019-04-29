package com.zzy.translation.web;

import com.zzy.translation.entity.Word;
import com.zzy.translation.service.WordService;
import com.zzy.translation.utils.Json2String;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/Word")
@CrossOrigin
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

    @RequestMapping(value = "addword", method = RequestMethod.POST)
    private Map<String, Object> addWord(Word word){
        Map<String, Object> modelMap = new HashMap<String, Object>();
        boolean flag = wordService.addWord(word);
        modelMap.put("success", flag);
        return modelMap;
    }

}
