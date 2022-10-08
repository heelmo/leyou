package com.xunfang;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import tk.mybatis.spring.annotation.MapperScan;


@SpringBootApplication
@EnableDiscoveryClient//告诉他这是一个客户端
@MapperScan("com.xunfang.mapper")
public class LeyouItemSreviceApplication {

    public static void main(String[] args){

        SpringApplication.run(LeyouItemSreviceApplication.class,args);
    }


}
