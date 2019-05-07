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
     * 根据wordId查询出单词记录
     * @param wordId
     * @return
     */
    Word queryWordByWordId(String wordId);

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

    /**
     * 通过改变is_collection字段起到收藏的功能
     * @param word
     * @return
     */
    boolean modifyWithColletion(Word word);

    /**
     * 通过改变is_delete字段起到删除的功能
     * @param word
     * @return
     */
    boolean modifyWithDelete(Word word);
}
