package com.example.demo.controller;

import com.example.demo.entity.PSysUser;
import com.example.demo.result.Result;
import com.example.demo.result.ResultFactory;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class UsersController {
    //返回用户列表--用户管理使用
    @GetMapping("/ISGP/admin/user")
    public Result usersList(){return ResultFactory.ResponseSuccess("");
    }
    //新增用户
    @PostMapping("/ISGP/admin/user")
    public Result addUser(@RequestBody @Valid PSysUser requestUser){return ResultFactory.ResponseSuccess("新增用户"+requestUser.getUserName()+"成功");}
    //更新用户状态-是否为有效用户
    @PutMapping("/ISGP/admin/user/status")
    public Result updateUserStatus(@RequestBody @Valid PSysUser requestUser){return ResultFactory.ResponseSuccess("用户"+requestUser.getUserName()+"状态更新成功");}
    //修改用户密码
    @PutMapping("/ISGP/admin/user/password")
    public Result resetPassword(@RequestBody @Valid PSysUser requestUser){return ResultFactory.ResponseSuccess("用户"+requestUser.getUserName()+"密码重置成功");}
    //修改或新增用户信息
    @PutMapping("/ISGP/admin/user")
    public Result editUser(@RequestBody @Valid PSysUser requestUser){return ResultFactory.ResponseSuccess("用户信息更新成功");}
    //删除用户
    @DeleteMapping("/ISGP/admin/user")
    public Result deleteUser(@RequestParam(value="userId",required = true) Integer requestUserId){return ResultFactory.ResponseSuccess("用户删除成功");}
}
