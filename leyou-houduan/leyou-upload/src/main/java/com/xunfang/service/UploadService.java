package com.xunfang.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Service
public class UploadService {
    public String upload(MultipartFile file){
        String filename=file.getOriginalFilename();

        File fileDir=new File("D:/image/");
        if(!fileDir.exists()){
            fileDir.mkdir();
        }
        String filePath="D:/image/"+filename;
        try{
            //保存到本地
            //路径映射
            file.transferTo(new File(filePath));
            return "http://localhost:8081/image/"+filename;//返回的是服务器映射的虚拟目录地址
        }catch (IOException e){
            e.printStackTrace();
        }

        return null;
    }
}


