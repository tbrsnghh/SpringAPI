package com.example.dependencyinjection;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class NonMember implements GoiDangKy {
    public NonMember() {
        System.out.println("NonMember constructor");
    }
    @Override
    public void thongTin() {
        System.out.println("Đây là gói Non member!");
    }
}
