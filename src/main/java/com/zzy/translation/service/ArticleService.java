package com.zzy.translation.service;

import com.zzy.translation.entity.Article;

import java.util.List;

public interface ArticleService {

    /**
     * 插入文章信息
     * @param article
     * @return
     */
    boolean addArticle(Article article);

    /**
     * 列出所有的文章
     * @return
     */
    List<Article> queryArticle();

    /**
     * 根据r_id字段查询文章信息
     * @param rId
     * @return
     */
    Article queryArticleByArticleId(String rId);

    /**
     * 通过r_status字段软删除文章
     * @param article
     * @return
     */
    boolean modifyArticleByStatus(Article article);

    /**
     * 更新文章信息
     * @param article
     * @return
     */
    boolean modifyArticle(Article article);
}
