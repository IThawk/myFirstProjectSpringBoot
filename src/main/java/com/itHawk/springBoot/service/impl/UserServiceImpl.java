package com.itHawk.springBoot.service.impl;

import com.itHawk.springBoot.dao.UserMapper;
import com.itHawk.springBoot.model.User;
import com.itHawk.springBoot.service.UserService;
import com.itHawk.springBoot.utils.EncryptUtils;
import com.itHawk.springBoot.utils.HttpCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    /***
     *
     *   根据用户名以及密码查询用户信息
     * @param username  用户的登入名
     * @param password   用户的登入密码
     * @return 用户信息
     */
    @Override
    public User selectByUserNameAndPassWord(String username, String password) {

        //TODO 通过token，使用redis查询用户信息，以及用户的登入次数

        //用户信息查询不到在进行数据库查询
        //将用户的密码进行加密
        String newPassword = encryptUserPassWord(password);
        User user = new User(username, newPassword);
        return userMapper.selectByUserNameAndPassWord(user);
    }

    /***
     *
     * 添加用户信息到数据库
     * @param user 用户信息
     * @return 注册用户信息的状态码
     */
    @Override
    public int addUser(User user) {
        //将用户的密码进行加密
        String newPassword = encryptUserPassWord(user.getPassword());
        user.setPassword(newPassword);

        //根据用户信息查询用户
        User exitUser = userMapper.selectByUserName(user);

        //如果用户存在，返回用户存在
        if (exitUser != null) {
            return HttpCode.USER_IS_EXIT;
        } else {
            return userMapper.insert(user);
        }

    }

    /***
     *
     * 修改用户信息
     * @param user 用户信息
     * @return 修改用户信息的状态码
     * @param  oldPassword 用户旧密码
     */
    @Override
    public int updateUser(User user, String oldPassword) {
        //TODO 调用redis并且查看用的旧密码输入错误次数，如果次数超过三次


        String newPassword = user.getPassword();
        //将用户的密码进行加密
        String oldPassword1 = encryptUserPassWord(oldPassword);
        user.setPassword(oldPassword1);

        //根据用户信息查询用户
        User exitUser = userMapper.selectByUserNameAndPassWord(user);

        //如果用户存在，返回用户存在
        if (exitUser != null) {
            return HttpCode.USER_PASSWORD_IS_ERROR;
        } else {
            //将用户的密码进行加密
            String newPassword1 = encryptUserPassWord(newPassword);
            user.setPassword(newPassword1);
            return userMapper.insert(user);
        }

    }
    public void logoutUser() {
        //TODO 调用redis并且清除redis中的记录

    }
    /***
     * 将用户的密码进行加密
     * @param password 加密前的密码
     * @return 加密后的密码
     */
    private String encryptUserPassWord(String password) {
        //将用户的密码进行加密
        return EncryptUtils.AESEncode(User.USER_ENC0DE_RULE, password);
    }
}
