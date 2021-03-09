package com.example.isgpspring.controller;

import com.example.isgpspring.result.Result;
import com.example.isgpspring.result.ResultFactory;
import com.example.isgpspring.service.imp.PSysMenusServiceImp;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "菜单接口")
@RestController
public class MenusController {
    //获取当前用户菜单--用于用户菜单展示
    @Autowired
    PSysMenusServiceImp pSysMenusServiceImp;
    @ApiOperation("权限菜单")
    @GetMapping("/ISGP/menu")
    public Result menus(){return ResultFactory.ResponseSuccess("");
    }
    //获取所有菜单--用户菜单管理使用
    @ApiOperation("所有菜单")
    @CrossOrigin
    @GetMapping("/ISGP/admin/roles/menus")
    public Result allMenuList(){return  ResultFactory.ResponseSuccess(pSysMenusServiceImp.getAll());}
}
