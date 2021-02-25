package com.example.isgpspring.service.imp;

import com.example.isgpspring.entity.PSysUser;
import com.example.isgpspring.mapper.PSysUserMapper;
import com.example.isgpspring.service.IPSysUserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class PSysUserServiceImp implements IPSysUserService {
    @Autowired
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
