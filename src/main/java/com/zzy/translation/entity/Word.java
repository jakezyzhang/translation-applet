package com.zzy.translation.entity;

import java.util.Date;

public class Word {
    private int id;
    private String wordId;
    private String openId;
    private String query;
    private String transSrc;
    private String transDst;
    private String fromWord;
    private String toWord;
    private String statusCode;
    private String  createTime;
    private String lastEditTime;
    private int isCollection;
    private int isDelete;



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getWordId() {
        return wordId;
    }

    public void setWordId(String wordId) {
        this.wordId = wordId;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public String getTransSrc() {
        return transSrc;
    }

    public void setTransSrc(String transSrc) {
        this.transSrc = transSrc;
    }

    public String getTransDst() {
        return transDst;
    }

    public void setTransDst(String transDst) {
        this.transDst = transDst;
    }

    public String getFromWord() {
        return fromWord;
    }

    public void setFromWord(String fromWord) {
        this.fromWord = fromWord;
    }

    public String getToWord() {
        return toWord;
    }

    public void setToWord(String toWord) {
        this.toWord = toWord;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getLastEditTime() {
        return lastEditTime;
    }

    public void setLastEditTime(String lastEditTime) {
        this.lastEditTime = lastEditTime;
    }

    public void setIsCollection(int isCollection) {
        this.isCollection = isCollection;
    }

    public int getIsCollection() {
        return isCollection;
    }

    public int getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(int isDelete) {
        this.isDelete = isDelete;
    }
}
