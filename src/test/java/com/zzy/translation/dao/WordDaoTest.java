package com.zzy.translation.dao;

import com.zzy.translation.entity.Word;
import com.zzy.translation.service.WordService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class WordDaoTest {
    @Autowired
    private WordService wordService;
    @Test
    public void queryWordByOpenId() {
    }

    @Test
    public void insertWord() {
        Word word = new Word();
        word.setOpenId("ousP54gfHHkcQPjxtoR-B_cze3T4");
        word.setQuery("你好");
        word.setFromWord("1");
        word.setToWord("2");
        boolean flag = wordService.addWord(word);
        assertEquals(true, flag);

    }

    @Test
    public void delectWord() {
        Word word = new Word();
        word.setWordId("0");
        boolean flag = wordService.deleteWord(word);
        assertEquals(true, flag);
    }

    @Test
    public void updateWithDelete(){
        Word word = new Word();
        word.setWordId("bae3c3114cd9efe5b");
        word.setIsDelete(1);
        System.out.println(word.getWordId());
        boolean flag = wordService.modifyWithDelete(word);
        assertEquals(true, flag);
    }
}