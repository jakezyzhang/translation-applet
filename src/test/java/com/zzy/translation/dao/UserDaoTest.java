package com.zzy.translation.dao;

import com.zzy.translation.entity.User;
import com.zzy.translation.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserDaoTest {
    @Autowired
    private UserService userService;
    @Test
    public void queryUser() {
    }

    @Test
    public void queryUserByUserId() {
    }

    @Test
    public void insertUser() {
        User user = new User();
        user.setUserName("123");
        user.setPassWord("123");
        user.setNickName("123");
        user.setPhone("123");
        user.setPower(1);
        user.setGender(1);
        boolean flag = userService.addUser(user);
        assertEquals(true, flag);
    }

    @Test
    public void updateUser() {
    }

    @Test
    public void deleteUser() {
    }

    @Test
    public void queryUserByUserName() {
    }
}