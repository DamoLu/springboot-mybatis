package com.my.mapper;

import com.my.model.User;

public interface UserMapper {
    int insert(User record);

    int insertSelective(User record);
}