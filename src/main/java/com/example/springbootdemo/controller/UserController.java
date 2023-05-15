package com.example.springbootdemo.controller;

import com.example.springbootdemo.service.UserService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Resource
    private UserService userService;

    @GetMapping("/user/{id}")
    public String queryUserNameById(@PathVariable("id") Integer id){
        return userService.queryUserNameById(id);
    }
}
