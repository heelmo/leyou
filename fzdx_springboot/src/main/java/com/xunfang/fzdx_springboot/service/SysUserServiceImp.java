package com.xunfang.fzdx_springboot.service;

import com.xunfang.fzdx_springboot.dao.SysUserDao;
import com.xunfang.fzdx_springboot.dao.SysUserxmlDao;
import com.xunfang.fzdx_springboot.entity.SysUser;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
@Service
public class SysUserServiceImp implements SysUserService{
    @Resource
    private SysUserDao sysUserDao;
    @Resource
    private SysUserxmlDao sysUserxmlDao;
    @Override
    public List<SysUser> findAll(){

        return sysUserDao.findAll();
    }

    @Override
    public SysUser selectSysUserById(int id) {
        return sysUserxmlDao.findSysUserById(id);
    }

    @Transactional
    @Override
    public int deleteUser(int id){
        return sysUserxmlDao.deleteUser(id);
    }
    @Transactional
    @Override
    public int addSysUser(SysUser sysUser) {
        SysUser user=new SysUser("ywt","123","尹文韬",2,"13720226276","武汉",1,new Date(),20);
        return sysUserxmlDao.addSysUser(user);
    }
    /*//增
    public int addSysUser(SysUser sysUser){

        SysUser user =new SysUser("zyn","888","麻子",2,
                "123456","纺大",0,new Date(),18);

        return sysUserDao.addSysUser(user);

    }*/


}
