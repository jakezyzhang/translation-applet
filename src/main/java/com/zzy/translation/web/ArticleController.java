package com.zzy.translation.web;

import com.zzy.translation.api.MD5;
import com.zzy.translation.entity.Article;
import com.zzy.translation.entity.User;
import com.zzy.translation.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("/Article")
@RestController
@CrossOrigin
public class ArticleController {
    @Autowired
    private HttpServletRequest request;
    @Autowired
    private ArticleService articleService;

    @RequestMapping(value = "/addarticle", method = RequestMethod.POST)
    private Map<String, Object> addArticle(Article article){
        Map<String, Object> modelMap = new HashMap<String, Object>();
        String title = article.getrLongTitle();
        String subheading = article.getrSubheading();
        StringBuilder sb = new StringBuilder();
        sb.append(title);
        sb.append(subheading);
        sb.append(new Date().getTime());
        String rId = MD5.stringMD5(sb.toString());
        article.setrId(rId);
        User loginUser = (User) request.getSession(false).getAttribute("loginUser");
        article.setrAuthor(loginUser.getUserName());
        article.setUserId(loginUser.getUserId());
        boolean flag = articleService.addArticle(article);
        modelMap.put("success", flag);
        return modelMap;
    }

    @RequestMapping(value = "/queryArticle", method = RequestMethod.GET)
    private Map<String, Object> queryArticle(){
        Map<String, Object> modelMap = new HashMap<String, Object>();
        List<Article> listArticle = articleService.queryArticle();
        modelMap.put("data", listArticle);
        modelMap.put("code", 0);
        modelMap.put("msg", "");
        modelMap.put("count", listArticle.size());
        return modelMap;
    }

    @RequestMapping(value = "/queryarticlebyarticleid", method = RequestMethod.GET)
    private Map<String, Object> queryArticleByArticleId(String rId){
        Map<String, Object> modelMap = new HashMap<String, Object>();
        Article article = articleService.queryArticleByArticleId(rId);
        modelMap.put("article", article);
        return modelMap;
    }

    @RequestMapping(value = "/modifyarticlebystatus", method = RequestMethod.POST)
    private Map<String, Object>modifyArticleByStatus(Article article){
        Map<String, Object> modelMap = new HashMap<String, Object>();
        User loginUser = (User) request.getSession(false).getAttribute("loginUser");
        article.setrAuthor(loginUser.getUserName());
        article.setUserId(loginUser.getUserId());
        modelMap.put("success", articleService.modifyArticleByStatus(article));
        return modelMap;
    }

    @RequestMapping(value = "/modifyarticle", method = RequestMethod.POST)
    private Map<String, Object>modifyArticle( Article article){
        Map<String, Object>modelMap = new HashMap<String, Object>();
        User loginUser = (User) request.getSession(false).getAttribute("loginUser");
        article.setrAuthor(loginUser.getUserName());
        article.setUserId(loginUser.getUserId());
        modelMap.put("success", articleService.modifyArticle(article));
        return modelMap;
    }
}
