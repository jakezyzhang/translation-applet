package com.zzy.translation.service;

import com.zzy.translation.entity.Word;

import java.util.List;

public interface WordService {
    /**
     * 翻译单词的接口
     * @return
     */
    String translationWord(Word word);

    /**
     * 查询出用户所查询过的所有单词的记录
     * @param openId
     * @return
     */
    List<Word> queryWordByOpenId(String openId);

    /**
     * 将查询出来的单词插入到数据库中
     * @param word
     * @return
     */
    boolean addWord(Word word);

    /**
     * 删除用户单词记录
     * @param word
     * @return
     */
    boolean deleteWord(Word word);
}
