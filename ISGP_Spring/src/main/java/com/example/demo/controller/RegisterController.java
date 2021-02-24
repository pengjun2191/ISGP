package com.example.demo.controller;

import com.example.demo.dao.PSysMenusDao;
import com.example.demo.entity.PSysRoles;
import com.example.demo.mapper.PSysRolesMapper;
import com.example.demo.result.Result;
import com.example.demo.result.ResultFactory;
import com.example.demo.service.imp.PSysMenusServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RegisterController {
    @Autowired
    PSysRolesMapper pSysRolesMapper;
    @Autowired
    PSysMenusDao pSysMenusDao;
    @Autowired
    PSysMenusServiceImp pSysMenusServiceImp;
    @GetMapping("/api/register/roles")
    public List<PSysRoles>  getRole(){return  pSysRolesMapper.findAll();}
    @GetMapping("/api/register/list")
    public Result getMenuList(){
        return ResultFactory.ResponseSuccess(pSysMenusServiceImp.getAll());
    }
    @GetMapping("/api/register")
    public Result getMenus(){
        return ResultFactory.ResponseSuccess(pSysMenusServiceImp.getAll());
    }
    @GetMapping("/api/register/pagesize={pagesize}&pagenum={pagenum}")
    public Result getMenus(@PathVariable("pagenum") Integer pageNum,@PathVariable("pagesize") Integer pageSize){
        return ResultFactory.ResponseSuccess(pSysMenusServiceImp.getMenusAll(pageNum,pageSize));
    }
}
