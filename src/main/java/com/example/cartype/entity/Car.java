package com.example.cartype.entity;

public class Car {
    private int id;
    private String name;
    private int guidePrice;
    private int minPrice;
    private int series;
    private int year;

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getYear() {
        return year;
    }

    public void setGuidePrice(int guidePrice) {
        this.guidePrice = guidePrice;
    }

    public void setMinPrice(int minPrice) {
        this.minPrice = minPrice;
    }

    public void setSeries(int series) {
        this.series = series;
    }

    public String getName() {
        return name;
    }

    public int getGuidePrice() {
        return guidePrice;
    }

    public int getMinPrice() {
        return minPrice;
    }

    public int getSeries() {
        return series;
    }

    public void setId(int id) {
        this.id = id;
    }
}
