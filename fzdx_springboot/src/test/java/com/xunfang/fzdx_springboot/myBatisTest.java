package com.xunfang.fzdx_springboot;

import com.xunfang.fzdx_springboot.dao.UserDAO;
import com.xunfang.fzdx_springboot.entity.SysUser;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;

import java.util.List;

public class myBatisTest {
    @Test
    void testSelectAll() {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        UserDAO userDAO = sqlSession.getMapper(UserDAO.class);
        List<SysUser> sysUsers = userDAO.findAll();
        System.out.println(sysUsers);
    }
}
