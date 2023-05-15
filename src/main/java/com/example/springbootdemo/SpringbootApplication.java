package com.example.springbootdemo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication  //springBoot注解
@MapperScan({"com.example.springbootdemo.dao"})
//启动类
public class SpringbootApplication {

//    main方法
    public static void main(String[] args) {
        SpringApplication.run(SpringbootApplication.class, args);
    }
}
