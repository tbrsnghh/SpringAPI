package com.example.swaggerconfig.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("${api.prefix}/layout")
@RequiredArgsConstructor
public class LayoutController {
    @GetMapping("/layout1")
    public String layout() {
        return "layout1";
    }
    @GetMapping("/layout2")
    public String layout2() {
        return "layout2";
    }
}
