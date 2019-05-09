package com.zzy.translation.service.impl;

import com.google.gson.JsonObject;
import com.zzy.translation.api.HttpGet;
import com.zzy.translation.dao.WordDao;
import com.zzy.translation.entity.Word;
import com.zzy.translation.service.WordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class WordServiceImpl implements WordService {
    @Autowired
    private WordDao wordDao;
    @Override
    public String translationWord(Word word) {
        String query = word.getQuery();
        String[] fromArr = {"auto", "zh", "en", "fra", "jp", "kor"};
        String[] toArr = {"zh", "en", "fra", "jp", "kor"};
        String from = fromArr[Integer.parseInt(word.getFromWord())];
        String to = toArr[Integer.parseInt(word.getToWord())];
        String result = HttpGet.get(query, from, to);
        return result;
    }

    @Override
    public List<Word> queryWordByOpenId(String openId) {
        return wordDao.queryWordByOpenId(openId);
    }

    @Override
    public Word queryWordByWordId(String wordId) {
        return wordDao.queryWordByWordId(wordId);
    }

    @Override
    public boolean addWord(Word word) {
        if (word.getOpenId() != null && !"".equals(word.getOpenId())){
//            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
            word.setIsColletion(0);
            word.setIsDelete(0);
            word.setCreateTime(new Date());
            word.setLastEditTime(new Date());
            String[] fromArr = {"auto", "zh", "en", "fra", "jp", "kor"};
            String[] toArr = {"zh", "en", "fra", "jp", "kor"};
            String from = fromArr[Integer.parseInt(word.getFromWord())];
            String to = toArr[Integer.parseInt(word.getToWord())];
            word.setFromWord(from);
            word.setToWord(to);
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

    @Override
    public boolean deleteWord(Word word) {
        if(word.getWordId() != null && !"".equals(word.getWordId())){
            try {
                int effectedNum = wordDao.deleteWord(word);
                if (effectedNum > 0){
                    return true;
                }else {
                    throw new RuntimeException("删除单词记录失败");
                }
            } catch (Exception e) {
                throw new RuntimeException("删除单词记录失败：" + e.getMessage());
            }
        }else {
            throw new RuntimeException("删除单词记录失败, wordId不能为空");
        }

    }

    @Override
    public boolean modifyWithCollection(Word word) {
        if (word.getWordId() != null && !"".equals(word.getWordId())){
//            word.setLastEditTime(new Date());
            try {
                int effectedNum = wordDao.updateWithCollection(word);
                if (effectedNum > 0){
                    return true;
                }else {
                    throw new RuntimeException("单词收藏失败！");
                }
            } catch (Exception e) {
                throw new RuntimeException("单词收藏失败！" + e.getMessage());
            }
        }else {
            throw new RuntimeException("单词id为空！");
        }
    }

    @Override
    public boolean modifyWithDelete(Word word) {
        if (word.getWordId() != null && !"".equals(word.getWordId())){
//            word.setLastEditTime(new Date());
            try {
                int effectedNum = wordDao.updateWithDelete(word);
                if (effectedNum > 0){
                    return true;
                }else {
                    throw new RuntimeException("单词删除失败！");
                }
            } catch (Exception e) {
                throw new RuntimeException("单词删除失败！" + e.getMessage());
            }
        }else {
            throw new RuntimeException("单词id为空！");
        }
    }

    @Override
    public List<Word> queryWordWithCollection(String openId) {
        return wordDao.queryWordWithCollection(openId);
    }
}
