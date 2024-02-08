package com.myfirstspringproject.myfirstspringproject.service;

import com.myfirstspringproject.myfirstspringproject.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    public User findByUserName(String userName);

}

