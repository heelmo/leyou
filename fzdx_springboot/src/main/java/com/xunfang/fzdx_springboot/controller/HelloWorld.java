package com.xunfang.fzdx_springboot.controller;

import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

//springmvc中的控制层
/*
@RestController 是springmvc中的@Controller+@ResponseBody 的整合
@RequestMapping 请求路径的注解
ssm：spring+springMVC+mybatis
spring:管理bean
spring容器：将所有的类都放到容器中通过注解方式来管理bean；默认的是单例模式（只创建一个对象）
@Component :通用注解
springMVC：MVC架构 M：model----实体类---数据库中的表（对象sususer）
v:view---视图---jsp
c:controller---控制层---servlet
entity---实体类---@Component
dao---接口---@Repository
service---实现类---@service
controller---控制类---@controller
*注意:以上几个注解的意义相同，都是将javabean放入spring容器中
*只是进行了分类
@ResponseBody:数据以JSON格式响应回来
@Resource/@Autowired:依赖注入将对象注入到另一个对象中
application.properties/applicattion.yml:两种格式
意义相同配置也相同，只是写法格式不同

* */

@RestController
@RequestMapping("hello")
public class HelloWorld {
    //localhost:8080/hello/show
    @RequestMapping("/show")
    public String show(){
        return "Hello Springboot";
    }
}
