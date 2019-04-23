package com.zzy.translation.service;

import com.zzy.translation.entity.Word;

public interface WordService {
    /**
     * 翻译单词的接口
     * @return
     */
    String translationWord(Word word);
    /**
     * 将查询出来的单词插入到数据库中
     * @param word
     * @return
     */
    boolean addWord(Word word);
}
