package com.example.isgpspring.service;

import com.example.isgpspring.entity.PSysRoleMenus;
import com.example.isgpspring.pojo.PageInfo;

public interface IPSysRoleMenusService {
    public PageInfo<PSysRoleMenus> getAll();
}
