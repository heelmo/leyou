package com.xunfang.sysuser_conuster.dao;
/*

//通用工具类，简单的增删改查不用写，继承通用工具类接口
查：查一个，查所有---根据主键---通用工具---不写SQL

*/

import com.xunfang.sysuser_conuster.entity.SysUser;
import tk.mybatis.mapper.common.Mapper;
@org.apache.ibatis.annotations.Mapper
public interface SysUserDao extends Mapper<SysUser> {

}
