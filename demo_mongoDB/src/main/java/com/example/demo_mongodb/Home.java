package com.example.demo_mongodb;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collation = "homes")
public class Home {
    @Id
    private String id;

    private String title;
    private String describe;
    private String images;
    public Home() {}

    public Home(String id, String title, String describe, String images) {
        super();
        this.id = id;
        this.title = title;
        this.describe = describe;
        this.images = images;
    }


    public String getTitle() {
        return this.title;
    }


    public void setTitle(String title) {
        this.title = title;
    }


    public String getDescribe() {
        return this.describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public String getImages() {
        return this.images;
    }

    public void setImages(String images) {
        this.images = images;
    }
}
