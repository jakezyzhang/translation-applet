package com.zzy.translation.service.impl;

import com.zzy.translation.dao.WxUserDao;
import com.zzy.translation.entity.WxUser;
import com.zzy.translation.service.WxUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Service
public class WxUserServiceImpl implements WxUserService {
    @Autowired
    private WxUserDao wxUserDao;

    @Override
    public boolean queryWxUserByOpenId(String openId) {
        if (openId != null && !"".equals(openId)){
            try {
                int effectedNum = wxUserDao.queryWxUserByOpenId(openId).getUserId().length();
                if (effectedNum > 0){
                    return true;
                }else {
                    throw new RuntimeException("获取用户信息失败!");
                }
            } catch (Exception e) {
                throw new RuntimeException("获取用户信息失败!" + e.getMessage());
            }
        }else {
            throw new RuntimeException("openId不能为空!");
        }

    }

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
