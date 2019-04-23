package com.zzy.translation.web;

import com.zzy.translation.entity.Word;
import com.zzy.translation.service.WordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Word")
public class WordController {

    @Autowired
    private WordService wordService;
    @RequestMapping(value = "/translation", method = RequestMethod.GET)
    private String translationInterface(Word word){

        String dst = wordService.translationWord(word);
        return dst;
    }
}
