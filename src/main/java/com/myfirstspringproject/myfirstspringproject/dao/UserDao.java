package com.myfirstspringproject.myfirstspringproject.dao;

import com.myfirstspringproject.myfirstspringproject.entity.User;

public interface UserDao{
    User findByUserName(String userName);

}
