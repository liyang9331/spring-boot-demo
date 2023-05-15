package com.example.springbootdemo.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

@RestController
public class FileUploadController {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd/");

    @PostMapping("/file/upload")
    public String upload(MultipartFile file, HttpServletRequest req) {
        String realPath = "/Users/macosx/Desktop/项目文档/springboot-demo/src/main/resources/uploadFile";
        File folder = new File(realPath);
        String filePath="";
        if (!folder.isDirectory()) {
            folder.mkdirs();
        }
            String oldName = file.getOriginalFilename();
            String newName = UUID.randomUUID().toString() +
                    oldName.substring(oldName.lastIndexOf("."), oldName.length());
            try {
                file.transferTo(new File(folder, newName));
                filePath = req.getScheme() + "://" + req.getServerName() + ":" +
                        req.getServerPort() + "/uploadFile/" + newName;

            } catch (IOException e) {
                e.printStackTrace();
                return "上传失败! ";
            }
        return filePath;
    }
}
