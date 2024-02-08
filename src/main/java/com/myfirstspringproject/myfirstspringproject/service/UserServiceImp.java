package com.myfirstspringproject.myfirstspringproject.service;

import com.myfirstspringproject.myfirstspringproject.dao.UserDao;
import com.myfirstspringproject.myfirstspringproject.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class UserServiceImp implements UserService {
    private UserDao userDao;

    @Autowired
    public  UserServiceImp(UserDao userDao){
        this.userDao = userDao;
    }
    @Override
    public User findByUserName(String userName){
        return userDao.findByUserName(userName);
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Retrieve user details from your data source (e.g., database)
        User user = userDao.findByUserName(username);

        if (user == null) {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }

        List<String> roles = new ArrayList<String>();
        roles.add("ADMIN");
        roles.add("REGULAR");
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(roles.get(0)));
        authorities.add(new SimpleGrantedAuthority(roles.get(1)));
        // Construct UserDetails object with user details
        return new org.springframework.security.core.userdetails.User(
                user.getUserName(),
                user.getPassword(),
                authorities);
    }

 }
