package com.my.controller;

import com.my.model.User;
import com.my.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user1")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/hi")
    public String hello() {
        return "hello world";
    }

    @GetMapping("insert")
    public void add() {
        User user = new User();
        user.setPassword("root");
        user.setPhone("12356488");
        user.setUserId(1);
        user.setUserName("liming");
    }
}
