package com.example.dependencyinjection;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class DependencyInjectionApplication {

    public static void main(String[] args) {

//        SpringApplication.run(DependencyInjectionApplication.class, args);
        System.out.println("Spring Boot Application Started");
        ApplicationContext context = SpringApplication.run(DependencyInjectionApplication.class, args);
        ThanhVien a = context.getBean(ThanhVien.class);
        a.thongtinThanhVien();
        Meo m = context.getBean(Meo.class);
        m.thongTin();
//        ThanhVien a = new ThanhVien();
//        a.thongtinThanhVien();
//
//        GoiDangKy b = new Basic();
//        ThanhVien c = new ThanhVien();
//        c.setThanhVien(b);
//        c.thongtinThanhVien();
    }

}
