package com.xunfang.fzdx_springboot.controller;

import com.xunfang.fzdx_springboot.entity.SysUser;
import com.xunfang.fzdx_springboot.service.SysUserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

import java.util.List;

@RestController
@RequestMapping("sysuser")
public class SysUserController {
    @Resource
    private SysUserService sysUserService;
    @RequestMapping("/list")

    /*public int addSysUser(SysUser sysUser){

        System.out.println("添加成功！");
        System.out.println(sysUser);
        return sysUserService.addSysUser(sysUser);
    }*/
    public List<SysUser> show(){
        return sysUserService.findAll();
    }

    @RequestMapping("/id")
    public SysUser show2(){
        return sysUserService.selectSysUserById(1);
    }

    @RequestMapping("/delete")
    public int show3(){
        return sysUserService.deleteUser(9);
    }

    @RequestMapping("/add")
    public int show4(SysUser sysUser){
        return sysUserService.addSysUser(sysUser);
    }
}
