package com.zzy.translation.service.impl;

import com.zzy.translation.dao.WxUserDao;
import com.zzy.translation.entity.WxUser;
import com.zzy.translation.service.WxUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class WxUserServiceImpl implements WxUserService {
    @Autowired
    private WxUserDao wxUserDao;

    @Transactional
    @Override
    public boolean addWxUser(WxUser wxUser) {
        if (wxUser.getOpenId() != null && !"".equals(wxUser.getOpenId())){
            wxUser.setUserId(String.valueOf(System.currentTimeMillis()));
            try {
                int effectedNum = wxUserDao.insertWxUser(wxUser);
                if (effectedNum > 0){
                    return true;
                }else {
                    throw new RuntimeException("插入微信用户信息失败!");
                }
            } catch (Exception e) {
                throw new RuntimeException("插入微信用户信息失败：" + e.getMessage());
            }
        }else {
            throw new RuntimeException("openid不能为空");
        }

    }
}
