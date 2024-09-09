package com.example.dependencyinjection;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Data
@RequiredArgsConstructor
@Component
public class ThanhVien {
    private String name;
    private final GoiDangKy goiDangKy;
//    // Dùng tight coupling
//    public ThanhVien(){
//        //goiDangKy = new NonMember();
//        System.out.println("Constructor Thanhvien()");
//    }
//    public void setThanhVien(GoiDangKy b){
//        goiDangKy = b;
//    }
//    // Dùng loose coupling
//    @Autowired
//    public ThanhVien(GoiDangKy b) {
//        goiDangKy = b;
//    }

    public void thongtinThanhVien(){
        System.out.println("Name: Nèo");
        goiDangKy.thongTin();
    }
}
