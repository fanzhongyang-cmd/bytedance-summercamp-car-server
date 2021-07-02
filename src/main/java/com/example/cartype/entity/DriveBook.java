package com.example.cartype.entity;

public class DriveBook {
    public static int state_done = 0;
    public static int state_not_done = 1;
    private int user_id;
    private String city;
    private String name;
    private String telephone;
    private long book_time;
    private int state = state_not_done;

    public DriveBook(int user_id, String city, String name, String telephone, long book_time, int isDone) {
        this.user_id = user_id;
        this.city = city;
        this.name = name;
        this.telephone = telephone;
        this.book_time = book_time;
        this.state = isDone;
    }

    public int getUser_id() {
        return user_id;
    }

    public String getCity() {
        return city;
    }

    public String getName() {
        return name;
    }

    public String getTelephone() {
        return telephone;
    }

    public long getBook_time() {
        return book_time;
    }

    public int getState() {
        return state;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public void setBook_time(long book_time) {
        this.book_time = book_time;
    }

    public void setState(int isDone) {
        this.state = isDone;
    }
}
