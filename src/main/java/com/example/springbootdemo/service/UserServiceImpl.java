package com.example.springbootdemo.service;

import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Override
    public String queryUserNameById(Integer id) {
        return "Java后端技术全栈,id="+id.toString();
    }
}
