package com.example.cartype.entity;

public class Car {
    private String name;
    private float guidePrice;
    private float LPrice;
    private CarSeries series;

    public Car(String name, float guidePrice, float LPrice, CarSeries series) {
        this.name = name;
        this.guidePrice = guidePrice;
        this.LPrice = LPrice;
        this.series = series;
    }

    public String getName() {
        return name;
    }

    public float getGuidePrice() {
        return guidePrice;
    }

    public float getLPrice() {
        return LPrice;
    }

    public CarSeries getSeries() {
        return series;
    }
}
