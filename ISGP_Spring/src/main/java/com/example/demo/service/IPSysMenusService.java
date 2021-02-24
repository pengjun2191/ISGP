package com.example.demo.service;


import com.example.demo.entity.PSysMenus;
import com.example.demo.pojo.PageInfo;


public interface IPSysMenusService {
    public PageInfo<PSysMenus> getMenusAll(Integer pageNum, Integer pageSize);
    public PageInfo<PSysMenus> getAll();

}
