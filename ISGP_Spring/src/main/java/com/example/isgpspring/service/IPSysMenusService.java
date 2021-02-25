package com.example.isgpspring.service;


import com.example.isgpspring.entity.PSysMenus;
import com.example.isgpspring.pojo.PageInfo;


public interface IPSysMenusService {
    public PageInfo<PSysMenus> getMenusAll(Integer pageNum, Integer pageSize);
    public PageInfo<PSysMenus> getAll();

}
