package com.my.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {
    @GetMapping(value = "hello")
    public String hello(Model model) {
        String name = "luqihua";
        model.addAttribute("name", name);
        return "hello";
    }
}
