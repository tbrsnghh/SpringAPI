package com.example.dependencyinjection;

import org.springframework.stereotype.Component;

@Component
public class Basic implements GoiDangKy{
    public Basic() {
        System.out.println("Basic constructor called");
    }
    @Override
    public void thongTin() {
        System.out.println("Đây là gói basic");
    }
}
