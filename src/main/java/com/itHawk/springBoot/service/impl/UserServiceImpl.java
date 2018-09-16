package com.itHawk.springBoot.service.impl;

import com.itHawk.springBoot.dao.UserMapper;
import com.itHawk.springBoot.model.User;
import com.itHawk.springBoot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public User selectByUserNameAndPassWord(String username,String password) {

        User user =new User( username,password);
        return userMapper.selectByUserNameAndPassWord(user);
    }
    @Override
    public int addUser(String username,String password){
        User user =new User( username,password);
        return userMapper.insert(user);
    }
}
