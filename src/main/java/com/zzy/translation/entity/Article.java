package com.zzy.translation.entity;

public class Article {

    private int id;
    private String rId;
    private String userId;
    private String rLongTitle;
    private String rSubheading;
    private String rAuthor;
    private String rSummary;
    private String rContent;
    private String createTime;
    private String lastEditTime;
    private int rPublish;
    private int rStatus;
    private String publishInfo;
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getrId() {
        return rId;
    }

    public void setrId(String rId) {
        this.rId = rId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getrLongTitle() {
        return rLongTitle;
    }

    public void setrLongTitle(String rLongTitle) {
        this.rLongTitle = rLongTitle;
    }

    public String getrSubheading() {
        return rSubheading;
    }

    public void setrSubheading(String rSubheading) {
        this.rSubheading = rSubheading;
    }

    public String getrAuthor() {
        return rAuthor;
    }

    public void setrAuthor(String rAuthor) {
        this.rAuthor = rAuthor;
    }

    public String getrSummary() {
        return rSummary;
    }

    public void setrSummary(String rSummary) {
        this.rSummary = rSummary;
    }

    public String getrContent() {
        return rContent;
    }

    public void setrContent(String rContent) {
        this.rContent = rContent;
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

    public int getrPublish() {
        return rPublish;
    }

    public void setrPublish(int rPublish) {
        this.rPublish = rPublish;
    }

    public int getrStatus() {
        return rStatus;
    }

    public void setrStatus(int rStatus) {
        this.rStatus = rStatus;
    }

    public String getPublishInfo() {
        return publishInfo;
    }

    public void setPublishInfo(String publishInfo) {
        this.publishInfo = publishInfo;
    }
}
