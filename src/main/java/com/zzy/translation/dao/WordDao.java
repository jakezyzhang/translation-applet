package com.zzy.translation.dao;

import com.zzy.translation.entity.Word;

import java.util.List;

public interface WordDao {
    /**
     * 根据openId查询该用户所查询过的单词记录
     * @param openId
     * @return
     */
    List<Word> queryWordByOpenId(String openId);

    /**
     * 将查询到的单词插入到数据库中
     * @param word
     * @return
     */
    int insertWord(Word word);

}
