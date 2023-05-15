package com.example.springbootdemo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AppInfo {
    private String type;
    private String version;
    private String apk;
    private String illustrate;
}
