package com.xunfang.sysuser_conuster.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Table(name="sysuser")//修改名字，因为工具要求表名为“ _  ”
//@Component  //可加可不加   原因：该实体类只表示数据库的表
public class SysUser implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer id;
    private  String account;
    private  String password;
    @Column(name="realname")
    private  String realName;
    @Column(name="roleId")
    private Integer roleId;
    private  String phone;
    private String address;
    private  Integer sex;
    private Date birthday;
    @Column(name="createdUserId")
    private  Integer createdUserId;

    public SysUser(String account, String password, String realName, Integer roleId, String phone, String address, Integer sex, Date birthday, Integer createdUserId) {
        this.account = account;
        this.password = password;
        this.realName = realName;
        this.roleId = roleId;
        this.phone = phone;
        this.address = address;
        this.sex = sex;
        this.birthday = birthday;
        this.createdUserId = createdUserId;
    }
    public SysUser(){

    }

    //生成getter

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Integer getCreatedUserId() {
        return createdUserId;
    }

    public void setCreatedUserId(Integer createdUserId) {
        this.createdUserId = createdUserId;
    }

    @Override
    public String toString() {
        return "SysUser{" +
                "id=" + id +
                ", account='" + account + '\'' +
                ", password='" + password + '\'' +
                ", realName='" + realName + '\'' +
                ", roleId=" + roleId +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", sex=" + sex +
                ", birthday=" + birthday +
                ", createdUserId=" + createdUserId +
                '}';
    }


}
