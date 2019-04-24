package com.zzy.translation.web;

import com.zzy.translation.entity.Word;
import com.zzy.translation.service.WordService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/Word")
public class WordController {

    @Autowired
    private WordService wordService;
    @RequestMapping(value = "/translation", method = RequestMethod.GET)
    private JSONObject translationInterface(Word word){
        HttpServletRequest request = ((ServletRequestAttributes) (RequestContextHolder.currentRequestAttributes())).getRequest();
        System.out.println(request.getRequestedSessionId());
        HttpSession session = request.getSession();
        System.out.println(session.getAttribute("openId"));
        JSONObject jsonObject = wordService.translationWord(session, word);
        return jsonObject;
    }
}
