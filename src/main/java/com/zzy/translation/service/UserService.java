package com.zzy.translation.service;

import com.zzy.translation.entity.User;

import java.util.List;

public interface UserService {
    /**
     * 列出用户列表
     * @return
     */
    List<User> getUserList();

    /**
     * 根据userId列出具体用户
     * @param userId
     * @return
     */
    User getUserByUserId(String userId);

    /**
     * 插入用户信息
     * @param user
     * @return
     */
    boolean addUser(User user);

    /**
     * 更新用户信息
     * @param user
     * @return
     */
    boolean modifyUser(User user);

    /**
     * 删除用户信息
     * @param userId
     * @return
     */
    boolean deleteUser(String userId);

    /**
     * 根据username列出用户信息
     * @param user
     * @return
     */
    User getUserByUserName(User user);

    /**
     * 根据username和password列出用户信息
     * @param user
     * @return
     */
    User getUserByUser(User user);
}
