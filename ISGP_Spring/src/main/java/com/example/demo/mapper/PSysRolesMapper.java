package com.example.demo.mapper;

import com.example.demo.entity.PSysRoles;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PSysRolesMapper {
    public List<PSysRoles> findAll();
    public PSysRoles getRoleById(Integer roleId);
    public Integer insertPSysRole(PSysRoles pSysRoles);
}
