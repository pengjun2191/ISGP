package com.example.isgpspring.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*@ResponseBody
@Controller*/
@RestController
public class RolesController {
    @RequestMapping("/api")
    public String hello(){
        return "hello world quick";
    }
}
