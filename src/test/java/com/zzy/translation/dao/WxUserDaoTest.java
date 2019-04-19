package com.zzy.translation.dao;

import com.zzy.translation.entity.WxUser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class WxUserDaoTest {

    @Autowired
    private WxUserDao wxUserDao;
    @Test
    public void insertWxUser() {
        WxUser wxUser = new WxUser();
        wxUser.setOpenId("5465464554");
        wxUser.setUserId("54445454");
        wxUser.setNickName("zzy");

        int effectedNum = wxUserDao.insertWxUser(wxUser);
        assertEquals(1, effectedNum);
    }
}