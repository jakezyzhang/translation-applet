package com.zzy.translation.entity;

import java.util.Date;

public class Word {
    private int id;
    private String openId;
    private String query;
    private String transSrc;
    private String transDst;
    private String from;
    private String to;
    private String statusCode;
    private Date createTime;
    private Date lastEditTime;

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getLastEditTime() {
        return lastEditTime;
    }

    public void setLastEditTime(Date lastEditTime) {
        this.lastEditTime = lastEditTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }
}
