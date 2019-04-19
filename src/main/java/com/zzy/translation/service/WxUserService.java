package com.zzy.translation.service;

import com.zzy.translation.entity.WxUser;

public interface WxUserService {
    /**
     * 插入微信用户信息
     * @param wxUser
     * @return
     */
    boolean addWxUser(WxUser wxUser);
}
