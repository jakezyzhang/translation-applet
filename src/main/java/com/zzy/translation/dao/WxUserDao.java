package com.zzy.translation.dao;

import com.zzy.translation.entity.WxUser;

import java.util.List;

public interface WxUserDao {
    /**
     * 列出微信用户列表
     * @return WxUserList
     */
    List<WxUser> queryWxUser();

    /**
     *根据openid列出具体的用户
     * @param openId
     * @return WxUser
     */
    WxUser queryWxUserByOpenId(String openId);

    /**
     * 插入微信用户
     * @param wxUser
     * @return
     */
    int insertWxUser(WxUser wxUser);
}
