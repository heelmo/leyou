package com.xunfang.controller;

import com.xunfang.service.UploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("image")
public class UploadController {
    @Autowired
    UploadService uploadService;

    @PostMapping
    @ResponseBody
    public String upload(@RequestParam(value = "file",required = false)MultipartFile file){
        String url=uploadService.upload(file);
        return url;
    }
}
