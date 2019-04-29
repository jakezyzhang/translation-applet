package com.zzy.translation.service.impl;

import com.google.gson.JsonObject;
import com.zzy.translation.api.HttpGet;
import com.zzy.translation.dao.WordDao;
import com.zzy.translation.entity.Word;
import com.zzy.translation.service.WordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.Date;

@Service
public class WordServiceImpl implements WordService {
    @Autowired
    private WordDao wordDao;
    @Override
    public String translationWord(Word word) {
        String query = word.getQuery();
        String[] fromArr = {"zh", "en", "fra", "jp", "kor", "auto"};
        String[] toArr = {"zh", "en", "fra", "jp", "kor"};
        String from = fromArr[Integer.parseInt(word.getFrom())];
        String to = toArr[Integer.parseInt(word.getTo())];
        String result = HttpGet.get(query, from, to);
        return result;
    }

    @Override
    public boolean addWord(Word word) {
        if (word.getOpenId() != null && !"".equals(word.getOpenId())){
            word.setCreateTime(new Date());
            word.setLastEditTime(new Date());
            String[] fromArr = {"zh", "en", "fra", "jp", "kor", "auto"};
            String[] toArr = {"zh", "en", "fra", "jp", "kor"};
            String from = fromArr[Integer.parseInt(word.getFrom())];
            String to = toArr[Integer.parseInt(word.getTo())];
            word.setFrom(from);
            word.setTo(to);
            try {
                int effectedNum = wordDao.insertWord(word);
                if (effectedNum > 0){
                    return true;
                }else {
                    throw new RuntimeException("插入失败");
                }
            } catch (Exception e) {
                throw new RuntimeException("插入查询单词记录失败：" + e.getMessage());
            }
        }else {
            throw new RuntimeException("未授权微信");
        }

    }
}
