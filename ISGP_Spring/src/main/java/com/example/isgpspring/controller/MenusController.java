package com.example.isgpspring.controller;

import com.example.isgpspring.result.Result;
import com.example.isgpspring.result.ResultFactory;
import com.example.isgpspring.service.imp.PSysMenusServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MenusController {
    //获取当前用户菜单--用于用户菜单展示
    @Autowired
    PSysMenusServiceImp pSysMenusServiceImp;
    @GetMapping("/ISGP/menu")
    public Result menus(){return ResultFactory.ResponseSuccess("");
    }
    //获取所有菜单--用户菜单管理使用
    @CrossOrigin
    @GetMapping("/ISGP/admin/roles/menus")
    public Result allMenuList(){return  ResultFactory.ResponseSuccess(pSysMenusServiceImp.getAll());}
}
