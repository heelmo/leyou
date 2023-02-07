package com.xunfang.fzdx_springboot.dao;

import com.xunfang.fzdx_springboot.entity.SysUser;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface SysUserxmlDao {
    @Select("select * from sysuser where id =#{id}")
    public SysUser findSysUserById(@Param("id") int id);
    @Select("select * from sysuser ")
    public List<SysUser> findAll();
    @Insert("insert into sysuser(account,password,realName,roleId,phone,address,sex,birthday,createdUserId)VALUES\n" +
            "(#{account},#{password},#{realName},#{roleId},#{phone},#{address},#{sex},#{birthday},#{createdUserId})")
    public  int addSysUser(SysUser sysUser);
    @Delete("delete from sysuser where id=#{id}")
    public int deleteUser(int id);
}
