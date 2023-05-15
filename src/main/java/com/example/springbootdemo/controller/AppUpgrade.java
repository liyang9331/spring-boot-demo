package com.example.springbootdemo.controller;

import com.example.springbootdemo.entity.AppInfo;
import com.example.springbootdemo.entity.Result;
import com.example.springbootdemo.util.MediaTypeUtils;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.nio.file.Path; import java.nio.file.Paths;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
public class AppUpgrade {

    @PostMapping("/user/upgrade")
    public Result appUpgrade(){
        String type = "wgt";
        String version = "1.1.0";
        String apk = "http://192.168.0.118:8080/file/package_v1.1.0.wgt";
        String illustrate = "";

        AppInfo appinfor = new AppInfo(type,version,apk,illustrate);
        Result respone  =  new Result(appinfor);
        return respone;
    }

    @GetMapping("/file/{fileName:.+}")
    public ResponseEntity<Resource> downloadFile(@PathVariable(name = "fileName") String fileName,
                                                 HttpServletRequest request, HttpServletResponse response) throws Exception {
        String uploadDir = "/Users/macosx/Desktop/项目文档/springboot-demo/src/main/resources/uploadFile/";
        // 构造文件路径
        String filePath = uploadDir + fileName;
        Path path = Paths.get(filePath);
        Resource resource = new UrlResource(path.toUri());
        // 如果文件存在并且可读
        if (resource.exists() && resource.isReadable()) {
            MediaType mediaType = MediaTypeUtils.getMediaTypeForFileName(request, fileName);
            return ResponseEntity.ok()
                    .contentType(mediaType)
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
                    .body(resource);
        } else {
            throw new Exception("文件不存在或不可读");
        }
    }
}
