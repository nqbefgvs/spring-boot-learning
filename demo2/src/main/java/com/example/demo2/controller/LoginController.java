package com.example.demo2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {
    @RequestMapping("/tologin")
//    @ResponseBody
    public String login(@RequestParam("UserName") String username, @RequestParam("Password") String password, Model model, HttpSession session){

        if(!StringUtils.isEmpty(username) && "123456".equals(password)){
            session.setAttribute("loginUser", username);
            return "redirect:/abc.html";
        }else{
            model.addAttribute("msg","用户名或密码错误");
            return "login.html";
        }
    }
//    public String login(){
//        return "OK";
//    }
    @RequestMapping("/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "redirect:/index.html";
    }
}
