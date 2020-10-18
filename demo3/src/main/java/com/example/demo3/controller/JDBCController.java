package com.example.demo3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class JDBCController {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @RequestMapping("/userList")
    public List<Map<String, Object>> userList(){
        String sql = "select * from user";
        List<Map<String, Object>> list_maps = jdbcTemplate.queryForList(sql);
        return list_maps;
    }

    @RequestMapping("/addUser/{id}")
    public String addUser(@PathVariable("id") int id){
        String sql = "insert into user values (?, 'vs', 'ggg', 'hhh')";
        jdbcTemplate.update(sql, id);
        return "added";
    }

    @RequestMapping("/updateUser/{id}")
    public String updateUser(@PathVariable("id") int id){
        String sql = "update user set name=?, pwd=? where id="+id;

        Object[] objects = new Object[2];
        objects[0] = "小明2";
        objects[1] = "zzzzz";
        jdbcTemplate.update(sql, objects);
        return "updated";
    }

    @RequestMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable("id") int id){
        String sql = "delete from user where id = ?";
        jdbcTemplate.update(sql, id);
        return "deleted";
    }

}
