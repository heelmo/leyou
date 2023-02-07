package com.xunfang.fzdx_springboot.dao;

import com.xunfang.fzdx_springboot.entity.SysUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
@Mapper //
public interface SysUserDao {
    //查询sysuser表的所有数据
    public List<SysUser> findAll();
    //根据id查指定对象
    public SysUser selectSysUserById(@Param("id") int id);
    //增加
    public int addSysUser(SysUser sysUser);
    //修改  修改整个对象，sysUser：新对象
    public int updateSysUser(SysUser sysUser);
    //删除
    public int deleteSysUserById(@Param("id") int id);

}
