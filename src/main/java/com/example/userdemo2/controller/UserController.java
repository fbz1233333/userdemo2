package com.example.userdemo2.controller;

import com.example.userdemo2.dao.UserMapper;
import com.example.userdemo2.domaim.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @RequestMapping("/hello")
    public String home(){
        return "hello,spring security";
    }

    @GetMapping("/info")
    public String productInfo(){
        String currentUser="";
        Object principl= SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principl instanceof UserDetails) {
            currentUser=((UserDetails)(UserDetails) principl).getUsername();
        }else {
            currentUser=principl.toString();
        }
        return "some product info,currentUser is:"+currentUser;
    }

    @Autowired
    UserMapper userMapper;

    @GetMapping("getByName/{name}")
    public User get(@PathVariable("name")String name){
        return userMapper.findByUsername(name);
    }
}
