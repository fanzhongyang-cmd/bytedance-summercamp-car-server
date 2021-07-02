package com.example.cartype.entity;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class CarBrand {
    public List<CarSeries> seriesList;
    private String name;
    private ImageIcon icon;
//    private Image image;

    public CarBrand(List<CarSeries> seriesList, String name, ImageIcon icon) {
        this.seriesList = seriesList;
        this.name = name;
        this.icon = icon;
    }
     public CarSeries AddSeries(CarSeries carSeries){
        this.seriesList.add(carSeries);
        return carSeries;
     }
     public CarSeries RemoveSeries(CarSeries carSeries){
        this.seriesList.remove(carSeries);
        return carSeries;
     }
     public void RemoveSeries(int index){
        this.seriesList.remove(index);
     }

    public List<CarSeries> getSeriesList() {
        return seriesList;
    }

    public String getName() {
        return name;
    }

    public ImageIcon getIcon() {
        return icon;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setIcon(ImageIcon icon) {
        this.icon = icon;
    }
}
