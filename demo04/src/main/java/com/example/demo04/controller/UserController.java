package com.example.demo04.controller;

import com.example.demo04.mapper.UserMapper;
import com.example.demo04.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @GetMapping("/queryList")
    public List<User> queryUserList(){
        List<User> userList = userMapper.queryUserList();
        for(User user : userList){
            System.out.println(user);
        }
        return userList;
    }

    @GetMapping("/addUser")
    public String addUser(){
        userMapper.addUser(new User(5, "阿毛", "456789", "123123"));
        return "user added";
    }

    @GetMapping("/updateUser")
    public String updateUser(){
        userMapper.updateUser(new User(5, "阿毛", "456789", "123123"));
        return "updated";
    }

    @GetMapping("/deleteUser")
    public String deleteUser(){
        userMapper.deleteUser(5);
        return "deleted";
    }
}
