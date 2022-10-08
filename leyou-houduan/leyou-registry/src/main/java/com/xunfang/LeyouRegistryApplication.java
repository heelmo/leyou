package com.xunfang;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer//告诉springboot启动器这是一个eureka服务器
public class LeyouRegistryApplication {

    public static void main(String[] args){
        SpringApplication.run(LeyouRegistryApplication.class,args);
    }


}
