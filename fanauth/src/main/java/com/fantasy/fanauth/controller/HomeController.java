package com.fantasy.fanauth.controller;

import com.fantasy.fanauth.entity.UserDO;
import com.fantasy.fanauth.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @author: xiangming
 * @date: 2020/03/20 15:18
 * @describetion: 主页
 */
@Controller
@AllArgsConstructor
public class HomeController {

    private final UserService userService;

    @GetMapping({"/", "/index", "/home"})
    public String root(){
        return "index";
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @GetMapping("/register")
    public String register(){
        return "register";
    }

    @PostMapping("/register")
    public String doRegister(UserDO userDO){
        // 此处省略校验逻辑
        userService.insert(userDO);
        return "redirect:register?success";
    }

}
