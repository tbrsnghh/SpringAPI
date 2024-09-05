package com.example.DemoWithMongoDB;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;

@Document(collection = "students")
public class Student {
    @Id
    private String id;
    private String userId;
    private String email;
    private String name;
    @Field("given_name")
    private String givenName;
    @Field("family_name")
    private String familyName;
    private String nickname;
    //@Field("last_ip")
    private String lastIp;
    //@Field("logins_count")
    private int loginsCount;
    //@Field("created_at")
    private Date createdAt;
    //@Field("updated_at")
    private Date updatedAt;
    //@Field("last_login")
    private Date lastLogin;
    //@Field("email_verified")
    private boolean emailVerified;

    public Student() {}

    public Student(String userId, String email, String name, String givenName, String familyName, String nickname, String lastIp, int loginsCount, Date createdAt, Date updatedAt, Date lastLogin, boolean emailVerified) {
        this.userId = userId;
        this.email = email;
        this.name = name;
        this.givenName = givenName;
        this.familyName = familyName;
        this.nickname = nickname;
        this.lastIp = lastIp;
        this.loginsCount = loginsCount;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.lastLogin = lastLogin;
        this.emailVerified = emailVerified;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGivenName() {
        return givenName;
    }

    public void setGivenName(String givenName) {
        this.givenName = givenName;
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getLastIp() {
        return lastIp;
    }

    public void setLastIp(String lastIp) {
        this.lastIp = lastIp;
    }

    public int getLoginsCount() {
        return loginsCount;
    }

    public void setLoginsCount(int loginsCount) {
        this.loginsCount = loginsCount;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Date getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Date lastLogin) {
        this.lastLogin = lastLogin;
    }

    public boolean isEmailVerified() {
        return emailVerified;
    }

    public void setEmailVerified(boolean emailVerified) {
        this.emailVerified = emailVerified;
    }
}