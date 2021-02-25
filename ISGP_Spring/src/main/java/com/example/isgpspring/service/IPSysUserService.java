package com.example.isgpspring.service;

import com.example.isgpspring.entity.PSysUser;

import java.util.List;

public interface IPSysUserService {
    //返回用户列表
    public List<PSysUser> userList();
    //判断是否存在
    public boolean isExist(String username);
    //用户名检索功能
    public PSysUser findByUsername(String username);
    //新增用户
    public boolean register(PSysUser pSysUser);
    //删除用户
    public void deleteByUserid(Integer userid);
    //修改用户信息
    public void editUser(PSysUser pSysUser);
    //重置用户密码


}
