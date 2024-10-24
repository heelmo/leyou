package com.xunfang.fzdx_springboot.dao;

import com.xunfang.fzdx_springboot.entity.SysUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserDAO {
    //查询sysuser表的所有数据
     List<SysUser> findAll();
    //根据id查指定对象
     SysUser selectSysUserById(@Param("id") int id);
    //增加
     int addSysUser(SysUser sysUser);
    //修改  修改整个对象，sysUser：新对象
     int updateSysUser(SysUser sysUser);
    //删除
     int deleteSysUserById(@Param("id") int id);
}
