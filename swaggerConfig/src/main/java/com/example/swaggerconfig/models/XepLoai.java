package com.example.swaggerconfig.models;

public enum XepLoai {
    GIOI("Giỏi"),
    KHA("Khá"),
    TRUNG_BINH("Trung Binh"),
    YEU("Yếu")
    ;
    private String xl;
    XepLoai(String xl) {
        this.xl = xl;
    }
    public String getXl() {
        return xl;
    }
}
