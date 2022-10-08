package com.xunfang;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;


@SpringBootApplication
@EnableDiscoveryClient//告诉他这是一个客户端
@EnableZuulProxy//网关的注解
public class LeyouGatewayApplication {

    public static void main(String[] args){
        SpringApplication.run(LeyouGatewayApplication.class,args);
    }


}
