package com.xunfang.sysuser_conuster.controller;

import com.xunfang.sysuser_conuster.entity.SysUser;
import com.xunfang.sysuser_conuster.service.SysUserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("sysuser")
public class SysUserController {
    @Resource
    private SysUserService sysUserService;
    //@RequestMapping:所有请求方式都满足
    //@GetMapping:只能是get请求方式
    @RequestMapping("{id}")
    public SysUser selectSysUserById(@PathVariable("id") int id) {
        return sysUserService.findSysUserById(id);
    }


}
