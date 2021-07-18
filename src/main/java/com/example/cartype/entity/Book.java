package com.example.cartype.entity;

public class Book {
    public static int STATE_COMMIT= 0;
    public static int STATE_NOT_DONE = 1;
    public static int STATE_DONE = 2;

    private int id;
    private int user;
    private String city;
    private String name;
    private long telephone;
    private int car;
    private long time=System.currentTimeMillis();
    private int state =STATE_COMMIT;

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", user=" + user +
                ", city='" + city + '\'' +
                ", name='" + name + '\'' +
                ", telephone=" + telephone +
                ", car=" + car +
                ", time=" + time +
                ", state=" + state +
                '}';
    }

    public void setUser(int user) {
        this.user = user;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTelephone(long telephone) {
        this.telephone = telephone;
    }

    public void setCar(int car) {
        this.car = car;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setState(int state) {
        this.state = state;
    }

    public int getId() {
        return id;
    }

    public int getUser() {
        return user;
    }

    public String getCity() {
        return city;
    }

    public String getName() {
        return name;
    }

    public long getTelephone() {
        return telephone;
    }

    public int getCar() {
        return car;
    }

    public long getTime() {
        return time;
    }

    public int getState() {
        return state;
    }
}
