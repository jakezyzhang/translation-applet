package com.zzy.translation.dao;

import com.zzy.translation.entity.User;

import java.util.List;

public interface UserDao {
    /**
     * 列出用户列表
     * @return
     */
    List<User> queryUser();

    /**
     * 根据userId列出具体用户信息
     * @param userId
     * @return
     */
    User queryUserByUserId(String userId);

    /**
     * 插入用户信息
     * @param user
     * @return
     */
    int insertUser(User user);

    /**
     * 更新用户信息
     * @param user
     * @return
     */
    int updateUser(User user);

    /**
     * 删除用户信息
     * @param userId
     * @return
     */
    int deleteUser(String userId);

    /**
     * 根据username列出用户信息
     * @param user
     * @return
     */
    User queryUserByUserName(User user);

    /**
     * 验证密码
     * @param user
     * @return
     */
    User checkPwdByUserName(User user);

}
