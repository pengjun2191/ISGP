package com.example.demo.service.imp;

import com.example.demo.entity.PSysUser;
import com.example.demo.mapper.PSysUserMapper;
import com.example.demo.service.IPSysUserService;

import java.util.List;

public class PSysUserServiceImp implements IPSysUserService {
    PSysUserMapper pSysUserMapper;
    @Override
    public List<PSysUser> userList(){
        return pSysUserMapper.findAll();
    }
    @Override
    public boolean isExist(String username){
        PSysUser user=pSysUserMapper.findByUsername(username);
        return null !=user;
    }

    @Override
    public PSysUser findByUsername(String username){
        return pSysUserMapper.findByUsername(username);
    }
    @Override
    public boolean register(PSysUser pSysUser){
        return true;
    }
    @Override
    public void deleteByUserid(Integer userid){}
    @Override
    public void editUser(PSysUser pSysUser){}
}
