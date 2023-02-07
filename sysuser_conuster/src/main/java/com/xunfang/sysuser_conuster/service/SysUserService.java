package com.xunfang.sysuser_conuster.service;

import com.xunfang.sysuser_conuster.dao.SysUserDao;
import com.xunfang.sysuser_conuster.entity.SysUser;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;

@Service
public class SysUserService {
    @Resource
    private SysUserDao sysUserDao;

    public SysUser findSysUserById(int id){
        return sysUserDao.selectByPrimaryKey(id);
    }
}
