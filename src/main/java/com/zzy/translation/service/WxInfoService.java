package com.zzy.translation.service;

import com.zzy.translation.entity.WxInfo;

public interface WxInfoService {
    /**
     * 获取OpenId
     * @param wxInfo
     * @return
     */
    String getOpenIdByWxInfo(WxInfo wxInfo);
}
