package com.zzy.translation.dao;

import com.zzy.translation.api.MD5;
import com.zzy.translation.entity.Article;
import com.zzy.translation.service.ArticleService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class ArticleDaoTest {

    @Autowired
    private ArticleService articleService;
    @Test
    public void queryArticle() {
    }

    @Test
    public void queryArticleByUserId() {
    }

    @Test
    public void queryArticleByArticleId() {
    }

    @Test
    public void insertArticle() {
        Article article = new Article();
        article.setrLongTitle("这是一篇测试的文章");
        article.setrSubheading("测试文章");
        article.setrContent("测试测试测试测试测试测试测试测试测试测试");
        String title = article.getrLongTitle();
        String subheading = article.getrSubheading();
        StringBuilder sb = new StringBuilder();
        sb.append(title);
        sb.append(subheading);
        sb.append(new Date().getTime());
        String rId = MD5.stringMD5(sb.toString());
        article.setrId(rId);
        boolean effected = articleService.addArticle(article);
        assertEquals(true, effected);
    }

    @Test
    public void updateArticle() {
    }

    @Test
    public void updateArticleByStatus() {
        Article article = new Article();
        article.setrId("06539a7a9ceff8e7155d8adb49f9c544");
        article.setrStatus(1);
        boolean effected = articleService.modifyArticleByStatus(article);
        assertEquals(true, effected);
    }

    @Test
    public void deleteArticle() {
    }
}