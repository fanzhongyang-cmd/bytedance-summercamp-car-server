package com.example.cartype.entity;

public class User {
    public static int CODE_LOGIN_TRUE=200;
    public static int CODE_LOGIN_FALSE=202;
    public static String DEFAULT_ICON="static/defaultIcon.jpg";
    private int id;
    private String name;
    private String signature;
    private String password;
    private String icon;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSignature() {
        return signature;
    }

    public String getPassword() {
        return password;
    }

    public String getIcon() {
        return icon;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public User(int id, String name, String signature, String password, String icon) {
        this.id = id;
        this.name = name;
        this.signature = signature;
        this.password = password;
        this.icon = icon;
    }

    public User(int id) {
        this.id = id;
    }
}
