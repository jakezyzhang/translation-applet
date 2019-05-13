package com.zzy.translation.service.impl;

import com.zzy.translation.api.MD5;
import com.zzy.translation.dao.UserDao;
import com.zzy.translation.entity.User;
import com.zzy.translation.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
@Service
public class UserServiceImpl implements UserService {
    private static final String SIGN = "ousP54gfHHkcQPjxtoR-B_cze3T4";
    @Autowired
    private UserDao userDao;
    @Override
    public List<User> getUserList() {
        return userDao.queryUser();
    }

    @Override
    public User getUserByUserId(String userId) {
        return userDao.queryUserByUserId(userId);
    }

    @Override
    public boolean addUser(User user) {
        if (user.getUserName() != null && !"".equals(user.getUserName()) && user.getPassWord() != null && !"".equals(user.getPassWord())){
            SimpleDateFormat df = new SimpleDateFormat("MM-dd HH:mm");
            user.setCreateTime(df.format(new Date()));
            user.setLastEditTime(df.format(new Date()));
            StringBuilder sb = new StringBuilder();
            sb.append(user.getUserName());
            sb.append(user.getPassWord());
            sb.append(System.currentTimeMillis());
            String userId = sb.toString();
            user.setUserId(MD5.stringMD5(userId));
            StringBuilder sPwd = new StringBuilder();
            sPwd.append(user.getPassWord());
            sPwd.append(SIGN);
            user.setPassWord(MD5.stringMD5(sPwd.toString()));
            try {
                int effectedNum = userDao.insertUser(user);
                if (effectedNum > 0){
                    return true;
                }else {
                    throw new RuntimeException("添加用户信息失败！");
                }
            } catch (RuntimeException e) {
                throw new RuntimeException("添加用户信息失败！" + e.getMessage());
            }
        }else {
            throw new RuntimeException("用户的userName和passWord不能为空！");
        }

    }

    @Override
    public boolean modifyUser(User user) {
        return false;
    }

    @Override
    public boolean deleteUser(String userId) {
        return false;
    }

    @Override
    public User getUserByUserName(User user) {
        return userDao.queryUserByUserName(user);
    }

    @Override
    public boolean checkPwdByUserName(User user) {
        if (user.getUserName() != null && !"".equals(user.getUserName())){
            try {
                User checkUser = userDao.queryUserByUserName(user);
                if (checkUser == null ){
                    throw new RuntimeException("用户名不存在！");
                }
                String checkPwd = checkUser.getPassWord();
                StringBuilder pwd = new StringBuilder();
                pwd.append(user.getPassWord());
                pwd.append(SIGN);
                if (checkPwd.equals(MD5.stringMD5(pwd.toString()))){
                    return true;
                }else {
                    throw new RuntimeException("账号或者密码输入有误！");
                }
            } catch (Exception e) {
                throw new RuntimeException("账号或者密码输入有误！" + e.getMessage());
            }
        }else {
            throw new RuntimeException("账号不能为空！");
        }
    }

}
