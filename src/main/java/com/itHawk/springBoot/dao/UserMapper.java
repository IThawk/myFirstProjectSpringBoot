package com.itHawk.springBoot.dao;

import com.itHawk.springBoot.model.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    User selectByUserNameAndPassWord(User record);

    User selectByUserName(User record);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}