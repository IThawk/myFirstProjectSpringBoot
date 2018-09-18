package com.itHawk.springBoot.service;

import com.itHawk.springBoot.model.User;
import org.springframework.stereotype.Service;

public interface UserService {
    /***
     * 根据用户登入名和密码进行用户信息的查询
     * @param username  用户的登入名
     * @param password   用户的登入密码
     * @return
     */
    User selectByUserNameAndPassWord(String username,String password);

    int addUser(User user);

    int updateUser(User user,String oldPassword);

    void logoutUser();


}
