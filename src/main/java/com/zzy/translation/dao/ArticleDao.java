package com.zzy.translation.dao;

import com.zzy.translation.entity.Article;
import com.zzy.translation.entity.User;

import java.util.List;

public interface ArticleDao {
    /**
     * 列出所有的文章
     * @return
     */
    List<Article> queryArticle();

    /**
     * 根据userId列出所有的文章
     * @param user
     * @return
     */
    List<Article> queryArticleByUserId(User user);

    /**
     * 根据r_id字段查询文章信息
     * @param rId
     * @return
     */
    Article queryArticleByArticleId(String rId);

    /**
     * 插入文章信息
     * @param article
     * @return
     */
    int insertArticle(Article article);

    /**
     * 更新文章信息
     * @param article
     * @return
     */
    int updateArticle(Article article);

    /**
     * 通过r_status字段软删除文章
     * @param article
     * @return
     */
    int updateArticleByStatus(Article article);

    /**
     * 删除文章信息
     * @param rId
     * @return
     */
    int deleteArticle(String  rId);
}
