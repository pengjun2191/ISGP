package com.example.demo.service;

import com.example.demo.entity.PSysRoleMenus;
import com.example.demo.pojo.PageInfo;

public interface IPSysRoleMenusService {
    public PageInfo<PSysRoleMenus> getAll();
}
