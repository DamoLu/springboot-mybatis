package com.my.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class UserController {

    @Value("${msg}")
    private String msg;

    @GetMapping("/hi")
    public String hello() {
        return msg;
    }

    @GetMapping("insert")
    public void add() {

    }
}
