package com.xunfang.fzdx_springboot.service;

import com.xunfang.fzdx_springboot.entity.SysUser;
import org.apache.ibatis.annotations.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


public interface SysUserService {
    public List<SysUser> findAll();
/*
    //增
    public int addSysUser(SysUser sysUser);
    //查*/
    public SysUser selectSysUserById(int id);

    @Transactional
    int deleteUser(int id);

    @Transactional
    int addSysUser(SysUser sysUser);
}
