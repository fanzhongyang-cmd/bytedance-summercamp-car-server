package com.example.cartype.entity;

import java.awt.*;
import java.util.List;

public class CarSeries {
    public static int Drivable=10;
    public static int UnDrivable=20;
    public static int ON_SALE=1;
    public static int NOT_ON_SALE=0;
//    public List<Integer> carList;
    private int id;
    private String name;
    private String picture;
    private int state;
    private int minPrice;
    private int maxPrice;
    private int minGuidePrice;
    private int maxGuidePrice;
    private float score;
    private String type;
    private int brand;


    public void setName(String name) {
        this.name = name;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public void setState(int state) {
        this.state = state;
    }

    public void setMinPrice(int minPrice) {
        this.minPrice = minPrice;
    }

    public void setMaxPrice(int maxPrice) {
        this.maxPrice = maxPrice;
    }

    public void setMinGuidePrice(int minGuidePrice) {
        this.minGuidePrice = minGuidePrice;
    }

    public void setMaxGuidePrice(int maxGuidePrice) {
        this.maxGuidePrice = maxGuidePrice;
    }

    public void setScore(float score) {
        this.score = score;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setBrand(int brand) {
        this.brand = brand;
    }

    public int getBrand() {
        return brand;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPicture() {
        return picture;
    }

    public int getState() {
        return state;
    }

    public int getMinPrice() {
        return minPrice;
    }

    public int getMaxPrice() {
        return maxPrice;
    }

    public int getMinGuidePrice() {
        return minGuidePrice;
    }

    public int getMaxGuidePrice() {
        return maxGuidePrice;
    }

    public float getScore() {
        return score;
    }

    public String getType() {
        return type;
    }

    public void setId(int id) {
        this.id = id;
    }
}
