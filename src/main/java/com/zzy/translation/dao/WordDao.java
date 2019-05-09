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
     * 根据wordId查询该用户所查询过的单词记录
     * @param wordId
     * @return
     */
    Word queryWordByWordId(String wordId);

    /**
     * 将查询到的单词插入到数据库中
     * @param word
     * @return
     */
    int insertWord(Word word);

    /**
     * 删除单词记录
     * @param word
     * @return
     */
    int deleteWord(Word word);

    /**
     * 通过改变is_collection字段起到收藏的功能
     * @param word
     * @return
     */
    int updateWithCollection(Word word);

    /**
     * 通过改变is_delete字段起到删除的功能
     * @param word
     * @return
     */
    int updateWithDelete(Word word);

    /**
     * 收藏的单词列表
     * @param openId
     * @return
     */
    List<Word> queryWordWithCollection(String openId);
}
