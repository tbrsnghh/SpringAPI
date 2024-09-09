package com.example.swaggerconfig.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("${api.prefix}/admin")
public class AdminController {
    @GetMapping("/admin1")
    public String admin1() {
        return "admin1 xin chào";
    }
    @GetMapping("/admin2")
    public String admin2() {
        return "admin2 xin chào";
    }
}
