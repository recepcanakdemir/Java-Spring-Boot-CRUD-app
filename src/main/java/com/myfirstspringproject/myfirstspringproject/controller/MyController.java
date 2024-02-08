package com.myfirstspringproject.myfirstspringproject.controller;

import com.myfirstspringproject.myfirstspringproject.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("myapp")
public class MyController {
    public MyController(){

    }

    @GetMapping("/hello")
    public String hello(Model theModel){
        return "hello-page";
    }
    @GetMapping("/users")
    public String users(Model theModel){
        return "hello-page";
    }

    /*// login controller
    @GetMapping("/login")
    public String login(){
        return "login";
    }

    // register controller
    @GetMapping("/register")
    public String register(){
        return "register";
    }*/



}
