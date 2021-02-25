package com.example.isgpspring.controller;

import ch.qos.logback.classic.Logger;
import com.example.isgpspring.entity.PSysUser;
import com.example.isgpspring.mapper.PSysUserMapper;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
    @Autowired
    PSysUserMapper pSysUserMapper;
    Logger logger= (Logger) LoggerFactory.getLogger("LoginController");
    @GetMapping("/ISGP/login/{userid}")
    public PSysUser getUser(@PathVariable("userid") Integer userId){

        PSysUser iduser=pSysUserMapper.findByUserId(userId);
        //logger.debug("测试代码获取地址："+iduser.getUserAddr());
        return iduser;
    }
}
